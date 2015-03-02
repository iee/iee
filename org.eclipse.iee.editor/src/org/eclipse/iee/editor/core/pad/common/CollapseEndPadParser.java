package org.eclipse.iee.editor.core.pad.common;

import java.util.Map;

import org.eclipse.iee.core.document.parser.IPadParser;
import org.osgi.service.component.annotations.Component;

@Component
public class CollapseEndPadParser implements IPadParser {

	@Override
	public CollapseBeginPart create(Map<String, String> padParams, String value) {
		CollapseBeginPart colapseBeginPart = new CollapseBeginPart();
		return colapseBeginPart;
	}
	
	@Override
	public String getType() {
		return "CollapseBegin";
	}

}