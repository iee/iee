package org.eclipse.iee.editor.monitoring.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

public class NewIEEMathWizard extends Wizard implements INewWizard {

	private WizardNewProjectCreationPage _pageOne;

	public NewIEEMathWizard() {

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
		_pageOne = new WizardNewProjectCreationPage("IEE Math Project Wizard");
		_pageOne.setTitle("IEE Math Project Wizard");
		_pageOne.setDescription("Creates IEE Math project.");

		addPage(_pageOne);

	}

}
