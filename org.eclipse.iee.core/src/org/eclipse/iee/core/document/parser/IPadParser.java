/**
 * 
 */
package org.eclipse.iee.core.document.parser;

import java.util.Map;

import org.eclipse.iee.core.document.PadDocumentPart;

/**
 * Interface of pad factory
 */
public interface IPadParser {

	/**
	 * Creates new pad instance using provided parameters
	 * @param padParams pad parameters
	 * @param value pad value
	 * @return new pad instance
	 */
	PadDocumentPart create(Map<String, String> padParams, String value);

	String getType();
	
}