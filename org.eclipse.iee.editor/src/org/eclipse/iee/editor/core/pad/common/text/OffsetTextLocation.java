package org.eclipse.iee.editor.core.pad.common.text;

import com.google.common.base.Optional;

public class OffsetTextLocation implements TextLocation {

	private IContentTextPart fTextPart;
	
	private int fTextOffset;
	
	public OffsetTextLocation(IContentTextPart textPart, int textOffset) {
		fTextOffset = textOffset;
		fTextPart = textPart;
	}

	@Override
	public IContentTextPart getTextPart() {
		return fTextPart;
	}
	
	@Override
	public int getPosition() {
		return fTextOffset;
	}

	public Optional<TextLocation> getPrevious() {
		if (fTextOffset > 0) {
			return Optional.<TextLocation> of(new OffsetTextLocation(fTextPart, fTextOffset - 1));
		} else if (fTextPart.getParentTextPart().isPresent()) {
			Optional<ICompositeTextPart> parent = fTextPart.getParentTextPart();
			Optional<ITextPart> previousPart = parent.get().getPrevious(fTextPart);
			return previousPart.isPresent() ? Optional.<TextLocation> of(previousPart.get().getEnd()) : Optional.<TextLocation> absent();
		} else {
			return Optional.<TextLocation> absent();
		}
	}

	@Override
	public Optional<TextLocation> getNext() {
		if (fTextOffset < fTextPart.getLength()) {
			return Optional.<TextLocation> of(new OffsetTextLocation(fTextPart, fTextOffset + 1));
		} else if (fTextPart.getParentTextPart().isPresent()) {
			Optional<ICompositeTextPart> parent = fTextPart.getParentTextPart();
			Optional<ITextPart> nextPart = parent.get().getNext(fTextPart);
			return nextPart.isPresent() ? Optional.<TextLocation> of(nextPart.get().getStart()) : Optional.<TextLocation> absent();
		} else {
			return Optional.<TextLocation> absent();
		}
	};
	
	
	
}
