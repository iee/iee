package org.eclipse.iee.sample.image.actions;

import org.eclipse.iee.editor.IPadEditor;
import org.eclipse.iee.sample.image.pad.ImagePad;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

public class AddImagePadActionDelegate implements IEditorActionDelegate {

	Shell shell = null;
	
	IPadEditor fPadEditor;

	@Override
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		if (targetEditor instanceof IPadEditor) {
			fPadEditor = (IPadEditor) targetEditor;
        }
	}

	@Override
	public void run(IAction action) {
		
		if (fPadEditor == null) {
            return;
        }
		
		fPadEditor.createPad(new ImagePad(), fPadEditor.getCaretOffset());
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
	}
}
