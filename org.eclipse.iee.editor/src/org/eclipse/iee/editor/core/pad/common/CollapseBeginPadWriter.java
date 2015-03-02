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
public class CollapseBeginPadWriter implements IPadWriter<CollapseBeginPart> {

	@Override
	public String getType() {
		return "CollapseBegin";
	}

	@Override
	public String getValue(CollapseBeginPart part) {
		return "";
	}

	@Override
	public Map<String, String> getParams(CollapseBeginPart part) {
		Map<String, String> params = new HashMap<>();
		return params;
	}

}