/**
 * 
 */
package org.eclipse.iee.web.renderer;

import java.io.IOException;
import java.io.Writer;

import org.eclipse.iee.pad.text.TextPart;

/**
 * @author Toxin
 *
 */
public class TextHTMLRenderer implements IHTMLRenderer<TextPart> {

	@Override
	public void renderPad(TextPart pad,
			IHTMLRendererContext context) throws IOException {
		Writer writer = context.getWriter();
		writer.append("<span class='pad pad-text' style='display:inline-block;'>").append(pad.getText()).append("</span>");
	}

	@Override
	public void renderResource(TextPart pad, String resourceId, IResourceRenderContext context)
			throws IOException {
	}

}
