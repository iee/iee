package org.eclipse.iee.sample.graph.pad;

import java.awt.Font;
import java.io.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.sample.graph.FileStorage;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.experimental.chart.swt.ChartComposite;

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
		FillLayout layout = new FillLayout(SWT.HORIZONTAL);
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		parent.setLayout(layout);
		JFreeChart chart = createChart(createDataset());
		final ChartComposite frame = new ChartComposite(parent, SWT.NONE, chart, true);
		
		MouseEventManager mouseManager = new MouseEventManager(parent);
		parent.addMouseTrackListener(mouseManager);
		parent.addMouseMoveListener(mouseManager);
		parent.addMouseListener(mouseManager);
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
	
	/**
     * Creates a sample dataset.
     * 
     * @return A sample dataset.
     */
    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("One", new Double(43.2));
        dataset.setValue("Two", new Double(10.0));
        dataset.setValue("Three", new Double(27.5));
        dataset.setValue("Four", new Double(17.5));
        dataset.setValue("Five", new Double(11.0));
        dataset.setValue("Six", new Double(19.4));
        return dataset;        
    }
    
    /**
     * Creates a chart.
     * 
     * @param dataset  the dataset.
     * 
     * @return A chart.
     */
    private static JFreeChart createChart(PieDataset dataset) {
        
        JFreeChart chart = ChartFactory.createPieChart(
            "Pie Chart Demo 1",  // chart title
            dataset,             // data
            true,               // include legend
            true,
            false
        );

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionOutlinesVisible(false);
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        return chart;
        
    }
}
