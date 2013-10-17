/**
 * 
 */
package org.eclipse.iee.core;

/**
 * @author Toxin
 *
 */
public interface IResultContainer {

	public void putResult(String padId, String result);
	
	public String getResult(String padId);
	
}
