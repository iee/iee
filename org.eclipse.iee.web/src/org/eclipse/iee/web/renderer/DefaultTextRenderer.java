/**
 * 
 */
package org.eclipse.iee.web.renderer;

import java.io.IOException;
import java.io.Writer;

import org.eclipse.iee.core.document.TextDocumentPart;
import org.osgi.service.component.annotations.Component;

import com.google.common.html.HtmlEscapers;

/**
 * @author aefimchuk
 *
 */
@Component
public class DefaultTextRenderer implements IHTMLRenderer<TextDocumentPart> {

	@Override
	public void renderPad(TextDocumentPart documentPart, IHTMLRendererContext context)
			throws IOException {
		Writer writer = context.getWriter();
		String type = documentPart.getType();
		if ("Ws".equals(type)) {
			writer.write(documentPart.getText());
		} else {
			writer.append("<span class = '").append(type.toLowerCase()).append("' >").append(HtmlEscapers.htmlEscaper().escape(documentPart.getText())).append("</span>");
		}
	}

	@Override
	public void renderResource(TextDocumentPart pad, String resourceId,
			IResourceRenderContext context) throws IOException {
	}

}
