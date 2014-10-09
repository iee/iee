package org.eclipse.iee.core.document.source;

public interface ISourceGeneratorContext {

	String translateFunction(String function, String id);

	String getStoragePath();

	boolean isInClassBody();

	IVariableType getExpressionType(String function);
	
}
