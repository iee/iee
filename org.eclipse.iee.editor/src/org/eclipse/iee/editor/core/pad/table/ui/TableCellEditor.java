package org.eclipse.iee.editor.core.pad.table.ui;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.iee.editor.core.bindings.IObservableValue;
import org.eclipse.iee.editor.core.bindings.ObservableProperty;
import org.eclipse.iee.editor.core.pad.common.text.AbstractTextEditor;
import org.eclipse.iee.editor.core.pad.common.text.TextLocation;
import org.eclipse.iee.editor.core.pad.common.text.TextPartEditor;
import org.eclipse.iee.editor.core.pad.table.CellMenuContributor;
import org.eclipse.iee.editor.core.pad.table.TableCell;
import org.eclipse.iee.editor.core.pad.table.ui.TablePad.CellFigureBorder;
import org.eclipse.swt.widgets.Caret;

public class TableCellEditor extends AbstractTextEditor<TableCell> {

	private TextPartEditor fTextPartEditor;
	private ObservableProperty<String> fValue;

	public TableCellEditor() {
		setMenuContributor(CellMenuContributor.INSTANCE);
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSelected(boolean b) {
		// TODO Auto-generated method stub
		
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
		bindObservableValue(value);
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
	
	

}
