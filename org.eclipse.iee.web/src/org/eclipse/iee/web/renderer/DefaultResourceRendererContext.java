/**
 * 
 */
package org.eclipse.iee.web.renderer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.iee.editor.core.pad.result.IParameterProvider;
import org.eclipse.iee.editor.core.pad.result.IResultContainer;
import org.eclipse.iee.web.store.IDocumentStore;

/**
 * @author Toxin
 *
 */
public class DefaultResourceRendererContext extends DefaultHTMLRendererContext implements IResourceRenderContext {

	private HttpServletRequest request;
	
	private HttpServletResponse response;
	
	private IDocumentStore documentStore;
	
	private String bundle;
	
	private String document;
	
	public DefaultResourceRendererContext(String docUrl, Map<String, String> params,
			IResultContainer fResultContainer, boolean isEditMode, IDocumentStore documentStore, 
			HttpServletRequest request, HttpServletResponse response, String bundle, String document, IParameterProvider parameterProvider) {
		super(docUrl, params, fResultContainer, isEditMode, parameterProvider);
		this.request = request;
		this.response = response;
		this.documentStore = documentStore;
		this.bundle = bundle;
		this.document = document;
	}

	@Override
	public HttpServletRequest getRequest() {
		return request;
	}

	@Override
	public HttpServletResponse getResponse() {
		return response;
	}

	@Override
	public InputStream getResourceAsStream(String string) throws IOException {
		return documentStore.getResourceAsStream(bundle, document, string);
	}

}
