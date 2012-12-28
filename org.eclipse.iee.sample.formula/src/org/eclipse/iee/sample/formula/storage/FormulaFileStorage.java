package org.eclipse.iee.sample.formula.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;

import org.apache.log4j.Logger;
import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.PadManager;
import org.eclipse.iee.editor.core.storage.FileStorage;
import org.eclipse.iee.sample.formula.pad.FormulaPad;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;

public class FormulaFileStorage extends FileStorage{

	private static final Logger logger = Logger.getLogger(FormulaFileStorage.class);
	
	private static String fDirectoryPath = "";
	private static FormulaFileStorage fInstance = null;

	public static FormulaFileStorage getInstance(String directoryPath) {
		if (fInstance == null || !directoryPath.matches(fDirectoryPath)) {
			fInstance = new FormulaFileStorage(directoryPath);
		}
		return fInstance;
	}

	private XStream fXstream;
	private final PadManager fPadManager = IeeEditorPlugin.getPadManager();

	private FormulaFileStorage(String directoryPath) {
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

	public void removeFile(String containerID) {
		File file = new File(fDirectoryPath + containerID);
		if (file.exists()) {
			file.delete();
		}
	}

	public void loadFromFile(String containerID) {
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
		
		if (loadedPad != null && loadedPad.getType().matches("Formula")) {
			fPadManager.loadPad(loadedPad);
		}
	}
}
