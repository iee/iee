package org.eclipse.iee.editor.core.pad.common.text;

import org.eclipse.draw2d.text.CaretInfo;
import org.eclipse.iee.editor.core.container.ITextEditor;
import org.eclipse.swt.widgets.Caret;

import com.google.common.base.Optional;

public class OffsetEditorLocation implements IEditorLocation {

	private ITextContainer<?> fTextPart;
	
	private int fTextOffset;
	
	public OffsetEditorLocation(ITextContainer<?> textPart, int textOffset) {
		fTextOffset = textOffset;
		fTextPart = textPart;
	}

	public Optional<IEditorLocation> getPrevious() {
		if (fTextOffset > 0) {
			return Optional.<IEditorLocation> of(new OffsetEditorLocation(fTextPart, fTextOffset - 1));
		} else if (fTextPart.getParent().isPresent()) {
			Optional<ITextEditor<?>> parent = fTextPart.getParent();
			return parent.get().getPrevious(fTextPart);
		} else {
			return Optional.<IEditorLocation> absent();
		}
	}

	@Override
	public Optional<IEditorLocation> getNext() {
		if (fTextOffset < fTextPart.getLength()) {
			return Optional.<IEditorLocation> of(new OffsetEditorLocation(fTextPart, fTextOffset + 1));
		} else if (fTextPart.getParent().isPresent()) {
			Optional<ITextEditor<?>> parent = fTextPart.getParent();
			return parent.get().getNext(fTextPart);
		} else {
			return Optional.<IEditorLocation> absent();
		}
	}
	
	@Override
	public Optional<IEditorLocation> getLineEnd() {
		CaretInfo caretInfo = fTextPart.getCaretInfo(fTextOffset, false);
		return fTextPart.getLineEnd(caretInfo.getX(), caretInfo.getBaseline());
	}

	@Override
	public Optional<IEditorLocation> getLineStart() {
		CaretInfo caretInfo = fTextPart.getCaretInfo(fTextOffset, false);
		return fTextPart.getLineStart(caretInfo.getX(), caretInfo.getBaseline());
	}
	
	@Override
	public void putCaret(Caret caret) {
		fTextPart.updateCaret(caret, fTextOffset);
	}

	@Override
	public Optional<IEditorLocation> getAbove() {
		if (fTextPart.getParent().isPresent()) {
			Optional<ITextEditor<?>> parent = fTextPart.getParent();
			return parent.get().getAbove(this);
		} else {
			return Optional.<IEditorLocation> absent();
		}
	}

	@Override
	public Optional<IEditorLocation> getBelow() {
		if (fTextPart.getParent().isPresent()) {
			Optional<ITextEditor<?>> parent = fTextPart.getParent();
			return parent.get().getBelow(this);
		} else {
			return Optional.<IEditorLocation> absent();
		}
	};
	
	@Override
	public CaretInfo getCaretInfo() {
		return fTextPart.getCaretInfo(fTextOffset, fTextOffset == fTextPart.getLength());
	}

	@Override
	public ITextEditor<?> getEditor() {
		return fTextPart;
	}
	
	@Override
	public int getOffset() {
		return fTextOffset;
	}
	
}
