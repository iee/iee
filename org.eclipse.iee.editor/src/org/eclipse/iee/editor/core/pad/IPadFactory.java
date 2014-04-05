/**
 * 
 */
package org.eclipse.iee.editor.core.pad;

import org.eclipse.iee.core.document.PadDocumentPart;

/**
 * Interface of pad factory
 */
public interface IPadFactory<T extends PadDocumentPart> {

	/**
	 * Creates new pad instance using provided parameters
	 * @param padParams pad parameters
	 * @param value pad value
	 * @return new pad instance
	 */
	Pad<T> create(T documentPart);

}