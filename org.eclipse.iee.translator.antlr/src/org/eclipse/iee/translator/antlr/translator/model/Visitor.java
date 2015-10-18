package org.eclipse.iee.translator.antlr.translator.model;

public interface Visitor<R, C> {

	R visitBinaryExpression(BinaryExpression expression, C context);

	R acceptFunctionExpression(FunctionExpression expression, C context);

	R acceptIdentifierExpression(IdentifierExpression expression, C context);

	R acceptIndexExpression(IndexExpression expression, C context);

	R acceptNaryExpression(NaryExpression expression, C context);

	R acceptVariableAssignment(VariableAssignment expression, C context);

	R visitBracketsExpression(BracketsExpression bracketsExpression, C context);

}