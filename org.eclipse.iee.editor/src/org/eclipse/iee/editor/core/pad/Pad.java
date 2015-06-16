package org.eclipse.iee.editor.core.pad;

import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.editor.core.bindings.DefaultObservableValue;
import org.eclipse.iee.editor.core.bindings.IObservableValue;
import org.eclipse.iee.editor.core.container.Container;
import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.iee.editor.core.container.ITextEditor;
import org.eclipse.iee.editor.core.pad.common.text.AbstractTextEditor;
import org.eclipse.iee.editor.core.pad.common.text.TextLocation;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.services.IDisposable;

public abstract class Pad<T extends PadDocumentPart> extends AbstractTextEditor<T> implements IDisposable, ITextEditor<T> {

	protected Container fContainer;

	private final RectangleFigure selectionFigure; 

	private IObservableValue<T> fObservableValue = new DefaultObservableValue<T>();
	
	public Pad() {
		selectionFigure = new RectangleFigure();
		selectionFigure.setForegroundColor(IPadConfiguration.BORDER_COLOR_SELECTED);
		selectionFigure.setLineWidth(1);
		selectionFigure.setFill(false);
	}
	
	public Pad(T model) {
		this();
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
		IFigure figure = fContainer.getFeedbackFigure();
		if (isSelected) {
			Rectangle bounds = getBounds();
			updateSelectionBounds(bounds);
			figure.add(selectionFigure);
		} else if (selectionFigure.getParent() != null) {
			selectionFigure.getParent().remove(selectionFigure);
		}
	}

	protected void updateSelectionBounds(Rectangle bounds) {
		selectionFigure.setBounds(new org.eclipse.draw2d.geometry.Rectangle(bounds.x - 2, bounds.y - 2, bounds.width + 4, bounds.height + 4));
	}

	public void moveCaretToCurrentPad() {
		int containerOffset = fContainer.getPosition().getOffset();
		fContainer.getContainerManager().getUserInteractionManager()
				.moveCaretTo(containerOffset);
	}
	
	public void focusOnMainEditor() {
		fContainer.getContainerManager().getUserInteractionManager()
				.focusOnMainEditor();
	}

	public abstract void attachContainer(Container container);

	public void addMouseListeners(Composite control) {
		MouseEventManager mouseManager = new MouseEventManager(control);
		control.addMouseTrackListener(mouseManager);
		control.addMouseMoveListener(mouseManager);
		control.addMouseListener(mouseManager);
	}

	public void detachContainer() {
		Assert.isLegal(isContainerAttached(), "No container attached");
		fContainer = null;
	}

	public abstract void activate();

	public void deactivate() {
	}

	/**
	 * Copy pad with @param containerID
	 * 
	 * @return
	 */
	public abstract Pad<T> copy();

	/**
	 * Save pad
	 */
	public abstract void save();

	/**
	 * Remove pad's storage
	 */
	public abstract void unsave();

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
		return (T) fContainer.getPadPart();
	}
	
	public void bindDocumentPart(IObservableValue<T> model) {
		bindObservableValue(model);
	}
	
	public String getContainerID() {
		return getDocumentPart().getId();
	}

	public void dispose() {
	}

	public abstract Rectangle getBounds();

	public abstract void setBounds(Rectangle newBounds);

	public abstract void setVisible(boolean isVisible);
	
	@Override
	public void acceptCaret(Caret caret, TextLocation textLocation) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public TextLocation getTextLocation(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void setActive(boolean b) {
		if (b) {
			activate();
		} else {
			deactivate();
		}
		
	}
	
	@Override
	public boolean isSelectable() {
		return true;
	}
	
	
}
