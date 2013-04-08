package org.eclipse.iee.editor;


import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.PadManager;

public interface IPadEditor {
	
	public final int PROP_CONTAINER_SET = "PROP_CONTAINER_SET".hashCode();
	
	public void initIeeEditorCore();

	public void dispose();
	
	public void createPad(Pad pad, int location);
	
	public int getCaretOffset();
	
	public Object[] getElements();
	
	public PadManager getPadManager();
	
	public ContainerManager getContainerManager();
}
