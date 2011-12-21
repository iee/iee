package org.eclipse.iee.sample.matrix.pad;

import java.io.Serializable;

import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.sample.matrix.FileStorage;
import org.eclipse.iee.sample.matrix.pad.model.Model;
import org.eclipse.iee.sample.matrix.pad.widget.MatrixWidget;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

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
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));
		//Test

		MatrixWidget matrix = new MatrixWidget(parent, new Model());
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
