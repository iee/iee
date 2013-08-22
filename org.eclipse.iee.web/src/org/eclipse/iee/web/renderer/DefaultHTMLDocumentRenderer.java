package org.eclipse.iee.web.renderer;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.web.document.DirectiveBlock;
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
	public void renderHTMLHead(Document document, IHTMLRendererContext context) throws IOException {
		Writer writer = context.getWriter();
		writer.append("<style type='text/css'>");
		writer.append(appendStyles());
		writer.append("</style>");
	}

	@Override
	public void renderHTMLBody(Document document, IHTMLRendererContext context) throws IOException {
		Writer writer = context.getWriter();
		writer.append("<div class='source'><pre>");
		List<DocumentPart> children = document.getRoot().getChildren();
		appendChildren(context, children);
		writer.append("</pre></div>");
	}

	private void appendChildren(IHTMLRendererContext context, List<DocumentPart> children) throws IOException {
		for (DocumentPart documentPart : children) {
			appendPart(documentPart, context);
		}
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

	private void appendPart(DocumentPart documentPart, IHTMLRendererContext context) throws IOException {
		Writer writer = context.getWriter();
		if (documentPart instanceof PadDocumentPart) {
			Pad pad = ((PadDocumentPart) documentPart).getPad();
			IHTMLRenderer<Pad> renderer = manager.getPadHTMLRenderer(pad.getType());
			writer.append("<div style='display:inline-block;'>");
			if (renderer != null) {
				renderer.renderPad(pad, context);
			} else {
				writer.append("Unknow pad type " + pad.getClass());
			}
			writer.append("</div>");
		} else if (documentPart instanceof TextDocumentPart) {
			String type = ((TextDocumentPart) documentPart).getType();
			if ("Ws".equals(type)) {
				writer.write(((TextDocumentPart) documentPart).getText());
			} else {
				writer.append("<span class = '").append(type.toLowerCase()).append("' >").append(StringEscapeUtils.escapeHtml4(((TextDocumentPart) documentPart).getText())).append("</span>");
			}
		} else if (documentPart instanceof DirectiveBlock) {
			String directive = ((DirectiveBlock) documentPart).getDirective();
			if ("hide".equals(directive)) {
				//skip hidden text
			} else {
				appendChildren(context, documentPart.getChildren());
			}
		}
	}

	@Override
	public void renderResource(Document document, String padId, String resourceId, IResourceRenderContext context)
			throws IOException {
		for (DocumentPart documentPart : document.getRoot().getChildren()) {
			if (documentPart instanceof PadDocumentPart) {
				Pad pad = ((PadDocumentPart) documentPart).getPad();
				if (padId.equals(pad.getContainerID())) {
					IHTMLRenderer<Pad> renderer = manager.getPadHTMLRenderer(pad.getType());
					renderer.renderResource(pad, resourceId, context);
				}
			}
		}
	}
	
}
