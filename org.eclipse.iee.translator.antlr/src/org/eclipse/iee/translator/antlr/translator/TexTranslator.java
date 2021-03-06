package org.eclipse.iee.translator.antlr.translator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.eclipse.iee.translator.antlr.math.MathBaseVisitor;
import org.eclipse.iee.translator.antlr.math.MathLexer;
import org.eclipse.iee.translator.antlr.math.MathParser;
import org.eclipse.iee.translator.antlr.math.MathParser.IntervalParameterContext;
import org.eclipse.iee.translator.antlr.math.MathParser.MatrixElementContext;
import org.eclipse.iee.translator.antlr.math.MathParser.MatrixRowContext;
import org.eclipse.iee.translator.antlr.math.MathParser.ValueParameterContext;
import org.eclipse.iee.translator.antlr.math.MathParser.VectorContext;

import com.google.common.base.Joiner;

public class TexTranslator {

	private static List<String> fGreekLetters = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;
		{
			add("alpha");
			add("beta");
			add("delta");
			add("epsilon");
			add("varepsilon");
			add("zeta");
			add("eta");
			add("theta");
			add("vartheta");
			add("gamma");
			add("kappa");
			add("lambda");
			add("pi");
			add("mu");
			add("nu");
			add("xi");
			add("varpi");
			add("rho");
			add("varrho");
			add("sigma");
			add("varsigma");
			add("tau");
			add("upsilon");
			add("phi");
			add("varphi");
			add("chi");
			add("psi");
			add("omega");
			add("Gamma");
			add("Delta");
			add("Theta");
			add("Lambda");
			add("Xi");
			add("Pi");
			add("Sigma");
			add("Upsilon");
			add("Phi");
			add("Psi");
			add("Omega");
		}
	};

	private static class TexMathVisitor extends MathBaseVisitor<String> {

		// statement rule

		public String visitFunctionDefinition(
				MathParser.FunctionDefinitionContext ctx) {
			return visitStandardFunction(ctx.name) + "=" + visit(ctx.value);
		}

		public String visitVariableAssignment(MathParser.VariableAssignmentContext ctx) {
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

		public String visitStandardFunction(
				MathParser.StandardFunctionContext ctx) {
			String function = "";
			function += translateName(ctx.name.getText());
			function += "(";

			for (int i = 0; i < ctx.params.size(); i++) {
				function += visit(ctx.params.get(i));
				if (i != ctx.params.size() - 1)
					function += ",";
			}

			function += ")";

			return function;
		}

		public String visitInternalFunction(
				MathParser.InternalFunctionContext ctx) {
			String function = "";

			switch (ctx.name.getText()) {
			case "Integrate":
				for (int i = ctx.params.size() - 1; i >= 0; i--) {
					function += "\\int_";

					IntervalParameterContext paramCtx = (IntervalParameterContext) ctx.params
							.get(i);
					function += "{" + visit(paramCtx.min) + "}";
					function += "^{" + visit(paramCtx.max) + "}";

				}
				function += "(" + visit(ctx.func) + ")" + "\\,";

				for (int i = 0; i < ctx.params.size(); i++) {
					function += "d";

					IntervalParameterContext paramCtx = (IntervalParameterContext) ctx.params
							.get(i);
					function += paramCtx.variable.getText();

					if (i < ctx.params.size() - 1)
						function += "\\,";
				}

				break;
			case "Sum":
				for (int i = ctx.params.size() - 1; i >= 0; i--) {
					function += "\\sum_";

					IntervalParameterContext paramCtx = (IntervalParameterContext) ctx.params
							.get(i);
					function += "{" + paramCtx.variable.getText() + "="
							+ visit(paramCtx.min) + "}";
					function += "^{" + visit(paramCtx.max) + "}";

				}
				function += "(" + visit(ctx.func) + ")";
				break;
			case "Diff":
				ValueParameterContext valueParamCtx = (ValueParameterContext) ctx.params
						.get(0);
				function += "\\frac{d}{d" + valueParamCtx.variable.getText()
						+ "}";

				function += "(" + visit(ctx.func) + ")";
				break;
			case "Product":
				for (int i = ctx.params.size() - 1; i >= 0; i--) {
					function += "\\prod_";

					IntervalParameterContext paramCtx = (IntervalParameterContext) ctx.params
							.get(i);
					function += "{" + paramCtx.variable.getText() + "="
							+ visit(paramCtx.min) + "}";
					function += "^{" + visit(paramCtx.max) + "}";

				}
				function += "(" + visit(ctx.func) + ")";
				break;
			case "Sqrt":
				function += "\\sqrt{" + visit(ctx.func) + "}";
				break;
			}

			return function;
		}

		public String visitAdd(MathParser.AddContext ctx) {
			return visit(ctx.left) + ctx.sign.getText() + visit(ctx.right);
		}

		public String visitShift(MathParser.ShiftContext ctx) {
			return visit(ctx.left) + ctx.sign.getText() + visit(ctx.right);
		}

		public String visitBitwiseAdd(MathParser.BitwiseAddContext ctx) {
			return visit(ctx.left) + "\\&" + visit(ctx.right);
		}

		public String visitBitwiseOr(MathParser.BitwiseOrContext ctx) {
			return visit(ctx.left) + "|" + visit(ctx.right);
		}

		public String visitXor(MathParser.XorContext ctx) {
			return visit(ctx.left) + "\\oplus " + visit(ctx.right);
		}

		public String visitMult(MathParser.MultContext ctx) {
			if (ctx.sign.getText().matches("\\*"))
				return visit(ctx.left) + "*" + visit(ctx.right);
			if (ctx.sign.getText().matches("/")) {

				return "\\frac{" + removeRoundBrackets(visit(ctx.left)) + "}{"
						+ removeRoundBrackets(visit(ctx.right)) + "}";
			}
			if (ctx.sign.getText().matches("%"))
				return visit(ctx.left) + " \\mod " + visit(ctx.right);

			return visitChildren(ctx);
		}

		public String visitPrimaryExpr(MathParser.PrimaryExprContext ctx) {
			return visitChildren(ctx);
		}

		public String visitPower(MathParser.PowerContext ctx) {
			return visit(ctx.left) + "^{" + visit(ctx.right) + "}";
		}

		public String visitMatrix(MathParser.MatrixContext ctx) {
			String matrix = "";
			int i;

			matrix += "$$\\left(\\begin{array}{";
			int rowsCount = ctx.rows.size();
			for (i = 0; i < rowsCount; i++)
				matrix += "c";
			matrix += "}";
			for (i = 0; i < rowsCount; i++) {
				matrix += visitVector(ctx.rows.get(i));
				if (i != rowsCount - 1)
					matrix += "\\\\";
			}

			matrix += "\\end{array}\\right)$$";

			return matrix;
		}

		public String visitLogicMult(MathParser.LogicMultContext ctx) {
			return visit(ctx.left) + " \\wedge " + visit(ctx.right);
		}

		public String visitLogicBrackets(MathParser.LogicBracketsContext ctx) {
			return '(' + visit(ctx.expr) + ')';
		}

		public String visitLogicAdd(MathParser.LogicAddContext ctx) {
			return visit(ctx.left) + " \\vee " + visit(ctx.right);
		}

		public String visitUnary(MathParser.UnaryContext ctx) {
			return ctx.sign.getText() + visit(ctx.unaryExpr);
		}

		public String visitExprBrackets(MathParser.ExprBracketsContext ctx) {
			return '(' + visit(ctx.bracketedExpr) + ')';
		}

		public String visitVector(VectorContext ctx) {
			String row = "";

			for (int i = 0; i < ctx.elements.size(); i++) {
				row += visit(ctx.elements.get(i));
				if (i != ctx.elements.size() - 1)
					row += "&";
			}

			return row;
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
		
		

		@Override
		public String visitMatrixRow(MatrixRowContext ctx) {
			StringBuilder sb = new StringBuilder(translateName(ctx.container.getText()));
			sb.append("_{").append(visit(ctx.rowId)).append("}");
			return sb.toString();
		}
		
		
		@Override
		public String visitMatrixElement(MatrixElementContext ctx) {
			StringBuilder sb = new StringBuilder(translateName(ctx.container.getText()));
			sb.append("_{").append(visit(ctx.rowId)).append(",").append(visit(ctx.columnId)).append("}");
			return sb.toString();
		}
		
		public String visitMethodCall(MathParser.MethodCallContext ctx) {
			return translateName(ctx.container.getText()) + "."
					+ visitStandardFunction(ctx.func);
		}

		public String visitProperty(MathParser.PropertyContext ctx) {
			return translateName(ctx.container.getText()) + "."
					+ translateName(ctx.property.getText());
		}

		@Override
		public String visitErrorNode(ErrorNode node) {
			return node.getText();
		}
		
		@Override
		protected String aggregateResult(String aggregate, String nextResult) {
			return Joiner.on("").skipNulls().join(aggregate, nextResult);
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
		String translatedName = name;

		for (int i = 0; i < fGreekLetters.size(); i++) {
			translatedName = replaceGreekLetter(translatedName,
					fGreekLetters.get(i));
		}

		return translatedName;
	}

	private static String replaceGreekLetter(String name, String letter) {
		String translatedName = "";
		int beginIndex = 0;
		int start = 0;
		int end = 0;

		int length = name.length();

		Pattern p = Pattern.compile(letter);

		Matcher m = p.matcher(name);

		while (m.find()) {
			start = m.start();
			end = m.end();

			translatedName += name.substring(beginIndex, start);
			if (start == 0) {
				if (end == length) {

					translatedName += "\\";
				} else {
					if (name.substring(end, end + 1).matches("[_]"))
						translatedName += "\\";
				}
			} else {
				if (end == length) {
					if (name.substring(start - 1, start).matches("[_]"))
						translatedName += "\\";
				} else {
					if (name.substring(start - 1, start).matches("[_]")
							&& name.substring(end, end + 1).matches("[_]"))
						translatedName += "\\";
				}
			}

			translatedName += letter;
			beginIndex = end;
		}

		if (end != length)
			translatedName += name.substring(end, length);

		return translatedName;

	}

	private static String removeRoundBrackets(String input) {
		String result = input.trim();

		if (result.charAt(0) == '('
				&& result.charAt(result.length() - 1) == ')') {
			result = result.substring(1, result.length() - 1);
		}

		return result;
	}
}
