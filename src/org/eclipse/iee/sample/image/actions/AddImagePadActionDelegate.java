package org.eclipse.iee.sample.image.actions;

import org.eclipse.iee.editor.jdt.editors.ExtendedJavaEditor;
import org.eclipse.iee.editor.sample.SampleExtendedEditor;
import org.eclipse.iee.sample.image.pad.ImagePad;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

public class AddImagePadActionDelegate implements IEditorActionDelegate {

	Shell shell = null;
	
	ExtendedJavaEditor fExtendedJavaEditor;
	
	@Override
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		
		if (targetEditor instanceof ExtendedJavaEditor) {
			fExtendedJavaEditor = (ExtendedJavaEditor) targetEditor;
        }
	}

	@Override
	public void run(IAction action) {
		Shell[] shells = Display.getCurrent().getShells();        
		if (shells.length > 0) {
            shell = shells[0];
        }
        
		if (fExtendedJavaEditor == null) {
            MessageDialog.openError(shell, "Invalid editor", "Invalid editor");
            return;
        }
		
		fExtendedJavaEditor.createPad(new ImagePad(), fExtendedJavaEditor.getCaretOffset());
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
	}
}
