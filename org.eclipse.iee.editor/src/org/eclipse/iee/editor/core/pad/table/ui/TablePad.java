package org.eclipse.iee.editor.core.pad.table.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import org.eclipse.draw2d.AbstractBorder;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseMotionListener;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.iee.editor.core.container.Container;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.common.text.ICompositeTextPart;
import org.eclipse.iee.editor.core.pad.common.text.ITextAdapter;
import org.eclipse.iee.editor.core.pad.common.text.ITextPart;
import org.eclipse.iee.editor.core.pad.common.text.TextLocation;
import org.eclipse.iee.editor.core.pad.common.text.TextPartEditor;
import org.eclipse.iee.editor.core.pad.table.CellMenuContributor;
import org.eclipse.iee.editor.core.pad.table.TableCell;
import org.eclipse.iee.editor.core.pad.table.TableColumn;
import org.eclipse.iee.editor.core.pad.table.TablePart;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;

import com.google.common.base.Optional;
import com.google.common.collect.Lists;

public class TablePad extends Pad<TablePart> implements ICompositeTextPart {

	private GridLayout fManager;
	
	private Figure fTable;

	private RectangleFigure fColumnHighlighter;

	private RectangleFigure fRowHighlighter;
	
	private List<TextPartEditor<TableCell>> cells = Lists.newArrayList();

	private PropertyChangeListener fListener;
	
	public TablePad(TablePart part) {
		super(part);
		fListener = new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("cells".equals(evt.getPropertyName()) 
						|| "columns".equals(evt.getPropertyName())) {
					updateTable(fTable);
				}
			}
		};
		part.addPropertyChangeListener(fListener);
	}

	//TODO remove
	@Override
	public void attachContainer(Container container) {
		fContainer = container;
		
		IFigure mainFigure = container.getMainFigure();
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
		
		mainFigure.add(fTable, new org.eclipse.draw2d.geometry.Rectangle(0, 0, -1, -1));
		getContainer().getContainerManager().registerVisual(this, fTable);
		
		fTable.addFigureListener(new FigureListener() {
			
			@Override
			public void figureMoved(IFigure source) {
				if (source != fTable) {
					return;
				}
				fContainer.updatePresentation();
			}
		});
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
				TextPartEditor<TableCell> textPartEditor = new TextPartEditor<TableCell>(documentPart.getCell(i, j), new ITextAdapter<TableCell>() {

					@Override
					public String getText(TableCell object) {
						return object.getValue();
					}

					@Override
					public void setText(TableCell object, String text) {
						object.setValue(text);
					}
				});
				textPartEditor.setMenuContributor(CellMenuContributor.INSTANCE);
				IFigure figure = textPartEditor.createFigure();
				table.add(createCell(figure), new GridData(GridData.FILL, GridData.FILL, true, true));
				getContainer().getContainerManager().registerVisual(textPartEditor, figure);
			}
		}
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
		TextPartEditor<TableColumn> textPartEditor = new TextPartEditor<TableColumn>(column, new ITextAdapter<TableColumn>() {

			@Override
			public String getText(TableColumn object) {
				return object.getHeader();
			}

			@Override
			public void setText(TableColumn object, String text) {
				object.setHeader(text);
			}
		});
		IFigure figure = textPartEditor.createFigure();
		table.add(createCell(figure), new GridData(GridData.FILL, GridData.FILL, true, true));
		textPartEditor.setText(column.getHeader());
		getContainer().getContainerManager().registerVisual(textPartEditor, figure);
	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub
		
	}

	//TODO remove
	@Override
	public Pad<TablePart> copy() {
		return new TablePad(getDocumentPart().copy());
	}

	@Override
	public void save() {
	}

	@Override
	public void unsave() {
	}

	@Override
	public String getType() {
		return "TableInput";
	}

	@Override
	public String getTex() {
		return "";
	}

	@Override
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
	
	private IFigure createCell(IFigure content) {
		Figure figure = new Figure();
		figure.setLayoutManager(new BorderLayout());
		figure.setBorder(new CellFigureBorder());
		figure.add(content, BorderLayout.CENTER);
		return figure;
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

	@Override
	public Optional<ICompositeTextPart> getParentTextPart() {
		return Optional.of(getContainer().getContainerManager().getRootTextPart());
	}

	@Override
	public TextLocation getStart() {
		return cells.get(0).getStart();
	}

	@Override
	public TextLocation getEnd() {
		return cells.get(cells.size() - 1).getEnd();
	}

	@Override
	public Optional<ITextPart> getPrevious(ITextPart textPart) {
		int indexOf = cells.indexOf(textPart);
		return indexOf > 0 ? Optional.<ITextPart> of(cells.get(indexOf - 1)) : Optional.<ITextPart> absent();
	}

	@Override
	public Optional<ITextPart> getNext(ITextPart textPart) {
		int indexOf = cells.indexOf(textPart);
		return indexOf < cells.size() - 1 ? Optional.<ITextPart> of(cells.get(indexOf + 1)) : Optional.<ITextPart> absent();
	}
	
	@Override
	public void dispose() {
		getModel().removePropertyChangeListener(fListener);
	}

}
