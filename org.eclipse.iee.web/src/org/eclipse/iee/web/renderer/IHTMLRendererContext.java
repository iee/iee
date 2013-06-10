package org.eclipse.iee.web.renderer;

import java.util.Map;

import org.eclipse.iee.editor.core.pad.result.IParameterProvider;
import org.eclipse.iee.editor.core.pad.result.IResultContainer;

public interface IHTMLRendererContext {

	public String createResourceURL(String padId, Map<String, String> params);
	
	public String createURL(Map<String, String> params);
	
	public IResultContainer getResultContainer();
	
	public IParameterProvider getParameterProvider();
	
	public boolean isEditMode();
	
}
