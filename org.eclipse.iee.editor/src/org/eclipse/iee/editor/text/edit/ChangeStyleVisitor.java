package org.eclipse.iee.editor.text.edit;

import org.eclipse.iee.core.document.text.Document;
import org.eclipse.iee.core.document.text.ICompositeNode;
import org.eclipse.iee.core.document.text.INode;
import org.eclipse.iee.core.document.text.INodeVisitor;
import org.eclipse.iee.core.document.text.Span;
import org.eclipse.iee.core.document.text.Text;

import com.google.common.base.Supplier;

public class ChangeStyleVisitor implements INodeVisitor<ChangeStyleCtx, CompositeCommand>{

	@Override
	public CompositeCommand visitText(final Text text, final ChangeStyleCtx ctx) {
		int from;
		int to;
		
		if (ctx.isFrom(text)) {
			ctx.setStarted(true);
			from = ctx.getFrom().getOffset();
		} else {
			from = 0;
		}
		if (ctx.isTo(text) ) {
			ctx.setStarted(false);
			to = ctx.getTo().getOffset();
		} else {
			to = text.getText().length();
		}
		if (from != 0 || to != text.getText().length()) {
			ctx.append(new WrapCommand(text, from, to));
		}
		ctx.append(ctx.do_(new Supplier<Span>() {
			@Override
			public Span get() {
				return (Span) text.getParent();
			}
		}));
		return ctx.getCommand();
	}

	@Override
	public CompositeCommand visitDocument(Document document, ChangeStyleCtx ctx) {
		traverse(document, ctx);
		return ctx.getCommand();
	}

	@Override
	public CompositeCommand visitSpan(final Span span, final ChangeStyleCtx ctx) {
		if (ctx.isStarted() && !span.isOrContains(ctx.getTo().getModel())) {
			ctx.append(ctx.do_(new Supplier<Span>() {
				@Override
				public Span get() {
					return span;
				}
			}));
		} else {
			traverse(span, ctx);
		}
		return ctx.getCommand();
	}

	protected void traverse(ICompositeNode<?> composite, ChangeStyleCtx ctx) {
		boolean started = ctx.isStarted();
		for (INode node : composite.getChildren()) {
			if (started) {
				node.accept(this, ctx);
			} else if (node.isOrContains(ctx.getFrom().getModel())) {
				started = true;
				node.accept(this, ctx);
			} 
			if (node.isOrContains(ctx.getTo().getModel())) {
				started = false;
			}
		}
	}


}
