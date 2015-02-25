package org.eclipse.iee.export.ui;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.iee.core.document.parser.IDocumentParser;
import org.eclipse.iee.core.store.IDocumentStore;
import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.web.renderer.IHTMLRendererManager;
import org.eclipse.iee.web.ui.store.DevDocumentStore;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IExportWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.statushandlers.StatusManager;

public class IEECloudExportWizard extends Wizard implements IExportWizard {

	public static final String IEE_CLOUD_EXPORT_WIZARD = "IEECloudExportWizard";
	private IEECloudOptionsPage fOptionsPage;
	private IStructuredSelection fSelection;
	private IDocumentParser parser;
	private IHTMLRendererManager htmlRendererManager;
	private IDocumentStore documentStore;
	private StatusManager fStatusManager;
	
	public IEECloudExportWizard() {
		IDialogSettings workbenchSettings = IeeEditorPlugin.getDefault().getDialogSettings();
        IDialogSettings section = workbenchSettings
                .getSection(IEE_CLOUD_EXPORT_WIZARD);//$NON-NLS-1$
        if (section == null) {
			section = workbenchSettings.addNewSection(IEE_CLOUD_EXPORT_WIZARD);//$NON-NLS-1$
		}
        setDialogSettings(section);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		fStatusManager = StatusManager.getManager();
		parser = (IDocumentParser) workbench.getService(IDocumentParser.class);
		htmlRendererManager = (IHTMLRendererManager) workbench.getService(IHTMLRendererManager.class);
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		documentStore = new DevDocumentStore(workspace.getRoot().getLocation().toFile(), parser);
		setWindowTitle("Export to IEECloud");
		setNeedsProgressMonitor(true);
		fSelection = getValidSelection(workbench);
	}
	
	protected IStructuredSelection getValidSelection(IWorkbench workbench) {
		ISelection currentSelection= workbench.getActiveWorkbenchWindow().getSelectionService().getSelection();
		if (currentSelection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection= (IStructuredSelection) currentSelection;
			List<Object> selectedElements= new ArrayList<Object>(structuredSelection.size());
			Iterator<?> iter= structuredSelection.iterator();
			while (iter.hasNext()) {
				Object selectedElement= iter.next();
				if (selectedElement instanceof IProject) {
					selectedElements.add(selectedElement);
				} else if (selectedElement instanceof IResource) {
					selectedElements.add(selectedElement);
				} else if (selectedElement instanceof IJavaElement) {
					selectedElements.add(((IJavaElement) selectedElement).getResource());
				}
			}
			return new StructuredSelection(selectedElements);
		} else
			return StructuredSelection.EMPTY;
	}

	@Override
	public boolean performFinish() {
		updateSettings(getDialogSettings());
		final String destinationFile = fOptionsPage.getDestinationValue();
		final List<IProject> selectedResources = fOptionsPage.getSelectedProjects();
		final boolean uploadChecked = fOptionsPage.isUploadChecked();
		final String password = fOptionsPage.getPassword();
		final String username = fOptionsPage.getUsername();
		final String urlStr = fOptionsPage.getUrl();
		try {
			getContainer().run(true, true, new IeeExportOperation(parser, htmlRendererManager, documentStore, destinationFile, password,
					uploadChecked, username, urlStr, selectedResources));
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException ex) {
			Throwable e = ex.getTargetException() != null ? ex.getTargetException() : ex;
			if (e instanceof ExecutionException) {
				e = e.getCause();
			}
			IStatus status = new Status(Status.ERROR, "org.eclipse.iee.export.ui", "Export error", e);
			fStatusManager.handle(status, StatusManager.SHOW | StatusManager.LOG);
			return false;
		}
		
		return true;
	}
	
	private void updateSettings(IDialogSettings dialogSettings) {
		fOptionsPage.updateSettings(dialogSettings);
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
