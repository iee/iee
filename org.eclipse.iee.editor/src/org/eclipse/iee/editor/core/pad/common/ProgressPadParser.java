package org.eclipse.iee.editor.core.pad.common;

import java.util.Map;

import org.eclipse.iee.core.document.parser.IPadParser;
import org.osgi.service.component.annotations.Component;

import com.google.common.base.Strings;

@Component
public class ProgressPadParser implements IPadParser {

	@Override
	public ProgressDocumentPart create(Map<String, String> padParams, String value) {
		ProgressDocumentPart colapseBeginPart = new ProgressDocumentPart();
		String string = padParams.get("progress");
		if (!Strings.isNullOrEmpty(string)) {
			colapseBeginPart.setProgress(Integer.parseInt(string));
		}
		colapseBeginPart.setStatus(value);
		return colapseBeginPart;
	}
	
	@Override
	public String getType() {
		return "Progress";
	}

}