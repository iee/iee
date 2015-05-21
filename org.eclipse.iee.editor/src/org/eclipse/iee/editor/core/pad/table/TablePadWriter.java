package org.eclipse.iee.editor.core.pad.table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.iee.core.document.writer.IPadWriter;
import org.eclipse.iee.pad.formula.InputValidation;
import org.osgi.service.component.annotations.Component;

import com.google.gson.Gson;

@Component
public class TablePadWriter implements IPadWriter<TablePart> {

	@Override
	public String getType() {
		return "TableInput";
	}

	@Override
	public String getValue(TablePart part) {
		StringBuilder sb = new StringBuilder("Matrix=");
		sb.append("[");
		for (int i = 0; i < part.getRowCount(); i++) {
			if (i > 0) {
				sb.append(", ");
			}
			sb.append("[");
			for (int j = 0; j < part.getColumnCount(); j++) {
				if (j > 0) {
					sb.append(", ");
				}
				sb.append(part.getCell(i, j).getValue());
			}
			sb.append("]");
		}
		sb.append("]");
		
		return sb.toString();
	}

	@Override
	public Map<String, String> getParams(TablePart part) {
		Map<String, String> params = new HashMap<>();
		List<TableColumn> columns = part.getColumns();
		InputValidation[] validation = new InputValidation[columns.size()];
		String[] header = new String[columns.size()];
		for (int i = 0; i < columns.size(); i++) {
			validation[i] = columns.get(i).getValidation();
			header[i] = columns.get(i).getHeader();
		}
		params.put("validation", new Gson().toJson(validation));
		params.put("header", new Gson().toJson(header));
		return params;
	}

}