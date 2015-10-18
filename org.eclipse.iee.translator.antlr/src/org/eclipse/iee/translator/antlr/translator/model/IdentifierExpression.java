package org.eclipse.iee.translator.antlr.translator.model;


public class IdentifierExpression extends Expression {

	private String name;

	public IdentifierExpression() {
	}
	
	public IdentifierExpression(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		String oldValue = this.name;
		this.name = name;
		getPropertyChangeSupport().firePropertyChange("name", oldValue, name);
	}

	@Override
	public String getText() {
		return name != null ? name : PLACEHOLDER;
	}
	
	@Override
	public <R, C> R accept(Visitor<R, C> visitor, C context) {
		return visitor.acceptIdentifierExpression(this, context);
	}

}
