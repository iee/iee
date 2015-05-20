package org.eclipse.iee.editor.core.pad.table;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.iee.core.document.writer.IPadWriter;
import org.osgi.service.component.annotations.Component;

@Component
public class ProgressPadWriter implements IPadWriter<TablePart> {

	@Override
	public String getType() {
		return "TableInput";
	}

	@Override
	public String getValue(TablePart part) {
		String string = "";
		return string;
	}

	@Override
	public Map<String, String> getParams(TablePart part) {
		Map<String, String> params = new HashMap<>();
		return params;
	}

}