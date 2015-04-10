package org.eclipse.iee.core.document.source;

public interface IScope {

	void addVariable(String name, IVariableType type);

	IVariableType getVariableType(String name);

	boolean hasVariable(String name);

}
