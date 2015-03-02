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
public class CollapseEndPadWriter implements IPadWriter<CollapseEndPart> {

	@Override
	public String getType() {
		return "CollapseEnd";
	}

	@Override
	public String getValue(CollapseEndPart part) {
		return "";
	}

	@Override
	public Map<String, String> getParams(CollapseEndPart part) {
		Map<String, String> params = new HashMap<>();
		return params;
	}

}