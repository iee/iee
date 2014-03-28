/**
 * 
 */
package org.eclipse.iee.web.server;

import java.io.File;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.apache.commons.lang3.text.StrSubstitutor;
import org.eclipse.iee.core.IResultContainer;
import org.eclipse.iee.core.InMemoryResultContainer;
import org.eclipse.iee.core.document.parser.DefaultDocumentParser;
import org.eclipse.iee.core.store.InMemoryEvaluationContextStore;
import org.eclipse.iee.pad.formula.FormulaPadParser;
import org.eclipse.iee.pad.formula.InputPadParser;
import org.eclipse.iee.pad.formula.SymbolicEngine;
import org.eclipse.iee.pad.formula.SymbolicPadParser;
import org.eclipse.iee.pad.graph.GraphPadParser;
import org.eclipse.iee.pad.image.ImagePadParser;
import org.eclipse.iee.pad.text.TextPadParser;
import org.eclipse.iee.web.renderer.DefaultHTMLDocumentRenderer;
import org.eclipse.iee.web.renderer.DefaultTextRenderer;
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
		DefaultDocumentParser documentParser = new DefaultDocumentParser();
		documentParser.registerPadParser(new InputPadParser());
		documentParser.registerPadParser(new FormulaPadParser());
		documentParser.registerPadParser(new SymbolicPadParser());
		documentParser.registerPadParser(new TextPadParser());
		documentParser.registerPadParser(new GraphPadParser());
		documentParser.registerPadParser(new ImagePadParser());
		containerStore = new OSGIContainerDocumentStore(ieeFolder, documentParser);	
		setDocumentStore(containerStore);
		FormulaImageRenderer formulaImageRenderer = new FormulaImageRenderer();
		HTMLRendererManager manager = new HTMLRendererManager();
		manager.registerPadHTMLRenderer(new FormulaHTMLRenderer(formulaImageRenderer));
		manager.registerPadHTMLRenderer(new InputHTMLRenderer(formulaImageRenderer));
		manager.registerPadHTMLRenderer(new SymbolicHTMLRenderer(new SymbolicEngine(), formulaImageRenderer));
		manager.registerPadHTMLRenderer(new ImageHTMLRenderer());
		manager.registerPadHTMLRenderer(new TextHTMLRenderer());
		manager.registerPadHTMLRenderer(new DefaultTextRenderer());
		manager.registerPadHTMLRenderer(new GraphHTMLRenderer(formulaImageRenderer));
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
