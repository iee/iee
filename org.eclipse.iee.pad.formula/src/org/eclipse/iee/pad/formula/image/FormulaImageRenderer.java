package org.eclipse.iee.pad.formula.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.eclipse.iee.pad.formula.FormulaPart;
import org.osgi.service.component.annotations.Component;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

import com.google.common.base.Throwables;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

@Component(service = FormulaImageRenderer.class)
public class FormulaImageRenderer {

	private final Cache<String, BufferedImage> images = CacheBuilder.newBuilder().expireAfterAccess(1, TimeUnit.MINUTES).build();
	
	public BufferedImage getFormulaImage(final String formula, final Color fg, final Color bg) {
		try {
			return images.get(formula, new Callable<BufferedImage>() {
				@Override
				public BufferedImage call() throws Exception {
					String translateToLatex;
					try {
						translateToLatex = FormulaPart.translateToLatex(formula);
					} catch (Exception e) {
						translateToLatex = formula;
					}
					//jlatexmath has threadsafety issues on image rendering
					synchronized (TeXFormula.class) {
						return (BufferedImage) TeXFormula.createBufferedImage(
								translateToLatex,
								TeXConstants.STYLE_TEXT, 
								20,
								fg, 
								bg);
					}
				}
			});
		} catch (ExecutionException e) {
			throw Throwables.propagate(e);
		}
	}
}
