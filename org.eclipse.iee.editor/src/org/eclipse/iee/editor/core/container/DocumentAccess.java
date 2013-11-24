package org.eclipse.iee.editor.core.container;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.eclipse.iee.core.document.parser.DocumentStructureConfig;
import org.eclipse.iee.core.document.source.ISourceGeneratorContext;
import org.eclipse.iee.core.document.writer.DefaultDocumentWriter;
import org.eclipse.iee.editor.core.utils.runtime.file.FileMessager;
import org.eclipse.iee.translator.antlr.translator.JavaTranslator;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.swt.widgets.Display;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Throwables;

public class DocumentAccess {

	private static final Logger logger = LoggerFactory.getLogger(DocumentAccess.class);

	/* Access actions IDs */
	static final int WRITE = 0;
	static final int RELEASE = 1;

	private ContainerManager fContainerManager;
	private IDocument fDocument;
	
	private DocumentStructureConfig fConfig = new DocumentStructureConfig();

	private DefaultDocumentWriter fWriter; 
	
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
		fDocument = containerManager.getDocument();
		fWriter = containerManager.getWriter();
	}

	/**
	 * Adds access action to queue;
	 */
	void requestAccessAction(int actionID, Container container) {
		fContainerDocumentAccessQueue
				.add(new AccessAction(actionID, container));
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				processNextDocumentAccessRequest();
			}
		});
	}

	/**
	 * This function is called by ContainerManager when document modification is
	 * allowed.
	 */
	boolean processNextDocumentAccessRequest() {
		logger.debug("processNextDocumentAccessRequest");

		AccessAction action;
		while ((action = fContainerDocumentAccessQueue.poll()) != null) {
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
		
		return false;
	}

	/* Format */

	/**
	 * This function is called by ContainerManager which puts Container data to
	 * Document
	 */
	public void writeContentToTextRegion(final Container container) {
		
		String payload = getPayload(container);
		
		Position position = container.getPosition();

		int from = position.getOffset() + fWriter.getPrologue().length();

		int length = position.getLength() - fWriter.getPrologue().length() - fWriter.getEpilogue().length();
		
		try {
			if (fDocument.get(from, length).equals(payload)) {
				return;
			}
			fDocument.replace(from, length, payload.toString());
		} catch (BadLocationException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public Container createContent(final Container container) {
		
		String payload = getPayload(container);
		
		Position position = container.getPosition();

		int from = position.getOffset();

		int length = position.getLength();
		
		String text = fWriter.getPrologue() + payload + fWriter.getEpilogue();
		
		try {
			container.updatePosition(from, text.length());
			if (!fDocument.get(from, length).equals(text)) {
				fDocument.replace(from, length, text);
			}
			return container;
		} catch (BadLocationException e) {
			throw Throwables.propagate(e);
		}
	}

	private String getPayload(final Container container) {
		String payload = fWriter.writeInternalsToString(container.getPadPart(), new ISourceGeneratorContext() {
			@Override
			public String translateFunction(String function, String id) {
				try {
					return JavaTranslator.translate(function,
							container.getContainerManager().getCompilationUnit(),
							container.getPosition().getOffset(), container.getContainerID());
				} catch (Exception e) {
					e.printStackTrace();
					return "";
				}
			}

			@Override
			public String getStoragePath() {
				return container.getContainerManager().getStoragePath() + "/" +
						FileMessager.getInstance().getRuntimeDirectoryName();
			}});
		return payload;
	}

	/**
	 * Removes container's text region from document. This function is called
	 * from ContainerManager
	 */
	protected void releaseTextRegion(Container container) {
		Position position = container.getPosition();
		try {
			fDocument.replace(position.getOffset(), position.getLength() - 1,
					"");
		} catch (BadLocationException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
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
			return null;
		}
	}

	public boolean hasNextDocumentAccessRequest() {
		return !fContainerDocumentAccessQueue.isEmpty();
	}

}
