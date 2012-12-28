package org.eclipse.iee.sample.image;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.storage.FileStorage;
import org.eclipse.iee.sample.image.pad.ImagePad;

public class ImageFileStorage extends FileStorage{
	
	private static final Logger logger = Logger.getLogger(ImageFileStorage.class);
	
	private String fDirectoryPath;
	private static ImageFileStorage fInstance = null;
	
	public static ImageFileStorage getInstance(String directoryPath) {
		if (fInstance == null) {
			fInstance = new ImageFileStorage(directoryPath);
		}
		return fInstance;
	}
	
	private ImageFileStorage(String directoryPath) {
		logger.debug("ImageFilesStorage");
		
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
				pad.getContainer().setValue(imageDst.getAbsolutePath());
			}
			
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
	}

}
