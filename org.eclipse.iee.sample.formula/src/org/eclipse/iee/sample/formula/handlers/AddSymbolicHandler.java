package org.eclipse.iee.sample.formula.handlers;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.iee.editor.IPadEditor;
import org.eclipse.iee.sample.formula.pad.SymbolicPad;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.handlers.HandlerUtil;

public class AddSymbolicHandler implements IHandler {

	private static final Logger logger = Logger
			.getLogger(AddSymbolicHandler.class);

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		logger.debug("Insert Formula");

		Shell shell = HandlerUtil.getActiveWorkbenchWindow(event).getShell();
		IWorkbenchPage page = HandlerUtil.getActiveWorkbenchWindow(event)
				.getActivePage();
		IEditorPart targetEditor = page.getActiveEditor();

		final IPadEditor fPadEditor;
		try {
			fPadEditor = (IPadEditor) targetEditor;
		} catch (ClassCastException e) {
			MessageDialog.openError(shell, "Invalid editor", "Invalid editor");
			return null;
		}

		final SymbolicPad pad = new SymbolicPad();

		fPadEditor.createPad(pad, fPadEditor.getCaretOffset());

		shell.getDisplay().asyncExec(new Runnable() {

			@Override
			public void run() {
				fPadEditor.getContainerManager().getUserInteractionManager()
						.activateContainer(pad.getContainer());
			}
		});

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
