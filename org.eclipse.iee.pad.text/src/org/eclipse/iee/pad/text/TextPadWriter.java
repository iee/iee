package org.eclipse.iee.pad.text;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.iee.core.document.text.Document;
import org.eclipse.iee.core.document.text.INode;
import org.eclipse.iee.core.document.text.NodeVisitor;
import org.eclipse.iee.core.document.text.Span;
import org.eclipse.iee.core.document.text.Text;
import org.eclipse.iee.core.document.text.TextStyle;
import org.eclipse.iee.core.document.writer.IPadWriter;
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
		Document root = part.getRoot();
		final StringWriter sw = new StringWriter();
		root.traverse(new NodeVisitor() {
			@Override
			public void head(INode node) {
				if (node instanceof Span) {
					sw.append("<span style='");
					Span span = (Span) node;
					TextStyle style = span.getStyle();
					if (style.isBold().or(Boolean.FALSE)) {
						sw.append("font-weight:bold;");
					}
					if (style.isItalic().or(Boolean.FALSE)) {
						sw.append("font-style:italic;");
					}
					if (style.getFont().isPresent() && style.getFont().get().length() > 0) {
						sw.append("font-family:").append(style.getFont().get()).append(';');
					}
					if (style.getFontSize().isPresent()) {
						sw.append("font-size:").append(String.valueOf(style.getFontSize().get())).append(';');
					}
					if (style.getFgColor().isPresent()) {
						String hexColor = Integer.toHexString(style.getFgColor().get().getRGB());
						hexColor = hexColor.substring(2, hexColor.length());
						sw.append("color:#").append(hexColor).append(';');
					}
					if (style.getBgColor().isPresent()) {
						String hexColor = Integer.toHexString(style.getBgColor().get().getRGB());
						hexColor = hexColor.substring(2, hexColor.length());
						sw.append("background-color:#").append(hexColor).append(';');
					}
					sw.append("'>");
				} else if (node instanceof Text) {
					sw.append(((Text) node).getText());
				}
			}
			
			@Override
			public void tail(INode node) {
				if (node instanceof Span) {
					sw.append("</span>");
				}
			}
		});
		return sw.toString();
	}

	@Override
	public Map<String, String> getParams(TextPart part) {
		return new HashMap<>();
	}
	
}