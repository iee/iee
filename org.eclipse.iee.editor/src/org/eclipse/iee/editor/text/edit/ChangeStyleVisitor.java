package org.eclipse.iee.editor.text.edit;

import org.eclipse.iee.core.document.text.Document;
import org.eclipse.iee.core.document.text.ICompositeNode;
import org.eclipse.iee.core.document.text.INode;
import org.eclipse.iee.core.document.text.INodeVisitor;
import org.eclipse.iee.core.document.text.ITextLocation;
import org.eclipse.iee.core.document.text.Span;
import org.eclipse.iee.core.document.text.Text;

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
		ctx.append(new IEditCommand() {
			
			@Override
			public void perform() {
				ctx.do_((Span) text.getParent());
			}
			
			@Override
			public ITextLocation adjust(ITextLocation location) {
				return location;
			}
		});
		return ctx.getCommand();
	}

	private IEditCommand createCommand(final Span span, final ChangeStyleCtx ctx) {
		return new IEditCommand() {
			
			@Override
			public void perform() {
				ctx.do_(span);
			}
			
			@Override
			public ITextLocation adjust(ITextLocation location) {
				return location;
			}
		};
	}

	@Override
	public CompositeCommand visitDocument(Document document, ChangeStyleCtx ctx) {
		traverse(document, ctx);
		return ctx.getCommand();
	}

	@Override
	public CompositeCommand visitSpan(final Span span, final ChangeStyleCtx ctx) {
		if (ctx.isStarted()) {
			ctx.append(createCommand(span, ctx));
		} else {
			traverse(span, ctx);
		}
		return ctx.getCommand();
	}

	protected void traverse(ICompositeNode<?> composite, ChangeStyleCtx ctx) {
		boolean started = false;
		for (INode node : composite.getChildren()) {
			if (started) {
				node.accept(this, ctx);
			} else if (node.isOrContains(ctx.getFrom().getModel())) {
				started = true;
				node.accept(this, ctx);
			} else if (node.isOrContains(ctx.getTo().getModel())) {
				started = false;
			}
		}
	}


}
