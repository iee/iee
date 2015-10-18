package org.eclipse.iee.translator.antlr.translator.model;

public class BinaryExpression extends Expression {

	private Expression left;
	
	private String sign;
	
	private Expression right;

	public BinaryExpression() {
	}

	public BinaryExpression(Expression left, String sign, Expression right) {
		super();
		this.left = left;
		this.sign = sign;
		this.right = right;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		String oldValue = this.sign;
		this.sign = sign;
		getPropertyChangeSupport().firePropertyChange("sign", oldValue, sign);
	}

	public Expression getLeft() {
		return left;
	}

	public void setLeft(Expression left) {
		Expression oldValue = this.left;
		this.left = left;
		getPropertyChangeSupport().firePropertyChange("left", oldValue, left);
	}

	public Expression getRight() {
		return right;
	}

	public void setRight(Expression right) {
		Expression oldValue = this.right;
		this.right = right;
		getPropertyChangeSupport().firePropertyChange("right", oldValue, right);
	}
	
	@Override
	public String getText() {
		return (getLeft() != null ? getLeft().getText() : PLACEHOLDER) + (sign != null ? sign : PLACEHOLDER) + (getRight() != null ? getRight().getText() : PLACEHOLDER);
	}
	
	@Override
	public <R, C> R accept(Visitor<R, C> visitor, C context) {
		return visitor.visitBinaryExpression(this, context);
	}
	
}
