package org.eclipse.iee.editor.core.pad.common.text;

import org.eclipse.draw2d.text.CaretInfo;
import org.eclipse.iee.editor.core.container.ITextEditor;
import org.eclipse.swt.widgets.Caret;

public interface ITextContainer<M> extends ITextEditor<M> {

	int getLength();

	void updateCaret(Caret caret, int textOffset);

	CaretInfo getCaretInfo(int textOffset, boolean b);

}