package org.eclipse.iee.editor.core.container;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

public class Container {

	private String fContainerID;
	
	private String fContainerHiddenContent;
	private Position fPosition;
	private int fLineNumber;
	private Composite fComposite;

	private boolean fIsDisposed;
	private boolean fIsTextRegionReleaseRequested;

	private ControlListener fCompositeResizeListener;

	private ContainerManager fContainerManager;
	private DocumentAccess fDocumentAccess;
	protected IDocument fDocument;
	private StyledText fStyledText;


	/**
	 * Creates new container with @param containerID at @param position
	 * 
	 * @param position
	 * @param containerID
	 */
	Container(Position position, String containerID, ContainerManager containerManager) {
		fPosition = position;
		fContainerID = containerID;
		fContainerHiddenContent = "";
		fIsDisposed = false;
		fIsTextRegionReleaseRequested = false;

		fContainerManager = containerManager;
		fDocumentAccess = containerManager.getDocumentAccess();
		fDocument = containerManager.getDocument();
		fStyledText = containerManager.getStyledText();

		fLineNumber = fContainerManager.getLineNumberByOffset(fPosition.offset, fDocument);

		fComposite = new Composite(fStyledText, SWT.NONE);

		initListeners();
		updateTextRegion();
	}

	public void recreateComposite() {
		releaseListeners();
		fComposite.dispose();
		fComposite = new Composite(fStyledText, SWT.NONE);
		setListeners();
	}

	private void initListeners() {
		fCompositeResizeListener = new ControlListener() {

			@Override
			public void controlResized(ControlEvent e) {
				fStyledText.redraw();
				fContainerManager.updateContainerPresentations();
			}

			@Override
			public void controlMoved(ControlEvent e) {
				fStyledText.redraw();
				// XXX fContainerManager.updateContainerPresentations();
			}
		};
		setListeners();
	}
	

	void updateTextRegion() {
		fDocumentAccess.requestTextRegionUpdate(this);
	}
	
	public void releaseTextRegion() {
		fIsTextRegionReleaseRequested = true;
		fDocumentAccess.requestTextRegionUpdate(this);
	}


	/* Setters */
	
	private void setListeners() {
		fComposite.addControlListener(fCompositeResizeListener);
	}

	private void releaseListeners() {
		fComposite.removeControlListener(fCompositeResizeListener);
	}

	public void setContainerID(String containerID) {
		fContainerID = containerID;
		updateTextRegion();
	}

	
	/* Getters */
	
	public String getContainerID() {
		return fContainerID;
	}

	public int getLineNumber() {
		return fLineNumber;
	}
	
	public String getContainerHiddenContent() {
		return fContainerHiddenContent;
	}

	public Position getPosition() {
		return fPosition;
	}

	public Composite getComposite() {
		return fComposite;
	}

	public String getContainerManagerID() {
		return fContainerManager.getContainerManagerID();
	}

	public boolean isDisposed() {
		return fIsDisposed;
	}


	protected boolean isTextRegionReleaseRequested() {
		return fIsTextRegionReleaseRequested;
	}

	/**
	 * Sets container's position.
	 * 
	 * @param offset
	 * @param length
	 */
	void updatePosition(int offset, int length) {
		fPosition.setOffset(offset);
		fPosition.setLength(length);
		fLineNumber = fContainerManager.getLineNumberByOffset(fPosition.offset, fDocument);
	}

	/**
	 * Disposes containers's SWT-composite.
	 */
	void dispose() {
		releaseListeners();
		fComposite.dispose();
		fIsDisposed = true;
	}

	/**
	 * Sets container's SWT-composite visibility.
	 * 
	 * @param isVisiable
	 */
	void setVisible(boolean isVisible) {
		fComposite.setVisible(isVisible);
	}

	/**
	 * This function causes container's SWT-composite get into proper position.
	 */
	void updatePresentation() {
		Point point = fStyledText.getLocationAtOffset(fPosition.getOffset());
		Point gabarit = fComposite.getSize();
		fComposite.setBounds(point.x, point.y, gabarit.x, gabarit.y);
	}

	@Override
	public String toString() {
		return "[" + fContainerID + ", " + fPosition + "]";
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
}
