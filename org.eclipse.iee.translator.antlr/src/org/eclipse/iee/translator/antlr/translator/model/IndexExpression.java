package org.eclipse.iee.translator.antlr.translator.model;

public class IndexExpression extends Expression {

	private Expression container;
	
	private Expression index;
	
	public IndexExpression() {
	}
	
	public IndexExpression(Expression container, Expression index) {
		this.container = container;
		this.index = index;
	}

	public Expression getContainer() {
		return container;
	}

	public void setContainer(Expression container) {
		Expression oldValue = this.container;
		this.container = container;
		getPropertyChangeSupport().firePropertyChange("container", oldValue, container);
	}

	public Expression getIndex() {
		return index;
	}

	public void setIndex(Expression index) {
		Expression oldValue = this.index;
		this.index = index;
		getPropertyChangeSupport().firePropertyChange("index", oldValue, index);
	}

	@Override
	public String getText() {
		return (getContainer() != null ? getContainer().getText() : PLACEHOLDER) + "[" + (getIndex() != null ? getIndex().getText() : PLACEHOLDER) + "]";
	}
	
	@Override
	public <R, C> R accept(Visitor<R, C> visitor, C context) {
		return visitor.acceptIndexExpression(this, context);
	}
	
}
