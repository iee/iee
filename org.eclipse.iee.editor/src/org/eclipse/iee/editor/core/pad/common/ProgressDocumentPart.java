package org.eclipse.iee.editor.core.pad.common;

import org.eclipse.iee.core.document.PadDocumentPart;

public class ProgressDocumentPart extends PadDocumentPart {

	private String status;
	
	private int progress;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getProgress() {
		return progress;
	}

	public void setProgress(int progress) {
		this.progress = progress;
	}

	@Override
	public ProgressDocumentPart copy() {
		ProgressDocumentPart part = new ProgressDocumentPart();
		part.setProgress(getProgress());
		part.setStatus(getStatus());
		return part;
	}
	
}
