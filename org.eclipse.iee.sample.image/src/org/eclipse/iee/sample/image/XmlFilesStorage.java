package org.eclipse.iee.sample.image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.io.FileUtils;
import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.PadManager;
import org.eclipse.iee.sample.image.pad.ImagePad;

public class XmlFilesStorage {
	
	private final PadManager fPadManager = IeeEditorPlugin.getPadManager();
	private String fDirectoryPath;
	private static XmlFilesStorage fInstance = null;
	
	public static XmlFilesStorage getInstance(String directoryPath) {
		if (fInstance == null) {
			fInstance = new XmlFilesStorage(directoryPath);
		}
		return fInstance;
	}
	
	private XmlFilesStorage(String directoryPath) {
		System.out.println("XmlFilesStorage");
		
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
	
	public void saveToFile(ImagePad pad) {
		System.out.println("saveToFile");
		
		try {
			
			File imageSrc = new File(pad.getImagePath());
			File imageDst = new File(pad.getStoragePath() + imageSrc.getName());
			
			if (!imageDst.exists())
			{
				FileUtils.copyFile(imageSrc, imageDst);
				pad.setImagePath(imageDst.getAbsolutePath());
			}
			
			File file = new File(fDirectoryPath + pad.getContainerID());
			
			if (!file.exists()) {
				System.out.println(file.getAbsolutePath());
				file.createNewFile();
			}
			
			FileOutputStream fos = new FileOutputStream(file);			
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(pad);
			out.close();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadAllFiles(File storageDirectory) {
		System.out.println("loadAllFiles");		
		for (String name : storageDirectory.list()) {
			Pad pad = loadFromFile(name);
			if (pad != null && pad.getType().matches("Image")) {
				fPadManager.loadPad(pad);
			}
		}
	}
	
	public void removeFile(String containerID) {
		File file = new File(fDirectoryPath + containerID);
		if (file.exists())  {
			file.delete();
		}
	}
	
	protected Pad loadFromFile(String containerID) {
		System.out.println("loadFromFile");
		Pad pad = null;
		try {
			File file = new File(fDirectoryPath + containerID);
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fis);
			try {
				pad = (Pad) in.readObject();
				pad.setContainerID(containerID);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			in.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pad;
	}
}
