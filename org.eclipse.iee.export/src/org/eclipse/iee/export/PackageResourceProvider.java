package org.eclipse.iee.export;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Map;

import org.eclipse.iee.core.IParameterProvider;
import org.eclipse.iee.core.IResultContainer;
import org.eclipse.iee.core.NullResultContainer;
import org.eclipse.iee.core.document.Document;
import org.eclipse.iee.core.document.DocumentPart;
import org.eclipse.iee.core.store.IDocumentStore;
import org.eclipse.iee.web.renderer.IHTMLRenderer;
import org.eclipse.iee.web.renderer.IHTMLRendererManager;
import org.eclipse.iee.web.renderer.IResourceRenderContext;

public class PackageResourceProvider {

	private IHTMLRendererManager manager;
	
	private String resourceId;
	
	private DocumentPart documentPart;

	private IDocumentStore documentStore;
	
	public PackageResourceProvider(IHTMLRendererManager manager, IDocumentStore documentStore,
			String resourceId, DocumentPart documentPart) {
		this.manager = manager;
		this.resourceId = resourceId;
		this.documentStore = documentStore;
		this.documentPart = documentPart;
	}

	public void writeToStream(final OutputStream os) throws IOException {
		IHTMLRenderer<DocumentPart> renderer = manager.getPadHTMLRenderer(documentPart);
		renderer.renderResource(documentPart, resourceId, new IResourceRenderContext() {
			
			@Override
			public boolean isEditMode() {
				return false;
			}
			
			@Override
			public Writer getWriter() throws IOException {
				return null;
			}
			
			@Override
			public IResultContainer getResultContainer() {
				return new NullResultContainer();
			}
			
			@Override
			public InputStream getResourceAsStream(String string) throws IOException {
				Document document = documentPart.getDocument();
				InputStream stream;
				try {
					stream = documentStore.getResourceAsStream(document.getBundle(), document.getName(), string);
				} catch (FileNotFoundException e) {
					stream = new ByteArrayInputStream(new byte[]{});
				}
				return stream;
			}
			
			@Override
			public IParameterProvider getParameterProvider() {
				return null;
			}
			
			@Override
			public String createURL(Map<String, String> params) {
				return null;
			}
			
			@Override
			public String createResourceURL(String padId, String resourceId,
					Map<String, String> params) {
				return null;
			}
			
			@Override
			public void setContentType(String string) {
				
			}
			
			@Override
			public OutputStream getOutputStream() throws IOException {
				return os;
			}
		});
		
		
	}

}
