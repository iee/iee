package org.eclipse.iee.pad.graph;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.iee.core.document.writer.IPadWriter;
import org.osgi.service.component.annotations.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Component
public class GraphPadWriter implements IPadWriter<GraphPart> {

	@Override
	public String getValue(GraphPart part) {
		Gson gson = new GsonBuilder().create();
		return gson.toJson(part.getModel());
	}

	@Override
	public Map<String, String> getParams(GraphPart part) {
		return new HashMap<>();
	}

	@Override
	public String getType() {
		return "Graph";
	}

}
