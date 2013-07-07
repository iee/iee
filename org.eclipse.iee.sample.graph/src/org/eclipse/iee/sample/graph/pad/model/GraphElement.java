package org.eclipse.iee.sample.graph.pad.model;

import java.io.Serializable;

public class GraphElement implements Serializable {

	private static final long serialVersionUID = 1L;

	private String function;

	private int numberOfPoints;

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

}
