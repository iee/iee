package org.eclipse.iee.editor.core.pad.common.ui;

import java.io.Serializable;
import java.util.Map;

import org.eclipse.iee.editor.core.bindings.TextViewerSupport;
import org.eclipse.iee.editor.core.pad.CompositePad;
import org.eclipse.iee.editor.core.pad.common.ProgressDocumentPart;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.TextViewerUndoManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class ProgressPad extends CompositePad<ProgressDocumentPart> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Composite fParent;
	
	private ProgressComposite fComposite;
	
	public ProgressPad() {
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

	}
	
	public void save() {
		processInput();
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
