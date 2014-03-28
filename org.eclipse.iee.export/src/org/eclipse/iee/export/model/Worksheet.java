package org.eclipse.iee.export.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Worksheet {

	private List<Field> fields;

	public List<Field> getFields() {
		return Collections.unmodifiableList(getFieldsIntl());
	}

	private List<Field> getFieldsIntl() {
		if (fields == null) {
			fields = new ArrayList<>();
		}
		return fields;
	}
	
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public void addField(Field field) {
		getFieldsIntl().add(field);
	}

}