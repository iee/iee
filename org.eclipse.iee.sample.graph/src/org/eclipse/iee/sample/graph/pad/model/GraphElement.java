package org.eclipse.iee.sample.graph.pad.model;

import java.io.Serializable;

public class GraphElement implements Serializable {

	private static final long serialVersionUID = 1L;

	private String function;

	private int numberOfPoints;

	private String color;
	
	private int width;
	
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
	
}
