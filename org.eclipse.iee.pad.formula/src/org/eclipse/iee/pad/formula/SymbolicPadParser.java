package org.eclipse.iee.pad.formula;

import java.util.Map;

import org.eclipse.iee.core.document.parser.IPadParser;

/**
 * {@link IPadParser} implementation. Creates instance of formula pad.
 */
public class SymbolicPadParser implements IPadParser {

	@Override
	public SymbolicPart create(Map<String, String> padParams, String value) {
		SymbolicPart symbolicPart = new SymbolicPart();
		symbolicPart.setId(padParams.get("id"));
		symbolicPart.setFormula(value);
		return symbolicPart;
	}

	@Override
	public String getType() {
		return "Symbolic";
	}
	
}
