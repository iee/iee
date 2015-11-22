package org.eclipse.iee.editor.text.edit;

import org.eclipse.iee.core.document.text.ICompositeNode;
import org.eclipse.iee.core.document.text.INode;
import org.eclipse.iee.core.document.text.ITextLocation;
import org.eclipse.iee.core.document.text.OffsetTextLocation;
import org.eclipse.iee.core.document.text.Span;
import org.eclipse.iee.core.document.text.Text;

public class WrapCommand implements IEditCommand {

	private Text fText;
	
	private int fFrom;
	
	private int fTo;

	private Text fLeft;

	private Text fRight;

	public WrapCommand(Text text, int from, int to) {
		fText = text;
		fFrom = from;
		fTo = to;
	}

	@Override
	public void perform() {
		String text = fText.getText();
		ICompositeNode<INode> parent = (ICompositeNode<INode>) fText.getParent();
		if (fFrom != 0) {
			fLeft = new Text();
			fLeft.setText(text.substring(0, fFrom));
			parent.addChildBefore(fLeft, fText);
		}
		if (fTo != text.length()) {
			fRight = new Text();
			fRight.setText(text.substring(fTo));
			parent.addChildAfter(fRight, fText);
		}
		fText.setText(text.substring(fFrom, fTo));
		Span span = new Span();
		parent.replace(fText, span);
		span.addChild(fText);
	}

	@Override
	public ITextLocation adjust(ITextLocation location) {
		if (location.getModel() == fText) {
			int offset = location.getOffset();
			if (offset < fFrom) {
				return new OffsetTextLocation(fLeft, offset);
			} 
			if (offset >= fFrom && offset <= fTo) {
				return new OffsetTextLocation(fText, offset - fFrom);
			} 			
			if (offset > fTo) {
				return new OffsetTextLocation(fRight, offset - fTo);
			}
		}
		return location;
	}

}
