/*
 * generated by Xtext
 */
package org.eclipse.iee.translator.molex.mex.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.IFileSystemAccess

import org.eclipse.iee.translator.molex.mex.mex

import org.eclipse.xtext.xtend2.lib.StringConcatenation
import static extension org.eclipse.xtext.xtend2.lib.ResourceExtensions.*
import org.eclipse.iee.translator.molex.mex.mex.*

class MexGenerator implements IGenerator {
	
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {

	}
	
	def String generateText(Resource resource) {
		var statements = resource.allContentsIterable.filter(typeof(Statement));
		
		if (statements.empty) {
			return null;
		}
		
		return statements.head.compileStatement.toString();	
	}
	
	def compileStatement(Statement s)
	{
	'''
		�IF s.functionDefinition != null��compileFunctionDefinition(s.functionDefinition)��ENDIF�
		�IF s.formula != null��compileFormula(s.formula)��ENDIF�
		�IF s.variableAssignment != null��compileVariableAssignment(s.variableAssignment)��ENDIF�
		�IF s.matrixAssignment != null��compileMatrixAssignment(s.matrixAssignment)��ENDIF�
		�IF s.matrixFormula != null��compileMatrixFormula(s.matrixFormula)��ENDIF�
	'''
	}
	
	def compileFunctionDefinition(FunctionDefinition funcDef)
	{
	'''
		�IF funcDef.function.name == "alpha" || funcDef.function.name == "beta" || funcDef.function.name == "gamma" ||
		    funcDef.function.name == "delta" || funcDef.function.name == "epsilon" || funcDef.function.name == "varepsilon" ||
		    funcDef.function.name == "zeta" || funcDef.function.name == "eta" || funcDef.function.name == "theta" ||
		    funcDef.function.name == "vartheta" || funcDef.function.name == "gamma" || funcDef.function.name == "kappa" ||
			funcDef.function.name == "lambda" || funcDef.function.name == "mu" || funcDef.function.name == "nu" || 
			funcDef.function.name == "xi" || funcDef.function.name == "pi" || funcDef.function.name == "varpi" || 
			funcDef.function.name == "rho" || funcDef.function.name == "varrho" || funcDef.function.name == "sigma" ||
			funcDef.function.name == "varsigma" || funcDef.function.name == "tau" || funcDef.function.name == "upsilon" ||
			funcDef.function.name == "phi" || funcDef.function.name == "varphi" || funcDef.function.name == "chi" || 
			funcDef.function.name == "psi" || funcDef.function.name == "omega" || funcDef.function.name == "Gamma" ||
			funcDef.function.name == "Delta" || funcDef.function.name == "Theta" || funcDef.function.name == "Lambda" ||
			funcDef.function.name == "Xi" || funcDef.function.name == "Pi" || funcDef.function.name == "Sigma" || 
			funcDef.function.name == "Upsilon" || funcDef.function.name == "Phi" || funcDef.function.name == "Psi" || 
			funcDef.function.name == "Omega"�
			\
		�ENDIF�
		�funcDef.function.name� ( 
		�FOR param:funcDef.function.parameters�
		 �IF param != null��compileFormula(param)��ENDIF�
		 �IF funcDef.function.parameters.last() != param�,�ENDIF�
		�ENDFOR�)
		�IF funcDef.formula != null�=�compileFormula(funcDef.formula)��ENDIF�
	'''
	}
	
	def compileVariableAssignment(VariableAssignment a)
	{
	 '''
	 	�IF a.variable == "alpha" || a.variable == "beta" || a.variable == "gamma" ||
		    a.variable == "delta" || a.variable == "epsilon" || a.variable == "varepsilon" ||
		    a.variable == "zeta" || a.variable == "eta" || a.variable == "theta" ||
		    a.variable == "vartheta" || a.variable == "gamma" || a.variable == "kappa" ||
			a.variable == "lambda" || a.variable == "mu" || a.variable == "nu" || 
			a.variable == "xi" || a.variable == "pi" || a.variable == "varpi" || 
			a.variable == "rho" || a.variable == "varrho" || a.variable == "sigma" ||
			a.variable == "varsigma" || a.variable == "tau" || a.variable == "upsilon" ||
			a.variable == "phi" || a.variable == "varphi" || a.variable == "chi" || 
			a.variable == "psi" || a.variable == "omega" || a.variable == "Gamma" ||
			a.variable == "Delta" || a.variable == "Theta" || a.variable == "Lambda" ||
			a.variable == "Xi" || a.variable == "Pi" || a.variable == "Sigma" || 
			a.variable == "Upsilon" || a.variable == "Phi" || a.variable == "Psi" || 
			a.variable == "Omega"�
			\
		�ENDIF�
	 	�a.variable� = �compileFormula(a.value)�
	 '''
	}
	
	def compileFormula(Formula f) 
	{
	'''
		�compileExpression(f.expression)�
	'''
	}
	
	def compileMatrixFormula(MatrixFormula f) 
	{
	'''
		�compileMatrixExpression(f.expression)�
	'''
	}
	
	def compileMatrixAssignment(MatrixAssignment a)
	{
	 '''
	 	�IF a.variable == "alpha" || a.variable == "beta" || a.variable == "gamma" ||
		    a.variable == "delta" || a.variable == "epsilon" || a.variable == "varepsilon" ||
		    a.variable == "zeta" || a.variable == "eta" || a.variable == "theta" ||
		    a.variable == "vartheta" || a.variable == "gamma" || a.variable == "kappa" ||
			a.variable == "lambda" || a.variable == "mu" || a.variable == "nu" || 
			a.variable == "xi" || a.variable == "pi" || a.variable == "varpi" || 
			a.variable == "rho" || a.variable == "varrho" || a.variable == "sigma" ||
			a.variable == "varsigma" || a.variable == "tau" || a.variable == "upsilon" ||
			a.variable == "phi" || a.variable == "varphi" || a.variable == "chi" || 
			a.variable == "psi" || a.variable == "omega" || a.variable == "Gamma" ||
			a.variable == "Delta" || a.variable == "Theta" || a.variable == "Lambda" ||
			a.variable == "Xi" || a.variable == "Pi" || a.variable == "Sigma" || 
			a.variable == "Upsilon" || a.variable == "Phi" || a.variable == "Psi" || 
			a.variable == "Omega"�
			\
		�ENDIF�
	 	�a.variable� = �compileMatrixFormula(a.value)�
	 '''
	}
	
	/*TODO: add function check */
	def compileFunction(Function f) '''
		�IF f.function.name == "alpha" || f.function.name == "beta" || f.function.name == "gamma" ||
		    f.function.name == "delta" || f.function.name == "epsilon" || f.function.name == "varepsilon" ||
		    f.function.name == "zeta" || f.function.name == "eta" || f.function.name == "theta" ||
		    f.function.name == "vartheta" || f.function.name == "gamma" || f.function.name == "kappa" ||
			f.function.name == "lambda" || f.function.name == "mu" || f.function.name == "nu" || 
			f.function.name == "xi" || f.function.name == "pi" || f.function.name == "varpi" || 
			f.function.name == "rho" || f.function.name == "varrho" || f.function.name == "sigma" ||
			f.function.name == "varsigma" || f.function.name == "tau" || f.function.name == "upsilon" ||
			f.function.name == "phi" || f.function.name == "varphi" || f.function.name == "chi" || 
			f.function.name == "psi" || f.function.name == "omega" || f.function.name == "Gamma" ||
			f.function.name == "Delta" || f.function.name == "Theta" || f.function.name == "Lambda" ||
			f.function.name == "Xi" || f.function.name == "Pi" || f.function.name == "Sigma" || 
			f.function.name == "Upsilon" || f.function.name == "Phi" || f.function.name == "Psi" || 
			f.function.name == "Omega"�
			\
		�ENDIF�
		\\�f.function.name�
		(�FOR param:f.function.parameters�
		 �IF param != null��compileFormula(param)��ENDIF�
		 �IF f.function.parameters.last() != param�,�ENDIF�
		�ENDFOR�)
	'''
	
	//Expression
		
	def dispatch compileExpression(Variable n) '''
		�IF n.name == "alpha" || n.name == "beta" || n.name == "gamma" ||
		    n.name == "delta" || n.name == "epsilon" || n.name == "varepsilon" ||
		    n.name == "zeta" || n.name == "eta" || n.name == "theta" ||
		    n.name == "vartheta" || n.name == "gamma" || n.name == "kappa" ||
			n.name == "lambda" || n.name == "mu" || n.name == "nu" || 
			n.name == "xi" || n.name == "pi" || n.name == "varpi" || 
			n.name == "rho" || n.name == "varrho" || n.name == "sigma" ||
			n.name == "varsigma" || n.name == "tau" || n.name == "upsilon" ||
			n.name == "phi" || n.name == "varphi" || n.name == "chi" || 
			n.name == "psi" || n.name == "omega" || n.name == "Gamma" ||
			n.name == "Delta" || n.name == "Theta" || n.name == "Lambda" ||
			n.name == "Xi" || n.name == "Pi" || n.name == "Sigma" || 
			n.name == "Upsilon" || n.name == "Phi" || n.name == "Psi" || 
			n.name == "Omega"�
			\
		�ENDIF�
		�n.name�'''
		
	def dispatch compileExpression(Float n) '''
		�n.value�'''
		
	def dispatch compileExpression(MatrixElement e) '''
		�IF e.element == "alpha" || e.element == "beta" || e.element == "gamma" ||
		    e.element == "delta" || e.element == "epsilon" || e.element == "varepsilon" ||
		    e.element == "zeta" || e.element == "eta" || e.element == "theta" ||
		    e.element == "vartheta" || e.element == "gamma" || e.element == "kappa" ||
			e.element == "lambda" || e.element == "mu" || e.element == "nu" || 
			e.element == "xi" || e.element == "pi" || e.element == "varpi" || 
			e.element == "rho" || e.element == "varrho" || e.element == "sigma" ||
			e.element == "varsigma" || e.element == "tau" || e.element == "upsilon" ||
			e.element == "phi" || e.element == "varphi" || e.element == "chi" || 
			e.element == "psi" || e.element == "omega" || e.element == "Gamma" ||
			e.element == "Delta" || e.element == "Theta" || e.element == "Lambda" ||
			e.element == "Xi" || e.element == "Pi" || e.element == "Sigma" || 
			e.element == "Upsilon" || e.element == "Phi" || e.element == "Psi" || 
			e.element == "Omega"�
			\
		�ENDIF�
		�e.element�_{�e.row�,�e.column�}'''
		
	def dispatch compileExpression(Function f) '''
		�compileFunction(f)�'''
	
	def dispatch compileExpression(InBrackets op) '''
		(�compileExpression(op.inBrackets.addition)�)'''
	
	def dispatch compileExpression(Addition op) '''
		�compileExpression(op.left)�+�compileExpression(op.right)�'''
	
	def dispatch compileExpression(Subtraction op) '''
		�compileExpression(op.left)�-�compileExpression(op.right)�'''
	
	def dispatch compileExpression(Multiplication op) '''
		�compileExpression(op.left)�*�compileExpression(op.right)�'''
	
	def dispatch compileExpression(Division op) '''
		\frac{�compileExpression(op.left)�}{�compileExpression(op.right)�}'''
	
	def dispatch compileExpression(Modulo op) '''
		�compileExpression(op.left)� \mod �compileExpression(op.right)�'''
	
	def dispatch compileExpression(Invert op) '''
	�IF op.expression != null� (-�compileExpression(op.expression)�) �ENDIF�''' 
	
	def dispatch compileExpression(Factorial op) '''
	�IF op.expression != null� �compileExpression(op.expression)�! �ENDIF�'''  
		
	def dispatch compileExpression(Exponent op) '''
		�compileExpression(op.left)�^�compileExpression(op.right)�'''
	
	//Matrix Expressions
	def dispatch compileMatrixExpression(MatrixVariable n) '''
		�n.name�'''	
	
	def dispatch compileMatrixExpression(NewMatrix m) '''
		$$\left(\begin{array}{
		�FOR row:m.matrix.rows�
			c
		�ENDFOR�	
		}
		�var j = 0�
		�FOR row:m.matrix.rows�
		 �IF row != null�
		 	�var i = 0�
	 		�FOR element:row.elements�
			 �IF element != null�
			 	�element�
			 �ENDIF�
			 �IF (i = i + 1) != row.elements.size()�&�ENDIF�
			�ENDFOR�
		 �ENDIF�
		 �IF (j = j + 1) != m.matrix.rows.size()�\\�ENDIF�
		�ENDFOR�
		\end{array}\right)$$
		'''	
		
	def dispatch compileMatrixExpression(TransposeMatrix n) '''
		�n.name�^T'''	
		
	def dispatch compileMatrixExpression(MatrixInBrackets op) '''
		(�compileMatrixExpression(op.inBrackets.addition)�)'''	
		
	def dispatch compileMatrixExpression(MatrixAddition op) '''
		�compileMatrixExpression(op.left)�+�compileMatrixExpression(op.right)�'''
	
	def dispatch compileMatrixExpression(MatrixSubtraction op) '''
		�compileMatrixExpression(op.left)�-�compileMatrixExpression(op.right)�'''
	
	def dispatch compileMatrixExpression(MatrixMultiplication op) '''
		�IF op.rightMatrix != null��compileMatrixExpression(op.left)�*�compileMatrixExpression(op.rightMatrix)��ENDIF�
		�IF op.rightScalar != null��compileMatrixExpression(op.left)�*�compileFormula(op.rightScalar)��ENDIF�'''
		
	
}
