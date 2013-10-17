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
		sb.append("double ").append(varName).append(";");
		String result = "org.eclipse.iee.core.EvaluationContextHolder.getParameter(\"" + part.getId() + "\")";
		sb.append("if (").append(result).append(" != null) {");
		sb.append(varName).append("= Double.parseDouble(").append(result).append(");");
		sb.append("} else {");
		sb.append(varName).append("=").append(varValue).append("D;");
		sb.append("}");
		
		return sb.toString();
	}

}
