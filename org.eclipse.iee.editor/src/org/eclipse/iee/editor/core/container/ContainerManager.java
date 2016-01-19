package org.eclipse.iee.editor.core.container;

import java.io.File;
import java.lang.reflect.Field;
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
import org.eclipse.draw2d.AbstractHintLayout;
import org.eclipse.draw2d.AncestorListener;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Translatable;
import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.core.document.parser.DocumentStructureConfig;
import org.eclipse.iee.core.document.parser.IDocumentParser;
import org.eclipse.iee.core.document.text.TextStyle;
import org.eclipse.iee.core.document.writer.IDocumentWriter;
import org.eclipse.iee.editor.core.container.partitioning.PartitioningManager;
import org.eclipse.iee.editor.core.pad.IPadFactoryManager;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.common.text.IEditorLocation;
import org.eclipse.iee.editor.core.pad.common.ui.SelectionModel;
import org.eclipse.iee.editor.core.utils.runtime.file.FileMessager;
import org.eclipse.iee.translator.antlr.java.JavaParser.CompilationUnitContext;
import org.eclipse.iee.translator.antlr.translator.JavaTranslator;
import org.eclipse.jdt.core.BufferChangedEvent;
import org.eclipse.jdt.core.IBufferChangedListener;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.ui.SharedASTProvider;
import org.eclipse.jdt.ui.SharedASTProvider.WAIT_FLAG;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
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
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewerExtension2;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.IElementComparer;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.SharedImages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;

public class ContainerManager extends EventManager implements IPostSelectionProvider, ICursorManager {

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

	private final Map<String, Pad<?, ?>> fPads = new TreeMap<>();
	
	private IPadFactoryManager fPadFactoryManager;

	private Listener fMouseListener;
	
	private List<ISelectionChangedListener> fSelectionChangedListeners;
	
	private List<ISelectionChangedListener> fPostSelectionChangedListeners;
	
	private Optional<IEditorLocation> fCursorPositon = Optional.absent();
	
	private SelectionModel fSelectionModel; 

	private Field fVerticalScrollOffsetField;

	private Field fHorizontalScrollOffsetField;

	private EditorManager fEditorManager;
	
	private TextRenderCtx fRenderCtx;

	private IShellProvider fShellProvider;

	private AncestorListener fAncestorListener;
	
	private Runnable fCaretTask;
	
	private CompilationUnitContext fCompilationUnitContext;

	private IBufferChangedListener fBufferChangeListener;
	
	private IASTProvider fAstProvider;
	
	public Pad<?, ?> getPadById(String id) {
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

	public CompilationUnit getCompilationUnit() {
		return fAstProvider.getAst(fCompilationUnit);
	}

	public void setCompilationUnit(ICompilationUnit compilationUnit) {
		if (fCompilationUnit != null) {
			try {
				fCompilationUnit.getBuffer().removeBufferChangedListener(fBufferChangeListener);
			} catch (JavaModelException e) {
				Throwables.propagate(e);
			}
		}
		this.fCompilationUnit = compilationUnit;
		if (compilationUnit != null) {
			try {
				compilationUnit.getBuffer().addBufferChangedListener(fBufferChangeListener);
			} catch (JavaModelException e) {
				Throwables.propagate(e);
			}
		}
	}

	/* INTERFACE FUNCTIONS */

	public ContainerManager(IPadFactoryManager padFactoryManager, IDocumentParser parser, IDocumentWriter writer, ISourceViewer sourceViewer, IShellProvider shellProvider) {
		fShellProvider = shellProvider;
		fContainerManagerID = UUID.randomUUID().toString();

		fPadFactoryManager = padFactoryManager;
		fParser = parser;
		fWriter = writer;
		fStyledText = sourceViewer.getTextWidget();
		fSourceViewer = sourceViewer;

		
		LightweightSystem lightweightSystem = new LightweightSystem(fStyledText);
		lightweightSystem.getRootFigure().setOpaque(false);
		final Viewport viewport = new Viewport();
		
		viewport.setLayoutManager(new AbstractHintLayout() {
			
			protected Dimension calculateMinimumSize(IFigure figure, int wHint,
					int hHint) {
				Dimension min = new Dimension();
				Insets insets = figure.getInsets();
				return min.getExpanded(insets.getWidth(), insets.getHeight());
			}
			
			@Override
			public void layout(IFigure container) {
				IFigure contents = (IFigure) container.getChildren().get(0);

				if (contents == null)
					return;
				org.eclipse.draw2d.geometry.Point p = container.getClientArea().getLocation();

				p.translate(getViewLocation().getNegated());

				// Calculate the hints
				Rectangle hints = container.getClientArea();
				int wHint = hints.width;
				int hHint = hints.height;

				Dimension newSize = container.getClientArea().getSize();
				Dimension min = contents.getMinimumSize(wHint, hHint);
				Dimension pref = contents.getPreferredSize(wHint, hHint);

				newSize.height = Math.max(newSize.height, pref.height);
				newSize.width = Math.max(newSize.width, pref.width);

				contents.setBounds(new Rectangle(p, newSize));
			}
			
			@Override
			protected Dimension calculatePreferredSize(IFigure container, int wHint,
					int hHint) {
				Insets insets = container.getInsets();
				IFigure contents = (IFigure) container.getChildren().get(0);
				wHint = -1;
				hHint = -1;
				if (contents == null) {
					return new Dimension(insets.getWidth(), insets.getHeight());
				} else {
					Dimension minSize = contents.getMinimumSize(wHint, hHint);
					if (wHint > -1)
						wHint = Math.max(wHint, minSize.width);
					if (hHint > -1)
						hHint = Math.max(hHint, minSize.height);
					return contents.getPreferredSize(wHint, hHint).getExpanded(
							insets.getWidth(), insets.getHeight());
				}
			}
			
		});	
		
		fEditorManager = new EditorManager();
		viewport.add(fEditorManager.getRoot());
		lightweightSystem.setContents(viewport);
		
		fSelectionModel = new SelectionModel(fEditorManager, this);
		
		fContainers = new TreeSet<Container>(fContainerComparator);

		fStyledTextManager = new StyledTextManager(this);
		fUserInteractionManager = new UserInteractionManager(this);
		fDocumentAccess = new DocumentAccess(this);

		TextStyle defaultStyle = new TextStyle();
		FontData fontData = sourceViewer.getTextWidget().getFont().getFontData()[0];
		defaultStyle.setFont(fontData.getName());
		defaultStyle.setFontSize(fontData.getHeight());
		fRenderCtx = new TextRenderCtx(defaultStyle, new LocalResourceManager(JFaceResources.getResources()));
		
		initViewer(sourceViewer);
		
		try {
			fVerticalScrollOffsetField = StyledText.class.getDeclaredField("verticalScrollOffset");
			fVerticalScrollOffsetField.setAccessible(true);
			fHorizontalScrollOffsetField = StyledText.class.getDeclaredField("horizontalScrollOffset");
			fHorizontalScrollOffsetField.setAccessible(true);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException e1) {
			throw Throwables.propagate(e1);
		}
		
		fAncestorListener = new AncestorListener.Stub()  {
			@Override
			public void ancestorMoved(IFigure source) {
				if (fCursorPositon.isPresent()) {
					putCursor(fCursorPositon.get());
				}
			}
		};
		
		fBufferChangeListener = new IBufferChangedListener() {
			@Override
			public void bufferChanged(BufferChangedEvent event) {
				fCompilationUnitContext = null;
			}
		};
		
		fAstProvider = new IASTProvider() {
			
			@Override
			public CompilationUnit getAst(ICompilationUnit compilationUnit) {
				return SharedASTProvider.getAST(compilationUnit, SharedASTProvider.WAIT_YES, null);
			}
		};
		
	}
	
	public org.eclipse.draw2d.geometry.Point getViewLocation() {
		try {
			Integer verticalScrollOffset = (Integer) fVerticalScrollOffsetField.get(fStyledText);
			Integer horizontalScrollOffset = (Integer) fHorizontalScrollOffsetField.get(fStyledText);
			return new org.eclipse.draw2d.geometry.Point(horizontalScrollOffset, verticalScrollOffset);
		} catch (SecurityException | IllegalArgumentException | IllegalAccessException e1) {
			throw Throwables.propagate(e1);
		}
	}
	
	private void initViewer(ISourceViewer sourceViewer) {
		fMouseListener = new Listener() {
			@Override
			public void handleEvent(Event event) {
				if (event.type == SWT.MouseDown && event.button == 1) {
					if (!(event.widget instanceof Control))
	                {
	                    return;
	                }

	                if (isEventFromChild(event)) {
						Point displayPoint = ((Control) event.widget).toDisplay(event.x, event.y);
						Point styledTextPoint = fStyledText.toControl(displayPoint);
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
							IView view = editor.get().getView();
							
							IFigure wrapped = view.getWrapped(IFigure.class);
							org.eclipse.draw2d.geometry.Point t = new org.eclipse.draw2d.geometry.Point(styledTextPoint.x, styledTextPoint.y);
							wrapped.translateToRelative(t);
							
							Optional<IEditorLocation> textLocation = editor.get().getTextLocation(t.x, t.y);
							if (textLocation.isPresent()) {
								setCursorPosition(textLocation.get());
							}
						} else {
							setCursorPosition(null);
						}
					}
				}
			}

			private boolean isEventFromChild(Event event) {
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
				return isOurChild;
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
//			List<Container> containers = parseContainersFromDocumentRegion(document, new Region(0, fDocument.getLength()));
//			for (Container container : containers) {
//				fContainers.add(container);
//			}
		}
	}

	public void dispose() {
		fStyledText.getDisplay().removeFilter(SWT.MouseDown, fMouseListener);
		setDocument(null);
		setCompilationUnit(null);
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
		final Pad<?, ?> pad = container.getPad();
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				activateEditor(pad);
				Optional<IEditorLocation> start = pad.getStart();
				if (start.isPresent()) {
					setCursorPosition(start.get());
				}
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

	private final class Viewport extends Figure {
		@Override
		protected void paintClientArea(Graphics g) {
			org.eclipse.draw2d.geometry.Point p = getViewLocation();
			try {
				g.translate(-p.x, -p.y);
				g.pushState();
				super.paintClientArea(g);
				g.popState();
			} finally {
				g.translate(p.x, p.y);
			}
		}

		/**
		 * @see IFigure#getClientArea(Rectangle)
		 */
		public Rectangle getClientArea(Rectangle rect) {
			super.getClientArea(rect);
			rect.translate(getViewLocation());
			return rect;
		}

		/**
		 * @see IFigure#isCoordinateSystem()
		 */
		public boolean isCoordinateSystem() {
			return true;
		}

		/**
		 * @see IFigure#translateFromParent(Translatable)
		 */
		public void translateFromParent(Translatable t) {
			org.eclipse.draw2d.geometry.Point p = getViewLocation();
			t.performTranslate(p.x, p.y);
			super.translateFromParent(t);
		}

		/**
		 * @see IFigure#translateToParent(Translatable)
		 */
		public void translateToParent(Translatable t) {
			org.eclipse.draw2d.geometry.Point p = getViewLocation();
			t.performTranslate(-p.x, -p.y);
			super.translateToParent(t);
		}

		private void localRevalidate() {
			invalidate();
			if (getLayoutManager() != null) {
				getLayoutManager().invalidate();
			}
			getUpdateManager().addInvalidFigure(this);
		}
	}

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
					if (from <= cStart && to >= cEnd) {
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

	private Pad<PadDocumentPart, ?> createPad(PadDocumentPart padPart) {
		Pad<PadDocumentPart, ?> pad = fPadFactoryManager.createPad(padPart, fRenderCtx);
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
		org.eclipse.draw2d.geometry.Point p = translateViewToReal(x, y);
		
		for(Container container : getContainers()) {
			if (container.getPad().getBounds().contains(p.x, p.y)) {
				return container;
			}
		}
		return null;
	}

	private org.eclipse.draw2d.geometry.Point translateViewToReal(int x, int y) {
		org.eclipse.draw2d.geometry.Point viewLocation = getViewLocation();
		org.eclipse.draw2d.geometry.Point p = new org.eclipse.draw2d.geometry.Point(viewLocation.x + x, viewLocation.y + y);
		return p;
	}

	private void clearPadSetsAndRuntime(String containerID) {
		Pad<?, ?> pad = fPads.get(containerID);

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
			Pad<?, ?> pad = fPads.get(containerID);
			if (pad != null) {
				pad.save();
			} else {
				logger.error("Failed to find pad with id = {}", containerID);
			}
		}
	}
	
	public List<Pad<?, ?>> selectPadsByType(String type) {
		List<Pad<?, ?>> result = new ArrayList<>();
		for(Pad<?, ?> pad : fPads.values()) {
			if (pad.getType().equals(type)) {
				result.add(pad);
			}
		}
		return result;
	}
	
	public void select(@Nullable ITextEditor<?> c) {
		selectEditor(c);
		if (c != null) {
			SelectionChangedEvent event = new SelectionChangedEvent(this, new StructuredSelection(c));
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
		if (fEditorManager.isEditorSelected()) {
			return new HybridSelection(fEditorManager.getSelectedEditor());
		}
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
		if (fSelectionChangedListeners != null)  {
			fSelectionChangedListeners.remove(listener);
			if (fSelectionChangedListeners.size() == 0) {
				fSelectionChangedListeners = null;
			}
		}
	}
	
	public void selectEditor(ITextEditor<?> editor) {
		fEditorManager.selectEditor(editor);
	}

	public void activateEditor(@Nullable ITextEditor<?> editor) {
		if (editor == null) {
			fCursorPositon = Optional.absent();
		}
		fEditorManager.activateEditor(editor);
	}

	public void deactivateEditor(ITextEditor<?> container) {
		activateEditor(null);
		fSourceViewer.getTextWidget().forceFocus();
	}

	public Optional<IEditorLocation> getCursonPosition() {
		return fCursorPositon;
	}

	public boolean isMirrored() {
		//TODO rtl?
		return false;
	}

	public void setCursorPosition(IEditorLocation textLocation) {
		if (textLocation != null) {
			fSelectionModel.set(textLocation);
		}
		putCursor(textLocation);
	}
	
	@Override
	public void putCursor(IEditorLocation textLocation) {
		final Optional<IEditorLocation> oldLocation = fCursorPositon;
		fCursorPositon = Optional.fromNullable(textLocation);
		if (fCaretTask == null) {
			fCaretTask = new Runnable() {
					public void run() {
						fCaretTask = null;
						putCaretIntl(oldLocation);
					}
				};
			Display.getDefault().asyncExec(fCaretTask);
		}
	}

	private void putCaretIntl(Optional<IEditorLocation> oldLocation) {
		if (oldLocation.isPresent()) {
			IFigure wrapped = oldLocation.get().getEditor().getView().getWrapped(IFigure.class);
			wrapped.removeAncestorListener(fAncestorListener);
		}
		if (fCursorPositon.isPresent()) {
			fCursorPositon.get().putCaret(getCaret());
			IFigure wrapped = fCursorPositon.get().getEditor().getView().getWrapped(IFigure.class);
			wrapped.addAncestorListener(fAncestorListener);
		} else {
			fCursorPositon = Optional.absent();
		}
	}

	public Optional<ITextEditor<?>> getEditorAt(int x, int y) {
		Optional<ITextEditor<?>> editor = fEditorManager.getEditorAt(translateViewToReal(x, y));
		if (!editor.isPresent()) {
			Container containerAtPoint = getContainerAtPoint(x, y);
			if (containerAtPoint != null) {
				editor = Optional.<ITextEditor<?>> fromNullable(containerAtPoint.getPad());
			}
		}
		return editor;
	}

	public void deactivate() {
		activateEditor(null);
	}

	static class HybridSelection extends StructuredSelection implements ITextSelection, IStructuredSelection {

		public HybridSelection() {
			super();
		}

		public HybridSelection(List elements, IElementComparer comparer) {
			super(elements, comparer);
		}

		public HybridSelection(List elements) {
			super(elements);
		}

		public HybridSelection(Object element) {
			super(element);
		}

		public HybridSelection(Object[] elements) {
			super(elements);
		}

		@Override
		public int getOffset() {
			return getPad().getContainer().getPosition().offset;
		}

		@Override
		public int getLength() {
			return getPad().getContainer().getPosition().length;
		}

		@Override
		public int getStartLine() {
			return 0;
		}

		@Override
		public int getEndLine() {
			return 0;
		}

		@Override
		public String getText() {
			return null;
		}
		
		private Pad<?, ?> getPad() {
			Object firstElement = getFirstElement();
			if (firstElement instanceof ITextEditor) {
				ITextEditor<?> element = (ITextEditor<?>) firstElement;
				while(element.getParent().isPresent()) {
					element = element.getParent().get();
				}
				return (Pad<?, ?>) element;
			}
			return null;
		}

		
	}

	public EditorManager getEditorManager() {
		return fEditorManager;
	}
	
	public SelectionModel getSelectionModel() {
		return fSelectionModel;
	}

	public void setSelectionEnd(IEditorLocation textLocation) {
		fSelectionModel.setEnd(textLocation);
		putCursor(textLocation);
	}

	public Shell getShell() {
		return fShellProvider.getShell();
	}
	

	public CompilationUnitContext getCompilationUnitContext() {
		if (fCompilationUnitContext == null) {
			try {
				fCompilationUnitContext = new JavaTranslator(getCompilationUnit()).createTree(fCompilationUnit.getSource());
			} catch (JavaModelException e1) {
				throw Throwables.propagate(e1);
			}
		}
		return fCompilationUnitContext;
	}
	
}
