package org.eclipse.iee.core.document.text;

import com.google.common.base.Optional;

public class Span extends AbstractCompositeNode<ISpanContent> implements IDocumentContent, ISpanContent {

	private TextStyle fStyle = new TextStyle();
	
	public TextStyle getStyle() {
		return fStyle;
	}

	@Override
	protected void onParentChanged(INode oldParent, INode newParent) {
		if (newParent != null) {
			fStyle.setParent(Optional.of(newParent.getStyle()));
		} else {
			fStyle.setParent(Optional.<TextStyle> absent());
		}
	}
	
	@Override
	public <C, R> R accept(INodeVisitor<C, R> visitor, C ctx) {
		return visitor.visitSpan(this, ctx);
	}
	
}
