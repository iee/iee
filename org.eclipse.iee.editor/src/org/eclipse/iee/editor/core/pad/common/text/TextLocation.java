package org.eclipse.iee.editor.core.pad.common.text;

import org.eclipse.draw2d.text.CaretInfo;
import org.eclipse.iee.editor.core.container.ITextEditor;
import org.eclipse.swt.widgets.Caret;

import com.google.common.base.Optional;

public interface TextLocation {

	Optional<TextLocation> getPrevious();
	
	Optional<TextLocation> getNext();

	Optional<TextLocation> getAbove();

	Optional<TextLocation> getBelow();
	
	void putCaret(Caret caret);

	CaretInfo getCaretInfo();

	ITextEditor<?, ?> getEditor();
	
}
