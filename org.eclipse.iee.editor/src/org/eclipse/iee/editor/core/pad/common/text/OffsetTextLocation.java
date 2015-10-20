package org.eclipse.iee.editor.core.pad.common.text;

import org.eclipse.draw2d.text.CaretInfo;
import org.eclipse.iee.editor.core.container.ITextEditor;
import org.eclipse.swt.widgets.Caret;

import com.google.common.base.Optional;

public class OffsetTextLocation implements TextLocation {

	private TextPartEditor fTextPart;
	
	private int fTextOffset;
	
	public OffsetTextLocation(TextPartEditor textPart, int textOffset) {
		fTextOffset = textOffset;
		fTextPart = textPart;
	}

	public Optional<TextLocation> getPrevious() {
		if (fTextOffset > 0) {
			return Optional.<TextLocation> of(new OffsetTextLocation(fTextPart, fTextOffset - 1));
		} else if (fTextPart.getParent().isPresent()) {
			Optional<ITextEditor<?,?>> parent = fTextPart.getParent();
			return parent.get().getPrevious(fTextPart);
		} else {
			return Optional.<TextLocation> absent();
		}
	}

	@Override
	public Optional<TextLocation> getNext() {
		if (fTextOffset < fTextPart.getLength()) {
			return Optional.<TextLocation> of(new OffsetTextLocation(fTextPart, fTextOffset + 1));
		} else if (fTextPart.getParent().isPresent()) {
			Optional<ITextEditor<?,?>> parent = fTextPart.getParent();
			return parent.get().getNext(fTextPart);
		} else {
			return Optional.<TextLocation> absent();
		}
	}

	@Override
	public void putCaret(Caret caret) {
		fTextPart.updateCaret(caret, fTextOffset, fTextOffset == fTextPart.getLength());
	}

	@Override
	public Optional<TextLocation> getAbove() {
		if (fTextPart.getParent().isPresent()) {
			Optional<ITextEditor<?,?>> parent = fTextPart.getParent();
			return parent.get().getAbove(this);
		} else {
			return Optional.<TextLocation> absent();
		}
	}

	@Override
	public Optional<TextLocation> getBelow() {
		if (fTextPart.getParent().isPresent()) {
			Optional<ITextEditor<?,?>> parent = fTextPart.getParent();
			return parent.get().getBelow(this);
		} else {
			return Optional.<TextLocation> absent();
		}
	};
	
	@Override
	public CaretInfo getCaretInfo() {
		return fTextPart.getCaretInfo(fTextOffset, fTextOffset == fTextPart.getLength());
	}

	@Override
	public ITextEditor<?, ?> getEditor() {
		return fTextPart;
	}
	
	@Override
	public int getOffset() {
		return fTextOffset;
	}
	
}
