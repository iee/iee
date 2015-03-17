package org.eclipse.iee.editor.core.pad.common;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.iee.core.document.parser.IPadParser;
import org.eclipse.iee.core.document.writer.IPadWriter;
import org.osgi.service.component.annotations.Component;

/**
 * {@link IPadParser} implementation. Creates instance of image pad.
 */
@Component
public class ProgressPadWriter implements IPadWriter<ProgressDocumentPart> {

	@Override
	public String getType() {
		return "Progress";
	}

	@Override
	public String getValue(ProgressDocumentPart part) {
		return part.getStatus();
	}

	@Override
	public Map<String, String> getParams(ProgressDocumentPart part) {
		Map<String, String> params = new HashMap<>();
		params.put("progress", String.valueOf(part.getProgress()));
		return params;
	}

}