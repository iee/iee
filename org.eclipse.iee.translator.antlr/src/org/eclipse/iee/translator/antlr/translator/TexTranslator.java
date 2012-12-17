package org.eclipse.iee.translator.antlr.translator;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.iee.translator.antlr.math.MathBaseVisitor;
import org.eclipse.iee.translator.antlr.math.MathLexer;
import org.eclipse.iee.translator.antlr.math.MathParser;

public class TexTranslator {

	private static class TexMathVisitor extends MathBaseVisitor<String> {

		// statement rule

		public String visitFunctionDefinition(
				MathParser.FunctionDefinitionContext ctx) {
			return visitFunction(ctx.name) + "=" + visit(ctx.value);
		}

		public String visitVariableAssignment(
				MathParser.VariableAssignmentContext ctx) {
			return visit(ctx.name) + "=" + visit(ctx.value);
		}

		public String visitLogicComparison(MathParser.LogicComparisonContext ctx) {
			if (ctx.sign.getText().matches(">="))
				return visit(ctx.left) + "\\ge" + visit(ctx.right);
			if (ctx.sign.getText().matches("<="))
				return visit(ctx.left) + "\\le" + visit(ctx.right);
			if (ctx.sign.getText().matches(">"))
				return visit(ctx.left) + ">" + visit(ctx.right);
			if (ctx.sign.getText().matches("<"))
				return visit(ctx.left) + "<" + visit(ctx.right);
			if (ctx.sign.getText().matches("!="))
				return visit(ctx.left) + "\\ne" + visit(ctx.right);
			if (ctx.sign.getText().matches("=="))
				return visit(ctx.left) + "==" + visit(ctx.right);
			
			return visitChildren(ctx);
		}

		public String visitFunction(MathParser.FunctionContext ctx) {
			return visitChildren(ctx);
		}

		public String visitAdd(MathParser.AddContext ctx) {
			return visit(ctx.left) + ctx.sign.getText() + visit(ctx.right);
		}

		public String visitMult(MathParser.MultContext ctx) {
			if (ctx.sign.getText().matches("*"))
				return visit(ctx.left) + "*" + visit(ctx.right);
			if (ctx.sign.getText().matches("/"))
				return "\\frac{" + visit(ctx.left) + "}{" +  visit(ctx.right) + "}";
			if (ctx.sign.getText().matches("%"))
				return visit(ctx.left) + "\\mod" + visit(ctx.right);
			
			return visitChildren(ctx);
		}

		public String visitPrimaryExpr(MathParser.PrimaryExprContext ctx) {
			return visitChildren(ctx);
		}

		public String visitPower(MathParser.PowerContext ctx) {
			return visit(ctx.left) + "^{" + visit(ctx.right) + "}";
		}

		public String visitMatrix(MathParser.MatrixContext ctx) {
			return visitChildren(ctx);
		}

		public String visitLogicMult(MathParser.LogicMultContext ctx) {
			return visit(ctx.left) + "\\wedge" + visit(ctx.right);
		}

		public String visitLogicBrackets(MathParser.LogicBracketsContext ctx) {
			return '(' + visit(ctx.expr) + ')';
		}

		public String visitLogicAdd(MathParser.LogicAddContext ctx) {
			return visit(ctx.left) + "\\vee" + visit(ctx.right);
		}

		public String visitUnary(MathParser.UnaryContext ctx) {
			return ctx.sign.getText() + visit(ctx.unaryExpr);
		}

		public String visitExprBrackets(MathParser.ExprBracketsContext ctx) {
			return '(' + visit(ctx.bracketedExpr) + ')';
		}

		public String visitMatrixRow(MathParser.MatrixRowContext ctx) {
			return visitChildren(ctx);
		}

		// primary rule

		public String visitVariable(MathParser.VariableContext ctx) {
			return translateName(ctx.getText());
		}

		public String visitFloatNumber(MathParser.FloatNumberContext ctx) {
			return ctx.getText();
		}

		public String visitIntNumber(MathParser.IntNumberContext ctx) {
			return ctx.getText();
		}

		public String visitMatrixDefinition(
				MathParser.MatrixDefinitionContext ctx) {
			return visitChildren(ctx);
		}

		public String visitMatrixElement(MathParser.MatrixElementContext ctx) {
			return visitChildren(ctx);
		}

		public String visitPrimaryFunction(MathParser.PrimaryFunctionContext ctx) {
			return visitFunction(ctx.function());
		}

		public String visitMethodCall(MathParser.MethodCallContext ctx) {
			return translateName(ctx.objName.getText()) + "."
					+ visitFunction(ctx.objFunction);
		}

		public String visitProperty(MathParser.PropertyContext ctx) {
			return translateName(ctx.objName.getText()) + "."
					+ translateName(ctx.objProperty.getText());
		}

		public String visitTransposeMatrix(MathParser.TransposeMatrixContext ctx) {
			return visitChildren(ctx);
		}

	}

	public static String translate(String expression) {
		String result = "";

		ANTLRInputStream input = new ANTLRInputStream(expression);
		MathLexer lexer = new MathLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MathParser parser = new MathParser(tokens);
		parser.setBuildParseTree(true);
		ParserRuleContext tree = parser.statement();

		TexMathVisitor mathVisitor = new TexMathVisitor();
		result = mathVisitor.visit(tree);

		return result;
	}

	private static String translateName(String name) {
		// TODO: add greek letters support
		return name;
	}

}
