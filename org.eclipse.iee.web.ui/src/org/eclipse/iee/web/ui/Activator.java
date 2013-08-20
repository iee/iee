package org.eclipse.iee.web.ui;

import java.util.Hashtable;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.editor.core.utils.symbolic.SymbolicEngine;
import org.eclipse.iee.web.parser.DefaultDocumentParser;
import org.eclipse.iee.web.renderer.DefaultHTMLDocumentRenderer;
import org.eclipse.iee.web.renderer.FormulaHTMLRenderer;
import org.eclipse.iee.web.renderer.FormulaImageRenderer;
import org.eclipse.iee.web.renderer.GraphHTMLRenderer;
import org.eclipse.iee.web.renderer.HTMLRendererManager;
import org.eclipse.iee.web.renderer.ImageHTMLRenderer;
import org.eclipse.iee.web.renderer.InputHTMLRenderer;
import org.eclipse.iee.web.renderer.SymbolicHTMLRenderer;
import org.eclipse.iee.web.renderer.TextHTMLRenderer;
import org.eclipse.iee.web.servlet.TestServlet;
import org.eclipse.iee.web.store.InMemoryEvaluationContextStore;
import org.eclipse.iee.web.ui.store.DevDocumentStore;
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
		DefaultDocumentParser parser = new DefaultDocumentParser(IeeEditorPlugin.getPadManager());
		DevDocumentStore documentStore = new DevDocumentStore(workspace.getRoot().getLocation().toFile(), parser);
		TestServlet servlet = new TestServlet();
		servlet.setDocumentRenderer(new DefaultHTMLDocumentRenderer(registerRenderer(new HTMLRendererManager())));
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
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		server.stop();
		server = null;
	}

	private HTMLRendererManager registerRenderer(HTMLRendererManager rendererManager) {
		FormulaImageRenderer formulaImageRenderer = new FormulaImageRenderer();
		rendererManager.registerPadHTMLRenderer("Formula", new FormulaHTMLRenderer(formulaImageRenderer));
		rendererManager.registerPadHTMLRenderer("Input", new InputHTMLRenderer(formulaImageRenderer));
		rendererManager.registerPadHTMLRenderer("Symbolic", new SymbolicHTMLRenderer(new SymbolicEngine(), formulaImageRenderer));
		rendererManager.registerPadHTMLRenderer("Image", new ImageHTMLRenderer());
		rendererManager.registerPadHTMLRenderer("Text", new TextHTMLRenderer());
		rendererManager.registerPadHTMLRenderer("Graph", new GraphHTMLRenderer(formulaImageRenderer));
		return rendererManager;
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
