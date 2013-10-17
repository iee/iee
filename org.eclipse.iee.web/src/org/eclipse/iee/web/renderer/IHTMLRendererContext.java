package org.eclipse.iee.web.renderer;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Map;

import org.eclipse.iee.core.IParameterProvider;
import org.eclipse.iee.core.IResultContainer;

public interface IHTMLRendererContext {

	public String createResourceURL(String padId, String resourceId, Map<String, String> params);
	
	public String createURL(Map<String, String> params);
	
	public IResultContainer getResultContainer();
	
	public IParameterProvider getParameterProvider();
	
	public boolean isEditMode();

	InputStream getResourceAsStream(String string) throws IOException;

	public Writer getWriter() throws IOException;
	
}
