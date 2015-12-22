package org.eclipse.iee.editor.text.edit;

import org.eclipse.iee.core.document.text.ICompositeNode;
import org.eclipse.iee.core.document.text.INode;
import org.eclipse.iee.core.document.text.INodeVisitor;

public abstract class BaseVisitor<C extends BaseCtx, R> implements INodeVisitor<C, R>{

	protected void traverse(ICompositeNode<?> composite, C ctx) {
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
