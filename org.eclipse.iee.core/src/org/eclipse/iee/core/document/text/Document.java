package org.eclipse.iee.core.document.text;

public class Document extends AbstractCompositeNode<Span> {

	private TextStyle fStyle = new TextStyle();
	
	public TextStyle getStyle() {
		return fStyle;
	}
	
	@Override
	public <C, R> R accept(INodeVisitor<C, R> visitor, C ctx) {
		return visitor.visitDocument(this, ctx);
	}
	
}
