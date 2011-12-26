package org.eclipse.iee.sample.matrix.pad.view;

import org.eclipse.iee.sample.matrix.pad.model.Matrix;
import org.eclipse.iee.sample.matrix.pad.model.Model;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class MatrixView extends Composite {

	private Model fModel;
	
	private int fRowsNumber;
	private int fColumnsNumber;
	
	private ElementView[][] fElementViews;
	private String fImagePath = "D:\\MatrixPads\\an_id";

	public MatrixView(Composite parent, int style) {
		super(parent, style);
	}

	public MatrixView(Composite parent, Model model) {
		super(parent, SWT.NONE);
		
		fModel = model;
		
		fRowsNumber = model.getMatrix().getRowsNumber();
		fColumnsNumber = model.getMatrix().getRowsNumber();
		
		GridLayout matrixLayout = new GridLayout(fColumnsNumber, true);
		this.setLayout(matrixLayout);

		fElementViews = new ElementView[fRowsNumber][fColumnsNumber];
		createElementsViews();
	}
	
	protected void fullReload() {
		Matrix matrix = fModel.getMatrix();
		fRowsNumber = matrix.getRowsNumber();
		fColumnsNumber = matrix.getRowsNumber();
		
		// set widget size		
	}

	private void createElementsViews() {
		GridData elemGridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		for (int i = 0; i < fRowsNumber; i++) {
			for (int j = 0; j < fColumnsNumber; j++) {
				fElementViews[i][j] = new ElementView(this, i, j, true, fImagePath + "_" + i + "_" + j + ".jpg");
				fElementViews[i][j].setLayoutData(elemGridData);
			}
		}
	}
	
	
}
