package org.eclipse.iee.editor.core.container;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.UUID;

import org.eclipse.core.commands.common.EventManager;
import org.eclipse.core.runtime.Assert;
import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.core.document.parser.DocumentStructureConfig;
import org.eclipse.iee.core.document.parser.IDocumentParser;
import org.eclipse.iee.core.document.writer.IDocumentWriter;
import org.eclipse.iee.editor.core.container.event.ContainerEvent;
import org.eclipse.iee.editor.core.container.event.IContainerManagerListener;
import org.eclipse.iee.editor.core.container.partitioning.PartitioningManager;
import org.eclipse.jdt.core.ICompilationUnit;
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
import org.eclipse.jface.text.ITextViewerExtension2;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Throwables;

public class ContainerManager extends EventManager {

	private static final Logger logger = LoggerFactory
			.getLogger(ContainerManager.class);

	private final String fContainerManagerID;

	private final IDocumentParser fParser;
	
	private final IDocumentWriter fWriter;

	private final DocumentAccess fDocumentAccess;

	private final StyledTextManager fStyledTextManager;

	private final UserInteractionManager fUserInteractionManager;

	private PartitioningManager fPartitioningManager;

	private final ISourceViewer fSourceViewer;

	private final StyledText fStyledText;

	private IDocument fDocument;

	private DocumentListener fDocumentListener;

	private ICompilationUnit fCompilationUnit;

	private String fStoragePath;

	private final NavigableSet<Container> fContainers;

	private static ContainerComparator fContainerComparator = new ContainerComparator();

	private boolean ignoreDocumentChanges;

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
		return fContainers.subSet(Container.atOffset(from), true,
				Container.atOffset(to), true);
	}

	public String getContainerManagerID() {
		return fContainerManagerID;
	}

	public IDocumentWriter getWriter() {
		return fWriter;
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

	public ICompilationUnit getCompilationUnit() {
		return fCompilationUnit;
	}

	public void setCompilationUnit(ICompilationUnit compilationUnit) {
		this.fCompilationUnit = compilationUnit;
	}

	/* INTERFACE FUNCTIONS */

	public ContainerManager(IDocumentParser parser, IDocumentWriter writer, ISourceViewer sourceViewer, StyledText styledText) {
		fContainerManagerID = UUID.randomUUID().toString();

		fParser = parser;
		fWriter = writer;
		fStyledText = styledText;
		fSourceViewer = sourceViewer;

		fContainers = new TreeSet<Container>(fContainerComparator);

		fStyledTextManager = new StyledTextManager(this);
		fUserInteractionManager = new UserInteractionManager(this);
		fDocumentAccess = new DocumentAccess(this);

	}
	
	public void setDocument(IDocument document) {
		fContainers.clear();
		if (fDocument != null) {
			removeDocumentListener(fDocument);
		}
		if (fPartitioningManager != null) {
			fPartitioningManager.dispose();
		}
		fDocument = document;
		if (document != null) {
			initDocumentListener();
			fPartitioningManager = new PartitioningManager(new DocumentStructureConfig(), fDocument);
			List<Container> containers = parseContainersFromDocumentRegion(document, new Region(0, fDocument.getLength()));
			for (Container container : containers) {
				fContainers.add(container);
			}
		}
	}

	public void dispose() {
		setDocument(null);
	}

	public Container createContainer(PadDocumentPart part, int offset) {
		if (part.getId() == null) {
			part.setId(UUID.randomUUID().toString());
		}
		try {
			fDocument.replace(offset, 0, "/**/");
		} catch (BadLocationException e) {
			throw Throwables.propagate(e);
		}
		Container container = createContainer(new Position(offset, 4));
		container.setPadPart(part);
		ignoreDocumentChanges = true;
	    try {
	    	container = fDocumentAccess.createContent(container);
	    } finally {
	    	ignoreDocumentChanges = false;
	    }
	    fContainers.add(container);
		fireContainerCreated(container);
		final Container ic = container;
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				getUserInteractionManager().activateContainer(ic);
			}
		});
	    return container; 
	}

	public boolean isModificationAllowed() {
		return true;
	}

	public void updateContainerPresentations(Container container) {
		if (isModificationAllowed()) {
			((ITextViewerExtension2)fSourceViewer).invalidateTextPresentation(container.getPosition().getOffset(), container.getPosition().getLength());
		}
	}

	/* Internal functions */

	protected void initDocumentListener() {
		fDocumentListener = new DocumentListener();
		fDocument.addDocumentPartitioningListener(fDocumentListener);
		fDocument.addDocumentListener(fDocumentListener);
	}

	protected void removeDocumentListener(IDocument document) {
		document.removeDocumentPartitioningListener(fDocumentListener);
		document.removeDocumentListener(fDocumentListener);
	}

	protected Container createContainer(Position position) {
		try {
			fDocument.addPosition(position);
		} catch (BadLocationException e) {
			throw Throwables.propagate(e);
		}
		return new Container(position, this);
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

		public DocumentListener() {
		}

		@Override
		public void documentPartitioningChanged(
				DocumentPartitioningChangedEvent event) {
			if (ignoreDocumentChanges) {
				return;
			}
			IRegion changedRegion = event.getChangedRegion(PartitioningManager.PARTITIONING_ID);
			if (changedRegion!= null) { 
				List<Container> containers = parseContainersFromDocumentRegion(fDocument, changedRegion);
				for (Container container : containers) {
					fContainers.add(container);
					fireContainerCreated(container);
				}
			}
		}

		@Override
		public void documentChanged(DocumentEvent event) {
			logger.debug("documentChanged start " + event);

			try {
				Container current = getContainerHavingOffset(event
						.getOffset());
				if (current != null) {

					/*
					 * Changed text area is inside current pad's
					 * area, updating it
					 */
					onChangesInsidePad(current, event);
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

			if (!fDocumentAccess.hasNextDocumentAccessRequest()) {

				/* XXX Visibility */
				// updateContainerVisibility(true);

				fUserInteractionManager.updateCaretSelection();

				logger.debug("== End of document modification handling ==\n\n");

				/* For debug */
				fireDebugNotification();

				// XXX
				// padsPositionsCalculationSW.stop();
			}
			logger.debug("documentChanged end ");
		}

		private void onChangesInsidePad(Container container, DocumentEvent event)
				throws BadLocationException, BadPartitioningException {
			fireContainerUpdated(container);
		}

		@Override
		public void documentPartitioningChanged(IDocument document) {
		}

		@Override
		public void documentAboutToBeChanged(DocumentEvent event) {

			if (event.getLength() > 0) {
				/* Remove all elements within changed area */

				Container from = fContainers.ceiling(Container.atOffset(event
						.getOffset()));
				Container to = fContainers.lower(Container.atOffset(event
						.getOffset() + event.getLength()));

				if (from != null && to != null
						&& fContainerComparator.isNotDescending(from, to)) {
					NavigableSet<Container> removeSet = fContainers.subSet(
							from, true, to, true);
					if (removeSet != null) {
						Container container;
						while ((container = removeSet.pollFirst()) != null) {

							/* Removing container */

							container.dispose();
							fireContainerRemoved(container);
						}
					}
				}
			}
		}
	}

	/* FUNCTIONS FOR OBSERVERS */

	public void addContainerManagerListener(IContainerManagerListener listener) {
		Assert.isNotNull(listener);
		addListenerObject(listener);
	}

	public void removeContainerManagerListener(
			IContainerManagerListener listener) {
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

	protected void fireContainerUpdated(Container c) {
		Object[] listeners = getListeners();
		for (int i = 0; i < listeners.length; i++) {
			((IContainerManagerListener) listeners[i])
					.containerUpdated(new ContainerEvent(c, fContainerManagerID));
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
					.containerSelected(new ContainerEvent(c,
							fContainerManagerID));
		}
	}

	protected void fireContainerLostSelection(Container c) {
		Object[] listeners = getListeners();
		for (int i = 0; i < listeners.length; i++) {
			((IContainerManagerListener) listeners[i])
					.containerLostSelection(new ContainerEvent(c,
							fContainerManagerID));
		}
	}

	protected void fireContainerActivated(Container c) {
		Object[] listeners = getListeners();
		for (int i = 0; i < listeners.length; i++) {
			((IContainerManagerListener) listeners[i])
					.containerActivated(new ContainerEvent(c,
							fContainerManagerID));
		}
	}

	public void fireContainerDeactivated(Container c) {
		Object[] listeners = getListeners();
		for (int i = 0; i < listeners.length; i++) {
			((IContainerManagerListener) listeners[i])
					.containerDeactivated(new ContainerEvent(c,
							fContainerManagerID));
		}
	}

	protected void fireDebugNotification() {
		Object[] listeners = getListeners();
		for (int i = 0; i < listeners.length; i++) {
			((IContainerManagerListener) listeners[i])
					.debugNotification(new ContainerEvent(null,
							fContainerManagerID));
		}
	}

	private Container parseContainer(Position position, String content) {
		PadDocumentPart part = fParser.parsePadPart(content);
		Container container = createContainer(position);
		container.setPadPart(part);
		return container;
	}

	public String getStoragePath() {
		return fStoragePath;
	}

	public void setStoragePath(String storagePath) {
		this.fStoragePath = storagePath;
	}
	
	private List<Container> parseContainersFromDocumentRegion(IDocument document, IRegion region) {
		try {
			ITypedRegion[] regions;
			regions = ((IDocumentExtension3) document)
					.computePartitioning(PartitioningManager.PARTITIONING_ID, region.getOffset(), region.getLength(), false);
			List<Container> result = new ArrayList<>();
			for (ITypedRegion typedRegion : regions) {
				if (typedRegion.getType().equals(
						PartitioningManager.CONTENT_TYPE_EMBEDDED)) {
					result.add(parseContainerFromDocumentRegion(document, typedRegion));
				}
			}
			return result;
		} catch (BadLocationException | BadPartitioningException e) {
			throw Throwables.propagate(e);
		}
	}
	
	private Container parseContainerFromDocumentRegion(IDocument document, IRegion region)
			throws BadLocationException {
		Container container;
		String containerTextRegion = document.get(
				region.getOffset(), region.getLength());

		/* Adding container */
		String containerID = fDocumentAccess
				.getContainerIDFromTextRegion(containerTextRegion);

		if (containerID.matches("\\w*-\\w*-\\w*-\\w*-\\w*")) {
			// old style
			container = createContainer(
					new Position(region.getOffset(),
							region.getLength()));
		} else {
			// new style
			container = parseContainer(
					new Position(region.getOffset(),
							region.getLength()), containerID);
		}

		/* XXX Visibility */
		container.setVisible(false);
		return container;
	}

	public Container getContainerAtPoint(int x, int y) {
		for(Container container : getContainers()) {
			if (container.getComposite().getBounds().contains(x, y)) {
				return container;
			}
		}
		return null;
	}

	public Container getContainerAtPoint(Point styledTextPoint) {
		for(Container container : getContainers()) {
			if (container.getComposite().getBounds().contains(styledTextPoint)) {
				return container;
			}
		}
		return null;
	}

}
