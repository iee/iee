package org.eclipse.iee.sample.formula.pad;

import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.eclipse.iee.editor.core.container.Container;
import org.eclipse.iee.sample.formula.FormulaPadManager;

public class Translator {
	
	private static final Logger logger = Logger.getLogger(Translator.class);
	
	protected static Map<String, String> fCachedItems = new TreeMap<String, String>();

	public static boolean isTextValid(String text) {
		if (fCachedItems.containsKey(text)) {
			return true;
		}
		
		if (translateElement(text) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public static String translateElement(String text) {
		if (text.trim().isEmpty())
			return null;
		
		String cached = fCachedItems.get(text);
		if (cached != null) {
			return cached;
		}
		
		// XXX Rewrite this
		
		String translated;
		try {
			String resultJava = "";
			
			if (text.charAt(0) == '=')
			{
				resultJava = FormulaPadManager.getMole().translateMath(text.substring(1));
				resultJava = "=" + resultJava;
			}
			else if (text.charAt(text.length() - 1) == '=')
			{
				resultJava = FormulaPadManager.getMole().translateMath(text.substring(0, text.length() - 1));
			}
			else  
			{
				resultJava = FormulaPadManager.getMole().translateMath(text);
			}

			if (resultJava == null) {
				return null;
			}
			translated = resultJava.trim();
			if (translated.matches(";")) {
				return null;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return null;
		}
		
		logger.debug("java: " + translated);
		fCachedItems.put(text, translated);
		return translated;
	}
}
