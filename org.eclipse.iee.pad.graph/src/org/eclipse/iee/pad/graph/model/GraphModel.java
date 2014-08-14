/**
 * 
 */
package org.eclipse.iee.pad.graph.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GraphModel implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	
	private transient final PropertyChangeSupport fpcs = new PropertyChangeSupport(this);
	
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
		Double oldValue = this.minX;
		this.minX = minX;
		getPropertyChangeSupport().firePropertyChange("minX", oldValue, minX);
	}

	public Double getMaxX() {
		return maxX;
	}

	public void setMaxX(Double maxX) {
		Double oldValue = this.maxX;
		this.maxX = maxX;
		getPropertyChangeSupport().firePropertyChange("maxX", oldValue, maxX);
	}

	public Double getMinY() {
		return minY;
	}

	public void setMinY(Double minY) {
		Double oldValue = this.minY;
		this.minY = minY;
		getPropertyChangeSupport().firePropertyChange("minY", oldValue, minY);
	}

	public Double getMaxY() {
		return maxY;
	}

	public void setMaxY(Double maxY) {
		Double oldValue = this.maxY;
		this.maxY = maxY;
		getPropertyChangeSupport().firePropertyChange("maxY", oldValue, maxY);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		fpcs.addPropertyChangeListener(listener);
	}
	
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		fpcs.removePropertyChangeListener(listener);
	}
	
	protected PropertyChangeSupport getPropertyChangeSupport() {
		return fpcs;
	}

}
