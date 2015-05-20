package org.eclipse.iee.editor.core.pad.table;

import java.util.Map;

import org.eclipse.iee.core.document.parser.IPadParser;
import org.osgi.service.component.annotations.Component;

@Component
public class TablePadParser implements IPadParser {

	@Override
	public TablePart create(Map<String, String> padParams, String value) {
		TablePart tablePart = new TablePart();
		return tablePart;
	}

	@Override
	public String getType() {
		return "TableInput";
	}

}