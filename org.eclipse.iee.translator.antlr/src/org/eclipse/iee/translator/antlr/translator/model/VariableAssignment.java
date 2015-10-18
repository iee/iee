package org.eclipse.iee.translator.antlr.translator.model;

public class VariableAssignment extends Expression {

	private String name;
	
	private Expression value;

	public VariableAssignment() {
	}

	public VariableAssignment(String name, Expression value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		String oldValue = this.name;
		this.name = name;
		getPropertyChangeSupport().firePropertyChange("name", oldValue, name);
	}

	public Expression getValue() {
		return value;
	}

	public void setValue(Expression value) {
		Expression oldValue = this.value;
		this.value = value;
		getPropertyChangeSupport().firePropertyChange("value", oldValue, value);
	}

	@Override
	public String getText() {
		return (getName() != null ? getName() : PLACEHOLDER) + " = " + (getValue() != null ? getValue().getText() : PLACEHOLDER);
	}
	
	@Override
	public <R, C> R accept(Visitor<R, C> visitor, C context) {
		return visitor.acceptVariableAssignment(this, context);
	}
	
}
