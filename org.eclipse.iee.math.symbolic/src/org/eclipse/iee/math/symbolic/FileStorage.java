package org.eclipse.iee.math.symbolic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.PadManager;
import org.eclipse.iee.math.symbolic.pad.SymbolicPad;

public class FileStorage {

	private final PadManager fPadManager = IeeEditorPlugin.getDefault()
			.getPadManager();
	private String fDirectoryPath;

	FileStorage(String directoryPath) {
		System.out.println("FileStorage");

		fDirectoryPath = directoryPath;
		File storageDirectory = new File(fDirectoryPath);

		if (!storageDirectory.exists()) {
			if (!storageDirectory.mkdirs()) {
				return;
			}
		}

		if (storageDirectory.exists() && storageDirectory.isDirectory()) {
			loadAllFiles(storageDirectory);
		}
	}

	public String getDirectoryPath()
	{
		return fDirectoryPath;
	}
	
	public void saveToFile(SymbolicPad pad) {
		System.out.println("saveToFile");
		try {
			FileOutputStream fos = new FileOutputStream(fDirectoryPath
					+ pad.getContainerID());
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(pad);
			out.close();
			fos.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public void loadAllFiles(File storageDirectory) {
		System.out.println("loadAllFiles");
		for (String name : storageDirectory.list()) {
			Pad pad = loadFromFile(name);
			if (pad != null) {
				fPadManager.loadPad(pad);
			}
		}
	}

	public void removeFile(String containerID) {
		File file = new File(fDirectoryPath + containerID);
		if (file.exists()) {
			file.delete();
		}
	}

	protected SymbolicPad loadFromFile(String containerID) {
		System.out.println("loadFromFile");
		SymbolicPad loadedPad = null;
		try {
			FileInputStream fis = new FileInputStream(fDirectoryPath
					+ containerID);
			ObjectInputStream in = new ObjectInputStream(fis);
			try {
				loadedPad = (SymbolicPad) in.readObject();
				loadedPad.setContainerID(containerID);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			in.close();
			fis.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
		return loadedPad;
	}
}
