package org.eclipse.iee.editor.text.edit;

import org.eclipse.iee.core.document.text.Document;
import org.eclipse.iee.core.document.text.Span;
import org.eclipse.iee.core.document.text.Text;

public class CopyVisitor extends BaseVisitor<CopyCtx, String> {

	@Override
	public String visitText(Text text, CopyCtx ctx) {
		int from = ctx.getFrom().getOffset();
		int to = ctx.getTo().getOffset();
		if (ctx.isFrom(text)) {
			if (ctx.isTo(text)) {
				ctx.append(text.getText().substring(from, to));
			} else {
				ctx.append(text.getText().substring(from));
			}
		} else if (ctx.isTo(text)) {
			ctx.append(text.getText().substring(0, to));
		} else if (ctx.isStarted()) {
			ctx.append(text.getText());
		}
		if (ctx.isFrom(text)) {
			ctx.setStarted(true);
		} 
		if (ctx.isTo(text) ) {
			ctx.setStarted(false);
		}
		return ctx.getString();
	}

	@Override
	public String visitDocument(Document document, CopyCtx ctx) {
		traverse(document, ctx);
		return ctx.getString();
	}

	@Override
	public String visitSpan(Span span, CopyCtx ctx) {
		traverse(span, ctx);
		return ctx.getString();
	}

}
