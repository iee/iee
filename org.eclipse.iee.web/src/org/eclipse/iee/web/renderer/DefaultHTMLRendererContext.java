package org.eclipse.iee.web.renderer;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.iee.document.api.IParameterProvider;
import org.eclipse.iee.document.api.IResultContainer;

public class DefaultHTMLRendererContext implements IHTMLRendererContext {

	private IResultContainer fResultContainer;

	private String docUrl;
	
	private Map<String, String> params;
	
	private boolean isEditMode;
	
	private IParameterProvider parameterProvider;
	
	public DefaultHTMLRendererContext(String docUrl, Map<String, String> params, IResultContainer fResultContainer, boolean isEditMode,  IParameterProvider parameterProvider) {
		super();
		this.fResultContainer = fResultContainer;
		this.docUrl = docUrl;
		this.params = params;
		this.isEditMode = isEditMode;
		this.parameterProvider = parameterProvider;
	}

	@Override
	public String createResourceURL(String padId, Map<String, String> params) {
		Map<String, String> mergedParams = new HashMap<String, String>(this.params);
		mergedParams.putAll(params);
		StringBuilder sb = new StringBuilder(docUrl);
		sb.append("/").append(padId);
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
	
}
