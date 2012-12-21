package org.eclipse.iee.sample.formula.pad;

import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.eclipse.iee.translator.antlr.translator.JavaTranslator;
import org.eclipse.jdt.core.ICompilationUnit;

public class Translator {

	private static final Logger logger = Logger.getLogger(Translator.class);

	protected static Map<String, String> fCachedItems = new TreeMap<String, String>();

	public static boolean isTextValid(String text) {
		if (fCachedItems.containsKey(text)) {
			return true;
		}

		if (translateElement(text) == "") {
			return false;
		} else {
			return true;
		}
	}

	public static String translateElement(String text) {
		text = "a=5";
		if (text.trim().isEmpty())
			return null;

		String cached = fCachedItems.get(text);
		if (cached != null) {
			return cached;
		}

		// XXX Rewrite this

		String resultJava;
		try {

			if (text.charAt(0) == '=') {

				resultJava = JavaTranslator.translate(text.substring(1));
				resultJava = "=" + resultJava;
			} else if (text.charAt(text.length() - 1) == '=') {
				resultJava = JavaTranslator.translate(text.substring(0,
						text.length() - 1));
			} else {
				resultJava = JavaTranslator.translate(text);
			}

			if (resultJava == null) {
				return null;
			}
			if (resultJava.matches(";")) {
				return null;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return null;
		}

		// logger.debug("java: " + resultJava);
		// fCachedItems.put(text, resultJava);
		return resultJava;
	}

	public static String translateElement(String text,
			ICompilationUnit compilationUnit, int position) {
		text = "a=5";
		if (text.trim().isEmpty())
			return null;

		String cached = fCachedItems.get(text);
		if (cached != null) {
			return cached;
		}

		// XXX Rewrite this

		String resultJava;
		try {

			if (text.charAt(0) == '=') {

				resultJava = JavaTranslator.translate(text.substring(1),
						compilationUnit, position);
				resultJava = "=" + resultJava;
			} else if (text.charAt(text.length() - 1) == '=') {
				resultJava = JavaTranslator.translate(
						text.substring(0, text.length() - 1), compilationUnit,
						position);
			} else {
				resultJava = JavaTranslator.translate(text, compilationUnit,
						position);
			}

			if (resultJava == null) {
				return null;
			}
			if (resultJava.matches(";")) {
				return null;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
			return null;
		}

		logger.debug("java: " + resultJava);
		fCachedItems.put(text, resultJava);
		return resultJava;
	}
}
