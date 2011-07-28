package org.eclipse.iee.sample.math.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class AddMathAction implements IWorkbenchWindowActionDelegate {
	private IWorkbenchWindow window;
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}

	@Override
	public void run(IAction action) {
		MessageDialog.openError(
				window.getShell(),
				"Error",
				"Core does not complete");
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		// TODO Auto-generated method stub

	}

}
