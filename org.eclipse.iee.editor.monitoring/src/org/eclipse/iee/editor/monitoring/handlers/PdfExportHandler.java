package org.eclipse.iee.editor.monitoring.handlers;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.iee.editor.IPadEditor;
import org.eclipse.iee.editor.core.container.Container;
import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.PadManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.handlers.HandlerUtil;

public class PdfExportHandler implements IHandler {

	private static final Logger logger = Logger
			.getLogger(PdfExportHandler.class);

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		logger.debug("Export to pdf");

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
		
		FileDialog fileDialog = new FileDialog(shell, SWT.SAVE);
		fileDialog.setFilterNames(new String[] { "pdf (*.pdf)" });
		fileDialog.setFilterExtensions(new String[] { "*.pdf" });

		String pdfPath = fileDialog.open();
		if (pdfPath == null) {
			return null;
		}

		//TODO: add export
		String latex = "";
		int lastOffset = 0;
		
		PadManager padManager = fPadEditor.getPadManager();
		ContainerManager containerManager = fPadEditor.getContainerManager();
		
		for (Container c : containerManager.getContainers())
		{
			String javaSource = "";
			int offset = c.getPosition().getOffset();
			int length = c.getPosition().getLength();
			
			try {
				javaSource = containerManager.getDocument().get(lastOffset, offset);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
			
			latex += javaSource;
			
			Pad pad = padManager.getPadById(c.getContainerID());
			latex += pad.getTex();
			
			lastOffset = offset + length;
		}
		
		logger.debug("full latex: " + latex);

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

