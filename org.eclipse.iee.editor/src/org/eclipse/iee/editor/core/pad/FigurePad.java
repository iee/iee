package org.eclipse.iee.editor.core.pad;

import java.awt.Rectangle;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutListener;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.editor.core.container.Container;

public abstract class FigurePad<T extends PadDocumentPart, F extends IFigure> extends Pad<T, F> {

	private IFigure fContent;
	
	@Override
	public void attachContainer(Container container)  {
		Assert.isNotNull(container);
		Assert.isLegal(!isContainerAttached(), "Another container is already attached");

		fContainer = container;
		fContent = getFigure();
		
		container.getContainerManager().getEditorManager().addEditor(this);
		container.getMainFigure().add(fContent, new org.eclipse.draw2d.geometry.Rectangle(0, 0, -1, -1));
		
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
		
		fContent.addLayoutListener(new LayoutListener.Stub() {
			
			@Override
			public void invalidate(IFigure container) {
				Dimension preferredSize = container.getPreferredSize(-1, -1);
				Rectangle bounds = getBounds();
				bounds.height = preferredSize.height;
				bounds.width = preferredSize.width;
				setBounds(bounds);
			}
			
		});
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
		fContainer.getContainerManager().getEditorManager().removeEditor(this);
		fContainer.getMainFigure().remove(fContent);
	}
}
