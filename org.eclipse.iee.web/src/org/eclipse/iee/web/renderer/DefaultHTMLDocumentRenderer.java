package org.eclipse.iee.web.renderer;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.web.document.Document;
import org.eclipse.iee.web.document.DocumentPart;
import org.eclipse.iee.web.document.PadDocumentPart;
import org.eclipse.iee.web.document.TextDocumentPart;

public class DefaultHTMLDocumentRenderer implements IHTMLDocumentRenderer {

	private HTMLRendererManager manager;

	public DefaultHTMLDocumentRenderer(HTMLRendererManager manager) {
		this.manager = manager;
	}

	@Override
	public void renderHTMLHead(Document document, Writer writer, IHTMLRendererContext context) throws IOException {
		writer.append("<style type='text/css'>");
		writer.append(appendStyles());
		writer.append("</style>");
	}

	@Override
	public void renderHTMLBody(Document document, Writer writer, IHTMLRendererContext context) throws IOException {
		writer.append("<div class='source'><pre>");
		List<DocumentPart> children = document.getRoot().getChildren();
		for (DocumentPart documentPart : children) {
			appendPart(documentPart, writer, context);
		}
		writer.append("</pre></div>");
	}

	private String appendStyles() {
		StringBuilder sb = new StringBuilder();
		sb.append(".source .keyword {color: #7F0055;}");
		sb.append(".source .linecomment {color: #3F7F5F;}");
		sb.append(".source .comment {color: #3F7F5F;}");
		sb.append(".source .javadoc {color: #3F5FBF;}");
		sb.append(".source .stringliteral {color: #2A00FF;}");
		return sb.toString();
	}

	private void appendPart(DocumentPart documentPart, Writer writer, IHTMLRendererContext context) throws IOException {
		if (documentPart instanceof PadDocumentPart) {
			Pad pad = ((PadDocumentPart) documentPart).getPad();
			IHTMLRenderer<Pad> renderer = manager.getPadHTMLRenderer(pad.getType());
			renderer.renderPad(pad, writer, context);
		} else if (documentPart instanceof TextDocumentPart) {
			String type = ((TextDocumentPart) documentPart).getType();
			if ("Ws".equals(type)) {
				writer.write(((TextDocumentPart) documentPart).getText());
			} else {
				writer.append("<span class = '").append(type.toLowerCase()).append("' >").append(StringEscapeUtils.escapeHtml4(((TextDocumentPart) documentPart).getText())).append("</span>");
			}
		}
	}
	
}
