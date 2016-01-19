package org.eclipse.iee.translator.antlr.translator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.iee.core.document.source.IVariableType;
import org.eclipse.iee.core.document.source.VariableType;
import org.eclipse.iee.translator.antlr.math.MathBaseVisitor;
import org.eclipse.iee.translator.antlr.math.MathParser;
import org.eclipse.iee.translator.antlr.math.MathParser.IntervalParameterContext;
import org.eclipse.iee.translator.antlr.math.MathParser.MatrixElementContext;
import org.eclipse.iee.translator.antlr.math.MathParser.MatrixRowContext;
import org.eclipse.iee.translator.antlr.math.MathParser.PrimaryFunctionsContext;
import org.eclipse.iee.translator.antlr.math.MathParser.ValueParameterContext;
import org.eclipse.iee.translator.antlr.math.MathParser.VectorContext;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;

class JavaMathVisitor extends MathBaseVisitor<String> {
	// statement rule

	/*
	 * Help variables
	 */
	private boolean fFunctionDefinition;
	private List<String> fDeterminedFunctionParams = new ArrayList<>();
	private List<String> fDeterminedFunctionVariables = new ArrayList<>();
	
	private List<String> fFoundedVariables = new ArrayList<>();
	private List<String> fInternalFunctionsParams = new ArrayList<>();

	private ExternalTranslationContext fExternalContext;
	private TypeVisitior fTypeVisitor; 
	
	public JavaMathVisitor(ExternalTranslationContext externalContext, TypeVisitior typeVisitior) {
		fExternalContext = externalContext;
		fTypeVisitor = typeVisitior;
	}

	public String visitFunctionDefinition(
			MathParser.FunctionDefinitionContext ctx) {

		fFunctionDefinition = true;

		String name = JavaTranslator.translateName(ctx.name.name.getText());
		name = JavaTranslator.firstLetterUpperCase(name);

		for (int i = 0; i < ctx.name.params.size(); i++) {
			String param = visit(ctx.name.params.get(i));
			fDeterminedFunctionParams.add(param);
		}

		fDeterminedFunctionVariables.clear();

		String value = visit(ctx.value);

		for (int i = 0; i < fInternalFunctionsParams.size(); i++) {
			String param = fInternalFunctionsParams.get(i);
			if (fDeterminedFunctionVariables.contains(param))
				fDeterminedFunctionVariables.remove(param);
		}

		JavaTranslator.logger.debug("funcDef DeterminedFunctionVariables: "
				+ fDeterminedFunctionVariables.toString());

		STGroup group = JavaTranslator.createSTGroup();
		ST template = group.getInstanceOf("function");
		template.add("name", name);
		template.add("params", fDeterminedFunctionParams);
		template.add("value", value);
		template.add("variables", fDeterminedFunctionVariables);

		return template.render(1).trim().replaceAll("\r\n", "")
				.replaceAll("\t", " ");

	}

	public String visitVariableAssignment(
			MathParser.VariableAssignmentContext ctx) {

		String value = visit(ctx.value);
		
		if (ctx.name instanceof MatrixElementContext) {
			MatrixElementContext elt = (MatrixElementContext) ctx.name;
			String rowIndex = visit(elt.rowId).replaceAll("\\.0", "");
			String columnIndex = visit(elt.columnId).replaceAll("\\.0", "");
			return JavaTranslator.translateName(elt.container.getText()) + ".set(" + rowIndex + "," + columnIndex + "," + value + ")";
		}
		
		String name = JavaTranslator.translateName(ctx.name.getText());
		
		String assignment = "";

		assignment += name + "=" + value;
		
		return assignment;
	}

	public String visitLogicComparison(MathParser.LogicComparisonContext ctx) {
		String left = visit(ctx.left);
		String right = visit(ctx.right);

		return left + ctx.sign.getText() + right;
	}

	public String visitFunction(MathParser.FunctionContext ctx) {
		return visitChildren(ctx);
	}

	public String visitStandardFunction(
			MathParser.StandardFunctionContext ctx) {

		String name = JavaTranslator.translateName(ctx.name.getText());

		String new_ = "";
		String name_ = "";
		List<String> fieldsNames = new ArrayList<>();
		List<String> params = new ArrayList<>();

		if (fExternalContext.containsMethod(name)) {
			new_ = "new ";
			name_ = JavaTranslator.firstLetterUpperCase(name);

			IType type = fExternalContext.getMethodType(name);
			try {
				IField[] fields = type.getFields();
				for (int i = 0; i < fields.length; i++) {
					IField field = fields[i];
					String fieldName = field.getElementName();
					if (!fieldsNames.contains(fieldName))
						fieldsNames.add(fieldName);
					if (!fFoundedVariables.contains(fieldName))
						fFoundedVariables.add(fieldName);
					if (fFunctionDefinition
							&& !fDeterminedFunctionVariables
									.contains(fieldName))
						fDeterminedFunctionVariables.add(fieldName);

				}
			} catch (JavaModelException e) {
				e.printStackTrace();
			}

		} else if (fExternalContext.containsClass(name)) {
			new_ = "this.new ";
			name_ = JavaTranslator.firstLetterUpperCase(name);

			IType type = fExternalContext.getClassType(name);
			try {
				IField[] fields = type.getFields();
				for (int i = 0; i < fields.length; i++) {
					IField field = fields[i];
					String fieldName = field.getElementName();
					if (!fieldsNames.contains(fieldName))
						fieldsNames.add(fieldName);
					if (!fFoundedVariables.contains(fieldName))
						fFoundedVariables.add(fieldName);
					if (fFunctionDefinition
							&& !fDeterminedFunctionVariables
									.contains(fieldName))
						fDeterminedFunctionVariables.add(fieldName);
				}
			} catch (JavaModelException e) {
				e.printStackTrace();
			}

		} else if (fExternalContext.containsOtherSourceClass(name)) {
			new_ = "new ";
			name_ = JavaTranslator.firstLetterUpperCase(name);

		} else
			name_ = JavaTranslator.translateName(ctx.name.getText());

		for (int i = 0; i < ctx.params.size(); i++) {
			params.add(visit(ctx.params.get(i)));
		}

		boolean isFunctionClass = true;
		if (new_.isEmpty())
			isFunctionClass = false;

		STGroup group = JavaTranslator.createSTGroup();
		ST template = group.getInstanceOf("functionCall");
		template.add("new", new_);
		template.add("name", name_);
		template.add("fields", fieldsNames);
		template.add("params", params);
		template.add("class", isFunctionClass);

		String function = template.render(1).trim().replaceAll("\r\n", "")
				.replaceAll("\t", " ");

		return function;
	}

	private List<String> getInternalFunctionVariables(
			MathParser.InternalFunctionContext ctx) {

		fFoundedVariables.clear();
		fInternalFunctionsParams.clear();
		visit(ctx.func);

		switch (ctx.name.getText()) {
		case "Sqrt":
		case "Diff":
			break;
		default:
			for (int i = 0; i < ctx.params.size(); i++) {
				IntervalParameterContext param = (IntervalParameterContext) ctx.params
						.get(i);
				visit(param.min);
				visit(param.max);
			}

		}

		return fFoundedVariables;
	}

	public String visitInternalFunction(
			MathParser.InternalFunctionContext ctx) {
		String function = "";

		JavaTranslator.logger.debug("Internal function: " + ctx.func.getText());

		List<String> internalFunctionVariables = getInternalFunctionVariables(ctx);
		List<String> internalFunctionParams = new ArrayList<>();

		String value = visit(ctx.func);

		List<String> params = new ArrayList<>();

		for (int i = 0; i < ctx.params.size(); i++) {
			if (ctx.params.get(i) instanceof ValueParameterContext) {
				ValueParameterContext param = (ValueParameterContext) ctx.params
						.get(i);
				params.add(param.variable.getText());
			} else if (ctx.params.get(i) instanceof IntervalParameterContext) {
				IntervalParameterContext param = (IntervalParameterContext) ctx.params
						.get(i);

				String paramVariable = param.variable.getText();
				params.add(paramVariable);

				if (!internalFunctionParams.contains(paramVariable))
					internalFunctionParams.add(paramVariable);
				if (!fInternalFunctionsParams.contains(paramVariable))
					fInternalFunctionsParams.add(paramVariable);

			}

		}

		List<String> variables = new ArrayList<>();

		for (int i = 0; i < internalFunctionVariables.size(); i++) {
			String variable = internalFunctionVariables.get(i);
			if (!fInternalFunctionsParams.contains(variable)
					&& !internalFunctionParams.contains(variable))
				variables.add(variable);
			if (params.size() > 1
					&& internalFunctionParams.contains(variable)
					&& !variable.matches(params.get(0)))
				variables.add(variable);
		}

		JavaTranslator.logger.debug("internalFunc FoundedVariables: "
				+ internalFunctionVariables.toString());
		JavaTranslator.logger.debug("internalFunc Variables: " + variables.toString());

		if (ctx.name.getText().matches("Sqrt")) {
			function = "Math.sqrt(" + value + ")";
		} else {
			STGroup group = JavaTranslator.createSTGroup();
			ST template = group.getInstanceOf("anonymousFunction");
			template.add("param", params.get(0));
			template.add("value", value);
			template.add("variables", variables);

			String anonymousFunction = template.render(1).trim()
					.replaceAll("\r\n", "").replaceAll("\t", " ");

			JavaTranslator.logger.debug("InternalFunc name: " + ctx.name.getText());

			switch (ctx.name.getText()) {
			case "Integrate":
				IntervalParameterContext integrateParam = (IntervalParameterContext) ctx.params
						.get(0);
				function += "integrate(" + anonymousFunction + ", "
						+ visit(integrateParam.min) + ","
						+ visit(integrateParam.max) + ")";

				if (ctx.params.size() > 1)
					for (int i = 1; i < ctx.params.size(); i++) {
						IntervalParameterContext param = (IntervalParameterContext) ctx.params
								.get(i);

						String variable = param.variable.getText();

						if (variables.contains(variable))
							variables.remove(variable);

						template = group.getInstanceOf("anonymousFunction");
						template.add("param", variable);
						template.add("value", function);
						template.add("variables", variables);
						anonymousFunction = template.render(1).trim()
								.replaceAll("\r\n", "")
								.replaceAll("\t", " ");

						function = "integrate(" + anonymousFunction;

						function += ", " + visit(param.min) + ","
								+ visit(param.max) + ")";

					}

				break;
			case "Sum":
				IntervalParameterContext sumParam = (IntervalParameterContext) ctx.params
						.get(0);
				function += "sum(" + anonymousFunction + ", "
						+ visit(sumParam.min) + "," + visit(sumParam.max)
						+ ")";

				if (ctx.params.size() > 1)
					for (int i = 1; i < ctx.params.size(); i++) {
						IntervalParameterContext param = (IntervalParameterContext) ctx.params
								.get(i);

						String variable = param.variable.getText();

						if (variables.contains(variable))
							variables.remove(variable);

						template = group.getInstanceOf("anonymousFunction");
						template.add("param", variable);
						template.add("value", function);
						template.add("variables", variables);
						anonymousFunction = template.render(1).trim()
								.replaceAll("\r\n", "")
								.replaceAll("\t", " ");

						function = "sum(" + anonymousFunction;

						function += ", " + visit(param.min) + ","
								+ visit(param.max) + ")";

					}

				break;
			case "Diff":
				ValueParameterContext diffParam = (ValueParameterContext) ctx.params
						.get(0);
				function += "differentiate(" + anonymousFunction + ", "
						+ diffParam.getText() + ")";
				break;
			case "Product":
				IntervalParameterContext productParam = (IntervalParameterContext) ctx.params
						.get(0);
				function += "product(" + anonymousFunction + ", "
						+ visit(productParam.min) + ","
						+ visit(productParam.max) + ")";

				if (ctx.params.size() > 1)
					for (int i = 1; i < ctx.params.size(); i++) {
						IntervalParameterContext param = (IntervalParameterContext) ctx.params
								.get(i);

						String variable = param.variable.getText();

						if (variables.contains(variable))
							variables.remove(variable);

						template = group.getInstanceOf("anonymousFunction");
						template.add("param", variable);
						template.add("value", function);
						template.add("variables", variables);
						anonymousFunction = template.render(1).trim()
								.replaceAll("\r\n", "")
								.replaceAll("\t", " ");

						function = "product(" + anonymousFunction;

						function += ", " + visit(param.min) + ","
								+ visit(param.max) + ")";

					}

				break;
			}
		}

		return function;
	}

	public String visitAdd(MathParser.AddContext ctx) {
		String left = visit(ctx.left);
		String right = visit(ctx.right);
		String sign = ctx.sign.getText();

		
		IVariableType leftType = ctx.left.accept(fTypeVisitor);
		IVariableType rightType = ctx.right.accept(fTypeVisitor);
		
		if (VariableType.MATRIX.equals(leftType) && VariableType.MATRIX.equals(rightType)) {
			if (sign.matches(Pattern.quote("+")))
				return left + ".plus(" + right + ")";
			if (sign.matches(Pattern.quote("-")))
				return left + ".minus(" + right + ")";
		}

		return "(" + left + ")" + sign + "(" + right + ")";
	}

	public String visitMult(MathParser.MultContext ctx) {
		String left = visit(ctx.left);
		String right = visit(ctx.right);
		String sign = ctx.sign.getText();

		IVariableType leftType = ctx.left.accept(fTypeVisitor);
		IVariableType rightType = ctx.right.accept(fTypeVisitor);
		boolean leftMatrix = leftType.equals(VariableType.MATRIX);
		boolean rightMatrix = rightType.equals(VariableType.MATRIX);
		if (leftMatrix || rightMatrix) {
			if (!leftMatrix && rightMatrix) {
				String tmp = right;
				right = left;
				left = tmp;
			}
			
			if (sign.matches(Pattern.quote("*"))) {
				return left + ".times(" + right + ")";
			}
		}

		return "(" + left + ")" + sign + "(" + right + ")";
	}

	public String visitShift(MathParser.ShiftContext ctx) {
		return visit(ctx.left) + ctx.sign.getText() + visit(ctx.right);
	}

	public String visitBitwiseAdd(MathParser.BitwiseAddContext ctx) {
		return visit(ctx.left) + '&' + visit(ctx.right);
	}

	public String visitBitwiseOr(MathParser.BitwiseOrContext ctx) {
		return visit(ctx.left) + '|' + visit(ctx.right);
	}

	public String visitXor(MathParser.XorContext ctx) {
		return visit(ctx.left) + "^" + visit(ctx.right);
	}

	public String visitPrimaryExpr(MathParser.PrimaryExprContext ctx) {
		return visitChildren(ctx);
	}

	public String visitPower(MathParser.PowerContext ctx) {
		String left = visit(ctx.left);
		String right = visit(ctx.right);

		IVariableType type = ctx.left.accept(fTypeVisitor);
		if (VariableType.MATRIX.equals(type) && right.matches("T")) {
			return left + ".transpose()";
		}

		return "Math.pow((" + left + "),(" + right + "))";
	}

	public String visitMatrix(MathParser.MatrixContext ctx) {
		String matrix = "";
		int i;

		matrix += "new Jama.Matrix(new double[][]{";
		int rowsCount = ctx.rows.size();

		for (i = 0; i < rowsCount; i++) {
			matrix += visitVector(ctx.rows.get(i));
			if (i != rowsCount - 1) {
				matrix += ",";
			}
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

	public String visitVector(VectorContext ctx) {
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
		String variable = JavaTranslator.translateName(ctx.getText());

		if (!fFoundedVariables.contains(variable))
			fFoundedVariables.add(variable);

		if (fFunctionDefinition
				&& !fDeterminedFunctionVariables.contains(variable)
				&& !fDeterminedFunctionParams.contains(variable))
			fDeterminedFunctionVariables.add(variable);

		return variable;
	}

	public String visitFloatNumber(MathParser.FloatNumberContext ctx) {
		return ctx.getText();
	}

	public String visitIntNumber(MathParser.IntNumberContext ctx) {
		return ctx.getText() + ".0";
	}

	public String visitMatrixDefinition(
			MathParser.MatrixDefinitionContext ctx) {
		return visitChildren(ctx);
	}

	public String visitMatrixElement(MathParser.MatrixElementContext ctx) {

		String rowIndex = visit(ctx.rowId).replaceAll("\\.0", "");
		String columnIndex = visit(ctx.columnId).replaceAll("\\.0", "");

		return JavaTranslator.translateName(ctx.container.getText()) + ".get((int) java.lang.Math.round(" + rowIndex + "), (int) java.lang.Math.round(" + columnIndex + "))";
	}
	
	@Override
	public String visitMatrixRow(MatrixRowContext ctx) {
		String rowIndex = visit(ctx.rowId).replaceAll("\\.0", "");

		String mtx = JavaTranslator.translateName(ctx.container.getText());
		return mtx + ".getMatrix(" + rowIndex + "," + rowIndex + ",0 , " + mtx + ".getColumnDimension() - 1)";
	}
	
	@Override
	public String visitPrimaryFunctions(PrimaryFunctionsContext ctx) {
		return visitFunction(ctx.function());
	}


	public String visitMethodCall(MathParser.MethodCallContext ctx) {
		return JavaTranslator.translateName(ctx.container.getText()) + "."
				+ visitStandardFunction(ctx.func);
	}

	public String visitProperty(MathParser.PropertyContext ctx) {
		return JavaTranslator.translateName(ctx.container.getText()) + "."
				+ JavaTranslator.translateName(ctx.property.getText());
	}

}