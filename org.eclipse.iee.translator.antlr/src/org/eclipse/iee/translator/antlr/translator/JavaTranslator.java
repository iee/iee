package org.eclipse.iee.translator.antlr.translator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.iee.core.document.source.IScope;
import org.eclipse.iee.core.document.source.IVariableType;
import org.eclipse.iee.core.document.source.VariableType;
import org.eclipse.iee.translator.antlr.java.JavaLexer;
import org.eclipse.iee.translator.antlr.java.JavaParser;
import org.eclipse.iee.translator.antlr.java.JavaParser.CompilationUnitContext;
import org.eclipse.iee.translator.antlr.math.MathLexer;
import org.eclipse.iee.translator.antlr.math.MathParser;
import org.eclipse.iee.translator.antlr.math.MathParser.ExpressionContext;
import org.eclipse.iee.translator.antlr.math.MathParser.MatrixElementContext;
import org.eclipse.iee.translator.antlr.math.MathParser.MatrixRowContext;
import org.eclipse.iee.translator.antlr.math.MathParser.VariableAssignmentContext;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.ISourceRange;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.internal.corext.dom.ASTNodes;
import org.eclipse.jdt.internal.corext.dom.ScopeAnalyzer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupDir;

import Jama.Matrix;

public class JavaTranslator {

	static final Logger logger = LoggerFactory.getLogger(JavaTranslator.class);

	private IType fClass;
	
	private IMethod fMethod;

	private int fPosition;

	private Map<String, ITypeBinding> fFields = new HashMap<>();

	private Set<String> fOtherSourceClasses = new HashSet<>();
	
	private Set<String> fMethodClasses = new HashSet<>();
	
	private Set<String> fInnerClasses = new HashSet<>();

	private CompilationUnit fUnit;
	
	public JavaTranslator(CompilationUnit ast) {
		fUnit = ast;
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
		TypeVisitior typeVisitior = new TypeVisitior(createContext());
		typeVisitior.visit(tree);
		JavaMathVisitor mathVisitor = createVisitor(typeVisitior);
		result = mathVisitor.visit(tree);
		return result;
	}

	private JavaMathVisitor createVisitor(TypeVisitior typeVisitor) {
		JavaMathVisitor mathVisitor = new JavaMathVisitor(createContext(), typeVisitor);
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
			public IVariableType getVariableType(String variable) {
				final ITypeBinding typeBinding = fFields.get(variable);
				if (typeBinding != null) {
					return createType(typeBinding);
				} else {
					@SuppressWarnings("unchecked")
					List<ImportDeclaration> imports= fUnit.imports();
					for (int i= 0; i < imports.size(); i++) {
						ImportDeclaration decl= imports.get(i);
						if (decl.isStatic() && !decl.isOnDemand()) {
							String nameIdentifier = ASTNodes.getSimpleNameIdentifier(decl.getName());
							IBinding binding = decl.resolveBinding();
							if (nameIdentifier.equals(variable) && binding instanceof IVariableBinding) {
								IVariableBinding vBinding = (IVariableBinding) binding;
								return createType(vBinding.getType());
							}
						}
					}
					throw new IllegalArgumentException("Unknown variable " + variable);
				}
			}
			
			@Override
			public IVariableType getFunctionType(String text) {
				return VariableType.DOUBLE;
			}
		};
	}

	public static String translate(String inputExpression,
			CompilationUnit compilationUnit, int position, String containerId) {

		logger.debug("Translate. Position: " + position + ", container: "
				+ containerId + "; Input: " + inputExpression);

		if (inputExpression.trim().isEmpty())
			return "";

		String result =  new JavaTranslator(compilationUnit).translateIntl(inputExpression, position,
				containerId);

		logger.debug("Translate. Output: " + result);

		return result;
	}

	private String translateIntl(String inputExpression, int position, String containerId) {
		ParserRuleContext tree = parseTree(inputExpression, position);
		String result = treeToString(tree);

		String name = null;
		boolean variableAssignment = tree.getChild(0) instanceof VariableAssignmentContext;
		if (variableAssignment) {
			VariableAssignmentContext assignment = (VariableAssignmentContext) tree.getChild(0);
			ExpressionContext nameCtx = assignment.name;
			if (nameCtx instanceof MatrixElementContext) {
				name = translateName(((MatrixElementContext)nameCtx).container.getText());
			} else if (nameCtx instanceof MatrixRowContext) {
				name = translateName(((MatrixRowContext)nameCtx).container.getText());
			} else {
				name = translateName(nameCtx.getText());
			}
		}
		
		/*
		 * Generate output code, if necessary
		 */
		IVariableType type = tree.accept(new TypeVisitior(createContext()));
		if (inputExpression.charAt(inputExpression.length() - 1) == '=') {
			String output = generateOutputCode(type, result, containerId);
			if (name != null && !fFields.containsKey(name)) {
				result = getName(type) + " " + name + ";" + output;
			} else {
				result = output;
			}
		} else {
			if (variableAssignment) {
				if (name != null && !fFields.containsKey(name)) {
					result = getName(type) + " " + result + ";";
				} else { 
					result = result + ";";
				}
			}
		} 
		return result;
	}

	private ParserRuleContext parseTree(String inputExpression, int position) {
		String expression = "";

		if (inputExpression.charAt(inputExpression.length() - 1) == '=') {
			expression = inputExpression.substring(0,
					inputExpression.length() - 1);
		} else {
			expression = inputExpression;
		}

		fPosition = position;

		parse();

		logger.debug("expr: " + expression);
		ParserRuleContext tree = parseTree(expression);
		return tree;
	}

	private String generateOutputCode(IVariableType type, String expression, String containerId) {
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

	private String getName(IVariableType type) {
		return type.getJavaQualifiedName();
	}

	static STGroup createSTGroup() {
		ClassLoader oldCL = Thread.currentThread().getContextClassLoader();
		try {
			Thread.currentThread().setContextClassLoader(JavaTranslator.class.getClassLoader());
			STGroup group = new STGroupDir("/templates");
			return group;
		} finally {
			Thread.currentThread().setContextClassLoader(oldCL);
		}
	}

	private void parse() {
		try {

			IType[] types = ((ICompilationUnit) fUnit.getJavaElement()).getTypes();
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

			}

			if (fMethod != null) {
				IJavaElement[] innerElements = fMethod.getChildren();
				for (int i = 0; i < innerElements.length; i++) {
					IType type = (IType) innerElements[i];
					String name = type.getElementName();
					if (type.isClass()) {
						fMethodClasses.add(name);
					}
				}
			}
			
			ScopeAnalyzer sa = new ScopeAnalyzer(fUnit);
			IBinding[] declarationsInScope = sa.getDeclarationsInScope(fPosition, ScopeAnalyzer.VARIABLES);
			for (IBinding iBinding : declarationsInScope) {
				if (iBinding instanceof IVariableBinding) {
					IVariableBinding variableBinding = (IVariableBinding) iBinding;
					fFields.put(variableBinding.getName(), variableBinding.getType());
				}
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

	static String translateName(String name) {
		String translatedName = name.replaceAll("\\{", "")
				.replaceAll("\\}", "");

		return translatedName;
	}

	static String firstLetterUpperCase(String str) {
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

	public static IVariableType getType(String expression, CompilationUnit iCompilationUnit, int i, String string) {
		return new JavaTranslator(iCompilationUnit)._getType(expression, i);
	}
	
	public IVariableType _getType(String expression, int i) {
		ParserRuleContext tree = parseTree(expression, i);
		return tree.accept(new TypeVisitior(createContext()));
	}

	public static IScope getScope(CompilationUnit compilationUnit, int offset) {
		Scope scope = new Scope(null);
		ScopeAnalyzer sa = new ScopeAnalyzer(compilationUnit);
		IBinding[] declarationsInScope = sa.getDeclarationsInScope(offset, ScopeAnalyzer.VARIABLES);
		for (IBinding iBinding : declarationsInScope) {
			if (iBinding instanceof IVariableBinding) {
				IVariableBinding variableBinding = (IVariableBinding) iBinding;
				scope.addVariable(variableBinding.getName(), createType(variableBinding.getType()));
			}
		}
		return scope;
	}
	
	private static IVariableType createType(final ITypeBinding typeBinding) {
		final String type = typeBinding.getQualifiedName();
		if ("D".equals(type) || "java.lang.Double".equals(type) || "double".equals(type)) {
			return VariableType.DOUBLE;
		} else if (Matrix.class.getName().equals(type) || "QMatrix;".equals(type)) {
			return VariableType.MATRIX;
		} else if ("I".equals(type) || "java.lang.Integer".equals(type) || "int".equals(type)) {
			return VariableType.INT;
		} else {
			return createCustomType(typeBinding);
		}
	}
	
	private static IVariableType createCustomType(final ITypeBinding typeBinding) {
		return new IVariableType() {
			
			@Override
			public String getJavaQualifiedName() {
				return typeBinding.getQualifiedName();
			}

			@Override
			public IVariableType getMethodType(String name) {
				IMethodBinding[] declaredMethods = typeBinding.getDeclaredMethods();
				for (IMethodBinding iMethodBinding : declaredMethods) {
					if (iMethodBinding.getName().equals(name)) {
						return createType(iMethodBinding.getReturnType());
					}
				}
				return null;
			}
		};
	}

}
