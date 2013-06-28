package org.eclipse.iee.sample.formula;

import java.util.Map;

import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.sample.formula.pad.InputPad;

/**
 * {@link IPadFactory} implementation. Creates instance of formula pad.
 */
public class InputPadFactory implements IPadFactory {

	@Override
	public Pad create(Map<String, String> padParams, String value) {
		InputPad formulaPad = new InputPad();
		formulaPad.setOriginalExpression(value);
		formulaPad.setTranslatingExpression(value);
		return formulaPad;
	}

}
