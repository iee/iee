package org.eclipse.iee.editor.core.container;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;

public class DocumentAccess {
	
	/* Access actions IDs */
	static final int WRITE = 0;
	static final int RELEASE = 1;
	
	private ContainerManager fContainerManager;
	private ContainerManagerConfig fConfig;
	private IDocument fDocument;
	
	public class AccessAction {
		AccessAction(int actionID, Container container) {
			this.actionID = actionID;
			this.container = container;
		}		
		public final int actionID;
		public final Container container;
	};
	
	private Queue<AccessAction> fContainerDocumentAccessQueue = new ConcurrentLinkedQueue<AccessAction>();
	
	DocumentAccess(ContainerManager containerManager) {
		fContainerManager = containerManager;
		fConfig = containerManager.getConfig();
		fDocument = containerManager.getDocument();
	}
	
	/**
	 * Adds access action to queue;
	 */
	void requestAccessAction(int actionID, Container container) {
		fContainerDocumentAccessQueue.add(new AccessAction(actionID, container));
	}
	
	/**
	 * This function is called by ContainerManager when document modification is
	 * allowed.
	 */
	void processNextDocumentAccessRequest() {
		AccessAction action = fContainerDocumentAccessQueue.poll();
		Container container = action.container;
		
		switch (action.actionID) {
		case WRITE:
			writeContentToTextRegion(container);
			break;
		case RELEASE:
			releaseTextRegion(container);			
			break;
		}
	}
	
	
	/* Format */

	/**
	 * This function is called by ContainerManager which puts Container data to Document
	 */
	protected void writeContentToTextRegion(Container container) {
		Position position = container.getPosition();
		String hiddenContent = "";
		
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
		String hiddenContent = "";

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
