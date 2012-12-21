package org.eclipse.iee.translator.antlr.translator;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.iee.translator.antlr.math.MathBaseVisitor;
import org.eclipse.iee.translator.antlr.math.MathLexer;
import org.eclipse.iee.translator.antlr.math.MathParser;
import org.eclipse.iee.translator.antlr.math.MathParser.MatrixContext;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.ISourceRange;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;

public class JavaTranslator {

	private static IType fClass;

	private static class JavaMathVisitor extends MathBaseVisitor<String> {
		// statement rule

		/*
		 * Help variables
		 */
		
		Boolean fVisitVariableName = false;
		Boolean fVisitedMatrixElement = false;
		Boolean fNewMatrix = false;

		public String visitFunctionDefinition(
				MathParser.FunctionDefinitionContext ctx) {
			String functionDef = "";

			functionDef += "public static double " + ctx.name.name.getText();
			functionDef += "(";

			for (int i = 0; i < ctx.name.params.size(); i++) {
				functionDef += "double " + visit(ctx.name.params.get(i));
				if (i != ctx.name.params.size() - 1)
					functionDef += ",";
			}

			functionDef += ")";
			functionDef += "{ return " + visit(ctx.value) + "; }";

			return functionDef;
		}

		public String visitVariableAssignment(
				MathParser.VariableAssignmentContext ctx) {

			fVisitVariableName = true;
			String name = visit(ctx.name);
			fVisitVariableName = false;
			
			String value = visit(ctx.value);

			if (fVisitedMatrixElement)
			{
				return name += value + ");";
			}

			if (fClass == null)
				return name + "=" + value + ";";

			String assignment = "";

			IField field = fClass.getField(visit(ctx.name));
			
			if (field != null)
				assignment += name + "=" + value + ";";
			else {
				if (fNewMatrix)
					assignment += "Matrix ";
				else
					assignment += "double ";
				assignment += name + "=" + value + ";";
			}

			return assignment;
		}

		public String visitLogicComparison(MathParser.LogicComparisonContext ctx) {
			String left = visit(ctx.left);
			String right = visit(ctx.right);

			return left + ctx.sign.getText() + right;
		}

		public String visitFunction(MathParser.FunctionContext ctx) {
			String function = "";
			function += ctx.name.getText();
			function += "(";

			for (int i = 0; i < ctx.params.size(); i++) {
				function += visit(ctx.params.get(i));
				if (i != ctx.params.size() - 1)
					function += ",";
			}

			function += ")";

			return function;
		}

		public String visitAdd(MathParser.AddContext ctx) {
			String left = visit(ctx.left);
			String right = visit(ctx.right);

			return "(" + left + ")" + ctx.sign.getText() + "(" + right + ")";
		}

		public String visitMult(MathParser.MultContext ctx) {
			String left = visit(ctx.left);
			String right = visit(ctx.right);

			return "(" + left + ")" + ctx.sign.getText() + "(" + right + ")";
		}

		public String visitPrimaryExpr(MathParser.PrimaryExprContext ctx) {
			return visitChildren(ctx);
		}

		public String visitPower(MathParser.PowerContext ctx) {
			String left = visit(ctx.left);
			String right = visit(ctx.right);

			return "Math.pow((" + left + "),(" + right + "))";
		}

		public String visitMatrix(MathParser.MatrixContext ctx) {

			fNewMatrix = true;
			
			String matrix = "";
			int i;

			matrix += "new Matrix(new double[][]{";
			int rowsCount = ctx.rows.size();

			for (i = 0; i < rowsCount; i++) {
				matrix += visitMatrixRow(ctx.rows.get(i));
				if (i != rowsCount - 1)
					matrix += ",";
			}

			matrix += "})";

			return matrix;
		}

		public String visitLogicMult(MathParser.LogicMultContext ctx) {
			String left = visit(ctx.left);
			String right = visit(ctx.right);

			return left + " && " + right;
		}

		public String visitLogicBrackets(MathParser.LogicBracketsContext ctx) {
			return '(' + visit(ctx.expr) + ')';
		}

		public String visitLogicAdd(MathParser.LogicAddContext ctx) {
			String left = visit(ctx.left);
			String right = visit(ctx.right);

			return left + " || " + right;
		}

		public String visitUnary(MathParser.UnaryContext ctx) {
			return "(" + ctx.sign.getText() + visit(ctx.unaryExpr) + ")";
		}

		public String visitExprBrackets(MathParser.ExprBracketsContext ctx) {
			return '(' + visit(ctx.bracketedExpr) + ')';
		}

		public String visitMatrixRow(MathParser.MatrixRowContext ctx) {
			String row = "";
			row += "{";

			for (int i = 0; i < ctx.elements.size(); i++) {
				row += visit(ctx.elements.get(i));
				if (i != ctx.elements.size() - 1)
					row += ",";
			}

			row += "}";

			return row;
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
			
			if (fVisitVariableName)
			{
				fVisitedMatrixElement = true;
				return ctx.name.getText() + ".set(" + visit(ctx.rowIdx) + ","
						+ visit(ctx.columnIdx) + ",";
			}
			else
				return ctx.name.getText() + ".get(" + visit(ctx.rowIdx) + ","
						+ visit(ctx.columnIdx) + ")";
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

	}

	public static String translate(String expression) {
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

	public static String translate(String expression, ICompilationUnit compilationUnit,
			int position) {
		String result = "";

		try {
			IType[] types = compilationUnit.getTypes();
			for (int i = 0; i < types.length; i++) {
				IType type = types[i];
				if (type.isClass()) {
					ISourceRange classSourceRange = type.getSourceRange();
					int classOffset = classSourceRange.getOffset();
					if (position > classOffset
							&& position <= (classOffset + classSourceRange
									.getLength()))
						fClass = type;
				}
			}
		} catch (JavaModelException e) {
			e.printStackTrace();
		}

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
