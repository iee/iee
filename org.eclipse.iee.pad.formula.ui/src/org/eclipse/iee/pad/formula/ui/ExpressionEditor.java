package org.eclipse.iee.pad.formula.ui;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.iee.editor.core.container.RenderCtx;
import org.eclipse.iee.editor.core.pad.common.text.AbstractTextEditor;
import org.eclipse.iee.editor.core.pad.common.text.TextLocation;
import org.eclipse.iee.translator.antlr.translator.model.Expression;
import org.eclipse.swt.widgets.Caret;

import com.google.common.base.Optional;

public class ExpressionEditor extends AbstractTextEditor<Expression, Figure> {

	private RenderCtx fRenderCtx;
	
	private EditorVisitor fEditorVisitor = new EditorVisitor();

	private Optional<? extends AbstractTextEditor<? extends Expression, ? extends IFigure>> fSubeditor = Optional.absent();
	
	public ExpressionEditor(RenderCtx fRenderCtx) {
		this.fRenderCtx = fRenderCtx;
	}

	@Override
	public TextLocation getTextLocation(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void acceptCaret(Caret caret, TextLocation textLocation) {
		// TODO Auto-generated method stub
		
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

	@Override
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
			getFigure().remove(fSubeditor.get().getFigure());
			removeEditor(fSubeditor.get());
			fSubeditor = Optional.absent();
		}
		if (newValue != null) {
			fSubeditor = Optional.of(newValue.accept(fEditorVisitor, new EditorVisitorContext(fRenderCtx)));
			addEditor(fSubeditor.get());
			getFigure().add(fSubeditor.get().getFigure());
		}
	}

}
