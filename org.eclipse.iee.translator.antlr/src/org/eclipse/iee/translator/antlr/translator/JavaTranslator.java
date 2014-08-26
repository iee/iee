package org.eclipse.iee.translator.antlr.translator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.iee.core.document.source.VariableType;
import org.eclipse.iee.translator.antlr.java.JavaLexer;
import org.eclipse.iee.translator.antlr.java.JavaParser;
import org.eclipse.iee.translator.antlr.java.JavaParser.CompilationUnitContext;
import org.eclipse.iee.translator.antlr.math.MathBaseVisitor;
import org.eclipse.iee.translator.antlr.math.MathLexer;
import org.eclipse.iee.translator.antlr.math.MathParser;
import org.eclipse.iee.translator.antlr.math.MathParser.IntervalParameterContext;
import org.eclipse.iee.translator.antlr.math.MathParser.MatrixElementContext;
import org.eclipse.iee.translator.antlr.math.MathParser.MatrixRowContext;
import org.eclipse.iee.translator.antlr.math.MathParser.ValueParameterContext;
import org.eclipse.iee.translator.antlr.math.MathParser.VariableAssignmentContext;
import org.eclipse.iee.translator.antlr.math.MathParser.VectorContext;
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
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupDir;

import Jama.Matrix;

public class JavaTranslator {

	private static final Logger logger = LoggerFactory.getLogger(JavaTranslator.class);

	private ICompilationUnit fCompilationUnit;
	
	private IType fClass;
	
	private IMethod fMethod;

	private int fPosition;

	private Map<String, String> fFields = new HashMap<>();

	private Set<String> fOtherSourceClasses = new HashSet<>();
	
	private Set<String> fMethodClasses = new HashSet<>();
	
	private Set<String> fInnerClasses = new HashSet<>();

	private static class JavaMathVisitor extends MathBaseVisitor<String> {
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
		
		public JavaMathVisitor(ExternalTranslationContext externalContext) {
			fExternalContext = externalContext;
			fTypeVisitor = new TypeVisitior(fExternalContext);
		}

		public String visitFunctionDefinition(
				MathParser.FunctionDefinitionContext ctx) {

			fFunctionDefinition = true;

			String name = translateName(ctx.name.name.getText());
			name = firstLetterUpperCase(name);

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

			logger.debug("funcDef DeterminedFunctionVariables: "
					+ fDeterminedFunctionVariables.toString());

			STGroup group = createSTGroup();
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
				return translateName(ctx.name.getText()) + ".set(" + rowIndex + "," + columnIndex + "," + value + ")";
			}
			
			String name = translateName(ctx.name.getText());
			
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

			String name = translateName(ctx.name.getText());

			String new_ = "";
			String name_ = "";
			List<String> fieldsNames = new ArrayList<>();
			List<String> params = new ArrayList<>();

			if (fExternalContext.containsMethod(name)) {
				new_ = "new ";
				name_ = firstLetterUpperCase(name);

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
				name_ = firstLetterUpperCase(name);

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
				name_ = firstLetterUpperCase(name);

			} else
				name_ = translateName(ctx.name.getText());

			for (int i = 0; i < ctx.params.size(); i++) {
				params.add(visit(ctx.params.get(i)));
			}

			boolean isFunctionClass = true;
			if (new_.isEmpty())
				isFunctionClass = false;

			STGroup group = createSTGroup();
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

			logger.debug("Internal function: " + ctx.func.getText());

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

			logger.debug("internalFunc FoundedVariables: "
					+ internalFunctionVariables.toString());
			logger.debug("internalFunc Variables: " + variables.toString());

			if (ctx.name.getText().matches("Sqrt")) {
				function = "Math.sqrt(" + value + ")";
			} else {
				STGroup group = createSTGroup();
				ST template = group.getInstanceOf("anonymousFunction");
				template.add("param", params.get(0));
				template.add("value", value);
				template.add("variables", variables);

				String anonymousFunction = template.render(1).trim()
						.replaceAll("\r\n", "").replaceAll("\t", " ");

				logger.debug("InternalFunc name: " + ctx.name.getText());

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

			
			VariableType leftType = ctx.left.accept(fTypeVisitor);
			VariableType rightType = ctx.right.accept(fTypeVisitor);
			
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

			VariableType leftType = ctx.left.accept(fTypeVisitor);
			VariableType rightType = ctx.right.accept(fTypeVisitor);
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

			VariableType type = ctx.left.accept(fTypeVisitor);
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
			String variable = translateName(ctx.getText());

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
			return ctx.getText();
		}

		public String visitMatrixDefinition(
				MathParser.MatrixDefinitionContext ctx) {
			return visitChildren(ctx);
		}

		public String visitMatrixElement(MathParser.MatrixElementContext ctx) {

			String rowIndex = visit(ctx.rowId).replaceAll("\\.0", "");
			String columnIndex = visit(ctx.columnId).replaceAll("\\.0", "");

			return translateName(ctx.container.getText()) + ".get(" + rowIndex + "," + columnIndex + ")";
		}
		
		@Override
		public String visitMatrixRow(MatrixRowContext ctx) {
			String rowIndex = visit(ctx.rowId).replaceAll("\\.0", "");

			String mtx = translateName(ctx.container.getText());
			return mtx + ".getMatrix(" + rowIndex + "," + rowIndex + ",0 , " + mtx + ".getColumnDimension() - 1)";
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

	private ParserRuleContext parseTree(String expression) {
		ANTLRInputStream input = new ANTLRInputStream(expression);
		MathLexer lexer = new MathLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MathParser parser = new MathParser(tokens);
		parser.setBuildParseTree(true);
		ParserRuleContext tree = parser.statement();
		return tree;
	}

	private String treeToString(ParserRuleContext tree) {
		String result;
		JavaMathVisitor mathVisitor = createVisitor();
		result = mathVisitor.visit(tree);
		return result;
	}

	private JavaMathVisitor createVisitor() {
		JavaMathVisitor mathVisitor = new JavaMathVisitor(createContext());
		return mathVisitor;
	}

	private ExternalTranslationContext createContext() {
		return new ExternalTranslationContext() {
			
			@Override
			public boolean containsMethod(String name) {
				return fMethodClasses.contains(firstLetterUpperCase(name));
			}

			@Override
			public IType getMethodType(String name) {
				return fMethod.getType(firstLetterUpperCase(name), 1);
			}

			@Override
			public boolean containsClass(String name) {
				return fInnerClasses.contains(firstLetterUpperCase(name));
			}

			@Override
			public IType getClassType(String name) {
				return fClass.getType(firstLetterUpperCase(name), 1);
			}

			@Override
			public boolean containsOtherSourceClass(String name) {
				return fOtherSourceClasses.contains(firstLetterUpperCase(name));
			}

			@Override
			public String translateName(String text) {
				return JavaTranslator.translateName(text);
			}

			@Override
			public VariableType getVariableType(String variable) {
				String type = fFields.get(variable);
				if ("double".equals(type)) {
					return VariableType.DOUBLE;
				} else if (Matrix.class.getName().equals(type)) {
					return VariableType.MATRIX;
				} else if ("int".equals(type)) {
					return VariableType.INT;
				} else {
					return VariableType.OTHER;
				}
			}
		};
	}

	public static String translate(String inputExpression,
			ICompilationUnit compilationUnit, int position, String containerId) {

		logger.debug("Translate. Position: " + position + ", container: "
				+ containerId + "; Input: " + inputExpression);

		if (inputExpression.trim().isEmpty())
			return "";

		String result =  new JavaTranslator().translateIntl(inputExpression, compilationUnit, position,
				containerId);

		logger.debug("Translate. Output: " + result);

		return result;
	}

	private String translateIntl(String inputExpression,
			ICompilationUnit compilationUnit, int position, String containerId) {
		ParserRuleContext tree = parseTree(inputExpression, compilationUnit, position);
		String result = treeToString(tree);

		String name = null;
		if (tree.getChild(0) instanceof VariableAssignmentContext) {
			VariableAssignmentContext assignment = (VariableAssignmentContext) tree.getChild(0);
			name = translateName(assignment.name.getText());
		}
		
		/*
		 * Generate output code, if necessary
		 */
		VariableType type = tree.accept(new TypeVisitior(createContext()));
		if (inputExpression.charAt(inputExpression.length() - 1) == '=') {
			String output = generateOutputCode(type, result, containerId);
			if (name != null && !fFields.containsKey(name)) {
				result = getName(type) + " " + name + ";" + output;
			} else {
				result = output;
			}
		} else {
			if (name != null && !fFields.containsKey(name)) {
				result = getName(type) + " " + result + ";";
			} else {
				result = result + ";";
			}
		} 
		return result;
	}

	private ParserRuleContext parseTree(String inputExpression,
			ICompilationUnit compilationUnit, int position) {
		String expression = "";

		if (inputExpression.charAt(inputExpression.length() - 1) == '=') {
			expression = inputExpression.substring(0,
					inputExpression.length() - 1);
		} else {
			expression = inputExpression;
		}

		fPosition = position;

		try {
			fCompilationUnit = compilationUnit.getWorkingCopy(null);
			fCompilationUnit.reconcile(ICompilationUnit.NO_AST, false, null, null);
		} catch (JavaModelException e) {
			e.printStackTrace();
		}

		parse();

		logger.debug("expr: " + expression);
		ParserRuleContext tree = parseTree(expression);
		return tree;
	}

	private String generateOutputCode(VariableType type, String expression, String containerId) {
			STGroup group = createSTGroup();
			if (VariableType.MATRIX.equals(type)) {
				ST template = group.getInstanceOf("matrix");
				template.add("id", containerId);
				template.add("variable", expression);
				return template.render(1).trim().replaceAll("\r\n", "").replaceAll("\t", " ");
			} else {
				ST template = group.getInstanceOf("variable");
				template.add("id", containerId);
				template.add("variable", expression);
				return template.render(1).trim().replaceAll("\r\n", "").replaceAll("\t", " ");
			}
	}

	private String getName(VariableType type) {
		switch (type) {
		case DOUBLE:
			return "double";
		case INT:
			return "int";
		case MATRIX:
			return "Jama.Matrix";
		default:
			return null;
		}
	}

	private static STGroup createSTGroup() {
		ClassLoader oldCL = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader(JavaTranslator.class.getClassLoader());
			STGroup group = new STGroupDir("/templates");
			return group;
		} finally {
			Thread.currentThread().setContextClassLoader(oldCL);
		}
	}

	private CompilationUnit createAST(ICompilationUnit unit) {
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(unit);
		parser.setResolveBindings(true);
		parser.setStatementsRecovery(true);
		parser.setBindingsRecovery(true);
		return (CompilationUnit) parser.createAST(null); // parse
	}

	private void parse() {
		try {

			IType[] types = fCompilationUnit.getTypes();
			for (int i = 0; i < types.length; i++) {
				IType type = types[i];
				if (type.isClass()) {
					ISourceRange classSourceRange = type.getSourceRange();
					int classOffset = classSourceRange.getOffset();
					if (fPosition > classOffset
							&& fPosition <= (classOffset + classSourceRange
									.getLength())) {
						fClass = type;
					} else {
						fOtherSourceClasses.add(type.getElementName());
					}
				}
			}

			if (fClass != null) {
				IMethod[] methods = fClass.getMethods();
				for (int i = 0; i < methods.length; i++) {
					IMethod method = methods[i];

					ISourceRange methodSourceRange = method.getSourceRange();
					int methodOffset = methodSourceRange.getOffset();
					if (fPosition > methodOffset
							&& fPosition <= (methodOffset + methodSourceRange
									.getLength()))
						fMethod = method;
				}

				IType[] innerTypes = fClass.getTypes();
				for (int i = 0; i < innerTypes.length; i++) {
					IType type = innerTypes[i];
					String name = type.getElementName();
					if (type.isClass()) {
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

					if (fPosition > fieldOffset) {
						fFields.put(name, type);
					}
				}
			}

			if (fMethod != null) {
				ILocalVariable[] methodParams = fMethod.getParameters();
				for (int i = 0; i < methodParams.length; i++) {
					ILocalVariable param = methodParams[i];
					String name = param.getElementName();
					String type = param.getTypeSignature();
					fFields.put(name, type);
				}

				IJavaElement[] innerElements = fMethod.getChildren();
				for (int i = 0; i < innerElements.length; i++) {
					IType type = (IType) innerElements[i];
					String name = type.getElementName();
					if (type.isClass()) {
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
									&& fPosition > variableAssignmentOffset) {

								List<?> fragments = node.fragments();
								String type = node.getType().resolveBinding().getQualifiedName();

								for (int i = 0; i < fragments.size(); i++) {
									VariableDeclarationFragment fragment = (VariableDeclarationFragment) fragments
											.get(i);
									String name = fragment.getName().toString();
									fFields.put(name, type);
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

		if (fClass != null) {
			logger.debug("fClass: " + fClass.getElementName());
			logger.debug("fSourceClasses: " + fOtherSourceClasses.toString());
			logger.debug("fInnerClasses: " + fInnerClasses.toString());
		}
		if (fMethod != null) {
			logger.debug("fMethod: " + fMethod.getElementName());
			logger.debug("fMethodClasses: " + fMethodClasses.toString());
		}
		logger.debug("fFields: " + fFields.toString());

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

	public CompilationUnitContext createTree(String source) {
		ANTLRInputStream input = new ANTLRInputStream(source);
		JavaLexer lexer = new JavaLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		JavaParser parser = new JavaParser(tokens);
		parser.setBuildParseTree(true);
		return parser.compilationUnit();
	}

	public static VariableType getType(String expression, ICompilationUnit iCompilationUnit, int i, String string) {
		return new JavaTranslator()._getType(expression, iCompilationUnit, i);
	}
	
	public VariableType _getType(String expression, ICompilationUnit iCompilationUnit, int i) {
		ParserRuleContext tree = parseTree(expression, iCompilationUnit, i);
		return tree.accept(new TypeVisitior(createContext()));
	}
	
	

}
