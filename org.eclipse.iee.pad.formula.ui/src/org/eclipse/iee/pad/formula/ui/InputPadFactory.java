package org.eclipse.iee.pad.formula.ui;

import java.util.Map;

import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.pad.formula.InputPart;

/**
 * {@link IPadFactory} implementation. Creates instance of formula pad.
 */
public class InputPadFactory implements IPadFactory<InputPart> {

	@Override
	public Pad create(InputPart part) {
		InputPad formulaPad = new InputPad(part);
		return formulaPad;
	}
	
}
