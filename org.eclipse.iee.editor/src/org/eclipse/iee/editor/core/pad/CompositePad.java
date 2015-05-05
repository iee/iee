package org.eclipse.iee.editor.core.pad;

import org.eclipse.core.runtime.Assert;
import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.editor.core.container.Container;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;

public abstract class CompositePad<T extends PadDocumentPart> extends Pad<T> {
	
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
				Rectangle bounds = fContent.getBounds();
				fContainer.setBounds(bounds);
				updateSelectionBounds(bounds);
			}

			@Override
			public void controlMoved(ControlEvent e) {
				updateSelectionBounds(fContent.getBounds());
			}
		});

		createPartControl(fContent);

		addMouseListeners(parent);

	}
	
	protected abstract void createPartControl(Composite parent);

	@Override
	public Rectangle getBounds() {
		return fContent.getBounds();
	}

	@Override
	public void setBounds(Rectangle newBounds) {
		fContent.setBounds(newBounds);
	}

	@Override
	public void setVisible(boolean isVisible) {
		fContent.setVisible(isVisible);
	}

}
