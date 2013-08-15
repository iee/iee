package org.eclipse.iee.sample.graph;

import java.util.Map;

import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.sample.formula.pad.FormulaPad;
import org.eclipse.iee.sample.graph.pad.GraphPad;
import org.eclipse.iee.sample.graph.pad.model.GraphModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * {@link IPadFactory} implementation. Creates instance of graph pad.
 */
public class GraphPadFactory implements IPadFactory {

	@Override
	public Pad create(Map<String, String> padParams, String value) {
		Gson gson = new GsonBuilder().create();
		GraphModel model = gson.fromJson(value, GraphModel.class);
		GraphPad graphPad = new GraphPad(model);
		return graphPad;
	}
	
	@Override
	public String getType() {
		return "Graph";
	}

}