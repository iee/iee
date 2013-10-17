/**
 * 
 */
package org.eclipse.iee.core;


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
