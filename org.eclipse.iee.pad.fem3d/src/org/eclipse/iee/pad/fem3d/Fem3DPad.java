package org.eclipse.iee.pad.fem3d;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.eclipse.iee.editor.core.bindings.TextViewerSupport;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.utils.runtime.file.FileMessageEvent;
import org.eclipse.iee.editor.core.utils.runtime.file.FileMessager;
import org.eclipse.iee.editor.core.utils.runtime.file.IFileMessageListener;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.TextViewerUndoManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CaretEvent;
import org.eclipse.swt.custom.CaretListener;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class Fem3DPad extends Pad implements Serializable {

	private static final long serialVersionUID = 1L;

	private String modelVariable = "";

	private Label fFormulaImageLabel;

	private TextViewer fViewer;

	private Composite fInputView;

	private Composite fResultView;

	private Composite fParent;

	
	public Fem3DPad() {
		this(null);
	}
	public Fem3DPad(String modelVariable) {
		this.modelVariable = modelVariable;
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

		fFormulaImageLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
			}

			@Override
			public void mouseDown(MouseEvent e) {
				moveCaretToCurrentPad();
				getContainer().getContainerManager()
						.getUserInteractionManager()
						.activateContainer(getContainer());
			}

			@Override
			public void mouseUp(MouseEvent e) {
			}
		});

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
	public Pad copy() {
		Fem3DPad newPad = new Fem3DPad();
		newPad.modelVariable = this.modelVariable;
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
		
		String path = getContainer().getContainerManager().getStoragePath() + "/" +
				FileMessager.getInstance().getRuntimeDirectoryName();
		String file = getContainerID();
		
		StringBuilder generatedText = new StringBuilder();
		generatedText.append("try {");
		generatedText.append("String path = \"").append(path).append("\";");
		generatedText.append("String file = \"").append(file).append("\";");
		generatedText.append("com.ieecloud.viewer.Java3DViewer.print(").append(modelVariable).append(", file, path + \"_img\");");
		generatedText.append("	byte[] bar = org.apache.commons.io.FileUtils.readFileToByteArray(new File(path + \"/\" + file));");
		generatedText.append("String encoded = org.apache.commons.codec.binary.Base64.encodeBase64String(bar);");
		generatedText.append("org.apache.commons.io.FileUtils.write(new File(path + \"/\" + file), encoded);");
		generatedText.append("} catch (IOException e) {");
		generatedText.append("e.printStackTrace();");
		generatedText.append("}");
		
		
		
		getContainer().setValue(modelVariable);
		getContainer().setTextContent(generatedText.toString());
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
		return "Fem3D";
	}

	@Override
	public String getTex() {
		return "";
	}
}
