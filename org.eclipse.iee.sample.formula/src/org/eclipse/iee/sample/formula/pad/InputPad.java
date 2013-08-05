package org.eclipse.iee.sample.formula.pad;

public class InputPad extends FormulaPad {

	
	@Override
	protected String generateCode() {
		if (fTranslatingExpression.length() == 0) {
			return "";
		}
		
		String[] expressions = fTranslatingExpression.split("=");
		
		String varName = expressions[0];
		Double varValue = Double.parseDouble(expressions[1]);
		
		StringBuilder sb = new StringBuilder();
		sb.append("double ").append(varName).append(";");
		String result = "org.eclipse.iee.document.api.EvaluationContextHolder.getParameter(\"" + getContainerID() + "\")";
		sb.append("if (").append(result).append(" != null) {");
		sb.append(varName).append("= Double.parseDouble(").append(result).append(");");
		sb.append("} else {");
		sb.append(varName).append("=").append(varValue).append("D;");
		sb.append("}");
		
		return sb.toString();
	}
	
	@Override
	public String getType() {
		return "Input";
	}

	public String getVariableExpression() {
		String[] expressions = fTranslatingExpression.split("=");
		String varName = expressions[0];
		return varName + "=";
	}

	public String getDefaultValue() {
		String[] expressions = fTranslatingExpression.split("=");
		return expressions[1];
	}
	
}
