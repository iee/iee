package org.eclipse.iee.pad.formula.ui;

import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.pad.formula.FormulaPart;

public class FormulaPad extends AbstractFormulaPad<FormulaPart> {

	public FormulaPad(FormulaPart part) {
		super(part);
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
	public Pad copy() {
		FormulaPad newPad = new FormulaPad(getDocumentPart().copy());
		return newPad;
	}
}
