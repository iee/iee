package org.eclipse.iee.pad.formula;

import org.eclipse.iee.core.document.PadDocumentPart;

public class SymbolicPart extends PadDocumentPart {

	private String formula;

	public String getFormula() {
		return formula != null ? formula : "";
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public SymbolicPart copy() {
		SymbolicPart clone = new SymbolicPart();
		clone.setFormula(getFormula());
		return clone;
	}
	
}
