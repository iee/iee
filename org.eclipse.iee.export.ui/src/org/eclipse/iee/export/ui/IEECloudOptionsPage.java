package org.eclipse.iee.export.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import com.google.common.base.Objects;

public class IEECloudOptionsPage extends WizardPage {
	private Text fDestinationText;
	private Table table;
	private IStructuredSelection fSelection;
	private CheckboxTableViewer fProjectsTable;
	private Text fUrlText;
	private Text fUsernameText;
	private Text fPasswordText;
	private Button fUploadCheck;

	public IEECloudOptionsPage(IStructuredSelection selection) {
		super("wizardPage");
		this.fSelection = selection;
		setTitle("Wizard Page title");
		setDescription("Wizard Page description");
	}

	protected void handleDestinationBrowseButtonPressed() {
		DirectoryDialog dialog = new DirectoryDialog(getContainer().getShell());

		String currentSourceString = getDestinationValue();
		int lastSeparatorIndex = currentSourceString
				.lastIndexOf(File.separator);
		if (lastSeparatorIndex != -1) {
			dialog.setFilterPath(currentSourceString.substring(0,
					lastSeparatorIndex));
		}
		String selectedFileName = dialog.open();
		if (selectedFileName != null) {
			IContainer[] findContainersForLocation = ResourcesPlugin
					.getWorkspace()
					.getRoot()
					.findContainersForLocationURI(
							URIUtil.toURI(new Path(selectedFileName)
									.makeAbsolute()));
			if (findContainersForLocation.length > 0) {
				selectedFileName = findContainersForLocation[0].getFullPath()
						.makeRelative().toString();
			}
			fDestinationText.setText(selectedFileName);
		}
	}

	protected String getDestinationValue() {
		String destinationText = fDestinationText.getText().trim();
		return destinationText;
	}

	public Text getDestinationText() {
		return fDestinationText;
	}
	
	public String getUrl() {
		return fUrlText.getText();
	}

	public String getUsername() {
		return fUsernameText.getText();
	}

	public String getPassword() {
		return fPasswordText.getText();
	}
	
	public boolean isUploadChecked() {
		return fUploadCheck.getSelection();
	}
	
	private void createViewer(Composite composite) {
		fProjectsTable = CheckboxTableViewer.newCheckList(composite, SWT.BORDER
				| SWT.FULL_SELECTION);
		table = fProjectsTable.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		fProjectsTable.setContentProvider(new IStructuredContentProvider() {

			@Override
			public void inputChanged(Viewer viewer, Object oldInput,
					Object newInput) {
			}

			@Override
			public void dispose() {
			}

			@Override
			public Object[] getElements(Object inputElement) {
				return ResourcesPlugin.getWorkspace().getRoot().getProjects();
			}
		});
		fProjectsTable.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				if (element instanceof IProject) {
					return ((IProject) element).getName();
				}
				return super.getText(element);
			}
		});
		fProjectsTable.setInput(new Object());
	}

	@Override
	public void createControl(Composite parent) {
		initializeDialogUnits(parent);

		Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_FILL
				| GridData.HORIZONTAL_ALIGN_FILL));
		composite.setFont(parent.getFont());

		initializeDialogUnits(composite);
		composite.setLayout(new GridLayout(1, false));

		Label lblAvailableProjects = new Label(composite, SWT.NONE);
		lblAvailableProjects.setText("Available projects");

		createViewer(composite);

		// destination specification group
		Composite destinationSelectionGroup = new Composite(composite, SWT.NONE);
		destinationSelectionGroup.setLayoutData(new GridData(SWT.FILL,
				SWT.FILL, false, false, 1, 1));
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		destinationSelectionGroup.setLayout(layout);

		String label = "Select destination folder:";
		new Label(destinationSelectionGroup, SWT.NONE).setText(label);

		fDestinationText = new Text(destinationSelectionGroup, SWT.SINGLE
				| SWT.BORDER);
		GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL
				| GridData.GRAB_HORIZONTAL);
		data.widthHint = 250;
		data.horizontalSpan = label == null ? 2 : 1;
		fDestinationText.setLayoutData(data);

		Button btnBrowse = new Button(destinationSelectionGroup, SWT.PUSH);
		btnBrowse.setText("Browse...");
		btnBrowse.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
		btnBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				handleDestinationBrowseButtonPressed();
			}
		});

		initializeViewer();
		
		setPageComplete(true);
		setErrorMessage(null);

		setControl(composite);
		
		Group grpIeeCloud = new Group(composite, SWT.NONE);
		grpIeeCloud.setLayout(new GridLayout(2, false));
		grpIeeCloud.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
		grpIeeCloud.setText("IEE Cloud");
		
		Label lblUploadModel = new Label(grpIeeCloud, SWT.NONE);
		lblUploadModel.setText("Upload model");
		
		fUploadCheck = new Button(grpIeeCloud, SWT.CHECK);
		
		Label lblUrl = new Label(grpIeeCloud, SWT.NONE);
		lblUrl.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblUrl.setText("Url");
		
		fUrlText = new Text(grpIeeCloud, SWT.BORDER);
		fUrlText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblUsername = new Label(grpIeeCloud, SWT.NONE);
		lblUsername.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblUsername.setText("Username");
		
		fUsernameText = new Text(grpIeeCloud, SWT.BORDER);
		fUsernameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblPassword = new Label(grpIeeCloud, SWT.NONE);
		lblPassword.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPassword.setText("Password");
		
		fPasswordText = new Text(grpIeeCloud, SWT.BORDER | SWT.PASSWORD);
		fPasswordText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		restoreWidgetStates();
		
	}

	protected void initializeViewer() {
		Object[] elems = fSelection.toArray();
		for (int i = 0; i < elems.length; i++) {
			Object elem = elems[i];
			IProject project = null;

			if (elem instanceof IResource) {
				IResource file = (IResource) elem;
				project = file.getProject();
			} else if (elem instanceof IProject) {
				project = (IProject) elem;
			}
			if (project != null) {
				fProjectsTable.setChecked(project, true);
			}
		}
	}

	public java.util.List<IProject> getSelectedProjects() {
		Object[] checkedElements = fProjectsTable.getCheckedElements();
		List<IProject> result = new ArrayList<IProject>();
		for (Object object : checkedElements) {
			if (object instanceof IProject) {
				result.add((IProject) object);
			}
		}
		return result;
	}

	public void updateSettings(IDialogSettings dialogSettings) {
		dialogSettings.put("upload", fUploadCheck.getSelection());
		dialogSettings.put("destination", fDestinationText.getText());
		dialogSettings.put("url", fUrlText.getText());
		dialogSettings.put("username", fUsernameText.getText());
		dialogSettings.put("password", fPasswordText.getText());
	}
	
	private void restoreWidgetStates() {
		IDialogSettings dialogSettings = getDialogSettings();
		fUploadCheck.setSelection(dialogSettings.getBoolean("upload"));
		fDestinationText.setText(Objects.firstNonNull(dialogSettings.get("destination"), ""));
		fUrlText.setText(Objects.firstNonNull(dialogSettings.get("url"), ""));
		fUsernameText.setText(Objects.firstNonNull(dialogSettings.get("username"), ""));
		fPasswordText.setText(Objects.firstNonNull(dialogSettings.get("password"), ""));
	}
}
