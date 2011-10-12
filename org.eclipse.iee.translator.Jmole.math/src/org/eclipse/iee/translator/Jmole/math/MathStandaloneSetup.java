
package org.eclipse.iee.translator.Jmole.math;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class MathStandaloneSetup extends MathStandaloneSetupGenerated{

	public static void doSetup() {
		new MathStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

