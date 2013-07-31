/**
 * 
 */
package org.eclipse.iee.editor.core.pad;

import java.util.Map;

/**
 * Interface of pad factory
 */
public interface IPadFactory {

	/**
	 * Creates new pad instance using provided parameters
	 * @param padParams pad parameters
	 * @param value pad value
	 * @return new pad instance
	 */
	Pad create(Map<String, String> padParams, String value);

	String getType();
	
}