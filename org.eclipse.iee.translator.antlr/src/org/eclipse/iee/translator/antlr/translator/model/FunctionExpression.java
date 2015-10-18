package org.eclipse.iee.translator.antlr.translator.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FunctionExpression extends Expression {
	
	private String name;
	
	private List<Expression> parameters;

	public FunctionExpression() {
		parameters = new ArrayList<>();
	}
	
	public FunctionExpression(String name, List<Expression> parameters) {
		this.name = name;
		this.parameters = new ArrayList<>(parameters);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		String oldValue = this.name;
		this.name = name;
		getPropertyChangeSupport().firePropertyChange("name", oldValue, name);
	}

	public List<Expression> getParameters() {
		return Collections.unmodifiableList(parameters);
	}

	public void setParameters(List<Expression> parameters) {
		List<Expression> oldValue = this.parameters;
		this.parameters = new ArrayList<>(parameters);
		getPropertyChangeSupport().firePropertyChange("parameters", oldValue, parameters);
	}

	@Override
	public String getText() {
		StringBuilder sb = new StringBuilder();
		sb.append(name != null ? name : PLACEHOLDER);
		sb.append('(');
		for (int i = 0; i < parameters.size(); i++) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append(parameters.get(i).getText());
		}
		sb.append(')');
		return sb.toString();
	}
	
	@Override
	public <R, C> R accept(Visitor<R, C> visitor, C context) {
		return visitor.acceptFunctionExpression(this, context);
	}

}
