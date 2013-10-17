package org.eclipse.iee.core.document.writer;

import java.util.Map;

import org.eclipse.iee.core.document.PadDocumentPart;

public interface IPadWriter<T extends PadDocumentPart> {

	String getValue(T part);
	
	Map<String, String> getParams(T part);
	
	String getType();
	
}
