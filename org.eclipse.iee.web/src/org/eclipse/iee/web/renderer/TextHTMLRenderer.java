/**
 * 
 */
package org.eclipse.iee.web.renderer;

import java.io.IOException;
import java.io.Writer;

import org.eclipse.iee.core.document.text.INode;
import org.eclipse.iee.core.document.text.NodeVisitor;
import org.eclipse.iee.core.document.text.Span;
import org.eclipse.iee.core.document.text.Text;
import org.eclipse.iee.core.document.text.TextStyle;
import org.eclipse.iee.pad.text.TextPart;
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
			public void head(INode node) {
				try {
					if (node instanceof Span) {
						writer.append("<span style='");
						Span span = (Span) node;
						TextStyle style = span.getStyle();
						if (style.isBold().isPresent()) {
							writer.append("font-weight:bold;");
						}
						if (style.isItalic().isPresent()) {
							writer.append("font-style:italic;");
						}
						if (style.getFont().isPresent() && style.getFont().get().length() > 0) {
							writer.append("font-family:").append(style.getFont().get()).append(';');
						}
						if (style.getFontSize().isPresent()) {
							writer.append("font-size:").append(String.valueOf(style.getFontSize().get())).append(';');
						}
						if (style.getFgColor().isPresent()) {
							writer.append("color:#").append(Integer.toHexString(style.getFgColor().get().getRGB())).append(';');
						}
						if (style.getBgColor().isPresent()) {
							writer.append("background-color:#").append(Integer.toHexString(style.getBgColor().get().getRGB())).append(';');
						}
						writer.append("'>");
					} else if (node instanceof Text) {
						writer.append(((Text) node).getText());
					}
				} catch (IOException e) {
					throw Throwables.propagate(e);
				}
			}
			
			@Override
			public void tail(INode node) {
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
