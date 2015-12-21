package org.eclipse.iee.editor.core.pad.common.text;

import org.eclipse.draw2d.text.CaretInfo;
import org.eclipse.iee.editor.core.container.ITextEditor;
import org.eclipse.swt.widgets.Caret;

import com.google.common.base.Optional;

public interface IEditorLocation {

	Optional<IEditorLocation> getPrevious();
	
	Optional<IEditorLocation> getNext();

	Optional<IEditorLocation> getAbove();

	Optional<IEditorLocation> getBelow();
	
	void putCaret(Caret caret);

	CaretInfo getCaretInfo();

	ITextEditor<?> getEditor();

	int getOffset();

	Optional<IEditorLocation> getLineEnd();
	
	Optional<IEditorLocation> getLineStart();

}
