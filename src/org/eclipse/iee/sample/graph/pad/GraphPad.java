package org.eclipse.iee.sample.graph.pad;

import java.io.*;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.sample.graph.FileStorage;
import org.eclipse.iee.sample.graph.alien.CartesianGraph;
import org.eclipse.iee.sample.graph.alien.ICartesianGraphListener;
import org.eclipse.iee.sample.graph.alien.elements.CartesianPoint;
import org.nfunk.jep.JEP;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

public class GraphPad extends Pad implements Serializable {

	private String fFunction;
	private transient static FileStorage fFileStorage;

	public GraphPad() {
		super();
		fFunction = "";
		save();
	}

	@Override
	public void createPartControl(final Composite parent) {
		GridLayout layout = new GridLayout(14, false);
		parent.setLayout(layout);

		final Label titleLabel = new Label(parent, SWT.BOLD);
		titleLabel
				.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
		titleLabel.setText("Sample Graph Plotter");

		final Label functionLabel = new Label(parent, SWT.NONE);
		functionLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true,
				false));
		functionLabel.setText("f(x) = ");

		final Text function = new Text(parent, SWT.BORDER);
		function.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		function.setText("");

		new Label(parent, SWT.NONE).setText("#(points): ");

		final Text points = new Text(parent, SWT.BORDER | SWT.RIGHT);
		points.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		points.setText("100");

		new Label(parent, SWT.NONE).setText("From");

		final Text initialValue = new Text(parent, SWT.BORDER | SWT.RIGHT);
		initialValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
				false));
		initialValue.setText("-100");

		new Label(parent, SWT.NONE).setText("To");

		final Text finalValue = new Text(parent, SWT.BORDER | SWT.LEFT);
		finalValue
				.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		finalValue.setText("100");

		new Label(parent, SWT.NONE).setText("Color");

		final Combo color = new Combo(parent, SWT.BORDER | SWT.READ_ONLY);
		color.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		color.setItems(new String[] { "Red", "Blue", "Green", "Pink", "Yellow" });
		color.setText(color.getItem(0));
		final int[] colorConstants = { SWT.COLOR_RED, SWT.COLOR_BLUE,
				SWT.COLOR_GREEN, SWT.COLOR_MAGENTA, SWT.COLOR_YELLOW };

		Button draw = new Button(parent, SWT.NONE);
		draw.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		draw.setText("Plot graph");

		Button center = new Button(parent, SWT.NONE);
		center.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		center.setText("Center axis");

		Button clear = new Button(parent, SWT.NONE);
		clear.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		clear.setText("Clear");

		final CartesianGraph graph = new CartesianGraph(parent, SWT.NONE);
		graph.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 14,
				100));

		// ArrayList<CartesianPoint> curvePoints = new
		// ArrayList<CartesianPoint>();
		//
		// curvePoints.add(new CartesianPoint(150f, 100f));
		// curvePoints.add(new CartesianPoint(250f, 150f));
		// curvePoints.add(new CartesianPoint(320f, 80f));
		// curvePoints.add(new CartesianPoint(-50f, 80f));
		//
		// graph.addCurve(new GraphCurve(curvePoints));

		Label hints = new Label(parent, SWT.CENTER);
		hints.setText("Use mousewhell to zoom, drag to move");
		hints.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label zoomRate = new Label(parent, SWT.CENTER);
		zoomRate.setText("100,00%");
		zoomRate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label mousePoint = new Label(parent, SWT.CENTER);
		mousePoint.setText("(0.0, 0.0)");
		mousePoint.setLayoutData(new GridData(150, SWT.DEFAULT));

		parent.pack();
		// Listeners

		draw.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				JEP jep = new JEP();
				jep.addStandardFunctions();
				jep.addStandardConstants();

				jep.setImplicitMul(true);

				Node node;
				try {
					jep.addVariable("x", 0);

					node = jep.parse(function.getText());

					ArrayList<CartesianPoint> curvePoints = new ArrayList<CartesianPoint>();

					Float init = Float.valueOf(initialValue.getText());
					Float end = Float.valueOf(finalValue.getText());

					Integer nValues = Integer.valueOf(points.getText());

					Color selectedColor = Display.getDefault().getSystemColor(
							colorConstants[color.getSelectionIndex()]);

					float step = (end - init) / nValues;

					for (float x = init; x < end; x += step) {
						jep.setVarValue("x", x);

						Object obj = jep.evaluate(node);
						if (obj instanceof Double) {
							Double y = (Double) obj;

							CartesianPoint p = new CartesianPoint(x, y
									.floatValue());
							p.setPointColor(selectedColor);
							curvePoints.add(p);
						}
					}

					graph.addCurve(new GraphCurve(curvePoints));
					graph.redraw();

				} catch (ParseException e1) {
					System.out.println("Invalid expression: "
							+ function.getText());
				}

			}
		});

		clear.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				graph.getCurves().clear();
				graph.redraw();
			}
		});

		center.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				graph.centerOrigin();
				graph.redraw();
			}
		});

		graph.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent e) {
				mousePoint.setText(graph.cartesianPoint(e.x, e.y).toString());
			}
		});

		graph.addCartesianGraphListener(new ICartesianGraphListener() {
			public void moved(Point offset) {

			}

			public void scaleChanged(float zoomRateX, float zoomRateY) {
				zoomRate.setText(String.format("%.2f%%",
						(zoomRateX + zoomRateY) / 2 * 100));
			}
		});

	}

	protected GraphPad(String containerID) {
		super(containerID);
		fFunction = "";
		save();
	}

	public static void setStorage(FileStorage fStorage) {
		GraphPad.fFileStorage = fStorage;
	}

	@Override
	public Pad copy() {
		GraphPad newPad = new GraphPad();
		newPad.fFunction = this.fFunction;
		return newPad;
	}

	@Override
	public String getType() {
		return "Graph";
	}

	// Save&Load operations, use it for serialization

	public void save() {
		GraphPad.fFileStorage.saveToFile(this);
	}

	@Override
	public void unsave() {
		GraphPad.fFileStorage.removeFile(getContainerID());
	}
}
