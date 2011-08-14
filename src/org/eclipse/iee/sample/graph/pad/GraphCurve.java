package org.eclipse.iee.sample.graph.pad;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.iee.sample.graph.alien.elements.CartesianLine;
import org.eclipse.iee.sample.graph.alien.elements.CartesianPoint;
import org.eclipse.iee.sample.graph.alien.elements.ICartesianCurve;

public class GraphCurve implements ICartesianCurve {
	List<CartesianPoint> points;
	
	GraphCurve(List<CartesianPoint> points) {
		this.points = points;
	}
	
	public Collection<? extends CartesianPoint> getPoints() {
		return points;
	}
	
	public Collection<? extends CartesianLine> getConnections() {
		CartesianPoint lastPoint = null;
		List<CartesianLine> connections = new LinkedList<CartesianLine>();
		for (CartesianPoint p : points) {
			if (lastPoint != null) {
				CartesianLine c = new CartesianLine(lastPoint, p);
				connections.add(c);
			}
			lastPoint = p;
		}
		return connections;
	}
}	
