package org.eclipse.iee.web.renderer;

import java.io.IOException;

import org.eclipse.iee.core.document.DocumentPart;

public interface IHTMLRenderer<T extends DocumentPart> {

	void renderPad(T pad, IHTMLRendererContext context) throws IOException;
	
	void renderResource(T pad, String resourceId, IResourceRenderContext context) throws IOException;
	
}
