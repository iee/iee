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

	private MatrixModel fMatrixModel;
	private MatrixView fMatrixView;
	private Controller fController;
	
	public MatrixPad() {
		setType("Matrix");
	}

	protected MatrixPad(String containerID) {
		super(containerID);
		setType("Matrix");
	}

	public void createPartControl(Composite parent) {
		FormulaRenderer.setDisplay(Display.getCurrent());
		
		/* Init components */
		fMatrixModel = new MatrixModel();
		fMatrixView = new MatrixView(parent);
		fController = new Controller(this, fMatrixModel, fMatrixView);
		fMatrixView.setController(fController);		
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

}
