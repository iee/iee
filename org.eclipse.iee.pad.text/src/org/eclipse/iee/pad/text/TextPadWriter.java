package org.eclipse.iee.pad.text;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.iee.core.document.writer.IPadWriter;
import org.eclipse.iee.pad.text.elements.Node;
import org.eclipse.iee.pad.text.elements.NodeVisitor;
import org.eclipse.iee.pad.text.elements.Span;
import org.eclipse.iee.pad.text.elements.TextNode;
import org.osgi.service.component.annotations.Component;

/**
 * {@link IPadWriter} implementation. Writes instance of text pad.
 */
@Component
public class TextPadWriter implements IPadWriter<TextPart> {

	@Override
	public String getType() {
		return "Text";
	}

	@Override
	public String getValue(TextPart part) {
		Node root = part.getRoot();
		final StringWriter sw = new StringWriter();
		for (Node node : root.getChildren()) {
			node.traverse(new NodeVisitor() {
				@Override
				public void head(Node node, int depth) {
					if (node instanceof Span) {
						sw.append("<span style='");
						Span span = (Span) node;
						if (span.isBold().isPresent()) {
							sw.append("font-weight:bold;");
						}
						if (span.isItalic().isPresent()) {
							sw.append("font-style:italic;");
						}
						if (span.getFont().isPresent() && span.getFont().get().length() > 0) {
							sw.append("font-family:").append(span.getFont().get()).append(';');
						}
						if (span.getFontSize().isPresent()) {
							sw.append("font-size:").append(String.valueOf(span.getFontSize().get())).append(';');
						}
						if (span.getFgColor().isPresent()) {
							String hexColor = Integer.toHexString(span.getFgColor().get().getRGB());
							hexColor = hexColor.substring(2, hexColor.length());
							sw.append("color:#").append(hexColor).append(';');
						}
						if (span.getBgColor().isPresent()) {
							String hexColor = Integer.toHexString(span.getBgColor().get().getRGB());
							hexColor = hexColor.substring(2, hexColor.length());
							sw.append("background-color:#").append(hexColor).append(';');
						}
						sw.append("'>");
					} else if (node instanceof TextNode) {
						sw.append(((TextNode) node).getText());
					}
				}
				
				@Override
				public void tail(Node node, int depth) {
					if (node instanceof Span) {
						sw.append("</span>");
					}
				}
			});
		}
		return sw.toString();
	}

	@Override
	public Map<String, String> getParams(TextPart part) {
		return new HashMap<>();
	}
	
}