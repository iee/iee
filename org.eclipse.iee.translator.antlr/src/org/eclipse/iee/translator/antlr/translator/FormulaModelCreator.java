package org.eclipse.iee.translator.antlr.translator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.eclipse.iee.translator.antlr.math.MathBaseVisitor;
import org.eclipse.iee.translator.antlr.math.MathParser;
import org.eclipse.iee.translator.antlr.math.MathParser.AddContext;
import org.eclipse.iee.translator.antlr.math.MathParser.BitwiseAddContext;
import org.eclipse.iee.translator.antlr.math.MathParser.ExprBracketsContext;
import org.eclipse.iee.translator.antlr.math.MathParser.ExpressionContext;
import org.eclipse.iee.translator.antlr.math.MathParser.IntervalParameterContext;
import org.eclipse.iee.translator.antlr.math.MathParser.MatrixElementContext;
import org.eclipse.iee.translator.antlr.math.MathParser.MatrixRowContext;
import org.eclipse.iee.translator.antlr.math.MathParser.MultContext;
import org.eclipse.iee.translator.antlr.math.MathParser.PowerContext;
import org.eclipse.iee.translator.antlr.math.MathParser.PrimaryExprContext;
import org.eclipse.iee.translator.antlr.math.MathParser.StandardFunctionContext;
import org.eclipse.iee.translator.antlr.math.MathParser.VariableAssignmentContext;
import org.eclipse.iee.translator.antlr.math.MathParser.VariableContext;
import org.eclipse.iee.translator.antlr.translator.model.BinaryExpression;
import org.eclipse.iee.translator.antlr.translator.model.BracketsExpression;
import org.eclipse.iee.translator.antlr.translator.model.Expression;
import org.eclipse.iee.translator.antlr.translator.model.FunctionExpression;
import org.eclipse.iee.translator.antlr.translator.model.IdentifierExpression;
import org.eclipse.iee.translator.antlr.translator.model.IndexExpression;
import org.eclipse.iee.translator.antlr.translator.model.NaryExpression;
import org.eclipse.iee.translator.antlr.translator.model.VariableAssignment;

public class FormulaModelCreator extends MathBaseVisitor<Expression> {
	
	@Override
	public Expression visitVariable(VariableContext ctx) {
		IdentifierExpression expression = new IdentifierExpression(ctx.getText());
		return expression;
	}
	
	@Override
	public Expression visitPower(PowerContext ctx) {
		BinaryExpression expression = new BinaryExpression(visit(ctx.left), "^", visit(ctx.right));
		return expression;
	}
	
	@Override
	public Expression visitVariableAssignment(VariableAssignmentContext ctx) {
		BinaryExpression expression = new BinaryExpression(visit(ctx.name), "=", visit(ctx.value));
		return expression;
	}
	
	@Override
	public Expression visitPrimaryExpr(PrimaryExprContext ctx) {
		IdentifierExpression expression = new IdentifierExpression(ctx.getText());
		return expression;
	}
	
	@Override
	public Expression visitAdd(AddContext ctx) {
		BinaryExpression expression = new BinaryExpression(visit(ctx.left), ctx.sign.getText(), visit(ctx.right));
		return expression;
	}

	@Override
	public Expression visitMult(MultContext ctx) {
		BinaryExpression expression = new BinaryExpression(visit(ctx.left), ctx.sign.getText(), visit(ctx.right));
		return expression;
	}

	@Override
	public Expression visitStandardFunction(StandardFunctionContext ctx) {
		List<Expression> lst = new ArrayList<>();
		for (ExpressionContext expression : ctx.params) {
			lst.add(visit(expression));
		}
		FunctionExpression expression = new FunctionExpression(ctx.name.getText(), lst);
		return expression;
	}
	
	@Override
	public Expression visitExprBrackets(ExprBracketsContext ctx) {
		BracketsExpression expression = new BracketsExpression(visit(ctx.bracketedExpr));
		return expression;
	}
	
	@Override
	public Expression visitErrorNode(ErrorNode node) {
		IdentifierExpression expression = new IdentifierExpression("!!!" + node.getText() + "!!!");
		return expression;
	}
	
	public Expression visitInternalFunction(MathParser.InternalFunctionContext ctx) {
		Expression expression;

		switch (ctx.name.getText()) {
		case "Integrate":
			expression = new IdentifierExpression("Integrate");
//			for (int i = ctx.params.size() - 1; i >= 0; i--) {
//				function += "\\int_";
//
//				IntervalParameterContext paramCtx = (IntervalParameterContext) ctx.params
//						.get(i);
//				function += "{" + visit(paramCtx.min) + "}";
//				function += "^{" + visit(paramCtx.max) + "}";
//
//			}
//			function += "(" + visit(ctx.func) + ")" + "\\,";n
//
//			for (int i = 0; i < ctx.params.size(); i++) {
//				function += "d";
//
//				IntervalParameterContext paramCtx = (IntervalParameterContext) ctx.params
//						.get(i);
//				function += paramCtx.variable.getText();
//
//				if (i < ctx.params.size() - 1)
//					function += "\\,";
//			}
//
			break;
		case "Sum":
			String s = "\u2211";
			expression = createMathSymbol(ctx, s);
			break;
		case "Diff":
			expression = new IdentifierExpression("Diff");
//			ValueParameterContext valueParamCtx = (ValueParameterContext) ctx.params
//					.get(0);
//			function += "\\frac{d}{d" + valueParamCtx.variable.getText()
//					+ "}";
//
//			function += "(" + visit(ctx.func) + ")";
			break;
		case "Product":
			expression = createMathSymbol(ctx, "\u220f");
			break;
		case "Sqrt":
			expression = new IdentifierExpression("Sqrt");
//			function += "\\sqrt{" + visit(ctx.func) + "}";
			break;
		default:
			expression = new IdentifierExpression("Default");
		}
		return expression;
	}
	
	private Expression createMathSymbol(MathParser.InternalFunctionContext ctx, String s) {
		List<VariableAssignment> variables = new ArrayList<>();
		for (int i = ctx.params.size() - 1; i >= 0; i--) {
			IntervalParameterContext paramCtx = (IntervalParameterContext) ctx.params.get(i);
			variables.add(new VariableAssignment(paramCtx.variable.getText(), visit(paramCtx.min), visit(paramCtx.max)));
		}
		NaryExpression expression = new NaryExpression(s, variables, visit(ctx.func));
		return expression;
	}
	
//	@Override
//	public Expression visitChildren(RuleNode node) {
//		if (node instanceof ParserRuleContext) {
//			RecognitionException exception = ((ParserRuleContext) node).exception;
//			if (exception != null) { 
//				Figure figure = createTextFigure(exception.getOffendingToken().getText());
//				figure.setBorder(new LineBorder(renderCtx.getErrorColor()));
//				return figure;
//			}
//		}
//		return super.visitChildren(node);
//	}
	
	@Override
	public Expression visitMatrixElement(MatrixElementContext ctx) {
		IndexExpression expression = new IndexExpression(new IndexExpression(visit(ctx.container), visit(ctx.rowId)), visit(ctx.columnId));
		return expression;
	}
	
	@Override
	public Expression visitMatrixRow(MatrixRowContext ctx) {
		IndexExpression expression = new IndexExpression(visit(ctx.container), visit(ctx.rowId));
		return expression;
	}
	
	@Override
	public Expression visitBitwiseAdd(BitwiseAddContext ctx) {
		BinaryExpression expression = new BinaryExpression(visit(ctx.left), "&", visit(ctx.right));
		return expression;
	}
	
	
}
