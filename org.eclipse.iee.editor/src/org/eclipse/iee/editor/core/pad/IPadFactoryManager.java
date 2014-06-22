package org.eclipse.iee.editor.core.pad;

import org.eclipse.iee.core.document.PadDocumentPart;

public interface IPadFactoryManager {

	public <T extends PadDocumentPart> Pad<T> createPad(T padPart);

}