/**
 * 
 */
package org.eclipse.iee.document.api.stub;

import org.eclipse.iee.document.api.IParameterProvider;

public class NullParameterProvider implements IParameterProvider {

	@Override
	public String getParameterValue(String parameter) {
		return null;
	}
	
}
