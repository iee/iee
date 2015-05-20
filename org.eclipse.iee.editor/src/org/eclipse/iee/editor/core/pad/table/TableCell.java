package org.eclipse.iee.editor.core.pad.table;

import org.eclipse.iee.core.document.DocumentPart;

public class TableCell extends DocumentPart {

	private String fValue;

	private TablePart fTablePart;
	
	public TableCell() {
	}

	public TableCell(String value) {
		fValue = value;
	}

	public String getValue() {
		return fValue;
	}
	
	public void setValue(String value) {
		String oldValue = fValue;
		fValue = value;
		getPropertyChangeSupport().firePropertyChange("value", oldValue, value);
	}

	public TablePart getTable() {
		return fTablePart;
	}
	
	void setTablePart(TablePart tablePart) {
		fTablePart = tablePart;
	}
	
}
