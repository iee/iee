package org.eclipse.iee.core.document.source;

public interface IVariableType {
	
	IVariableType getMethodType(String name);
	
	String getJavaQualifiedName();

}
