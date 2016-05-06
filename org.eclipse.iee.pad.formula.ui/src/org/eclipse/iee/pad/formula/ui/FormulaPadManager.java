package org.eclipse.iee.pad.formula.ui;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.iee.editor.core.pad.Pad;

public class FormulaPadManager {

	public static List<Pad<?>> getFollowingPads(Pad<?> pad) {		
		List<Pad<?>> pads = pad.getContainer().getContainerManager().selectPadsByType(pad.getType());
		
		Collections.sort(pads, new Comparator<Pad<?>>() {
			@Override
			public int compare(Pad<?> pad1, Pad<?> pad2) {
				int offset1 = pad1.getContainer().getPosition().getOffset();
				int offset2 = pad2.getContainer().getPosition().getOffset();
				if (offset1 < offset2) {
					return -1;
				} else if (offset1 == offset2) {
					return 0;
				} else {
					return 1;
				}
			}
		});
		
		return pads.subList(pads.indexOf(pad), pads.size());
	}

}
