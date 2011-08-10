package org.eclipse.iee.editor.core.container;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.LineStyleEvent;
import org.eclipse.swt.custom.LineStyleListener;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.GlyphMetrics;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

public class Container {

	private String	  fContainerID;
	private Position  fPosition;	
	private Composite fComposite;
	private boolean   fIsDisposed;
	private boolean   fIsTextRegionReleaseRequested;

	private LineStyleListener fLineStyleListener;
	private ControlListener fCompositeResizeListener;
	
	private StyledText fStyledText;
	private ContainerManager fContainerManager;
	
	
    private static Queue<Container> fContainerDocumentAccessQueue =
    	new ConcurrentLinkedQueue<Container>();
	
	
	/**
	 * Creates new container with @param containerID at @param position
	 * @param position
	 * @param containerID
	 */
	Container(Position position, String containerID, StyledText styledText, ContainerManager containerManager) {
		fPosition = position;
		fContainerID = containerID;
		fIsDisposed = false;
		fIsTextRegionReleaseRequested = false;
		
		fStyledText = styledText;
		fContainerManager = containerManager;
		
		fComposite = new Composite(fStyledText, SWT.NONE);
		
		initListeners();		
		requestTextRegionUpdate();
	}
	
	public void recreateComposite() {
		releaseListeners();
		fComposite.dispose();
		
		fComposite = new Composite(fStyledText, SWT.NONE);
		setListeners();
	}
	
	
	private void initListeners() {
		fLineStyleListener = new LineStyleListener() {
			@Override
			public void lineGetStyle(LineStyleEvent e) {
				String containerID = getContainerIDFromTextRegion(e.lineText);				
				if (containerID != null && containerID.equals(fContainerID)) {
					StyleRange compositeStyle = new StyleRange();
					compositeStyle.start = e.lineOffset;
					compositeStyle.length = 1;
					compositeStyle.metrics = new GlyphMetrics(
						fComposite.getSize().y, 0, fComposite.getSize().x);
					
					StyleRange hiddenTextStyle = new StyleRange();
					hiddenTextStyle.start = e.lineOffset + 1;
					hiddenTextStyle.length = e.lineText.length() - 1;
					hiddenTextStyle.metrics = new GlyphMetrics(0, 0, 0);
					
					e.styles = new StyleRange[] { compositeStyle, hiddenTextStyle };
				}
			}
		};
		
		fCompositeResizeListener = new ControlListener() {
			@Override
			public void controlResized(ControlEvent e) {
				fStyledText.redraw();
				fContainerManager.updateContainerPresentaions();
			}			
			@Override public void controlMoved(ControlEvent e) {}
		};		

		setListeners();
	}
	
	private void setListeners() {
		fStyledText.addLineStyleListener(fLineStyleListener);
		fComposite.addControlListener(fCompositeResizeListener);	
	}
	
	private void releaseListeners() {
		fStyledText.removeLineStyleListener(fLineStyleListener);
		fComposite.removeControlListener(fCompositeResizeListener);
	}

	public void setContainerID(String containerID) {
		fContainerID = containerID;
		requestTextRegionUpdate();
	}
	
	public String getContainerID() {
		return fContainerID;
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
	
	public void requestDispose() {
		requestTextRegionRelease();
	}	
	
	protected boolean isTextRegionReleaseRequested() {
		return fIsTextRegionReleaseRequested;
	}
	
	
	/**
	 * Sets container's position.
	 * @param offset
	 * @param length
	 */
	void updatePosition(int offset, int length) {
		fPosition.setOffset(offset);
		fPosition.setLength(length);
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
	 * @param isVisiable
	 */	
	void setVisiable(boolean isVisiable) {
		fComposite.setVisible(isVisiable);
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

	
	/* DataAccess */
	
	
	/**
	 * Generates initial text region
	 * @param containerID
	 * @return Generated text region
	 */
	static String getInitialTextRegion(String containerID) {
    	return
    		IConfiguration.EMBEDDED_REGION_BEGINS +
			containerID +
			IConfiguration.EMBEDDED_REGION_ENDS + "\n";
    }
	
	
	/**
	 * Parses @param textRegion and returns container's id 
	 * @param textRegion
	 * @return Container's id
	 */
	static String getContainerIDFromTextRegion(String textRegion) {
		int from = IConfiguration.EMBEDDED_REGION_BEGINS.length();
		int to = textRegion.indexOf(IConfiguration.EMBEDDED_REGION_ENDS);
		
		try {
			return textRegion.substring(from, to);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}
	
	
	/**
	 * This function is called by ContainerManager when document modification is allowed.
	 * @param document
	 */
	static void processNextDocumentAccessRequest(IDocument document) {
		Container container = fContainerDocumentAccessQueue.poll();
		if (container != null) {
		   	if (container.isTextRegionReleaseRequested()) {
		   		container.releaseTextRegion(document);
		   	} else {
		   		container.writeContentToTextRegion(document);
		   	}
		}
	}
	
	
	/**
	 *  Requests container's text region updating
	 */	
	void requestTextRegionUpdate() {
		fContainerDocumentAccessQueue.add(this);
	}
	
	
	/**
	 * Requests container's text region release
	 */
	void requestTextRegionRelease() {
		fIsTextRegionReleaseRequested = true;
		fContainerDocumentAccessQueue.add(this);
	}

	
	/**
	 *  This function is called by ContainerManager which puts Container data to Document 
	 */
	protected void writeContentToTextRegion(IDocument document) {
		System.out.println("writeContentToTextRegion");
		
		int from = fPosition.getOffset()
			+ IConfiguration.EMBEDDED_REGION_BEGINS.length();
		
		int length = fPosition.getLength()
			- IConfiguration.EMBEDDED_REGION_BEGINS.length()
			- IConfiguration.EMBEDDED_REGION_ENDS.length();
				
		try {
			document.replace(from, length, fContainerID);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Removes container's text region from document. This function is called from ContainerManager
	 * @param document
	 */
	protected void releaseTextRegion(IDocument document) {
		try {
			document.replace(fPosition.getOffset(), fPosition.getLength(), "");
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	
    /* Functions for comparator */

	
	/**
	 * Creates temporary container with position at @param offset, used for comparison
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
