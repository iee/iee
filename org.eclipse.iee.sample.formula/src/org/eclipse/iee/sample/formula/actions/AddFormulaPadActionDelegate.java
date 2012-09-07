package org.eclipse.iee.sample.formula.actions;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.iee.editor.IPadEditor;
import org.eclipse.iee.sample.formula.pad.FormulaPad;
import org.eclipse.iee.sample.formula.storage.FileStorage;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

public class AddFormulaPadActionDelegate implements IEditorActionDelegate {

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

		IEditorPart editor = (IEditorPart)fPadEditor;
		IFileEditorInput input = (IFileEditorInput)editor.getEditorInput();
	    IFile file = input.getFile();
	    IProject project = file.getProject();
	    
	    IPath rawLocation = project.getRawLocation();
	    
	    String storagePath = "";
	    
	    if (rawLocation != null)
	    {
	    	storagePath = rawLocation.makeAbsolute().toString() + "/pads/formula/";
	    }
	    else
	    {
	    	IWorkspace workspace = ResourcesPlugin.getWorkspace();  
	    	IPath workspaceDirectory = workspace.getRoot().getLocation();
	    	storagePath = workspaceDirectory.toString() + project.getFullPath().makeAbsolute().toString() + "/pads/formula/";
	    }
	    
		System.out.println("storagePath = " + storagePath);
		
		
		FormulaPad pad = new FormulaPad();
		pad.setDirectoryPath(storagePath);
		
		fPadEditor.createPad(pad, fPadEditor.getCaretOffset());
			
		/* load saved pads */
		FileStorage.getInstance(storagePath);
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
	}
}
