package org.eclipse.iee.editor.core.storage;

import org.eclipse.iee.editor.core.pad.Pad;

public abstract class FileStorage implements IPadStorage {

	public FileStorage() {
	}
	
	public FileStorage(String directoryPath) {
	}
	
	public abstract void saveToFile(Pad<?, ?> pad);

	public abstract void removeFile(String containerID);

	public abstract void loadFromFile(String containerID);
}
