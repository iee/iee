package org.eclipse.iee.export.ui;

import java.io.File;
import java.util.List;

import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.WizardExportResourcesPage;

public class IEECloudOptionsPage extends WizardExportResourcesPage {
	private Text fDestinationText;

	/**
	 * Create the wizard.
	 */
	public IEECloudOptionsPage(IStructuredSelection selection) {
		super("wizardPage", selection);
		setTitle("Wizard Page title");
		setDescription("Wizard Page description");
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

	@Override
	public List getSelectedResources() {
		return super.getSelectedResources();
	}
	
	@Override
	public void handleEvent(Event event) {
	}

	@Override
	protected void createDestinationGroup(Composite parent) {
		initializeDialogUnits(parent);

		// destination specification group
		Composite destinationSelectionGroup= new Composite(parent, SWT.NONE);
		GridLayout layout= new GridLayout();
		layout.numColumns= 3;
		destinationSelectionGroup.setLayout(layout);
		destinationSelectionGroup.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.VERTICAL_ALIGN_FILL));

		String label = "Select destination JAR:";
		new Label(destinationSelectionGroup, SWT.NONE).setText(label);

		fDestinationText = new Text(destinationSelectionGroup, SWT.SINGLE | SWT.BORDER);
		GridData data= new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
		data.widthHint= SIZING_TEXT_FIELD_WIDTH;
		data.horizontalSpan= label == null ? 2 : 1;
		fDestinationText.setLayoutData(data);

		Button btnBrowse = new Button(destinationSelectionGroup,SWT.PUSH);
		btnBrowse.setText("Browse...");
		btnBrowse.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		btnBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleDestinationBrowseButtonPressed();
			}
		});
	}
}
