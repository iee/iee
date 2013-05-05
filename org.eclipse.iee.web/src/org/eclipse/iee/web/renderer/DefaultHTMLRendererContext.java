package org.eclipse.iee.web.renderer;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.iee.editor.core.pad.result.IResultContainer;

public class DefaultHTMLRendererContext implements IHTMLRendererContext {

	private IResultContainer fResultContainer;

	private String docUrl;
	
	public DefaultHTMLRendererContext(String docUrl, IResultContainer fResultContainer) {
		super();
		this.fResultContainer = fResultContainer;
		this.docUrl = docUrl;
	}

	@Override
	public String createResourceURL(String padId, Map<String, String> params) {
		StringBuilder sb = new StringBuilder(docUrl);
		sb.append("/").append(padId);
		boolean first = true;
		for (Entry<String, String> entry : params.entrySet()) {
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

	
	
}
