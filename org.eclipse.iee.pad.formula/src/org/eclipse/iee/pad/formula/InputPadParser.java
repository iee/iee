package org.eclipse.iee.pad.formula;

import java.util.Map;

import org.eclipse.iee.core.document.parser.IPadParser;

/**
 * {@link IPadParser} implementation. Creates instance of formula pad.
 */
public class InputPadParser implements IPadParser {

	@Override
	public InputPart create(Map<String, String> padParams, String value) {
		InputPart inputPad = new InputPart();
		inputPad.setId(padParams.get("id"));
		String[] expressions = value.split("=");
		String varName = expressions[0];
		inputPad.setVariable(varName);
		if (expressions.length > 1) {
			String defValue = expressions[1];
			inputPad.setDefaultValue(defValue);
		}
		return inputPad;
	}
	
	@Override
	public String getType() {
		return "Input";
	}

}
