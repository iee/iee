package org.eclipse.iee.sample.formula;

import java.util.Map;

import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.sample.formula.pad.FormulaPad;

/**
 * {@link IPadFactory} implementation. Creates instance of formula pad.
 */
public class FormulaPadFactory implements IPadFactory {

	@Override
	public Pad create(Map<String, String> padParams, String value) {
		FormulaPad formulaPad = new FormulaPad();
		formulaPad.setOriginalExpression(value);
		formulaPad.setTranslatingExpression(value);
		return formulaPad;
	}

}