package org.eclipse.iee.pad.text.ui;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.iee.editor.core.bindings.TextViewerSupport;
import org.eclipse.iee.editor.core.pad.CompositePad;
import org.eclipse.iee.pad.text.TextPart;
import org.eclipse.iee.pad.text.elements.Node;
import org.eclipse.iee.pad.text.elements.NodeVisitor;
import org.eclipse.iee.pad.text.elements.Span;
import org.eclipse.iee.pad.text.elements.TextNode;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.TextViewer;
import org.eclipse.jface.text.TextViewerUndoManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Resource;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;

public class TextPad extends CompositePad<TextPart> {

	private TextViewer fViewer;
	private Document fDocument;

	private Composite fParent;
	private Composite fInputView;

	private boolean fTextChanged;

	private Image iBold;
	private Image iFont;
	private Image iItalic;
	private Image iUnderline;
	private Image iStrikeout;
	private Image iCut;
	private Image iCopy;
	private Image iPaste;
	private Image iTextForeground;
	private Image iTextBackground;

	private Font textFont;
	
	private MenuItem fontControl, boldControl, italicControl;
	private Color textForeground, textBackground;
	private int styleState;
	static final int BOLD = SWT.BOLD;
	static final int ITALIC = SWT.ITALIC;
	static final int FONT_STYLE = BOLD | ITALIC;
	static final int FONT = 1 << 3;
	static final int FOREGROUND = 1 << 4;
	static final int BACKGROUND = 1 << 5;
	
	public TextPad(TextPart textPart) {
		super(textPart);
	}

	public void toggleEditMode() {
//		fViewer.setEditable(true);

		fParent.pack();

		fViewer.getControl().forceFocus();
	}

	public void toggleViewMode() {
//		fViewer.setEditable(false);
		getContainer().updateDocument();
		focusOnMainEditor();
		fParent.pack();
	}

	public void setListeners() {

		fViewer.addTextListener(new ITextListener() {

			@Override
			public void textChanged(TextEvent event) {
				fTextChanged = true;
				String newText = fDocument.get();
				getDocumentPart().setRoot(toRoot(fDocument));
				getContainer().updateDocument();
				if (newText != "") {
					/* Resize fInputText */
					Point size = fViewer.getControl().computeSize(
							SWT.DEFAULT, SWT.DEFAULT, false);
					fViewer.getControl().setSize(size);
					fParent.pack();
				}
			}
		});

		final StyledText control = (StyledText)fViewer.getControl();
		control.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				switch (e.keyCode) {
				case SWT.ESC:
					toggleViewMode();
					moveCaretToContainerTail();
					break;
				

				}
			}
		});
		
		control.addVerifyKeyListener(new VerifyKeyListener() {
			@Override
			public void verifyKey(VerifyEvent event) {
				Point selection = control.getSelection();
				int caretOffset = control.getCaretOffset();
				switch (event.keyCode) {
				case SWT.ARROW_LEFT:
					if (selection.y - selection.x == 0 && caretOffset == 0) {
						toggleViewMode();
						moveCaretToCurrentPad();
					}
					break;
				case SWT.ARROW_RIGHT:
					if (selection.y - selection.x == 0 && caretOffset == control.getCharCount()) {
						toggleViewMode();
						moveCaretToContainerTail();
					}
					break;
				}
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

		fViewer = new TextViewer(fInputView, SWT.MULTI);
		fViewer.getControl().setSize(50, 100);
		fDocument = new Document(rootToString(getDocumentPart().getRoot()));
		fViewer.setDocument(fDocument);
		fViewer.getTextWidget().setStyleRanges(rootToStyleRanges(getDocumentPart().getRoot()));
		fTextChanged = false;

		TextViewerUndoManager defaultUndoManager = new TextViewerUndoManager(25);
		fViewer.setUndoManager(defaultUndoManager);
		defaultUndoManager.connect(fViewer);
		new TextViewerSupport(fViewer);
		
		((StyledText)fViewer.getControl()).setMenu(createPopupMenu(fViewer.getControl()));
		setListeners();
		toggleViewMode();
	}

	private Menu createPopupMenu(org.eclipse.swt.widgets.Control parent) {
		Menu menu = new Menu(parent);

		final MenuItem cutItem = new MenuItem(menu, SWT.PUSH);
		cutItem.setText("Cut"); 
		cutItem.setImage(iCopy);
		cutItem.setAccelerator(SWT.MOD1 | 'x');
		cutItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				((StyledText)fViewer.getControl()).cut();
			}
		});

		final MenuItem copyItem = new MenuItem(menu, SWT.PUSH);
		copyItem.setText("Copy"); 
		copyItem.setImage(iCopy);
		copyItem.setAccelerator(SWT.MOD1 | 'c');
		copyItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				((StyledText)fViewer.getControl()).copy();
			}
		});

		MenuItem pasteItem = new MenuItem(menu, SWT.PUSH);
		pasteItem.setText("Paste"); 
		pasteItem.setImage(iPaste);
		pasteItem.setAccelerator(SWT.MOD1 | 'v');
		pasteItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				((StyledText)fViewer.getControl()).paste();
			}
		});

		new MenuItem (menu, SWT.SEPARATOR);
		
		fontControl = new MenuItem(menu, SWT.PUSH);
		fontControl.setImage(iFont);
		fontControl.setText("Font");
		fontControl.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				StyledText textWidget = fViewer.getTextWidget();
				Shell shell = textWidget.getShell();
				FontDialog dlg = new FontDialog(shell);

				if (textFont != null) {
					dlg.setFontList(textFont.getFontData());
				}
				if (textForeground != null) {
					dlg.setRGB(textForeground.getRGB());
				}

				if (dlg.open() != null) {
					if (textFont != null) {
						textFont.dispose();
					}
					if (textForeground != null)
						textForeground.dispose();

					textFont = new Font(shell.getDisplay(), dlg.getFontList());
					setStyle(FONT);

					RGB rgb = dlg.getRGB();
					if (rgb != null) {
						textForeground = new Color(shell.getDisplay(), rgb);
						setStyle(FOREGROUND);
					}
				}
				fParent.pack();
			}
		});
		
		boldControl = new MenuItem(menu, SWT.PUSH);
		boldControl.setImage(iBold);
		boldControl.setText("Bold");
		boldControl.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				setStyle(BOLD);
			}
		});

		italicControl = new MenuItem(menu, SWT.PUSH);
		italicControl.setImage(iItalic);
		italicControl.setText("Italic"); //$NON-NLS-1$
		italicControl.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				setStyle(ITALIC);
			}
		});

		MenuItem foregroundItem = new MenuItem(menu, SWT.PUSH);
		foregroundItem.setImage(iTextForeground);
		foregroundItem.setText("Text Foreground"); //$NON-NLS-1$
		foregroundItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {		
				if (event.detail == SWT.ARROW || textForeground == null) {
					ColorDialog dialog = new ColorDialog(((StyledText)fViewer.getControl()).getShell());
					RGB rgb = textForeground != null ? textForeground.getRGB() : null;
					dialog.setRGB(rgb);
					RGB newRgb = dialog.open();
					if (newRgb == null) return;
					if (!newRgb.equals(rgb)) {
						disposeResource(textForeground);
						textForeground = new Color(Display.getDefault(), newRgb);					
					}
				}
				setStyle(FOREGROUND);				
			}
		});

		MenuItem backgroundItem = new MenuItem(menu, SWT.PUSH);
		backgroundItem.setImage(iTextBackground);
		backgroundItem.setText("Text Background"); //$NON-NLS-1$
		backgroundItem.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {			
				if (event.detail == SWT.ARROW || textBackground == null) {
					ColorDialog dialog = new ColorDialog(((StyledText)fViewer.getControl()).getShell());
					RGB rgb = textBackground != null ? textBackground.getRGB() : null;
					dialog.setRGB(rgb);
					RGB newRgb = dialog.open();
					if (newRgb == null) return;
					if (!newRgb.equals(rgb)) {
						disposeResource(textBackground);
						textBackground = new Color(Display.getDefault(), newRgb);
					}
				}
				setStyle(BACKGROUND);
			}
		});

		return menu;
	}
	
	@Override
	public void activate() {
		toggleEditMode();
	}

	@Override
	public void deactivate() {
		fViewer.getTextWidget().setSelection(0,0);
		toggleViewMode();
	}
	
	@Override
	public TextPad copy() {
		TextPad newPad = new TextPad(getDocumentPart().copy());
		return newPad;
	}

	// Save&Load operations, use it for serialization

	public void save() {
	}

	@Override
	public void unsave() {
	}

	@Override
	public String getType() {
		return "Text";
	}

	@Override
	public void addMouseListeners(Composite control) {
	}
	
	void initResources() {
		iFont= loadImage(Display.getDefault(), "font_big.ico"); 
		iBold = loadImage(Display.getDefault(), "bold.ico"); 
		iItalic = loadImage(Display.getDefault(), "italic.ico"); 
		iUnderline = loadImage(Display.getDefault(), "underline.ico"); 
		iStrikeout = loadImage(Display.getDefault(), "strikeout.ico"); 
		iCut = loadImage(Display.getDefault(), "cut.ico"); 
		iCopy = loadImage(Display.getDefault(), "copy.ico"); 
		iPaste = loadImage(Display.getDefault(), "paste.ico"); 
		iTextForeground = loadImage(Display.getDefault(), "textForeground.ico"); 
		iTextBackground = loadImage(Display.getDefault(), "textBackground.ico"); 
	}
	
	private Image loadImage(Display display, String fileName) {
		Image image = null; 
		try {
			InputStream sourceStream = getClass().getResourceAsStream("icons/" + fileName);
			ImageData source = new ImageData(sourceStream);
			ImageData mask = source.getTransparencyMask();
			image = new Image(display, source, mask);
			sourceStream.close();
		} catch (IOException e) {
		}
		return image;
	}
	
	void setStyle(int style) {
		int[] ranges = ((StyledText)fViewer.getControl()).getSelectionRanges();
		int i = 0;
		while (i < ranges.length) {
			setStyle(style, ranges[i++], ranges[i++]);
		}
		updateStyleState(style, FOREGROUND);
		updateStyleState(style, BACKGROUND);
	}
	
	void updateStyleState(int style, int changingStyle) {
		if ((style & changingStyle) != 0) {
			if ((style & changingStyle) == (styleState & changingStyle)) {
				styleState &= ~changingStyle;
			} else {
				styleState &= ~changingStyle;
				styleState |= style;
			}
		}
	}
	
	void setStyle(int style, int start, int length) {
		if (length == 0) return;
		
		/* Create new style range */
		StyleRange newRange = new StyleRange();
		if ((style & FONT) != 0) {
			newRange.font = textFont;
		}
		if ((style & FONT_STYLE) != 0) {
			newRange.fontStyle = style & FONT_STYLE;
		}
		if ((style & FOREGROUND) != 0) {
			newRange.foreground = textForeground;
		}
		if ((style & BACKGROUND) != 0) {
			newRange.background = textBackground;
		}
		
		int newRangeStart = start;
		int newRangeLength = length;
		int[] ranges = ((StyledText)fViewer.getControl()).getRanges(start, length);
		StyleRange[] styles = ((StyledText)fViewer.getControl()).getStyleRanges(start, length, false);		
		int maxCount = ranges.length * 2 + 2;
		int[] newRanges = new int[maxCount];
		StyleRange[] newStyles = new StyleRange[maxCount / 2];		
		int count = 0;
		for (int i = 0; i < ranges.length; i+=2) {
			int rangeStart = ranges[i];
			int rangeLength = ranges[i + 1];
			StyleRange range = styles[i / 2];
			if (rangeStart > newRangeStart) {
				newRangeLength = rangeStart - newRangeStart;
				newRanges[count] = newRangeStart;
				newRanges[count + 1] = newRangeLength;
				newStyles[count / 2] = newRange;
				count += 2;
			}
			newRangeStart = rangeStart + rangeLength;
			newRangeLength = (start + length) - newRangeStart;

			/* Create merged style range*/
			StyleRange mergedRange = new StyleRange(range);
			//Note: fontStyle is not copied by the constructor
			mergedRange.fontStyle = range.fontStyle;
			
			if ((style & FONT) != 0) {
				mergedRange.font = textFont;
			}
			if ((style & FONT_STYLE) != 0) {
				mergedRange.fontStyle =  range.fontStyle ^ newRange.fontStyle;
			}
			if (mergedRange.font != null && ((style & FONT_STYLE) != 0)) {
				boolean change = false;
				FontData[] fds = mergedRange.font.getFontData();
				for (int j = 0; j < fds.length; j++) {
					FontData fd = fds[j];
					if (fd.getStyle() != mergedRange.fontStyle) {
						fds[j].setStyle(mergedRange.fontStyle);
						change = true;
					}
				}
				if (change) {
					mergedRange.font = new Font(Display.getCurrent(), fds);
				}
			}
			if ((style & FOREGROUND) != 0) {
				mergedRange.foreground = newRange.foreground != range.foreground ? newRange.foreground : null;
			}
			if ((style & BACKGROUND) != 0) {
				mergedRange.background = newRange.background != range.background ? newRange.background : null;
			}
			
			newRanges[count] = rangeStart;
			newRanges[count + 1] = rangeLength;
			newStyles[count / 2] = mergedRange;
			count += 2;
		}
		if (newRangeLength > 0) {
			newRanges[count] = newRangeStart;
			newRanges[count + 1] = newRangeLength;
			newStyles[count / 2] = newRange;
			count += 2;
		}
		if (0 < count && count < maxCount) {			
			int[] tmpRanges = new int[count];
			StyleRange[] tmpStyles = new StyleRange[count / 2];
			System.arraycopy(newRanges, 0, tmpRanges, 0, count);
			System.arraycopy(newStyles, 0, tmpStyles, 0, count / 2);
			newRanges = tmpRanges;
			newStyles = tmpStyles;
		}
		((StyledText)fViewer.getControl()).setStyleRanges(start, length, newRanges, newStyles);
		disposeRanges(styles);
	}
	
	void disposeRanges(StyleRange[] ranges) {
		StyleRange[] allRanges = ((StyledText)fViewer.getControl()).getStyleRanges(0, ((StyledText)fViewer.getControl()).getCharCount(), false);
		for (int i = 0; i < ranges.length; i++) {
			StyleRange style = ranges[i];
			boolean disposeFg = true, disposeBg = true, disposeStrike= true, disposeUnder= true, disposeBorder = true, disposeFont = true;

			for (int j = 0; j < allRanges.length; j++) {
				StyleRange s = allRanges[j];
				if (disposeFont && style.font == s.font) disposeFont = false;
				if (disposeFg && style.foreground == s.foreground) disposeFg = false;
				if (disposeBg && style.background == s.background) disposeBg = false;
				if (disposeStrike && style.strikeoutColor == s.strikeoutColor) disposeStrike = false;
				if (disposeUnder && style.underlineColor == s.underlineColor) disposeUnder = false;
				if (disposeBorder && style.borderColor == s.borderColor) disposeBorder =  false;
			}
			if (disposeFont && style.font != textFont && style.font != null)  style.font.dispose();
			if (disposeFg && style.foreground != textForeground && style.foreground != null) style.foreground.dispose();
			if (disposeBg && style.background != textBackground && style.background != null) style.background.dispose();
			
			Object data = style.data;
			if (data != null) {
				if (data instanceof Image) ((Image)data).dispose();
				if (data instanceof Control) ((Control)data).dispose();
			}
		}
	}
	
	void disposeResource(Resource resource) {
		if (resource == null) return;
		StyleRange[] styles = ((StyledText)fViewer.getControl()).getStyleRanges(0, ((StyledText)fViewer.getControl()).getCharCount(), false);
		int index = 0;
		while (index < styles.length) {
			if (styles[index].font == resource) break;
			if (styles[index].foreground == resource) break;
			if (styles[index].background == resource) break;
			if (styles[index].strikeoutColor == resource) break;
			if (styles[index].underlineColor == resource) break;
			if (styles[index].borderColor == resource) break;
			index++;
		}
		if (index == styles.length) resource.dispose();
	}
	
	@Override
	public String getTex() {
		return rootToString(this.getDocumentPart().getRoot()).replaceAll(" ", " \\\\ ")
				.replaceAll("\r\n", " \\\\\\\\ ")
				.replaceAll("\t", " \\\\quad ");
	}
	
	public String rootToString(Node root) {
		final StringWriter sw = new StringWriter();
		root.traverse(new NodeVisitor() {
			
			@Override
			public void tail(Node node, int depth) {
			}
			
			@Override
			public void head(Node node, int depth) {
				if (node instanceof TextNode) {
					sw.append(((TextNode) node).getText());
				}
			}
		});
		
		return sw.toString();
	}
	
	public StyleRange[] rootToStyleRanges(Node root) {
		final List<StyleRange> srs = new ArrayList<>();
		root.traverse(new NodeVisitor() {
			private int offset = 0;
			private int length = 0;
			
			@Override
			public void tail(Node node, int depth) {
				if (node instanceof Span) {
					Span span = (Span) node;
					StyleRange styleRange = new StyleRange();
					styleRange.start = offset;
					styleRange.length = length;
					Boolean bold = span.isBold().or(Boolean.FALSE);
					Boolean italic = span.isItalic().or(Boolean.FALSE);
					styleRange.fontStyle = 0xFF & ((bold ? SWT.BOLD : 0) | (italic ? SWT.ITALIC : 0));
					StyledText textWidget = fViewer.getTextWidget();
					Display display = textWidget.getDisplay();
					styleRange.foreground = toSwtColor(display, span.getFgColor().or(java.awt.Color.BLACK));
					styleRange.background = toSwtColor(display, span.getBgColor().or(java.awt.Color.WHITE));
					if (span.getFont().isPresent()) {
						FontData[] fontData = JFaceResources.getFontRegistry().getFontData(span.getFont().get());
						if (span.getFontSize().isPresent()) {
							fontData[0].setHeight(span.getFontSize().get());
						}
						styleRange.font = new Font(display, fontData);
					}
					srs.add(styleRange);
					offset += length;
					length = 0;
				}
			}
			
			@Override
			public void head(Node node, int depth) {
				if (node instanceof TextNode) {
					length = ((TextNode) node).getText().length();
				}
			}
		});
		
		return (StyleRange[]) srs.toArray(new StyleRange[srs.size()]);
	}
	
	public Node toRoot(Document document) {
		Node root = new Node();
		StyledText textWidget = fViewer.getTextWidget();
		
		String text = document.get();
		for (int i = 0; i < text.length(); i++) {
			StringBuilder spanText = new StringBuilder().append(text.charAt(i)); 
			StyleRange styleRange = textWidget.getStyleRangeAtOffset(i);
			while (i + 1 < text.length()
					&& isSimilarTo(styleRange, textWidget.getStyleRangeAtOffset(i + 1))) {
				i++;
				spanText.append(text.charAt(i));
			}
			Span span = new Span();
			if (styleRange != null) {
				if ((styleRange.fontStyle & SWT.BOLD) > 0) {
					span.setBold(true);
				}
				if ((styleRange.fontStyle & SWT.ITALIC) > 0) {
					span.setItalic(true);
				}
				if (styleRange.foreground != null) {
					span.setFgColor(toAwtColor(styleRange.foreground));
				}
				if (styleRange.background != null) {
					span.setBgColor(toAwtColor(styleRange.background));
				}
				Font font = styleRange.font;
				if (font != null) {
					span.setFont(font.getFontData()[0].getName());
					span.setFontSize(font.getFontData()[0].getHeight());
				}
			}
			span.appendChild(new TextNode().setText(spanText.toString()));
			root.appendChild(span);
		}
		return root;
	}

	private boolean isSimilarTo(StyleRange sr1, StyleRange sr2) {
		if (sr1 == null && sr2 == null) {
			return true;
		} else if (sr1 == sr2) {
			return true;
		} else if (sr1 != null && sr2 != null && sr1.similarTo(sr2)) {
			return true;
		}
		return false;
	}
	
    public static java.awt.Color toAwtColor(Color color) { 
        return new java.awt.Color(color.getRed(), color.getGreen(),  
                color.getBlue()); 
    } 
     
    public static Color toSwtColor(Device device, java.awt.Paint paint) { 
        java.awt.Color color; 
        if (paint instanceof java.awt.Color) { 
            color = (java.awt.Color) paint; 
        } 
        else { 
            try { 
                throw new Exception("only color is supported at present... "  
                        + "setting paint to uniform black color" ); 
            }  
            catch (Exception e) { 
                e.printStackTrace(); 
                color = new java.awt.Color(0, 0, 0); 
            } 
        } 
        return new org.eclipse.swt.graphics.Color(device, 
                color.getRed(), color.getGreen(), color.getBlue()); 
    } 
	
}
