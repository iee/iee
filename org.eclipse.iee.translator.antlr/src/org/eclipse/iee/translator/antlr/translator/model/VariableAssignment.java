package org.eclipse.iee.translator.antlr.translator.model;

public class VariableAssignment extends Expression {

	private String name;
	
	private Expression fMin;

	private Expression fMax;

	public VariableAssignment() {
	}

	public VariableAssignment(String name, Expression min, Expression max) {
		this.name = name;
		this.fMin = min;
		fMax = max;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		String oldValue = this.name;
		this.name = name;
		getPropertyChangeSupport().firePropertyChange("name", oldValue, name);
	}

	public Expression getMin() {
		return fMin;
	}

	public void setMin(Expression value) {
		Expression oldValue = this.fMin;
		this.fMin = value;
		getPropertyChangeSupport().firePropertyChange("min", oldValue, value);
	}
	
	public Expression getMax() {
		return fMin;
	}

	public void setMax(Expression value) {
		Expression oldValue = this.fMax;
		this.fMax = value;
		getPropertyChangeSupport().firePropertyChange("max", oldValue, value);
	}

	@Override
	public String getText() {
		return (getName() != null ? getName() : PLACEHOLDER) + " = " + (getMin() != null ? getMin().getText() : PLACEHOLDER);
	}
	
	@Override
	public <R, C> R accept(Visitor<R, C> visitor, C context) {
		return visitor.acceptVariableAssignment(this, context);
	}
	
}
