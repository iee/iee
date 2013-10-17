package org.eclipse.iee.pad.fem3d;

import org.eclipse.iee.core.document.PadDocumentPart;

public class Fem3DPart extends PadDocumentPart {

	private String fModelVariable = "";

	public Fem3DPart() {
		this(null);
	}
	public Fem3DPart(String modelVariable) {
		this.fModelVariable = modelVariable;
	}

	public String getModelVariable() {
		return fModelVariable;
	}

	public void setModelVariable(String modelVariable) {
		fModelVariable = modelVariable;
	}
	
	public Fem3DPart copy() {
		Fem3DPart newPad = new Fem3DPart();
		newPad.fModelVariable = this.fModelVariable;
		return newPad;
	}
}
