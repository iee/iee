package org.eclipse.iee.sample.formula.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.PadManager;
import org.eclipse.iee.sample.formula.pad.FormulaPad;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;

public class FileStorage {
	
	private static String fDirectoryPath = "D:\\FormulaPads\\";
	private static FileStorage fInstance = null;
	
	public static FileStorage getInstance() {
		if (fInstance == null) {
			fInstance = new FileStorage();
		}
		return fInstance;
	}	
	
	private XStream fXstream;
	private final PadManager fPadManager = IeeEditorPlugin.getPadManager();
	
	private FileStorage() {
		fXstream = new XStream(new DomDriver());
		fXstream.setMode(XStream.ID_REFERENCES);
		//fXstream.autodetectAnnotations(true);
		fXstream.registerConverter(new FormulaPadConverter());
		fXstream.alias("FormulaPad", FormulaPad.class);
		
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
		System.out.println("saveToFile");
		try {
			FileOutputStream fos = new FileOutputStream(fDirectoryPath + pad.getContainerID());
			fos.write(fXstream.toXML(pad).getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadAllFiles(File storageDirectory) {
		System.out.println("loadAllFiles");
		for (String name : storageDirectory.list()) {
			Pad pad = loadFromFile(name);
			if (pad != null) {
				System.out.println(">>>>>>>>loadPad");
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
		System.out.println(">>>>>>>>loadFromFile");
		
		Pad loadedPad = null;
		try {
			FileInputStream fis = new FileInputStream(fDirectoryPath + containerID);
			
			try {
				Class.forName("org.eclipse.iee.sample.formula.pad.FormulaPad");
			} catch (ClassNotFoundException e) {
				System.out.println("FormulaPad preloading failed");
				e.printStackTrace();
			}
			
			loadedPad = (Pad) fXstream.fromXML(fis);
			loadedPad.setContainerID(containerID);
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CannotResolveClassException e) {
			e.printStackTrace();
			System.out.println("Message: " + e.getMessage());
		}
		return loadedPad;
	}
}
