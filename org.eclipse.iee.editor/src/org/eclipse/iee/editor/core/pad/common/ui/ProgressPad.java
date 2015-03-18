package org.eclipse.iee.editor.core.pad.common.ui;

import java.io.Serializable;
import java.util.Map;

import org.eclipse.iee.editor.core.bindings.TextViewerSupport;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.pad.common.ProgressDocumentPart;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.TextViewerUndoManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class ProgressPad extends Pad<ProgressDocumentPart> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Composite fParent;
	
	private ProgressComposite fComposite;
	
	public ProgressPad(ProgressDocumentPart part) {
		super(part);
	}

	private Document fDocument;

	private TextViewer fViewer;

	@Override
	public void createPartControl(final Composite parent) {
		fParent = parent;
		parent.setLayout(new FillLayout());
		
		fComposite = new ProgressComposite(parent, SWT.NONE);
		
		fDocument = new Document();
		fDocument.set(getDocumentPart().getStatus());
		fViewer = fComposite.getTextBox();
		fViewer.setDocument(fDocument);
		fComposite.setSpinner(getDocumentPart().getProgress());

		TextViewerUndoManager defaultUndoManager = new TextViewerUndoManager(25);
		fViewer.setUndoManager(defaultUndoManager);
		defaultUndoManager.connect(fViewer);

		new TextViewerSupport(fViewer);

		if (fDocument.get() != "") {
			toggleFormulaImage();
		} else {
			toggleInputText();
		}
		
		setListeners();
	}

	public void setListeners() {

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
	public ProgressPad copy() {
		ProgressPad newPad = new ProgressPad(getDocumentPart().copy());
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
		fParent.pack();
		fViewer.getControl().forceFocus();
	}

	public void toggleFormulaImage() {
		fParent.pack();
	}

	public void processInput() {
		String var = fDocument.get();
		getDocumentPart().setStatus(var);
		getDocumentPart().setProgress(fComposite.getSpinner());
		getContainer().updateDocument();
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
		return "Progress";
	}

	@Override
	public String getTex() {
		return "";
	}
}
