package org.eclipse.iee.editor.core.container;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;

public class DocumentAccess {

	private ContainerManager fContainerManager;
	private ContainerManagerConfig fConfig;
	private IDocument fDocument;
	
	private Queue<Container> fContainerDocumentAccessQueue = new ConcurrentLinkedQueue<Container>();
	
	DocumentAccess(ContainerManager containerManager) {
		fContainerManager = containerManager;
		fConfig = containerManager.getConfig();
		fDocument = containerManager.getDocument();
	}
	
	
	/**
	 * This function is called by ContainerManager when document modification is
	 * allowed.
	 * 
	 * @param document
	 */
	void processNextDocumentAccessRequest() {
		Container container = fContainerDocumentAccessQueue.poll();
		if (container != null) {
			if (container.isTextRegionReleaseRequested()) {
				releaseTextRegion(container);
			} else {
				writeContentToTextRegion(container);
			}
		}
	}
	
	/**
	 * Requests container's text region updating
	 */
	void requestTextRegionUpdate(Container container) {
		fContainerDocumentAccessQueue.add(container);
	}
	
	/**
	 * Requests container's text region release
	 */
	void requestTextRegionRelease(Container container) {
		fContainerDocumentAccessQueue.add(container);
	}


	/* Format */

	/**
	 * This function is called by ContainerManager which puts Container data to Document
	 */
	protected void writeContentToTextRegion(Container container) {
		Position position = container.getPosition();
		String hiddenContent = container.getContainerHiddenContent();
		
		int from = position.getOffset()
			+ fContainerManager.getConfig().EMBEDDED_REGION_BEGIN.length();

		int length = position.getLength()
			- fContainerManager.getConfig().EMBEDDED_REGION_BEGIN.length()
			- fContainerManager.getConfig().EMBEDDED_REGION_BEGIN.length();

		try {
			fDocument.replace(from, length, container.getContainerID());
			fDocument.replace(position.getOffset() + position.getLength(),
					hiddenContent.length(), hiddenContent);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Removes container's text region from document. This function is called
	 * from ContainerManager
	 */
	protected void releaseTextRegion(Container container) {
		Position position = container.getPosition();
		String hiddenContent = container.getContainerHiddenContent();

		try {
			fDocument.replace(position.getOffset(), position.getLength()
					+ hiddenContent.length(), "");
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Generates initial text region
	 */
	String getInitialTextRegion(String containerID) {
		return fConfig.EMBEDDED_REGION_BEGIN
			   + containerID +
			   fConfig.EMBEDDED_REGION_END;
	}

	/**
	 * Parses @param textRegion and returns container's id
	 * 
	 * @param textRegion
	 * @return Container's id
	 */
	String getContainerIDFromTextRegion(String textRegion) {		
		int from = fConfig.EMBEDDED_REGION_BEGIN.length();
		
		int to = textRegion.indexOf(fConfig.EMBEDDED_REGION_END);

		try {
			return textRegion.substring(from, to);
		} catch (IndexOutOfBoundsException e) {
			return null;
		}
	}

}
