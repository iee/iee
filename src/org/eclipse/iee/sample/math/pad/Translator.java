package org.eclipse.iee.sample.math.pad;

import java.util.Map;
import java.util.TreeMap;

import org.eclipse.iee.sample.math.Activator;

public class Translator {
	
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
		String cached = fCachedItems.get(text);
		if (cached != null) {
			return cached;
		}
		
		// XXX Rewrite this
		
		String translated;
		try {
			String resultJava = Activator.getMole().translateMath(text);
			if (resultJava == null) {
				return null;
			}
			translated = resultJava.trim();
			if (translated.matches(";")) {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		fCachedItems.put(text, translated);
		return translated;
	}
}
