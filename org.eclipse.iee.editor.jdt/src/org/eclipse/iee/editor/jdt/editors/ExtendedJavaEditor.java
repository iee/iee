package org.eclipse.iee.editor.jdt.editors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.UUID;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.core.document.parser.DocumentStructureConfig;
import org.eclipse.iee.editor.IPadEditor;
import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.iee.editor.core.container.event.ContainerEvent;
import org.eclipse.iee.editor.core.container.event.IContainerManagerListener;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.PadManager;
import org.eclipse.iee.pad.image.ImagePart;
import org.eclipse.iee.pad.image.ui.ImagePad;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor;
import org.eclipse.jdt.internal.ui.javaeditor.JavaSourceViewer;
import org.eclipse.jdt.ui.text.IJavaPartitions;
import org.eclipse.jdt.ui.text.JavaSourceViewerConfiguration;
import org.eclipse.jdt.ui.text.JavaTextTools;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewerExtension5;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.ImageTransfer;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Throwables;
import com.google.common.io.Closeables;
import com.google.common.io.Files;

@SuppressWarnings("restriction")
public class ExtendedJavaEditor extends CompilationUnitEditor implements
		IPadEditor {

	private static final Logger logger = LoggerFactory
			.getLogger(ExtendedJavaEditor.class);

	private static final String BUNDLE_FOR_CONSTRUCTED_KEYS = "org.eclipse.jdt.internal.ui.javaeditor.ConstructedJavaEditorMessages";//$NON-NLS-1$
	private static ResourceBundle fgBundleForConstructedKeys = ResourceBundle
			.getBundle(BUNDLE_FOR_CONSTRUCTED_KEYS);

	private ContainerManager fContainerManager;
	private IContainerManagerListener fContainerManagerListener;

	private final PadManager fPadManager = IeeEditorPlugin.getDefault()
			.getPadManager();

	public ExtendedJavaEditor() {
		super();
	}

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);

		logger.debug("Create ExtendedJavaEditor");

		initIeeEditorCore();

		doSave(null);
	};

	@Override
	public void initIeeEditorCore() {
		IDocument document = getSourceViewer().getDocument();

		DocumentStructureConfig config = new DocumentStructureConfig();
		fContainerManager = new ContainerManager(IeeEditorPlugin.getDefault().getParser(), 
				IeeEditorPlugin.getDefault().getWriter(), document,
				getSourceViewer(), getSourceViewer().getTextWidget());

		IEditorPart editor = (IEditorPart) this;
		IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
		IFile file = input.getFile();
		IProject project = file.getProject();
		ICompilationUnit compilationUnit = JavaCore
				.createCompilationUnitFrom(file);
		fContainerManager.setCompilationUnit(compilationUnit);

		IPath rawLocation = project.getRawLocation();

		String storagePath = "";

		if (rawLocation != null) {
			storagePath = rawLocation.makeAbsolute().toString() + "/pads/";
		} else {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IPath workspaceDirectory = workspace.getRoot().getLocation();
			storagePath = workspaceDirectory.toString()
					+ project.getFullPath().makeAbsolute().toString()
					+ "/pads/";
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

			@Override
			public void containerDeactivated(ContainerEvent containerEvent) {
				// TODO Auto-generated method stub

			}
		};
		fContainerManager
				.addContainerManagerListener(fContainerManagerListener);

		fPadManager.registerContainerManager(fContainerManager);

		getSourceViewer().getTextWidget().addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				getContainerManager().getUserInteractionManager().activateContainer(null);
			}
		});
		
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

	@Override
	public void createPad(PadDocumentPart pad, int location) {
		getContainerManager().createContainer(pad, location);
	}

	@Override
	public int getCaretOffset() {
		ISourceViewer sourceViewer = getSourceViewer();
		ITextViewerExtension5 ext5 = (ITextViewerExtension5) sourceViewer;
		return ext5.widgetOffset2ModelOffset(sourceViewer.getTextWidget().getCaretOffset());
	}

	@Override
	public Object[] getElements() {
		return fContainerManager.getElements();
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		fPadManager.savePadsInEditor(fContainerManager.getContainerManagerID());

		super.doSave(monitor);
	}

	@Override
	public void doSaveAs() {
		fPadManager.savePadsInEditor(fContainerManager.getContainerManagerID());
		super.doSaveAs();
	}

	// TODO move to separate class
	@Override
	protected ISourceViewer createJavaSourceViewer(Composite parent,
			IVerticalRuler verticalRuler, IOverviewRuler overviewRuler,
			boolean isOverviewRulerVisible, int styles, IPreferenceStore store) {
		return new JavaSourceViewer(parent, verticalRuler, overviewRuler,

				isOverviewRulerVisible, styles, store) {

			@Override
			public void doOperation(int operation) {

				if (getTextWidget() == null
						|| (!redraws() && operation != FORMAT))
					return;

				switch (operation) {
				case PASTE:
					boolean result = paste();
					if (!result) {
						super.doOperation(operation);
					}
					break;
				default:
					super.doOperation(operation);
				}
			}

			private boolean paste() {
				Clipboard clipboard = new Clipboard(getDisplay());
				try {
					ImageTransfer transfer = ImageTransfer.getInstance();
					ImageData content = (ImageData) clipboard
							.getContents(transfer);
					if (content != null) {
						File storageDirectory = new File(getContainerManager()
								.getStoragePath() + "image/");

						if (!storageDirectory.exists()) {
							if (!storageDirectory.mkdirs()) {
								return false;
							}
						}
						ImageLoader loader = new ImageLoader();
						loader.data = new ImageData[] { content };
						String imageName = UUID.randomUUID().toString() + ".png";
						File imageDst = new File(getContainerManager()
								.getStoragePath() + "image/" + imageName);
						try (FileOutputStream stream = new FileOutputStream(imageDst)) {
							loader.save(stream, SWT.IMAGE_PNG);
						} catch (IOException e) {
							throw Throwables.propagate(e);
						}
						ImagePart imagePart = new ImagePart();
						imagePart.setImagePath(imageName);
						createPad(imagePart, getTextWidget().getCaretOffset());
						return true;
					}
					FileTransfer fileTransfer = FileTransfer.getInstance();
					String[] files = (String[]) clipboard
							.getContents(fileTransfer);
					if (files != null && files.length > 0) {
						try {
							new ImageData(files[0]);
							createImage(files[0], getTextWidget().getCaretOffset());
						} catch (Exception e) {
							// not image
						}
					}
				} finally {
					clipboard.dispose();
				}

				return false;
			}

			private Display getDisplay() {
				if (getTextWidget() == null || getTextWidget().isDisposed())
					return null;

				Display display = getTextWidget().getDisplay();
				if (display != null && display.isDisposed())
					return null;

				return display;
			}
		};
	}

	@Override
	protected JavaSourceViewerConfiguration createJavaSourceViewerConfiguration() {
		JavaTextTools textTools= JavaPlugin.getDefault().getJavaTextTools();
		return new ExtendedJavaSourceViewerConfiguration(textTools.getColorManager(), getPreferenceStore(), this, IJavaPartitions.JAVA_PARTITIONING);
	}
	
	
	@Override
	public PadManager getPadManager() {
		return fPadManager;
	}

	@Override
	public ContainerManager getContainerManager() {
		return fContainerManager;
	}
	
	@Override
	public void createImage(String fileName, int location) {
		File storageDirectory = new File(getContainerManager()
				.getStoragePath() + "image/");

		if (!storageDirectory.exists()) {
			if (!storageDirectory.mkdirs()) {
				return;
			}
		}

		File imageSrc = new File(fileName);
		File imageDst = new File(getContainerManager()
				.getStoragePath() + "image/" + imageSrc.getName());
		if (!imageDst.exists()) {
			try {
				Files.copy(imageSrc, imageDst);
			} catch (IOException e1) {
			}
		}
		ImagePart imagePart = new ImagePart();
		imagePart.setImagePath(imageSrc.getName());
		createPad(imagePart, location);
	}
}
