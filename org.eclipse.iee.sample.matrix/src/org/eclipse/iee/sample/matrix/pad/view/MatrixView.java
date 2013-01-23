package org.eclipse.iee.sample.matrix.pad.view;

import org.eclipse.iee.sample.matrix.pad.controller.Controller;
import org.eclipse.iee.sample.matrix.pad.model.Matrix;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

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
		parent.setLayout(new GridLayout(3, true));

		/* Action buttons */
		createMenu(parent);

		/* Keys actions */
		createKeyListeners(parent);

		/* Matrix grid */
		Label leftBracket = new Label(parent, SWT.RESIZE | SWT.FILL);
		leftBracket.setText("Left");

		GridData leftBracketGridData = new GridData(SWT.RIGHT,
				SWT.FILL, true, true);
		leftBracket.setLayoutData(leftBracketGridData);

		fComposite = new Composite(parent, SWT.RESIZE | SWT.FILL);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true,
				true);
		fComposite.setLayoutData(gridData);

		Label rightBracket = new Label(parent, SWT.RESIZE | SWT.FILL);
		rightBracket.setText("Right");

		GridData rightBracketGridData = new GridData(SWT.FILL,
				SWT.FILL, true, true);
		rightBracket.setLayoutData(rightBracketGridData);

		updateLayout();
	}

	public void updateLayout() {
		fComposite.setLayout(new GridLayout(fColumnsNumber, true));
		fComposite.getParent().pack();
	}

	public void updateMatrix(Matrix matrix) {
		updateMatrixSize(matrix.getRowsNumber(), matrix.getCollumnsNumber());

		createElementsPartControls();

		System.out.println(matrix.toString());

		for (int i = 0; i < fRowsNumber; i++) {
			for (int j = 0; j < fColumnsNumber; j++) {
				String newExpression = matrix.getElements()[i][j];
				ElementView elementView = fElementViews[i][j];
				if (!elementView.getExpression().equals(newExpression)) {
					elementView.setExpression(newExpression);
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

		for (int i = 0; i < fRowsNumber; i++) {
			for (int j = 0; j < fColumnsNumber; j++) {
				ElementView view = fElementViews[i][j];
				if (view.isDisposed()) {
					view.createPartControl(fComposite);
				}
				if (prev != null) {
					view.getComposite().moveBelow(prev.getComposite());
				}
				prev = view;
			}
		}
	}

	public void createMenu(Composite parent) {
		Label menuLabel = new Label(parent, SWT.NONE);
		menuLabel.setText("Menu");
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true,
				true);
		gridData.horizontalSpan = 3;
		menuLabel.setLayoutData(gridData);

		final Menu menuBar = new Menu(menuLabel);
		MenuItem removeRowMenu = new MenuItem(menuBar, SWT.PUSH);
		removeRowMenu.setText("&-row");
		removeRowMenu.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				fController.removeRow();
			}

			public void widgetDefaultSelected(SelectionEvent event) {
			}
		});

		MenuItem addRowMenu = new MenuItem(menuBar, SWT.PUSH);
		addRowMenu.setText("&+row");
		addRowMenu.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				fController.addRow();
			}

			public void widgetDefaultSelected(SelectionEvent event) {
			}
		});

		MenuItem removeColumnMenu = new MenuItem(menuBar, SWT.PUSH);
		removeColumnMenu.setText("&-col");
		removeColumnMenu.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				fController.removeCollumn();
			}

			public void widgetDefaultSelected(SelectionEvent event) {
			}
		});

		MenuItem addColumnMenu = new MenuItem(menuBar, SWT.PUSH);
		addColumnMenu.setText("&+col");
		addColumnMenu.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				fController.addCollumn();
			}

			public void widgetDefaultSelected(SelectionEvent event) {
			}
		});

		MenuItem rollBackMenu = new MenuItem(menuBar, SWT.PUSH);
		rollBackMenu.setText("&<-");
		rollBackMenu.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				fController.rollBack();
			}

			public void widgetDefaultSelected(SelectionEvent event) {
			}
		});

		MenuItem rollFrontMenu = new MenuItem(menuBar, SWT.PUSH);
		rollFrontMenu.setText("&->");
		rollFrontMenu.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				fController.rollFront();
			}

			public void widgetDefaultSelected(SelectionEvent event) {
			}
		});

		menuLabel.addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent e) {
				menuBar.setVisible(true);
			}

			@Override
			public void mouseDown(MouseEvent e) {
			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {
			}
		});

		menuLabel.setMenu(menuBar);

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

				case SWT.ESC:
					System.out.println("ESC");
					break;
				}

			}

			@Override
			public void keyReleased(KeyEvent arg0) {
			}
		});
	}
}
