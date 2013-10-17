package org.eclipse.iee.pad.formula;

import java.util.Map;

import org.eclipse.iee.core.document.parser.IPadParser;

/**
 * {@link IPadParser} implementation. Creates instance of formula pad.
 */
public class FormulaPadParser implements IPadParser {

	@Override
	public FormulaPart create(Map<String, String> padParams, String value) {
		FormulaPart formulaPad = new FormulaPart();
		formulaPad.setId(padParams.get("id"));
		formulaPad.setFormula(value);
		return formulaPad;
	}

	@Override
	public String getType() {
		return "Formula";
	}
	
}