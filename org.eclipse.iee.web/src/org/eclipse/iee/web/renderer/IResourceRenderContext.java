/**
 * 
 */
package org.eclipse.iee.web.renderer;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author Toxin
 *
 */
public interface IResourceRenderContext extends IHTMLRendererContext {

	void setContentType(String string);

	OutputStream getOutputStream() throws IOException;
	
}
