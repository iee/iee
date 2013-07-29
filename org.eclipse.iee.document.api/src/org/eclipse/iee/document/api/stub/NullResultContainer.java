/**
 * 
 */
package org.eclipse.iee.document.api.stub;

import org.eclipse.iee.document.api.IResultContainer;

/**
 * @author aefimchuk
 *
 */
public class NullResultContainer implements IResultContainer {

	@Override
	public void putResult(String padId, String result) {
	}

	@Override
	public String getResult(String padId) {
		return null;
	}

}
