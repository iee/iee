package org.eclipse.iee.sample.matrix.pad;

import java.util.TreeMap;

import org.eclipse.iee.sample.matrix.Activator;
import org.eclipse.iee.sample.matrix.pad.model.Matrix;

public class Translator {
	
	protected TreeMap<String, String> fCachedItems;

	public boolean validateElement(String text) {
		if (fCachedItems.containsKey(text)) {
			return true;
		}

		// XXX perform validation here
		return true;
	}
		
	public String translateMatrix(final Matrix matrix) {

		/* Array declaration */
		
		String declaration =
			"new double[" +	matrix.getRowsNumber() + "][" +	matrix.getCollumnsNumber() + "]=";
		
		/* Elements */
				
		String elements = "{";
		
		for (String[] row : matrix.getElements()) {
			elements += "{";
			for (String element : row) {
				String translated = translateElement(element);
				if (translated == null) {
					return null;
				}
				elements += translated + ",";
			}
			elements += "},";
		}
		
		elements += "};";

		return declaration + elements;
	}
	
	public String translateElement(String text) {
		String cached = fCachedItems.get(text);
		if (cached != null) {
			return cached;
		}
		
		// XXX Rewrite this
		
		String translated = "Test";
		try {
			String resultJava = Activator.getMole().translateMath(text);
			translated = resultJava.trim();
			if (translated.matches(";")) {
				translated = "";
			}			
		} catch (Exception e) {
			translated = "";
			e.printStackTrace();
		}		

		fCachedItems.put(text, translated);
		return translated;
	}
}
