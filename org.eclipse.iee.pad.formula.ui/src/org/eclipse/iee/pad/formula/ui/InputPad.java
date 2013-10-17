package org.eclipse.iee.pad.formula.ui;

import org.eclipse.iee.pad.formula.InputPart;

public class InputPad extends AbstractFormulaPad<InputPart> {

	public InputPad(InputPart part) {
		super(part);
		String expression = "";
		if (!part.getVariable().isEmpty()) {
			expression += part.getVariable();
		}
		if (!part.getDefaultValue().isEmpty()) {
			expression += "=" + part.getDefaultValue();
		}
		setTranslatingExpression(expression);
		setOriginalExpression(expression);
	}

	@Override
	public void processInput() {
		super.processInput();
		getDocumentPart().setDefaultValue(getDefaultValue());
		getDocumentPart().setVariable(getVariableExpression());
		getContainer().updateDocument();
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
	
	@Override
	public InputPad copy() {
		InputPad newPad = new InputPad(getDocumentPart().copy());
		return newPad;
	}
	
}
