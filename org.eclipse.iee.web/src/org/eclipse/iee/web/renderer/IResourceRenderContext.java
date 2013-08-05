/**
 * 
 */
package org.eclipse.iee.web.renderer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Toxin
 *
 */
public interface IResourceRenderContext extends IHTMLRendererContext {

	void setContentType(String string);

	OutputStream getOutputStream() throws IOException;
	
}
