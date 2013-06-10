/**
 * 
 */
package org.eclipse.iee.sample.graph.pad;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.iee.sample.graph.pad.model.GraphElement;
import org.eclipse.iee.sample.graph.pad.model.GraphModel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;

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
		this.model = model;
		List<GraphElement> elements = model.getElements();
		for (GraphElement graphElement : elements) {
			addElementComposite(model, graphElement, composite);
		}
	}
	
	private void addElementComposite(final GraphModel model,
			final GraphElement graphElement, final GraphComposite parent) {
		Composite composite = parent.getComposite();
		final GraphElementComposite elementComposite = new GraphElementComposite(composite, SWT.EMBEDDED);
		presenenters.add(new GraphElementPresenenter(elementComposite, this, graphElement));
		parent.layout();
	}
	
	public void addNewElement() {
		GraphElement newElement = new GraphElement();
		newElement.setfDomainCardinality(100);
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
		for (GraphElementPresenenter presenter : presenenters) {
			presenter.save();
		}
	}
	
	
}
