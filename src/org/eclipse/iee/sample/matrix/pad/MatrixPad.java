package org.eclipse.iee.sample.matrix.pad;

import java.io.Serializable;

import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.sample.matrix.FileStorage;
import org.eclipse.iee.sample.matrix.pad.model.Model;
import org.eclipse.iee.sample.matrix.pad.view.MatrixView;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

public class MatrixPad extends Pad implements Serializable {

	private static final long serialVersionUID = 1L;

	private transient static FileStorage fFileStorage;
	private String fImagePath;
	private String fJavaContent;

	public MatrixPad() {
		fImagePath = fFileStorage.getDirectoryPath() + this.getContainerID() + ".jpg";
		setType("Matrix");
	}

	protected MatrixPad(String containerID) {
		super(containerID);		
		fImagePath = fFileStorage.getDirectoryPath() + this.getContainerID() + ".jpg";
		setType("Matrix");
	}

	public void createPartControl(Composite parent) {
		
		FormulaRenderer.setDisplay(Display.getCurrent());
		
		
		
		//parent.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridLayout padLayout = new GridLayout(1, true);
		parent.setLayout(padLayout);
		
		//Test

		MatrixView matrix = new MatrixView(parent, new Model());
		GridData matrixGridData = new GridData(GridData.FILL, GridData.FILL, true, true);
		matrix.setLayoutData(matrixGridData);
	}

	public static void setStorage(FileStorage fStorage) {
		MatrixPad.fFileStorage = fStorage;
	}

	@Override
	public Pad copy() {
		return new MatrixPad();
	}

	@Override
	public void save() {
		MatrixPad.fFileStorage.saveToFile(this);
	}

	@Override
	public void unsave() {
		MatrixPad.fFileStorage.removeFile(getContainerID() + ".jpg");
	}

	@Override
	public void onContainerAttached() {
		getContainer().setTextContent(fJavaContent);
	}

}
