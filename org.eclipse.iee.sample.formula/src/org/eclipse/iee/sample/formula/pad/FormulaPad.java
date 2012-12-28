package org.eclipse.iee.sample.formula.pad;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.eclipse.iee.editor.core.container.Container;
import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.utils.console.ConsoleMessageEvent;
import org.eclipse.iee.editor.core.utils.console.ConsoleMessager;
import org.eclipse.iee.editor.core.utils.console.IConsoleMessageListener;
import org.eclipse.iee.sample.formula.FormulaPadManager;
import org.eclipse.iee.sample.formula.bindings.TextViewerSupport;
import org.eclipse.iee.sample.formula.pad.hover.HoverShell;
import org.eclipse.iee.translator.antlr.translator.JavaTranslator;
import org.eclipse.iee.translator.antlr.translator.JavaTranslator.VariableType;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
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
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

public class FormulaPad extends Pad {

	@XStreamOmitField
	private static final Logger logger = Logger.getLogger(FormulaPad.class);

	@XStreamOmitField
	private Composite fParent;
	@XStreamOmitField
	private Composite fInputView;
	@XStreamOmitField
	private Composite fResultView;

	@XStreamOmitField
	private Label fFormulaImageLabel;
	@XStreamOmitField
	private Label fLastResultImageLabel;

	@XStreamOmitField
	private TextViewer fViewer;
	@XStreamOmitField
	private TextViewerSupport fViewerSupport;
	@XStreamOmitField
	private Document fDocument;

	@XStreamOmitField
	private HoverShell fHoverShell;

	private boolean fIsInputValid;

	private String fDirectoryPath = "";

	private String fOriginalExpression = "";
	private String fTranslatingExpression = "";
	private String fLastValidText = "";

	private int fCaretOffset;
	private int fPreviousCaretOffset;

	private final Color INPUT_VALID_COLOR = new Color(null, 255, 255, 255);
	private final Color INPUT_INVALID_COLOR = new Color(null, 128, 255, 255);

	private IConsoleMessageListener fConsoleMessageListener = new IConsoleMessageListener() {
		@Override
		public void messageReceived(ConsoleMessageEvent e) {
			logger.debug("Message received:" + e.getMessage());
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

	public String getDirectoryPath() {
		return fDirectoryPath;
	}

	public void setDirectoryPath(String directoryPath) {
		this.fDirectoryPath = directoryPath;
	}

	public String getOriginalExpression() {
		return fOriginalExpression;
	}

	public void setOriginalExression(String expression) {
		fOriginalExpression = expression;
	}

	public String getTranslatingExpression() {
		return fTranslatingExpression;
	}

	public void setTranslatingExression(String expression) {
		fTranslatingExpression = expression;
	}

	public FormulaPad() {
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
		logger.debug("force Focus");
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
		String text = fDocument.get();
		fOriginalExpression = text;
		
		if (Translator.isTextValid(text) && FormulaRenderer.isTextValid(text)) {
			setInputIsValid();
			fLastValidText = text;
		} else {
			setInputIsInvalid();
		}
	}

	public void processInput() {
		if (fIsInputValid) {
			if (!fDocument.get().equals(fTranslatingExpression)) {
				/* Remove result images from following pads */
				Collection<Pad> following = FormulaPadManager
						.getFollowingPads(this);

				for (Pad pad : following) {
					((FormulaPad) pad).updateLastResult("");
				}
			}
		}

		fTranslatingExpression = fLastValidText;

		/* Set formula image */
		Image image = FormulaRenderer.getFormulaImage(fTranslatingExpression);
		fFormulaImageLabel.setImage(image);

		/* Generate code */

		String generated = Translator.translateElement(fTranslatingExpression,
				getContainer().getContainerManager().getCompilationUnit(),
				getContainer().getPosition().getOffset());

		/* Add result output */
		if (!fTranslatingExpression.trim().isEmpty())
			if (fTranslatingExpression
					.charAt(fTranslatingExpression.length() - 1) == '=') {
				String output = generateOutputCode(fTranslatingExpression);

				Pattern p = Pattern.compile("\\s*\\[?\\w+\\]?\\s*=$");
				Matcher m = p.matcher(fTranslatingExpression);
				if (m.matches())
					generated = output;
				else
					generated += output;
			}
		getContainer().setTextContent(generated);
		getContainer().setValue(fOriginalExpression);
	}

	public String generateOutputCode(String expresion) {
		Pattern p = Pattern.compile("\\s*\\[?\\w+\\]?\\s*=.*");
		Matcher m = p.matcher(expresion.replaceAll(Pattern.quote("{"), "")
				.replaceAll(Pattern.quote("}"), ""));
		if (m.matches()) {
			String variable = expresion.substring(0, expresion.indexOf('='));
			variable = variable.trim();
			variable = variable.replaceAll(Pattern.quote("{"), "");
			variable = variable.replaceAll(Pattern.quote("}"), "");
			VariableType varType = JavaTranslator.getVariableType();

			if (varType == null) {
				if (JavaTranslator.getDoubleFields().contains(variable))
					varType = JavaTranslator.VariableType.DOUBLE;
				else if (JavaTranslator.getIntegerFields().contains(variable))
					varType = JavaTranslator.VariableType.INT;
				else if (JavaTranslator.getMatrixFields().contains(variable))
					varType = JavaTranslator.VariableType.MATRIX;
				else
					return "";
			}

			System.out.println("Type:" + varType.toString());

			if (varType != JavaTranslator.VariableType.MATRIX) {
				return "System.out.println(\"" + getContainerID() + "\" + "
						+ variable + ");";
			} else {
				String output = "";

				// TODO: extend Matrix class or change i, j and matrix

				output += "int i=0, j=0; String matrix = \"{\";";

				output += "for(i = 0; i < " + variable
						+ ".getRowDimension(); i++){" + "matrix += \"{\";"
						+ "for(j = 0; j < " + variable
						+ ".getColumnDimension(); j++)";
				output += "{";
				output += "matrix += " + variable + ".get(i,j);";
				output += "if (j !=" + variable + ".getColumnDimension() - 1)";
				output += "matrix += \",\";";
				output += "else matrix += \"}\";";
				output += "}";
				output += "if (i !=" + variable + ".getRowDimension() - 1)";
				output += "matrix += \",\";";
				output += "}";

				output += "matrix += \"}\";";

				output += "System.out.println(\"" + getContainerID() + "\" + "
						+ "matrix);";

				return output;

			}
		} else {
			return "";
		}
	}

	public void updateLastResult(String result) {
		if (result == "") {
			fLastResultImageLabel.setImage(null);
			fParent.pack();
			return;
		}

		Image image = FormulaRenderer.getFormulaImage(result);
		fLastResultImageLabel.setImage(image);
		fParent.pack();
	}

	private void switchToResultView() {
		processInput();
		moveCaretToCurrentPad();

		if (fTranslatingExpression != "")
			toggleFormulaImage();

		if (fHoverShell != null) {
			fHoverShell.dispose();
			fHoverShell = null;
		}
	}

	private void moveCaretToContainerTail() {
		Container c = getContainer();
		ContainerManager containerManager = c.getContainerManager();
		containerManager.getStyledText().setCaretOffset(
				c.getPosition().getOffset() + c.getPosition().getLength());
	}

	public void setListeners() {

		ConsoleMessager.getInstance().addConsoleMessageListener(
				fConsoleMessageListener);

		fFormulaImageLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
			}

			@Override
			public void mouseDown(MouseEvent e) {
				moveCaretToCurrentPad();
				toggleInputText();
			}

			@Override
			public void mouseUp(MouseEvent e) {
			}
		});

		fLastResultImageLabel.addMouseListener(new MouseListener() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
			}

			@Override
			public void mouseDown(MouseEvent e) {
				moveCaretToCurrentPad();
				toggleInputText();
			}

			@Override
			public void mouseUp(MouseEvent e) {
			}
		});

		fViewer.getControl().addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				processInput();
				if (fTranslatingExpression != "")
					toggleFormulaImage();
				if (fHoverShell != null) {
					fHoverShell.dispose();
					fHoverShell = null;
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				logger.debug("focusGained");
			}
		});

		fViewer.addTextListener(new ITextListener() {

			@Override
			public void textChanged(TextEvent event) {

				if (fDocument.get() != "") {

					validateInput();

					Image image = FormulaRenderer.getFormulaImage(fDocument
							.get());
					if (image == null)
						image = FormulaRenderer.getFormulaImage(fLastValidText);
					if (fHoverShell != null) {
						fHoverShell.dispose();
						fHoverShell = null;
					}
					fHoverShell = new HoverShell(fParent, image);
					/* Resize fInputText */
					Point size = fViewer.getControl().computeSize(SWT.DEFAULT,
							SWT.DEFAULT, false);
					fViewer.getControl().setSize(size);
					fParent.pack();
				}
			}
		});

		fViewer.getControl().addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				getContainer().getContainerManager().fireContainerSelected(
						getContainer());
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
					break;
				case SWT.ARROW_DOWN:
					moveCaretToCurrentPad();
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
						switchToResultView();
						moveCaretToContainerTail();
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
		if (fTranslatingExpression.isEmpty())
			fDocument.set(fOriginalExpression);
		else
			fDocument.set(fTranslatingExpression);
		fViewer.setDocument(fDocument);

		TextViewerUndoManager defaultUndoManager = new TextViewerUndoManager(25);
		fViewer.setUndoManager(defaultUndoManager);
		defaultUndoManager.connect(fViewer);

		fViewerSupport = new TextViewerSupport(fViewer);

		/* Result View */

		fResultView = new Composite(sashForm, SWT.NONE);
		fResultView.setBackground(new Color(null, 255, 255, 255));
		fResultView.setLayout(new GridLayout(2, false));
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

		setListeners();

		// moveCaretToCurrentPad();

		if (fTranslatingExpression != "" && fDocument.get() != "") {
			validateInput();
			processInput();
			toggleFormulaImage();
		} else {
			getContainer().getComposite().setVisible(true);
			toggleInputText();
		}

	}

	@Override
	public void activate() {
		int editorCaretOffset = getContainer().getContainerManager()
				.getStyledText().getCaretOffset();

		toggleInputText();

		if (editorCaretOffset > getContainer().getPosition().getOffset() + 1) {
			fCaretOffset = fTranslatingExpression.length();
			fViewer.getTextWidget().setCaretOffset(fCaretOffset);
		}

	}

	@Override
	public Pad copy() {
		FormulaPad newPad = new FormulaPad();
		newPad.fTranslatingExpression = this.fTranslatingExpression;
		newPad.fOriginalExpression = this.fOriginalExpression;
		newPad.fLastValidText = this.fLastValidText;
		newPad.fIsInputValid = this.fIsInputValid;
		return newPad;
	}

	// Save&Load operations, use it for serialization

	public void save() {
	}

	@Override
	public void unsave() {
	}

	@Override
	public void onContainerAttached() {
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
}
