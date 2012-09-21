package org.eclipse.iee.sample.image;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.PadManager;
import org.eclipse.iee.editor.core.storage.FileStorage;
import org.eclipse.iee.sample.image.pad.ImagePad;

public class ImageFileStorage extends FileStorage{
	
	private static final Logger logger = Logger.getLogger(ImageFileStorage.class);
	
	private final PadManager fPadManager = IeeEditorPlugin.getPadManager();
	private String fDirectoryPath;
	private static ImageFileStorage fInstance = null;
	
	public static ImageFileStorage getInstance(String directoryPath) {
		if (fInstance == null) {
			fInstance = new ImageFileStorage(directoryPath);
		}
		return fInstance;
	}
	
	private ImageFileStorage(String directoryPath) {
		logger.debug("XmlFilesStorage");
		
		fDirectoryPath = directoryPath;
		File storageDirectory = new File(fDirectoryPath);
		
		if (!storageDirectory.exists()) {
			if (!storageDirectory.mkdirs()) {
				return;
			}
		}
	}
	
	public void saveToFile(Pad pad) {
		logger.debug(pad.getContainerID() + " : saveToFile");
		
		ImagePad imagePad = (ImagePad)pad;
		
		try {
			
			File imageSrc = new File(imagePad.getImagePath());
			File imageDst = new File(imagePad.getStoragePath() + imageSrc.getName());
			
			if (!imageDst.exists())
			{
				FileUtils.copyFile(imageSrc, imageDst);
				imagePad.setImagePath(imageDst.getAbsolutePath());
			}
			
			File file = new File(fDirectoryPath + pad.getContainerID());
			
			if (!file.exists()) {
				logger.debug("new file: " + file.getAbsolutePath());
				file.createNewFile();
			}
			
			FileOutputStream fos = new FileOutputStream(file);			
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(pad);
			out.close();
			fos.close();
		} catch (IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void removeFile(String containerID) {
		File file = new File(fDirectoryPath + containerID);
		if (file.exists())  {
			file.delete();
		}
	}
	
	public void loadFromFile(String containerID) {
		logger.debug(containerID + " : loadFromFile");
		Pad pad = null;
		try {
			File file = new File(fDirectoryPath + containerID);
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fis);
			try {
				pad = (Pad) in.readObject();
				pad.setContainerID(containerID);
			} catch (ClassNotFoundException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}
			in.close();
			fis.close();
		} catch (IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}

		if (pad != null && pad.getType().matches("Image")) {
			fPadManager.loadPad(pad);
		}
		
	}

}
