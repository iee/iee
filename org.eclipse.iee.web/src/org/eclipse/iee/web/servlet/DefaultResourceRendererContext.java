/**
 * 
 */
package org.eclipse.iee.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.iee.core.IParameterProvider;
import org.eclipse.iee.core.IResultContainer;
import org.eclipse.iee.core.store.IDocumentStore;
import org.eclipse.iee.web.renderer.IResourceRenderContext;

/**
 * @author Toxin
 *
 */
public class DefaultResourceRendererContext extends DefaultHTMLRendererContext implements IResourceRenderContext {


	public DefaultResourceRendererContext(String evaluationId, String docUrl, Map<String, String> params,
			IResultContainer fResultContainer, boolean isEditMode, IDocumentStore documentStore, 
			HttpServletRequest request, HttpServletResponse response, String bundle, String document, IParameterProvider parameterProvider) {
		super(evaluationId, request, response, docUrl, params, documentStore, bundle, document, fResultContainer, isEditMode, parameterProvider);
		this.request = request;
		this.response = response;
	}

	@Override
	public void setContentType(String string) {
		response.setContentType(string);
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		return response.getOutputStream();
	}

}
