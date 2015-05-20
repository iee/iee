package org.eclipse.iee.editor.core.pad.table.ui;

import org.eclipse.iee.core.document.PropertiesContainer;
import org.eclipse.iee.core.document.Property;
import org.eclipse.iee.editor.core.pad.table.TableColumn;
import org.eclipse.iee.editor.core.pad.table.TableCell;
import org.eclipse.iee.editor.core.pad.table.TablePart;

public class CellPropertiesModel {

	private TableCell fCell;
	
	public CellPropertiesModel(TableCell cell) {
		fCell = cell;
	}
	
	@Property(name = "Value", description = "Value")
	public String getValue() {
		return fCell.getValue();
	}
	
	public void setValue(String value) {
		fCell.setValue(value);
	}
	
	@PropertiesContainer(name = "Column", description = "Column")
	public TableColumn getColumn() {
		TablePart table = fCell.getTable();
		return table.getColumn(fCell);
	}
	
}
