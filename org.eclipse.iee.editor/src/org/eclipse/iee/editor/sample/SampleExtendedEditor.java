package org.eclipse.iee.editor.sample;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.editor.IPadEditor;
import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.iee.editor.core.container.event.ContainerEvent;
import org.eclipse.iee.editor.core.container.event.IContainerManagerListener;
import org.eclipse.iee.editor.core.pad.IPadFactoryManager;
import org.eclipse.iee.pad.image.ImagePart;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.editors.text.TextEditor;

import com.google.common.io.Files;

public class SampleExtendedEditor extends TextEditor implements IPadEditor {

	private ContainerManager fContainerManager;
	private IContainerManagerListener fContainerManagerListener;

	private final IPadFactoryManager fPadManager = IeeEditorPlugin.getDefault()
			.getPadFactoryManager();

	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);

		initIeeEditorCore();
	};

	@Override
	public void initIeeEditorCore() {
		IDocument document = getSourceViewer().getDocument();

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
		return getSourceViewer().getTextWidget().getCaretOffset();
	}

	@Override
	public Object[] getElements() {
		return fContainerManager.getElements();
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		fContainerManager.savePads();
		super.doSave(monitor);
	}

	@Override
	public void doSaveAs() {
		fContainerManager.savePads();
		super.doSaveAs();
	}

	@Override
	public IPadFactoryManager getPadManager() {
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

	@Override
	public void createPad(PadDocumentPart pad) {
		createPad(pad, getCaretOffset());
	}

}
