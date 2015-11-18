package org.eclipse.iee.editor.core.pad;

import java.awt.Rectangle;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.editor.core.container.Container;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.widgets.Composite;

public abstract class CompositePad<T extends PadDocumentPart> extends Pad<T, IFigure> {
	
	private Composite fContent;
	
	@Override
	public void attachContainer(Container container)  {
		Assert.isNotNull(container);
		Assert.isLegal(!isContainerAttached(), "Another container is already attached");

		fContainer = container;
		final Composite parent = fContainer.getTextWidget();

		fContent = new Composite(parent, SWT.NONE);

		fContent.addControlListener(new ControlListener() {
			@Override
			public void controlResized(ControlEvent e) {
				fContainer.updatePresentation();
				Rectangle bounds = getBounds();
				updateSelectionBounds(bounds);
			}

			@Override
			public void controlMoved(ControlEvent e) {
			}
		});

		createPartControl(fContent);
		fContent.pack();
		
		addMouseListeners(parent);

	}
	
	protected abstract void createPartControl(Composite parent);

	@Override
	public Rectangle getBounds() {
		org.eclipse.swt.graphics.Rectangle bounds = fContent.getBounds();
		Point viewLocation = getContainer().getContainerManager().getViewLocation();
		return new Rectangle(viewLocation.x + bounds.x, viewLocation.y + bounds.y, bounds.width, bounds.height);
	}

	@Override
	public void setBounds(Rectangle newBounds) {
		Point viewLocation = getContainer().getContainerManager().getViewLocation();
		org.eclipse.swt.graphics.Rectangle bounds = new org.eclipse.swt.graphics.Rectangle(newBounds.x - viewLocation.x, newBounds.y - viewLocation.y, newBounds.width, newBounds.height);
		fContent.setBounds(bounds);
		updateSelectionBounds(newBounds);
	}

	@Override
	public void setVisible(boolean isVisible) {
		fContent.setVisible(isVisible);
	}
	
	@Override
	public void dispose() {
		fContent.dispose();
	}

	@Override
	protected IFigure createFigure() {
		return new Figure();
	}
	
}
