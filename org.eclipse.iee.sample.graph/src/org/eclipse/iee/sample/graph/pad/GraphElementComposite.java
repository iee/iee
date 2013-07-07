package org.eclipse.iee.sample.graph.pad;

import org.eclipse.iee.editor.core.bindings.TextViewerSupport;
import org.eclipse.iee.sample.formula.pad.hover.HoverShell;
import org.eclipse.iee.sample.formula.utils.FormulaRenderer;
import org.eclipse.iee.translator.antlr.translator.TexTranslator;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.TextViewerUndoManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class GraphElementComposite extends Composite {
	private Text text_1;
	private Button button;
	private Button button_1;
	private Composite fInputView;
	private TextViewer fViewer;
	private Document fDocument;
	private Composite fResultView;
	private Label fFormulaImageLabel;
	private HoverShell fHoverShell;
	private String fLastValidText;
	
	
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public GraphElementComposite(Composite parent, int style) {
		super(parent, style);
		GridLayout layout = new GridLayout(5, false);
		layout.verticalSpacing = 0;
		layout.marginHeight = 0;
		layout.marginBottom = 0;
		setLayout(layout);
		
		SashForm sashForm = new SashForm(this, SWT.FILL);
		sashForm.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		sashForm.setLayout(new FillLayout(SWT.HORIZONTAL));

		/* Input View */

		fInputView = new Composite(sashForm, SWT.NONE);
		fInputView.setBackground(new Color(null, 255, 255, 255));
		fInputView.setLayout(new FillLayout());

		fViewer = new TextViewer(fInputView, SWT.NONE);
		fDocument = new Document();
		fViewer.setDocument(fDocument);

		TextViewerUndoManager defaultUndoManager = new TextViewerUndoManager(25);
		fViewer.setUndoManager(defaultUndoManager);
		defaultUndoManager.connect(fViewer);

		TextViewerSupport fViewerSupport = new TextViewerSupport(fViewer);

		/* Result View */

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

		addTextListener();
		
		Label label_1 = new Label(this, SWT.NONE);
		label_1.setText("#(points): ");
		
		text_1 = new Text(this, SWT.BORDER | SWT.RIGHT);
		GridData gd_text_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_text_1.widthHint = 30;
		text_1.setLayoutData(gd_text_1);
		text_1.setText("100");
		
		button = new Button(this, SWT.NONE);
		GridData gd_button = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_button.widthHint = 20;
		button.setLayoutData(gd_button);
		button.setText("+");
		
		button_1 = new Button(this, SWT.NONE);
		GridData gd_button_1 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_button_1.widthHint = 20;
		button_1.setLayoutData(gd_button_1);
		button_1.setText("-");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	public TextViewer getFormulaText() {
		return fViewer;
	}
	public Composite getInputView() {
		return fInputView;
	}
	public Label getfFormulaImageLabel() {
		return fFormulaImageLabel;
	}
	public Text getPointsText() {
		return text_1;
	}
	public Button getPlusButton() {
		return button;
	}
	public Button getMinusButton() {
		return button_1;
	}
	
	public void addTextListener() {
		fViewer.addTextListener(new ITextListener() {

			@Override
			public void textChanged(TextEvent event) {

				if (fDocument.get() != "") {

					if (fHoverShell != null) {
						fHoverShell.dispose();
						fHoverShell = null;
					}
					// hack to paint hover image after widgets size
					// recalculation.
					Display.getCurrent().asyncExec(new Runnable() {
						public void run() {
							String fTexExpression = translateToLatex(fDocument.get());
							Image image = FormulaRenderer
									.getFormulaImage(fTexExpression);
							if (image == null) {
								fTexExpression = translateToLatex(fLastValidText);
								image = FormulaRenderer
										.getFormulaImage(fTexExpression);
							} else {
								fLastValidText = fDocument.get();
							}
							fHoverShell = new HoverShell(GraphElementComposite.this, image);
						}
					});
					/* Resize fInputText */
					Point size = fViewer.getControl().computeSize(SWT.DEFAULT,
							SWT.DEFAULT, false);
					fViewer.getControl().setSize(size);
					pack();
				}
			}
		});
	}
	
	public void toggleInputText() {

		// OFF
		fResultView.setVisible(false);

		// ON
		fInputView.setVisible(true);

		pack();

		fViewer.getControl().forceFocus();
	}

	public void toggleFormulaImage() {
		processInput();
		// OFF
		fInputView.setVisible(false);

		// ON
		fResultView.setVisible(true);

		if (fHoverShell != null) {
			fHoverShell.dispose();
			fHoverShell = null;
		}
		
		pack();
	}
	
	private String translateToLatex(String text) {
		String latex = "";

		if (text.isEmpty()) {
			return "";
		}
		
		/* Translating to Latex */
		if (text.charAt(0) == '=') {
			latex = TexTranslator.translate(text.substring(1));
			latex = "=" + latex;
		} else if (text.charAt(text.length() - 1) == '=') {
			latex = TexTranslator
					.translate(text.substring(0, text.length() - 1));
			latex = latex + "=";
		} else {
			latex = TexTranslator.translate(text);
		}

		return latex;

	}
	
	public void processInput() {
		/* Set formula image */
		String fTexExpression = translateToLatex(fViewer.getDocument().get());
		Image image = FormulaRenderer.getFormulaImage(fTexExpression);

		fFormulaImageLabel.setImage(image);
	}

}
