package org.eclipse.iee.sample.matrix.pad;

import java.io.Serializable;

import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.sample.matrix.storage.FileStorage;
import org.eclipse.iee.sample.matrix.pad.controller.Controller;
import org.eclipse.iee.sample.matrix.pad.model.MatrixModel;
import org.eclipse.iee.sample.matrix.pad.view.MatrixView;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class MatrixPad extends Pad implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private transient static final int STATE_MENU = 0;
	private transient static final int STATE_INTERACTIVE = 1;
	private transient static final int STATE_STATIC = 2;
	private transient static final int STATE_TABLE = 1;
	
	private MatrixModel fMatrixModel;
	private MatrixView fMatrixView;
	private Controller fController;
	private int fCurrentState;
	
	public MatrixPad() {
		init();
	}

	protected MatrixPad(String containerID) {
		super();
		init();
	}
	
	protected void init() {
		FormulaRenderer.setDisplay(Display.getCurrent());
		
		fMatrixModel = new MatrixModel();
		fMatrixView = new MatrixView();
		fController = new Controller(this, fMatrixModel, fMatrixView);
		fMatrixView.setController(fController);
	}

	public void createPartControl(Composite parent) {
		fMatrixView.createPartControl(parent);
		fController.updateView();
	}
		
	@Override
	public Pad copy() {
		return new MatrixPad();
	}

	@Override
	public void save() {
		FileStorage.getInstance().saveToFile(this);
	}

	@Override
	public void unsave() {
		FileStorage.getInstance().removeFile(getContainerID());
	}

	@Override
	public void onContainerAttached() {
	}

	@Override
	public void activate() {
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
