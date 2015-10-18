package org.eclipse.iee.pad.formula.ui.editors;

import org.eclipse.draw2d.Figure;
import org.eclipse.iee.editor.core.bindings.DefaultObservableValue;
import org.eclipse.iee.editor.core.bindings.ObservableProperty;
import org.eclipse.iee.editor.core.container.RenderCtx;
import org.eclipse.iee.editor.core.pad.common.text.AbstractTextEditor;
import org.eclipse.iee.editor.core.pad.common.text.TextLocation;
import org.eclipse.iee.editor.core.pad.common.text.WrapperEditor;
import org.eclipse.iee.pad.formula.ui.EditorVisitor;
import org.eclipse.iee.pad.formula.ui.ExpressionEditor;
import org.eclipse.iee.translator.antlr.translator.model.BinaryExpression;
import org.eclipse.iee.translator.antlr.translator.model.Expression;
import org.eclipse.swt.widgets.Caret;

import com.google.common.base.Optional;

public class BinaryExpressionEditor extends AbstractTextEditor<BinaryExpression, Figure> {
	private ExpressionEditor fLeftEditor;
	private WrapperEditor<BinaryExpression> fSignEditor;
	private ExpressionEditor fRightEditor;
	private Optional<ObservableProperty<Expression>> fLeft;
	private Optional<ObservableProperty<Expression>> fRight;
	private RenderCtx fRenderCtx;

	public BinaryExpressionEditor(RenderCtx renderCtx) {
		this.fRenderCtx = renderCtx;
		addEditor(fLeftEditor = new ExpressionEditor(fRenderCtx));
		addEditor(fSignEditor = new WrapperEditor<>("sign", renderCtx));
		addEditor(fRightEditor = new ExpressionEditor(fRenderCtx));
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
}