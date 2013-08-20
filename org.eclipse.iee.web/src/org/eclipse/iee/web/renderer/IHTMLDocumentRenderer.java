package org.eclipse.iee.web.renderer;

import java.io.IOException;
import java.io.Writer;

import org.eclipse.iee.web.document.Document;

public interface IHTMLDocumentRenderer {
	
	void renderHTMLHead(Document document, IHTMLRendererContext context) throws IOException;
	
	void renderHTMLBody(Document document, IHTMLRendererContext context) throws IOException;
	
	void renderResource(Document document, String padId, String resourceId, IResourceRenderContext context) throws IOException;
	
}
