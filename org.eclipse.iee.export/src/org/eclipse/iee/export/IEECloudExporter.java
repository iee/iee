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
import org.eclipse.iee.core.store.IDocumentStore;
import org.eclipse.iee.export.model.Field;
import org.eclipse.iee.export.model.FloatField;
import org.eclipse.iee.export.model.FloatValidation;
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

	private final IDocumentStore documentStore;
	
	public IEECloudExporter(IHTMLRendererManager manager, IDocumentStore documentStore) {
		this.manager = manager;
		this.documentStore = documentStore;
	}

	public PackageBuilder export(Document document) {
		PackageBuilder builder = new PackageBuilder();
		Worksheet ws = new Worksheet();
		DocumentPart root = document.getRoot();
		List<DocumentPart> children = root.getChildren();
		for (DocumentPart documentPart : children) {
			ws.addField(export(builder, documentPart));
		}
		builder.setBundleName(document.getBundle());
		builder.setBundleDescription(document.getVersion());
		return builder.setWorksheet(ws);
	}

	private Field export(PackageBuilder builder, DocumentPart documentPart) {
		Field f;
		if (documentPart instanceof InputPart) {
			FloatField flt = new FloatField();
			flt.setName(((InputPart) documentPart).getVariable());
			flt.setSampleValue(Double.parseDouble(((InputPart) documentPart).getDefaultValue()));
			FloatValidation validation = new FloatValidation();
			validation.setMax(validation.getMax());
			validation.setMin(validation.getMin());
			f = flt;
		} else {
			IHTMLRenderer<DocumentPart> padHTMLRenderer = manager
					.getPadHTMLRenderer(documentPart);
			HTMLField html = new HTMLField();
			html.setHtml(getHTMLString(builder, documentPart, padHTMLRenderer));
			f = html;
		}
		return f;
	}

	private String getHTMLString(final PackageBuilder packageBuilder,
			final DocumentPart documentPart,
			final IHTMLRenderer<DocumentPart> padHTMLRenderer) {
		try (final StringWriter writer = new StringWriter()) {
			IHTMLRendererContext context = new IHTMLRendererContext() {
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
					String resourcePath = padId + ".png";
					packageBuilder.addResource(
							resourcePath, 
							new PackageResourceProvider(manager, documentStore, resourcePath, documentPart)
							);
					
					return "img/" + resourcePath;
				}
			};
			padHTMLRenderer.renderPad(documentPart, context);
			return writer.toString();
		} catch (IOException e) {
			throw Throwables.propagate(e);
		}
	}

}
