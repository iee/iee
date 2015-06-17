package org.eclipse.iee.pad.formula.ui;

import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.pad.formula.FormulaPart;
import org.eclipse.iee.pad.formula.ui.utils.UIFormulaRenderer;

@SuppressWarnings("unused")
public class FormulaPad extends AbstractFormulaPad<FormulaPart> {

	public FormulaPad(UIFormulaRenderer formulaRenderer) {
		super(formulaRenderer);
	}
	
	@Override
	public void processInput() {
		super.processInput();
		getDocumentPart().setFormula(fOriginalExpression);
		getContainer().updateDocument();
	}
	
	@Override
	protected void onValueChanged(FormulaPart oldValue, FormulaPart newValue) {
		setTranslatingExpression(newValue.getFormula());
		setOriginalExpression(newValue.getFormula());
	}
	
}
