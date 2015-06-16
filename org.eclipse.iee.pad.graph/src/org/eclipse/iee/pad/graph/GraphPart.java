package org.eclipse.iee.pad.graph;

import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.pad.graph.model.GraphModel;

public class GraphPart extends PadDocumentPart {

	private GraphModel fModel;
	
	
	public GraphPart(GraphModel model) {
		fModel = model;
	}

	public GraphModel getModel() {
		return fModel;
	}

	public GraphPart copy() {
		GraphPart clone = new GraphPart(getModel().clone());
		return clone;
	}
}
