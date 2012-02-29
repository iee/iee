package org.eclipse.iee.editor.core.storage;

import org.eclipse.iee.editor.core.pad.Pad;

import com.thoughtworks.xstream.converters.Converter;

public interface IPadStorage {
	public void registerSerializer(IPadSerializer serializer);
	public void saveToFile(Pad pad);
	public void removeFile(String containerID);
	public void registerConverter(Converter converter);
}
