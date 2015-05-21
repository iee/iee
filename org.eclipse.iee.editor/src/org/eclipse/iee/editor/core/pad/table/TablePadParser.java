package org.eclipse.iee.editor.core.pad.table;

import java.util.List;
import java.util.Map;

import org.eclipse.iee.core.document.parser.IPadParser;
import org.eclipse.iee.pad.formula.InputValidation;
import org.osgi.service.component.annotations.Component;

import com.google.common.base.Strings;
import com.google.gson.Gson;

@Component
public class TablePadParser implements IPadParser {

	@Override
	public TablePart create(Map<String, String> padParams, String value) {
		TablePart tablePart = new TablePart();
		
		String headersParam = padParams.get("header");
		String[] headers = new Gson().fromJson(headersParam, String[].class);
		for (String string : headers) {
			tablePart.addColumn(new TableColumn(string));
		}
		
		String validationParam = padParams.get("validation");
		if (!Strings.isNullOrEmpty(validationParam)) {
			InputValidation[] validations = new Gson().fromJson(validationParam, InputValidation[].class);
			List<TableColumn> columns = tablePart.getColumns();
			for (int i = 0; i < columns.size(); i++) {
				TableColumn tableColumn = columns.get(i);
				tableColumn.setValidation(validations[i]);
			}
		}
		
		String string = value.replace("Matrix=", "");
		String[][] fromJson = new Gson().fromJson(string, String[][].class);
		for (int i = 0; i < fromJson.length; i++) {
			tablePart.addRow(new TableRow());
			for (int j = 0; j < fromJson[i].length; j++) {
				tablePart.setCell(i, j, new TableCell(fromJson[i][j]));
			}
		}
		
		return tablePart;
	}

	@Override
	public String getType() {
		return "TableInput";
	}

}