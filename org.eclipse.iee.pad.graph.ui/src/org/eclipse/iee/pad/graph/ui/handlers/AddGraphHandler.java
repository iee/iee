package org.eclipse.iee.pad.graph.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.iee.editor.IPadEditor;
import org.eclipse.iee.pad.graph.GraphPart;
import org.eclipse.iee.pad.graph.model.GraphElement;
import org.eclipse.iee.pad.graph.model.GraphModel;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.google.common.base.Verify;

public class AddGraphHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IEditorPart targetEditor = HandlerUtil.getActiveEditor(event);

		Verify.verify(targetEditor != null, "Active editor cannot be null");
		Verify.verify(targetEditor instanceof IPadEditor, "Active editor should be IPadEditor but it is %s", targetEditor.getClass().getName());
		
		IPadEditor fPadEditor = (IPadEditor) targetEditor;
		GraphModel model = new GraphModel();
		model.addElement(new GraphElement());
		fPadEditor.createPad(new GraphPart(model), fPadEditor.getCaretOffset());

		return null;
	}

}
