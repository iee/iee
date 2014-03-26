package org.eclipse.iee.export.ui;

import java.io.File;

import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class IEECloudOptionsPage extends WizardPage {
	private Text fDestinationText;

	/**
	 * Create the wizard.
	 */
	public IEECloudOptionsPage(IStructuredSelection selection) {
		super("wizardPage");
		setTitle("Wizard Page title");
		setDescription("Wizard Page description");
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		setControl(container);
		container.setLayout(new FormLayout());
		
		Label lblSelectDestinationJar = new Label(container, SWT.NONE);
		FormData fd_lblSelectDestinationJar = new FormData();
		fd_lblSelectDestinationJar.bottom = new FormAttachment(100, -261);
		fd_lblSelectDestinationJar.top = new FormAttachment(0, 6);
		fd_lblSelectDestinationJar.left = new FormAttachment(0);
		lblSelectDestinationJar.setLayoutData(fd_lblSelectDestinationJar);
		lblSelectDestinationJar.setText("Select destination JAR:");
		
		fDestinationText = new Text(container, SWT.BORDER);
		FormData fd_text = new FormData();
		fd_text.top = new FormAttachment(0, 3);
		fd_text.left = new FormAttachment(lblSelectDestinationJar, 6);
		fDestinationText.setLayoutData(fd_text);
		
		Button btnBrowse = new Button(container, SWT.NONE);
		btnBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleDestinationBrowseButtonPressed();
			}
		});
		fd_text.right = new FormAttachment(btnBrowse, -6);
		FormData fd_btnBrowse = new FormData();
		fd_btnBrowse.top = new FormAttachment(lblSelectDestinationJar, -5, SWT.TOP);
		fd_btnBrowse.right = new FormAttachment(100);
		btnBrowse.setLayoutData(fd_btnBrowse);
		btnBrowse.setText("Browse...");
	}
	
	protected void handleDestinationBrowseButtonPressed() {
		FileDialog dialog= new FileDialog(getContainer().getShell(), SWT.SAVE);
		dialog.setFilterExtensions(new String[] {"*.zip"});

		String currentSourceString = getDestinationValue();
		int lastSeparatorIndex= currentSourceString.lastIndexOf(File.separator);
		if (lastSeparatorIndex != -1) {
			dialog.setFilterPath(currentSourceString.substring(0, lastSeparatorIndex));
			dialog.setFileName(currentSourceString.substring(lastSeparatorIndex + 1, currentSourceString.length()));
		}
		String selectedFileName= dialog.open();
		if (selectedFileName != null) {
			IContainer[] findContainersForLocation = 
					ResourcesPlugin.getWorkspace().getRoot().findContainersForLocationURI(URIUtil.toURI(new Path(selectedFileName).makeAbsolute()));
			if (findContainersForLocation.length > 0) {
				selectedFileName= findContainersForLocation[0].getFullPath().makeRelative().toString();
			}
			fDestinationText.setText(selectedFileName);
		}
	}
	
	protected String getDestinationValue() {
		String destinationText= fDestinationText.getText().trim();
		if (destinationText.indexOf('.') < 0)
			destinationText+= getOutputSuffix();
		return destinationText;
	}
	
	public Text getDestinationText() {
		return fDestinationText;
	}
	
	protected String getOutputSuffix() {
		return ".zip";
	}
}
