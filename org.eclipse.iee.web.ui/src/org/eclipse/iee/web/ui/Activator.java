package org.eclipse.iee.web.ui;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.iee.core.store.InMemoryEvaluationContextStore;
import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.web.renderer.DefaultHTMLDocumentRenderer;
import org.eclipse.iee.web.renderer.IHTMLRendererManager;
import org.eclipse.iee.web.servlet.TestServlet;
import org.eclipse.iee.web.ui.store.DevDocumentStore;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

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
	@Override
	public void start(BundleContext context) throws Exception {
		plugin = this;
		server = new Server(8080);
		ServletContextHandler ctx = new ServletContextHandler();
		ctx.setContextPath("/test");
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		
		
		DevDocumentStore documentStore = new DevDocumentStore(workspace.getRoot().getLocation().toFile(), IeeEditorPlugin.getDefault().getParser());
		TestServlet servlet = new TestServlet();
		ServiceReference<IHTMLRendererManager> serviceReference = context.getServiceReference(IHTMLRendererManager.class);
		servlet.setDocumentRenderer(new DefaultHTMLDocumentRenderer(context.getService(serviceReference)));
		servlet.setDocumentStore(documentStore);
		servlet.setEvaluationContextStore(new InMemoryEvaluationContextStore());
		ctx.addServlet(new ServletHolder(servlet),"/doc/*");
        server.setHandler(ctx);
        server.start();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		server.stop();
		server = null;
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
