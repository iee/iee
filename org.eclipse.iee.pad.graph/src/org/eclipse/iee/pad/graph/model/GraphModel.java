/**
 * 
 */
package org.eclipse.iee.pad.graph.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GraphModel implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	
	private Double minX;

	private Double maxX;

	private Double minY;

	private Double maxY;

	private List<GraphElement> elements = new ArrayList<GraphElement>();

	private List<String> variables = new ArrayList<String>();

	public List<GraphElement> getElements() {
		if (elements == null) {
			elements = new ArrayList<GraphElement>();
		}
		return elements;
	}

	public void setElements(List<GraphElement> elements) {
		this.elements = elements;
	}
	
	public List<String> getVariables() {
		return variables;
	}

	public void setVariables(List<String> variables) {
		this.variables = variables;
	}

	@Override
	public GraphModel clone() {
		try {
			return (GraphModel) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}

	public Double getMinX() {
		return minX;
	}

	public void setMinX(Double minX) {
		this.minX = minX;
	}

	public Double getMaxX() {
		return maxX;
	}

	public void setMaxX(Double maxX) {
		this.maxX = maxX;
	}

	public Double getMinY() {
		return minY;
	}

	public void setMinY(Double minY) {
		this.minY = minY;
	}

	public Double getMaxY() {
		return maxY;
	}

	public void setMaxY(Double maxY) {
		this.maxY = maxY;
	}

}
