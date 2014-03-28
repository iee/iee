package org.eclipse.iee.export.ui;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.iee.core.document.Document;
import org.eclipse.iee.core.document.DocumentPart;
import org.eclipse.iee.core.document.parser.IDocumentParser;
import org.eclipse.iee.export.IEECloudExporter;
import org.eclipse.iee.export.model.Worksheet;
import org.eclipse.iee.web.renderer.IHTMLRendererManager;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.osgi.framework.Bundle;

import com.google.common.base.Charsets;
import com.google.common.io.ByteStreams;
import com.google.gson.Gson;

public class IEECloudExportWizard extends Wizard implements IExportWizard {

	private IEECloudOptionsPage fOptionsPage;
	private IStructuredSelection fSelection;
	private IDocumentParser parser;
	private IHTMLRendererManager htmlRendererManager;
	
	
	public IEECloudExportWizard() {
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		parser = (IDocumentParser) workbench.getService(IDocumentParser.class);
		htmlRendererManager = (IHTMLRendererManager) workbench.getService(IHTMLRendererManager.class);
		setWindowTitle("Export to IEECloud");
		setNeedsProgressMonitor(true);
		fSelection = selection;
	}

	@Override
	public boolean performFinish() {
		final String destinationFile = fOptionsPage.getDestinationValue();
		List<IResource> selectedResources = fOptionsPage.getSelectedResources();
		IFile output = null;
		for (IResource resource : selectedResources) {
			if ("java".equals(resource.getFileExtension())) {
				output = (IFile) resource;
			}
		}
		if (output == null) {
			return false;
		}
		final IFile fo = output;
		
		try {
			getContainer().run(true, true, new IRunnableWithProgress(){

				@Override
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {
					
					DocumentPart parsedDocument;
					try (InputStream is = fo.getContents()) {
						parsedDocument = parser.parseDocument(is);
					} catch (IOException | CoreException e1) {
						throw new InvocationTargetException(e1);
					}
					
					try (FileOutputStream fos = new FileOutputStream(destinationFile);
							ZipOutputStream zos = new ZipOutputStream(fos)) {
						
						String manifest = "Manifest-Version: 1.0\r\n" + 
								"Bundle-Version: 2.0.0.v2012091404418\r\n" + 
								"name: com.ieecloud.ws.settlement.rigid.stamp\r\n" + 
								"description: Settlement of rigid stamp\r\n" + 
								"type: fixed";
						
						ZipEntry manifestEntry = new ZipEntry("META-INF.MF");
						zos.putNextEntry(manifestEntry);
						zos.write(manifest.getBytes());
			    		zos.closeEntry();
			    		Bundle bundle = Platform.getBundle("org.eclipse.iee.export.ui");
			    		Enumeration<URL> entries = bundle.findEntries("/META-INF/resources/zip", null, true);
			    		while (entries.hasMoreElements()){
			    			URL url = entries.nextElement();
			    			String name = url.getPath().replace("/META-INF/resources/zip", "");
							if (!name.endsWith("/")) {
				    			try (InputStream is = url.openStream()) {
				    				ZipEntry entry = new ZipEntry(name);
				    				zos.putNextEntry(entry);
				    				ByteStreams.copy(is, zos);
				    				zos.closeEntry();
				    			}
			    			}
		    			}
			    		
			    		ZipEntry viewEntry = new ZipEntry("schema/view.json");
			    		zos.putNextEntry(viewEntry);
			    		Worksheet export = new IEECloudExporter(htmlRendererManager).export(new Document(null, null, parsedDocument));
			    		OutputStreamWriter writer = new OutputStreamWriter(zos, Charsets.UTF_8);
			    		new Gson().toJson(export, writer);
			    		writer.flush();
			    		zos.closeEntry();
					} catch (IOException e) {
						e.printStackTrace();
						throw new InvocationTargetException(e);
					} 
				}});
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException ex) {
			if (ex.getTargetException() != null) {
				ex.printStackTrace();
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void addPages() {
		super.addPages();
		if (fOptionsPage == null) {
			fOptionsPage = new IEECloudOptionsPage(fSelection);
		}
		addPage(fOptionsPage);
	}

}
