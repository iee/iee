package org.eclipse.iee.editor;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.Platform;
import org.eclipse.iee.core.document.DocumentPart;
import org.eclipse.iee.core.document.parser.IDocumentParser;
import org.eclipse.iee.core.document.writer.IDocumentWriter;
import org.eclipse.iee.editor.core.pad.IPadFactoryManager;
import org.eclipse.iee.editor.core.pad.table.TableCell;
import org.eclipse.iee.editor.core.pad.table.ui.CellPropertiesAdapterFactory;
import org.eclipse.iee.editor.core.storage.IPadStorage;
import org.eclipse.iee.editor.properties.PropertiesAdapterFactory;
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
	private static IPadStorage fPadStorage;
	
	private IAdapterFactory fPropertiesAdapterFactory = new PropertiesAdapterFactory();
	private IAdapterFactory fCellPropertiesAdapterFactory = new CellPropertiesAdapterFactory();
	/**
	 * The constructor
	 */
	public IeeEditorPlugin() {
	}
	
	public IPadFactoryManager getPadFactoryManager() {
		return getService(IPadFactoryManager.class);
	}

	private <T> T getService(Class<T> clazz) {
		BundleContext context = getDefault().getBundle().getBundleContext();
		ServiceReference<T> sr = context.getServiceReference(clazz);
		if (sr == null) {
			throw new IllegalArgumentException("Unknown service " + clazz.getName());
		}
		return context.getService(sr);
	}
	
	public IDocumentParser getParser() {
		return getService(IDocumentParser.class);
	}

	public IDocumentWriter getWriter() {
		return getService(IDocumentWriter.class);
	}

	public IPadStorage getPadStorage() {
		return fPadStorage;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		Platform.getAdapterManager().registerAdapters(fPropertiesAdapterFactory, DocumentPart.class);
		Platform.getAdapterManager().registerAdapters(fCellPropertiesAdapterFactory, TableCell.class);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		Platform.getAdapterManager().unregisterAdapters(fPropertiesAdapterFactory);
		Platform.getAdapterManager().unregisterAdapters(fCellPropertiesAdapterFactory);
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
