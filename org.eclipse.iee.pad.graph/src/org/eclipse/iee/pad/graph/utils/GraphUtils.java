package org.eclipse.iee.pad.graph.utils;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class GraphUtils {

	public static double[][] parseArray(String arrayStr) throws IOException {
		StringReader reader = new StringReader(arrayStr);
		return parseArray(reader);
	}
	
	public static double[][] parseArray(Reader reader) throws IOException {
		List<double[]> parsed = new ArrayList<double[]>();
		readChar(reader, '{', true);
		double[] readPair;
		while ((readPair = readPair(reader)) != null) {
			parsed.add(readPair);
			readChar(reader, ',', false);
		}
		readChar(reader, '}', true);
		double[][] result = new double[parsed.size()][];
		for (int i = 0; i < parsed.size(); i++) {
			result[i] = parsed.get(i);
		}
		return result;
	}
	
	public static double[] readPair(Reader reader) throws IOException {
		double result[]; 
		if (readChar(reader, '{', false)) {
			result = new double[2];
			result[0] = readDouble(reader);
			readChar(reader, ',', true);
			result[1] = readDouble(reader);
			readChar(reader, '}', true);
		} else {
			result = null;
		}
		return result;
	}
	
	public static double readDouble(Reader reader) throws IOException {
		
		StringBuilder str = new StringBuilder();
		while (true) {
			reader.mark(1);
			int i = reader.read();
			if (i == -1) {
				break;
			} 
			char c = (char) i;
			if (Character.isDigit(c) || c == '.' || c =='-' || c == 'e' || c == 'E') {
				str.append(c);
			} else {
				reader.reset();
				break;
			}
		}
		return Double.parseDouble(str.toString());
	}
	
	public static boolean readChar(Reader reader, char character, boolean mandatory) throws IOException {
		while (true) {
			reader.mark(1);
			int i = reader.read();
			if (i == -1) {
				break;
			} 
			char c = (char) i;
			if (character == c) {
				return true;
			} else if (Character.isSpaceChar(c)) {
				continue;
			} else if (mandatory) {
				throw new IllegalArgumentException("Illegal symbol " + c);
			} else {
				reader.reset();
				return false;
			}
		}
		throw new IllegalArgumentException("Stream unexpectedly closed");
	}

	
}
