
package org.eclipse.iee.translator.molex.mex;

/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class MexStandaloneSetup extends MexStandaloneSetupGenerated{

	public static void doSetup() {
		new MexStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

