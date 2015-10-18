package org.eclipse.iee.translator.antlr.translator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NaryExpression extends Expression {

	private String name;
	
	private List<VariableAssignment> variables;
	
	private Expression expression;

	public NaryExpression() {
		variables = new ArrayList<>();
	}

	public NaryExpression(String name, List<VariableAssignment> variables, Expression expression) {
		super();
		this.name = name;
		this.variables = new ArrayList<>(variables);
		this.expression = expression;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		String oldValue = this.name;
		this.name = name;
		getPropertyChangeSupport().firePropertyChange("name", oldValue, name);
	}

	public List<VariableAssignment> getVariables() {
		return Collections.unmodifiableList(variables);
	}

	public void setVariables(List<VariableAssignment> variables) {
		List<VariableAssignment> oldValue = this.variables;
		this.variables = new ArrayList<>(variables);
		getPropertyChangeSupport().firePropertyChange("variables", oldValue, variables);
	}

	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		Expression oldValue = this.expression;
		this.expression = expression;
		getPropertyChangeSupport().firePropertyChange("expression", oldValue, expression);
	}

	@Override
	public String getText() {
		StringBuilder sb = new StringBuilder();
		sb.append(name != null ? name : PLACEHOLDER);
		sb.append('(');
		for (int i = 0; i < variables.size(); i++) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append(variables.get(i).getText());
		}
		sb.append(',');
		sb.append(getExpression() != null ? getExpression().getText() : PLACEHOLDER); 
		sb.append(')');
		return sb.toString();
	}
	
	@Override
	public <R, C> R accept(Visitor<R, C> visitor, C context) {
		return visitor.acceptNaryExpression(this, context);
	}
	
}
