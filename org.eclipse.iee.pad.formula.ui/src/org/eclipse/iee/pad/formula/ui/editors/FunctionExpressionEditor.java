package org.eclipse.iee.pad.formula.ui.editors;

import java.util.List;

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
import org.eclipse.iee.translator.antlr.translator.model.FunctionExpression;

import com.google.common.base.Optional;
import com.google.common.reflect.TypeToken;

public final class FunctionExpressionEditor extends AbstractVisualTextEditor<FunctionExpression>  implements IExpressionEditor<FunctionExpression, Figure> {
	private WrappedExpressionEditor<FunctionExpression> fNameEditor;
	private ExpressionsListEditor fArgumentsEditor;
	private TextRenderCtx fRenderCtx;
	private Optional<ObservableProperty<List<Expression>>> fArguments;
	private Figure fFigure;

	public FunctionExpressionEditor(TextRenderCtx renderCtx) {
		this.fRenderCtx = renderCtx;
		addEditor(fNameEditor = new WrappedExpressionEditor<>("name", renderCtx));
		addEditor(fArgumentsEditor = new ExpressionsListEditor(renderCtx));
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
		figure.add(fNameEditor.getFigure());
		TextPartEditor t = new TextPartEditor(fRenderCtx);
		t.setValue(Optional.of(DefaultObservableValue.fromValue("(")));
		figure.add(addEditor(t).getView().getWrapped(IFigure.class));
		figure.add(fArgumentsEditor.getFigure());
		TextPartEditor t1 = new TextPartEditor(fRenderCtx);
		t1.setValue(Optional.of(DefaultObservableValue.fromValue(")")));
		figure.add(addEditor(t1).getView().getWrapped(IFigure.class));
		return figure;
	}

	@Override
	protected void doBindValue(FunctionExpression value) {
		fArguments = Optional.of(new ObservableProperty<List<Expression>>(value, "parameters", new TypeToken<List<Expression>>() {}));
		fNameEditor.setValue(Optional.of(DefaultObservableValue.fromValue(value)));
		fArgumentsEditor.setValue(fArguments);
	}

	@Override
	protected void doUnbindValue(FunctionExpression oldValue) {
		if (fArguments.isPresent()) {
			fArguments.get().dispose();
		}
		fNameEditor.setValue(Optional.<ObservableProperty<FunctionExpression>> absent());
		fArgumentsEditor.setValue(Optional.<ObservableProperty<List<Expression>>> absent());
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