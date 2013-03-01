package org.eclipse.iee.translator.antlr.translator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.log4j.Logger;
import org.eclipse.iee.translator.antlr.math.MathBaseVisitor;
import org.eclipse.iee.translator.antlr.math.MathLexer;
import org.eclipse.iee.translator.antlr.math.MathParser;
import org.eclipse.jdt.core.IBuffer;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.ILocalVariable;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.ISourceRange;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupDir;

public class JavaTranslator {

	private static final Logger logger = Logger.getLogger(JavaTranslator.class);

	public enum VariableType {
		INT, DOUBLE, MATRIX, OTHER
	}

	private static ICompilationUnit fCompilationUnit;
	private static IType fClass;
	private static IMethod fMethod;
	private static List<String> fDoubleFields = new ArrayList<>();

	private static List<String> fIntegerFields = new ArrayList<>();

	private static List<String> fMatrixFields = new ArrayList<>();

	private static List<String> fOtherFields = new ArrayList<>();

	private static List<String> fOtherSourceClasses = new ArrayList<>();
	private static List<String> fMethodClasses = new ArrayList<>();
	private static List<String> fInnerClasses = new ArrayList<>();

	private static List<String> fFunctionVariables = new ArrayList<>();

	private static VariableType fVariableType = null;
	private static String fVariableTypeString = "";

	private static boolean fNewVariable;
	private static List<String> fFoundedVariables = new ArrayList<>();

	private static class JavaMathVisitor extends MathBaseVisitor<String> {
		// statement rule

		/*
		 * Help variables
		 */

		Boolean fVisitVariableName = false;
		Boolean fVisitedMatrixElement = false;
		Boolean fNewMatrix = false;
		Boolean fMatrixExpression = false;

		public String visitFunctionDefinition(
				MathParser.FunctionDefinitionContext ctx) {

			String name = translateName(ctx.name.name.getText());
			name = firstLetterUpperCase(name);

			List<String> params = new ArrayList<>();

			for (int i = 0; i < ctx.name.params.size(); i++) {
				params.add(visit(ctx.name.params.get(i)));
			}

			fFoundedVariables.clear();

			String value = visit(ctx.value);

			List<String> variables = new ArrayList<>();

			for (int i = 0; i < fFoundedVariables.size(); i++) {
				String variable = fFoundedVariables.get(i);
				if (!params.contains(variable))
					variables.add(variable);
			}

			logger.debug("Variables: " + variables.toString());

			STGroup group = new STGroupDir("/templates");
			ST template = group.getInstanceOf("function");
			template.add("name", name);
			template.add("params", params);
			template.add("value", value);
			template.add("variables", variables);

			return template.render(1).trim().replaceAll("\r\n", "")
					.replaceAll("\t", " ");

		}

		public String visitVariableAssignment(
				MathParser.VariableAssignmentContext ctx) {

			fVisitVariableName = true;
			String name = visit(ctx.name);
			fVisitVariableName = false;

			String value = visit(ctx.value);

			if (fVisitedMatrixElement) {
				fVariableType = VariableType.DOUBLE;
				return name += value + ");";
			}

			if (fClass == null)
				return name + "=" + value + ";";

			String assignment = "";

			if (fDoubleFields.contains(name) || fMatrixFields.contains(name)
					|| fIntegerFields.contains(name)) {
				if (fDoubleFields.contains(name))
					fVariableType = VariableType.DOUBLE;
				else if (fMatrixFields.contains(name))
					fVariableType = VariableType.MATRIX;
				else if (fIntegerFields.contains(name))
					fVariableType = VariableType.INT;
				else if (fOtherFields.contains(name))
					fVariableType = VariableType.OTHER;

				assignment += name + "=" + value + ";";
			} else {
				if ((fNewMatrix || fMatrixExpression || (fMatrixFields
						.contains(value)) && !name.matches(value))) {
					assignment += "Matrix ";
					fVariableType = VariableType.MATRIX;
				} else {
					fNewVariable = true;
				}
				assignment += name + "=";
				assignment += value + ";";

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

			String name = translateName(ctx.name.getText());

			String new_ = "";
			String name_ = "";
			List<String> fieldsNames = new ArrayList<>();
			List<String> params = new ArrayList<>();

			if (fMethodClasses.contains(firstLetterUpperCase(name))) {
				new_ = "new ";
				name_ = firstLetterUpperCase(name);

				IType type = fMethod.getType(firstLetterUpperCase(name), 1);
				try {
					IField[] fields = type.getFields();
					for (int i = 0; i < fields.length; i++) {
						IField field = fields[i];
						fieldsNames.add(field.getElementName());
					}
				} catch (JavaModelException e) {
					e.printStackTrace();
				}

			} else if (fInnerClasses.contains(firstLetterUpperCase(name))) {
				new_ = "this.new ";
				name_ = firstLetterUpperCase(name);

				IType type = fClass.getType(firstLetterUpperCase(name), 1);
				try {
					IField[] fields = type.getFields();
					for (int i = 0; i < fields.length; i++) {
						IField field = fields[i];
						fieldsNames.add(field.getElementName());
					}
				} catch (JavaModelException e) {
					e.printStackTrace();
				}

			} else if (fOtherSourceClasses.contains(firstLetterUpperCase(name))) {
				new_ = "new ";
				name_ = firstLetterUpperCase(name);

			} else
				name_ = translateName(ctx.name.getText());

			for (int i = 0; i < ctx.params.size(); i++) {
				params.add(visit(ctx.params.get(i)));
			}

			STGroup group = new STGroupDir("/templates");
			ST template = group.getInstanceOf("functionCall");
			template.add("new", new_);
			template.add("name", name_);
			template.add("fields", fieldsNames);
			template.add("params", params);

			return template.render(1).trim().replaceAll("\r\n", "")
					.replaceAll("\t", " ");

		}

		public String visitAdd(MathParser.AddContext ctx) {
			String left = visit(ctx.left);
			String right = visit(ctx.right);
			String sign = ctx.sign.getText();

			if (fMatrixFields.contains(left) && fMatrixFields.contains(right)) {
				// XXX: temporary solution
				fMatrixExpression = true;

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

			if (fMatrixFields.contains(left)) {
				// XXX: temporary solution
				fMatrixExpression = true;

				if (sign.matches(Pattern.quote("*")))
					return left + ".times(" + right + ")";
			}

			return "(" + left + ")" + sign + "(" + right + ")";
		}

		public String visitPrimaryExpr(MathParser.PrimaryExprContext ctx) {
			return visitChildren(ctx);
		}

		public String visitPower(MathParser.PowerContext ctx) {
			String left = visit(ctx.left);
			String right = visit(ctx.right);

			if (fMatrixFields.contains(left) && right.matches("T")) {
				// XXX: temporary solution
				fMatrixExpression = true;

				return left + ".transpose()";
			}

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
			String variable = translateName(ctx.getText());
			fFoundedVariables.add(variable);

			return variable;
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

			if (fVisitVariableName) {
				fVisitedMatrixElement = true;
				return translateName(ctx.name.getText()) + ".set("
						+ visit(ctx.rowIdx) + "," + visit(ctx.columnIdx) + ",";
			} else
				return translateName(ctx.name.getText()) + ".get("
						+ visit(ctx.rowIdx) + "," + visit(ctx.columnIdx) + ")";
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

	}

	public static boolean validate(String text) {

		try {

			if (translate(text) == "") {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
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

	public static String translate(String inputExpression,
			ICompilationUnit compilationUnit, int position, String containerId,
			String storagePath, String runtimeDirectoryName) {

		if (inputExpression.trim().isEmpty())
			return "";

		String result = "";
		String expression = "";

		if (inputExpression.charAt(inputExpression.length() - 1) == '=') {
			expression = inputExpression.substring(0,
					inputExpression.length() - 1);
		} else {
			expression = inputExpression;
		}

		clear();

		fCompilationUnit = compilationUnit;

		parse(position);

		logger.debug("expr: " + expression);
		result = translate(expression);

		/*
		 * Try get recognize variable type from expression
		 */

		if (fNewVariable) {
			result = getType(position, result) + " " + result;
		}

		String[] parts = result.split("=");
		if (parts.length == 1)
			getType(position, "myTmp=" + parts[0] + ";");

		/*
		 * Generate output code, if necessary
		 */
		if (inputExpression.charAt(inputExpression.length() - 1) == '=') {
			parts = inputExpression.split("=");

			if (parts.length == 1) {
				String output = generateOutputCode(result, containerId,
						storagePath, runtimeDirectoryName);
				result = output;
			} else if (parts.length > 1) {
				String output = generateOutputCode(inputExpression,
						containerId, storagePath, runtimeDirectoryName);
				result += output;
			}
		}

		return result;
	}

	public static String generateOutputCode(String expression,
			String containerId, String storagePath, String runtimeDirectoryName) {
		String expr = expression;

		String[] parts = expr.replaceAll(Pattern.quote("{"), "")
				.replaceAll(Pattern.quote("}"), "").split("=");
		if (parts.length >= 1) {
			String variable = expression;
			if (parts.length > 1)
				variable = expression.substring(0, expression.indexOf('='));

			variable = variable.trim();
			variable = variable.replaceAll(Pattern.quote("{"), "");
			variable = variable.replaceAll(Pattern.quote("}"), "");
			VariableType varType = fVariableType;

			if (varType == null) {
				if (fDoubleFields.contains(variable))
					varType = VariableType.DOUBLE;
				else if (fIntegerFields.contains(variable))
					varType = VariableType.INT;
				else if (fMatrixFields.contains(variable))
					varType = VariableType.MATRIX;
				else
					return "";
			}

			logger.debug("Type:" + varType.toString());
			STGroup group = new STGroupDir("/templates");

			if (varType != VariableType.MATRIX) {

				String type = "";
				if (varType == VariableType.DOUBLE)
					type = "double";
				else if (varType == VariableType.INT)
					type = "int";

				ST template = group.getInstanceOf("variable");

				template.add("type", type);
				template.add("id", containerId);
				template.add("variable", variable);
				template.add("path", storagePath + runtimeDirectoryName);

				return template.render(1).trim().replaceAll("\r\n", "")
						.replaceAll("\t", " ");

			} else {

				String type = "Matrix";

				ST template = group.getInstanceOf("matrix");
				template.add("type", type);
				template.add("id", containerId);
				template.add("variable", variable);
				template.add("path", storagePath + runtimeDirectoryName);

				return template.render(1).trim().replaceAll("\r\n", "")
						.replaceAll("\t", " ");
			}
		} else {
			return "";
		}
	}

	private static void clear() {
		fCompilationUnit = null;
		fClass = null;
		fMethod = null;
		fVariableType = null;
		fVariableTypeString = "";
		fNewVariable = false;

		fMatrixFields.clear();
		fDoubleFields.clear();
		fIntegerFields.clear();
		fOtherFields.clear();

		fMethodClasses.clear();
		fInnerClasses.clear();
		fFunctionVariables.clear();
		fOtherSourceClasses.clear();
	}

	private static CompilationUnit createAST(ICompilationUnit unit) {
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(unit);
		parser.setResolveBindings(true);
		return (CompilationUnit) parser.createAST(null); // parse
	}

	private static void parse(final int position) {
		try {

			IType[] types = fCompilationUnit.getTypes();
			for (int i = 0; i < types.length; i++) {
				IType type = types[i];
				if (type.isClass()) {
					ISourceRange classSourceRange = type.getSourceRange();
					int classOffset = classSourceRange.getOffset();
					if (position > classOffset
							&& position <= (classOffset + classSourceRange
									.getLength()))
						fClass = type;
					else if (!fOtherSourceClasses.contains(type
							.getElementName()))
						fOtherSourceClasses.add(type.getElementName());
				}
			}

			if (fClass != null) {
				IMethod[] methods = fClass.getMethods();
				for (int i = 0; i < methods.length; i++) {
					IMethod method = methods[i];

					ISourceRange methodSourceRange = method.getSourceRange();
					int methodOffset = methodSourceRange.getOffset();
					if (position > methodOffset
							&& position <= (methodOffset + methodSourceRange
									.getLength()))
						fMethod = method;
				}

				IType[] innerTypes = fClass.getTypes();
				for (int i = 0; i < innerTypes.length; i++) {
					IType type = innerTypes[i];
					String name = type.getElementName();
					if (type.isClass()) {
						if (!fInnerClasses.contains(name))
							fInnerClasses.add(name);
					}
				}

				IField[] classFields = null;

				classFields = fClass.getFields();
				for (int i = 0; i < classFields.length; i++) {
					IField field = classFields[i];
					String name = field.getElementName();
					String type = field.getTypeSignature();

					ISourceRange fieldSourceRange = field.getSourceRange();
					int fieldOffset = fieldSourceRange.getOffset();

					if (position > fieldOffset) {
						if (type.matches("D")) {
							if (!fDoubleFields.contains(name))
								fDoubleFields.add(name);
						} else if (type.matches("QMatrix;")) {
							if (!fMatrixFields.contains(name))
								fMatrixFields.add(name);
						} else if (type.matches("I")) {
							if (!fIntegerFields.contains(name))
								fIntegerFields.add(name);
						} else {
							if (!fOtherFields.contains(name))
								fOtherFields.add(name);
						}
					}
				}
			}

			if (fMethod != null) {
				ILocalVariable[] methodParams = fMethod.getParameters();
				for (int i = 0; i < methodParams.length; i++) {
					ILocalVariable param = methodParams[i];
					String name = param.getElementName();
					String type = param.getTypeSignature();

					if (type.matches("D")) {
						if (!fDoubleFields.contains(name))
							fDoubleFields.add(name);
					} else if (type.matches("QMatrix;")) {
						if (!fMatrixFields.contains(name))
							fMatrixFields.add(name);
					} else if (type.matches("I")) {
						if (!fIntegerFields.contains(name))
							fIntegerFields.add(name);
					} else {
						if (!fOtherFields.contains(name))
							fOtherFields.add(name);
					}

				}

				IJavaElement[] innerElements = fMethod.getChildren();
				for (int i = 0; i < innerElements.length; i++) {
					IType type = (IType) innerElements[i];
					String name = type.getElementName();
					if (type.isClass()) {
						if (!fMethodClasses.contains(name))
							fMethodClasses.add(name);
					}
				}

				CompilationUnit unit = (CompilationUnit) createAST(fCompilationUnit);
				unit.accept(new ASTVisitor() {
					@Override
					public boolean visit(VariableDeclarationStatement node) {
						try {
							ISourceRange methodSourceRange = fMethod
									.getSourceRange();
							int methodOffset = methodSourceRange.getOffset();

							int variableAssignmentOffset = node
									.getStartPosition();

							if (variableAssignmentOffset > methodOffset
									&& variableAssignmentOffset <= (methodOffset + methodSourceRange
											.getLength())
									&& position > variableAssignmentOffset) {

								List<?> fragments = node.fragments();
								String type = node.getType().toString();

								for (int i = 0; i < fragments.size(); i++) {
									VariableDeclarationFragment fragment = (VariableDeclarationFragment) fragments
											.get(i);
									String name = fragment.getName().toString();

									if (type.matches("double")) {
										if (!fDoubleFields.contains(name))
											fDoubleFields.add(name);
									} else if (type.matches("Matrix")) {
										if (!fMatrixFields.contains(name))
											fMatrixFields.add(name);
									} else if (type.matches("int")) {
										if (!fIntegerFields.contains(name))
											fIntegerFields.add(name);
									} else {
										if (!fOtherFields.contains(name))
											fOtherFields.add(name);
									}
								}
							}
						} catch (JavaModelException e) {
							e.printStackTrace();
						}

						return true;
					}

				});
			}

		} catch (JavaModelException e) {
			e.printStackTrace();
		}

		try {
			logger.debug("Source: " + fCompilationUnit.getSource());
		} catch (JavaModelException e) {
			e.printStackTrace();
		}
		if (fClass != null) {
			logger.debug("fClass: " + fClass.getElementName());
			logger.debug("fSourceClasses: " + fOtherSourceClasses.toString());
			logger.debug("fInnerClasses: " + fInnerClasses.toString());
		}
		if (fMethod != null) {
			logger.debug("fMethod: " + fMethod.getElementName());
			logger.debug("fMethodClasses: " + fMethodClasses.toString());
		}
		logger.debug("fMatrixFields: " + fMatrixFields.toString());
		logger.debug("fDoubleFields: " + fDoubleFields.toString());
		logger.debug("fIntegerFields: " + fIntegerFields.toString());
		logger.debug("fOtherFields: " + fOtherFields.toString());

	}

	private static String getType(final int position, final String assignment) {
		fVariableTypeString = "double";

		try {
			ICompilationUnit copy = fCompilationUnit.getWorkingCopy(null);
			IBuffer buffer = copy.getBuffer();
			buffer.replace(position, 0, assignment);
			copy.reconcile(AST.JLS4, false, null, null);

			logger.debug("CopySource" + copy.getSource());

			CompilationUnit unit = (CompilationUnit) createAST(copy);
			unit.accept(new ASTVisitor() {
				@Override
				public boolean visit(Assignment node) {
					int startPosition = node.getStartPosition();
					if (startPosition >= position
							&& startPosition < (position + assignment.length())) {
						Expression rightSide = node.getRightHandSide();
						logger.debug("expr: " + rightSide.toString());
						fVariableTypeString = rightSide.resolveTypeBinding()
								.getName();
						logger.debug("expr type: " + fVariableTypeString);
					}

					return true;
				}
			});

			copy.discardWorkingCopy();

		} catch (JavaModelException e) {
			e.printStackTrace();
		}

		logger.debug("Type: " + fVariableTypeString);

		if (fVariableTypeString.matches("double"))
			fVariableType = VariableType.DOUBLE;
		else if (fVariableTypeString.matches("int")) {
			/*
			 * If user want's use integer variables, he should define it before
			 */
			// fVariableType = VariableType.INT;
			fVariableTypeString = "double";
			fVariableType = VariableType.DOUBLE;
		} else if (fVariableTypeString.matches("Matrix"))
			fVariableType = VariableType.MATRIX;
		else
			fVariableType = VariableType.OTHER;

		return fVariableTypeString;
	}

	private static String translateName(String name) {
		String translatedName = name.replaceAll("\\{", "")
				.replaceAll("\\}", "");

		return translatedName;
	}

	private static String firstLetterUpperCase(String str) {
		String result = str;
		String firstLetter = result.substring(0, 1).toUpperCase();
		if (result.length() > 1)
			result = firstLetter.concat(result.substring(1));
		else
			result = firstLetter;

		return result;
	}

}
