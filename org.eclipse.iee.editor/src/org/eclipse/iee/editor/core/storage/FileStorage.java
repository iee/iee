package org.eclipse.iee.editor.core.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.PadManager;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.mapper.CannotResolveClassException;
import com.thoughtworks.xstream.converters.Converter;

public class FileStorage implements IPadStorage {
	
	XStream fXstream;
	
	private final PadManager fPadManager = IeeEditorPlugin.getPadManager();
	private String fDirectoryPath;

	public FileStorage(String directoryPath) {
		fXstream = new XStream(new DomDriver());
		fXstream.setMode(XStream.ID_REFERENCES);
		fXstream.autodetectAnnotations(true);
		
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
		
	@Override
	/* Doesn't work. TODO: fix inheritance stuff */
	public void registerSerializer(IPadSerializer serializer) {
		if (serializer instanceof Converter) {
			fXstream.registerConverter((Converter) serializer);
		}
	}
	
	@Override
	public void registerConverter(Converter converter) {
		fXstream.registerConverter(converter);
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
