package org.eclipse.iee.sample.matrix.pad.widget;

import org.eclipse.iee.sample.matrix.pad.model.Model;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class MatrixWidget extends Composite {

	private Model fModel;
	
	private int fRowsNumber;
	private int fColumnsNumber;
	
	private MatrixEntry[][] fEntries;
	private String fImagePath = "D:\\MatrixPads\\an_id";

	public MatrixWidget(Composite parent, int style) {
		super(parent, style);
	}

	public MatrixWidget(Composite parent, Model model) {
		super(parent, SWT.NONE);
		
		fModel = model;
		
		fRowsNumber = model.getMatrix().getRowsNumber();
		fColumnsNumber = model.getMatrix().getRowsNumber();
		
		GridLayout matrixLayout = new GridLayout(fColumnsNumber, true);
		this.setLayout(matrixLayout);

		fEntries = new MatrixEntry[fRowsNumber][fColumnsNumber];
		initEntries(this, SWT.NONE);
	}

	private void initEntries(Composite parent, int style) {
		for (int i = 0; i < fRowsNumber; i++) {
			for (int j = 0; j < fColumnsNumber; j++) {
				fEntries[i][j] = new MatrixEntry(parent, style, i, j, true, fImagePath + "_" + i + "_" + j + ".jpg");
			}
		}
	}
	
	
}
