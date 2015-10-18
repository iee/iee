package org.eclipse.iee.editor.core.pad.table.ui;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.iee.editor.core.bindings.IObservableValue;
import org.eclipse.iee.editor.core.bindings.ObservableProperty;
import org.eclipse.iee.editor.core.pad.common.text.AbstractTextEditor;
import org.eclipse.iee.editor.core.pad.common.text.TextLocation;
import org.eclipse.iee.editor.core.pad.common.text.TextPartEditor;
import org.eclipse.iee.editor.core.pad.common.ui.IMenuContributor;
import org.eclipse.iee.editor.core.pad.table.TableCell;
import org.eclipse.iee.editor.core.pad.table.TableColumn;
import org.eclipse.iee.editor.core.pad.table.TablePart;
import org.eclipse.iee.editor.core.pad.table.TableRow;
import org.eclipse.iee.editor.core.pad.table.ui.TablePad.CellFigureBorder;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Event;

import com.google.common.base.Optional;

public class TableCellEditor extends AbstractTextEditor<TableCell, IFigure> implements IMenuContributor {

	private TextPartEditor fTextPartEditor;
	
	private ObservableProperty<String> fValue;

	public TableCellEditor() {
		fTextPartEditor = new TextPartEditor();
		addEditor(fTextPartEditor);
	}
	
	
	@Override
	public TextLocation getTextLocation(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void acceptCaret(Caret caret, TextLocation textLocation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isSelectable() {
		return true;
	}

	@Override
	public void setSelected(boolean selected) {
		TablePad tablePad = (TablePad) getParent().get();
		tablePad.updateSelectionFrame(selected);
	}

	@Override
	public void setActive(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected IFigure createFigure() {
		Figure figure = new Figure();
		figure.setLayoutManager(new BorderLayout());
		figure.setBorder(new CellFigureBorder());
		figure.add(fTextPartEditor.getFigure(), BorderLayout.CENTER);
		return figure;
	}
	
	public void bindValue(IObservableValue<TableCell> value) {
		setValue(Optional.of(value));
	}
	
	@Override
	protected void doBindValue(TableCell value) {
		fValue = new ObservableProperty<String>(value, "value", String.class);
		fTextPartEditor.bindValue(fValue);
	}
	
	@Override
	protected void doUnbindValue(TableCell oldValue) {
		fValue.dispose();
	}
	
	@Override
	public void contribute(MenuManager menuManager) {
		
		menuManager.add(new ActionContributionItem(new Action("Add column after") {
			@Override
			public void runWithEvent(Event event) {
				TablePad tablePad = (TablePad) getParent().get();
				TablePart table = tablePad.getModel();
				TableColumn column = table.getColumn(getModel());
				table.addColumnAfter(column, new TableColumn("Header"));
			}
		}));
		
		menuManager.add(new ActionContributionItem(new Action("Add column before") {
			@Override
			public void runWithEvent(Event event) {
				TablePad tablePad = (TablePad) getParent().get();
				TablePart table = tablePad.getModel();
				TableColumn column = table.getColumn(getModel());
				table.addColumnBefore(column, new TableColumn("Header"));
			}
		}));
		
		menuManager.add(new ActionContributionItem(new Action("Delete column") {
			@Override
			public void runWithEvent(Event event) {
				TablePad tablePad = (TablePad) getParent().get();
				TablePart table = tablePad.getModel();
				TableColumn column = table.getColumn(getModel());
				table.removeColumn(column);
			}
		}));
		
		menuManager.add(new ActionContributionItem(new Action("Add row after") {
			@Override
			public void runWithEvent(Event event) {
				TablePad tablePad = (TablePad) getParent().get();
				TablePart table = tablePad.getModel();
				TableRow row = table.getRow(getModel());
				table.addRowAfter(row, new TableRow());
			}
		}));
		
		menuManager.add(new ActionContributionItem(new Action("Add row before") {
			@Override
			public void runWithEvent(Event event) {
				TablePad tablePad = (TablePad) getParent().get();
				TablePart table = tablePad.getModel();
				TableRow row = table.getRow(getModel());
				table.addRowBefore(row, new TableRow());
			}
		}));
		
		menuManager.add(new ActionContributionItem(new Action("Delete row") {
			@Override
			public void runWithEvent(Event event) {
				TablePad tablePad = (TablePad) getParent().get();
				TablePart table = tablePad.getModel();
				TableRow row = table.getRow(getModel());
				table.removeRow(row);
			}
		}));
		
		
	}

}
