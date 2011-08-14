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

public class CartesianPoint implements Comparable<CartesianPoint> {
	
	private Float x;
	private Float y;
	private Integer diameter = 4;
	private Color pointColor;
	
	public Color getPointColor() {
		return pointColor;
	}

	public void setPointColor(Color pointColor) {
		this.pointColor = pointColor;
	}

	public Integer getDiameter() {
		return diameter;
	}

	public void setDiameter(Integer diameter) {
		this.diameter = diameter;
	}

	public CartesianPoint(Float x, Float y) {
		this.x = x;
		this.y = y;
	}

	public CartesianPoint(Float x, Float y, String label) {
		this(x, y);
	}

	public Float getX() {
		return x;
	}
	
	public void setX(Float x) {
		this.x = x;
	}

	public void setY(Float y) {
		this.y = y;
	}

	public Float getY() {
		return y;
	}

	public int compareTo(CartesianPoint o) {
		return getX().compareTo(o.getX());
	}
	
	public String toString() {
		return String.format("(%.5f, %.5f)", x, y);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof CartesianPoint))
			return false;
		
		CartesianPoint cp2 = (CartesianPoint) obj;
		
		return this.getX().equals(cp2.getX()) && this.getY().equals(cp2.getY());
	}
	
}