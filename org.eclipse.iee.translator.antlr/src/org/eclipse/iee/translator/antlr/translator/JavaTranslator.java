package org.eclipse.iee.translator.antlr.translator;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.iee.translator.antlr.math.MathBaseVisitor;
import org.eclipse.iee.translator.antlr.math.MathLexer;
import org.eclipse.iee.translator.antlr.math.MathParser;
import org.eclipse.jdt.core.ICompilationUnit;

public class JavaTranslator {

	private static class JavaMathVisitor extends MathBaseVisitor<String> {
		// statement rule

		public String visitFunctionDefinition(
				MathParser.FunctionDefinitionContext ctx) {
			return visitChildren(ctx);
		}

		public String visitVariableAssignment(
				MathParser.VariableAssignmentContext ctx) {
			return visitChildren(ctx);
		}

		public String visitLogicComparison(MathParser.LogicComparisonContext ctx) {
			return visitChildren(ctx);
		}

		public String visitFunction(MathParser.FunctionContext ctx) {
			return visitChildren(ctx);
		}

		public String visitAdd(MathParser.AddContext ctx) {
			return visitChildren(ctx);
		}

		public String visitMult(MathParser.MultContext ctx) {
			return visitChildren(ctx);
		}

		public String visitPrimaryExpr(MathParser.PrimaryExprContext ctx) {
			return visitChildren(ctx);
		}

		public String visitPower(MathParser.PowerContext ctx) {
			return visitChildren(ctx);
		}

		public String visitMatrix(MathParser.MatrixContext ctx) {
			return visitChildren(ctx);
		}

		public String visitLogicMult(MathParser.LogicMultContext ctx) {
			return visitChildren(ctx);
		}

		public String visitLogicBrackets(MathParser.LogicBracketsContext ctx) {
			return '(' + visit(ctx.expr) + ')';
		}

		public String visitLogicAdd(MathParser.LogicAddContext ctx) {
			return visitChildren(ctx);
		}

		public String visitUnary(MathParser.UnaryContext ctx) {
			return visitChildren(ctx);
		}

		public String visitExprBrackets(MathParser.ExprBracketsContext ctx) {
			return '(' + visit(ctx.bracketedExpr) + ')';
		}

		public String visitMatrixRow(MathParser.MatrixRowContext ctx) {
			return visitChildren(ctx);
		}

		// primary rule

		public String visitVariable(MathParser.VariableContext ctx) {
			return ctx.getText();
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
			return ctx.objName.getText() + "." + visitFunction(ctx.objFunction);
		}

		public String visitProperty(MathParser.PropertyContext ctx) {
			return ctx.objName.getText() + "." + ctx.objProperty.getText();
		}

		public String visitTransposeMatrix(MathParser.TransposeMatrixContext ctx) {
			return visitChildren(ctx);
		}
	}

	public static String translate(String expression) {
		String result = "";

		return result;
	}

	public static String translate(ICompilationUnit compilationUnit,
			String expression, int position) {
		String result = "";

		ANTLRInputStream input = new ANTLRInputStream(expression);
		MathLexer lexer = new MathLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MathParser parser = new MathParser(tokens);
		parser.setBuildParseTree(true);
		ParserRuleContext tree = parser.statement();

		JavaMathVisitor mathVisitor = new JavaMathVisitor();
		result = mathVisitor.visit(tree);

		return result;
	}

}
