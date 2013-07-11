package org.eclipse.iee.editor.core.container;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;

public class DocumentAccess {
	
	private static final Logger logger = Logger.getLogger(DocumentAccess.class);
	
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
		if (fContainerManager.isModificationAllowed()) {
			processNextDocumentAccessRequest();
		}
	}
	
	/**
	 * This function is called by ContainerManager when document modification is
	 * allowed.
	 */
	boolean processNextDocumentAccessRequest() {
		logger.debug("processNextDocumentAccessRequest");
		
		AccessAction action = fContainerDocumentAccessQueue.poll();
		if (action == null) {
			return false;
		}
		
		Container container = action.container;
		switch (action.actionID) {
		case WRITE:
			writeContentToTextRegion(container);
			break;
		case RELEASE:
			releaseTextRegion(container);
			break;
		}
		return true;
	}
	
	
	/* Format */

	/**
	 * This function is called by ContainerManager which puts Container data to Document
	 */
	protected void writeContentToTextRegion(Container container) {
		logger.debug("writeContentToTextRegion: " + container);
		
		Position position = container.getPosition();
		String textContent = container.getTextContent();
			
		/* Container ID */
		StringBuilder payload = new StringBuilder();
		payload.append(container.getPadType() != null ? container.getPadType() : "----");
		Map<String, String> padParams = container.getPadParams();
		if (padParams.size() > 0) {
			payload.append('(');
			boolean isFirst = true;
			for (Entry<String, String> entry : padParams.entrySet()) {
				if (!isFirst) {
					payload.append(",");
				}
				payload.append('"');
				payload.append(entry.getKey().replace("\"", "\\\""));
				payload.append("\"=\"");
				if (entry.getValue() != null) {
					payload.append(entry.getValue().replace("\"", "\\\""));
				}
				payload.append('"');
				isFirst = false;
			}
			payload.append(')');
		}
		if (container.getValue() != null && container.getValue().length() > 0) {
			payload.append(':').append(container.getValue());
		}
		
		if (textContent != null && !textContent.isEmpty()) {
			/* Payload if exists */
			
			payload.append(fConfig.INNER_TEXT_BEGIN);
			
			String[] lines = textContent.split("\n");
			for (int i = 0; i < lines.length - 1; i++) {
				payload.append(lines[i].trim())
					.append(fConfig.INNER_TEXT_BR);
			}
			payload.append(lines[lines.length - 1])
				.append(fConfig.INNER_TEXT_END);
		}
		
		/* Old bounds */
		
		int from = position.getOffset()
			+ fContainerManager.getConfig().EMBEDDED_REGION_BEGIN.length();

		int length = position.getLength()
			- fContainerManager.getConfig().EMBEDDED_REGION_BEGIN.length()
			- fContainerManager.getConfig().EMBEDDED_REGION_END.length();

		try {
			logger.debug("payload: " + payload.toString());
			fDocument.replace(from, length, payload.toString());
			
		} catch (BadLocationException e) {
			logger.error(e.getMessage());
			logger.error("method: writeContentToTextRegion");
			logger.error("fDocument: " + fDocument.get());
			logger.error("from: " + from + ", length: " + length);
			logger.error("payload: " + payload.toString());
						
			logger.error(e);
		}

	}

	/**
	 * Removes container's text region from document. This function is called
	 * from ContainerManager
	 */
	protected void releaseTextRegion(Container container) {
		Position position = container.getPosition();
		try {
			fDocument.replace(position.getOffset(), position.getLength() - 1, "");
		} catch (BadLocationException e) {
			logger.error(e.getMessage());
			logger.error("method: releaseTextRegion");
			logger.error("fDocument: " + fDocument);
			logger.error("position: " + position.toString());
			
			logger.error(e);
		}
	}
	
	/**
	 * Generates initial text region
	 * @param id 
	 */
	String getInitialTextRegion(String type, String id) {
		return fConfig.EMBEDDED_REGION_BEGIN
				   + type + "(\"id\"=\"" + id + "\")" +
				   fConfig.EMBEDDED_REGION_END;
	}

	/**
	 * Parses @param textRegion and returns container's id
	 */
	String getContainerIDFromTextRegion(String textRegion) {		
		int from = fConfig.EMBEDDED_REGION_BEGIN.length();
		
		int to = textRegion.indexOf(fConfig.INNER_TEXT_BEGIN); 
		if (to == -1) {
			to = textRegion.indexOf(fConfig.EMBEDDED_REGION_END);
		}
		
		try {
			return textRegion.substring(from, to);
		} catch (IndexOutOfBoundsException e) {
			logger.error(e.getMessage());
			logger.error("method: getContainerIDFromTextRegion");
			logger.error("textRegion: " + textRegion);
			logger.error("from: " + from + ", to: " + to);
			return null;
		}
	}

}
