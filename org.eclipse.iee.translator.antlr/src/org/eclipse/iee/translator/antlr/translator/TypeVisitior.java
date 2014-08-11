package org.eclipse.iee.translator.antlr.translator;

import org.eclipse.iee.translator.antlr.math.MathBaseVisitor;
import org.eclipse.iee.translator.antlr.math.MathParser.FloatNumberContext;
import org.eclipse.iee.translator.antlr.math.MathParser.IntNumberContext;
import org.eclipse.iee.translator.antlr.math.MathParser.InternalFunctionContext;
import org.eclipse.iee.translator.antlr.math.MathParser.MatrixContext;
import org.eclipse.iee.translator.antlr.math.MathParser.StandardFunctionContext;
import org.eclipse.iee.translator.antlr.math.MathParser.VariableContext;
import org.eclipse.iee.translator.antlr.translator.JavaTranslator.VariableType;

public class TypeVisitior extends MathBaseVisitor<VariableType> {

	private ExternalTranslationContext fExternalContext;

	public TypeVisitior(ExternalTranslationContext fExternalContext) {
		this.fExternalContext = fExternalContext;
	}

	@Override
	public VariableType visitIntNumber(IntNumberContext ctx) {
		return VariableType.INT;
	}
	
	@Override
	public VariableType visitFloatNumber(FloatNumberContext ctx) {
		return VariableType.DOUBLE;
	}
	
	@Override
	public VariableType visitMatrix(MatrixContext ctx) {
		return VariableType.MATRIX;
	}
	
	@Override
	public VariableType visitVariable(VariableContext ctx) {
		String text = ctx.getText();
		String name = fExternalContext.translateName(text);
		return fExternalContext.getVariableType(name);
	}
	
	@Override
	public VariableType visitStandardFunction(StandardFunctionContext ctx) {
		return VariableType.DOUBLE;
	}
	
	@Override
	public VariableType visitInternalFunction(InternalFunctionContext ctx) {
		return VariableType.DOUBLE;
	}
	
	@Override
	protected VariableType aggregateResult(VariableType aggregate,
			VariableType nextResult) {
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
		throw new UnsupportedOperationException();
	}
	
}
