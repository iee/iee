package org.eclipse.iee.pad.fem3d;

import java.util.Map;

import org.eclipse.iee.core.document.parser.IPadParser;
import org.osgi.service.component.annotations.Component;

/**
 * {@link IPadParser} implementation. Creates instance of graph pad.
 */
@Component
public class Fem3DPadParser implements IPadParser {

	@Override
	public Fem3DPart create(Map<String, String> padParams, String value) {
		Fem3DPart graphPad = new Fem3DPart(value);
		graphPad.setId(padParams.get("id"));
		return graphPad;
	}
	
	@Override
	public String getType() {
		return "Threedview";
	}

}