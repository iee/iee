package org.eclipse.iee.pad.formula.ui;

import java.util.Collection;
import java.util.Map;

import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.editor.core.bindings.TextViewerSupport;
import org.eclipse.iee.editor.core.pad.CompositePad;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.utils.runtime.file.FileMessageEvent;
import org.eclipse.iee.editor.core.utils.runtime.file.FileMessager;
import org.eclipse.iee.editor.core.utils.runtime.file.IFileMessageListener;
import org.eclipse.iee.pad.formula.FormulaPart;
import org.eclipse.iee.pad.formula.ui.hover.HoverShell;
import org.eclipse.iee.pad.formula.ui.utils.UIFormulaRenderer;
import org.eclipse.iee.pad.formula.ui.utils.Function;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.TextViewerUndoManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CaretEvent;
import org.eclipse.swt.custom.CaretListener;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractFormulaPad<T extends PadDocumentPart> extends CompositePad<T> {

	private static final Logger logger = LoggerFactory.getLogger(AbstractFormulaPad.class);

	private UIFormulaRenderer formulaRenderer;
	
	Composite fParent;

	private Composite fInputView;
	private Composite fResultView;

	protected Label fFormulaImageLabel;
	Label fLastResultImageLabel;

	protected String fResult;

	protected TextViewer fViewer;

	protected Document fDocument;

	HoverShell fHoverShell;

	protected boolean fIsInputValid;

	protected String fOriginalExpression = "";
	protected String fTranslatingExpression = "";
	protected String fLastValidText = "";
	protected String fTexExpression = "";

	private int fCaretOffset;
	private int fPreviousCaretOffset;

	private final Color INPUT_VALID_COLOR = new Color(null, 255, 255, 255);
	private final Color INPUT_INVALID_COLOR = new Color(null, 255, 0, 0);

	private IFileMessageListener fFileMessageListener = new IFileMessageListener() {

		@Override
		public void messageReceived(FileMessageEvent e) {
			updateLastResult(e.getMessage());
		}

		@Override
		public String getRequesterID() {
			return getContainerID();
		}

	};

	
	/*
	 * Getters/Setters
	 */

	public String getOriginalExpression() {
		return fOriginalExpression;
	}

	public void setOriginalExpression(String expression) {
		fOriginalExpression = expression;
	}

	public String getTranslatingExpression() {
		return fTranslatingExpression;
	}

	public void setTranslatingExpression(String expression) {
		fTranslatingExpression = expression;
	}

	public AbstractFormulaPad(T part, UIFormulaRenderer formulaRenderer) {
		this.formulaRenderer = formulaRenderer;
	}

	public UIFormulaRenderer getFormulaRenderer() {
		return formulaRenderer;
	}
	
	public void asyncUIUpdate(final Function function) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				function.f();
			}
		});
	}

	public void toggleInputText() {

		// OFF
		fResultView.setVisible(false);

		// ON
		fDocument.set(fLastValidText);
		fInputView.setVisible(true);

		fParent.pack();

		fViewer.getControl().forceFocus();
		fCaretOffset = 0;
	}

	public void toggleFormulaImage() {
		// OFF
		fInputView.setVisible(false);

		// ON
		fResultView.setVisible(true);

		fParent.pack();
	}

	public void setInputIsValid() {
		fIsInputValid = true;
		fViewer.getControl().setBackground(INPUT_VALID_COLOR);
	}

	public void setInputIsInvalid() {
		fIsInputValid = false;
		fViewer.getControl().setBackground(INPUT_INVALID_COLOR);
	}

	public void validateInput() {
		// TODO: add validation
		String text = fDocument.get();
		fOriginalExpression = text;
		setInputIsValid();
		fLastValidText = text;
	}

	public void processInput() {
		if (fIsInputValid) {
			if (!fDocument.get().equals(fTranslatingExpression)) {
				/* Remove result images from following pads */
				Collection<Pad<?>> following = FormulaPadManager
						.getFollowingPads(this);

				for (Pad<?> pad : following) {
					((AbstractFormulaPad<?>) pad).updateLastResult("");
				}
			}
		}

		fTranslatingExpression = fLastValidText;

		updateFormulaImage();

	}

	private void updateFormulaImage() {
		fTexExpression = fTranslatingExpression;
		Image image = formulaRenderer.getFormulaImage(fTexExpression);

		fFormulaImageLabel.setImage(image);
	}

	public void updateLastResult(String result) {
		final Image image;
		fResult = result;
		if (result == "")
			image = null;
		else {
			String latex = result;
			fTexExpression += latex;
			image = formulaRenderer.getFormulaImage(latex);
		}

		Function updateImage = new Function() {

			@Override
			public void f() {
				if (!fLastResultImageLabel.isDisposed()) {
					fLastResultImageLabel.setImage(image);
					fParent.pack();
				}
			}
		};

		asyncUIUpdate(updateImage);

	}

	private void switchToResultView() {
		processInput();
		focusOnMainEditor();

		if (fTranslatingExpression != "")
			toggleFormulaImage();

		if (fHoverShell != null) {
			fHoverShell.dispose();
			fHoverShell = null;
		}
	}

	public void setListeners() {

		FileMessager.getInstance().addFileMessageListener(fFileMessageListener,
				getContainer().getContainerManager().getStoragePath());

		fViewer.getControl().addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				getContainer().getContainerManager()
						.deactivateContainer(getContainer());
			}

			@Override
			public void focusGained(FocusEvent e) {
				logger.debug("focusGained");
			}
		});

		addTextListener();

		fViewer.getControl().addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch (e.keyCode) {
				case SWT.CR:
					e.doit = false;
					switchToResultView();
					moveCaretToContainerTail();
					break;
				case SWT.ESC:
					switchToResultView();
					moveCaretToContainerTail();
					break;
				case SWT.ARROW_UP:
					moveCaretToCurrentPad();
					focusOnMainEditor();
					break;
				case SWT.ARROW_DOWN:
					moveCaretToCurrentPad();
					focusOnMainEditor();
					break;
				case SWT.ARROW_LEFT:
					if (fCaretOffset == 0 && fPreviousCaretOffset == 0)
						switchToResultView();
					else
						fPreviousCaretOffset = fCaretOffset;
					break;
				case SWT.ARROW_RIGHT:

					int expressionLength = fOriginalExpression.length();
					if (fCaretOffset == expressionLength
							&& fPreviousCaretOffset == expressionLength) {
						moveCaretToContainerTail();
						switchToResultView();
					} else
						fPreviousCaretOffset = fCaretOffset;
					break;

				}

			}
		});

		fViewer.getTextWidget().addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent e) {
			}

			@Override
			public void mouseDown(MouseEvent e) {
				int caretOffset = fViewer.getTextWidget().getCaretOffset();
				if (caretOffset == 0) {
					fCaretOffset = 0;
					fPreviousCaretOffset = 0;
				}
				if (caretOffset == fOriginalExpression.length()) {
					fCaretOffset = fOriginalExpression.length();
					fPreviousCaretOffset = fCaretOffset;
				}
			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {
			}
		});

		fViewer.getTextWidget().addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseScrolled(MouseEvent e) {
				if (fHoverShell != null) {
					fHoverShell.dispose();
					fHoverShell = null;
				}
			}
		});

		fViewer.getTextWidget().addCaretListener(new CaretListener() {

			@Override
			public void caretMoved(CaretEvent event) {
				fPreviousCaretOffset = fCaretOffset;
				fCaretOffset = event.caretOffset;

				if (fCaretOffset == 0 && fPreviousCaretOffset != 1)
					fPreviousCaretOffset = 0;

				if (fCaretOffset == fTranslatingExpression.length()
						&& fPreviousCaretOffset != (fTranslatingExpression
								.length() - 1))
					fPreviousCaretOffset = fCaretOffset;
			}
		});

	}

	public void addTextListener() {
		fViewer.addTextListener(new ITextListener() {

			@Override
			public void textChanged(TextEvent event) {

				if (fDocument.get() != "") {

					validateInput();

					if (fHoverShell != null) {
						fHoverShell.dispose();
						fHoverShell = null;
					}
					// hack to paint hover image after widgets size
					// recalculation.
					Display.getCurrent().asyncExec(new Runnable() {
						public void run() {
							fTexExpression = fDocument.get();
							Image image = createImage(fTexExpression);
							if (image == null) {
								fTexExpression = fLastValidText;
								image = createImage(fTexExpression);
							}
							if (fHoverShell != null) {
								fHoverShell.dispose();
							}
							fHoverShell = new HoverShell(fParent, image);
						}
					});
					/* Resize fInputText */
					Point size = fViewer.getControl().computeSize(SWT.DEFAULT,
							SWT.DEFAULT, false);
					fViewer.getControl().setSize(size);
					fParent.pack();
				}
			}

		});
	}

	protected Image createImage(String formula) {
		return formulaRenderer.getFormulaImage(fTexExpression);
	}
	
	@Override
	public void createPartControl(final Composite parent) {

		fParent = parent;

		FillLayout layout = new FillLayout(SWT.HORIZONTAL);
		parent.setLayout(layout);

		SashForm sashForm = new SashForm(parent, SWT.FILL);
		sashForm.setLayout(new FillLayout(SWT.HORIZONTAL));

		/* Input View */

		fInputView = new Composite(sashForm, SWT.NONE);
		fInputView.setBackground(new Color(null, 255, 255, 255));
		fInputView.setLayout(new GridLayout(1, true));

		fViewer = new TextViewer(fInputView, SWT.SINGLE);
		fViewer.getControl().setSize(50, 100);
		fViewer.getControl().setFont(
				getContainer().getContainerManager().getStyledText().getFont());
		fDocument = new Document();
		if (fTranslatingExpression.isEmpty()) {
			fDocument.set(fOriginalExpression);
		} else {
			fDocument.set(fTranslatingExpression);
		}
		fViewer.setDocument(fDocument);

		TextViewerUndoManager defaultUndoManager = new TextViewerUndoManager(25);
		fViewer.setUndoManager(defaultUndoManager);
		defaultUndoManager.connect(fViewer);

		new TextViewerSupport(fViewer);

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
		fFormulaImageLabel.setLayoutData(formulaImageGridData);

		fLastResultImageLabel = new Label(fResultView, SWT.NONE);
		fLastResultImageLabel.setBackground(new Color(null, 255, 255, 255));
		GridData lastResultImageGridData = new GridData(SWT.LEFT, SWT.FILL,
				true, true);
		fLastResultImageLabel.setLayoutData(lastResultImageGridData);
		fLastResultImageLabel.setMenu(createPopupMenu(parent));
		setListeners();

		// moveCaretToCurrentPad();

		if (fTranslatingExpression != "" && fDocument.get() != "") {
			validateInput();
			updateFormulaImage();
			toggleFormulaImage();
		} else {
			getContainer().setVisible(true);
			toggleInputText();
		}

	}

	private Menu createPopupMenu(org.eclipse.swt.widgets.Control parent) {
		Menu menu = new Menu(parent);

		final MenuItem copyItem = new MenuItem(menu, SWT.PUSH);
		copyItem.setText("Copy result");
		copyItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				Clipboard clipboard = new Clipboard(Display.getCurrent());
				try {
					TextTransfer transfer = TextTransfer.getInstance();
					clipboard.setContents(new Object[] { fResult },
							new Transfer[] { transfer });
				} finally {
					clipboard.dispose();
				}
			}
		});

		return menu;
	}

	@Override
	public void activate() {
		logger.debug(getContainerID() + " activated");

		int editorCaretOffset = getContainer().getContainerManager()
				.getStyledText().getCaretOffset();

		toggleInputText();

		if (editorCaretOffset > getContainer().getPosition().getOffset() + 1) {
			fCaretOffset = fTranslatingExpression.length();
			fViewer.getTextWidget().setCaretOffset(fCaretOffset);
		}

	}

	@Override
	public void deactivate() {
		processInput();
		if (fTranslatingExpression != "") {
			toggleFormulaImage();
		}
		if (fHoverShell != null) {
			fHoverShell.dispose();
			fHoverShell = null;
		}
	}

	// Save&Load operations

	public void save() {
		processInput();
	}

	@Override
	public void unsave() {
	}

	@Override
	public String getType() {
		return "Formula";
	}

	@Override
	public void addMouseListeners(Composite control) {
	}

	@Override
	public void updateData(Map<String, String> params, String value) {
	}

	@Override
	public String getTex() {
		return fTexExpression;
	}
}
