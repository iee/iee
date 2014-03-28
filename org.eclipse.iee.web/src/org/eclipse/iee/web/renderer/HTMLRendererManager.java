package org.eclipse.iee.web.renderer;

import java.util.Set;

import org.eclipse.iee.core.HandlerManager;
import org.eclipse.iee.core.document.DocumentPart;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.reflect.TypeToken;

@Component
public class HTMLRendererManager implements IHTMLRendererManager {

	private static final LoadingCache<Class<?>, Set<Class<?>>> flattenHierarchyCache = CacheBuilder
			.newBuilder().weakKeys()
			.build(new CacheLoader<Class<?>, Set<Class<?>>>() {
				@Override
				@SuppressWarnings({ "unchecked", "rawtypes" })
				public Set<Class<?>> load(Class<?> concreteClass) {
					return (Set) TypeToken.of(concreteClass).getTypes()
							.rawTypes();
				}
			});

	/** Registered pad html renderers. */
	@SuppressWarnings("rawtypes")
	private final HandlerManager<IHTMLRenderer> fhtmlRenderers = new HandlerManager<>(
			IHTMLRenderer.class);

	@Reference(cardinality = ReferenceCardinality.MULTIPLE, unbind = "unregisterPadHTMLRenderer", policy = ReferencePolicy.DYNAMIC)
	public void registerPadHTMLRenderer(IHTMLRenderer<?> renderer) {
		fhtmlRenderers.registerHandler(renderer);
	}

	public void unregisterPadHTMLRenderer(IHTMLRenderer<?> renderer) {
		fhtmlRenderers.unregisterHandler(renderer);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.iee.web.renderer.IHTMLRendererManager#getPadHTMLRenderer(T)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <T extends DocumentPart> IHTMLRenderer<T> getPadHTMLRenderer(T part) {
		Set<Class<?>> hierarchy = flattenHierarchyCache.getUnchecked(part.getClass());
		for (Class<?> clz : hierarchy) {
			IHTMLRenderer<T> handler = fhtmlRenderers.getHandler(clz);
			if (handler != null) {
				return handler;
			}
		}
		return null;
	}

}
