package org.eclipse.iee.sample.matrix.pad.model;

import java.util.Stack;

public class MatrixModel {	
	protected Stack<Matrix> fPreviousStates = new Stack<Matrix>();
	protected Stack<Matrix> fFutureStates = new Stack<Matrix>();
	
	/* Matrix represents the current state */
	protected Matrix fMatrix = new Matrix();
		
	/* Setters. Cause state shifting */
	
	public void setMatrixElement(int row, int collumn, String value) {
		saveState();
		fMatrix.setElement(row, collumn, value);
	}
	
	public void setMatrixSize(int rows, int collumns) {
		saveState();
		fMatrix = fMatrix.mutate(rows, collumns);
	}
	
	/* Getters */
	
	public final Matrix getMatrix() {
		return fMatrix;
	}
	
	public final String[][] getMatrixElements() {
		return fMatrix.getElements();
	}
	
	public final String getMatrixElement(int row, int collumn) {
		return fMatrix.getElements()[row][collumn];
	}

	
	/* State manipulation */
	
	protected void saveState() {
		fPreviousStates.push(fMatrix.copy());
		fFutureStates.clear();
	}
	
	public boolean rollBack() {
		if (fPreviousStates.isEmpty()) {
			return false;
		}
		
		fFutureStates.push(fMatrix);
		fMatrix = fPreviousStates.pop();
		
		return true;
	}
	
	public boolean rollFront() {
		if (fFutureStates.isEmpty()) {
			return false;
		}
		
		fPreviousStates.push(fMatrix);
		fMatrix = fFutureStates.pop();
		
		return true;
	}
}
