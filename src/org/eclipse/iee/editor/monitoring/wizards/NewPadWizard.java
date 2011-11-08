package org.eclipse.iee.editor.monitoring.wizards;

import org.eclipse.iee.editor.monitoring.templates.PadTemplate;
import org.eclipse.pde.ui.IFieldData;
import org.eclipse.pde.ui.templates.ITemplateSection;
import org.eclipse.pde.ui.templates.NewPluginTemplateWizard;

public class NewPadWizard extends NewPluginTemplateWizard {

	protected IFieldData fData;

	public void init(IFieldData data) {
        super.init(data);
        fData = data;
        setWindowTitle("New Pad");  
	}
	@Override
	public ITemplateSection[] createTemplateSections() {
		return new ITemplateSection[] {new PadTemplate()};
	}
}
