package org.eclipse.iee.editor.monitoring.wizards;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.pde.ui.IFieldData;
import org.eclipse.pde.ui.templates.ITemplateSection;
import org.eclipse.pde.ui.templates.NewPluginTemplateWizard;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

public class NewPadWizard extends NewPluginTemplateWizard implements INewWizard {

	private WizardNewProjectCreationPage _pageOne;
	protected IFieldData fData;

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		super.init(getData());
        setWindowTitle("New Pad Wizard");
	}

	@Override
	public ITemplateSection[] createTemplateSections() {
		return null;
		//return new ITemplateSection[] {new SimpleViewTemplateSection()};
	}
	

}
