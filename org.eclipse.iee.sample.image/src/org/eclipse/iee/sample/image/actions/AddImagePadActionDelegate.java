package org.eclipse.iee.sample.image.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.iee.editor.IPadEditor;
import org.eclipse.iee.sample.image.XmlFilesStorage;
import org.eclipse.iee.sample.image.pad.ImagePad;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

public class AddImagePadActionDelegate implements IEditorActionDelegate {

	Shell shell = null;

	IPadEditor fPadEditor;

	@Override
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		try {
			fPadEditor = (IPadEditor) targetEditor;
		} catch (ClassCastException e) {
			fPadEditor = null;
		}
	}

	@Override
	public void run(IAction action) {

		if (fPadEditor == null) {
			MessageDialog.openError(shell, "Invalid editor", "Invalid editor");
			return;
		}
		
		IEditorPart editor = (IEditorPart)fPadEditor;
		IFileEditorInput input = (IFileEditorInput)editor.getEditorInput();
	    IFile file = input.getFile();
	    IProject project = file.getProject();
	    
		String storagePath = project.getRawLocation().makeAbsolute().toString() + "/pads/";

		ImagePad pad = new ImagePad();
		pad.setStoragePath(storagePath);
		
		fPadEditor.createPad(pad, fPadEditor.getCaretOffset());
		
		/* load saved pads */
		//XmlFilesStorage.getInstance(storagePath);
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
	}
}
