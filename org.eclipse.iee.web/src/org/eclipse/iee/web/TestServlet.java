package org.eclipse.iee.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.apache.commons.lang3.StringEscapeUtils;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.PadManager;
import org.eclipse.iee.editor.core.pad.result.FileResultContainer;
import org.eclipse.iee.editor.core.pad.result.IResultContainer;
import org.eclipse.iee.editor.core.pad.result.ResultContainerHolder;
import org.eclipse.iee.web.renderer.DefaultHTMLRendererContext;
import org.eclipse.iee.web.renderer.DefaultResourceRendererContext;
import org.eclipse.iee.web.renderer.HTMLRendererManager;
import org.eclipse.iee.web.renderer.IHTMLRenderer;
import org.eclipse.iee.web.renderer.IHTMLRendererContext;
import org.eclipse.iee.web.renderer.IResourceRenderContext;


public class TestServlet extends HttpServlet {

	private HTMLRendererManager manager;
	
	private PadManager padManager;
	
	public TestServlet(PadManager padManager, HTMLRendererManager manager) {
		super();
		this.padManager = padManager;
		this.manager = manager;
	}	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		String[] parts = pathInfo.split("/");
		
		String projectLoc = parts[1];
		String clazz = parts[2];
		InputStream resource = new FileInputStream(new File(projectLoc, "src/" + clazz.replace(".", "/") + ".java"));
		URLClassLoader classLoader = new URLClassLoader(new URL[] {new File(projectLoc, "bin").toURL()}, getClass().getClassLoader());
		Class<?> loadClass;
		IResultContainer container = new FileResultContainer();
		ResultContainerHolder.setResultContainer(container);
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
			ResultContainerHolder.removeResultContainer();
		}
		ANTLRInputStream st = new ANTLRInputStream(resource);
		JavaLexer lexer = new JavaLexer(st);
		String docRoot = req.getContextPath() + req.getServletPath() + '/' + URLEncoder.encode(parts[1], "utf-8") + '/' +  URLEncoder.encode(parts[2], "utf-8");
		if (parts.length == 3) {
			IHTMLRendererContext htmlRendererContext = new DefaultHTMLRendererContext(docRoot, container);
			PrintWriter writer = resp.getWriter();
			writer.append("<html><head><style type='text/css'>").append(appendStyles()).append("'</style></head><body><div class='source'><pre>");
			for (Token token = lexer.nextToken(); token.getType() != Token.EOF; token = lexer.nextToken()) {
				appendToken(token, writer, htmlRendererContext);
			}
			writer.append("</pre></div></body></html>");
		} else if (parts.length == 4) {
			IResourceRenderContext resourceRenderContext = new DefaultResourceRendererContext(docRoot, container, new File(projectLoc, "pads"), req, resp);
			for (Token token = lexer.nextToken(); token.getType() != Token.EOF; token = lexer.nextToken()) {
				if (token.getType() == JavaLexer.Pad) {
					Pad pad = parsePad(token);
					if (parts[3].equals(pad.getContainerID())) {
						IHTMLRenderer<Pad> renderer = manager.getPadHTMLRenderer(pad.getType());
						renderer.renderResource(pad, resourceRenderContext);
					}
				}
			}
		}
	}
	
	private String appendStyles() {
		StringBuilder sb = new StringBuilder();
		sb.append(".source .keyword {color: #7F0055;}");
		sb.append(".source .linecomment {color: #3F7F5F;}");
		sb.append(".source .comment {color: #3F7F5F;}");
		sb.append(".source .javadoc {color: #3F5FBF;}");
		sb.append(".source .stringliteral {color: #2A00FF;}");
		return sb.toString();
	}

	private void appendToken(Token token, Writer writer, IHTMLRendererContext context) throws IOException {
		int type = token.getType();
		if (type == JavaLexer.Pad) {
			Pad pad = parsePad(token);
			IHTMLRenderer<Pad> renderer = manager.getPadHTMLRenderer(pad.getType());
			renderer.renderPad(pad, writer, context);
		} else if (type == JavaLexer.Ws) { 
			writer.write(token.getText());
		} else {
			writer.append("<span class = '").append(JavaLexer.tokenNames[type].toLowerCase()).append("' >").append(StringEscapeUtils.escapeHtml4(token.getText())).append("</span>");
		}
	}

	private Pad parsePad(Token token) {
		String replace = token.getText().replace("/*<", "").replace(">*/", "");
		int indexOf = replace.indexOf("<*/");
		if (indexOf != -1) {
			replace = replace.substring(0, indexOf);
		}
		Pad pad = padManager.parsePad(replace);
		return pad;
	};

}
