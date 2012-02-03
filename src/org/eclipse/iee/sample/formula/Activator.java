package org.eclipse.iee.sample.formula;

import org.eclipse.iee.sample.formula.pad.FormulaPad;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import org.eclipse.iee.translator.jmole.math.generator.Mole;
import org.eclipse.iee.translator.molex.mex.generator.Molex;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin implements IStartup {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.iee.sample.formula"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	
	private static Mole mole;
	private static Molex molex;
	
	/**
	 * The constructor
	 */
	public Activator() {
		FormulaPad.setStorage(new FileStorage("D:\\MathPads\\"));

		mole = Mole.create();
		molex = Molex.create();
	}
	
	public static Mole getMole() {
		return mole;
	}
	
	public static Molex getMolex() {
		return molex;
	}	

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	@Override
	public void earlyStartup() {
		// TODO Auto-generated method stub
	}

}
