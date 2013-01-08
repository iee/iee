package org.eclipse.iee.editor.core.utils.runtime.console;

public class ConsoleMessageEvent {
	private String fMessage;
	
	public String getMessage() {
		return fMessage;
	}
	
	ConsoleMessageEvent(String message) {
		fMessage = message;
	}
}
