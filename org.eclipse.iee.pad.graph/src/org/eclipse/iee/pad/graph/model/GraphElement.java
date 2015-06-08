package org.eclipse.iee.pad.graph.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

import org.eclipse.iee.core.IHasPropertyChangeListener;

public class GraphElement implements Serializable, IHasPropertyChangeListener {

	private static final long serialVersionUID = 1L;

	private String function;

	private int numberOfPoints;

	private String color;
	
	private int width = 1;

	private GraphModel fGraph;
	
	private transient final PropertyChangeSupport fpcs = new PropertyChangeSupport(this);
	
	public String getFunction() {
		return function;
	}

	public void setFunction(String fFunction) {
		this.function = fFunction;
	}

	public int getNumberOfPoints() {
		return numberOfPoints;
	}

	public void setNumberOfPoints(int fDomainCardinality) {
		this.numberOfPoints = fDomainCardinality;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public GraphModel getGraph() {
		return fGraph;
	}
	
	void setGraph(GraphModel graph) {
		fGraph = graph;
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
