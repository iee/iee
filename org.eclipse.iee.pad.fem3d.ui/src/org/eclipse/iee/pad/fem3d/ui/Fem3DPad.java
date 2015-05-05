package org.eclipse.iee.pad.fem3d.ui;

import java.io.Serializable;
import java.util.Map;

import org.eclipse.iee.editor.core.bindings.TextViewerSupport;
import org.eclipse.iee.editor.core.pad.CompositePad;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.pad.fem3d.Fem3DPart;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.TextViewerUndoManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class Fem3DPad extends CompositePad<Fem3DPart> implements Serializable {

	private static final long serialVersionUID = 1L;

	private String modelVariable;

	private Composite fParent;
	
	private Fem3DComposite fComposite;
	
	private TextViewer fViewer;

	public Fem3DPad(Fem3DPart part) {
		modelVariable = part.getModelVariable();
	}

	private Document fDocument;

	@Override
	public void createPartControl(final Composite parent) {
		fParent = parent;
		parent.setLayout(new FillLayout());
		
		fComposite = new Fem3DComposite(parent, SWT.NONE);
		
		fViewer = fComposite.getTextBox();
		fDocument = new Document();
		fDocument.set(modelVariable);
		fViewer.setDocument(fDocument);

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
		fParent.pack();
		fViewer.getControl().forceFocus();
	}

	public void toggleFormulaImage() {
		fParent.pack();
	}

	public void processInput() {
		String var = fDocument.get();
		modelVariable = var;
		getDocumentPart().setModelVariable(modelVariable);
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
		return "Threedview";
	}

	@Override
	public String getTex() {
		return "";
	}
}
