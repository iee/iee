package org.eclipse.iee.editor.monitoring.templates;

import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.IPluginReference;
import org.eclipse.pde.ui.templates.ITemplateSection;

public class PadTemplate implements ITemplateSection {

	@Override
	public URL getTemplateLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getReplacementString(String fileName, String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPages(Wizard wizard) {
		// TODO Auto-generated method stub

	}

	@Override
	public WizardPage getPage(int pageIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPageCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getPagesAdded() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getNumberOfWorkUnits() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IPluginReference[] getDependencies(String schemaVersion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsedExtensionPoint() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getNewFiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void execute(IProject project, IPluginModelBase model,
			IProgressMonitor monitor) throws CoreException {
		// TODO Auto-generated method stub
		
	}

}
