package org.eclipse.iee.sample.graph.handlers;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.iee.editor.IPadEditor;
import org.eclipse.iee.sample.graph.pad.GraphPad;
import org.eclipse.iee.sample.graph.pad.model.GraphElement;
import org.eclipse.iee.sample.graph.pad.model.GraphModel;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.handlers.HandlerUtil;

public class AddGraphHandler implements IHandler {

	private static final Logger logger = Logger
			.getLogger(AddGraphHandler.class);

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		logger.debug("Insert Graph");

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

		GraphModel model = new GraphModel();
		model.getElements().add(new GraphElement());
		fPadEditor.createPad(new GraphPad(model), fPadEditor.getCaretOffset());

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
