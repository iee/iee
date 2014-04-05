package org.eclipse.iee.editor.core.pad;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.iee.core.document.PadDocumentPart;

public class PadFactoryManager {

	/** Registered pad factories. */
	private Map<Class<? extends PadDocumentPart>, IPadFactory<?>> fPadFactories = new HashMap<>();
	
	public void registerPadFactory(IPadFactory<?> factory) {
		fPadFactories.put(getType(factory), factory);
	}

	public void unregisterPadFactory(IPadFactory<?> factory) {
		Set<Entry<Class<? extends PadDocumentPart>, IPadFactory<?>>> entrySet = fPadFactories.entrySet();
		for (Iterator<Entry<Class<? extends PadDocumentPart>, IPadFactory<?>>> iterator = entrySet
				.iterator(); iterator.hasNext();) {
			Entry<Class<? extends PadDocumentPart>, IPadFactory<?>> entry = iterator.next();
			if (entry.getValue() == factory) {
				iterator.remove();
			}
		}
	}
	
	private Class<? extends PadDocumentPart> getType(IPadFactory<?> factory) {
		//???
		return null;
	}
	
}
