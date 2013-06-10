package org.eclipse.iee.sample.graph.pad.model;

import java.io.Serializable;

public class GraphElement implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fFunction;
	private double fDomainMin;
	private double fDomainMax;
	private int fDomainCardinality;

	public String getfFunction() {
		return fFunction;
	}

	public void setfFunction(String fFunction) {
		this.fFunction = fFunction;
	}

	public double getfDomainMin() {
		return fDomainMin;
	}

	public void setfDomainMin(double fDomainMin) {
		this.fDomainMin = fDomainMin;
	}

	public double getfDomainMax() {
		return fDomainMax;
	}

	public void setfDomainMax(double fDomainMax) {
		this.fDomainMax = fDomainMax;
	}

	public int getfDomainCardinality() {
		return fDomainCardinality;
	}

	public void setfDomainCardinality(int fDomainCardinality) {
		this.fDomainCardinality = fDomainCardinality;
	}

}
