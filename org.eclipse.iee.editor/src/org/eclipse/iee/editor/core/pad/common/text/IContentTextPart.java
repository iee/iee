package org.eclipse.iee.editor.core.pad.common.text;

import org.eclipse.swt.widgets.Caret;

public interface IContentTextPart extends ITextPart {

	void updateCaret(Caret caret, int position, boolean flag);

	void replace(int start, int end, String text);
	
	int getLength();

}
