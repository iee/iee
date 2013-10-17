package org.eclipse.iee.pad.graph.ui;

import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.pad.graph.GraphPart;

public class GraphPadFactory implements IPadFactory<GraphPart> {

	@Override
	public Pad create(GraphPart documentPart) {
		return new GraphPad(documentPart);
	}

}
