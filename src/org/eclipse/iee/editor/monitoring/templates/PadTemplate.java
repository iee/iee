package org.eclipse.iee.editor.monitoring.templates;

import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.iee.editor.monitoring.Activator;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.pde.core.plugin.IPluginBase;
import org.eclipse.pde.core.plugin.IPluginElement;
import org.eclipse.pde.core.plugin.IPluginExtension;
import org.eclipse.pde.core.plugin.IPluginModelFactory;
import org.eclipse.pde.core.plugin.IPluginReference;
import org.eclipse.pde.internal.ui.IHelpContextIds;
import org.eclipse.pde.ui.IFieldData;
import org.eclipse.pde.ui.templates.OptionTemplateSection;
import org.eclipse.pde.ui.templates.PluginReference;
import org.eclipse.pde.ui.templates.TemplateOption;

public class PadTemplate extends OptionTemplateSection {

	private static final String KEY_CLASS_NAME = "className";
	private String packageName = null;
	
	public PadTemplate() {
		super();
		setPageCount(1);
		createOptions();
	}
	
	private void createOptions() {
		addOption(KEY_CLASS_NAME, "Class Name ", "NewPad", 0);
	}
	
	public void addPages(Wizard wizard) {
		//WizardPage page = createPage(0, IHelpContextIds.TEMPLATE_INTRO);
		WizardPage page = createPage(0);
		page.setTitle("Pad Template");
		page.setDescription("Creates a new pad");
		wizard.addPage(page);
		markPagesAdded();
	}
	
	/**
	 * This is the folder relative to your install url and template directory
	 * where the templates are stored.
	 */
	public String getSectionId() {
		return "padtemplate";
	}
	
	protected void initializeFields(IFieldData data) {
		String id = data.getId();
		initializeOption(KEY_PACKAGE_NAME, getFormattedPackageName(id));
		this.packageName = getFormattedPackageName(id);
	}

	/**
	 * Validate your options here!
	 */
	public void validateOptions(TemplateOption changed) {
		// TODO Auto-generated method stub

	}

	protected void updateModel(IProgressMonitor monitor) throws CoreException {
		IPluginBase plugin = model.getPluginBase();
		IPluginModelFactory factory = model.getPluginFactory();
	}

	public String getUsedExtensionPoint() {
		return "org.eclipse.ui.views";
	}

	/**
	 * The location of your plugin supplying the template content
	 */
	protected URL getInstallURL() {
		return Activator.getDefault().getBundle().getEntry("/");
	}

	protected ResourceBundle getPluginResourceBundle() {
		return Platform.getResourceBundle(Activator.getDefault().getBundle());
	}

	/**
	 * You can use this method to add files relative to your section id
	 */
	public String[] getNewFiles() {
		return new String[0];
	}
	
	public IPluginReference[] getDependencies(String schemaVersion) {
		ArrayList<PluginReference> result = new ArrayList<PluginReference>();
 
        result.add(new PluginReference("org.eclipse.core.runtime", null, 0)); 
        result.add(new PluginReference("org.eclipse.ui", null, 0));
        result.add(new PluginReference("org.eclipse.iee.editor", "1.0.0", 0));
        result.add(new PluginReference("org.eclipse.ui.editors", "3.7.0", 0));

		return (IPluginReference[]) result.toArray(
				new IPluginReference[result.size()]);
	}
	
	public boolean isDependentOnParentWizard() {
		return true;
	}
	
	public int getNumberOfWorkUnits() {
		return super.getNumberOfWorkUnits() + 1;
	}
	
	public String getStringOption(String name) {
		if (name.equals(KEY_PACKAGE_NAME)) {
			return packageName;
		}
		return super.getStringOption(name);
	}
	
	protected String getFormattedPackageName(String id){
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < id.length(); i++) {
			char ch = id.charAt(i);
			if (buffer.length() == 0) {
				if (Character.isJavaIdentifierStart(ch))
					buffer.append(Character.toLowerCase(ch));
			} else {
				if (Character.isJavaIdentifierPart(ch) || ch == '.')
					buffer.append(ch);
			}
		}
		return buffer.toString().toLowerCase(Locale.ENGLISH);
	}
	

	public String getDescription() {
		return "Creates a new pad";
	}

	public String getLabel() {
		return "New Pad";
	}

}
