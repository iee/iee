package org.eclipse.iee.pad.formula.ui.editors;

import org.eclipse.draw2d.Figure;
import org.eclipse.iee.editor.core.bindings.IObservableValue;
import org.eclipse.iee.editor.core.bindings.ObservableProperty;
import org.eclipse.iee.editor.core.container.RenderCtx;
import org.eclipse.iee.editor.core.pad.common.text.AbstractTextEditor;
import org.eclipse.iee.editor.core.pad.common.text.TextLocation;
import org.eclipse.iee.pad.formula.ui.EditorVisitor;
import org.eclipse.iee.pad.formula.ui.ExpressionEditor;
import org.eclipse.iee.translator.antlr.translator.model.Expression;
import org.eclipse.iee.translator.antlr.translator.model.IndexExpression;
import org.eclipse.swt.widgets.Caret;

import com.google.common.base.Optional;

public final class IndexExpressionEditor extends AbstractTextEditor<IndexExpression, Figure> {
	private ExpressionEditor fContainerEditor;
	private ExpressionEditor fIndexEditor;
	private Optional<ObservableProperty<Expression>> fContainer;
	private Optional<ObservableProperty<Expression>> fIndex;
	private RenderCtx fRenderCtx;

	public IndexExpressionEditor(RenderCtx renderCtx) {
		this.fRenderCtx = renderCtx;
		addEditor(fContainerEditor = new ExpressionEditor(fRenderCtx));
		addEditor(fIndexEditor = new ExpressionEditor(fRenderCtx.createSubscriptCtx()));
	}

	@Override
	public TextLocation getTextLocation(int x, int y) {
		return null;
	}

	@Override
	public void acceptCaret(Caret caret, TextLocation textLocation) {
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
		figure.add(fContainerEditor.getFigure());
		figure.add(EditorVisitor.createSuperSubScript(Optional.<Figure>absent(), Optional.of(fIndexEditor.getFigure())));
		return figure;
	}

	@Override
	protected void doBindValue(IndexExpression value) {
		fContainerEditor.setValue(fContainer = Optional.of(new ObservableProperty<Expression>(value, "container", Expression.class)));
		fIndexEditor.setValue(fIndex = Optional.of(new ObservableProperty<Expression>(value, "index", Expression.class)));
	}

	@Override
	protected void doUnbindValue(IndexExpression oldValue) {
		fContainerEditor.setValue(Optional.<IObservableValue<Expression>> absent());
		fIndexEditor.setValue(Optional.<IObservableValue<Expression>> absent());
		fContainer.get().dispose();
		fIndex.get().dispose();
	}
}