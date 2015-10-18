package org.eclipse.iee.pad.formula.ui;

import java.util.List;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.iee.editor.core.bindings.DefaultObservableValue;
import org.eclipse.iee.editor.core.bindings.IObserver;
import org.eclipse.iee.editor.core.bindings.ObservableProperty;
import org.eclipse.iee.editor.core.container.RenderCtx;
import org.eclipse.iee.editor.core.pad.common.text.AbstractTextEditor;
import org.eclipse.iee.editor.core.pad.common.text.TextLocation;
import org.eclipse.iee.editor.core.pad.common.text.WrapperEditor;
import org.eclipse.iee.pad.formula.ui.editors.BinaryExpressionEditor;
import org.eclipse.iee.pad.formula.ui.editors.FunctionExpressionEditor;
import org.eclipse.iee.pad.formula.ui.editors.IndexExpressionEditor;
import org.eclipse.iee.translator.antlr.translator.model.BinaryExpression;
import org.eclipse.iee.translator.antlr.translator.model.BracketsExpression;
import org.eclipse.iee.translator.antlr.translator.model.Expression;
import org.eclipse.iee.translator.antlr.translator.model.FunctionExpression;
import org.eclipse.iee.translator.antlr.translator.model.IdentifierExpression;
import org.eclipse.iee.translator.antlr.translator.model.IndexExpression;
import org.eclipse.iee.translator.antlr.translator.model.NaryExpression;
import org.eclipse.iee.translator.antlr.translator.model.VariableAssignment;
import org.eclipse.iee.translator.antlr.translator.model.Visitor;
import org.eclipse.swt.widgets.Caret;

import com.google.common.base.Optional;
import com.google.common.reflect.TypeToken;

public class EditorVisitor
		implements Visitor<AbstractTextEditor<? extends Expression, ? extends IFigure>, EditorVisitorContext> {

	@Override
	public AbstractTextEditor<? extends Expression, ? extends IFigure> visitBinaryExpression(
			final BinaryExpression expression, final EditorVisitorContext context) {
		AbstractTextEditor<BinaryExpression, Figure> wrapperEditor = new BinaryExpressionEditor(context.getRenderCtx());
		wrapperEditor.setValue(Optional.of(DefaultObservableValue.fromValue(expression)));
		return wrapperEditor;
	}

	@Override
	public AbstractTextEditor<? extends Expression, ? extends IFigure> acceptFunctionExpression(
			final FunctionExpression expression, final EditorVisitorContext context) {
		final RenderCtx renderCtx = context.getRenderCtx();
		
		AbstractTextEditor<FunctionExpression, Figure> wrapperEditor = new FunctionExpressionEditor(renderCtx);
		wrapperEditor.setValue(Optional.of(DefaultObservableValue.fromValue(expression)));
		return wrapperEditor;
	}

	@Override
	public AbstractTextEditor<? extends Expression, ? extends IFigure> acceptIdentifierExpression(
			IdentifierExpression expression, EditorVisitorContext context) {
		RenderCtx renderCtx = context.getRenderCtx();
		WrapperEditor<IdentifierExpression> wrapperEditor = new WrapperEditor<IdentifierExpression>("name", renderCtx);
		wrapperEditor.setValue(Optional.of(DefaultObservableValue.fromValue(expression)));
		return wrapperEditor;
	}

	@Override
	public AbstractTextEditor<? extends Expression, ? extends IFigure> acceptIndexExpression(final IndexExpression expression,
			final EditorVisitorContext context) {
		AbstractTextEditor<IndexExpression, Figure> wrapperEditor = new IndexExpressionEditor(context.getRenderCtx());
		wrapperEditor.setValue(Optional.of(DefaultObservableValue.fromValue(expression)));
		return wrapperEditor;
	}

	@Override
	public AbstractTextEditor<? extends Expression, ? extends IFigure> acceptNaryExpression(final NaryExpression expression,
			final EditorVisitorContext context) {
		final RenderCtx renderCtx = context.getRenderCtx();
		AbstractTextEditor<NaryExpression, Figure> wrapperEditor = new AbstractTextEditor<NaryExpression, Figure>() {

			private Optional<ObservableProperty<Expression>> fExpression = Optional.absent();
			private Optional<ObservableProperty<List<Expression>>> fVariables = Optional.absent();
			private ExpressionEditor fExpressionEditor;
			private Optional<ObservableProperty<String>> fName;
			private Optional<Figure> fSymbol = Optional.absent();
			
			{
				addEditor(fExpressionEditor = new ExpressionEditor(renderCtx));
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
				Figure result = new Figure();
				FlowLayout resultLayout = new FlowLayout();
				resultLayout.setMinorAlignment(FlowLayout.ALIGN_CENTER);
				result.setLayoutManager(resultLayout);
				fillFigure(result);
				return result;
			}

			private void fillFigure(Figure result) {
				Figure sign = new Figure();
				ToolbarLayout manager = new ToolbarLayout();
				manager.setMinorAlignment(ToolbarLayout.ALIGN_CENTER);
				manager.setStretchMinorAxis(false);
				sign.setLayoutManager(manager);
				Figure max = new Figure();
				max.setLayoutManager(new FlowLayout());
				fSymbol = Optional.of(new Figure());
				FlowLayout functionLayout = new FlowLayout();
				functionLayout.setMajorSpacing(0);
				functionLayout.setMinorSpacing(0);
				fSymbol.get().setLayoutManager(functionLayout);
				Figure min = new Figure();
				FlowLayout minLayout = new FlowLayout();
				minLayout.setMajorSpacing(0);
				minLayout.setMinorSpacing(0);
				min.setLayoutManager(minLayout);
				for (VariableAssignment v : expression.getVariables()) {
//					context.pushRenderCtx(context.getRenderCtx().createSuperscriptCtx());
//					max.add(expression.getMax().accept(EditorVisitor.this, context).getFigure());
//					context.popRenderCtx();
					context.pushRenderCtx(renderCtx.createSubscriptCtx());
//					min.add(createTextFigure(paramCtx.variable.getText() + "="));
					min.add(v.accept(EditorVisitor.this, context).getFigure());
					context.popRenderCtx();
				}
				sign.add(max);
				sign.add(fSymbol.get());
				sign.add(min);
				result.add(sign);
				result.add(fExpressionEditor.getFigure());
				
				if (fName.isPresent()) {
					updateSymbol(fName.get().getValue());
				}
			}
			
			@Override
			protected void doBindValue(NaryExpression value) {
				fExpressionEditor.setValue(fExpression = Optional.of(new ObservableProperty<Expression>(value, "expression", Expression.class)));
				fName = Optional.of(new ObservableProperty<String>(value, "name", String.class));
				fName.get().addObserver(new IObserver<String>() {
					@Override
					public void valueChanged(String oldValue, String newValue) {
						updateSymbol(newValue);
					}
				});
				updateSymbol(fName.get().getValue());
				fVariables = Optional.of(new ObservableProperty<List<Expression>>(value, "variables", new TypeToken<List<Expression>>() {}));
				//TODO
			}
			
			@Override
			protected void doUnbindValue(NaryExpression oldValue) {
				fExpression.get().dispose();
				fName.get().dispose();
				fVariables.get().dispose();
			}
			
			private void updateSymbol(String symbol) {
				if (fSymbol.isPresent()) {
					fSymbol.get().removeAll();
					fSymbol.get().add(createTextFigure(symbol, renderCtx.createNAryFigureCtx()));
				}
			}
			
		};
		wrapperEditor.setValue(Optional.of(DefaultObservableValue.fromValue(expression)));
		return wrapperEditor;
	}

	@Override
	public AbstractTextEditor<? extends Expression, ? extends IFigure> acceptVariableAssignment(
			final VariableAssignment expression, final EditorVisitorContext context) {
		AbstractTextEditor<BinaryExpression, Figure> wrapperEditor = new AbstractTextEditor<BinaryExpression, Figure>() {

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
				Figure figure = createTextContainerFigure();
				figure.add(createLabel(expression.getName(), context.getRenderCtx()));
				figure.add(createLabel("=", context.getRenderCtx()));
				figure.add(expression.getValue().accept(EditorVisitor.this, context).getFigure());
				return figure;
			}
		};
		return wrapperEditor;
	}
	
	@Override
	public AbstractTextEditor<? extends Expression, ? extends IFigure> visitBracketsExpression(
			BracketsExpression bracketsExpression, EditorVisitorContext context) {
		return bracketsExpression.getInner().accept(this, context);
	}
	
	public static Figure createTextContainerFigure() {
		Figure figure = new Figure();
		FlowLayout manager = new FlowLayout(true);
		manager.setMajorSpacing(0);
		manager.setMinorSpacing(0);
		manager.setMinorAlignment(FlowLayout.ALIGN_CENTER);
		manager.setMajorAlignment(FlowLayout.ALIGN_CENTER);
		figure.setLayoutManager(manager);
		return figure;
	}
	
	private Label createLabel(String text, RenderCtx renderCtx) {
		Label label = new Label(text);
		label.setFont(renderCtx.getFont());
		return label;
	}
	
	public static IFigure createSuperSubScript(Optional<? extends IFigure> sup, Optional<? extends Figure> sub) {
		FlowLayout layout = new FlowLayout(false);
		Figure figure = new Figure();
		figure.setLayoutManager(layout);
		if (sup.isPresent()) {
			figure.add(sup.get());
		} else {
			figure.add(new Figure());
		}
		if (sub.isPresent()) {
			figure.add(sub.get());
		} else {
			figure.add(new Figure());
		}		
		return figure;
	}

	private Figure createTextFigure(String text, RenderCtx renderCtx) {
		Figure figure = createTextContainerFigure();
		Label label = createLabel(text, renderCtx);
		figure.add(label);
		return figure;
	}
	
}
