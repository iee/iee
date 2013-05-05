/**
 * 
 */
package org.eclipse.iee.web.renderer;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Toxin
 *
 */
public interface IResourceRenderContext extends IHTMLRendererContext {

	HttpServletRequest getRequest();
	
	HttpServletResponse getResponse();

	InputStream getResourceAsStream(String string) throws IOException;
	
}
