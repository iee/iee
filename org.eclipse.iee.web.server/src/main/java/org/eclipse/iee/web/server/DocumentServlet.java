/**
 * 
 */
package org.eclipse.iee.web.server;

import java.io.File;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.apache.commons.lang3.text.StrSubstitutor;
import org.eclipse.iee.document.api.IResultContainer;
import org.eclipse.iee.document.api.stub.InMemoryResultContainer;
import org.eclipse.iee.editor.core.pad.PadManager;
import org.eclipse.iee.editor.core.utils.symbolic.SymbolicEngine;
import org.eclipse.iee.pad.fem3d.Fem3DPadFactory;
import org.eclipse.iee.sample.formula.FormulaPadFactory;
import org.eclipse.iee.sample.formula.InputPadFactory;
import org.eclipse.iee.sample.formula.SymbolicPadFactory;
import org.eclipse.iee.sample.graph.GraphPadFactory;
import org.eclipse.iee.sample.image.ImagePadFactory;
import org.eclipse.iee.sample.text.TextPadFactory;
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
import org.eclipse.iee.web.server.store.OSGIContainerDocumentStore;
import org.eclipse.iee.web.servlet.TestServlet;
import org.eclipse.iee.web.store.InMemoryEvaluationContextStore;

/**
 * @author aefimchuk
 *
 */
public class DocumentServlet extends TestServlet {
	
	private OSGIContainerDocumentStore containerStore;

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		String ieeFolder = StrSubstitutor.replaceSystemProperties(arg0.getInitParameter("iee-folder"));
		File file = new File(ieeFolder);
		if (!file.exists()) {
			file.mkdirs();
		}
		PadManager padManager = new PadManager();
		padManager.registerPadFactory(new FormulaPadFactory());
		padManager.registerPadFactory(new InputPadFactory());
		padManager.registerPadFactory(new SymbolicPadFactory());
		padManager.registerPadFactory(new TextPadFactory());
		padManager.registerPadFactory(new GraphPadFactory());
		padManager.registerPadFactory(new ImagePadFactory());
		padManager.registerPadFactory(new Fem3DPadFactory());
		DefaultDocumentParser documentParser = new DefaultDocumentParser(padManager);
		containerStore = new OSGIContainerDocumentStore(ieeFolder, documentParser);	
		setDocumentStore(containerStore);
		FormulaImageRenderer formulaImageRenderer = new FormulaImageRenderer();
		HTMLRendererManager manager = new HTMLRendererManager();
		manager.registerPadHTMLRenderer("Formula", new FormulaHTMLRenderer(formulaImageRenderer));
		manager.registerPadHTMLRenderer("Input", new InputHTMLRenderer(formulaImageRenderer));
		manager.registerPadHTMLRenderer("Symbolic", new SymbolicHTMLRenderer(new SymbolicEngine(), formulaImageRenderer));
		manager.registerPadHTMLRenderer("Image", new ImageHTMLRenderer());
		manager.registerPadHTMLRenderer("Text", new TextHTMLRenderer());
		manager.registerPadHTMLRenderer("Graph", new GraphHTMLRenderer(formulaImageRenderer));
		setDocumentRenderer(new DefaultHTMLDocumentRenderer(manager));
		setEvaluationContextStore(new InMemoryEvaluationContextStore());
	}
	
	@Override
	protected IResultContainer createResultContainer() {
		return new InMemoryResultContainer();
	}
	
	@Override
	public void destroy() {
		containerStore.stop();
	}
	
}
