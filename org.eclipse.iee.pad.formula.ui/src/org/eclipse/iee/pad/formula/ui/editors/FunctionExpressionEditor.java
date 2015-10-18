package org.eclipse.iee.pad.formula.ui.editors;

import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.iee.editor.core.bindings.DefaultObservableValue;
import org.eclipse.iee.editor.core.bindings.ObservableProperty;
import org.eclipse.iee.editor.core.container.RenderCtx;
import org.eclipse.iee.editor.core.pad.common.text.AbstractTextEditor;
import org.eclipse.iee.editor.core.pad.common.text.TextPartEditor;
import org.eclipse.iee.editor.core.pad.common.text.WrapperEditor;
import org.eclipse.iee.pad.formula.ui.EditorVisitor;
import org.eclipse.iee.translator.antlr.translator.model.Expression;
import org.eclipse.iee.translator.antlr.translator.model.FunctionExpression;

import com.google.common.base.Optional;
import com.google.common.reflect.TypeToken;

public final class FunctionExpressionEditor extends AbstractTextEditor<FunctionExpression, Figure> {
	private WrapperEditor<FunctionExpression> fNameEditor;
	private ExpressionsListEditor fArgumentsEditor;
	private RenderCtx fRenderCtx;
	private Optional<ObservableProperty<List<Expression>>> fArguments;

	public FunctionExpressionEditor(RenderCtx renderCtx) {
		this.fRenderCtx = renderCtx;
		addEditor(fNameEditor = new WrapperEditor<>("name", renderCtx));
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

	@Override
	protected Figure createFigure() {
		Figure figure = EditorVisitor.createTextContainerFigure();
		figure.add(fNameEditor.getFigure());
		TextPartEditor t = new TextPartEditor(fRenderCtx);
		t.setValue(Optional.of(DefaultObservableValue.fromValue("(")));
		figure.add(addEditor(t).getFigure());
		figure.add(fArgumentsEditor.getFigure());
		TextPartEditor t1 = new TextPartEditor(fRenderCtx);
		t1.setValue(Optional.of(DefaultObservableValue.fromValue(")")));
		figure.add(addEditor(t1).getFigure());
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
}