package org.eclipse.iee.editor.jdt.editors;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.iee.editor.IPadEditor;
import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.iee.editor.core.container.ContainerManagerConfig;
import org.eclipse.iee.editor.core.container.event.ContainerEvent;
import org.eclipse.iee.editor.core.container.event.IContainerManagerListener;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.PadManager;
import org.eclipse.iee.sample.formula.FormulaPadFactory;
import org.eclipse.iee.sample.image.ImagePadFactory;
import org.eclipse.iee.sample.text.TextPadFactory;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

@SuppressWarnings("restriction")
public class ExtendedJavaEditor extends CompilationUnitEditor implements
		IPadEditor {

	private static final Logger logger = Logger
			.getLogger(ExtendedJavaEditor.class);

	private ContainerManager fContainerManager;
	private IContainerManagerListener fContainerManagerListener;

	private final PadManager fPadManager = IeeEditorPlugin.getDefault()
			.getPadManager();

	public ExtendedJavaEditor() {
		super();
	}

	public void createPartControl(Composite parent) {
		super.createPartControl(parent);

		logger.debug("Create ExtendedJavaEditor");

		initIeeEditorCore();

		loadEditorPads();
	};

	public void initIeeEditorCore() {
		IDocument document = getSourceViewer().getDocument();

		ContainerManagerConfig config = new ContainerManagerConfig();

		// config.EMBEDDED_REGION_BEGIN = "/*<";
		// config.EMBEDDED_REGION_END = ">*/";
		// config.INNER_TEXT_BEGIN = "*/";
		// config.INNER_TEXT_END = "/*";

		fContainerManager = new ContainerManager(config, document,
				getSourceViewer(), getSourceViewer().getTextWidget());
		
		IEditorPart editor = (IEditorPart)this;
		IFileEditorInput input = (IFileEditorInput)editor.getEditorInput();
	    IFile file = input.getFile();
	    IProject project = file.getProject();
	    ICompilationUnit compilationUnit = JavaCore.createCompilationUnitFrom(file);
	    fContainerManager.setCompilationUnit(compilationUnit);
	    
	    IPath rawLocation = project.getRawLocation();
	    
	    String storagePath = "";
	    
	    if (rawLocation != null)
	    {
	    	storagePath = rawLocation.makeAbsolute().toString() + "/pads/";
	    }
	    else
	    {
	    	IWorkspace workspace = ResourcesPlugin.getWorkspace();  
	    	IPath workspaceDirectory = workspace.getRoot().getLocation();
	    	storagePath = workspaceDirectory.toString() + project.getFullPath().makeAbsolute().toString() + "/pads/";
	    }
	    
	    logger.debug("storagePath = " + storagePath);
	    fContainerManager.setStoragePath(storagePath);
	    
		fContainerManagerListener = new IContainerManagerListener() {
			@Override
			public void debugNotification(ContainerEvent event) {
				firePropertyChange(PROP_CONTAINER_SET);
			}

			@Override
			public void containerCreated(ContainerEvent event) {
			}

			@Override
			public void containerRemoved(ContainerEvent event) {
			}

			@Override
			public void containerSelected(ContainerEvent event) {
			}

			@Override
			public void containerLostSelection(ContainerEvent event) {
			}

			@Override
			public void containerActivated(ContainerEvent event) {
			}

			@Override
			public void containerUpdated(ContainerEvent containerEvent) {
			}
		};
		fContainerManager
				.addContainerManagerListener(fContainerManagerListener);

		fPadManager.registerContainerManager(fContainerManager);

		/*
		 * Update document partitioning.
		 * 
		 * TODO: find smarter way.
		 */
		try {
			String text = document.get();
			document.replace(0, text.length(), "");
			document.set(text);

		} catch (BadLocationException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

	}

	private void loadEditorPads() {
		logger.debug("loadEditorPads");
		
		fPadManager.registerPadFactory("Formula", new FormulaPadFactory());
		fPadManager.registerPadFactory("Image", new ImagePadFactory());
		fPadManager.registerPadFactory("Text", new TextPadFactory());
	}

	@Override
	public void dispose() {
		logger.debug("dispose() called");

		fPadManager.removeContainerManager(fContainerManager);
		fContainerManager
				.removeContainerManagerListener(fContainerManagerListener);
		fContainerManager.dispose();
		fContainerManager = null;

		super.dispose();
	}

	public void createPad(Pad pad, int location) {
		fPadManager.insertPad(pad, location, fContainerManager);
	}

	public int getCaretOffset() {
		return getSourceViewer().getTextWidget().getCaretOffset();
	}

	public Object[] getElements() {
		return fContainerManager.getElements();
	}

	public void doSave(IProgressMonitor monitor) {
		fPadManager.savePadsInEditor(fContainerManager.getContainerManagerID());
		super.doSave(monitor);
	}

	public void doSaveAs() {
		fPadManager.savePadsInEditor(fContainerManager.getContainerManagerID());
		super.doSaveAs();
	}
}
