package org.eclipse.iee.editor.core.pad;

import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.editor.core.container.Container;
import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Pad<T extends PadDocumentPart> {

	private static final Logger logger = LoggerFactory.getLogger(Pad.class);

	private Container fContainer;

	private T fDocumentPart;
	
	private Color fBorderColor = IPadConfiguration.BORDER_COLOR_NOT_SELECTED;

	public Pad(T documentPart) {
		fDocumentPart = documentPart;
	}

	public String getContainerManagerID() {
		if (fContainer == null) {
			return null;
		}
		return fContainer.getContainerManagerID();
	}

	public boolean isContainerAttached() {
		return fContainer != null;
	}

	public Container getContainer() {
		return fContainer;
	}

	public void setSelected(boolean isSelected) {
		fBorderColor = (isSelected) ? IPadConfiguration.BORDER_COLOR_SELECTED
				: IPadConfiguration.BORDER_COLOR_NOT_SELECTED;
		if (fContainer != null) {
			fContainer.getComposite().setBackground(fBorderColor);
		}
	}

	public void moveCaretToCurrentPad() {
		int containerOffset = fContainer.getPosition().getOffset();
		fContainer.getContainerManager().getUserInteractionManager()
				.moveCaretTo(containerOffset);
	}

	public void attachContainer(Container container) {
		Assert.isNotNull(container);
		Assert.isLegal(!isContainerAttached(),
				"Another container is already attached");

		container.updateDocument();

		fContainer = container;
		final Composite parent = fContainer.getComposite();

		/* Create Pad's border and content area */
		FillLayout layout = new FillLayout();
		layout.marginHeight = IPadConfiguration.BORDER_WIDTH;
		layout.marginWidth = IPadConfiguration.BORDER_WIDTH;
		parent.setLayout(layout);

		parent.setBackground(fBorderColor);

		final Composite content = new Composite(parent, SWT.NONE);
		parent.pack();

		content.addControlListener(new ControlListener() {
			@Override
			public void controlResized(ControlEvent e) {
				parent.setSize(content.getSize().x + 2
						* IPadConfiguration.BORDER_WIDTH, content.getSize().y
						+ 2 * IPadConfiguration.BORDER_WIDTH);
			}

			@Override
			public void controlMoved(ControlEvent e) {
			}
		});

		createPartControl(content);
		fContainer.getComposite().pack();

		addMouseListeners(parent);

		onContainerAttached();

	}

	public void addMouseListeners(Composite control) {
		MouseEventManager mouseManager = new MouseEventManager(control);
		control.addMouseTrackListener(mouseManager);
		control.addMouseMoveListener(mouseManager);
		control.addMouseListener(mouseManager);
	}

	public void detachContainer() {
		Assert.isLegal(isContainerAttached(), "No container attached");

		fBorderColor = IPadConfiguration.BORDER_COLOR_NOT_SELECTED;
		fContainer = null;
	}

	/* Abstract methods */

	/**
	 * Method is called when Container is attached to Pad
	 */
	public abstract void createPartControl(Composite parent);

	public abstract void activate();

	public void deactivate() {
	}

	/**
	 * Copy pad with @param containerID
	 * 
	 * @return
	 */
	public abstract Pad copy();

	/**
	 * Save pad
	 */
	public abstract void save();

	/**
	 * Remove pad's storage
	 */
	public abstract void unsave();

	/**
	 * Called when container is attached
	 */
	public abstract void onContainerAttached();

	public abstract String getType();

	public abstract String getTex();

	public void updateData(Map<String, String> params, String value) {
	}

	protected void moveCaretToContainerTail() {
		Container c = getContainer();
		ContainerManager containerManager = c.getContainerManager();
		containerManager.getUserInteractionManager().moveCaretTo(
				c.getPosition().getOffset() + c.getPosition().getLength());
	}
	
	public T getDocumentPart() {
		return fDocumentPart;
	}

	public String getContainerID() {
		return getDocumentPart().getId();
	}

}
