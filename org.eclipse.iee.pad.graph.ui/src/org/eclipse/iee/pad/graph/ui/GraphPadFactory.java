package org.eclipse.iee.pad.graph.ui;

import org.eclipse.iee.editor.core.bindings.DefaultObservableValue;
import org.eclipse.iee.editor.core.pad.IPadFactory;
import org.eclipse.iee.editor.core.pad.IPadFactoryContext;
import org.eclipse.iee.pad.formula.ui.utils.UIFormulaRenderer;
import org.eclipse.iee.pad.graph.GraphPart;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;

@Component
public class GraphPadFactory implements IPadFactory<GraphPart> {

	private UIFormulaRenderer formulaRenderer;
	
	@Override
	public GraphPad create(GraphPart documentPart, IPadFactoryContext factoryContext) {
		GraphPad graphPad = new GraphPad(formulaRenderer);
		DefaultObservableValue<GraphPart> model = new DefaultObservableValue<GraphPart>();
		model.setValue(documentPart);
		graphPad.bindDocumentPart(model);
		return graphPad;
	}
	
	@Reference(unbind = "unbindFormulaRenderer", policy = ReferencePolicy.DYNAMIC)
	public void bindFormulaRenderer(UIFormulaRenderer renderer) {
		formulaRenderer = renderer;
	}
	
	public void unbindFormulaRenderer(UIFormulaRenderer renderer) {
		formulaRenderer = null;
	}

}
