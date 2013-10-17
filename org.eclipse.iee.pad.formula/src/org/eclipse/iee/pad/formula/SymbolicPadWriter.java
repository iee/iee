package org.eclipse.iee.pad.formula;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.iee.core.document.writer.IPadWriter;

/**
 * {@link IPadWriter} implementation. Creates instance of symbolic pad.
 */
public class SymbolicPadWriter implements IPadWriter<SymbolicPart> {

	@Override
	public String getType() {
		return "Symbolic";
	}

	@Override
	public String getValue(SymbolicPart part) {
		return part.getFormula();
	}

	@Override
	public Map<String, String> getParams(SymbolicPart part) {
		return new HashMap<>();
	}
	
}
