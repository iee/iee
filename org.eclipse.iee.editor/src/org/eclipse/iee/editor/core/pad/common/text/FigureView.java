package org.eclipse.iee.editor.core.pad.common.text;

import java.awt.Rectangle;

import org.eclipse.draw2d.IFigure;
import org.eclipse.iee.editor.core.container.IView;

public class FigureView implements IView {
	
	private IFigure fFigure;
	
	public FigureView(IFigure figure) {
		this.fFigure = figure;
	}

	@Override
	public <A> A getWrapped(Class<A> type) {
		if (type == IFigure.class) {
			return (A) fFigure;
		}
		return null;
	}

	@Override
	public Rectangle getBounds() {
		org.eclipse.draw2d.geometry.Rectangle bounds = fFigure.getBounds();
		return new Rectangle(bounds.x, bounds.y, bounds.width, bounds.height);
	}
}