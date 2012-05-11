package org.eclipse.iee.sample.formula;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.sample.formula.storage.FileStorage;
import org.eclipse.iee.translator.jmole.math.generator.Mole;
import org.eclipse.iee.translator.molex.mex.generator.Molex;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class FormulaPadManager extends AbstractUIPlugin implements IStartup {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.iee.sample.formula"; //$NON-NLS-1$

	// The shared instance
	private static FormulaPadManager plugin;
	
	private static Mole mole;
	private static Molex molex;
	
	/**
	 * The constructor
	 */
	public FormulaPadManager() {
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
	public static FormulaPadManager getDefault() {
		return plugin;
	}

	@Override
	public void earlyStartup() {
		// TODO Auto-generated method stub
	}

	public static List<Pad> getFollowingPads(Pad pad) {		
		List<Pad> pads = IeeEditorPlugin.getPadManager().selectPadsByType(pad.getType());
		
		Collections.sort(pads, new Comparator<Pad>() {
			@Override
			public int compare(Pad pad1, Pad pad2) {
				int offset1 = pad1.getContainer().getPosition().getOffset();
				int offset2 = pad2.getContainer().getPosition().getOffset();
				if (offset1 < offset2) {
					return -1;
				} else if (offset1 == offset2) {
					return 0;
				} else {
					return 1;
				}
			}
		});
		
		return pads.subList(pads.indexOf(pad), pads.size());
	}

}