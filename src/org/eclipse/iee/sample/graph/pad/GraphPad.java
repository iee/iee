package org.eclipse.iee.sample.graph.pad;

import java.io.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.sample.graph.FileStorage;

public class GraphPad extends Pad implements Serializable {

	private String fFunction;
	private transient static FileStorage fFileStorage;

	public GraphPad() {
		super();
		fFunction = "";
		save();
	}

	@Override
	public void createPartControl(final Composite parent) {
		FillLayout layout = new FillLayout(SWT.HORIZONTAL);
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		parent.setLayout(layout);

		// Listeners

		MouseEventManager mouseManager = new MouseEventManager(parent);
		parent.addMouseTrackListener(mouseManager);
		parent.addMouseMoveListener(mouseManager);
		parent.addMouseListener(mouseManager);

	}

	protected GraphPad(String containerID) {
		super(containerID);
		fFunction = "";
		save();
	}

	public static void setStorage(FileStorage fStorage) {
		GraphPad.fFileStorage = fStorage;
	}

	@Override
	public Pad copy() {
		GraphPad newPad = new GraphPad();
		newPad.fFunction = this.fFunction;
		return newPad;
	}

	@Override
	public String getType() {
		return "Graph";
	}

	// Save&Load operations, use it for serialization

	public void save() {
		GraphPad.fFileStorage.saveToFile(this);
	}

	@Override
	public void unsave() {
		GraphPad.fFileStorage.removeFile(getContainerID());
	}
}
