package org.eclipse.iee.editor.core.utils.runtime.file;

public class FileMessageEvent {
	private String fMessage;
	
	public String getMessage() {
		return fMessage;
	}
	
	FileMessageEvent(String message) {
		fMessage = message;
	}
}
