package org.eclipse.iee.sample.image.handlers;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.iee.editor.IPadEditor;
import org.eclipse.iee.sample.image.pad.ImagePad;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.handlers.HandlerUtil;

public class AddImageHandler implements IHandler {

	private static final Logger logger = Logger
			.getLogger(AddImageHandler.class);

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		logger.debug("Insert Image");

		Shell shell = HandlerUtil.getActiveWorkbenchWindow(event).getShell();
		IWorkbenchPage page = HandlerUtil.getActiveWorkbenchWindow(event)
				.getActivePage();
		IEditorPart targetEditor = page.getActiveEditor();

		IPadEditor fPadEditor;
		try {
			fPadEditor = (IPadEditor) targetEditor;
		} catch (ClassCastException e) {
			fPadEditor = null;
		}

		if (fPadEditor == null) {
			MessageDialog.openError(shell, "Invalid editor", "Invalid editor");
			return null;
		}

		FileDialog fileDialog = new FileDialog(shell, SWT.OPEN);
		fileDialog.setFilterNames(new String[] { "Jpeg (*.jpg)", "PNG (*.png)" });
		fileDialog.setFilterExtensions(new String[] { "*.jpg", "*.png" });

		String imagePath = fileDialog.open();
		if (imagePath == null) {
			return null;
		}
		
		ImagePad pad = new ImagePad();
		
		fPadEditor.createPad(pad, fPadEditor.getCaretOffset());
		pad.moveCaretToCurrentPad();
		
		pad.setImageFile(imagePath);

		return null;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
	}

}
