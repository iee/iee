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

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

public class LayeredCanvas extends Canvas {

	private List<ICanvasLayer> layers = new ArrayList<ICanvasLayer>();

	public LayeredCanvas(Composite parent, int style) {
		super(parent, style);

		addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				paintLayers(e);
			}
		});

		addControlListener(new ControlAdapter() {
			public void controlResized(ControlEvent e) {
				if (forgetCache())
					redraw();
			}
		});
	}

	public boolean forgetCache() {
		boolean ret = false;
		for (ICanvasLayer layer : layers) {
			if (layer instanceof ICacheableLayer)
				ret |= ((ICacheableLayer) layer).forgetCache();
		}

		return ret;
	}

	protected void paintLayers(PaintEvent e) {
		for (ICanvasLayer layer : layers) {
			layer.paint(e.gc);
		}
	}

	public List<ICanvasLayer> getLayers() {
		return new LinkedList<ICanvasLayer>(layers);
	}

	public void addLayer(ICanvasLayer layer) {
		layers.add(layer);
	}

	public void removeLayer(ICanvasLayer layer) {
		layers.remove(layer);
		layer.dispose();
	}

}
