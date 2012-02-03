package org.eclipse.iee.editor.core.utils.console;

public interface IConsoleMessageListener {
	
	public void messageReceived(ConsoleMessageEvent e);
	public String getRequesterID();
}
