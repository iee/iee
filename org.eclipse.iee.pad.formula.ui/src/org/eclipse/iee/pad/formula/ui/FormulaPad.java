package org.eclipse.iee.pad.formula.ui;

import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.pad.formula.FormulaPart;
import org.eclipse.iee.pad.formula.ui.utils.UIFormulaRenderer;

@SuppressWarnings("unused")
public class FormulaPad extends AbstractFormulaPad<FormulaPart> {

	public FormulaPad(FormulaPart part, UIFormulaRenderer formulaRenderer) {
		super(part, formulaRenderer);
		setTranslatingExpression(part.getFormula());
		setOriginalExpression(part.getFormula());
	}
	
	@Override
	public void processInput() {
		super.processInput();
		getDocumentPart().setFormula(fOriginalExpression);
		getContainer().updateDocument();
	}
	
	@Override
	public FormulaPad copy() {
		FormulaPad newPad = new FormulaPad(getDocumentPart().copy(), getFormulaRenderer());
		return newPad;
	}
}
