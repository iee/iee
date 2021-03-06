package org.eclipse.iee.editor.jdt.editors;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.UUID;
import java.util.concurrent.Callable;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.editor.IPadEditor;
import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.editor.core.container.Container;
import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.iee.editor.core.pad.IPadFactoryManager;
import org.eclipse.iee.editor.core.pad.common.text.IEditorLocation;
import org.eclipse.iee.editor.core.pad.common.ui.SelectionModel;
import org.eclipse.iee.pad.image.ImagePart;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.actions.CompositeActionGroup;
import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor;
import org.eclipse.jdt.ui.actions.OpenViewActionGroup;
import org.eclipse.jdt.ui.text.IJavaPartitions;
import org.eclipse.jdt.ui.text.JavaSourceViewerConfiguration;
import org.eclipse.jdt.ui.text.JavaTextTools;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.ITextViewerExtension5;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.ImageTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.HelpListener;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchCommandConstants;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;
import org.eclipse.ui.texteditor.IUpdate;
import org.eclipse.ui.texteditor.IWorkbenchActionDefinitionIds;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.PropertySheetEntry;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;
import com.google.common.base.Throwables;
import com.google.common.io.Files;

@SuppressWarnings("restriction")
public class ExtendedJavaEditor extends CompilationUnitEditor implements
		IPadEditor, IAdaptable {

	private static final Logger logger = LoggerFactory.getLogger(ExtendedJavaEditor.class);

	private PropertySheetPage fPropertySheetPage;
	
	private ContainerManager fContainerManager;
	
	private ICompilationUnit fCompilationUnit;
	
	private IPartListener fPartListener = new IPartListener() {
        public void partActivated(IWorkbenchPart part) {
        }

        public void partBroughtToTop(IWorkbenchPart part) {
        }

        public void partClosed(IWorkbenchPart part) {
        }

        public void partDeactivated(IWorkbenchPart part) {
        	if (part == ExtendedJavaEditor.this) {
        		fContainerManager.deactivate();
        	}
        }

        public void partOpened(IWorkbenchPart part) {
        }
    };
	
	public ExtendedJavaEditor() {
		super();
		setEditorContextMenuId("org.eclipse.iee.editor.popup");
	}
	
	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		super.init(site, input);
		IFile file = ((IFileEditorInput)input).getFile();
		fCompilationUnit = JavaCore.createCompilationUnitFrom(file);
	}
	
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);

		logger.debug("Create ExtendedJavaEditor");

		getSite().getPage().addPartListener(fPartListener);

		doSave(null);
	};
	
	@Override
	public void dispose() {
		logger.debug("dispose() called");
		getSite().getPage().removePartListener(fPartListener);
		super.dispose();
	}
	
	@Override
	public ISelectionProvider getSelectionProvider() {
		return fContainerManager;
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
		return getContainerManager().getElements();
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		getContainerManager().savePads();
		super.doSave(monitor);
	}

	@Override
	public void doSaveAs() {
		getContainerManager().savePads();
		super.doSaveAs();
	}

	@Override
	protected ISourceViewer createJavaSourceViewer(Composite parent,
			IVerticalRuler verticalRuler, IOverviewRuler overviewRuler,
			boolean isOverviewRulerVisible, int styles, IPreferenceStore store) {
		ISourceViewer viewer = super.createJavaSourceViewer(parent, verticalRuler, overviewRuler, isOverviewRulerVisible, styles, store);
		fContainerManager = new ContainerManager(IeeEditorPlugin.getDefault().getPadFactoryManager(), IeeEditorPlugin.getDefault().getParser(), 
				IeeEditorPlugin.getDefault().getWriter(), viewer, new IShellProvider() {
					
					@Override
					public Shell getShell() {
						return getSite().getWorkbenchWindow().getShell();
					}
				});
		fContainerManager.setCompilationUnit(fCompilationUnit);

		
		
		IEditorPart editor = this;
		IFileEditorInput input = (IFileEditorInput) editor.getEditorInput();
		IFile file = input.getFile();
		IProject project = file.getProject();

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
		
		return viewer;
	}

	@Override
	protected JavaSourceViewerConfiguration createJavaSourceViewerConfiguration() {
		JavaTextTools textTools= JavaPlugin.getDefault().getJavaTextTools();
		return new ExtendedJavaSourceViewerConfiguration(textTools.getColorManager(), getPreferenceStore(), this, IJavaPartitions.JAVA_PARTITIONING);
	}
	
	@Override
	protected void createActions() {
		super.createActions();

	}
	
	@Override
	protected void createNavigationActions() {
		super.createNavigationActions();

		
		createDelegateAction(ITextEditorActionDefinitionIds.LINE_START, new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				Optional<IEditorLocation> position = fContainerManager.getCursonPosition();
				if (position.isPresent()) {
					Optional<IEditorLocation> start = position.get().getLineStart();
					if (start.isPresent()) {
						fContainerManager.setCursorPosition(start.get());
					}
					return true;
				}
				return false;
			}
		});
		createDelegateAction(ITextEditorActionDefinitionIds.SELECT_LINE_START, new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				Optional<IEditorLocation> position = fContainerManager.getCursonPosition();
				if (position.isPresent()) {
					Optional<IEditorLocation> start = position.get().getLineStart();
					if (start.isPresent()) {
						fContainerManager.setSelectionEnd(start.get());
					} 
					return true;
				}
				return false;
			}
		});
		createDelegateAction(ITextEditorActionDefinitionIds.LINE_END, new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				Optional<IEditorLocation> position = fContainerManager.getCursonPosition();
				if (position.isPresent()) {
					Optional<IEditorLocation> end = position.get().getLineEnd();
					if (end.isPresent()) {
						fContainerManager.setCursorPosition(end.get());
					}
					return true;
				}
				return false;
			}
		});
		createDelegateAction(ITextEditorActionDefinitionIds.SELECT_LINE_END, new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				Optional<IEditorLocation> position = fContainerManager.getCursonPosition();
				if (position.isPresent()) {
					Optional<IEditorLocation> end = position.get().getLineEnd();
					if (end.isPresent()) {
						fContainerManager.setSelectionEnd(end.get());
					} 
					return true;
				}
				return false;
			}
		});
		
	}
	
	private void createDelegateAction(String actionId, final Callable<Boolean> callable) {
		createDelegateAction(actionId, callable, actionId);	
	}

	private void createDelegateAction(String actionId, final Callable<Boolean> callable, String definitionId) {
		final DelegateAction action = new DelegateAction(getAction(actionId)) {
			@Override
			public void run() {
				try {
					if (!callable.call()) {
						super.run();
					}
				} catch (final Exception e) {
					throw Throwables.propagate(e);
				}
			}
			
			@Override
			public void runWithEvent(final Event event) {
				run();
			}
		};
		action.setActionDefinitionId(definitionId);
		setAction(actionId, action);
	}
	
	@Override
	public IPadFactoryManager getPadManager() {
		return IeeEditorPlugin.getDefault().getPadFactoryManager();
	}

	@Override
	public ContainerManager getContainerManager() {
		return fContainerManager;
	}

	private boolean copy() {
		Optional<IEditorLocation> position = getContainerManager().getCursonPosition();
		if (position.isPresent()) {
			String txt = getContainerManager().getSelectionModel().copy();
			Clipboard clipboard = new Clipboard(getDisplay());
			TextTransfer textTransfer = TextTransfer.getInstance();
			clipboard.setContents(new Object[] {txt}, new Transfer[] {textTransfer});
			return true;
		}
		return false;
	}

	private boolean cut() {
		if (getContainerManager().getCursonPosition().isPresent()) {
			Clipboard clipboard = new Clipboard(getDisplay());
			SelectionModel selectionModel = getContainerManager().getSelectionModel();
			String txt = selectionModel.copy();
			getContainerManager().setCursorPosition(selectionModel.replace(""));
			TextTransfer textTransfer = TextTransfer.getInstance();
			clipboard.setContents(new Object[] {txt}, new Transfer[] {textTransfer});
			return true;
		}
		return false;
	}
	
	private boolean paste() {
		if (getContainerManager().getCursonPosition().isPresent()) {
			Clipboard clipboard = new Clipboard(getDisplay());
			TextTransfer textTransfer = TextTransfer.getInstance();
			String contents = (String) clipboard.getContents(textTransfer);
			getContainerManager().setCursorPosition(getContainerManager().getSelectionModel().replace(contents));
			return true;
		}
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
				createPad(imagePart, getExt5().widgetOffset2ModelOffset(getViewer().getTextWidget().getCaretOffset()));
				return true;
			}
			FileTransfer fileTransfer = FileTransfer.getInstance();
			String[] files = (String[]) clipboard
					.getContents(fileTransfer);
			if (files != null && files.length > 0) {
				try {
					new ImageData(files[0]);
					createImage(files[0], getExt5().widgetOffset2ModelOffset(getViewer().getTextWidget().getCaretOffset()));
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
		if (getViewer().getTextWidget() == null || getViewer().getTextWidget().isDisposed())
			return null;

		Display display = getViewer().getTextWidget().getDisplay();
		if (display != null && display.isDisposed())
			return null;

		return display;
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
	
	private ITextViewerExtension5 getExt5() {
		return (ITextViewerExtension5) getViewer();
	}
	
	private class DelegateAction implements IAction, IUpdate {
		
		private final IAction action;
		
		private IUpdate update;
		
		public DelegateAction(IAction action) {
			this.action = action;
			if (action instanceof IUpdate) {
				this.update = (IUpdate) action;
			}
		}

		@Override
		public void addPropertyChangeListener(IPropertyChangeListener listener) {
			action.addPropertyChangeListener(listener);
		}

		@Override
		public int getAccelerator() {
			return action.getAccelerator();
		}

		@Override
		public String getActionDefinitionId() {
			return action.getActionDefinitionId();
		}

		@Override
		public String getDescription() {
			return action.getDescription();
		}

		@Override
		public ImageDescriptor getDisabledImageDescriptor() {
			return action.getDisabledImageDescriptor();
		}

		@Override
		public HelpListener getHelpListener() {
			return action.getHelpListener();
		}

		@Override
		public ImageDescriptor getHoverImageDescriptor() {
			return action.getHoverImageDescriptor();
		}

		@Override
		public String getId() {
			return action.getId();
		}

		@Override
		public ImageDescriptor getImageDescriptor() {
			return action.getImageDescriptor();
		}

		@Override
		public IMenuCreator getMenuCreator() {
			return action.getMenuCreator();
		}

		@Override
		public int getStyle() {
			return action.getStyle();
		}

		@Override
		public String getText() {
			return action.getText();
		}

		@Override
		public String getToolTipText() {
			return action.getToolTipText();
		}

		@Override
		public boolean isChecked() {
			return action.isChecked();
		}

		@Override
		public boolean isEnabled() {
			return action.isEnabled();
		}

		@Override
		public boolean isHandled() {
			return action.isHandled();
		}

		@Override
		public void removePropertyChangeListener(
				IPropertyChangeListener listener) {
			action.removePropertyChangeListener(listener);
		}

		@Override
		public void run() {
			action.run();
		}

		@Override
		public void runWithEvent(Event event) {
			action.runWithEvent(event);
		}

		@Override
		public void setActionDefinitionId(String id) {
			action.setActionDefinitionId(id);
		}

		@Override
		public void setChecked(boolean checked) {
			action.setChecked(checked);
		}

		@Override
		public void setDescription(String text) {
			action.setDescription(text);
		}

		@Override
		public void setDisabledImageDescriptor(ImageDescriptor newImage) {
			action.setDisabledImageDescriptor(newImage);
		}

		@Override
		public void setEnabled(boolean enabled) {
			action.setEnabled(enabled);
		}

		@Override
		public void setHelpListener(HelpListener listener) {
			action.setHelpListener(listener);
		}

		@Override
		public void setHoverImageDescriptor(ImageDescriptor newImage) {
			action.setHoverImageDescriptor(newImage);
		}

		@Override
		public void setId(String id) {
			action.setId(id);
		}

		@Override
		public void setImageDescriptor(ImageDescriptor newImage) {
			action.setImageDescriptor(newImage);
		}

		@Override
		public void setMenuCreator(IMenuCreator creator) {
			action.setMenuCreator(creator);
		}

		@Override
		public void setText(String text) {
			action.setText(text);
		}

		@Override
		public void setToolTipText(String text) {
			action.setToolTipText(text);
		}

		@Override
		public void setAccelerator(int keycode) {
			action.setAccelerator(keycode);
		}

		@Override
		public void update() {
			if (update != null) {
				update.update();
			}
		}
		
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public Object getAdapter(Class required) {
		if (IPropertySheetPage.class.equals(required)) {
			fPropertySheetPage = new PropertySheetPage();
			fPropertySheetPage.setRootEntry(new PropertySheetEntry(){
				
				java.beans.PropertyChangeListener listener = new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						refreshFromRoot();
					}
				};
				
				@Override
				public void setValues(Object[] objects) {
					if (getValues() != null) {
						for (Object object : getValues()) {
							if (object instanceof Container) {
								((Container) object).getPadPart().removePropertyChangeListener(listener);
							}
						}
					}
					super.setValues(objects);
					for (Object object : objects) {
						if (object instanceof Container) {
							((Container) object).getPadPart().addPropertyChangeListener(listener);
						}
					}
				}

				@Override
				public void dispose() {
					super.dispose();
					for (Object object : getValues()) {
						if (object instanceof Container) {
							((Container) object).getPadPart().removePropertyChangeListener(listener);
						}
					}
				}
				
			});
			return fPropertySheetPage;
		} else if (ITextOperationTarget.class.equals(required)) {
			final ITextOperationTarget delegate = (ITextOperationTarget) super.getAdapter(ITextOperationTarget.class);
			return new ITextOperationTarget() {
				@Override
				public void doOperation(int operation) {
					Optional<IEditorLocation> position = getContainerManager().getCursonPosition();
					if (position.isPresent()) {
						switch (operation) {
						case ITextOperationTarget.CUT:
							cut();
							return;
						case ITextOperationTarget.COPY:
							copy();
							return;
						case ITextOperationTarget.DELETE:
						case ITextOperationTarget.PASTE:
							paste();
							return;
						}
					} else {
						delegate.doOperation(operation);
					}
				}
				
				@Override
				public boolean canDoOperation(int operation) {
					Optional<IEditorLocation> position = getContainerManager().getCursonPosition();
					if (position.isPresent()) {
						switch (operation) {
						case ITextOperationTarget.CUT:
							return isEditable() && position.isPresent();
						case ITextOperationTarget.COPY:
							return position.isPresent();
						case ITextOperationTarget.DELETE:
						case ITextOperationTarget.PASTE:
							return isEditable();
						}
					}
					return delegate.canDoOperation(operation);
				}
			};
		}
		return super.getAdapter(required);
	}

	@Override
	public void createPad(PadDocumentPart pad) {
		createPad(pad, getCaretOffset());
	}
	
	@Override
	public void editorContextMenuAboutToShow(IMenuManager menu) {
		Field groupsField;
		try {
			groupsField = CompositeActionGroup.class.getDeclaredField("fGroups");
			groupsField.setAccessible(true);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException e1) {
			throw Throwables.propagate(e1);
		}
		ActionGroup[] groups;
		try {
			groups = (ActionGroup[]) groupsField.get(fActionGroups);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw Throwables.propagate(e);
		}
		for (ActionGroup actionGroup : groups) {
			if (actionGroup instanceof OpenViewActionGroup) {
				((OpenViewActionGroup) actionGroup).containsOpenPropertiesAction(false);
			}
		}
		super.editorContextMenuAboutToShow(menu);
	}
	
}
