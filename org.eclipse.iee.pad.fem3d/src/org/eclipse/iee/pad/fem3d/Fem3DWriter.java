package org.eclipse.iee.pad.fem3d;

import java.util.Map;

import org.eclipse.iee.core.document.writer.IPadWriter;
import org.osgi.service.component.annotations.Component;

import com.google.common.collect.Maps;

@Component
public class Fem3DWriter implements IPadWriter<Fem3DPart> {

	@Override
	public String getValue(Fem3DPart part) {
		return part.getModelVariable();
	}

	@Override
	public Map<String, String> getParams(Fem3DPart part) {
		return Maps.newHashMap();
	}

	@Override
	public String getType() {
		return "Threedview";
	}

}
