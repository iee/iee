package org.eclipse.iee.translator.antlr.translator;

import java.util.Map;

import org.eclipse.iee.core.document.source.IScope;
import org.eclipse.iee.core.document.source.IVariableType;

import com.google.common.collect.Maps;

class Scope implements IScope {
	
	private Scope parent;
	
	private Map<String, IVariableType> variables = Maps.newHashMap();

	public Scope(Scope parent) {
		this.parent = parent;
	}
	
	public Scope getParent() {
		return parent;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.iee.translator.antlr.translator.IScope#addVariable(java.lang.String, org.eclipse.iee.core.document.source.VariableType)
	 */
	@Override
	public void addVariable(String text, IVariableType d) {
		variables.put(text, d);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.iee.translator.antlr.translator.IScope#getVariableType(java.lang.String)
	 */
	@Override
	public IVariableType getVariableType(String text) {
		IVariableType variableType = variables.get(text);
		if (variableType == null && parent != null) {
			return parent.getVariableType(text);
		}
		return variableType;
	}

	@Override
	public boolean hasVariable(String variable) {
		return variables.containsKey(variable);
	}
	
}