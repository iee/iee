package org.eclipse.iee.sample.matrix.pad.view;

import org.eclipse.iee.sample.matrix.pad.controller.Controller;
import org.eclipse.iee.sample.matrix.pad.model.Matrix;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

public class MatrixView {

	private final int MAX_ROWS = 100;
	private final int MAX_COLLUMNS = 100;
	private ElementView[][] fElementViews = new ElementView[MAX_ROWS][MAX_COLLUMNS];

	private int fRowsNumber = 0;
	private int fColumnsNumber = 0;
	
	private int fSelectedRow = 0;
	private int fSeletedColumn = 0;
	
	private Controller fController;
	private Composite fComposite;

	public void setController(Controller controller) {
		fController = controller;
	}
	
	public void moveAbove(Composite composite) {
		fComposite.moveAbove(composite);
	}
	
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, true));
		
		/* Action buttons */
		createTempButtons(parent);
		
		/* Keys actions */
		createKeyListeners(parent);
		
		/* Matrix grid */
		fComposite = new Composite(parent, SWT.NONE);
		GridData gridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		fComposite.setLayoutData(gridData);
				
		updateLayout();
	}
	
	public void updateLayout() {
		fComposite.setLayout(new GridLayout(fColumnsNumber, true));
		fComposite.getParent().pack();
	}
	
	public void updateMatrix(Matrix matrix) {		
		updateMatrixSize(
			matrix.getRowsNumber(),
			matrix.getCollumnsNumber());
		
		createElementsPartControls();
		
		System.out.println(matrix.toString());
		
		for (int i = 0; i < fRowsNumber; i++) {
			for (int j = 0; j < fColumnsNumber; j++) {
				String newExpression = matrix.getElements()[i][j];
				ElementView elementView = fElementViews[i][j];
				if (!elementView.getExpression().equals(newExpression)) {
					elementView.setExression(newExpression);
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
				}
			}	
		}
		
		fRowsNumber = rows;
		fColumnsNumber = columns;
				
		updateLayout();
	}
	
	public void createElementsPartControls() {
		
		ElementView prev = null;
		
		for(int i = 0; i < fRowsNumber; i++) {
			for (int j = 0; j < fColumnsNumber; j++) {
				ElementView view = fElementViews[i][j];
				if (view.isDisposed()) {
					view.createPartControl(fComposite);
				}
				if (prev != null) {
					view.getComposite().moveBelow(
						prev.getComposite());
				}
				prev = view;
			}
		}
	}
	
	public void createTempButtons(Composite parent) {
		Composite sashForm = new SashForm(parent, SWT.HORIZONTAL);
		
		Button removeRowButton = new Button(sashForm, SWT.PUSH);
		removeRowButton.setText("-row");
		removeRowButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				fController.removeRow();
		    }
		    public void widgetDefaultSelected(SelectionEvent event) {}
		});
		
		Button addRowButton = new Button(sashForm, SWT.PUSH);
		addRowButton.setText("+row");
		addRowButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				fController.addRow();
		    }
		    public void widgetDefaultSelected(SelectionEvent event) {}
		});
		
		Button removeColumnButton = new Button(sashForm, SWT.PUSH);
		removeColumnButton.setText("-col");
		removeColumnButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				fController.removeCollumn();
		    }
		    public void widgetDefaultSelected(SelectionEvent event) {}
		});
		
		Button addColumnButton = new Button(sashForm, SWT.PUSH);
		addColumnButton.setText("+col");
		addColumnButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				fController.addCollumn();
		    }
		    public void widgetDefaultSelected(SelectionEvent event) {}
		});
		
		Button rollBackButton = new Button(sashForm, SWT.PUSH);
		rollBackButton.setText("<-");
		rollBackButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				fController.rollBack();
		    }
		    public void widgetDefaultSelected(SelectionEvent event) {}
		});
		
		Button rollFrontButton = new Button(sashForm, SWT.PUSH);
		rollFrontButton.setText("->");
		rollFrontButton.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				fController.rollFront();
		    }
		    public void widgetDefaultSelected(SelectionEvent event) {}
		});
	}
	
	public void createKeyListeners(Composite parent) {
		parent.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
								
				switch (e.keyCode) {
				case SWT.ARROW_LEFT:
					System.out.println("LEFT");
					break;
					
				case SWT.ARROW_RIGHT:
					System.out.println("RIGHT");
					break;
					
				case SWT.ARROW_UP:
					System.out.println("UP");
					break;
					
				case SWT.ARROW_DOWN:
					System.out.println("DOWN");
					break;
				}
				
			}
			
			@Override public void keyReleased(KeyEvent arg0) {}
		});
	}
}

