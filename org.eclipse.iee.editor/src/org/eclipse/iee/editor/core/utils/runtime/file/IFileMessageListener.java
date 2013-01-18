package org.eclipse.iee.editor.core.utils.runtime.file;

public interface IFileMessageListener {
	
	public void messageReceived(FileMessageEvent e);
	public String getRequesterID();
}
