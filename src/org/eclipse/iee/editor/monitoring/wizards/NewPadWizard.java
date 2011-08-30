package org.eclipse.iee.editor.monitoring.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

public class NewPadWizard extends Wizard implements INewWizard {

	private WizardNewProjectCreationPage _pageOne;

	public NewPadWizard() {
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}

	@Override
	public boolean performFinish() {
		return true;
	}
	
	@Override
	public void addPages() {
		super.addPages();
		_pageOne = new WizardNewProjectCreationPage(
				"IEE NewPad Plug-in Project Wizard");
		_pageOne.setTitle("IEE NewPad Plug-in Project");
		_pageOne.setDescription("Creates sample pad project.");

		addPage(_pageOne);

	}

}
