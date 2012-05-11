package org.eclipse.iee.sample.matrix;

import org.eclipse.iee.translator.jmole.math.generator.Mole;
import org.eclipse.iee.translator.molex.mex.generator.Molex;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "org.eclipse.iee.sample.matrix"; //$NON-NLS-1$

	private static Activator plugin;
	
	private static Mole mole;
	private static Molex molex;
	
	/**
	 * The constructor
	 */
	public Activator() {	
		mole = Mole.create();
		molex = Molex.create();
		System.out.println("Activated");
	}
	
	public static Mole getMole() {
		return mole;
	}
	
	public static Molex getMolex() {
		return molex;
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

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

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
