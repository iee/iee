package org.eclipse.iee.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.iee.core.IParameterProvider;
import org.eclipse.iee.core.IResultContainer;
import org.eclipse.iee.core.store.IDocumentStore;
import org.eclipse.iee.web.renderer.IHTMLRendererContext;

public class DefaultHTMLRendererContext implements IHTMLRendererContext {

	private String evaluationId;
	
	private IResultContainer fResultContainer;

	private String docUrl;
	
	private Map<String, String> params;
	
	private boolean isEditMode;
	
	private IParameterProvider parameterProvider;
	
	private String bundle;
	
	private String document;
	
	private IDocumentStore documentStore;
	
	protected HttpServletRequest request;
	
	protected HttpServletResponse response;
	
	public DefaultHTMLRendererContext(
			String evaluationId,
			HttpServletRequest request, 
			HttpServletResponse response, 
			String docUrl, 
			Map<String, String> params,
			IDocumentStore documentStore,
			String bundle,
			String document,
			IResultContainer fResultContainer, 
			boolean isEditMode,  
			IParameterProvider parameterProvider) {
		super();
		this.evaluationId = evaluationId;
		this.request = request;
		this.response = response;
		this.fResultContainer = fResultContainer;
		this.docUrl = docUrl;
		this.params = params;
		this.isEditMode = isEditMode;
		this.parameterProvider = parameterProvider;
		this.documentStore = documentStore;
		this.bundle = bundle;
		this.document = document;
	}

	public String getEvaluationId() {
		return evaluationId;
	}
	
	@Override
	public String createResourceURL(String padId, String resourceId, Map<String, String> params) {
		Map<String, String> mergedParams = new HashMap<String, String>(this.params);
		mergedParams.putAll(params);
		mergedParams.put("evalId", getEvaluationId());
		StringBuilder sb = new StringBuilder(docUrl);
		sb.append("/").append(padId);
		sb.append("/").append(resourceId);
		boolean first = true;
		for (Entry<String, String> entry : mergedParams.entrySet()) {
			if (first) {
				sb.append('?');
				first = false;
			} else {
				sb.append('&');
			}
			sb.append(entry.getKey());
			sb.append('=');
			sb.append(entry.getValue());
		}
		return sb.toString();
	}
	
	@Override
	public String createURL(Map<String, String> params) {
		Map<String, String> mergedParams = new HashMap<String, String>(this.params);
		mergedParams.putAll(params);
		StringBuilder sb = new StringBuilder(docUrl);
		boolean first = true;
		for (Entry<String, String> entry : mergedParams.entrySet()) {
			if (first) {
				sb.append('?');
				first = false;
			} else {
				sb.append('&');
			}
			sb.append(entry.getKey());
			sb.append('=');
			sb.append(entry.getValue());
		}
		return sb.toString();
	}

	@Override
	public IResultContainer getResultContainer() {
		return fResultContainer;
	}

	@Override
	public boolean isEditMode() {
		return isEditMode;
	}

	@Override
	public IParameterProvider getParameterProvider() {
		return parameterProvider;
	}
	
	@Override
	public InputStream getResourceAsStream(String string) throws IOException {
		return documentStore.getResourceAsStream(bundle, document, string);
	}
	
	@Override
	public Writer getWriter() throws IOException {
		return response.getWriter();
	}
	
}
