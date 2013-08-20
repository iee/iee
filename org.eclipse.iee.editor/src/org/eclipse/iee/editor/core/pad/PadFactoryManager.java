package org.eclipse.iee.editor.core.pad;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PadFactoryManager {

	/** Registered pad factories. */
	private Map<String, IPadFactory> fPadFactories = new HashMap<String, IPadFactory>();
	
	public void registerPadFactory(IPadFactory factory) {
		String type = factory.getType();
		fPadFactories.put(type, factory);
	}

	public void unregisterPadFactory(IPadFactory factory) {
		Set<Entry<String, IPadFactory>> entrySet = fPadFactories.entrySet();
		for (Iterator<Entry<String, IPadFactory>> iterator = entrySet
				.iterator(); iterator.hasNext();) {
			Entry<String, IPadFactory> entry = iterator.next();
			if (entry.getValue() == factory) {
				iterator.remove();
			}
		}
	}
	
}
