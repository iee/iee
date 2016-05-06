package org.eclipse.iee.pad.formula.ui.editors;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.iee.editor.core.container.IView;
import org.eclipse.iee.editor.core.container.TextRenderCtx;
import org.eclipse.iee.editor.core.pad.common.text.AbstractVisualTextEditor;
import org.eclipse.iee.editor.core.pad.common.text.FigureView;
import org.eclipse.iee.pad.formula.ui.EditorVisitor;
import org.eclipse.iee.pad.formula.ui.EditorVisitorContext;
import org.eclipse.iee.pad.formula.ui.IExpressionEditor;
import org.eclipse.iee.translator.antlr.translator.model.Expression;

import com.google.common.base.Optional;

public class ExpressionEditor extends AbstractVisualTextEditor<Expression> {

	private TextRenderCtx fRenderCtx;
	
	private EditorVisitor fEditorVisitor = new EditorVisitor();

	private Optional<? extends IExpressionEditor<? extends Expression, ? extends IFigure>> fSubeditor = Optional.absent();

	private Figure fFigure;
	
	public ExpressionEditor(TextRenderCtx fRenderCtx) {
		this.fRenderCtx = fRenderCtx;
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

	protected Figure createFigure() {
		Figure figure = new Figure();
		FlowLayout manager = new FlowLayout(true);
		manager.setStretchMinorAxis(false);
		figure.setLayoutManager(manager);
		return figure;
	}

	@Override
	protected void onValueChanged(Expression oldValue, Expression newValue) {
		if (fSubeditor.isPresent()) {
			getFigure().remove(fSubeditor.get().getView().getWrapped(IFigure.class));
			removeEditor(fSubeditor.get());
			fSubeditor = Optional.absent();
		}
		if (newValue != null) {
			fSubeditor = Optional.of(newValue.accept(fEditorVisitor, new EditorVisitorContext(fRenderCtx)));
			addEditor(fSubeditor.get());
			getFigure().add(fSubeditor.get().getView().getWrapped(IFigure.class));
		}
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
