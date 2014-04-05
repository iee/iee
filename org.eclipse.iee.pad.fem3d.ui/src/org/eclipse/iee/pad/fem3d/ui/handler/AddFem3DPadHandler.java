package org.eclipse.iee.pad.fem3d.ui.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.iee.editor.IPadEditor;
import org.eclipse.iee.pad.fem3d.Fem3DPart;
import org.eclipse.ui.handlers.HandlerUtil;

public class AddFem3DPadHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IPadEditor fPadEditor = (IPadEditor) HandlerUtil.getActiveEditorChecked(event);
		fPadEditor.createPad(new Fem3DPart(), fPadEditor.getCaretOffset());
		return null;
	}
	
}
