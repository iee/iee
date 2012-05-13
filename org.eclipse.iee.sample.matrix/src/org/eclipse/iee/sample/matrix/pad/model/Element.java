package org.eclipse.iee.sample.matrix.pad.model;

public class Element implements Cloneable {
	
	private int fRow;
	private int fColumn;
	
	private String fExpression = "0";
	private String fLastValidText = "0";
	
	/*
	 * Getters/Setters
	 */
	
	public int getRow() {
		return fRow;
	}

	public void setRow(int row) {
		this.fRow = row;
	}

	public int getColumn() {
		return fColumn;
	}

	public void setColumn(int column) {
		this.fColumn = column;
	}

	public String getExpression() {
		return fExpression;
	}

	public void setExpression(String expression) {
		this.fExpression = expression;
	}

	public String getLastValidText() {
		return fLastValidText;
	}

	public void setLastValidText(String lastValidText) {
		this.fLastValidText = lastValidText;
	}

	
	
	public Element() {
		
	}
	
}
