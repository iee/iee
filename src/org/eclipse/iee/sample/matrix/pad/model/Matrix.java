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
	}
	
	public Matrix(int rows, int collumns) {
		fRowsNumber = rows;
		fCollumnsNumber = collumns;		
		fElements = new String[fRowsNumber][fCollumnsNumber];
	}

	public Matrix(Matrix another, int rows, int collumns) {	
		fElements = new String[rows][collumns];
		
		for (int i = 0; i < rows; i++) {
			Arrays.fill(fElements[i], DEFAULT_VALUE);
		}
		
		for (int i = 0; i < Math.min(rows, another.getRowsNumber()); i++) {
			for (int j = 0; j < Math.min(collumns, another.getCollumnsNumber()); j++) {
				fElements[i][j] = another.getElements()[i][j];
			}
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
}
