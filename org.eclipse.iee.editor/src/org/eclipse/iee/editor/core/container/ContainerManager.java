package org.eclipse.iee.editor.core.container;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;

import org.antlr.v4.runtime.misc.Nullable;
import org.eclipse.core.commands.common.EventManager;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.iee.core.document.DocumentPart;
import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.core.document.parser.DocumentStructureConfig;
import org.eclipse.iee.core.document.parser.IDocumentParser;
import org.eclipse.iee.core.document.writer.IDocumentWriter;
import org.eclipse.iee.editor.core.container.partitioning.PartitioningManager;
import org.eclipse.iee.editor.core.pad.IPadFactoryManager;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.common.text.AbstractTextEditor;
import org.eclipse.iee.editor.core.pad.common.text.ICompositeTextPart;
import org.eclipse.iee.editor.core.pad.common.text.IContentTextPart;
import org.eclipse.iee.editor.core.pad.common.text.ITextPart;
import org.eclipse.iee.editor.core.pad.common.text.TextLocation;
import org.eclipse.iee.editor.core.utils.runtime.file.FileMessager;
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
import org.eclipse.jface.text.ITextInputListener;
import org.eclipse.jface.text.ITextViewerExtension2;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.collect.Maps;

public class ContainerManager extends EventManager implements IPostSelectionProvider {

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

	private final Map<String, Pad<?>> fPads = new TreeMap<String, Pad<?>>();
	
	private IPadFactoryManager fPadFactoryManager;

	private Listener fMouseListener;
	
	private List<ISelectionChangedListener> fSelectionChangedListeners;
	
	private List<ISelectionChangedListener> fPostSelectionChangedListeners;
	
	private ITextEditor<?> fSelectedEditor;

	private ITextEditor<?> fActiveEditor;
	
	private IFigure fMainFigure;

	private IFigure fFeedbackFigure;
	
	private Map<IFigure, ITextEditor<?>> fFigureToEditor = Maps.newHashMap();
	
	private TextLocation fCursorPositon;
	
	public Pad<?> getPadById(String id) {
		return fPads.get(id);
	}

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

	public ContainerManager(IPadFactoryManager padFactoryManager, IDocumentParser parser, IDocumentWriter writer, ISourceViewer sourceViewer) {
		fContainerManagerID = UUID.randomUUID().toString();

		fPadFactoryManager = padFactoryManager;
		fParser = parser;
		fWriter = writer;
		fStyledText = sourceViewer.getTextWidget();
		fSourceViewer = sourceViewer;

		LightweightSystem lightweightSystem = new LightweightSystem(fStyledText);
		lightweightSystem.getRootFigure().setOpaque(false);
		Figure stack = new Figure();
		stack.setLayoutManager(new StackLayout());
		lightweightSystem.setContents(stack);
		
		fMainFigure = new Figure();
		fMainFigure.setLayoutManager(new XYLayout());
		fMainFigure.setOpaque(false);
		stack.add(fMainFigure);
		
		fFeedbackFigure = new Figure();
		fFeedbackFigure.setLayoutManager(new XYLayout());
		fFeedbackFigure.setOpaque(false);
		fFeedbackFigure.setEnabled(false);
		stack.add(fFeedbackFigure);		
		
		fContainers = new TreeSet<Container>(fContainerComparator);

		fStyledTextManager = new StyledTextManager(this);
		fUserInteractionManager = new UserInteractionManager(this);
		fDocumentAccess = new DocumentAccess(this);

		initViewer(sourceViewer);
		
	}
	
	private void initViewer(ISourceViewer sourceViewer) {
		fMouseListener = new Listener() {
			@Override
			public void handleEvent(Event event) {
				if (event.type == SWT.MouseDown) {
					if (!(event.widget instanceof Control))
	                {
	                    return;
	                }

	                boolean isOurChild = false;
	                Control control = (Control) event.widget;
	                while (control != null) {
	                	if (control == fStyledText)
	                	{
	                		isOurChild = true;
	                		break;
	                	}
	                	control = control.getParent();
	                }
	                
	                Point displayPoint = ((Control) event.widget).toDisplay(event.x, event.y);
	                Point styledTextPoint = fStyledText.toControl(displayPoint);
					if (isOurChild) {
						Optional<ITextEditor<?>> c = getEditorAt(styledTextPoint.x, styledTextPoint.y);
						
						c = getSelectableEditor(c);
						
						if (c.isPresent()) {
							select(c.get());
							activateEditor(c.get());
						} else {
							select(null);
							activateEditor(null);
						}
						
						Optional<ITextEditor<?>> editor = getEditorAt(styledTextPoint.x, styledTextPoint.y);
						if (editor.isPresent()) {
							TextLocation textLocation = editor.get().getTextLocation(styledTextPoint.x, styledTextPoint.y);
							fCursorPositon = textLocation;
							editor.get().acceptCaret(getCaret(), textLocation);
						} else {
							fCursorPositon = null;
						}
					}
				}
			}

			private Optional<ITextEditor<?>> getSelectableEditor(
					Optional<ITextEditor<?>> c) {
				while (c.isPresent() && !c.get().isSelectable()) {
					c = c.get().getParent();
				}
				return c;
			}
		};
		fStyledText.getDisplay().addFilter(SWT.MouseDown, fMouseListener);
		fStyledText.addDisposeListener(
				new DisposeListener() {
					public void widgetDisposed(DisposeEvent e) {
						dispose();
					}
				}
			);
		sourceViewer.addTextInputListener(new ITextInputListener() {
			
			@Override
			public void inputDocumentChanged(IDocument oldInput, IDocument newInput) {
				setDocument(newInput);
			}
			
			@Override
			public void inputDocumentAboutToBeChanged(IDocument oldInput, IDocument newInput) {
			}
		});
		fStyledText.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				activateEditor(null);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		
	}
	
	public Caret getCaret() {
		Canvas canvas = fStyledText;
		Caret caret = canvas.getCaret();
		if (caret == null) {
			caret = new Caret(canvas, 0);
		}
		return caret;
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
		fStyledText.getDisplay().removeFilter(SWT.MouseDown, fMouseListener);
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
		Container container = createContainer(new Position(offset, 4), part);
		ignoreDocumentChanges = true;
	    try {
	    	container = fDocumentAccess.createContent(container);
	    } finally {
	    	ignoreDocumentChanges = false;
	    }
	    fContainers.add(container);
		containerCreated(container);
		final Pad<?> pad = container.getPad();
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				activateEditor(pad);
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

	protected Container createContainer(Position position, PadDocumentPart part) {
		try {
			fDocument.addPosition(position);
		} catch (BadLocationException e) {
			throw Throwables.propagate(e);
		}
		Container container = new Container(position, this, part, createPad(part));
		return container;
	}

	protected Container getContainerHavingOffset(int offset) {
		Preconditions.checkArgument(offset >= 0);
		for (Container container : getContainers()) {
			if (container.getPosition().includes(offset)) {
				return container;
			}
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
					containerCreated(container);
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

				// XXX
				// padsPositionsCalculationSW.stop();
			}
			logger.debug("documentChanged end ");
		}

		private void onChangesInsidePad(Container container, DocumentEvent event)
				throws BadLocationException, BadPartitioningException {
		}

		@Override
		public void documentPartitioningChanged(IDocument document) {
		}

		@Override
		public void documentAboutToBeChanged(DocumentEvent event) {

			if (event.getLength() > 0) {
				/* Remove all elements within changed area */

				int from = event.getOffset();
				int to = from + event.getLength();

				for (Iterator<Container> iterator = fContainers.iterator(); iterator.hasNext();) {
					Container container = iterator.next();
					Position position = container.getPosition();
					int cStart = position.getOffset();
					int cEnd = position.getOffset() + position.getLength();
					if (to >= cStart && from <= cEnd) {
						container.dispose();
						String containerID = container.getContainerID();
						clearPadSetsAndRuntime(containerID);
						fPads.remove(containerID);
						iterator.remove();
					}
				}
			}
		}
	}
	
	protected void containerCreated(Container c) {
		String containerID = c.getContainerID();
		PadDocumentPart padPart = c.getPadPart();
		if (containerID == null || fPads.containsKey(containerID)) {
			containerID = UUID.randomUUID().toString();
			padPart.setId(containerID);
		}
		fPads.put(containerID, c.getPad());
	}

	private Pad<PadDocumentPart> createPad(PadDocumentPart padPart) {
		Pad<PadDocumentPart> pad = fPadFactoryManager.createPad(padPart);
		return pad;
	}

	private Container parseContainer(Position position, String content) {
		PadDocumentPart part = fParser.parsePadPart(content);
		Container container = createContainer(position, part);
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
			container = parseContainer(
					new Position(region.getOffset(),
							region.getLength()), containerID);
		container.setVisible(false);
		return container;
	}

	private Container getContainerAtPoint(int x, int y) {
		for(Container container : getContainers()) {
			if (container.getBounds().contains(x, y)) {
				return container;
			}
		}
		return null;
	}

	private Container getContainerAtPoint(Point styledTextPoint) {
		for(Container container : getContainers()) {
			if (container.getBounds().contains(styledTextPoint)) {
				return container;
			}
		}
		return null;
	}

	private void clearPadSetsAndRuntime(String containerID) {
		Pad<?> pad = fPads.get(containerID);

		String runtimePath = pad.getContainer().getContainerManager()
				.getStoragePath()
				+ FileMessager.getInstance().getRuntimeDirectoryName()
				+ "/"
				+ containerID;

		File runtimeFile = new File(runtimePath);
		if (runtimeFile.exists()) {
			runtimeFile.delete();
		}
		pad.detachContainer();
	}
	
	public void savePads() {
		String[] containerIDs = getContainerIDs();
		for (String containerID : containerIDs) {
			Pad<?> pad = fPads.get(containerID);
			if (pad != null) {
				pad.save();
			} else {
				logger.error("Failed to find pad with id = {}", containerID);
			}
		}
	}
	
	public List<Pad<?>> selectPadsByType(String type) {
		List<Pad<?>> result = new ArrayList<Pad<?>>();
		for(Pad<?> pad : fPads.values()) {
			if (pad.getType().equals(type)) {
				result.add(pad);
			}
		}
		return result;
	}
	
	public void select(@Nullable ITextEditor<?> c) {
		selectEditor(c);
		if (c != null) {
			SelectionChangedEvent event = new SelectionChangedEvent(this, new StructuredSelection(c.getModel()));
			fireSelectionChanged(event);
			firePostSelectionChanged(event);
		}
	}
	
	@Override
	public void setSelection(ISelection selection) {
		if (!(selection instanceof IStructuredSelection)) {
			if (fSourceViewer instanceof ISelectionProvider) {
				((ISelectionProvider) fSourceViewer).setSelection(selection);
			}
		}
		Object selected = ((IStructuredSelection) selection).getFirstElement();
		if (selected instanceof ITextEditor) {
			select((ITextEditor<?>) selected);
		}
	}
	
	@Override
	public void addPostSelectionChangedListener(ISelectionChangedListener listener) {
		if (fSourceViewer instanceof IPostSelectionProvider) {
			((IPostSelectionProvider) fSourceViewer).addPostSelectionChangedListener(listener);
		}
		if (fPostSelectionChangedListeners == null) {
			fPostSelectionChangedListeners = new ArrayList<>();
		}
		if (!fPostSelectionChangedListeners.contains(listener)) {
			fPostSelectionChangedListeners.add(listener);
		}
	}
	
	@Override
	public void removePostSelectionChangedListener(ISelectionChangedListener listener) {
		if (fSourceViewer instanceof IPostSelectionProvider) {
			((IPostSelectionProvider) fSourceViewer).removePostSelectionChangedListener(listener);
		}
		if (fPostSelectionChangedListeners != null)  {
			fPostSelectionChangedListeners.remove(listener);
			if (fPostSelectionChangedListeners.size() == 0) {
				fPostSelectionChangedListeners=  null;
			}
		}
	}

	private void fireSelectionChanged(SelectionChangedEvent event) {
		List<ISelectionChangedListener> listeners = fSelectionChangedListeners;
		if (listeners != null) {
			listeners = new ArrayList<>(listeners);
			for (int i = 0; i < listeners.size(); i++) {
				ISelectionChangedListener l= (ISelectionChangedListener) listeners.get(i);
				l.selectionChanged(event);
			}
		}
	}
	
	private void firePostSelectionChanged(SelectionChangedEvent event) {
		List<ISelectionChangedListener> listeners = fPostSelectionChangedListeners;
		if (listeners != null) {
			listeners = new ArrayList<>(listeners);
			for (int i = 0; i < listeners.size(); i++) {
				ISelectionChangedListener l= (ISelectionChangedListener) listeners.get(i);
				l.selectionChanged(event);
			}
		}
	}

	@Override
	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		if (fSourceViewer instanceof ISelectionProvider) {
			((ISelectionProvider) fSourceViewer).addSelectionChangedListener(listener);
		}
		if (fSelectionChangedListeners == null) {
			fSelectionChangedListeners = new ArrayList<>();
		}
		if (!fSelectionChangedListeners.contains(listener)) {
			fSelectionChangedListeners.add(listener);
		}
	}

	@Override
	public ISelection getSelection() {
		if (fSourceViewer instanceof ISelectionProvider) {
			return ((ISelectionProvider) fSourceViewer).getSelection();
		}
		return null;
	}

	@Override
	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		if (fSourceViewer instanceof ISelectionProvider) {
			((ISelectionProvider) fSourceViewer).removeSelectionChangedListener(listener);
		}
		if (fPostSelectionChangedListeners != null)  {
			fPostSelectionChangedListeners.remove(listener);
			if (fPostSelectionChangedListeners.size() == 0) {
				fPostSelectionChangedListeners=  null;
			}
		}
	}
	
	public void selectEditor(ITextEditor<?> editor) {
		if (editor != null && editor.equals(fSelectedEditor)) {
			return;
		}
		
		if (fSelectedEditor != null) {
			fSelectedEditor.setSelected(false);
		}
		fSelectedEditor = editor;
		if (fSelectedEditor != null) {
			fSelectedEditor.setSelected(true);
		}
	}

	public void activateEditor(@Nullable ITextEditor<?> editor) {
		if (editor != null && editor.equals(fActiveEditor)) {
			return;
		}
		if (fActiveEditor != null) {
			fActiveEditor.setActive(false);
		}
		fActiveEditor = editor;
		if (fActiveEditor != null) {
			fActiveEditor.setActive(true);
		}
		selectEditor(editor);
	}

	public void deactivateEditor(ITextEditor<?> container) {
		activateEditor(null);
		fSourceViewer.getTextWidget().forceFocus();
	}

	public IFigure getMainFigure() {
		return fMainFigure;
	}

	public IFigure getFeedbackFigure() {
		return fFeedbackFigure;
	}

	public void registerVisual(ITextEditor<?> textPartEditor, IFigure figure) {
		fFigureToEditor.put(figure, textPartEditor);
	}

	public TextLocation getCursonPosition() {
		return fCursorPositon;
	}

	public boolean isMirrored() {
		//TODO rtl?
		return false;
	}

	public void setCursorPosition(TextLocation textLocation) {
		fCursorPositon = textLocation;
		IContentTextPart textPart = textLocation.getTextPart();
		int position = textLocation.getPosition();
		textPart.updateCaret(getCaret(), position, position == textPart.getLength());
	}

	public Optional<ITextEditor<?>> getEditorAt(int x, int y) {
		IFigure findFigureAt = fMainFigure.findFigureAt(x, y);
		ITextEditor<?> editor = null;
		while (findFigureAt != null) {
			editor = fFigureToEditor.get(findFigureAt);
			if (editor != null) {
				break;
			}
			findFigureAt = findFigureAt.getParent();
		}
		if (editor == null) {
			Container containerAtPoint = getContainerAtPoint(x, y);
			if (containerAtPoint != null) {
				editor = containerAtPoint.getPad();
			}
		}
		
		return Optional.<ITextEditor<?>> fromNullable(editor);
	}

	public ICompositeTextPart getRootTextPart() {
		return new ICompositeTextPart() {
			
			@Override
			public TextLocation getStart() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Optional<ICompositeTextPart> getParentTextPart() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public TextLocation getEnd() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Optional<ITextPart> getPrevious(ITextPart textPart) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Optional<ITextPart> getNext(ITextPart textPart) {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

	public void addTextPart(ITextPart tablePad) {
		
		
	}

	public Optional<ITextEditor<?>> getRootTextEditor() {
		return Optional.<ITextEditor<?>>of (new AbstractTextEditor<DocumentPart>(null) {

			@Override
			public TextLocation getTextLocation(int x, int y) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void acceptCaret(Caret caret, TextLocation textLocation) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean isSelectable() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void setSelected(boolean b) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void setActive(boolean b) {
				// TODO Auto-generated method stub
				
			}});
	}

	public void deactivate() {
		activateEditor(null);
	}

	
}
