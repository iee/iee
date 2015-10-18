package org.eclipse.iee.translator.antlr.translator.model;

public class BracketsExpression extends Expression {

	private Expression inner;
	
	public BracketsExpression() {
	}

	public BracketsExpression(Expression inner) {
		this.inner = inner;
	}

	public Expression getInner() {
		return inner;
	}

	public void setInner(Expression inner) {
		getPropertyChangeSupport().firePropertyChange("left", this.inner, this.inner = inner);
	}

	public String getText() {
		return "(" + (getInner() != null ? getInner().getText() : PLACEHOLDER) + ")";
	}
	
	@Override
	public <R, C> R accept(Visitor<R, C> visitor, C context) {
		return visitor.visitBracketsExpression(this, context);
	}
	
}
