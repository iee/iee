package org.eclipse.iee.editor.core.pad.table;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.iee.core.document.PadDocumentPart;

import com.google.common.base.Supplier;
import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;

public class TablePart extends PadDocumentPart {

	private List<TableColumn> columns = Lists.newArrayList();

	private List<TableRow> rows = Lists.newArrayList();
	
	private Table<Integer, Integer, TableCell> cells = Tables.newCustomTable(new HashMap<Integer, Map<Integer, TableCell>>(), new Supplier<Map<Integer, TableCell>>() {

		@Override
		public Map<Integer, TableCell> get() {
			return new HashMap<Integer, TableCell>();
		}
	});
	
	public void addColumn(TableColumn column) {
		List<TableColumn> oldValue = Lists.newArrayList(columns);
		columns.add(column);
		getPropertyChangeSupport().firePropertyChange("columns", oldValue, columns);
	}
	
	public void removeColumn(TableColumn column) {
		List<TableColumn> oldValue = Lists.newArrayList(columns);
		columns.remove(column);
		getPropertyChangeSupport().firePropertyChange("columns", oldValue, columns);
	}
	
	public List<TableColumn> getColumns() {
		return Collections.unmodifiableList(columns);
	}
	
	public void setColumns(List<TableColumn> columns) {
		List<TableColumn> oldValue = Lists.newArrayList(columns);
		this.columns = Lists.newArrayList(columns);
		getPropertyChangeSupport().firePropertyChange("columns", oldValue, columns);
	}
	
	public void addRow(TableRow row) {
		List<TableRow> oldValue = Lists.newArrayList(rows);
		rows.add(row);
		getPropertyChangeSupport().firePropertyChange("rows", oldValue, rows);
	}
	
	public void removeRow(TableRow row) {
		List<TableRow> oldValue = Lists.newArrayList(rows);
		rows.remove(row);
		getPropertyChangeSupport().firePropertyChange("rows", oldValue, rows);
	}
	
	public List<TableRow> getRows() {
		return Collections.unmodifiableList(rows);
	}
	
	public TableCell getCell(int row, int column) {
		TableCell tableCell = cells.get(row, column);
		if (tableCell == null) {
			tableCell = new TableCell();
			tableCell.setTablePart(this);
			cells.put(row, column, tableCell);
		}
		return tableCell;
	}

	public int getRowCount() {
		if (cells.size() == 0) {
			return 0;
		}
		return Collections.max(cells.rowKeySet()) + 1;
	}
	
	public int getColumnCount() {
		return columns.size();
	}	
	
	@Override
	public TablePart copy() {
		TablePart tablePart = new TablePart();
		return tablePart;
	}

	public void setCell(int row, int column, TableCell cell) {
		Table<Integer, Integer, TableCell> oldValue = copyCells();
		cell.setTablePart(this);
		cells.put(row, column, cell);
		getPropertyChangeSupport().firePropertyChange("cells", oldValue, cells);
	}

	private Table<Integer, Integer, TableCell> copyCells() {
		Table<Integer, Integer, TableCell> oldValue = Tables.newCustomTable(new HashMap<Integer, Map<Integer, TableCell>>(), new Supplier<Map<Integer, TableCell>>() {
			@Override
			public Map<Integer, TableCell> get() {
				return new HashMap<Integer, TableCell>();
			}
		});
		oldValue.putAll(cells);
		return oldValue;
	}

	public TableColumn getColumn(TableCell cell) {
		Set<com.google.common.collect.Table.Cell<Integer,Integer, TableCell>> cellSet = cells.cellSet();
		for (com.google.common.collect.Table.Cell<Integer, Integer, TableCell> c : cellSet) {
			if (c.getValue() == cell) {
				return getColumns().get(c.getColumnKey());
			}
		}
		return null;
	}

	public void addColumnAfter(TableColumn after, TableColumn newColumn) {
		List<TableColumn> oldValue = Lists.newArrayList(columns);
		int size = getColumnCount();
		int indexOf = columns.indexOf(after);
		if (indexOf + 1 < size) {
			columns.add(indexOf + 1, newColumn);
		} else {
			columns.add(newColumn);
		}
		for (int i = 0; i < getRowCount(); i++) {
			for (int j = size - 1; j > indexOf; j--) {
				TableCell value = cells.get(i, j);
				if (value != null) {
					cells.put(i, j + 1, value);
					cells.remove(i, j);
				}
			}
		}
		getPropertyChangeSupport().firePropertyChange("columns", oldValue, columns);
		getPropertyChangeSupport().firePropertyChange("cells", oldValue, columns);
	}

	public void addColumnBefore(TableColumn before, TableColumn newColumn) {
		List<TableColumn> oldValue = Lists.newArrayList(columns);
		Table<Integer, Integer, TableCell> oldCells = copyCells();
		int size = getColumnCount();
		int indexOf = columns.indexOf(before);
		columns.add(indexOf, newColumn);
		for (int i = 0; i < getRowCount(); i++) {
			for (int j = size - 1; j >= indexOf; j--) {
				TableCell value = cells.get(i, j);
				if (value != null) {
					cells.put(i, j + 1, value);
					cells.remove(i, j);
				}
			}
		}
		getPropertyChangeSupport().firePropertyChange("columns", oldValue, columns);
		getPropertyChangeSupport().firePropertyChange("cells", oldCells, cells);
	}

	public TableRow getRow(TableCell cell) {
		Set<com.google.common.collect.Table.Cell<Integer,Integer, TableCell>> cellSet = cells.cellSet();
		for (com.google.common.collect.Table.Cell<Integer, Integer, TableCell> c : cellSet) {
			if (c.getValue() == cell) {
				return getRows().get(c.getRowKey());
			}
		}
		return null;
	}

	public void addRowAfter(TableRow after, TableRow newRow) {
		List<TableRow> oldValue = Lists.newArrayList(rows);
		Table<Integer, Integer, TableCell> oldCells = copyCells();
		int size = getRowCount();
		int indexOf = rows.indexOf(after);
		if (indexOf + 1 < size) {
			rows.add(indexOf + 1, newRow);
		} else {
			rows.add(newRow);
		}
		for (int i = size - 1; i > indexOf; i--) {
			for (int j = 0; j < getColumnCount(); j++) {
				TableCell value = cells.get(i, j);
				if (value != null) {
					cells.put(i + 1, j, value);
					cells.remove(i, j);
				}
			}
		}
		getPropertyChangeSupport().firePropertyChange("rows", oldValue, rows);
		getPropertyChangeSupport().firePropertyChange("cells", oldCells, cells);
	}
	
	public void addRowBefore(TableRow before, TableRow newRow) {
		List<TableRow> oldValue = Lists.newArrayList(rows);
		Table<Integer, Integer, TableCell> oldCells = copyCells();
		int size = getRowCount();
		int indexOf = rows.indexOf(before);
		rows.add(indexOf, newRow);
		for (int i = size - 1; i >= indexOf; i--) {
			for (int j = 0; j < getColumnCount(); j++) {
				TableCell value = cells.get(i, j);
				if (value != null) {
					cells.put(i + 1, j, value);
					cells.remove(i, j);
				}
			}
		}
		getPropertyChangeSupport().firePropertyChange("rows", oldValue, rows);
		getPropertyChangeSupport().firePropertyChange("cells", oldCells, cells);
	}

}
