package org.eclipse.iee.web.renderer;

import java.util.Map;

import org.eclipse.iee.editor.core.pad.result.IResultContainer;

public interface IHTMLRendererContext {

	public String createResourceURL(String padId, Map<String, String> params);
	
	public IResultContainer getResultContainer();
	
}
