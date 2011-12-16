package org.eclipse.iee.sample.matrix.pad;

import java.io.Serializable;

import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class MatrixPad extends Pad implements Serializable {

	private static final long serialVersionUID = 1L;

	public MatrixPad() {
		super();
	}

	protected MatrixPad(String containerID) {
		super(containerID);
	}

	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());
	}

	@Override
	public Pad copy() {
		return new MatrixPad();
	}

	@Override
	public void save() {

	}

	@Override
	public void unsave() {
	}

	@Override
	public void onContainerAttached() {
	}

}
