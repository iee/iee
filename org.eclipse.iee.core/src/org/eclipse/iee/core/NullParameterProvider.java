/**
 * 
 */
package org.eclipse.iee.core;


public class NullParameterProvider implements IParameterProvider {

	@Override
	public String getParameterValue(String parameter) {
		return null;
	}
	
}
