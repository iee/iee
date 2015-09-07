package org.eclipse.iee.pad.graph.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.iee.pad.graph.ui.GraphPad;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.jfree.experimental.chart.swt.editor.SWTChartEditor;

public class PropertiesHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			for (Object selected : ((IStructuredSelection) selection).toList()) {
				if (selected instanceof GraphPad) {
			        SWTChartEditor editor = new SWTChartEditor(HandlerUtil.getActiveShell(event).getDisplay(),
			                ((GraphPad) selected).getChart());
			        editor.open();
				}
			}
		}
		return null;
	}


}
