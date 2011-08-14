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

package org.eclipse.iee.sample.graph.alien.elements;

import org.eclipse.swt.graphics.Color;

public class CartesianLine {

	private CartesianPoint p1;
	private CartesianPoint p2;
	
	private Color lineColor;
	
	public CartesianLine(CartesianPoint p1, CartesianPoint p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public CartesianPoint getP1() {
		return p1;
	}

	public void setP1(CartesianPoint p1) {
		this.p1 = p1;
	}

	public CartesianPoint getP2() {
		return p2;
	}

	public void setP2(CartesianPoint p2) {
		this.p2 = p2;
	}

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}
	
	
}
