package org.eclipse.iee.core.utils;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.List;

import com.google.common.base.Throwables;
import com.google.common.collect.Lists;

public class ArrayUtils {

	public static double[][] parseArray(String str) {
		StringReader stringReader = new StringReader(str);
		try {
			return parseArray(stringReader);
		} catch (IOException e) {
			throw Throwables.propagate(e);
		}
	}
	
	public static double[][] parseArray(StringReader reader) throws IOException {
		StreamTokenizer st = new StreamTokenizer(reader);
		readChar(st, '[');
		List<double[]> arrs = Lists.newArrayList();
		arrs.add(parseInnerArray(st));
		while (readOptionalChar(st, ',')) {
			arrs.add(parseInnerArray(st));
		}
		readChar(st, ']');
		
		double[][] result = new double[arrs.size()][];
		for (int i = 0; i < arrs.size(); i++) {
			result[i] = arrs.get(i);
		}
		return result;
	}
	
	private static void readChar(StreamTokenizer st, char c) throws IOException {
		int nextToken = st.nextToken();
		if (nextToken != c) {
			throw new IllegalArgumentException("Unexpected token " + (char) nextToken + " expected " + c);
		}
	}
	
	private static boolean readOptionalChar(StreamTokenizer st, char c) throws IOException {
		int nextToken = st.nextToken();
		if (nextToken != c) {
			st.pushBack();
			return false;
		}
		return true;
	}
	
	private static double[] parseInnerArray(StreamTokenizer st) throws IOException {
		readChar(st, '[');
		List<Double> doubles = Lists.newArrayList();
		doubles.add(readDouble(st));
		while (readOptionalChar(st, ',')) {
			doubles.add(readDouble(st));
		}
		readChar(st, ']');
		double[] result = new double[doubles.size()];
		for (int i = 0; i < doubles.size(); i++) {
			result[i] = doubles.get(i);
		}
		return result;
	}
	
	private static double readDouble(StreamTokenizer st) throws IOException {
		if (st.nextToken() != StreamTokenizer.TT_NUMBER) {
			throw new IllegalArgumentException("Expected number");
		}
		return st.nval;
	}
	
	
	public static void main(String[] args) throws IOException {
		double[][] parseArray = parseArray("[[1,2,3,8],[3,4,2],[3,4,2],[3,4,2],[3,4,2]]");
		for (int i = 0; i < parseArray.length; i++) {
			System.out.print(i + ": {");
			double[] inner = parseArray[i];
			for (double d : inner) {
				System.out.print(d + ", ");
			}
			System.out.println(" }");
		}
	}
	
}
