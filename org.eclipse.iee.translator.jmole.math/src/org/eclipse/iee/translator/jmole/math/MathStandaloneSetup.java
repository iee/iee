
package org.eclipse.iee.translator.jmole.math;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class MathStandaloneSetup extends MathStandaloneSetupGenerated{

	public static void doSetup() {
		new MathStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

