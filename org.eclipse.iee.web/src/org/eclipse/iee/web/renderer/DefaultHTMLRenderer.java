/**
 * 
 */
package org.eclipse.iee.web.renderer;

import java.io.IOException;
import java.io.Writer;

import org.eclipse.iee.editor.core.pad.Pad;

/**
 * @author Toxin
 *
 */
public class DefaultHTMLRenderer implements IHTMLRenderer<Pad> {

	@Override
	public void renderPad(Pad pad, Writer writer, IHTMLRendererContext context) throws IOException {
		writer.write("Unknown pad here");
	}

	@Override
	public void renderResource(Pad pad, IResourceRenderContext context)
			throws IOException {
	}

}
