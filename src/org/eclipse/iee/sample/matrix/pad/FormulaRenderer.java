package org.eclipse.iee.sample.matrix.pad;

import java.util.Map;
import java.util.TreeMap;

import org.eclipse.iee.sample.matrix.Activator;
import org.eclipse.swt.graphics.Image;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

public class FormulaRenderer {
	protected Map<String, Image> fCachedImages = new TreeMap<String, Image>();
	
	public Image getImage(String text) {
		Image formula = fCachedImages.get(text);
		if (formula != null) {
			return formula;
		}
		
		/*
		try {
			String resultTex = Activator.getMolex().translateMath(text);
			String hidden = resultTex.trim();
			fLatexContent = hidden;
			System.out.println(fLatexContent);
			TeXFormula texFormula = new TeXFormula(fLatexContent);
			texFormula.createJPEG(TeXConstants.STYLE_DISPLAY, 60,
					fImagePath, java.awt.Color.white,
					java.awt.Color.black);
		} catch (Exception e1) {
			fLatexContent = "";
			e1.printStackTrace();
		}*/
		
		// XXX generate image here
		
		return null;
	}	
}
