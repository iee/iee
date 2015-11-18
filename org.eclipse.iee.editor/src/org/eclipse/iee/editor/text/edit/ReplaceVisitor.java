package org.eclipse.iee.editor.text.edit;

import org.eclipse.iee.core.document.text.Document;
import org.eclipse.iee.core.document.text.INodeVisitor;
import org.eclipse.iee.core.document.text.Span;
import org.eclipse.iee.core.document.text.Text;

public class ReplaceVisitor implements INodeVisitor<ReplaceCtx, CompositeCommand>{

	@Override
	public CompositeCommand visitText(Text text, ReplaceCtx ctx) {
		if (ctx.isFrom(text) && ctx.isTo(text)) {
			ctx.append(new ReplaceText(text, ctx.getFrom().getOffset(), ctx.getTo().getOffset(), ctx.getText()));
		}
		return ctx.getCommand();
	}

	@Override
	public CompositeCommand visitDocument(Document document, ReplaceCtx ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompositeCommand visitSpan(Span span, ReplaceCtx ctx) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
