package org.eclipse.iee.translator.antlr.translator;

import org.eclipse.iee.core.document.source.IVariableType;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.dom.ITypeBinding;

public interface ExternalTranslationContext {

	boolean containsMethod(String name);

	IType getMethodType(String name);

	boolean containsClass(String name);

	IType getClassType(String name);

	boolean containsOtherSourceClass(String name);

	String translateName(String text);

	IVariableType getVariableType(String variable);

	IVariableType getFunctionType(String text);

}
