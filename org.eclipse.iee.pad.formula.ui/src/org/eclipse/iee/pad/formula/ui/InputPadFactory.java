package org.eclipse.iee.pad.formula.ui;

import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.pad.formula.InputPart;
import org.eclipse.iee.pad.formula.ui.utils.UIFormulaRenderer;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;

/**
 * {@link IPadFactory} implementation. Creates instance of formula pad.
 */
@Component
public class InputPadFactory implements IPadFactory<InputPart> {

	private UIFormulaRenderer formulaRenderer;
	
	@Override
	public InputPad create(InputPart part) {
		InputPad formulaPad = new InputPad(part, formulaRenderer);
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
