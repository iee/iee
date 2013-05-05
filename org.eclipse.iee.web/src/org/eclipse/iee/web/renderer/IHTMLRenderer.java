package org.eclipse.iee.web.renderer;

import java.io.IOException;
import java.io.Writer;

import org.eclipse.iee.editor.core.pad.Pad;

public interface IHTMLRenderer<T extends Pad> {

	void renderPad(T pad, Writer writer, IHTMLRendererContext context) throws IOException;
	
	void renderResource(T pad, IResourceRenderContext context) throws IOException;
	
}
