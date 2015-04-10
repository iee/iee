package org.eclipse.iee.translator.antlr.translator;

import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.eclipse.iee.core.document.source.IVariableType;
import org.eclipse.iee.core.document.source.VariableType;
import org.eclipse.iee.translator.antlr.math.MathBaseVisitor;
import org.eclipse.iee.translator.antlr.math.MathParser.ExpressionContext;
import org.eclipse.iee.translator.antlr.math.MathParser.FloatNumberContext;
import org.eclipse.iee.translator.antlr.math.MathParser.FunctionDefinitionContext;
import org.eclipse.iee.translator.antlr.math.MathParser.IntNumberContext;
import org.eclipse.iee.translator.antlr.math.MathParser.InternalFunctionContext;
import org.eclipse.iee.translator.antlr.math.MathParser.IntervalParameterContext;
import org.eclipse.iee.translator.antlr.math.MathParser.MatrixContext;
import org.eclipse.iee.translator.antlr.math.MathParser.MatrixElementContext;
import org.eclipse.iee.translator.antlr.math.MathParser.MatrixRowContext;
import org.eclipse.iee.translator.antlr.math.MathParser.MethodCallContext;
import org.eclipse.iee.translator.antlr.math.MathParser.ParameterContext;
import org.eclipse.iee.translator.antlr.math.MathParser.PowerContext;
import org.eclipse.iee.translator.antlr.math.MathParser.RangeExprContext;
import org.eclipse.iee.translator.antlr.math.MathParser.StandardFunctionContext;
import org.eclipse.iee.translator.antlr.math.MathParser.VariableAssignmentContext;
import org.eclipse.iee.translator.antlr.math.MathParser.VariableContext;

import com.google.common.collect.Maps;

public class TypeVisitior extends MathBaseVisitor<IVariableType> {

	private ExternalTranslationContext fExternalContext;

	private Map<ParseTree, IVariableType> types = Maps.newHashMap();
	
	private Scope scope = new Scope(null); 
	
	public TypeVisitior(ExternalTranslationContext fExternalContext) {
		this.fExternalContext = fExternalContext;
	}
	@Override
	public IVariableType visit(ParseTree tree) {
		if (types.containsKey(tree)) {
			return types.get(tree);
		}
		IVariableType result = super.visit(tree);
		types.put(tree, result);
		return result;
	}
	
	@Override
	public IVariableType visitChildren(RuleNode tree) {
		if (types.containsKey(tree)) {
			return types.get(tree);
		}
		IVariableType result = super.visitChildren(tree);
		types.put(tree, result);
		return result;
	}

	@Override
	public IVariableType visitVariableAssignment(VariableAssignmentContext ctx) {
		return visit(ctx.value);
	}
	
	@Override
	public IVariableType visitIntNumber(IntNumberContext ctx) {
		return VariableType.DOUBLE;
	}
	
	@Override
	public IVariableType visitFloatNumber(FloatNumberContext ctx) {
		return VariableType.DOUBLE;
	}
	
	@Override
	public IVariableType visitMatrix(MatrixContext ctx) {
		return VariableType.MATRIX;
	}
	
	@Override
	public IVariableType visitMatrixElement(MatrixElementContext ctx) {
		return VariableType.DOUBLE;
	}
	
	@Override
	public IVariableType visitMatrixRow(MatrixRowContext ctx) {
		return VariableType.MATRIX;
	}
	
	@Override
	public IVariableType visitPower(PowerContext ctx) {
		if (types.containsKey(ctx)) {
			return types.get(ctx);
		}
		IVariableType result;
		
		IVariableType left = visit(ctx.left);
		String right = ctx.right.getText();
		if (VariableType.MATRIX.equals(left) && right.matches("T")) {
			result = VariableType.MATRIX;
		} else {
			result = VariableType.DOUBLE;
		}
		types.put(ctx, result);
		return result;
	}
	
	@Override
	public IVariableType visitVariable(VariableContext ctx) {
		if (types.containsKey(ctx)) {
			return types.get(ctx);
		}
		IVariableType result;
		
		String text = ctx.getText();
		String name = fExternalContext.translateName(text);
		IVariableType variableType = scope.getVariableType(text);
		if (variableType == null) {
			variableType = getScope(ctx).getVariableType(text);
			if (variableType == null) {
				variableType = fExternalContext.getVariableType(name);
				if (variableType == null) {
					throw new IllegalArgumentException("Unknown variable " +  text);
				}
			}
		}
		result = variableType;
		types.put(ctx, result);
		return variableType;
	}
	
	private Scope getScope(ParserRuleContext ctx) {
		Scope scope;
		if (ctx.getParent() != null) {
			scope = new Scope(getScope(ctx.getParent()));
		} else {
			scope = new Scope(null);
		}
		if (ctx instanceof InternalFunctionContext) {
			List<ParameterContext> params = ((InternalFunctionContext) ctx).params;
			for (int i = 0; i < params.size(); i++) {
				if (params.get(i) instanceof IntervalParameterContext) {
					IntervalParameterContext param = (IntervalParameterContext) params
							.get(i);
					String paramVariable = param.variable.getText();
					scope.addVariable(paramVariable, VariableType.DOUBLE);
				}
			}
		} else if (ctx instanceof StandardFunctionContext) {
			List<ExpressionContext> params = ((StandardFunctionContext) ctx).params;
			for (ExpressionContext expressionContext : params) {
				scope.addVariable(expressionContext.getText(), VariableType.DOUBLE);
			}
		} else if (ctx instanceof FunctionDefinitionContext) {
			StandardFunctionContext name = ((FunctionDefinitionContext) ctx).name;
			List<ExpressionContext> params = name.params;
			for (ExpressionContext expressionContext : params) {
				scope.addVariable(expressionContext.getText(), VariableType.DOUBLE);
			}
		}
		return scope;
	}
	
	@Override
	public IVariableType visitStandardFunction(StandardFunctionContext ctx) {
		String text = ctx.name.getText();
		IVariableType functionType = fExternalContext.getFunctionType(text);
		if (functionType == null) {
			throw new IllegalArgumentException("Unknown function " +  text);
		}
		return functionType;
	}
	
	@Override
	public IVariableType visitInternalFunction(InternalFunctionContext ctx) {
		if (types.containsKey(ctx)) {
			return types.get(ctx);
		}
		IVariableType result;
		
		scope = new Scope(scope);
		for (int i = 0; i < ctx.params.size(); i++) {
			if (ctx.params.get(i) instanceof IntervalParameterContext) {
				IntervalParameterContext param = (IntervalParameterContext) ctx.params
						.get(i);
				String paramVariable = param.variable.getText();
				scope.addVariable(paramVariable, VariableType.DOUBLE);
			}
		}
		scope = scope.getParent();
		
		result = VariableType.DOUBLE;
		types.put(ctx, result);
		return result;
	}
	
	@Override
	public IVariableType visitRangeExpr(RangeExprContext ctx) {
		return VariableType.RANGE;
	}
	
	@Override
	public IVariableType visitFunctionDefinition(FunctionDefinitionContext ctx) {
		if (types.containsKey(ctx)) {
			return types.get(ctx);
		}
		IVariableType result;
		
		scope = new Scope(scope);
		StandardFunctionContext name = ctx.name;
		List<ExpressionContext> params = name.params;
		for (ExpressionContext expressionContext : params) {
			scope.addVariable(expressionContext.getText(), VariableType.DOUBLE);
		}
		result = visit(ctx.value);
		scope = scope.getParent();
		types.put(ctx, result);
		return result;
	}
	
	@Override
	public IVariableType visitMethodCall(MethodCallContext ctx) {
		if (types.containsKey(ctx)) {
			return types.get(ctx);
		}
		IVariableType result;
		
		ExpressionContext container = ctx.container;
		IVariableType containerType = visit(container);
		String text = ctx.func.name.getText();
		IVariableType methodType = containerType.getMethodType(text);
		if (methodType == null) {
			throw new IllegalArgumentException("Unknown method " +  text);
		}
		result = methodType;
		types.put(ctx, result);
		return result;
	}
	
	@Override
	protected IVariableType aggregateResult(IVariableType aggregate, IVariableType nextResult) {
		if (nextResult == aggregate) {
			return aggregate;
		} else if (nextResult == null) {
			return aggregate;
		} else if (aggregate == null) {
			return nextResult;
		} else if ((VariableType.DOUBLE.equals(aggregate) && VariableType.INT.equals(nextResult))
				|| (VariableType.DOUBLE.equals(nextResult) && VariableType.INT.equals(aggregate))) {
			return VariableType.DOUBLE;
		} else if (((VariableType.DOUBLE.equals(aggregate) || VariableType.INT.equals(aggregate)) && VariableType.MATRIX.equals(nextResult))
				|| ((VariableType.DOUBLE.equals(nextResult) || VariableType.INT.equals(nextResult)) && VariableType.MATRIX.equals(aggregate))) {
			return VariableType.MATRIX;
		}
		throw new RuntimeException();
	}
	
}
