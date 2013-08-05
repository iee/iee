/**
 * 
 */
package org.eclipse.iee.web.renderer;

import java.io.IOException;
import java.io.Writer;

import org.eclipse.iee.sample.text.pad.TextPad;

/**
 * @author Toxin
 *
 */
public class TextHTMLRenderer implements IHTMLRenderer<TextPad> {

	@Override
	public void renderPad(TextPad pad,
			IHTMLRendererContext context) throws IOException {
		Writer writer = context.getWriter();
		writer.append("<span class='pad pad-text' style='display:inline-block;'>").append(pad.getText()).append("</span>");
	}

	@Override
	public void renderResource(TextPad pad, String resourceId, IResourceRenderContext context)
			throws IOException {
	}

}
