package org.eclipse.iee.pad.formula.ui.editors;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.iee.editor.core.bindings.DefaultObservableValue;
import org.eclipse.iee.editor.core.bindings.ObservableProperty;
import org.eclipse.iee.editor.core.container.IView;
import org.eclipse.iee.editor.core.container.TextRenderCtx;
import org.eclipse.iee.editor.core.pad.common.text.AbstractVisualTextEditor;
import org.eclipse.iee.editor.core.pad.common.text.FigureView;
import org.eclipse.iee.pad.formula.ui.EditorVisitor;
import org.eclipse.iee.pad.formula.ui.IExpressionEditor;
import org.eclipse.iee.translator.antlr.translator.model.BinaryExpression;
import org.eclipse.iee.translator.antlr.translator.model.Expression;

import com.google.common.base.Optional;

public class BinaryExpressionEditor extends AbstractVisualTextEditor<BinaryExpression> implements IExpressionEditor<BinaryExpression, IFigure> {
	
	private ExpressionEditor fLeftEditor;
	private WrappedExpressionEditor<BinaryExpression> fSignEditor;
	private ExpressionEditor fRightEditor;
	private Optional<ObservableProperty<Expression>> fLeft;
	private Optional<ObservableProperty<Expression>> fRight;
	private TextRenderCtx fRenderCtx;
	private IFigure fFigure;

	public BinaryExpressionEditor(TextRenderCtx renderCtx) {
		this.fRenderCtx = renderCtx;
		addEditor(fLeftEditor = new ExpressionEditor(fRenderCtx));
		addEditor(fSignEditor = new WrappedExpressionEditor<>("sign", renderCtx));
		addEditor(fRightEditor = new ExpressionEditor(fRenderCtx));
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
		figure.add(fLeftEditor.getFigure());
		figure.add(fSignEditor.getFigure());
		figure.add(fRightEditor.getFigure());
		return figure;
	}
	
	@Override
	protected void doBindValue(BinaryExpression value) {
		fLeftEditor.setValue(fLeft = Optional.of(new ObservableProperty<Expression>(value, "left", Expression.class)));
		fRightEditor.setValue(fRight = Optional.of(new ObservableProperty<Expression>(value, "right", Expression.class)));
		fSignEditor.setValue(Optional.of(DefaultObservableValue.fromValue(value)));
	}

	@Override
	protected void doUnbindValue(BinaryExpression oldValue) {
		fLeftEditor.setValue(Optional.<ObservableProperty<Expression>> absent());
		fRightEditor.setValue(Optional.<ObservableProperty<Expression>> absent());
		fSignEditor.setValue(Optional.<ObservableProperty<BinaryExpression>> absent());
		if (fLeft.isPresent()) {
			fLeft.get().dispose();
		}
		if (fRight.isPresent()) {
			fRight.get().dispose();
		}
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