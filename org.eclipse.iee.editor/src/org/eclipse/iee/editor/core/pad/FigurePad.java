package org.eclipse.iee.editor.core.pad;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.editor.core.container.Container;
import org.eclipse.swt.graphics.Rectangle;

public abstract class FigurePad<T extends PadDocumentPart, F extends IFigure> extends Pad<T, F> {

	private IFigure fContent;
	
	@Override
	public void attachContainer(Container container)  {
		Assert.isNotNull(container);
		Assert.isLegal(!isContainerAttached(), "Another container is already attached");

		fContainer = container;
		fContent = getFigure();
		
		container.getMainFigure().add(fContent, new org.eclipse.draw2d.geometry.Rectangle(0, 0, -1, -1));
		getContainer().getContainerManager().registerVisual(this, fContent);
		
		fContent.addFigureListener(new FigureListener() {
			
			@Override
			public void figureMoved(IFigure source) {
				if (source != fContent) {
					return;
				}
				Rectangle bounds = getBounds();
				updateSelectionBounds(bounds);
				fContainer.updatePresentation();
			}
		});
		
		fContent.setPreferredSize(new Dimension(300, 200));

	}

	@Override
	public Rectangle getBounds() {
		org.eclipse.draw2d.geometry.Rectangle bounds = fContent.getBounds();
		return new Rectangle(bounds.x, bounds.y, bounds.width, bounds.height);
	}

	@Override
	public void setBounds(Rectangle newBounds) {
		org.eclipse.draw2d.geometry.Rectangle bounds = new org.eclipse.draw2d.geometry.Rectangle(newBounds.x, newBounds.y, newBounds.width, newBounds.height);
		fContent.getParent().setConstraint(fContent, bounds);
		updateSelectionBounds(newBounds);
	}

	@Override
	public void setVisible(boolean isVisible) {
		fContent.setVisible(isVisible);
	}
	
	@Override
	public void dispose() {
	}
}
