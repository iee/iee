package org.eclipse.iee.pad.formula;

import org.eclipse.iee.core.document.PadDocumentPart;

public class InputPart extends PadDocumentPart {

	private String variable;

	private String defaultValue;

	public String getVariable() {
		return variable != null ? variable : "";
	}

	public void setVariable(String variable) {
		this.variable = variable;
	}

	public String getDefaultValue() {
		return defaultValue != null ? defaultValue : "";
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	public InputPart copy() {
		InputPart clone = new InputPart();
		clone.setDefaultValue(getDefaultValue());
		clone.setVariable(getVariable());
		return clone;
	}

}
