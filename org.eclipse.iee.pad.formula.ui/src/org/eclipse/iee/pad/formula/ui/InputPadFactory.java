package org.eclipse.iee.pad.formula.ui;

import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.pad.formula.InputPart;
import org.osgi.service.component.annotations.Component;

/**
 * {@link IPadFactory} implementation. Creates instance of formula pad.
 */
@Component
public class InputPadFactory implements IPadFactory<InputPart> {

	@Override
	public InputPad create(InputPart part) {
		InputPad formulaPad = new InputPad(part);
		return formulaPad;
	}
	
}
