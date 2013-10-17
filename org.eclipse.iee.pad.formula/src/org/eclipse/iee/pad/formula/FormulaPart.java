package org.eclipse.iee.pad.formula;

import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.translator.antlr.translator.TexTranslator;

public class FormulaPart extends PadDocumentPart {

	private String formula;

	public String getFormula() {
		return formula != null ? formula : "";
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public static String translateToLatex(String text) {
		String latex = "";
	
		if (text.length() == 0)
			return latex;
		
		/* Translating to Latex */
		if (text.charAt(0) == '=') {
			latex = TexTranslator.translate(text.substring(1));
			latex = "=" + latex;
		} else if (text.charAt(text.length() - 1) == '=') {
			latex = TexTranslator
					.translate(text.substring(0, text.length() - 1));
			latex = latex + "=";
		} else {
			latex = TexTranslator.translate(text);
		}
		return latex;
	}

	public FormulaPart copy() {
		FormulaPart clone = new FormulaPart();
		clone.setFormula(getFormula());
		return clone;
	}

}
