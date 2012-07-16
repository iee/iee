/*
 * generated by Xtext
 */
package org.eclipse.iee.translator.molex.mex.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.iee.translator.molex.mex.mex.*

class MexGenerator implements IGenerator {
	
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {

	}
	
	def String generateText(Resource resource) {
		var statements = resource.contents;
		
		if (statements.empty) {
			return null;
		}
		
		var statement = compileStatement(statements.head as Statement);
		
		return statement.toString();
	}
	
	def compileStatement(Statement s)
	{
	'''
		�IF s.functionDefinition != null��compileFunctionDefinition(s.functionDefinition)��ENDIF�
		�IF s.formula != null��compileFormula(s.formula)��ENDIF�
		�IF s.logicalFormula != null��compileLogicalFormula(s.logicalFormula)��ENDIF�
		�IF s.variableAssignment != null��compileVariableAssignment(s.variableAssignment)��ENDIF�
		�IF s.matrixAssignment != null��compileMatrixAssignment(s.matrixAssignment)��ENDIF�
		�IF s.matrixFormula != null��compileMatrixFormula(s.matrixFormula)��ENDIF�
	'''
	}
	
	def compileFunctionDefinition(FunctionDefinition funcDef)
	{
	'''
		�compileName(funcDef.function.name)� ( 
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
	 	�compileFormula(a.variable)� = �compileFormula(a.value)�
	 '''
	}
	
	def compileName(MathName name)
	{
	'''
		�var temp = name.mathName�
		�IF temp.contains("")�
		�ENDIF�
		�temp.replaceAll("alpha", "\\\\alpha")
			 .replaceAll("beta", "\\\\beta")
			 .replaceAll("delta", "\\\\delta")
			 .replaceAll("epsilon", "\\\\epsilon")
			 //.replaceAll("varepsilon", "\\\\varepsilon")
			 .replaceAll("zeta", "\\\\zeta")
			 //.replaceAll("eta", "\\\\eta")
			 .replaceAll("theta", "\\\\theta")
			 //.replaceAll("vartheta", "\\\\vartheta")
			 .replaceAll("gamma", "\\\\gamma")
			 .replaceAll("kappa", "\\\\kappa")	
			 .replaceAll("lambda", "\\\\lambda")
			 .replaceAll("mu", "\\\\mu")
			 .replaceAll("nu", "\\\\nu")
			 .replaceAll("xi", "\\\\xi")
			 .replaceAll("pi", "\\\\pi")
			 //.replaceAll("varpi", "\\\\varpi")
			 .replaceAll("rho", "\\\\rho")
			 //.replaceAll("varrho", "\\\\varrho")
			 .replaceAll("sigma", "\\\\sigma")
			 //.replaceAll("varsigma", "\\\\varsigma")
			 .replaceAll("tau", "\\\\tau")
			 .replaceAll("upsilon", "\\\\upsilon")
			 .replaceAll("phi", "\\\\phi")
			 //.replaceAll("varphi", "\\\\varphi")
			 .replaceAll("chi", "\\\\chi")
			 //.replaceAll("psi", "\\\\psi")
			 .replaceAll("omega", "\\\\omega")
			 .replaceAll("Gamma", "\\\\Gamma")
			 .replaceAll("Delta", "\\\\Delta")
			 .replaceAll("Theta", "\\\\Theta")
			 .replaceAll("Lambda", "\\\\Lambda")
			 .replaceAll("Xi", "\\\\Xi")
			 .replaceAll("Pi", "\\\\Pi")
			 .replaceAll("Sigma", "\\\\Sigma")	
			 .replaceAll("Upsilon", "\\\\Upsilon")
			 .replaceAll("Phi", "\\\\Phi")
			 .replaceAll("Psi", "\\\\Psi")
			 .replaceAll("Omega", "\\\\Omega")
			 �
	'''
	}
	
	def compileFormula(Formula f) 
	{
	'''
		�compileExpression(f.expression)�
	'''
	}
	
	def compileLogicalFormula(LogicalFormula f) 
	{
	'''
		�compileLogicalExpression(f.expression)�
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
	 	�compileName(a.variable)� = �compileMatrixFormula(a.value)�
	 '''
	}
	
	/*TODO: add function check */
	def compileFunction(Function f) '''
		�compileName(f.function.name)�
		(�FOR param:f.function.parameters�
		 �IF param != null��compileFormula(param)��ENDIF�
		 �IF f.function.parameters.last() != param�,�ENDIF�
		�ENDFOR�)
	'''
	
	//Expression
		
	def dispatch compileExpression(Variable n) '''
		�compileName(n.name)�'''
		
	def dispatch compileExpression(Float n) '''
		�n.value�'''
		
	def dispatch compileExpression(MatrixElement e) '''
		�compileName(e.element)�_{�compileFormula(e.row)�,�compileFormula(e.column)�}'''
		
	def dispatch compileExpression(Function f) '''
		�compileFunction(f)�'''
		
	def dispatch compileExpression(ClassFunction call) '''
		�compileName(call.class_)�.�compileName(call.function.name)�
		(�FOR param:call.function.parameters�
		 �IF param != null��compileFormula(param)��ENDIF�
		 �IF call.function.parameters.last() != param�,�ENDIF�
		�ENDFOR�)'''
		
	def dispatch compileExpression(ClassMember call) '''
		�compileName(call.class_)�.�compileName(call.member)�'''	
	
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
		�compileExpression(op.left)�^{�compileExpression(op.right)�}'''
	
	//Matrix Expressions
	def dispatch compileMatrixExpression(MatrixVariable n) '''
		�compileName(n.name)�'''	
	
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
			 	�compileFormula(element)�
			 �ENDIF�
			 �IF (i = i + 1) != row.elements.size()�&�ENDIF�
			�ENDFOR�
		 �ENDIF�
		 �IF (j = j + 1) != m.matrix.rows.size()�\\�ENDIF�
		�ENDFOR�
		\end{array}\right)$$
		'''	
		
	def dispatch compileMatrixExpression(TransposeMatrix n) '''
		�compileName(n.name)�^T'''	
		
	def dispatch compileMatrixExpression(MatrixInBrackets op) '''
		(�compileMatrixExpression(op.inBrackets.addition)�)'''	
		
	def dispatch compileMatrixExpression(MatrixAddition op) '''
		�compileMatrixExpression(op.left)�+�compileMatrixExpression(op.right)�'''
	
	def dispatch compileMatrixExpression(MatrixSubtraction op) '''
		�compileMatrixExpression(op.left)�-�compileMatrixExpression(op.right)�'''
	
	def dispatch compileMatrixExpression(MatrixMultiplication op) '''
		�IF op.rightMatrix != null��compileMatrixExpression(op.left)�*�compileMatrixExpression(op.rightMatrix)��ENDIF�
		�IF op.rightScalar != null��compileMatrixExpression(op.left)�*�compileFormula(op.rightScalar)��ENDIF�'''
	
	//Logical Expressions
		
	def dispatch compileLogicalExpression(LogicalInBrackets op) '''
		(�compileLogicalExpression(op.inBrackets.addition)�)'''	
		
	def dispatch compileLogicalExpression(LogicalAddition op) '''
		�compileLogicalExpression(op.left)� \vee �compileLogicalExpression(op.right)�'''
	
	def dispatch compileLogicalExpression(LogicalMultiplication op) '''
		�compileLogicalExpression(op.left)� \wedge �compileLogicalExpression(op.right)�'''
		
	 def dispatch compileLogicalExpression(LogicalComparison op) '''
		�compileFormula(op.left)� 
		�IF op.operation.matches(">=")�
			\ge
		�ENDIF�
		�IF op.operation.matches("<=")�
			\le	
		�ENDIF�
		�IF op.operation.matches("<")�
			<
		�ENDIF� 
		�IF op.operation.matches(">")�
			>	
		�ENDIF�
		�IF op.operation.matches("!=")�
			\ne	
		�ENDIF�
		�IF op.operation.matches("==")�
			==	
		�ENDIF�
		�compileFormula(op.right)�'''		
}
