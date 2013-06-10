package org.eclipse.iee.web;

import java.util.Hashtable;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.editor.core.utils.symbolic.SymbolicEngine;
import org.eclipse.iee.web.renderer.FormulaHTMLRenderer;
import org.eclipse.iee.web.renderer.HTMLRendererManager;
import org.eclipse.iee.web.renderer.ImageHTMLRenderer;
import org.eclipse.iee.web.renderer.InputHTMLRenderer;
import org.eclipse.iee.web.renderer.SymbolicHTMLRenderer;
import org.eclipse.iee.web.renderer.TextHTMLRenderer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator implements BundleActivator {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.iee.web"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	private Server server;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		HTMLRendererManager rendererManager = new HTMLRendererManager();
		registerRenderer(rendererManager);
		context.registerService(HTMLRendererManager.class, 
				new HTMLRendererManager(), new Hashtable<String, Object>());
		plugin = this;
		server = new Server(8080);
		ServletContextHandler ctx = new ServletContextHandler();
		ctx.setContextPath("/test");
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		ctx.addServlet(new ServletHolder(new TestServlet(workspace.getRoot().getLocation().toFile(), IeeEditorPlugin.getPadManager(), rendererManager)),"/doc/*");
        server.setHandler(ctx);
        server.start();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		server.stop();
		server = null;
	}

	private void registerRenderer(HTMLRendererManager rendererManager) {
		rendererManager.registerPadHTMLRenderer("Formula", new FormulaHTMLRenderer());
		rendererManager.registerPadHTMLRenderer("Input", new InputHTMLRenderer());
		rendererManager.registerPadHTMLRenderer("Symbolic", new SymbolicHTMLRenderer(new SymbolicEngine()));
		rendererManager.registerPadHTMLRenderer("Image", new ImageHTMLRenderer());
		rendererManager.registerPadHTMLRenderer("Text", new TextHTMLRenderer());
	}
	
	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
