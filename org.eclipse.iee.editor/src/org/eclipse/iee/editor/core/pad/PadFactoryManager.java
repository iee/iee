package org.eclipse.iee.editor.core.pad;

import org.eclipse.iee.core.HandlerManager;
import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.editor.core.pad.common.LoadingPad;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

@Component
public class PadFactoryManager implements IPadFactoryManager {

	/** Registered pad factories. */
	@SuppressWarnings("rawtypes")
	private final HandlerManager<IPadFactory> fPadFactories = new HandlerManager<IPadFactory>(IPadFactory.class);


	public PadFactoryManager() {
	}

	@Reference(cardinality = ReferenceCardinality.MULTIPLE, unbind = "unregisterPadFactory", policy = ReferencePolicy.DYNAMIC)
	public <T extends PadDocumentPart> void registerPadFactory(IPadFactory<T> factory) {
		fPadFactories.registerHandler(factory);
	}

	public void unregisterPadFactory(IPadFactory<?> factory) {
		fPadFactories.unregisterHandler(factory);
	}

	@Override
	public <T extends PadDocumentPart> Pad<T> createPad(T padPart) {
		IPadFactory iPadFactory = fPadFactories.getHandler(padPart.getClass());
		Pad<T> pad;
		if (iPadFactory != null) {
			pad = iPadFactory.create(padPart);
		} else {
			pad = (Pad<T>) new LoadingPad(padPart);
		}
		return pad;
	}

}
