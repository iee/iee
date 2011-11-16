package org.eclipse.iee.translator.math;

import org.eclipse.iee.translator.jmole.math.generator.Mole;
import org.eclipse.iee.translator.molex.math.generator.TexMole;
import org.eclipse.iee.translator.math.pad.CompiledMathPad;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin implements IStartup {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.iee.translator.math"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	private static Mole mole;
	private static TexMole molex;
	
	/**
	 * The constructor
	 */
	public Activator() {
		CompiledMathPad.setStorage(new FileStorage("D:\\CompiledMathPads\\"));
		
		//mole = Mole.create();
		//molex = TexMole.create();
		//System.out.println("Activated");
	}
	
	public static Mole getMole() {
		molex = null;
		mole = Mole.create();
		return mole;
	}
	
	public static TexMole getMolex() {
		mole = null;
		molex = TexMole.create();
		return molex;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
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
