package org.eclipse.iee.pad.formula.ui;

import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.pad.formula.SymbolicPart;
import org.osgi.service.component.annotations.Component;

/**
 * {@link IPadFactory} implementation. Creates instance of formula pad.
 */
@Component
public class SymbolicPadFactory implements IPadFactory<SymbolicPart> {

	@Override
	public SymbolicPad create(SymbolicPart part) {
		SymbolicPad formulaPad = new SymbolicPad(part);
		return formulaPad;
	}

}
