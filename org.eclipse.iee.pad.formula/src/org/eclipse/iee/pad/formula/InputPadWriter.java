package org.eclipse.iee.pad.formula;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.iee.core.document.writer.IPadWriter;
import org.osgi.service.component.annotations.Component;

/**
 * {@link IPadWriter} implementation. Writes instance of input pad.
 */
@Component
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
