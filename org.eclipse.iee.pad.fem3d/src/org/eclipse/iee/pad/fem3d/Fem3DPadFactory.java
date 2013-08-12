package org.eclipse.iee.pad.fem3d;

import java.util.Map;

import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.Pad;

/**
 * {@link IPadFactory} implementation. Creates instance of graph pad.
 */
public class Fem3DPadFactory implements IPadFactory {

	@Override
	public Pad create(Map<String, String> padParams, String value) {
		Fem3DPad graphPad = new Fem3DPad(value);
		return graphPad;
	}
	
	@Override
	public String getType() {
		return "Fem3D";
	}

}