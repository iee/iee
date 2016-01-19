package org.eclipse.iee.editor.core.container;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.dom.CompilationUnit;

public interface IASTProvider {

	CompilationUnit getAst(ICompilationUnit compilationUnit);
	
}
