package org.eclipse.iee.editor;


import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.iee.editor.core.pad.IPadFactoryManager;

public interface IPadEditor {
	
	public final int PROP_CONTAINER_SET = "PROP_CONTAINER_SET".hashCode();
	
	public void dispose();
	
	public void createPad(PadDocumentPart pad, int location);
	
	public void createImage(String fileName, int location);
	
	public int getCaretOffset();
	
	public Object[] getElements();
	
	public IPadFactoryManager getPadManager();
	
	public ContainerManager getContainerManager();

	public void createPad(PadDocumentPart pad);
}
