package org.eclipse.iee.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.iee.core.EvaluationContextHolder;
import org.eclipse.iee.core.FileResultContainer;
import org.eclipse.iee.core.IParameterProvider;
import org.eclipse.iee.core.IResultContainer;
import org.eclipse.iee.core.document.Document;
import org.eclipse.iee.core.store.IDocumentStore;
import org.eclipse.iee.core.store.IEvaluationContextStore;
import org.eclipse.iee.web.RequestParameterProvider;
import org.eclipse.iee.web.renderer.IHTMLDocumentRenderer;
import org.eclipse.iee.web.renderer.IHTMLRendererContext;
import org.eclipse.iee.web.renderer.IResourceRenderContext;

public class TestServlet extends HttpServlet {

	private IHTMLDocumentRenderer documentRenderer;

	private IDocumentStore documentStore;

	private IEvaluationContextStore resultStore;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		String[] parts = pathInfo.split("/");

		String projectLoc = parts[1];
		String clazz = parts[2];
		boolean isEditMode = "1".equals(req.getParameter("edit"));
		Document document = documentStore.getDocument(projectLoc, clazz);
		if (document == null) {
			do404(req, resp);
			return;
		}
		String evaluationId = req.getParameter("evalId");
		IParameterProvider parameterProvider;
		IResultContainer container;
		if (evaluationId != null) {
			parameterProvider = resultStore.getParameterProvider(evaluationId);
			container = resultStore.getResultContainer(evaluationId);
		} else {
			evaluationId = UUID.randomUUID().toString();
			parameterProvider = new RequestParameterProvider(req);
			container = evaluateDocument(projectLoc, clazz, parameterProvider);
			resultStore.putParameterProvider(evaluationId, parameterProvider);
			resultStore.putResultContainer(evaluationId, container);
		}
		String docRoot = req.getContextPath() + req.getServletPath() + '/'
				+ URLEncoder.encode(parts[1], "utf-8") + '/'
				+ URLEncoder.encode(parts[2], "utf-8");
		Enumeration<String> parameterNames = req.getParameterNames();
		Map<String, String> params = new HashMap<>();
		while (parameterNames.hasMoreElements()) {
			String nextElement = parameterNames.nextElement();
			params.put(nextElement, req.getParameter(nextElement));
		}
		if (parts.length == 3) {
			IHTMLRendererContext htmlRendererContext = new DefaultHTMLRendererContext(
					evaluationId, req, resp, docRoot, params, documentStore,
					projectLoc, clazz, container, isEditMode, parameterProvider);
			PrintWriter writer = resp.getWriter();
			writer.append("<html><head>");
			documentRenderer.renderHTMLHead(document, htmlRendererContext);
			writer.append("</head><body>");
			if (!isEditMode) {
				writer.append("<div>");
				Map<String, String> editParam = new HashMap<>();
				editParam.put("edit", "1");
				writer.append("<a href='")
						.append(htmlRendererContext.createURL(editParam))
						.append("'>Edit</a>");
				writer.append("</div>");
			}
			if (isEditMode) {
				writer.append("<form>");
				writer.append("<div>");
				writer.append("<input type='submit' value='Calculate'>");
				writer.append("</div>");
			}
			documentRenderer.renderHTMLBody(document, htmlRendererContext);
			if (isEditMode) {
				writer.append("</form>");
			}
			writer.append("</body></html>");
		} else if (parts.length > 3) {
			IResourceRenderContext resourceRenderContext = new DefaultResourceRendererContext(
					evaluationId, docRoot, params, container, isEditMode,
					documentStore, req, resp, projectLoc, clazz,
					parameterProvider);
			String resourceId;
			if (parts.length > 4) {
				String[] copyOfRange = Arrays.copyOfRange(parts, 4,
						parts.length);
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < copyOfRange.length; i++) {
					if (i > 0) {
						sb.append("/");
					}
					sb.append(copyOfRange[i]);
				}
				resourceId = sb.toString();
			} else {
				resourceId = "";
			}
			documentRenderer.renderResource(document, parts[3], resourceId,
					resourceRenderContext);
		}
	}

	private void do404(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		resp.getWriter().append("<html><body>Sorry. Document is not available.</body></html>");
	}

	protected IResultContainer evaluateDocument(String projectLoc,
			String clazz, IParameterProvider parameterProvider)
			throws IOException {
		IResultContainer container = createResultContainer();
		EvaluationContextHolder.setResultContainer(container);
		EvaluationContextHolder.setParameterProvider(parameterProvider);
		try {
			Class<?> loadClass = documentStore.getDocumentClass(projectLoc,
					clazz);
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

	protected IResultContainer createResultContainer() {
		return new FileResultContainer();
	}

	public IHTMLDocumentRenderer getDocumentRenderer() {
		return documentRenderer;
	}

	public void setDocumentRenderer(IHTMLDocumentRenderer documentRenderer) {
		this.documentRenderer = documentRenderer;
	}

	public IDocumentStore getDocumentStore() {
		return documentStore;
	}

	public void setDocumentStore(IDocumentStore documentStore) {
		this.documentStore = documentStore;
	}

	public IEvaluationContextStore getResultStore() {
		return resultStore;
	}

	public void setEvaluationContextStore(IEvaluationContextStore resultStore) {
		this.resultStore = resultStore;
	}

}
