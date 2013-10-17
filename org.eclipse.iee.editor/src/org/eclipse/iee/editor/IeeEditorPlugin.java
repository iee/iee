package org.eclipse.iee.editor;

import org.eclipse.iee.core.document.parser.DefaultDocumentParser;
import org.eclipse.iee.core.document.writer.DefaultDocumentWriter;
import org.eclipse.iee.editor.core.pad.PadManager;
import org.eclipse.iee.editor.core.storage.IPadStorage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * The activator class controls the plug-in life cycle
 */
public class IeeEditorPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.iee.editor";

	// The shared instance
	private static IeeEditorPlugin plugin;
	
	// Single instance of PadManager
	private static PadManager fPadManager;
	private static DefaultDocumentParser fParser;
	private static DefaultDocumentWriter fWriter;
	private static IPadStorage fPadStorage;
	
	/**
	 * The constructor
	 */
	public IeeEditorPlugin() {
	}
	
	public static PadManager getPadManager() {
		return fPadManager;
	}
	
	public static DefaultDocumentParser getParser() {
		return fParser;
	}

	public static DefaultDocumentWriter getWriter() {
		return fWriter;
	}

	public static IPadStorage getPadStorage() {
		return fPadStorage;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		ServiceReference<DefaultDocumentParser> parserReference = (ServiceReference<DefaultDocumentParser>) context.getServiceReference(DefaultDocumentParser.class.getName());
		ServiceReference<DefaultDocumentWriter> writerReference = (ServiceReference<DefaultDocumentWriter>) context.getServiceReference(DefaultDocumentWriter.class.getName());
		ServiceReference<PadManager> serviceReference = (ServiceReference<PadManager>) context.getServiceReference(PadManager.class.getName());
		fPadManager = context.getService(serviceReference);
		fParser = context.getService(parserReference);
		fWriter = context.getService(writerReference);
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
	public static IeeEditorPlugin getDefault() {
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
