package org.eclipse.iee.editor.core.container;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewerExtension5;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.IPropertySource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Container implements IAdaptable {

	private static final Logger logger = LoggerFactory.getLogger(Container.class);

	private PadDocumentPart padPart;
	
	private Position fPosition;
	private Composite fComposite;

	private ControlListener fCompositeResizeListener;

	private ContainerManager fContainerManager;
	private DocumentAccess fDocumentAccess;
	protected IDocument fDocument;
	private ISourceViewer fSourceViewer;

	/* Setters */

	public String getContainerID() {
		return getPadPart().getId();
	}

	public Position getPosition() {
		return fPosition;
	}

	public Composite getComposite() {
		return fComposite;
	}

	public int getLineNumber() {
		try {
			return fDocument.getLineOfOffset(fPosition.offset);
		} catch (BadLocationException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return -1;
		}
	}
	
	public PadDocumentPart getPadPart() {
		return padPart;
	}

	public void setPadPart(PadDocumentPart padPart) {
		this.padPart = padPart;
	}

	public String getContainerManagerID() {
		return fContainerManager.getContainerManagerID();
	}

	public ContainerManager getContainerManager() {
		return fContainerManager;
	}

	/* FUNCTIONS USED IN PAD MANAGER: */

	/**
	 * Called when SWT-composite needs to be reloaded.
	 */
	public void reset() {
		this.recreateComposite();
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

	public Container(Position position, ContainerManager containerManager) {
		fPosition = position;
		fContainerManager = containerManager;
		fDocumentAccess = containerManager.getDocumentAccess();
		fDocument = containerManager.getDocument();
		fSourceViewer = containerManager.getSourceViewer();

		fComposite = new Composite(fSourceViewer.getTextWidget(), SWT.NONE);

		initListeners();
	}

	/**
	 * This function causes container's SWT-composite get into proper position.
	 */
	boolean updatePresentation() {
		// logger.debug("Updated container's position");

		ITextViewerExtension5 ext5 = (ITextViewerExtension5) fSourceViewer;
		int offset = ext5.modelOffset2WidgetOffset(fPosition.getOffset());
		StyledText textWidget = fSourceViewer.getTextWidget();
		Point point = textWidget.getLocationAtOffset(offset);
		int height = textWidget.getLineHeight(offset);
		Point gabarit = fComposite.getSize();
		int heightOffset = height - gabarit.y;
		Rectangle newBounds = new Rectangle(point.x
				+ StyledTextManager.PAD_LEFT_MARGIN, point.y + heightOffset,
				gabarit.x, gabarit.y);
		if (!fComposite.getBounds().equals(newBounds)) {
			fComposite.setBounds(newBounds);
			return true;
		}
		return false;
	}
	
	/**
	 * Sets container's SWT-composite visibility.
	 */
	void setVisible(boolean isVisible) {
		fComposite.setVisible(isVisible);
	}

	/**
	 * Disposes containers's SWT-composite. Called from ContainerManager.
	 */
	void dispose() {
		releaseListeners();
		fComposite.dispose();
	}

	/* INTERNAL FUNCTIONS: */

	private void initListeners() {
		fCompositeResizeListener = new ControlListener() {

			@Override
			public void controlResized(ControlEvent e) {
				fContainerManager.updateContainerPresentations(Container.this);
			}

			@Override
			public void controlMoved(ControlEvent e) {
			}
		};
		setListeners();
	}

	private void setListeners() {
		fComposite.addControlListener(fCompositeResizeListener);
	}

	private void releaseListeners() {
		fComposite.removeControlListener(fCompositeResizeListener);
	}

	private void recreateComposite() {
		releaseListeners();
		fComposite.dispose();
		fComposite = new Composite(fSourceViewer.getTextWidget(), SWT.NONE);
		setListeners();
	}

	/* Functions for comparator */

	/**
	 * Creates temporary container with position at @param offset, used for
	 * comparison
	 * 
	 * @return Temporary container at @param offset
	 */
	static Container atOffset(int offset) {
		return new Container(new Position(offset, 0));
	}

	/**
	 * Private constructor for temporary containers, used for comparison
	 */
	private Container(Position position) {
		fPosition = position;
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
}
