package org.eclipse.iee.pad.graph.ui;

import java.awt.BasicStroke;

import org.eclipse.iee.editor.core.bindings.TextViewerSupport;
import org.eclipse.iee.pad.formula.ui.hover.HoverShell;
import org.eclipse.iee.pad.formula.ui.utils.FormulaRenderer;
import org.eclipse.iee.translator.antlr.translator.TexTranslator;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.TextViewerUndoManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.jfree.experimental.swt.SWTGraphics2D;

public class GraphElementComposite extends Composite {
	private Composite fInputView;
	private TextViewer fViewer;
	private Document fDocument;
	private Composite fResultView;
	private Label fFormulaImageLabel;
	private HoverShell fHoverShell;
	private String fLastValidText = "";
	private boolean editInProgress = false;
	private java.awt.Color color = java.awt.Color.BLACK;
	private int width = 1;
	private Canvas stokeCanvas;
	private MenuItem addItem;
	private MenuItem removeItem;
	private MenuItem propertiesItem;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public GraphElementComposite(Composite parent, int style) {
		super(parent, style);
		GridLayout layout = new GridLayout(1, false);
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
		fFormulaImageLabel.setMenu(createPopupMenu(parent));
		
		addTextListener();
		
		stokeCanvas = new Canvas(this, SWT.NONE);
		stokeCanvas.addPaintListener(new PaintListener() {
		
			@Override
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				SWTGraphics2D graphics2d = new SWTGraphics2D(gc);
				graphics2d.setStroke(new BasicStroke(width));
				graphics2d.setColor(color);
				graphics2d.drawLine(0, e.height/2, e.width, e.height/2);
		
			}
		});
		GridData canvasGD = new GridData(SWT.FILL, SWT.FILL, true, true);
		canvasGD.heightHint = 5;
		stokeCanvas.setLayoutData(canvasGD);
		

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

	public void addTextListener() {
		fViewer.addTextListener(new ITextListener() {

			@Override
			public void textChanged(TextEvent event) {
				if (!editInProgress) {
					return;
				}
				
				if (fDocument.get() != "") {

					if (fHoverShell != null) {
						fHoverShell.dispose();
						fHoverShell = null;
					}
					// hack to paint hover image after widgets size
					// recalculation.
					Display.getCurrent().asyncExec(new Runnable() {
						public void run() {
							Image image = createImage();
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
		editInProgress = true;
		// OFF
		fResultView.setVisible(false);

		// ON
		fInputView.setVisible(true);

		pack();

		fViewer.getControl().forceFocus();
	}

	public void toggleFormulaImage() {
		editInProgress = false;
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
		Image image = createImage();

		fFormulaImageLabel.setImage(image);
	}

	private Image createImage() {
		String fTexExpression = translateToLatex(fDocument.get());
		Image image = null;
		if (fTexExpression != null) {
			image = FormulaRenderer.getFormulaImage(fTexExpression);
		}
		if (image == null) {
			fTexExpression = translateToLatex(fLastValidText);
			image = FormulaRenderer
					.getFormulaImage(fTexExpression);
		} else {
			fLastValidText = fDocument.get();
		}
		return image;
	}
	
	public void setColor(java.awt.Color color) {
		this.color = color;
		stokeCanvas.redraw();
	}
	
	public void setWidth(int width) {
		this.width = width;
		stokeCanvas.redraw();
	}
	
	private Menu createPopupMenu(org.eclipse.swt.widgets.Control parent) {
		Menu menu = new Menu(parent);

		addItem = new MenuItem(menu, SWT.PUSH);
		addItem.setText("Add function");
		removeItem = new MenuItem(menu, SWT.PUSH);
		removeItem.setText("Remove function");
		propertiesItem = new MenuItem(menu, SWT.PUSH);
		propertiesItem.setText("Properties");

		return menu;
	}

	public MenuItem getAddItem() {
		return addItem;
	}

	public MenuItem getRemoveItem() {
		return removeItem;
	}

	public MenuItem getPropertiesItem() {
		return propertiesItem;
	}
}
