package org.eclipse.iee.pad.fem3d.ui;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.eclipse.iee.editor.core.bindings.TextViewerSupport;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.utils.runtime.file.FileMessageEvent;
import org.eclipse.iee.editor.core.utils.runtime.file.FileMessager;
import org.eclipse.iee.editor.core.utils.runtime.file.IFileMessageListener;
import org.eclipse.iee.pad.fem3d.Fem3DPart;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.TextViewerUndoManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class Fem3DPad extends Pad<Fem3DPart> implements Serializable {

	private static final long serialVersionUID = 1L;

	private String modelVariable = "";

	private Label fFormulaImageLabel;

	private TextViewer fViewer;

	private Composite fInputView;

	private Composite fResultView;

	private Composite fParent;

	
	public Fem3DPad(Fem3DPart part) {
		super(part);
	}

	private IFileMessageListener fFileMessageListener = new IFileMessageListener() {

		@Override
		public void messageReceived(FileMessageEvent e) {
			updateResult(e.getMessage());
		}

		@Override
		public String getRequesterID() {
			return getContainerID();
		}

	};

	private Document fDocument;

	@Override
	public void createPartControl(final Composite parent) {
		fParent = parent;
		parent.setLayout(new FillLayout());
		
		SashForm sashForm = new SashForm(parent, SWT.FILL);
		sashForm.setLayout(new FillLayout(SWT.HORIZONTAL));

		/* Input View */

		fInputView = new Composite(sashForm, SWT.NONE);
		fInputView.setBackground(new Color(null, 255, 255, 255));
		fInputView.setLayout(new FillLayout());
		
		fViewer = new TextViewer(fInputView, SWT.NONE);
		fDocument = new Document();
		fDocument.set(modelVariable);
		fViewer.setDocument(fDocument);

		TextViewerUndoManager defaultUndoManager = new TextViewerUndoManager(25);
		fViewer.setUndoManager(defaultUndoManager);
		defaultUndoManager.connect(fViewer);

		new TextViewerSupport(fViewer);

		fResultView = new Composite(sashForm, SWT.NONE);
		fResultView.setBackground(new Color(null, 255, 255, 255));
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginWidth = 0;
		gridLayout.marginHeight = 0;
		fResultView.setLayout(gridLayout);
		fResultView.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		fFormulaImageLabel = new Label(fResultView, SWT.NONE);
		fFormulaImageLabel.setBackground(new Color(null, 255, 255, 255));
		GridData formulaImageGridData = new GridData(SWT.FILL, SWT.FILL, true,
				true);
		formulaImageGridData.minimumWidth = 40;
		fFormulaImageLabel.setLayoutData(formulaImageGridData);
		
		if (fDocument.get() != "") {
			toggleFormulaImage();
		} else {
			toggleInputText();
		}
		
		setListeners();
	}

	public void setListeners() {

		FileMessager.getInstance().addFileMessageListener(fFileMessageListener,
				getContainer().getContainerManager().getStoragePath());

		fViewer.getControl().addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				getContainer().getContainerManager()
						.getUserInteractionManager()
						.deactivateContainer(getContainer());
			}

			@Override
			public void focusGained(FocusEvent e) {
			}
		});

	}
	
	@Override
	public Fem3DPad copy() {
		Fem3DPad newPad = new Fem3DPad(getDocumentPart().copy());
		return newPad;
	}

	// Save&Load operations, use it for serialization

	public void save() {
		processInput();
	}

	@Override
	public void unsave() {
	}
	
	public void toggleInputText() {
		fResultView.setVisible(false);
		fInputView.setVisible(true);
		fParent.pack();
		fViewer.getControl().forceFocus();
	}

	public void toggleFormulaImage() {
		fInputView.setVisible(false);
		fResultView.setVisible(true);
		fParent.pack();
	}

	public void processInput() {
		String var = fDocument.get();
		modelVariable = var;
		fFormulaImageLabel.setText(var);
		
		
		getDocumentPart().setModelVariable(modelVariable);
		getContainer().updateDocument();
	}

	public void updateResult(String result) {
        try {
            byte[] decoded = Base64.decodeBase64(result);
            ByteArrayInputStream bis = new ByteArrayInputStream(decoded);
            Image img = new Image(fFormulaImageLabel.getDisplay(), bis);
            bis.close();
            fFormulaImageLabel.setImage(img);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@Override
	public void onContainerAttached() {
	}

	@Override
	public void activate() {
		toggleInputText();
	}
	
	@Override
	public void deactivate() {
		processInput();
		toggleFormulaImage();
	}

	@Override
	public void updateData(Map<String, String> params, String value) {
	}
	
	@Override
	public String getType() {
		return "Threedview";
	}

	@Override
	public String getTex() {
		return "";
	}
}
