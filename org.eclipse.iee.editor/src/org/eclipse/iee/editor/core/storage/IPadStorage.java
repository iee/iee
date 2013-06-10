package org.eclipse.iee.editor.core.storage;

import org.eclipse.iee.editor.core.pad.Pad;

public interface IPadStorage {
	public void saveToFile(Pad pad);
	public void removeFile(String containerID);
	public void loadFromFile(String containerID);
}
