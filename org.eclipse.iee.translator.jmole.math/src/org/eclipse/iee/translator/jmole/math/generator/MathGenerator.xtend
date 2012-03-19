/*
 * generated by Xtext
 */
package org.eclipse.iee.translator.jmole.math.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.generator.IFileSystemAccess

import org.eclipse.iee.translator.jmole.math.math

import org.eclipse.xtext.xtend2.lib.StringConcatenation
import static extension org.eclipse.xtext.xtend2.lib.ResourceExtensions.*
import org.eclipse.iee.translator.jmole.math.math.*

class MathGenerator implements IGenerator {
	
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
		�IF s.matrixDefinition != null��compileMatrixDefinition(s.matrixDefinition)�;�ENDIF�
		�IF s.assignment != null��compileAssignment(s.assignment)�;�ENDIF�
		�IF s.formula != null��compileFormula(s.formula)�;�ENDIF�
		
	'''
	}
	
	def compileFunctionDefinition(FunctionDefinition funcDef)
	{
	'''
		public static double �funcDef.function.name� ( 
		�FOR param:funcDef.function.parameters�
		 �IF param != null�double �compileFormula(param)��ENDIF�
		 �IF funcDef.function.parameters.last() != param�,�ENDIF�
		�ENDFOR�) 
		{ �IF funcDef.formula != null� return �compileFormula(funcDef.formula)�;�ENDIF� }
	'''
	}
	
	def compileAssignment(Assignment a)
	{
	 '''
	 	�a.variable� = �compileFormula(a.value)�
	 '''
	}
	
	def compileFormula(Formula f) 
	{
	'''
		�compileExpression(f.expression)�
	'''
	}
	
	def compileMatrixDefinition(MatrixDefinition m) 
	{
	'''
		Matrix �m.name� = new Matrix(new double[][]
		{
		�var j = 0�
		�FOR row:m.rows�
		 �IF row != null�
		 {
		 	�var i = 0�
	 		�FOR element:row.elements�
			 �IF element != null�
			 	�element�
			 �ENDIF�
			 �IF (i = i + 1) != row.elements.size()�,�ENDIF�
			�ENDFOR�
		 }
		 �ENDIF�
		 �IF (j = j + 1) != m.rows.size()�,�ENDIF�
		�ENDFOR�
		})
	'''
	}
	
	def compileFunction(Function f) '''
		�f.function.name�
		(�FOR param:f.function.parameters�
		 �IF param != null��compileFormula(param)��ENDIF�
		 �IF f.function.parameters.last() != param�,�ENDIF�
		�ENDFOR�)
	'''
			
	def dispatch compileExpression(Variable n) '''
		�n.name�'''
		
	def dispatch compileExpression(Float n) '''
		�n.value�'''
		
	def dispatch compileExpression(Function f) '''
		�compileFunction(f)�'''
	
	def dispatch compileExpression(Addition op) '''
		(�compileExpression(op.left)�) + (�compileExpression(op.right)�)'''
	
	def dispatch compileExpression(Subtraction op) '''
		(�compileExpression(op.left)�) - (�compileExpression(op.right)�)'''
	
	def dispatch compileExpression(Multiplication op) '''
		(�compileExpression(op.left)�) * (�compileExpression(op.right)�)'''
	
	def dispatch compileExpression(Division op) '''
		(�compileExpression(op.left)�) / (�compileExpression(op.right)�)'''
	
	def dispatch compileExpression(Modulo op) '''
		(�compileExpression(op.left)�) % (�compileExpression(op.right)�)'''
	
	def dispatch compileExpression(Invert op) '''
	�IF op.expression != null� (-(�compileExpression(op.expression)�)) �ENDIF�''' 
	
	def dispatch compileExpression(Factorial op) '''
	�IF op.expression != null� (�compileExpression(op.expression)�)! �ENDIF�'''  
	
	def dispatch compileExpression(Interval op) '''
	�IF op.ceil != null && op.floor != null��op.openingBracket�(�compileExpression(op.ceil)�)..(�compileExpression(op.floor)�)�op.closingBracket��ENDIF�'''  
	
	def dispatch compileExpression(Exponent op) '''
		(�compileExpression(op.left)�) ^ (�compileExpression(op.right)�)'''
}