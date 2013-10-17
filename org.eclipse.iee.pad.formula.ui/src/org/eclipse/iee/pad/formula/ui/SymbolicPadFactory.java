package org.eclipse.iee.pad.formula.ui;

import java.util.Map;

import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.pad.formula.SymbolicPart;

/**
 * {@link IPadFactory} implementation. Creates instance of formula pad.
 */
public class SymbolicPadFactory implements IPadFactory<SymbolicPart> {

	@Override
	public Pad create(SymbolicPart part) {
		SymbolicPad formulaPad = new SymbolicPad(part);
		return formulaPad;
	}

}
