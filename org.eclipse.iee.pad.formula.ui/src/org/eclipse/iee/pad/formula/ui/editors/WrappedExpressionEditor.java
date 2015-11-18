package org.eclipse.iee.pad.formula.ui.editors;

import org.eclipse.draw2d.IFigure;
import org.eclipse.iee.core.IHasPropertyChangeListener;
import org.eclipse.iee.editor.core.container.TextRenderCtx;
import org.eclipse.iee.editor.core.pad.common.text.WrapperEditor;
import org.eclipse.iee.pad.formula.ui.IExpressionEditor;

public class WrappedExpressionEditor<M extends IHasPropertyChangeListener> extends WrapperEditor<M> implements IExpressionEditor<M, IFigure>{

	public WrappedExpressionEditor(String property, TextRenderCtx renderCtx) {
		super(property, renderCtx);
	}

}
