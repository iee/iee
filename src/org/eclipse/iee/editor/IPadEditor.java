package org.eclipse.iee.editor;


import org.eclipse.iee.editor.core.pad.Pad;

public interface IPadEditor {
	
	public final int PROP_CONTAINER_SET = "PROP_CONTAINER_SET".hashCode();
	
	public void initIeeEditorCore();

	public void dispose();
	
	public void createPad(Pad pad, int location);
	
	public int getCaretOffset();
	
	public Object[] getElements(); 
}
