package org.eclipse.iee.sample.matrix.pad.view;

import org.eclipse.iee.sample.matrix.pad.controller.Controller;
import org.eclipse.iee.sample.matrix.pad.model.Matrix;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

public class MatrixView {

	private final int MAX_ROWS = 100;
	private final int MAX_COLLUMNS = 100;
	private ElementView[][] fElementViews = new ElementView[MAX_ROWS][MAX_COLLUMNS];

	private int fRowsNumber = 0;
	private int fColumnsNumber = 0;
	
	private Controller fController;
	private Composite fComposite;
	private GridLayout fLayout;

	public void setController(Controller controller) {
		fController = controller;
	}
	
	public MatrixView(Composite parent) {
		createPartControl(parent);
	}
	
	public void createPartControl(Composite parent) {
		fComposite = new Composite(parent, SWT.NONE);
		fLayout = new GridLayout(fColumnsNumber, true);
		fComposite.setLayout(fLayout);
	}
	
	public void updateMatrix(Matrix matrix) {
		updateMatrixSize(
			matrix.getRowsNumber(),
			matrix.getCollumnsNumber());

		System.out.println(matrix.toString());
		
		for (int i = 0; i < fRowsNumber; i++) {
			for (int j = 0; j < fColumnsNumber; j++) {
				
				String newExpression = matrix.getElements()[i][j];
				ElementView elementView = fElementViews[i][j];
				if (!elementView.getExpression().equals(newExpression)) {
					elementView.setExression(newExpression);
					//updateView element 
				}
			}
		}
	}
	
	public void updateMatrixSize(int rows, int columns) {
		if (rows < fRowsNumber) {
			/* Remove rows */
			for (int i = rows; i < fRowsNumber; i++) {
				for (int j = 0; j < fColumnsNumber; j++) {
					fElementViews[i][j].dispose();
					fElementViews[i][j] = null;
				}
			}
		} else if (rows > fRowsNumber) {
			/* Add rows */
			for (int i = fRowsNumber; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					fElementViews[i][j] = new ElementView(fController, i, j);
					fElementViews[i][j].createPartControl(fComposite);
				}
			}
		}
		
		if (columns < fColumnsNumber) {
			/* Remove collumns */
			for (int i = 0; i < fRowsNumber; i++) {
				for (int j = columns; j < fColumnsNumber; j++) {
					fElementViews[i][j].dispose();
					fElementViews[i][j] = null;
				}
			}
		} else if (columns > fColumnsNumber) {
			/* Add columns */
			for (int i = 0; i < rows; i++) {
				for (int j = fColumnsNumber; j < columns; j++) {
					fElementViews[i][j] = new ElementView(fController, i, j);
					fElementViews[i][j].createPartControl(fComposite);
				}
			}
		}
		
		fRowsNumber = rows;
		fColumnsNumber = columns;
		
		
		Button s = new Button(c, SWT.PUSH);
	    s.setText("Special " + index[0]);
	    index[0]++;
	    Control[] children = c.getChildren();
	    s.moveAbove(children[3]);
	    shell.layout(new Control[] { s });
		
		fLayout.numColumns = fColumnsNumber;
		fComposite.setLayout(fLayout);
	}
		
	public void updateElementViews(int rows, int collumns) {
		
	}
		
	public void render() {
		
	}
}
