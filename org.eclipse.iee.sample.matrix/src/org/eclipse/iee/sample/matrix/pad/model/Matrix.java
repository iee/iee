package org.eclipse.iee.sample.matrix.pad.model;

import java.util.Arrays;

public class Matrix implements Cloneable {
	public static final int DEFAULT_ROWS = 3;
	public static final int DEFAULT_COLLUMNS = 3;
	public static final String DEFAULT_VALUE = "0";
	
	protected String[][] fElements;
	protected int fRowsNumber;
	protected int fCollumnsNumber;

	public String[][] getElements() {
		return fElements;
	}
	
	public int getRowsNumber() {
		return fRowsNumber;
	}
	
	public int getCollumnsNumber() {
		return fCollumnsNumber;
	}
	
	public Matrix() {
		fRowsNumber = DEFAULT_ROWS;
		fCollumnsNumber = DEFAULT_COLLUMNS;
		fElements = new String[fRowsNumber][fCollumnsNumber];
		setZeroes();
	}
	
	public Matrix(int rows, int columns) {
		initElements(rows, columns);
	}

	public Matrix(Matrix another, int rows, int columns) {
		initElements(rows, columns);
		
		for (int i = 0; i < Math.min(rows, another.getRowsNumber()); i++) {
			for (int j = 0; j < Math.min(columns, another.getCollumnsNumber()); j++) {
				fElements[i][j] = another.getElements()[i][j];
			}
		}
	}
	
	protected void initElements(int rows, int columns) {
		fRowsNumber = rows;
		fCollumnsNumber = columns;
		fElements = new String[fRowsNumber][fCollumnsNumber];
		setZeroes();
	}
	
	public void setZeroes() {
		for (int i = 0; i < fRowsNumber; i++) {
			Arrays.fill(fElements[i], DEFAULT_VALUE);
		}
	}
	
	public void setElement(int row, int collumn, String value) {
		fElements[row][collumn] = value;
	}
	
	public Matrix copy() {
		return new Matrix(this, fRowsNumber, fCollumnsNumber);
	}
	
	public Matrix mutate(int rows, int collumns) {
		return new Matrix(this, rows, collumns);
	}

	@Override
	public String toString() {
		String result = "[\n";
		for (String[] row : fElements) {
			result += "\t";
			for (String element : row) {
				result += element + "\t";
			}
			result += "\n";
		}
		return result + "]\n";
	}
}
