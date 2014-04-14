package org.eclipse.iee.pad.formula;

import org.eclipse.iee.core.document.Property;

public class InputValidation {

	@Property(name = "Min", description = "Minimal value")
	private Double min;
	
	@Property(name = "Max", description = "Maximal value")
	private Double max;

	public Double getMin() {
		return min;
	}

	public void setMin(Double min) {
		this.min = min;
	}

	public Double getMax() {
		return max;
	}

	public void setMax(Double max) {
		this.max = max;
	}
	
}
