/**
 * 
 */
package org.eclipse.iee.web.renderer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.iee.editor.core.pad.result.IResultContainer;

/**
 * @author Toxin
 *
 */
public class DefaultResourceRendererContext extends DefaultHTMLRendererContext implements IResourceRenderContext {

	private HttpServletRequest request;
	
	private HttpServletResponse response;
	
	private File storagePath;
	
	public DefaultResourceRendererContext(String docUrl,
			IResultContainer fResultContainer, File storagePath, 
			HttpServletRequest request, HttpServletResponse response) {
		super(docUrl, fResultContainer);
		this.storagePath = storagePath;
		this.request = request;
		this.response = response;
	}

	@Override
	public HttpServletRequest getRequest() {
		return request;
	}

	@Override
	public HttpServletResponse getResponse() {
		return response;
	}

	@Override
	public InputStream getResourceAsStream(String string) throws IOException {
		return new FileInputStream(new File(storagePath, string));
	}

}
