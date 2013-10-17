package org.eclipse.iee.pad.formula;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.iee.core.document.parser.IPadParser;
import org.eclipse.iee.core.document.writer.IPadWriter;

/**
 * {@link IPadWriter} implementation. Writes instance of input pad.
 */
public class InputPadWriter implements IPadWriter<InputPart> {

	@Override
	public String getType() {
		return "Input";
	}

	@Override
	public String getValue(InputPart part) {
		return part.getVariable() + "=" + part.getDefaultValue();
	}

	@Override
	public Map<String, String> getParams(InputPart part) {
		return new HashMap<>();
	}

}
