package org.eclipse.iee.pad.formula.ui.editors;

import org.eclipse.draw2d.Figure;
import org.eclipse.iee.editor.core.bindings.IObservableValue;
import org.eclipse.iee.editor.core.bindings.ObservableProperty;
import org.eclipse.iee.editor.core.container.IView;
import org.eclipse.iee.editor.core.container.TextRenderCtx;
import org.eclipse.iee.editor.core.pad.common.text.AbstractVisualTextEditor;
import org.eclipse.iee.editor.core.pad.common.text.FigureView;
import org.eclipse.iee.pad.formula.ui.EditorVisitor;
import org.eclipse.iee.pad.formula.ui.IExpressionEditor;
import org.eclipse.iee.translator.antlr.translator.model.Expression;
import org.eclipse.iee.translator.antlr.translator.model.IndexExpression;

import com.google.common.base.Optional;

public final class IndexExpressionEditor extends AbstractVisualTextEditor<IndexExpression>  implements IExpressionEditor<IndexExpression, Figure> {
	private ExpressionEditor fContainerEditor;
	private ExpressionEditor fIndexEditor;
	private Optional<ObservableProperty<Expression>> fContainer;
	private Optional<ObservableProperty<Expression>> fIndex;
	private TextRenderCtx fRenderCtx;
	private Figure fFigure;

	public IndexExpressionEditor(TextRenderCtx renderCtx) {
		this.fRenderCtx = renderCtx;
		addEditor(fContainerEditor = new ExpressionEditor(fRenderCtx));
		addEditor(fIndexEditor = new ExpressionEditor(fRenderCtx.createSubscriptCtx()));
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

	@Override
	protected IView createView() {
		return new FigureView(getFigure());
	}

	public Figure getFigure() {
		if (fFigure == null) {
			fFigure = createFigure();
		}
		return fFigure;
	}

}