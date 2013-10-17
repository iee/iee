package org.eclipse.iee.pad.fem3d.ui.handler;

import org.eclipse.iee.editor.IPadEditor;
import org.eclipse.iee.pad.fem3d.Fem3DPart;
import org.eclipse.iee.pad.fem3d.ui.Fem3DPad;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

public class AddFem3DPadActionDelegate implements IEditorActionDelegate {

	private Shell shell = null;

	private IPadEditor fPadEditor;

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
		Shell[] shells = Display.getCurrent().getShells();
		if (shells.length > 0) {
			shell = shells[0];
		}

		if (fPadEditor == null) {
			MessageDialog.openError(shell, "Invalid editor", "Invalid editor");
			return;
		}

		fPadEditor.createPad(new Fem3DPart(), fPadEditor.getCaretOffset());
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
	}
}
