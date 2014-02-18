/**
 * 
 */
package org.eclipse.iee.pad.formula;

import org.eclipse.iee.core.document.source.ISourceGenerator;
import org.eclipse.iee.core.document.source.ISourceGeneratorContext;

/**
 * @author aefimchuk
 *
 */
public class InputSourceGenerator implements ISourceGenerator<InputPart> {

	@Override
	public String getSource(InputPart part, ISourceGeneratorContext context) {
		if (part.getVariable().length() == 0) {
			return "";
		}
		
		String varName = part.getVariable();
		Double varValue = Double.parseDouble(part.getDefaultValue());
		
		StringBuilder sb = new StringBuilder();
		if (context.isInClassBody()) {
			sb.append("private static ").append("double ").append(varName).append("=").append(varValue).append("D;");
			sb.append("public static ").append("double ").append("get").append(varName).append("() {").append(" return ").append(varName).append(";}");
			sb.append("public static ").append("void ").append("set").append(varName).append("(").append("double _").append(varName).append(") {").append(varName).append("=_").append(varName).append(";}");
			String result = "org.eclipse.iee.core.EvaluationContextHolder.getParameter(\"" + part.getId() + "\")";
			sb.append("public static ").append("void ").append("set").append(varName).append("FromProvider(org.eclipse.iee.core.IParameterProvider prd) {")
				.append("if (").append(result).append(" != null) {")
				.append(varName).append("= Double.parseDouble(").append(result).append(");")
				.append("}")
				.append("}");

		} else {
			sb.append("double ").append(varName).append(";");
			String result = "org.eclipse.iee.core.EvaluationContextHolder.getParameter(\"" + part.getId() + "\")";
			sb.append("{").append("if (").append(result).append(" != null) {");
			sb.append(varName).append("= Double.parseDouble(").append(result).append(");");
			sb.append("} else {");
			sb.append(varName).append("=").append(varValue).append("D;");
			sb.append("}").append("}");
		}
		
		return sb.toString();
	}

}
