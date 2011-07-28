package org.eclipse.iee.sample.math.actions;

import org.eclipse.iee.editor.sample.SampleExtendedEditor;
import org.eclipse.iee.sample.math.pad.MathPad;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

public class AddMathPadActionDelegate implements IEditorActionDelegate {

	Shell shell = null;
	
	SampleExtendedEditor fSampleExtendedEditor;
	
	@Override
	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		
		if (targetEditor instanceof SampleExtendedEditor) {
			fSampleExtendedEditor = (SampleExtendedEditor) targetEditor;
        }
	}

	@Override
	public void run(IAction action) {
		Shell[] shells = Display.getCurrent().getShells();        
		if (shells.length > 0) {
            shell = shells[0];
        }
        
		if (fSampleExtendedEditor == null) {
            MessageDialog.openError(shell, "Invalid editor", "Invalid editor");
            return;
        }
		
		fSampleExtendedEditor.createPad(new MathPad(), fSampleExtendedEditor.getCaretOffset());
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
	}
}
