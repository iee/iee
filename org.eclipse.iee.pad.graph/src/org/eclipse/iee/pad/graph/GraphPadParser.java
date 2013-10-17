package org.eclipse.iee.pad.graph;

import java.util.Map;

import org.eclipse.iee.core.document.parser.IPadParser;
import org.eclipse.iee.pad.graph.model.GraphModel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * {@link IPadParser} implementation. Creates instance of graph pad.
 */
public class GraphPadParser implements IPadParser {

	@Override
	public GraphPart create(Map<String, String> padParams, String value) {
		Gson gson = new GsonBuilder().create();
		GraphModel model = gson.fromJson(value, GraphModel.class);
		GraphPart graphPad = new GraphPart(model);
		graphPad.setId(padParams.get("id"));
		return graphPad;
	}
	
	@Override
	public String getType() {
		return "Graph";
	}

}