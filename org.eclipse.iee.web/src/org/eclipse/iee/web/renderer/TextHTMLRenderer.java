/**
 * 
 */
package org.eclipse.iee.web.renderer;

import java.io.IOException;
import java.io.Writer;

import org.eclipse.iee.pad.text.TextPart;
import org.eclipse.iee.pad.text.elements.Node;
import org.eclipse.iee.pad.text.elements.NodeVisitor;
import org.eclipse.iee.pad.text.elements.Span;
import org.eclipse.iee.pad.text.elements.TextNode;
import org.osgi.service.component.annotations.Component;

import com.google.common.base.Throwables;

/**
 * @author Toxin
 *
 */
@Component
public class TextHTMLRenderer implements IHTMLRenderer<TextPart> {

	@Override
	public void renderPad(TextPart pad,
			IHTMLRendererContext context) throws IOException {
		final Writer writer = context.getWriter();
		writer.append("<span class='pad pad-text' style='display:inline-block;'>");
		pad.getRoot().traverse(new NodeVisitor() {
			@Override
			public void head(Node node, int depth) {
				try {
					if (node instanceof Span) {
						writer.append("<span style='");
						Span span = (Span) node;
						if (span.isBold().isPresent()) {
							writer.append("font-weight:bold;");
						}
						if (span.isItalic().isPresent()) {
							writer.append("font-style:italic;");
						}
						if (span.getFont().isPresent() && span.getFont().get().length() > 0) {
							writer.append("font-family:").append(span.getFont().get()).append(';');
						}
						if (span.getFontSize().isPresent()) {
							writer.append("font-size:").append(String.valueOf(span.getFontSize().get())).append(';');
						}
						if (span.getFgColor().isPresent()) {
							writer.append("color:#").append(Integer.toHexString(span.getFgColor().get().getRGB())).append(';');
						}
						if (span.getBgColor().isPresent()) {
							writer.append("background-color:#").append(Integer.toHexString(span.getBgColor().get().getRGB())).append(';');
						}
						writer.append("'>");
					} else if (node instanceof TextNode) {
						writer.append(((TextNode) node).getText());
					}
				} catch (IOException e) {
					throw Throwables.propagate(e);
				}
			}
			
			@Override
			public void tail(Node node, int depth) {
				try {
					if (node instanceof Span) {
						writer.append("</span>");
					}
				} catch (IOException e) {
					throw Throwables.propagate(e);
				}
			}
		});
		writer.append("</span>");
	}

	@Override
	public void renderResource(TextPart pad, String resourceId, IResourceRenderContext context)
			throws IOException {
	}

}
