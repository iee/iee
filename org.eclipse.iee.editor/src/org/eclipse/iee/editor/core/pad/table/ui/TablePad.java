package org.eclipse.iee.editor.core.pad.table.ui;

import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.iee.editor.core.container.ITextEditor;
import org.eclipse.iee.editor.core.pad.FigurePad;
import org.eclipse.iee.editor.core.pad.common.text.IEditorLocation;
import org.eclipse.iee.editor.core.pad.common.text.TextPartEditor;
import org.eclipse.iee.editor.core.pad.table.TableCell;
import org.eclipse.iee.editor.core.pad.table.TableColumn;
import org.eclipse.iee.editor.core.pad.table.TablePart;
import org.eclipse.swt.graphics.Color;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

public class TablePad extends FigurePad<TablePart, IFigure> {

	private GridLayout fManager;
	
	private Figure fTable;

	private RectangleFigure fColumnHighlighter;

	private RectangleFigure fRowHighlighter;
	
	private List<TextPartEditor> cells = Lists.newArrayList();

	private PropertyChangeListener fListener;
	
	public TablePad() {
		fListener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("cells".equals(evt.getPropertyName()) 
						|| "columns".equals(evt.getPropertyName())
						|| "rows".equals(evt.getPropertyName())) {
					updateTable(fTable);
					getContainer().updateDocument();
				}
			}
		};
	}

	@Override
	public IFigure createFigure() {
		fTable = new Figure();
		fTable.setMinimumSize(new Dimension(20, 20));
		
		fManager = new GridLayout();
		fManager.horizontalSpacing = 0;
		fManager.verticalSpacing = 0;
		fManager.marginHeight = 0;
		fManager.marginWidth = 0;
		fTable.setLayoutManager(fManager);
		fTable.setBorder(new TableFigureBorder());
		
		fColumnHighlighter = new RectangleFigure();
		fColumnHighlighter.setForegroundColor(new Color(null, 0, 255, 0));
		fColumnHighlighter.setBounds(new org.eclipse.draw2d.geometry.Rectangle(10, 10, 10, 10));
		fColumnHighlighter.setOpaque(false);
		fColumnHighlighter.setFill(false);
		
		fRowHighlighter = new RectangleFigure();
		fRowHighlighter.setForegroundColor(new Color(null, 0, 255, 0));
		fRowHighlighter.setBounds(new org.eclipse.draw2d.geometry.Rectangle(10, 10, 10, 10));
		fRowHighlighter.setOpaque(false);
		fRowHighlighter.setFill(false);
		
		fTable.addMouseMotionListener(new MouseMotionListener.Stub() {

			@Override
			public void mouseMoved(MouseEvent me) {
				int column = getColumn(me.x);
				int row = getRow(me.y);
				if (column != -1 && row != -1) {
					enableHighlight();
					org.eclipse.draw2d.geometry.Rectangle bounds = fTable.getBounds();
					fColumnHighlighter.setBounds(new org.eclipse.draw2d.geometry.Rectangle(getColumnOffset(column), bounds.y, getColumnWidth(column), bounds.height));
					fRowHighlighter.setBounds(new org.eclipse.draw2d.geometry.Rectangle(bounds.x, getRowOffset(row), bounds.width, getRowWidth(row)));
				} else {
					disableHighlight();
				}
			}

			@Override
			public void mouseExited(MouseEvent me) {
				disableHighlight();
			}
			
			private int getColumn(int x) {
				int[] columnWidths = fManager.getColumnWidths();
				int offset = fTable.getLocation().x;
				for (int i = 0; i < columnWidths.length; i++) {
					int width = getColumnWidth(i);
					if (x >= offset && x < (offset + width)) {
						return i;
					}
					offset = offset + width;
				}
				return -1;
			}
			
			private int getColumnOffset(int column) {
				int offset = fTable.getLocation().x;
				for (int i = 0; i < column; i++) {
					offset += getColumnWidth(column);
				}
				return offset;
			}

			private int getColumnWidth(int column) {
				int columnWidth = fManager.getColumnWidths()[column];
				return calcFullColumnWidth(fManager, columnWidth);
			}

			private int calcFullColumnWidth(final GridLayout manager, int columnWidth) {
				return columnWidth + manager.horizontalSpacing;
			}

			private int getRow(int y) {
				int[] rowHeights = fManager.getRowHeights();
				int offset = fTable.getLocation().y;
				for (int i = 0; i < rowHeights.length; i++) {
					int height = getRowWidth(i);
					if (y >= offset && y < (offset + height)) {
						return i;
					}
					offset = offset + height;
				}
				return -1;
			}
			
			private int getRowOffset(int row) {
				int offset = fTable.getLocation().y;
				for (int i = 0; i < row; i++) {
					offset += getRowWidth(row);
				}
				return offset;
			}

			private int getRowWidth(int row) {
				int rowWidth = fManager.getRowHeights()[row];
				return calcFullRowHeight(fManager, rowWidth);
			}

			private int calcFullRowHeight(final GridLayout manager, int rowWidth) {
				return rowWidth + manager.verticalSpacing;
			}
			
		});
		
		
		updateTable(fTable);
		
		return fTable;
	}

	private void updateTable(final Figure table) {
		table.removeAll();
		createHeader(table);
		createContent(table);
	}

	private void createContent(Figure table) {
		TablePart documentPart = getDocumentPart();
		for (int i = 0; i < documentPart.getRowCount(); i++) {
			for (int j = 0; j < documentPart.getColumnCount(); j++) {
				TableCell cell = documentPart.getCell(i, j);
				TableCellEditor tableCellEditor = new TableCellEditor();
				addCellEditor(tableCellEditor);
			}
		}
	}
	
	private void addColumnEditor(TableColumnEditor tableColumnEditor) {
		addEditor(tableColumnEditor);
		IFigure figure = tableColumnEditor.getFigure();
		fTable.add(figure, new GridData(GridData.FILL, GridData.FILL, true, true));
	}

	private void addCellEditor(TableCellEditor tableCellEditor) {
		addEditor(tableCellEditor);
		IFigure figure = tableCellEditor.getFigure();
		fTable.add(figure, new GridData(GridData.FILL, GridData.FILL, true, true));
	}

	private void createHeader(Figure table) {
		TablePart documentPart = getDocumentPart();
		List<TableColumn> columns = documentPart.getColumns();
		fManager.numColumns = columns.size();
		for (TableColumn column : columns) {
			createColumn(table, column);
		}
		
		if (columns.size() == 0) {
			createColumn(table, new TableColumn("TBD"));
		}
	}

	private void createColumn(Figure table, TableColumn column) {
		TableColumnEditor tableCellEditor = new TableColumnEditor();
		addColumnEditor(tableCellEditor);
	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void save() {
	}

	@Override
	public String getType() {
		return "TableInput";
	}

	@Override
	public String getTex() {
		return "";
	}

	public Rectangle getBounds() {
		org.eclipse.draw2d.geometry.Rectangle bounds = fTable.getBounds();
		return new Rectangle(bounds.x, bounds.y, bounds.width, bounds.height);
	}

	@Override
	public void setBounds(Rectangle bounds) {
		org.eclipse.draw2d.geometry.Rectangle d2dBounds = new org.eclipse.draw2d.geometry.Rectangle(bounds.x, bounds.y, bounds.width, bounds.height);
		fTable.setBounds(d2dBounds);
		getContainer().getMainFigure().setConstraint(fTable, new org.eclipse.draw2d.geometry.Rectangle(bounds.x, bounds.y, -1, -1));
		updateSelectionBounds(bounds);
	}

	@Override
	public void setVisible(boolean isVisible) {
		fTable.setVisible(isVisible);
	}
	
	private void enableHighlight() {
		getFeedbackLayer().add(fColumnHighlighter);
		getFeedbackLayer().add(fRowHighlighter);
	}

	private void disableHighlight() {
		if (fColumnHighlighter.getParent() != null) {
			getFeedbackLayer().remove(fColumnHighlighter);
		}
		if (fRowHighlighter.getParent() != null) {
			getFeedbackLayer().remove(fRowHighlighter);
		}
	}
	
	private IFigure getFeedbackLayer() {
		return getContainer().getFeedbackFigure();
	}
	
	public static class TableFigureBorder extends AbstractBorder {
		public Insets getInsets(IFigure figure) {
			return new Insets(1, 1, 0, 0);
		}

		public void paint(IFigure figure, Graphics graphics, Insets insets) {
			org.eclipse.draw2d.geometry.Rectangle paintRectangle = getPaintRectangle(figure, insets);
			graphics.drawLine(paintRectangle.getTopLeft(),
					paintRectangle.getBottomLeft());
			graphics.drawLine(paintRectangle.getTopLeft(),
					paintRectangle.getTopRight());
		}
	}
	
	public static class CellFigureBorder extends AbstractBorder {
		public Insets getInsets(IFigure figure) {
			return new Insets(0, 0, 1, 1);
		}

		public void paint(IFigure figure, Graphics graphics, Insets insets) {
			org.eclipse.draw2d.geometry.Rectangle paintRectangle = getPaintRectangle(figure, insets);
			graphics.drawLine(paintRectangle.getTopRight().getTranslated(-1, 0),
					paintRectangle.getBottomRight().getTranslated(-1, 0));
			graphics.drawLine(paintRectangle.getBottomLeft().getTranslated(0, -1),
					paintRectangle.getBottomRight().getTranslated(0, -1));
		}
	}

//	public TextLocation getStart() {
//		return cells.get(0).getStart();
//	}
//
//	public TextLocation getEnd() {
//		return cells.get(cells.size() - 1).getEnd();
//	}

	@Override
	public Optional<IEditorLocation> getPrevious(ITextEditor<?> textPart) {
		int indexOf = cells.indexOf(textPart);
		return indexOf > 0 ? cells.get(indexOf - 1).getEnd() : Optional.<IEditorLocation> absent();
	}

	@Override
	public Optional<IEditorLocation> getNext(ITextEditor<?> textPart) {
		int indexOf = cells.indexOf(textPart);
		return indexOf < cells.size() - 1 ? cells.get(indexOf + 1).getStart() : Optional.<IEditorLocation> absent();
	}
	
	@Override
	public void dispose() {
		disableHighlight();
		getModel().removePropertyChangeListener(fListener);
		getContainer().getMainFigure().remove(fTable);
	}
	
	@Override
	protected void doBindValue(TablePart value) {
		value.addPropertyChangeListener(fListener);
	}
	
	@Override
	protected void doUnbindValue(TablePart oldValue) {
		oldValue.removePropertyChangeListener(fListener);
	}

}
