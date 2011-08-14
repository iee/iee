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

package org.eclipse.iee.sample.graph.alien;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.eclipse.iee.sample.graph.alien.elements.CartesianLabeledPoint;
import org.eclipse.iee.sample.graph.alien.elements.CartesianLine;
import org.eclipse.iee.sample.graph.alien.elements.CartesianPoint;
import org.eclipse.iee.sample.graph.alien.elements.ICartesianAxisFormatter;
import org.eclipse.iee.sample.graph.alien.elements.ICartesianCurve;
import org.eclipse.iee.sample.graph.alien.layeredcanvas.ICanvasLayer;
import org.eclipse.iee.sample.graph.alien.layeredcanvas.LayeredCanvas;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

/**
 * Cartesian line graph widget. 
 * 
 * @author lipe
 */
public class CartesianGraph extends LayeredCanvas {
	
	public class DefaultAxisFormatter implements ICartesianAxisFormatter {

		String axisName;
		
		public DefaultAxisFormatter(String axisName) {
			this.axisName = axisName;
		}
		
		public String formatValue(float val) {
			return String.format("%.2f", val);
		}

		public String getAxisName() {
			return axisName;
		}

		public Color getGridLineColor(float val) {
			return getDisplay().getSystemColor(SWT.COLOR_GRAY);
		}

		public int getGridLineStyle(float val) {
			if ((int) val == val)
				return SWT.LINE_DASH;
			else
				return SWT.LINE_DOT;
		}
	};
	
	List<ICartesianGraphListener> listeners = new ArrayList<ICartesianGraphListener>();
	
	List<ICartesianCurve> curves = new LinkedList<ICartesianCurve>();
	
	boolean autoFitX = false;
	boolean autoFitY = false;
	
	boolean onlyPositives = false;
	
	ICartesianAxisFormatter yAxis = new DefaultAxisFormatter("y");
	ICartesianAxisFormatter xAxis = new DefaultAxisFormatter("x");

	float yMin = 0;
	float yMax = 100;

	float xMin = 0;
	float xMax = 100;
	
	private Point originOffset = null;
	
	private float zoomRateX = 1;
	private float zoomRateY = 1;	
	
	private Rectangle graphArea;

	private Point originPoint;

	private int minGridInterval = 50;
	
	public void addCartesianGraphListener(ICartesianGraphListener listener) {
		listeners.add(listener);
	}

	public void removeCartesianGraphListener(ICartesianGraphListener listener) {
		listeners.remove(listener);
	}
	
	
	/**
	 * Create the composite
	 * @param parent
	 * @param style
	 */
	public CartesianGraph(final Composite parent, int style) {
		super(parent, style | SWT.DOUBLE_BUFFERED);
		setLayout(new FillLayout());

		ICanvasLayer graphAxisLayer = new ICanvasLayer() {
			public void paint(GC gc) {
				paintAxis(gc);				
			}
			public void dispose() {
			}
		};
		addLayer(graphAxisLayer);
		
		ICanvasLayer graphCurves = new ICanvasLayer() {
			public void paint(GC gc) {
				paintCurves(gc);
			}
			public void dispose() {
			}
		};
		addLayer(graphCurves);
		
		Listener clickToMoveListener = new Listener() {
			Point downPoint = null;
			
			public void handleEvent(Event event) {
				if (isEnabled() && event.type == SWT.MouseDown && event.button == 1) {
					downPoint = new Point(event.x - originOffset.x, originOffset.y + event.y);
					setCursor(getDisplay().getSystemCursor(SWT.CURSOR_SIZEALL));
				}
				else if (event.type == SWT.MouseMove) {
					if (downPoint != null) {
						originOffset.x = -(downPoint.x - event.x);
						originOffset.y = downPoint.y - event.y;
						
						for (ICartesianGraphListener l : listeners)
							l.moved(new Point(originOffset.x, originOffset.y));
						
						redraw();
					}	
				}
				else if (event.type == SWT.MouseUp && event.button == 1) {
					setCursor(null);
					downPoint = null;
				}
			}
		};
		
		Listener zoomListener = new Listener() {
			public void handleEvent(Event event) {
				if (!isEnabled())
					return;
				
				if ((event.count > 0 && event.type == SWT.MouseWheel) || (event.keyCode == SWT.KEYPAD_ADD && event.type == SWT.KeyDown))
					zoomIn();
				else if ((event.count < 0 && event.type == SWT.MouseWheel) || (event.keyCode == SWT.KEYPAD_SUBTRACT && event.type == SWT.KeyDown))
					zoomOut();
			}
		};
		
		addListener(SWT.MouseDown, clickToMoveListener);
		addListener(SWT.MouseMove, clickToMoveListener);
		addListener(SWT.MouseUp, clickToMoveListener);
		
		addListener(SWT.MouseWheel, zoomListener);
		addListener(SWT.KeyDown, zoomListener);
	}
	
	protected void paintCurves(GC gc) {
		for (ICartesianCurve curve : curves) {
			if (curve.getPoints() != null) {
				for (CartesianPoint p : curve.getPoints()) {
					gc.setBackground(p.getPointColor() != null ? p.getPointColor() : getDisplay().getSystemColor(SWT.COLOR_BLUE));
					
					Point point = screenPoint(p.getX(), p.getY());
					
					gc.fillOval(point.x - p.getDiameter() / 2, point.y - p.getDiameter() / 2, p.getDiameter(), p.getDiameter());
					
					if (p instanceof CartesianLabeledPoint && ((CartesianLabeledPoint) p).getLabel() != null) {
						CartesianLabeledPoint lp = ((CartesianLabeledPoint) p);
						//gc.setBackground(getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
						gc.setForeground(lp.getLabelColor() != null ? lp.getLabelColor() : getDisplay().getSystemColor(SWT.COLOR_GRAY));
						gc.drawString(lp.getLabel(), point.x, point.y + 2, true);
					}
					
				}
			}
			
			if (curve.getConnections() != null) {
				for (CartesianLine c : curve.getConnections()) {
					Point p1 = screenPoint(c.getP1().getX(), c.getP1().getY());
					Point p2 = screenPoint(c.getP2().getX(), c.getP2().getY());
					
					gc.setForeground(c.getLineColor() != null ? c.getLineColor() : getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));
					gc.drawLine(p1.x, p1.y, p2.x, p2.y);
				}
			}
		}
	}

	public void zoomIn() {
		float resultX = zoomRateX * 2;
		float resultY = zoomRateY * 2;		
		if (resultX != Float.NaN && resultY != Float.NaN) {
			zoomRateX = resultX;
			zoomRateY = resultY;
			
			for (ICartesianGraphListener l : listeners)
				l.scaleChanged(zoomRateX, zoomRateY);
			
			redraw();
		}
	}

	public void zoomOut() {
		float resultX = zoomRateX / 2;
		float resultY = zoomRateY / 2;		
		if (resultX != Float.NaN && resultY != Float.NaN) {
			zoomRateX = resultX;
			zoomRateY = resultY;

			for (ICartesianGraphListener l : listeners)
				l.scaleChanged(zoomRateX, zoomRateY);
			
			redraw();
		}
	}
	
	public Point screenPoint(float x, float y) {
		Point point = new Point(
				(originPoint == null ? 0 : originPoint.x) + (int) (x * zoomRateX),
				(originPoint == null ? 0 : originPoint.y) - (int) (y * zoomRateY));
		
		return point;
	}
	
	public CartesianPoint cartesianPoint(int x, int y) {
		CartesianPoint point = new CartesianPoint(
				(x - (originPoint == null ? 0 : originPoint.x)) / zoomRateX,
				((originPoint == null ? 0 : originPoint.y) - y) / zoomRateY);
		
		return point;
	}	
	
	protected void paintAxis(GC gc) {
		//gc.setBackground(getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		gc.setForeground(getDisplay().getSystemColor(SWT.COLOR_LIST_FOREGROUND));

		FontData defaultFontData = getDisplay().getSystemFont().getFontData()[0];
		defaultFontData.height = 7;
		
		Font smallFont = new Font(getDisplay(), defaultFontData);
		
		gc.setFont(smallFont);
		
		graphArea = new Rectangle(
				0,
				0,
				(getClientArea().width),
				(getClientArea().height)
			);

		// grid
		//gc.setBackground(getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
		int gridIntervalX = minGridInterval; 
		int gridIntervalY = minGridInterval;
		
		if (autoFitX || autoFitY) {
			float xPointMax = 0, xPointMin = -1, yPointMax = 0, yPointMin = -1;
			
			int axisMarginWidth = 0, axisMarginHeight = 0;
			
			for (ICartesianCurve curve : curves) {
				for (CartesianPoint p : curve.getPoints()) {
					if (autoFitX) {
						if (p.getX() < xPointMin)
							xPointMin = p.getX();
						else if (p.getX() > xPointMax)
							xPointMax = p.getX();
					}
					
					if (autoFitY) {
						if (p.getY() < yPointMin)
							yPointMin = p.getY();
						else if (p.getY() > yPointMax)
							yPointMax = p.getY();
					}	
					
					if (yAxis.getAxisName() != null)
						axisMarginWidth  = Math.max(axisMarginWidth, gc.textExtent(xAxis.formatValue(p.getX())).x);
					
					if (xAxis.getAxisName() != null)
						axisMarginHeight = Math.max(axisMarginHeight, gc.textExtent(yAxis.formatValue(p.getY())).y);
				}
			}

			if (yAxis.getAxisName() != null)
				axisMarginWidth  = Math.max(axisMarginWidth, gc.textExtent(yAxis.getAxisName()).x);
			
			if (xAxis.getAxisName() != null)
				axisMarginHeight  = Math.max(axisMarginHeight, gc.textExtent(xAxis.getAxisName()).y);
			
			axisMarginWidth += 4;
			axisMarginHeight += 4;
			
			boolean rateChanged = false;
			
			if (autoFitX && (xPointMax - xPointMin) != 0) {
				zoomRateX = (graphArea.width - axisMarginWidth) / (xPointMax - xPointMin);
				gridIntervalX = (int) Math.max(Math.ceil(zoomRateX), minGridInterval);
				rateChanged = true;
			}
			
			if (autoFitY && (yPointMax - yPointMin) != 0) {
				zoomRateY = (graphArea.height - axisMarginHeight)  / (yPointMax - yPointMin);
				gridIntervalY = (int) Math.max(Math.ceil(zoomRateY), minGridInterval);
				rateChanged = true;
			}
			
			if (rateChanged)
				for (ICartesianGraphListener l : listeners)
					l.scaleChanged(zoomRateX, zoomRateY);
			
			if (originOffset == null)
				originOffset = new Point(axisMarginWidth, axisMarginHeight);
		}
		
		if (originOffset == null)
			originOffset = screenPoint(0, 0);

		

		originPoint = new Point(
					graphArea.x + originOffset.x,
					graphArea.height + graphArea.y - originOffset.y 
				);		
		
		
		// positive vertical bars
		for (int x = gridIntervalX; x < graphArea.x + graphArea.width - originPoint.x; x += gridIntervalX) {
			float val = x / zoomRateX;
			gc.setForeground(xAxis.getGridLineColor(val));
			gc.setLineStyle(xAxis.getGridLineStyle(val));
			
			gc.drawLine(originPoint.x + x, graphArea.height + graphArea.y, originPoint.x + x, graphArea.y);
			
			// grid label
			String gridLabel = xAxis.formatValue(val);
			if (gridLabel != null) {
				Point labelSize = gc.textExtent(gridLabel);
				gc.drawString(gridLabel, originPoint.x + x - (labelSize.x / 2), originPoint.y + 2);
			}
		}
		
		// negative vertical bars
		if (!onlyPositives) {
			for (int x = gridIntervalX; x < originPoint.x - graphArea.x; x += gridIntervalX) {
				float val = -x / zoomRateX;
				gc.setForeground(xAxis.getGridLineColor(val));
				gc.setLineStyle(xAxis.getGridLineStyle(val));
				
				gc.drawLine(originPoint.x - x, graphArea.height + graphArea.y, originPoint.x - x, graphArea.y);
				
				// grid label
				String gridLabel = xAxis.formatValue(val);
				if (gridLabel != null) {
					Point labelSize = gc.textExtent(gridLabel);
					gc.drawString(gridLabel, originPoint.x - x - (labelSize.x / 2), originPoint.y + 2);
				}
			}
		}
		
		
		// positive horizontal bars
		for (int y = gridIntervalY; y < originPoint.y - graphArea.y; y += gridIntervalY) {
			float val = y / zoomRateY;
			gc.setForeground(yAxis.getGridLineColor(val));
			gc.setLineStyle(yAxis.getGridLineStyle(val));
			
			gc.drawLine(graphArea.x, originPoint.y - y, graphArea.width + graphArea.x, originPoint.y - y);

			// grid label
			String gridLabel = yAxis.formatValue(val);
			if (gridLabel != null) {
				Point labelSize = gc.textExtent(gridLabel);
				gc.drawString(gridLabel, originPoint.x - labelSize.x - 2, originPoint.y - y - (labelSize.y / 2) - 1);
			}
		}

		if (!onlyPositives) {
			// negative horizontal bars
			for (int y = gridIntervalY; y < graphArea.height + graphArea.y - originPoint.y; y += gridIntervalY) {
				float val = -y / zoomRateY;
				gc.setForeground(yAxis.getGridLineColor(val));
				gc.setLineStyle(yAxis.getGridLineStyle(val));
				
				gc.drawLine(graphArea.x, originPoint.y + y, graphArea.width + graphArea.x, originPoint.y + y);
	
				// grid label
				String gridLabel = yAxis.formatValue(val);
				if (gridLabel != null) {
					Point labelSize = gc.textExtent(gridLabel);
					gc.drawString(gridLabel, originPoint.x - labelSize.x - 2, originPoint.y + y - (labelSize.y / 2) - 1);
				}
			}
		}
		
		// axis
		gc.setLineStyle(SWT.LINE_SOLID);
		
		// x-axis
		gc.setForeground(getDisplay().getSystemColor(SWT.COLOR_BLACK));
		gc.drawLine(graphArea.x, originPoint.y, graphArea.x + graphArea.width, originPoint.y);
		
		// x-axis end arrow
		//gc.setBackground(getDisplay().getSystemColor(SWT.COLOR_BLACK));
		gc.fillPolygon(new int[] {
			graphArea.x + graphArea.width - 3,
			originPoint.y - 3,
			graphArea.x + graphArea.width - 3,
			originPoint.y + 3,
			graphArea.x + graphArea.width,
			originPoint.y,
			graphArea.x + graphArea.width - 3,
			originPoint.y - 3,
		});
		
		// x-axis name
		if (xAxis.getAxisName() != null) {
			//gc.setBackground(getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
			Point xAxisArea = gc.textExtent(xAxis.getAxisName());
			gc.drawText(xAxis.getAxisName(), graphArea.x + graphArea.width - xAxisArea.x, originPoint.y + 2, false);
		}
		
		// y-axis
		gc.drawLine(originPoint.x, graphArea.y, originPoint.x, graphArea.y + graphArea.height);

		// y-axis end arrow
		//gc.setBackground(getDisplay().getSystemColor(SWT.COLOR_BLACK));
		gc.fillPolygon(new int[] {
			originPoint.x - 3,
			graphArea.y + 4,
			originPoint.x + 3,
			graphArea.y + 4,
			originPoint.x,
			graphArea.y,
			originPoint.x - 3,
			graphArea.y + 4
		});

		// y-axis name
		if (yAxis.getAxisName() != null) {
			//gc.setBackground(getDisplay().getSystemColor(SWT.COLOR_LIST_BACKGROUND));
			Point yAxisArea = gc.textExtent(yAxis.getAxisName());
			gc.drawText(yAxis.getAxisName(), originPoint.x - yAxisArea.x - 2, graphArea.y, false);	
		}

		smallFont.dispose();
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public boolean isAutoFitX() {
		return autoFitX;
	}

	public void setAutoFitX(boolean autoFitX) {
		this.autoFitX = autoFitX;
	}

	public boolean isAutoFitY() {
		return autoFitY;
	}

	public void setAutoFitY(boolean autoFitY) {
		this.autoFitY = autoFitY;
	}

	public List<? extends ICartesianCurve> getCurves() {
		return curves;
	}
	
	public <T extends ICartesianCurve> void addCurve(T curve) {
		curves.add(curve);
	}	

	public ICartesianAxisFormatter getXAxis() {
		return xAxis;
	}

	public void setXAxis(ICartesianAxisFormatter axisFormatter) {
		xAxis = axisFormatter;
	}

	public float getXMax() {
		return xMax;
	}

	public void setXMax(float max) {
		xMax = max;
	}

	public float getXMin() {
		return xMin;
	}

	public void setXMin(float min) {
		xMin = min;
	}

	public ICartesianAxisFormatter getYAxis() {
		return yAxis;
	}

	public void setYAxis(ICartesianAxisFormatter axisFormatter) {
		yAxis = axisFormatter;
	}

	public float getYMax() {
		return yMax;
	}

	public void setYMax(float max) {
		yMax = max;
	}

	public float getYMin() {
		return yMin;
	}

	public void setYMin(float min) {
		yMin = min;
	}

	public void centerOrigin() {
		originOffset = new Point(getClientArea().width / 2, getClientArea().height / 2);
	}

	public int getMinGridInterval() {
		return minGridInterval;
	}

	public void setMinGridInterval(int minGridInterval) {
		this.minGridInterval = minGridInterval;
	}

	public Point getOriginOffset() {
		return originOffset;
	}

	public void setOriginOffset(Point originOffset) {
		this.originOffset = originOffset;
	}

	public boolean isOnlyPositives() {
		return onlyPositives;
	}

	public void setOnlyPositives(boolean onlyPositives) {
		this.onlyPositives = onlyPositives;
	}

}
