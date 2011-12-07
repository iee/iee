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
	private String fTextContent;
	
	private Position fPosition;
	private Composite fComposite;

	private ControlListener fCompositeResizeListener;

	private ContainerManager fContainerManager;
	private DocumentAccess fDocumentAccess;
	protected IDocument fDocument;
	private StyledText fStyledText;

	
	/* Setters */

	public void setContainerID(String containerID) {
		fContainerID = containerID;
		fDocumentAccess.requestAccessAction(DocumentAccess.WRITE, this);
	}
	
	public void setTextContent(String content) {
		System.out.println("setTextContent");
		fTextContent = content;
		fDocumentAccess.requestAccessAction(DocumentAccess.WRITE, this);
	}

	/* Getters */
	
	public String getContainerID() {
		return fContainerID;
	}
	
	public String getTextContent() {
		return fTextContent;
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
	
	
	/* FUNCTIONS USED IN PAD MANAGER: */

	/**
	 * Called when SWT-composite needs to be reloaded.
	 */
	public void reset() {
		this.recreateComposite();
	}
	
	/**
	 * Request for container destruction. Called from PadManager.
	 */
	public void destroy() {
		fDocumentAccess.requestAccessAction(DocumentAccess.RELEASE, this);
	}
	
	/* FUNCTION USED IN CONTAINER MANAGER: */
	
	/**
	 * Creates new container.
	 */
	Container(Position position, String containerID, ContainerManager containerManager) {
		fPosition = position;
		fContainerID = containerID;

		fContainerManager = containerManager;
		fDocumentAccess = containerManager.getDocumentAccess();
		fDocument = containerManager.getDocument();
		fStyledText = containerManager.getStyledText();

		fComposite = new Composite(fStyledText, SWT.NONE);

		initListeners();
	}
	
	/**
	 * Sets container's position.
	 */
	void updatePosition(int offset, int length) {		
		fPosition.setOffset(offset);
		fPosition.setLength(length);
	}
	
	/**
	 * This function causes container's SWT-composite get into proper position.
	 */
	void updatePresentation() {
		System.out.println("updatePresentation");
		
		Point point = fStyledText.getLocationAtOffset(fPosition.getOffset());
		Point gabarit = fComposite.getSize();
		fComposite.setBounds(point.x, point.y, gabarit.x, gabarit.y);
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
				fContainerManager.updateContainersPresentations();
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
		fComposite = new Composite(fStyledText, SWT.NONE);
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
		return "[" + fContainerID + ", " + fPosition + "]";
	}
}
