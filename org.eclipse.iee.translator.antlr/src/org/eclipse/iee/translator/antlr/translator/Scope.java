package org.eclipse.iee.translator.antlr.translator;

import java.util.Map;

import org.eclipse.iee.core.document.source.VariableType;

import com.google.common.collect.Maps;

class Scope {
	
	private Scope parent;
	
	private Map<String, VariableType> variables = Maps.newHashMap();

	public Scope(Scope parent) {
		this.parent = parent;
	}
	
	public Scope getParent() {
		return parent;
	}

	public void addVariable(String text, VariableType d) {
		variables.put(text, d);
	}

	public VariableType getVariableType(String text) {
		VariableType variableType = variables.get(text);
		if (variableType == null && parent != null) {
			return parent.getVariableType(text);
		}
		return variableType;
	}
	
}