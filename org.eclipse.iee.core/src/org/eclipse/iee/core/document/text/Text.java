package org.eclipse.iee.core.document.text;

public class Text extends AbstractNode implements ISpanContent {

	private String fText;
	
	public String getText() {
		return fText;
	}

	public Text setText(String text) {
		getEventBusSupport().firePropertyChange("text", fText, fText = text);
		return this;
	}
	
	@Override
	public boolean hasText() {
		return true;
	}
	
	@Override
	public <C, R> R accept(INodeVisitor<C, R> visitor, C ctx) {
		return visitor.visitText(this, ctx);
	}
	
	@Override
	public TextStyle getStyle() {
		return getParent().getStyle();
	}

}
