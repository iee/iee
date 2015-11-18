package org.eclipse.iee.editor.text.edit;

import org.eclipse.iee.core.document.text.ITextLocation;
import org.eclipse.iee.core.document.text.OffsetTextLocation;
import org.eclipse.iee.core.document.text.Text;

import com.google.common.base.Objects;

public class ReplaceText implements IEditCommand {

	private Text fModel;
	
	private int fFrom;
	
	private int fTo;
	
	private String fText;

	public ReplaceText(Text model, int from, int to, String text) {
		fModel = model;
		fFrom = from;
		fTo = to;
		fText = text;

	}

	@Override
	public void perform() {
		String oldV = Objects.firstNonNull(fModel.getText(), "");
		String newV = oldV.substring(0, Math.min(fFrom, fTo)) + fText + oldV.substring(Math.max(fFrom, fTo));
		fModel.setText(newV);
	}

	@Override
	public ITextLocation adjust(ITextLocation location) {
		if (location.getOffset() >= fTo) {
			return new OffsetTextLocation(fModel, location.getOffset() - (fTo - fFrom) + fText.length());
		} 
		return location;
	}

}
