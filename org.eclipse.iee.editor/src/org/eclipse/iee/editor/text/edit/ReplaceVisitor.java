package org.eclipse.iee.editor.text.edit;

import org.eclipse.iee.core.document.text.Document;
import org.eclipse.iee.core.document.text.ICompositeNode;
import org.eclipse.iee.core.document.text.INode;
import org.eclipse.iee.core.document.text.INodeVisitor;
import org.eclipse.iee.core.document.text.ITextLocation;
import org.eclipse.iee.core.document.text.OffsetTextLocation;
import org.eclipse.iee.core.document.text.Span;
import org.eclipse.iee.core.document.text.Text;

public class ReplaceVisitor implements INodeVisitor<ReplaceCtx, CompositeCommand>{

	private final class RemoveCommand implements IEditCommand {
		
		private final INode fNode;

		private final ITextLocation fMoveTo;
		
		private RemoveCommand(INode node, ITextLocation moveTo) {
			fNode = node;
			fMoveTo = moveTo;
		}

		@Override
		public void perform() {
			final ICompositeNode<INode> parent = (ICompositeNode<INode>) fNode.getParent();
			parent.removeChild(fNode);
		}

		@Override
		public ITextLocation adjust(ITextLocation location) {
			if (location.getModel().hasParent(fNode)) {
				return fMoveTo;
			}
			return location;
		}
		
	}

	@Override
	public CompositeCommand visitText(Text text, ReplaceCtx ctx) {
		if (ctx.isFrom(text)) {
			if (ctx.isTo(text)) {
				ctx.append(new ReplaceText(text, ctx.getFrom().getOffset(), ctx.getTo().getOffset(), ctx.getText()));
			} else {
				ctx.append(new ReplaceText(text, ctx.getFrom().getOffset(), text.getText().length(), ctx.getText()));
			}
		} else if (ctx.isTo(text)) {
			ctx.append(new ReplaceText(text, 0, ctx.getTo().getOffset(), ""));
		} else if (ctx.isStarted()) {
			createCommand(text, ctx);
		}
		if (ctx.isFrom(text)) {
			ctx.setStarted(true);
		} 
		if (ctx.isTo(text) ) {
			ctx.setStarted(false);
		}
		return ctx.getCommand();
	}

	@Override
	public CompositeCommand visitDocument(Document document, ReplaceCtx ctx) {
		traverse(document, ctx);
		return ctx.getCommand();
	}

	@Override
	public CompositeCommand visitSpan(final Span span, final ReplaceCtx ctx) {
		if (ctx.isStarted() && !span.isOrContains(ctx.getTo().getModel())) {
			createCommand(span, ctx);
		} else {
			traverse(span, ctx);
		}
		return ctx.getCommand();
	}

	private void createCommand(final INode node, final ReplaceCtx ctx) {
		ctx.append(new RemoveCommand(node, new OffsetTextLocation(ctx.getFrom().getModel(), ctx.getFrom().getOffset() + ctx.getText().length())));
	}

	protected void traverse(ICompositeNode<?> composite, ReplaceCtx ctx) {
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
