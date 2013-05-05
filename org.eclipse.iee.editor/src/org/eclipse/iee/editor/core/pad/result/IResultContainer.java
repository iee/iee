/**
 * 
 */
package org.eclipse.iee.editor.core.pad.result;

/**
 * @author Toxin
 *
 */
public interface IResultContainer {

	public void putResult(String padId, String result);
	
	public String getResult(String padId);
	
}
