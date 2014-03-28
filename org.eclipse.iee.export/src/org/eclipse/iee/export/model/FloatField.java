package org.eclipse.iee.export.model;

import com.google.gson.annotations.SerializedName;

public class FloatField extends Field {

	private String name;
	private boolean required;
	private FloatValidation validation;
	@SerializedName("sample_value")
	private double sampleValue;
	
	public FloatField() {
		super("float");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public FloatValidation getValidation() {
		return validation;
	}

	public void setValidation(FloatValidation validation) {
		this.validation = validation;
	}

	public double getSampeleValue() {
		return sampleValue;
	}

	public void setSampleValue(double sampeleValue) {
		this.sampleValue = sampeleValue;
	}
	
}
