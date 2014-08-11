package org.eclipse.iee.translator.antlr.translator;

import org.eclipse.iee.translator.antlr.translator.JavaTranslator.VariableType;
import org.eclipse.jdt.core.IType;

public interface ExternalTranslationContext {

	boolean containsMethod(String name);

	IType getMethodType(String name);

	boolean containsClass(String name);

	IType getClassType(String name);

	boolean containsOtherSourceClass(String name);

	String translateName(String text);

	VariableType getVariableType(String variable);

}
