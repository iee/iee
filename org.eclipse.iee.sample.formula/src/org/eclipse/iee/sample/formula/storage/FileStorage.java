package org.eclipse.iee.sample.formula.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.PadManager;
import org.eclipse.iee.sample.formula.pad.FormulaPad;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;

public class FileStorage {

	private static final Logger logger = Logger.getLogger(FileStorage.class);
	
	private String fDirectoryPath = "";
	private static FileStorage fInstance = null;

	public static FileStorage getInstance(String directoryPath) {
		if (fInstance == null) {
			fInstance = new FileStorage(directoryPath);
		}
		return fInstance;
	}

	private XStream fXstream;
	private final PadManager fPadManager = IeeEditorPlugin.getPadManager();

	private FileStorage(String directoryPath) {
		fXstream = new XStream(new DomDriver());
		fXstream.setMode(XStream.ID_REFERENCES);

		fXstream.registerConverter(new FormulaPadConverter());
		fXstream.alias("FormulaPad", FormulaPad.class);
		
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

	public void saveToFile(Pad pad) {
		logger.debug(pad.getContainerID() + ":saveToFile");
		try {
			FileOutputStream fos = new FileOutputStream(fDirectoryPath
					+ pad.getContainerID());
			fos.write(fXstream.toXML(pad).getBytes());
			fos.close();
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	public void loadAllFiles(File storageDirectory) {
		logger.debug("loadAllFiles");
		for (String name : storageDirectory.list()) {
			Pad pad = loadFromFile(name);
			if (pad != null && pad.getType().matches("Formula")) {
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

	protected Pad loadFromFile(String containerID) {
		logger.debug(containerID + " >>>>>>>> loadFromFile");

		Pad loadedPad = null;
		try {
			FileInputStream fis = new FileInputStream(fDirectoryPath
					+ containerID);

			try {
				Class.forName("org.eclipse.iee.sample.formula.pad.FormulaPad");
			} catch (ClassNotFoundException e) {
				logger.error("FormulaPad preloading failed: " + e.getMessage());
				e.printStackTrace();
			}

			loadedPad = (Pad) fXstream.fromXML(fis);
			loadedPad.setContainerID(containerID);
			fis.close();
		} catch (IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (CannotResolveClassException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return loadedPad;
	}
}
