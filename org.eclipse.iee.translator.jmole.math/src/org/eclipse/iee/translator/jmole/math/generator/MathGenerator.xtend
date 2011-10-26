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
		var formulas = resource.allContentsIterable.filter(typeof(Formula));
		
		if (formulas.empty) {
			return null;
		}
		
		return formulas.head.compileFormula.toString();	
	}
	
	def compileFormula(Formula f) 
	{
	'''
		«compileExpression(f.expression)»
	'''
	}
	
	def compileFunction(Function f) '''
		«f.function.name.substring(0,1).toUpperCase()+ 
		f.function.name.substring(1).toLowerCase()»
		(«IF f.function.formula != null»«compileFormula(f.function.formula)»«ENDIF»)
	'''
		
	def dispatch compileExpression(Variable n) '''
		«n.name»'''
	
	def dispatch compileExpression(Float n) '''
		«n.value»'''
		
	def dispatch compileExpression(Function f) '''
		«compileFunction(f)»'''
	
	def dispatch compileExpression(Addition op) '''
		(«compileExpression(op.left)») + («compileExpression(op.right)»)'''
	
	def dispatch compileExpression(Subtraction op) '''
		(«compileExpression(op.left)») - («compileExpression(op.right)»)'''
	
	def dispatch compileExpression(Multiplication op) '''
		(«compileExpression(op.left)») * («compileExpression(op.right)»)'''
	
	def dispatch compileExpression(Division op) '''
		(«compileExpression(op.left)») / («compileExpression(op.right)»)'''
	
	def dispatch compileExpression(Power op) '''
		(«compileExpression(op.left)») ^ («compileExpression(op.right)»)'''
}