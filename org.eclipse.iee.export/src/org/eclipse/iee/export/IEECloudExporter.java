/**
 * 
 */
package org.eclipse.iee.export;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import org.eclipse.iee.core.IParameterProvider;
import org.eclipse.iee.core.IResultContainer;
import org.eclipse.iee.core.InMemoryResultContainer;
import org.eclipse.iee.core.NullParameterProvider;
import org.eclipse.iee.core.document.Document;
import org.eclipse.iee.core.document.DocumentPart;
import org.eclipse.iee.export.model.Field;
import org.eclipse.iee.export.model.FloatField;
import org.eclipse.iee.export.model.HTMLField;
import org.eclipse.iee.export.model.Worksheet;
import org.eclipse.iee.pad.formula.InputPart;
import org.eclipse.iee.web.renderer.IHTMLRenderer;
import org.eclipse.iee.web.renderer.IHTMLRendererContext;
import org.eclipse.iee.web.renderer.IHTMLRendererManager;

import com.google.common.base.Throwables;

/**
 * @author aefimchuk
 * 
 */
public class IEECloudExporter {

	private final IHTMLRendererManager manager;

	public IEECloudExporter(IHTMLRendererManager manager) {
		this.manager = manager;
	}

	public Worksheet export(Document document) {
		Worksheet ws = new Worksheet();
		DocumentPart root = document.getRoot();
		List<DocumentPart> children = root.getChildren();
		for (DocumentPart documentPart : children) {
			ws.addField(export(documentPart));
		}
		return ws;
	}

	private Field export(DocumentPart documentPart) {
		Field f;
		if (documentPart instanceof InputPart) {
			FloatField flt = new FloatField();
			flt.setName(((InputPart) documentPart).getVariable());
			flt.setSampleValue(Double.parseDouble(((InputPart) documentPart).getDefaultValue()));
			f = flt;
		} else {
			IHTMLRenderer<DocumentPart> padHTMLRenderer = manager
					.getPadHTMLRenderer(documentPart);
			HTMLField html = new HTMLField();
			html.setHtml(getHTMLString(documentPart, padHTMLRenderer));
			f = html; 
		}
		return f;
	}

	private String getHTMLString(DocumentPart documentPart,
			IHTMLRenderer<DocumentPart> padHTMLRenderer) {
		try (final StringWriter writer = new StringWriter()) {
			padHTMLRenderer.renderPad(documentPart, new IHTMLRendererContext() {
				@Override
				public boolean isEditMode() {
					return false;
				}

				@Override
				public Writer getWriter() throws IOException {
					return writer;
				}

				@Override
				public IResultContainer getResultContainer() {
					return new InMemoryResultContainer();
				}

				@Override
				public InputStream getResourceAsStream(String string)
						throws IOException {
					return null;
				}

				@Override
				public IParameterProvider getParameterProvider() {
					return new NullParameterProvider();
				}

				@Override
				public String createURL(Map<String, String> params) {
					return null;
				}

				@Override
				public String createResourceURL(String padId,
						String resourceId, Map<String, String> params) {
					return "img/" + resourceId;
				}
			});
			return writer.toString();
		} catch (IOException e) {
			throw Throwables.propagate(e);
		}
	}

	private Field createUnknownField(DocumentPart documentPart) {
		HTMLField f = new HTMLField();
		f.setHtml("Unknown field");
		return f;
	}

}
