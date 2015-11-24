package org.eclipse.iee.pad.formula.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.iee.editor.core.container.TextRenderCtx;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.pad.formula.FormulaPart;
import org.eclipse.iee.pad.formula.ui.utils.UIFormulaRenderer;

@SuppressWarnings("unused")
public class FormulaPad extends AbstractFormulaPad<FormulaPart> {

	private PropertyChangeListener fListener;
	
	public FormulaPad(UIFormulaRenderer formulaRenderer, TextRenderCtx renderCtx) {
		super(formulaRenderer, renderCtx);
		fListener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("formula".equals(evt.getPropertyName())) {
					updateFormula((String) evt.getNewValue());
				}
			}
		};
	}
	
	@Override
	public void processInput() {
		super.processInput();
		getDocumentPart().setFormula(fOriginalExpression);
		getContainer().updateDocument();
	}
	
	@Override
	protected void doBindValue(FormulaPart value) {
		value.addPropertyChangeListener(fListener);
		updateFormula(value.getFormula());
	}
	
	@Override
	protected void doUnbindValue(FormulaPart oldValue) {
		oldValue.removePropertyChangeListener(fListener);
	}
	
	private void updateFormula(String formula) {
		setTranslatingExpression(formula);
		setOriginalExpression(formula);
	}
	
}
