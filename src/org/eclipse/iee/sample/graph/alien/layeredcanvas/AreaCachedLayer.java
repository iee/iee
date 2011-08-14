/*
 * SWTGraph - a set of SWT Graphs and Charts
 * Copyright (C) 2006  Felipe Santos Andrade
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 * 
 * For more information, see http://swtgraph.sourceforge.net/license.php
 * You can also contact author through lipeandrade@users.sourceforge.net
 */

package org.eclipse.iee.sample.graph.alien.layeredcanvas;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;

public abstract class AreaCachedLayer implements ICanvasLayer, ICacheableLayer {

	private ImageData cacheData;

	public void paint(GC gc) {
		Rectangle bounds = getLayerArea(gc);

		if (!isCacheAvaliable()) {
			Image imageCache = new Image(gc.getDevice(), bounds);
			GC cacheGc = new GC(imageCache);
			buildImage(cacheGc);
			cacheData = imageCache.getImageData();
			imageCache.dispose();
			cacheGc.dispose();

			RGB transparentPixel = getTransparentPixel();
			if (transparentPixel != null)
				cacheData.transparentPixel = cacheData.palette
						.getPixel(transparentPixel);
		}

		Image cache = new Image(gc.getDevice(), cacheData);
		gc.drawImage(cache, bounds.x, bounds.y);
		cache.dispose();
	}

	protected Rectangle getLayerArea(GC gc) {
		return gc.getClipping();
	}

	public abstract void buildImage(GC gc);

	public RGB getTransparentPixel() {
		return null;
	}

	public void dispose() {
		if (isCacheAvaliable()) {
			cacheData = null;
		}
	}

	public boolean isCacheAvaliable() {
		return cacheData != null;
	}

	public boolean forgetCache() {
		if (cacheData != null) {
			cacheData = null;
			return true;
		}
		return false;
	}
}
