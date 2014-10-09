package org.eclipse.iee.translator.antlr.translator;

import org.eclipse.iee.core.document.source.IVariableType;
import org.eclipse.iee.core.document.source.VariableType;
import org.eclipse.iee.translator.antlr.math.MathBaseVisitor;
import org.eclipse.iee.translator.antlr.math.MathParser.ExpressionContext;
import org.eclipse.iee.translator.antlr.math.MathParser.FloatNumberContext;
import org.eclipse.iee.translator.antlr.math.MathParser.FunctionDefinitionContext;
import org.eclipse.iee.translator.antlr.math.MathParser.IntNumberContext;
import org.eclipse.iee.translator.antlr.math.MathParser.InternalFunctionContext;
import org.eclipse.iee.translator.antlr.math.MathParser.MatrixContext;
import org.eclipse.iee.translator.antlr.math.MathParser.MatrixElementContext;
import org.eclipse.iee.translator.antlr.math.MathParser.MatrixRowContext;
import org.eclipse.iee.translator.antlr.math.MathParser.MethodCallContext;
import org.eclipse.iee.translator.antlr.math.MathParser.PowerContext;
import org.eclipse.iee.translator.antlr.math.MathParser.RangeExprContext;
import org.eclipse.iee.translator.antlr.math.MathParser.StandardFunctionContext;
import org.eclipse.iee.translator.antlr.math.MathParser.VariableAssignmentContext;
import org.eclipse.iee.translator.antlr.math.MathParser.VariableContext;

public class TypeVisitior extends MathBaseVisitor<IVariableType> {

	private ExternalTranslationContext fExternalContext;

	public TypeVisitior(ExternalTranslationContext fExternalContext) {
		this.fExternalContext = fExternalContext;
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
		IVariableType left = visit(ctx.left);
		String right = ctx.right.getText();
		if (VariableType.MATRIX.equals(left) && right.matches("T")) {
			return VariableType.MATRIX;
		} else {
			return VariableType.DOUBLE;
		}
	}
	
	@Override
	public IVariableType visitVariable(VariableContext ctx) {
		String text = ctx.getText();
		String name = fExternalContext.translateName(text);
		return fExternalContext.getVariableType(name);
	}
	
	@Override
	public IVariableType visitStandardFunction(StandardFunctionContext ctx) {
		return fExternalContext.getFunctionType(ctx.name.getText());
	}
	
	@Override
	public IVariableType visitInternalFunction(InternalFunctionContext ctx) {
		return VariableType.DOUBLE;
	}
	
	@Override
	public IVariableType visitRangeExpr(RangeExprContext ctx) {
		return VariableType.RANGE;
	}
	
	@Override
	public IVariableType visitFunctionDefinition(FunctionDefinitionContext ctx) {
		return visit(ctx.value);
	}
	
	@Override
	public IVariableType visitMethodCall(MethodCallContext ctx) {
		ExpressionContext container = ctx.container;
		IVariableType containerType = visit(container);
		String text = ctx.func.name.getText();
		return containerType.getMethodType(text);
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
