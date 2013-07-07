/**
 * 
 */
package org.eclipse.iee.sample.graph.pad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.iee.sample.graph.pad.model.GraphElement;
import org.eclipse.iee.sample.graph.pad.model.GraphModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * @author Efimchuk.A
 *
 */
public class GraphModelPresenter {

	private List<GraphElementPresenenter> presenenters = new ArrayList<GraphElementPresenenter>();
	
	private GraphPad graphPad;
	
	private GraphComposite composite;
	
	private GraphModel model;

	public GraphModelPresenter(GraphPad graphPad, GraphComposite composite, GraphModel model) {
		this.graphPad = graphPad;
		this.composite = composite;
		setModel(model);
	}
	
	private void addElementComposite(final GraphModel model,
			final GraphElement graphElement, final GraphComposite parent) {
		Composite composite = parent.getComposite();
		final GraphElementComposite elementComposite = new GraphElementComposite(composite, SWT.NONE);
		presenenters.add(new GraphElementPresenenter(elementComposite, this, graphElement));
		parent.layout();
	}
	
	public void addNewElement() {
		GraphElement newElement = new GraphElement();
		newElement.setNumberOfPoints(100);
		model.getElements().add(newElement);
		addElementComposite(model, newElement, composite);
		graphPad.processInput(model);
	}
	
	public void removeElement(GraphElementPresenenter elementPresenenter) {
		presenenters.remove(elementPresenenter);
		model.getElements().remove(elementPresenenter.getGraphElement());
		elementPresenenter.remove();
		graphPad.processInput(model);
		composite.layout();
	}

	public void save() {
		String text = composite.getVariablesText().getText();
		String[] variables = text.split(",");
		model.setVariables(Arrays.asList(variables));
		for (GraphElementPresenenter presenter : presenenters) {
			presenter.save();
		}
	}

	public void setModel(GraphModel model) {
		for (GraphElementPresenenter presenter : presenenters) {
			presenter.remove();
		}
		presenenters.clear();
		this.model = model;
		List<GraphElement> elements = model.getElements();
		for (GraphElement graphElement : elements) {
			addElementComposite(model, graphElement, composite);
		}
		StringBuilder sb = new StringBuilder();
		List<String> variables = model.getVariables();
		for (String variable : variables) {
			if (sb.length() > 0) {
				sb.append(",");
			}
			sb.append(variable);
		}
		
		Text variablesText = composite.getVariablesText();
		variablesText.setText(sb.toString());
		composite.layout();
	}
	
}
