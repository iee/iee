package org.eclipse.iee.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.iee.document.api.EvaluationContextHolder;
import org.eclipse.iee.document.api.IParameterProvider;
import org.eclipse.iee.document.api.IResultContainer;
import org.eclipse.iee.document.api.stub.FileResultContainer;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.PadManager;
import org.eclipse.iee.web.document.Document;
import org.eclipse.iee.web.document.DocumentPart;
import org.eclipse.iee.web.document.PadDocumentPart;
import org.eclipse.iee.web.parser.DefaultDocumentParser;
import org.eclipse.iee.web.renderer.DefaultHTMLDocumentRenderer;
import org.eclipse.iee.web.renderer.DefaultHTMLRendererContext;
import org.eclipse.iee.web.renderer.DefaultResourceRendererContext;
import org.eclipse.iee.web.renderer.HTMLRendererManager;
import org.eclipse.iee.web.renderer.IHTMLRenderer;
import org.eclipse.iee.web.renderer.IHTMLRendererContext;
import org.eclipse.iee.web.renderer.IResourceRenderContext;
import org.eclipse.iee.web.store.DevDocumentStore;
import org.eclipse.iee.web.store.IDocumentStore;

public class TestServlet extends HttpServlet {

	private HTMLRendererManager manager;
	
	private DefaultHTMLDocumentRenderer documentRenderer;
	
	private IDocumentStore documentStore;
	
	public TestServlet(File root, PadManager padManager, HTMLRendererManager manager) {
		super();
		this.manager = manager;
		documentRenderer = new DefaultHTMLDocumentRenderer(manager);
		documentStore = new DevDocumentStore(root, new DefaultDocumentParser(padManager));
	}	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		String[] parts = pathInfo.split("/");
		
		String projectLoc = parts[1];
		String clazz = parts[2];
		boolean isEditMode = "1".equals(req.getParameter("edit"));
		Document document = documentStore.getDocument(projectLoc, clazz);
		IParameterProvider parameterProvider = new RequestParameterProvider(req);
		IResultContainer container = evaluateDocument(projectLoc, clazz, parameterProvider);
		String docRoot = req.getContextPath() + req.getServletPath() + '/' + URLEncoder.encode(parts[1], "utf-8") + '/' +  URLEncoder.encode(parts[2], "utf-8");
		Enumeration<String> parameterNames = req.getParameterNames();
		Map<String, String> params = new HashMap<>();
		while (parameterNames.hasMoreElements()) {
			String nextElement = parameterNames.nextElement();
			params.put(nextElement, req.getParameter(nextElement));
		}
		if (parts.length == 3) {
			IHTMLRendererContext htmlRendererContext = new DefaultHTMLRendererContext(docRoot, params, container, isEditMode, parameterProvider);
			PrintWriter writer = resp.getWriter();
			writer.append("<html><head>");
			documentRenderer.renderHTMLHead(document, writer, htmlRendererContext);
			writer.append("</head><body>");
			if (!isEditMode) {
				writer.append("<div>");
				Map<String, String> editParam = new HashMap<>();
				editParam.put("edit", "1");
				writer.append("<a href='").append(htmlRendererContext.createURL(editParam)).append("'>Edit</a>");
				writer.append("</div>");
			}
			if (isEditMode) {
				writer.append("<form>");
				writer.append("<div>");
				writer.append("<input type='submit' value='Calculate'>");
				writer.append("</div>");
			}
			documentRenderer.renderHTMLBody(document, writer, htmlRendererContext);
			if (isEditMode) {
				writer.append("</form>");
			}
			writer.append("</body></html>");
		} else if (parts.length == 4) {
			IResourceRenderContext resourceRenderContext = new DefaultResourceRendererContext(docRoot, params, container, isEditMode, documentStore, req, resp, projectLoc, clazz, parameterProvider);
			List<DocumentPart> children = document.getRoot().getChildren();
			for (DocumentPart documentPart : children) {
				if (documentPart instanceof PadDocumentPart) {
					Pad pad = ((PadDocumentPart) documentPart).getPad();
					if (parts[3].equals(pad.getContainerID())) {
						IHTMLRenderer<Pad> renderer = manager.getPadHTMLRenderer(pad.getType());
						renderer.renderResource(pad, resourceRenderContext);
					}
				}
			}
		}
	}

	protected IResultContainer evaluateDocument(String projectLoc, String clazz, IParameterProvider parameterProvider)
			throws IOException {
		ClassLoader classLoader = documentStore.getDocumentClassLoader(projectLoc, clazz);
		Class<?> loadClass;
		IResultContainer container = new FileResultContainer();
		EvaluationContextHolder.setResultContainer(container);
		EvaluationContextHolder.setParameterProvider(parameterProvider);
		try {
			loadClass = classLoader.loadClass(clazz);
			Method main = loadClass.getMethod("main", String[].class);
				main.invoke(null, (Object) new String[] {});
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} finally {
			EvaluationContextHolder.cleanContext();
		}
		return container;
	}

}
