package org.eclipse.iee.sample.output.console;

public class ConsoleMessageEvent {
	private String fMessage;
	
	public String getMessage() {
		return fMessage;
	}
	
	ConsoleMessageEvent(String message) {
		fMessage = message;
	}
}
