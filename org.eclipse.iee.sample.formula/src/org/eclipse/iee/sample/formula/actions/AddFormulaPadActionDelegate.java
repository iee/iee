package org.eclipse.iee.sample.formula.actions;

import org.apache.log4j.Logger;
import org.eclipse.iee.editor.IPadEditor;
import org.eclipse.iee.sample.formula.pad.FormulaPad;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

public class AddFormulaPadActionDelegate implements IEditorActionDelegate {

	private static final Logger logger = Logger.getLogger(AddFormulaPadActionDelegate.class);
	
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
		Shell[] shells = Display.getCurrent().getShells();
		if (shells.length > 0) {
			shell = shells[0];
		}

		if (fPadEditor == null) {
			MessageDialog.openError(shell, "Invalid editor", "Invalid editor");
			return;
		}
		
		logger.debug("Insert Formula");
		
		FormulaPad pad = new FormulaPad();
		
		fPadEditor.createPad(pad, fPadEditor.getCaretOffset());
		
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
	}
}
