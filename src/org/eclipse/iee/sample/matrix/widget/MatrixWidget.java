package org.eclipse.iee.sample.matrix.widget;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class MatrixWidget extends Composite {

	private int fRowsNumber;
	private int fColumnsNumber;
	private MatrixEntry[][] fEntries;
	private String fImagePath = "D:\\MatrixPads\\an_id";

	public MatrixWidget(Composite parent, int style) {
		super(parent, style);
	}

	public MatrixWidget(Composite parent, int style, int rowsNumber,
			int columnsNumber) {
		super(parent, style);
		GridLayout matrixLayout = new GridLayout(columnsNumber, true);
		this.setLayout(matrixLayout);

		fRowsNumber = rowsNumber;
		fColumnsNumber = columnsNumber;
		fEntries = new MatrixEntry[rowsNumber][columnsNumber];
		initEntries(this, SWT.NONE);
	}

	private void initEntries(Composite parent, int style) {
		for (int i = 0; i < fRowsNumber; i++)
			for (int j = 0; j < fColumnsNumber; j++) {
				fEntries[i][j] = new MatrixEntry(parent, style, i, j, true, fImagePath + "_" + i + "_" + j + ".jpg");
			}
	}

	/*
	 * Getters/Setters
	 */

	public int getRowsNumber() {
		return fRowsNumber;
	}

	public void setRowsNumber(int number) {
		fRowsNumber = number;
	}

	public int getColumnsNumber() {
		return fColumnsNumber;
	}

	public void setColumnsNUmber(int number) {
		fColumnsNumber = number;
	}

}
