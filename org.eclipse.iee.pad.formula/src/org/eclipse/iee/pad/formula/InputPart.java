package org.eclipse.iee.pad.formula;

import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.core.document.PropertiesContainer;

public class InputPart extends PadDocumentPart {

	private String variable;

	private String defaultValue;

	@PropertiesContainer(name = "Validation", description = "Validation")
	private InputValidation validation;

	public InputPart() {
		validation = new InputValidation();
	}
	
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

	public InputValidation getValidation() {
		return validation;
	}

	public void setValidation(InputValidation validation) {
		this.validation = validation;
	}

	public InputPart copy() {
		InputPart clone = new InputPart();
		clone.setDefaultValue(getDefaultValue());
		clone.setVariable(getVariable());
		clone.setValidation(getValidation());
		return clone;
	}

}
