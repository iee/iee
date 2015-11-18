package org.eclipse.iee.editor.text.edit;

import org.eclipse.iee.core.document.text.ITextLocation;

public interface IEditCommand {

	void perform();

	ITextLocation adjust(ITextLocation location);

}
