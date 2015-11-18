package org.eclipse.iee.editor.core.pad.common.text;

import java.awt.Rectangle;

import org.eclipse.draw2d.IFigure;
import org.eclipse.iee.editor.core.container.IView;


public abstract class AbstractVisualTextEditor<T, F extends IFigure> extends AbstractTextEditor<T> {

	private F fFigure;
	
	@Override
	protected IView createView() {
		return new IView() {
			
			@Override
			public <A> A getWrapped(Class<A> type) {
				if (type == IFigure.class) {
					return (A) getFigure();
				}
				return null;
			}
			
			@Override
			public Rectangle getBounds() {
				return AbstractVisualTextEditor.this.getBounds();
			}
		};
	}
	
	public F getFigure() {
		if (fFigure == null) {
			fFigure = createFigure();
		}
		return fFigure;
	}
	
	abstract protected F createFigure();
	
	public Rectangle getBounds() {
		org.eclipse.draw2d.geometry.Rectangle bounds = getFigure().getBounds();
		return new Rectangle(bounds.x, bounds.y, bounds.width, bounds.height);
	}
	
}
