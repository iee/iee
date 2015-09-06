package org.eclipse.iee.pad.formula.ui;

import org.eclipse.iee.editor.core.bindings.DefaultObservableValue;
import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.IPadFactoryContext;
import org.eclipse.iee.pad.formula.FormulaPart;
import org.eclipse.iee.pad.formula.ui.utils.UIFormulaRenderer;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;

/**
 * {@link IPadFactory} implementation. Creates instance of formula pad.
 */
@Component
public class FormulaPadFactory implements IPadFactory<FormulaPart> {

	private UIFormulaRenderer formulaRenderer;
	
	@Override
	public FormulaPad create(FormulaPart part, IPadFactoryContext factoryContext) {
		FormulaPad formulaPad = new FormulaPad(formulaRenderer);
		formulaPad.bindDocumentPart(DefaultObservableValue.fromValue(part));
		return formulaPad;
	}

	@Reference(unbind = "unbindFormulaRenderer", policy = ReferencePolicy.DYNAMIC)
	public void bindFormulaRenderer(UIFormulaRenderer renderer) {
		formulaRenderer = renderer;
	}
	
	public void unbindFormulaRenderer(UIFormulaRenderer renderer) {
		formulaRenderer = null;
	}
	
}