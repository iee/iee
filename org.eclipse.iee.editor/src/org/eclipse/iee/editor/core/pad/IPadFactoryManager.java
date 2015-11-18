package org.eclipse.iee.editor.core.pad;

import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.editor.core.container.TextRenderCtx;

public interface IPadFactoryManager {

	public <T extends PadDocumentPart> Pad<T, ?> createPad(T padPart, TextRenderCtx renderCtx);

}