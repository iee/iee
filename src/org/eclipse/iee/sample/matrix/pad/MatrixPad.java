package org.eclipse.iee.sample.matrix.pad;

import java.io.Serializable;

import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.sample.matrix.FileStorage;
import org.eclipse.iee.sample.matrix.widget.MatrixWidget;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class MatrixPad extends Pad implements Serializable {

	private static final long serialVersionUID = 1L;

	private transient static FileStorage fFileStorage;

	private String fLatexContent;
	private String fJavaContent;
	private String fImagePath;
	private boolean fIsImage;

	public MatrixPad() {
		super();
		fLatexContent = "";
		fJavaContent = "";
		fImagePath = fFileStorage.getDirectoryPath() + this.getContainerID()
				+ ".jpg";
		fIsImage = false;
		setType("Matrix");
	}

	protected MatrixPad(String containerID) {
		super(containerID);
		fLatexContent = "";
		fJavaContent = "";
		fImagePath = fFileStorage.getDirectoryPath() + this.getContainerID()
				+ ".jpg";
		fIsImage = false;
		setType("Matrix");
	}

	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout(SWT.HORIZONTAL));
		//Test
		MatrixWidget matrix = new MatrixWidget(parent, SWT.NONE, 3, 3);
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
		MatrixPad.fFileStorage.removeFile(getContainerID());
	}

	@Override
	public void onContainerAttached() {
		getContainer().setTextContent(fJavaContent);
	}

}
