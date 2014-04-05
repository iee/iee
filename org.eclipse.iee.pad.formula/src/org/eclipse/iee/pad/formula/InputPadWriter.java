package org.eclipse.iee.pad.formula;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.iee.core.document.writer.IPadWriter;
import org.osgi.service.component.annotations.Component;

import com.google.gson.Gson;

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
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("validation", new Gson().toJson(part.getValidation()));
		return hashMap;
	}

}
