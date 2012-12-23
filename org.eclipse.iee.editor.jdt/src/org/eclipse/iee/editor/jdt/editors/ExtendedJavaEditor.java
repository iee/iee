package org.eclipse.iee.editor.jdt.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.iee.editor.IPadEditor;
import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.iee.editor.core.container.ContainerManagerConfig;
import org.eclipse.iee.editor.core.container.event.ContainerEvent;
import org.eclipse.iee.editor.core.container.event.IContainerManagerListener;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.PadManager;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor;
import org.eclipse.jdt.internal.ui.javaeditor.JavaSourceViewer;
import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jdt.ui.text.IJavaPartitions;
import org.eclipse.jdt.ui.text.JavaSourceViewerConfiguration;
import org.eclipse.jdt.ui.text.JavaTextTools;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;

@SuppressWarnings("restriction")
public class ExtendedJavaEditor extends CompilationUnitEditor implements IPadEditor {

	private ContainerManager fContainerManager;
	private IContainerManagerListener fContainerManagerListener;

	private final PadManager fPadManager =
		IeeEditorPlugin.getDefault().getPadManager();

	public ExtendedJavaEditor() {
		super();
	}
	
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);

		initIeeEditorCore();
	};
	
	public void initIeeEditorCore() {
		IDocument document = getSourceViewer().getDocument();
		
		ContainerManagerConfig config = new ContainerManagerConfig();

		//config.EMBEDDED_REGION_BEGIN = "/*<";
		//config.EMBEDDED_REGION_END = ">*/";
		//config.INNER_TEXT_BEGIN = "*/";
		//config.INNER_TEXT_END = "/*";
		
		fContainerManager = new ContainerManager(
			config,
			document,
			getSourceViewer(),
			getSourceViewer().getTextWidget());

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
		fContainerManager.addContainerManagerListener(fContainerManagerListener);

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
			e.printStackTrace();
		}
	}

	@Override
	public void dispose() {
		System.out.println("ExtendedJavaEditor dispose() called");
		
		fPadManager.removeContainerManager(fContainerManager);
		fContainerManager.removeContainerManagerListener(fContainerManagerListener);
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
