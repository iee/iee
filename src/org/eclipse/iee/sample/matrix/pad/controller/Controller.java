package org.eclipse.iee.sample.matrix.pad.controller;

import org.eclipse.iee.sample.matrix.pad.MatrixPad;
import org.eclipse.iee.sample.matrix.pad.Translator;
import org.eclipse.iee.sample.matrix.pad.model.MatrixModel;
import org.eclipse.iee.sample.matrix.pad.view.MatrixView;

public class Controller {
	
	MatrixPad fMatrixPad;
	MatrixModel fMatrixModel;
	MatrixView fMatrixView;
	
	public Controller(MatrixPad pad, MatrixModel model, MatrixView view) {
		fMatrixPad = pad;
		fMatrixModel = model;
		fMatrixView = view;
	}
		
	/* Matrix resize actions */
	
	public boolean canAddRow() {
		return true;
	}
	
	public void addRow() {
		fMatrixModel.setMatrixSize(
			fMatrixModel.getMatrix().getRowsNumber() + 1,
			fMatrixModel.getMatrix().getCollumnsNumber());
		updateView();
	}
	
	public boolean canRemoveRow() {
		return fMatrixModel.getMatrix().getRowsNumber() > 1;
	}
	
	public void removeRow() {
		fMatrixModel.setMatrixSize(
			fMatrixModel.getMatrix().getRowsNumber() - 1,
			fMatrixModel.getMatrix().getCollumnsNumber());
		updateView();
	}
	
	public boolean canAddCollumn() {
		return true;
	}
	
	public void addCollumn() {
		fMatrixModel.setMatrixSize(
			fMatrixModel.getMatrix().getRowsNumber(),
			fMatrixModel.getMatrix().getCollumnsNumber() + 1);
		updateView();
	}
	
	public boolean canRemoveCollumn() {
		return fMatrixModel.getMatrix().getCollumnsNumber() > 1;
	}
	
	public void removeCollumn() {
		fMatrixModel.setMatrixSize(
			fMatrixModel.getMatrix().getRowsNumber(),
			fMatrixModel.getMatrix().getCollumnsNumber() - 1);
		updateView();
	}
	
	
	/* Modification actions */
	
	public void setElementValue(int i, int j, String value) {
		fMatrixModel.setMatrixElement(i, j, value);
		updateView();
	}
			
	public void rollBack() {
		fMatrixModel.rollBack();
		updateView();
	}
	
	
	public void rollFront() {
		fMatrixModel.rollFront();
		updateView();
	}
	
	/* External actions */
	public void selectCurrentPad() {
		fMatrixPad.moveCaretToCurrentPad();
	}
	
	/* Code generation */
	
	public boolean validateExpression(String expression) {
		return Translator.isTextValid(expression);
	}
		
	public void updateView() {
		fMatrixView.updateMatrix(fMatrixModel.getMatrix());
	}
}