package org.eclipse.iee.editor.core.pad.table.ui.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.iee.editor.IPadEditor;
import org.eclipse.iee.editor.core.pad.common.CollapseBeginPart;
import org.eclipse.iee.editor.core.pad.table.TableCell;
import org.eclipse.iee.editor.core.pad.table.TableColumn;
import org.eclipse.iee.editor.core.pad.table.TablePart;
import org.eclipse.iee.editor.core.pad.table.TableRow;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.common.collect.Lists;

public class AddTableHandler implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
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
		
		TablePart tablePart = new TablePart();
		tablePart.setColumns(Lists.newArrayList(new TableColumn("Header")));
		tablePart.addRow(new TableRow());
		tablePart.setCell(0, 0, new TableCell("value"));
		fPadEditor.createPad(tablePart);
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
