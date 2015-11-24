package org.eclipse.iee.pad.formula.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.iee.editor.core.container.TextRenderCtx;
import org.eclipse.iee.pad.formula.FormulaPart;
import org.eclipse.iee.pad.formula.InputPart;
import org.eclipse.iee.pad.formula.ui.utils.UIFormulaRenderer;

public class InputPad extends AbstractFormulaPad<InputPart> {

	private PropertyChangeListener fListener;
	
	public InputPad(UIFormulaRenderer formulaRenderer, TextRenderCtx renderCtx) {
		super(formulaRenderer, renderCtx);
		fListener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("variable".equals(evt.getPropertyName())
						|| "defaultValue".equals(evt.getPropertyName())) {
					onValueChanged((InputPart) evt.getSource());
				}
			}
		};
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
		return varName;
	}

	public String getDefaultValue() {
		String[] expressions = fTranslatingExpression.split("=");
		return expressions.length > 1 ? expressions[1] : "";
	}
	
	protected void onValueChanged(InputPart part) {
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
	protected void doBindValue(InputPart value) {
		value.addPropertyChangeListener(fListener);
		onValueChanged(value);
	}
	
	@Override
	protected void doUnbindValue(InputPart oldValue) {
		oldValue.removePropertyChangeListener(fListener);
	}
	
}
