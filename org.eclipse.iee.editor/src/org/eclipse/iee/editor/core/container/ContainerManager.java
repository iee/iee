package org.eclipse.iee.editor.core.container;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.common.EventManager;
import org.eclipse.core.runtime.Assert;
import org.eclipse.iee.editor.core.container.event.ContainerEvent;
import org.eclipse.iee.editor.core.container.event.IContainerManagerListener;
import org.eclipse.iee.editor.core.container.partitioning.PartitioningManager;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPartitioningException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.DocumentPartitioningChangedEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IDocumentPartitioningListener;
import org.eclipse.jface.text.IDocumentPartitioningListenerExtension2;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.custom.StyledText;
import org.perf4j.LoggingStopWatch;
import org.perf4j.StopWatch;

public class ContainerManager extends EventManager {

	private static final Logger logger = Logger.getLogger(ContainerManager.class);
	
	private final String fContainerManagerID;
	
	private final ContainerManagerConfig fConfig;
	
	private final DocumentAccess fDocumentAccess;
	
	private final StyledTextManager fStyledTextManager;
	
	private final UserInteractionManager fUserInteractionManager;
	
	@SuppressWarnings("unused")
	private final PartitioningManager fPartitioningManager;
	
	private final ISourceViewer fSourceViewer;
	
	private final StyledText fStyledText;
	
	private final IDocument fDocument;
	
	private DocumentListener fDocumentListener;

	private final NavigableSet<Container> fContainers;
	
	private static ContainerComparator fContainerComparator = new ContainerComparator();

	private enum State {
		READY,
		DOCUMENT_CHANGES_HANDLING
	}
	State fState = State.READY;
	
	
	
	/* Getters */

	
	public Object[] getElements() {
		return fContainers.toArray();
	}
		
	public List<Container> getContainers() {
		/* XXX Check performance */
		return new ArrayList<Container>(fContainers);
	}
	
	public String[] getContainerIDs() {
		String[] containerIDs = new String[fContainers.size()];
		int i = 0;
		for (Container container : fContainers) {
			containerIDs[i++] = container.getContainerID();
		}
		return containerIDs;
	}
		
	public Collection<Container> getContainersInRange(int from, int to) {		
		/* XXX check sublist!!! */
		return fContainers.subSet(
			Container.atOffset(from),
			true,
			Container.atOffset(to),
			true);
	}
		
	public String getContainerManagerID() {
		return fContainerManagerID;
	}

	public ContainerManagerConfig getConfig() {
		return fConfig;
	}
	
	public DocumentAccess getDocumentAccess() {
		return fDocumentAccess;
	}
	
	public IDocument getDocument() {
		return fDocument;
	}

	public StyledText getStyledText() {
		return fStyledText;
	}
	
	public StyledTextManager getStyledTextManager() {
		return fStyledTextManager;
	}
	
	public ISourceViewer getSourceViewer() {
		return fSourceViewer;
	}
	
	public UserInteractionManager getUserInteractionManager() {
		return fUserInteractionManager;
	}


	
	/* INTERFACE FUNCTIONS */
	
	
	public ContainerManager(ContainerManagerConfig config, IDocument document, ISourceViewer sourceViewer, StyledText styledText) {
		fContainerManagerID = UUID.randomUUID().toString();
		
		fConfig = config;
		fDocument = document;
		fStyledText = styledText;
		fSourceViewer = sourceViewer;
		
		fContainers = new TreeSet<Container>(fContainerComparator);

		fStyledTextManager = new StyledTextManager(this);
		fUserInteractionManager = new UserInteractionManager(this);
		fPartitioningManager = new PartitioningManager(this);
		fDocumentAccess = new DocumentAccess(this);
		
		fState = State.READY;
		
		initDocumentListener();
	}
	
	public void dispose() {
		removeDocumentListener();
	}

	public void RequestContainerAllocation(String containerID, int offset) {
		String containerEmbeddedRegion = fDocumentAccess.getInitialTextRegion(containerID);
		try {
			fDocument.replace(offset, 0, containerEmbeddedRegion);
		} catch (BadLocationException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public boolean isModificationAllowed() {
		return fState == State.READY;
	}
	
	public void updateContainersPresentations() {
		if (isModificationAllowed()) {
			boolean doInitiateTextPresentationUpdate = true;
			fStyledTextManager.updateStyles(doInitiateTextPresentationUpdate);
		}
	}


	
	/* Internal functions */

	
	protected void initDocumentListener() {
		fDocumentListener = new DocumentListener();
		fDocument.addDocumentPartitioningListener(fDocumentListener);
		fDocument.addDocumentListener(fDocumentListener);
	}
	
	protected void removeDocumentListener() {
		fDocument.removeDocumentPartitioningListener(fDocumentListener);
		fDocument.removeDocumentListener(fDocumentListener);
	}
	
	protected Container createContainer(Position position, String containerID) {
		return new Container(position, containerID,	this);
	}
	
	protected Container getContainerHavingOffset(int offset) {
		if (offset < 0)
			return null;
		Container c = fContainers.floor(Container.atOffset(offset));
		if (c != null && c.getPosition().includes(offset)) {
			return c;
		}
		return null;
	}
	
	void updateContainerVisibility(boolean visibility) {		
		Iterator<Container> it = fContainers.iterator();
		while (it.hasNext()) {
			Container container = it.next();
			if (!visibility) {
				container.setVisible(false);
			} else {
				container.setVisible(true);
			}
		}
	}
	
	
	
	/* DOCUMENT MODIFICATION EVENT PROCESSING */

	
	class DocumentListener implements IDocumentListener,
			IDocumentPartitioningListener,
			IDocumentPartitioningListenerExtension2 {
		private IRegion fChangedPartitioningRegion;

		public DocumentListener() {
			fChangedPartitioningRegion = null;
		}

		@Override
		public void documentPartitioningChanged(
				DocumentPartitioningChangedEvent event) {
			
			assert(fChangedPartitioningRegion == null);
						
			fChangedPartitioningRegion = event
				.getChangedRegion(PartitioningManager.PARTITIONING_ID);
			
			if (fChangedPartitioningRegion != null) {
				String[] partitionings = event.getChangedPartitionings();
				
				for (String partitioning : partitionings) {
					logger.debug("Changed partitionings: " + partitioning);
					logger.debug("Changed region: " + fChangedPartitioningRegion.toString());
					
					if (partitioning.equals(PartitioningManager.PARTITIONING_ID)) {
						continue;
					}
				}
			}
		}

		@Override
		public void documentChanged(DocumentEvent event) {

			// XXX
			//StopWatch padsPositionsCalculationSW = new LoggingStopWatch("padsPositionsCalculation");
					
			
			if (fState == State.READY) {
				logger.debug("\n\n== Begin of document modification handling ==");
				fState = State.DOCUMENT_CHANGES_HANDLING;	
			} else {
				logger.debug("\n\n== Internal document modification ==");
			}
			
			/*
			 * All pads which placed after 'unmodifiedOffset' are considered to
			 * be just moved without any other modifications.
			 * 
			 * It's calculated according following equation 'unmodified offset'
			 * = max('end of partitioning changed area', 'end of document
			 * changed area') - 'moving_delta'
			 */

			int unmodifiedOffset;
			final int movingDelta = event.getText().length()
					- event.getLength();

			if (fChangedPartitioningRegion != null) {
				unmodifiedOffset = Math.max(event.getOffset()
						+ event.getText().length(),
						fChangedPartitioningRegion.getOffset()
								+ fChangedPartitioningRegion.getLength());
				unmodifiedOffset -= movingDelta;
			} else {
				unmodifiedOffset = event.getOffset() + event.getLength();
			}

			/*
			 * Positive delta means that unmodified pads move forward. We have
			 * to perform this action before any other modifications to avoid
			 * collisions.
			 */

			if (movingDelta > 0) {
				moveUnmodifiedPads(unmodifiedOffset, movingDelta);
			}

			try {
				if (fChangedPartitioningRegion != null) {

					/*
					 * Case 1: Document partitioning is changed, so updating the
					 * set of the pads
					 */
					onPartitioningChanged(event, unmodifiedOffset);

				} else {
					Container current = getContainerHavingOffset(event
							.getOffset());
					if (current != null) {

						/*
						 * Case 2: Changed text area is inside current pad's
						 * area, updating it
						 */
						onChangesInsidePad(current, event);
					}

					/*
					 * Case 3: No pad modified, do nothing.
					 */
				}
			} catch (BadLocationException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			} catch (BadPartitioningException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			} catch (RuntimeException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}

			/*
			 * If delta is negative, we move unmodified pads backward, but after
			 * any other modifications are done.
			 */

			if (movingDelta < 0) {
				moveUnmodifiedPads(unmodifiedOffset, movingDelta);
			}

			fChangedPartitioningRegion = null;
			
			if (!fDocumentAccess.processNextDocumentAccessRequest()) {
				
				boolean doInitiateTextPresentationUpdate = false;
				fStyledTextManager.updateStyles(doInitiateTextPresentationUpdate);
				
				/* XXX Visibility */
				//updateContainerVisibility(true);
				
				fUserInteractionManager.updateCaretSelection();

				logger.debug("== End of document modification handling ==\n\n");
				fState = State.READY;

				/* For debug */
				fireDebugNotification();
				
				
				// XXX
				//padsPositionsCalculationSW.stop();
			}
		}

		private void onPartitioningChanged(DocumentEvent event,
				int unmodifiedOffset) throws BadLocationException,
				BadPartitioningException {

			/* Remove all elements within changed area */

			int beginRegionOffset = Math.min(event.getOffset(),
					fChangedPartitioningRegion.getOffset());

			Container from = fContainers.ceiling(Container
					.atOffset(beginRegionOffset));
			Container to = fContainers.lower(Container
					.atOffset(unmodifiedOffset));

			if (from != null && to != null
					&& fContainerComparator.isNotDescending(from, to)) {
				NavigableSet<Container> removeSet = fContainers.subSet(from,
						true, to, true);
				if (removeSet != null) {
					Container container;
					while ((container = removeSet.pollFirst()) != null) {

						/* Removing container */

						container.dispose();
						fireContainerRemoved(container);
					}
				}
			}

			/* Scanning for new containers */

			int offset = Math.max(event.getOffset(),
					fChangedPartitioningRegion.getOffset());
			while (offset < fChangedPartitioningRegion.getOffset()
					+ fChangedPartitioningRegion.getLength()) {
				ITypedRegion region = ((IDocumentExtension3) fDocument)
						.getPartition(PartitioningManager.PARTITIONING_ID,
								offset, false);

				if (region.getType().equals(
						PartitioningManager.CONTENT_TYPE_EMBEDDED)) {

					String containerTextRegion = fDocument.get(
							region.getOffset(), region.getLength());

					/* Adding container */

					String containerID = fDocumentAccess
							.getContainerIDFromTextRegion(containerTextRegion);

					Container container = createContainer(
							new Position(region.getOffset(), region.getLength()),
							containerID);

					/* XXX Visibility */
					container.setVisible(false);
					
					fContainers.add(container);
					fireContainerCreated(container);
				}
				offset += region.getLength();
			}
		}

		private void onChangesInsidePad(Container container, DocumentEvent event)
				throws BadLocationException, BadPartitioningException {
			ITypedRegion region = ((IDocumentExtension3) fDocument)
					.getPartition(PartitioningManager.PARTITIONING_ID,
							event.getOffset(), false);

			Assert.isTrue(container.getPosition().getOffset() == region
					.getOffset());
			
			

			/* Updating container */
			container.updatePosition(region.getOffset(), region.getLength());
		}

		private void moveUnmodifiedPads(int offset, int delta) {
			Container from = fContainers.ceiling(Container.atOffset(offset));
			if (from == null)
				return;

			NavigableSet<Container> tail = fContainers.tailSet(from, true);
			Iterator<Container> it = tail.iterator();
			while (it.hasNext()) {
				Container container = it.next();
				Position position = container.getPosition();

				/* Updating container */
				container.updatePosition(position.getOffset() + delta,
						position.getLength());
			}
		}

		@Override
		public void documentPartitioningChanged(IDocument document) {
		}

		@Override
		public void documentAboutToBeChanged(DocumentEvent event) {
		}
	}
	
	
	
	/* FUNCTIONS FOR OBSERVERS */
	

	public void addContainerManagerListener(IContainerManagerListener listener) {
		Assert.isNotNull(listener);
		addListenerObject(listener);
	}

	public void removeContainerManagerListener(IContainerManagerListener listener) {
		Assert.isNotNull(listener);
		removeListenerObject(listener);
	}

	protected void fireContainerCreated(Container c) {
		Object[] listeners = getListeners();
		for (int i = 0; i < listeners.length; i++) {
			((IContainerManagerListener) listeners[i])
				.containerCreated(new ContainerEvent(c, fContainerManagerID));
		}
	}

	protected void fireContainerRemoved(Container c) {
		Object[] listeners = getListeners();
		for (int i = 0; i < listeners.length; i++) {
			((IContainerManagerListener) listeners[i])
				.containerRemoved(new ContainerEvent(c, fContainerManagerID));
		}
	}
	
	public void fireContainerSelected(Container c) {
		Object[] listeners = getListeners();
		for (int i = 0; i < listeners.length; i++) {
			((IContainerManagerListener) listeners[i])
				.containerSelected(new ContainerEvent(c, fContainerManagerID));
		}
	}
	
	protected void fireContainerLostSelection(Container c) {
		Object[] listeners = getListeners();
		for (int i = 0; i < listeners.length; i++) {
			((IContainerManagerListener) listeners[i])
				.containerLostSelection(new ContainerEvent(c, fContainerManagerID));
		}
	}
	
	protected void fireContainerActivated(Container c) {
		Object[] listeners = getListeners();
		for (int i = 0; i < listeners.length; i++) {
			((IContainerManagerListener) listeners[i])
				.containerActivated(new ContainerEvent(c, fContainerManagerID));
		}
	}

	protected void fireDebugNotification() {
		Object[] listeners = getListeners();
		for (int i = 0; i < listeners.length; i++) {
			((IContainerManagerListener) listeners[i])
				.debugNotification(new ContainerEvent(null, fContainerManagerID));
		}
	}
	
}
