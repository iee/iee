package org.eclipse.iee.editor.core.pad.common;

import java.util.Map;

import org.eclipse.iee.core.document.parser.IPadParser;
import org.osgi.service.component.annotations.Component;

@Component
public class CollapseBeginPadParser implements IPadParser {

	@Override
	public CollapseEndPart create(Map<String, String> padParams, String value) {
		CollapseEndPart colapseEndPart = new CollapseEndPart();
		return colapseEndPart;
	}
	
	@Override
	public String getType() {
		return "CollapseEnd";
	}

}