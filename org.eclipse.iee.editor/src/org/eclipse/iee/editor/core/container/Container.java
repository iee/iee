package org.eclipse.iee.editor.core.container;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.IFigure;
import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.jface.text.ITextViewerExtension5;
import org.eclipse.jface.text.Position;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.IPropertySource;

public class Container implements IAdaptable {

	private PadDocumentPart fPadPart;
	
	private final Position fPosition;

	private final ContainerManager fContainerManager;
	
	private DocumentAccess fDocumentAccess;

	private final Pad<?> fPad;
	
	/* Setters */

	public String getContainerID() {
		return getPadPart().getId();
	}

	public Position getPosition() {
		return fPosition;
	}

	public PadDocumentPart getPadPart() {
		return fPadPart;
	}

	public String getContainerManagerID() {
		return fContainerManager.getContainerManagerID();
	}

	public ContainerManager getContainerManager() {
		return fContainerManager;
	}

	public void updateDocument() {
		fDocumentAccess.requestAccessAction(DocumentAccess.WRITE, this);
	}

	/**
	 * Request for container destruction. Called from PadManager.
	 */
	public void destroy() {
		fDocumentAccess.requestAccessAction(DocumentAccess.RELEASE, this);
	}

	/* FUNCTION USED IN CONTAINER MANAGER: */

	public Container(Position position, ContainerManager containerManager, PadDocumentPart part, Pad<?> pad) {
		fPosition = position;
		fContainerManager = containerManager;
		this.fPad = pad;
		fDocumentAccess = containerManager.getDocumentAccess();
		fPadPart = part;
		pad.attachContainer(this);
	}

	/**
	 * This function causes container's SWT-composite get into proper position.
	 */
	boolean updatePresentation() {
		// logger.debug("Updated container's position");

		ITextViewerExtension5 ext5 = (ITextViewerExtension5) fContainerManager.getSourceViewer();
		int offset = ext5.modelOffset2WidgetOffset(fPosition.getOffset());
		StyledText textWidget = fContainerManager.getStyledText();
		Point point = textWidget.getLocationAtOffset(offset);
		int height = textWidget.getLineHeight(offset);
		Rectangle bounds = getBounds();
		int heightOffset = height - bounds.height;
		Rectangle newBounds = new Rectangle(point.x
				+ StyledTextManager.PAD_LEFT_MARGIN, point.y + heightOffset,
				bounds.width, bounds.height);
		if (!bounds.equals(newBounds)) {
			fPad.setBounds(newBounds);
			return true;
		}
		return false;
	}
	
	/**
	 * Sets container's SWT-composite visibility.
	 */
	public void setVisible(boolean isVisible) {
		fPad.setVisible(isVisible);
	}

	/**
	 * Disposes containers's SWT-composite. Called from ContainerManager.
	 */
	void dispose() {
		fPad.dispose();
	}

	@Override
	public String toString() {
		return "[" + getContainerID() + ", " + fPosition + "]";
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class adapter) {
		if (IPropertySource.class.equals(adapter)) {
			return new ContainerPropertySource(this);
		} 
		return null;
	}

	public Rectangle getBounds() {
		return fPad.getBounds();
	}

	public Composite getTextWidget() {
		return fContainerManager.getStyledText();
	}

	public void setBounds(Rectangle bounds) {
		updatePresentation();
	}

	public IFigure getMainFigure() {
		return fContainerManager.getMainFigure();
	}

	public Pad<?> getPad() {
		return fPad;
	}

}
