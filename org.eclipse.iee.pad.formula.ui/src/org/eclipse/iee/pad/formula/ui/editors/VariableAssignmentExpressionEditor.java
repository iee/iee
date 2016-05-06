package org.eclipse.iee.pad.formula.ui.editors;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.iee.editor.core.bindings.DefaultObservableValue;
import org.eclipse.iee.editor.core.bindings.ObservableProperty;
import org.eclipse.iee.editor.core.container.IView;
import org.eclipse.iee.editor.core.container.TextRenderCtx;
import org.eclipse.iee.editor.core.pad.common.text.AbstractVisualTextEditor;
import org.eclipse.iee.editor.core.pad.common.text.FigureView;
import org.eclipse.iee.editor.core.pad.common.text.TextPartEditor;
import org.eclipse.iee.pad.formula.ui.EditorVisitor;
import org.eclipse.iee.pad.formula.ui.IExpressionEditor;
import org.eclipse.iee.translator.antlr.translator.model.Expression;
import org.eclipse.iee.translator.antlr.translator.model.VariableAssignment;

import com.google.common.base.Optional;

public class VariableAssignmentExpressionEditor extends AbstractVisualTextEditor<VariableAssignment>  implements IExpressionEditor<VariableAssignment, IFigure> {
	
	private WrappedExpressionEditor<VariableAssignment> fLeftEditor;
	private TextPartEditor fSignEditor;
	private ExpressionEditor fRightEditor;
	private Optional<ObservableProperty<Expression>> fRight;
	private TextRenderCtx fRenderCtx;
	private IFigure fFigure;

	public VariableAssignmentExpressionEditor(TextRenderCtx renderCtx) {
		this.fRenderCtx = renderCtx;
		addEditor(fLeftEditor = new WrappedExpressionEditor<VariableAssignment>("name", fRenderCtx));
		addEditor(fSignEditor = new TextPartEditor(renderCtx));
		fSignEditor.setValue(Optional.of(DefaultObservableValue.fromValue("=")));
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
	protected void doBindValue(VariableAssignment value) {
		fLeftEditor.setValue(Optional.of(DefaultObservableValue.fromValue(value)));
		fRightEditor.setValue(fRight = Optional.of(new ObservableProperty<Expression>(value, "value", Expression.class)));
	}

	@Override
	protected void doUnbindValue(VariableAssignment oldValue) {
		fLeftEditor.setValue(Optional.<ObservableProperty<VariableAssignment>> absent());
		fRightEditor.setValue(Optional.<ObservableProperty<Expression>> absent());
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