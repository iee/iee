/**
 * 
 */
package org.eclipse.iee.sample.graph.pad.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GraphModel implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	
	private List<GraphElement> elements;

	public List<GraphElement> getElements() {
		if (elements == null) {
			elements = new ArrayList<GraphElement>();
		}
		return elements;
	}

	public void setElements(List<GraphElement> elements) {
		this.elements = elements;
	}
	
	@Override
	public GraphModel clone() {
		try {
			return (GraphModel) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

}
