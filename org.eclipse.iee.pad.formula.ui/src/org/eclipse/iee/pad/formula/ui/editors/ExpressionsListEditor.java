package org.eclipse.iee.pad.formula.ui.editors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.iee.editor.core.bindings.DefaultObservableValue;
import org.eclipse.iee.editor.core.container.RenderCtx;
import org.eclipse.iee.editor.core.pad.common.text.AbstractTextEditor;
import org.eclipse.iee.editor.core.pad.common.text.TextLocation;
import org.eclipse.iee.editor.core.pad.common.text.TextPartEditor;
import org.eclipse.iee.pad.formula.ui.EditorVisitor;
import org.eclipse.iee.pad.formula.ui.ExpressionEditor;
import org.eclipse.iee.translator.antlr.translator.model.Expression;
import org.eclipse.swt.widgets.Caret;

import com.google.common.base.Optional;

public class ExpressionsListEditor extends AbstractTextEditor<List<Expression>, Figure> {
	
	private RenderCtx fRenderCtx;
	
	private List<ExpressionEditor> fEditors = new ArrayList<>();

	public ExpressionsListEditor(RenderCtx renderCtx) {
		this.fRenderCtx = renderCtx;
	}

	@Override
	public boolean isSelectable() {
		return false;
	}

	@Override
	public void setSelected(boolean b) {
	}

	@Override
	public void setActive(boolean b) {
	}

	@Override
	protected Figure createFigure() {
		Figure figure = EditorVisitor.createTextContainerFigure();
		return figure;
	}

	@Override
	protected void doBindValue(List<Expression> value) {
		for (int i = 0; i < value.size(); i++) {
			if (i > 0) {
				TextPartEditor t = new TextPartEditor(fRenderCtx);
				t.setValue(Optional.of(DefaultObservableValue.fromValue(",")));
				addEditor(t);
				getFigure().add(t.getFigure());
			}
			ExpressionEditor e = new ExpressionEditor(fRenderCtx);
			e.setValue(Optional.of(DefaultObservableValue.fromValue(value.get(i))));
			addEditor(e);
			fEditors.add(e);			
			getFigure().add(e.getFigure());
		}
	}

	@Override
	protected void doUnbindValue(List<Expression> oldValue) {
		for (ExpressionEditor expressionEditor : fEditors) {
			removeEditor(expressionEditor);
			expressionEditor.dispose();
		}
		fEditors.clear();
		getFigure().removeAll();
	}
}