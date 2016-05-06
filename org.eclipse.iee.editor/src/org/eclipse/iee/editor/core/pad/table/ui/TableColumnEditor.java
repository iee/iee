package org.eclipse.iee.editor.core.pad.table.ui;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.iee.editor.core.bindings.IObservableValue;
import org.eclipse.iee.editor.core.bindings.ObservableProperty;
import org.eclipse.iee.editor.core.container.IView;
import org.eclipse.iee.editor.core.pad.common.text.AbstractVisualTextEditor;
import org.eclipse.iee.editor.core.pad.common.text.FigureView;
import org.eclipse.iee.editor.core.pad.common.text.IEditorLocation;
import org.eclipse.iee.editor.core.pad.common.text.TextPartEditor;
import org.eclipse.iee.editor.core.pad.table.TableColumn;
import org.eclipse.iee.editor.core.pad.table.ui.TablePad.CellFigureBorder;
import org.eclipse.swt.widgets.Caret;

import com.google.common.base.Optional;

public class TableColumnEditor extends AbstractVisualTextEditor<TableColumn> {

	private TextPartEditor fTextPartEditor;
	private ObservableProperty<String> fValue;
	private IFigure fFigure;

	public TableColumnEditor() {
		fTextPartEditor = new TextPartEditor();
		addEditor(fTextPartEditor);
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

	protected IFigure createFigure() {
		Figure figure = new Figure();
		figure.setLayoutManager(new BorderLayout());
		figure.setBorder(new CellFigureBorder());
		figure.add(fTextPartEditor.getFigure(), BorderLayout.CENTER);
		return figure;
	}

	public void bindValue(IObservableValue<TableColumn> cell) {
		setValue(Optional.of(cell));
	}
	
	@Override
	protected void doBindValue(TableColumn value) {
		fValue = new ObservableProperty<String>(value, "header", String.class);
		fTextPartEditor.bindValue(fValue);
	}
	
	@Override
	protected void doUnbindValue(TableColumn oldValue) {
		fValue.dispose();
	}

	@Override
	protected IView createView() {
		return new FigureView(getFigure());
	}

	public IFigure getFigure() {
		if (fFigure == null) {
			fFigure = createFigure();
		}
		return fFigure;
	}

}
