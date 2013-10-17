package org.eclipse.iee.pad.formula;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.iee.core.document.parser.IPadParser;
import org.eclipse.iee.core.document.writer.IPadWriter;

/**
 * {@link IPadParser} implementation. Writer instance of formula pad.
 */
public class FormulaPadWriter implements IPadWriter<FormulaPart> {

	@Override
	public String getType() {
		return "Formula";
	}

	@Override
	public String getValue(FormulaPart part) {
		return part.getFormula();
	}

	@Override
	public Map<String, String> getParams(FormulaPart part) {
		return new HashMap<>();
	}
	
}