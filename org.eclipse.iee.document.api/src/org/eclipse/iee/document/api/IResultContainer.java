/**
 * 
 */
package org.eclipse.iee.document.api;

/**
 * @author Toxin
 *
 */
public interface IResultContainer {

	public void putResult(String padId, String result);
	
	public String getResult(String padId);
	
}
