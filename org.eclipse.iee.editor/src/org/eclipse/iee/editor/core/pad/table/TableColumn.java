package org.eclipse.iee.editor.core.pad.table;

import org.eclipse.iee.core.document.DocumentPart;
import org.eclipse.iee.core.document.PropertiesContainer;
import org.eclipse.iee.core.document.Property;
import org.eclipse.iee.pad.formula.InputValidation;

public class TableColumn extends DocumentPart {

	@Property(name = "Header", description = "Column title")
	private String header;
	
	@PropertiesContainer(name = "Validation", description = "Validation")
	private InputValidation validation;

	public TableColumn() {
	}
	
	public TableColumn(String header) {
		setHeader(header);
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		String oldValue = header;
		this.header = header;
		getPropertyChangeSupport().firePropertyChange("header", oldValue, header);
	}

	public InputValidation getValidation() {
		return validation;
	}

	public void setValidation(InputValidation validation) {
		this.validation = validation;
	}
	
}
