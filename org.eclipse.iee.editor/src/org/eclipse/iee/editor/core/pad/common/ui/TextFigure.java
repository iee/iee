package org.eclipse.iee.editor.core.pad.common.ui;

import java.util.Hashtable;

import org.eclipse.draw2d.FocusBorder;
import org.eclipse.draw2d.FocusEvent;
import org.eclipse.draw2d.FocusListener;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.KeyEvent;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.text.BlockFlow;
import org.eclipse.draw2d.text.CaretInfo;
import org.eclipse.draw2d.text.FlowPage;
import org.eclipse.draw2d.text.ParagraphTextLayout;
import org.eclipse.draw2d.text.TextFlow;
import org.eclipse.iee.editor.core.pad.common.text.ICompositeTextPart;
import org.eclipse.iee.editor.core.pad.common.text.IContentTextPart;
import org.eclipse.iee.editor.core.pad.common.text.OffsetTextLocation;
import org.eclipse.iee.editor.core.pad.common.text.TextLocation;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Display;

import com.google.common.base.Optional;
import com.google.common.base.Strings;

public class TextFigure extends FlowPage implements IContentTextPart {

	private Document fFormula;
	private TextFlow fTextFlow;
	private Caret fCaret;
	private int fCaretOffset;
	private Hashtable<Integer, Integer> fKeyActionMap = new Hashtable<Integer, Integer>();
	
	private SelectionModel fSelectionModel = new SelectionModel() {

		@Override
		public TextLocation getStart() {
			return new OffsetTextLocation(TextFigure.this, fCaretOffset);
		}
		
	};
	
	public TextFigure(final Caret caret) {
		this.fCaret = caret;
		fFormula = new Document();
		BlockFlow blockFlow = new BlockFlow();
		fTextFlow = new TextFlow(fFormula.get());
		fTextFlow.setLayoutManager(new ParagraphTextLayout(fTextFlow, ParagraphTextLayout.WORD_WRAP_SOFT));
		blockFlow.add(fTextFlow);
		add(blockFlow);
		
		addMouseListener(new MouseListener() {

			public void mousePressed(MouseEvent me) {
				int[] trailing = new int[1];
				Point location = me.getLocation();
				translateFromParent(location);
				int offset = fTextFlow.getOffset(location, trailing, null);
				updateCaret(fTextFlow, caret, offset, trailing[0] == 1);
				requestFocus();
			}

			public void mouseReleased(MouseEvent me) {
			}

			public void mouseDoubleClicked(MouseEvent me) {
			}});
		
		setRequestFocusEnabled(true);
	
		addKeyListener(new org.eclipse.draw2d.KeyListener () {

			public void keyPressed(org.eclipse.draw2d.KeyEvent ke) {
				int action = getAction(ke);
				if (action == SWT.NULL) {
					TextLocation cursonPosition = getCursonPosition();
					replace(cursonPosition, cursonPosition, String.valueOf(ke.character));
					doColumnNext();
				} else {
					doAction(action);
				}
			}


			public void keyReleased(org.eclipse.draw2d.KeyEvent ke) {
			}});
		
		addFocusListener(new FocusListener() {

			public void focusGained(FocusEvent fe) {
				IFigure gainer = fe.gainer;
				gainer.setBorder(new FocusBorder());
			}

			public void focusLost(FocusEvent fe) {
				IFigure loser = fe.loser;
				loser.setBorder(null);
			}});
		fFormula.addDocumentListener(new IDocumentListener() {
			@Override
			public void documentAboutToBeChanged(DocumentEvent event) {
			}

			@Override
			public void documentChanged(DocumentEvent event) {
				String s = event.getDocument().get();
				if (!Strings.isNullOrEmpty(s)) {
					fTextFlow.setText(s);
				} else {
					fTextFlow.setText("\u25a1");
				}
				revalidate();
			}
		});
		createKeyBindings();
	}


	private int getAction(KeyEvent event) {
		int action;
		if (event.keycode != 0) {
			// special key pressed (e.g., F1)
			action = getKeyBinding(event.keycode | event.getState());
		} else {
			// character key pressed
			action = getKeyBinding(event.character | event.getState());
			if (action == SWT.NULL) {
				if ((event.getState() & SWT.CTRL) != 0 && event.character <= 31) {
					// get the character from the CTRL+char sequence, the control
					// key subtracts 64 from the value of the key that it modifies
					int c = event.character + 64;
					action = getKeyBinding(c | event.
							getState());
				}
			}
		}
		return action;
		
	}
	
	
	private int getKeyBinding(int key) {
		Integer action = (Integer) fKeyActionMap.get(new Integer(key));	
		return action == null ? SWT.NULL : action.intValue();
	}
	
	/**
	 * Creates default key bindings.
	 */
	void createKeyBindings() {
		int nextKey = isMirrored() ? SWT.ARROW_LEFT : SWT.ARROW_RIGHT;
		int previousKey = isMirrored() ? SWT.ARROW_RIGHT : SWT.ARROW_LEFT;
		
		// Navigation
		setKeyBinding(SWT.ARROW_UP, ST.LINE_UP);	
		setKeyBinding(SWT.ARROW_DOWN, ST.LINE_DOWN);
			
		setKeyBinding(SWT.HOME, ST.LINE_START);
		setKeyBinding(SWT.END, ST.LINE_END);
		setKeyBinding(SWT.HOME | SWT.MOD1, ST.TEXT_START);
		setKeyBinding(SWT.END | SWT.MOD1, ST.TEXT_END);
		setKeyBinding(nextKey | SWT.MOD1, ST.WORD_NEXT);
		setKeyBinding(previousKey | SWT.MOD1, ST.WORD_PREVIOUS);

		setKeyBinding(SWT.PAGE_UP, ST.PAGE_UP);
		setKeyBinding(SWT.PAGE_DOWN, ST.PAGE_DOWN);
		setKeyBinding(SWT.PAGE_UP | SWT.MOD1, ST.WINDOW_START);
		setKeyBinding(SWT.PAGE_DOWN | SWT.MOD1, ST.WINDOW_END);
		setKeyBinding(nextKey, ST.COLUMN_NEXT);
		setKeyBinding(previousKey, ST.COLUMN_PREVIOUS);
		
		// Selection
		setKeyBinding(SWT.ARROW_UP | SWT.MOD2, ST.SELECT_LINE_UP);	
		setKeyBinding(SWT.ARROW_DOWN | SWT.MOD2, ST.SELECT_LINE_DOWN);

		setKeyBinding(SWT.HOME | SWT.MOD2, ST.SELECT_LINE_START);
		setKeyBinding(SWT.END | SWT.MOD2, ST.SELECT_LINE_END);
		setKeyBinding(SWT.HOME | SWT.MOD1 | SWT.MOD2, ST.SELECT_TEXT_START);	
		setKeyBinding(SWT.END | SWT.MOD1 | SWT.MOD2, ST.SELECT_TEXT_END);
		setKeyBinding(nextKey | SWT.MOD1 | SWT.MOD2, ST.SELECT_WORD_NEXT);
		setKeyBinding(previousKey | SWT.MOD1 | SWT.MOD2, ST.SELECT_WORD_PREVIOUS);
		
		setKeyBinding(SWT.PAGE_UP | SWT.MOD2, ST.SELECT_PAGE_UP);
		setKeyBinding(SWT.PAGE_DOWN | SWT.MOD2, ST.SELECT_PAGE_DOWN);
		setKeyBinding(SWT.PAGE_UP | SWT.MOD1 | SWT.MOD2, ST.SELECT_WINDOW_START);
		setKeyBinding(SWT.PAGE_DOWN | SWT.MOD1 | SWT.MOD2, ST.SELECT_WINDOW_END);
		setKeyBinding(nextKey | SWT.MOD2, ST.SELECT_COLUMN_NEXT);
		setKeyBinding(previousKey | SWT.MOD2, ST.SELECT_COLUMN_PREVIOUS);	
	           	  	
		// Modification
		// Cut, Copy, Paste
		setKeyBinding('X' | SWT.MOD1, ST.CUT);
		setKeyBinding('C' | SWT.MOD1, ST.COPY);
		setKeyBinding('V' | SWT.MOD1, ST.PASTE);
	
		// Cut, Copy, Paste Wordstar style
		setKeyBinding(SWT.DEL | SWT.MOD2, ST.CUT);
		setKeyBinding(SWT.INSERT | SWT.MOD1, ST.COPY);
		setKeyBinding(SWT.INSERT | SWT.MOD2, ST.PASTE);
		
		setKeyBinding(SWT.BS | SWT.MOD2, ST.DELETE_PREVIOUS);
		setKeyBinding(SWT.BS, ST.DELETE_PREVIOUS);
		setKeyBinding(SWT.DEL, ST.DELETE_NEXT);
		setKeyBinding(SWT.BS | SWT.MOD1, ST.DELETE_WORD_PREVIOUS);
		setKeyBinding(SWT.DEL | SWT.MOD1, ST.DELETE_WORD_NEXT);
		
		// Miscellaneous
		setKeyBinding(SWT.INSERT, ST.TOGGLE_OVERWRITE);
	}

	public void setKeyBinding(int key, int action) {
		int modifierValue = key & SWT.MODIFIER_MASK;
		char keyChar = (char)(key & SWT.KEY_MASK);
		if (Character.isLetter(keyChar)) {
			char ch = Character.toUpperCase(keyChar);
			int newKey = ch | modifierValue;
			if (action == SWT.NULL) {
				fKeyActionMap.remove(new Integer(newKey));
			} else {
			 	fKeyActionMap.put(new Integer(newKey), new Integer(action));
			}
			ch = Character.toLowerCase(keyChar);
			newKey = ch | modifierValue;
			if (action == SWT.NULL) {
				fKeyActionMap.remove(new Integer(newKey));
			} else {
			 	fKeyActionMap.put(new Integer(newKey), new Integer(action));
			}
		} else {
			if (action == SWT.NULL) {
				fKeyActionMap.remove(new Integer(key));
			} else {
			 	fKeyActionMap.put(new Integer(key), new Integer(action));
			}
		}		
	}
	

	private void doAction(int action) {
		switch (action) {
		case ST.DELETE_PREVIOUS:
			doDeletePrevious();
			break;
		case ST.DELETE_NEXT:
			doDeleteNext();
			break;
		case ST.COLUMN_NEXT:
			doColumnNext();
			break;
		case ST.COLUMN_PREVIOUS:
			doColumnPrevious();
			break;
		default:
			break;
		}
		
		
	}

	private void doColumnNext() {
		TextLocation position = getCursonPosition();
		Optional<TextLocation> next = position.getNext();
		if (next.isPresent()) {
			showCursorAt(next.get());
		}
	}
	
	private void doColumnPrevious() {
		TextLocation position = getCursonPosition();
		Optional<TextLocation> previous = position.getPrevious();
		if (previous.isPresent()) {
			showCursorAt(previous.get());
		}
	}
	
	private TextLocation getCursonPosition() {
		return new OffsetTextLocation(this, fCaretOffset);
	}
	
	private void doDeletePrevious() {
		TextLocation start = fSelectionModel.getStart();
		Optional<TextLocation> previous = start.getPrevious();
		if (previous.isPresent()) {
			replace(previous.get(), start, "");
			showCursorAt(previous.get());
		}
	}
	
	private void doDeleteNext() {
		TextLocation start = fSelectionModel.getStart();
		Optional<TextLocation> next = start.getNext();
		if (next.isPresent()) {
			replace(start, next.get(), "");
		}
	}
	
	private void showCursorAt(TextLocation textLocation) {
		int position = textLocation.getPosition();
		updateCaret(fTextFlow, fCaret, position, position == fFormula.getLength());
	}
	
	private void replace(TextLocation start, TextLocation end, String text) {
		try {
			fFormula.replace(start.getPosition(), end.getPosition() - start.getPosition(), text);
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public void addDocumentListener(IDocumentListener listener) {
		fFormula.addDocumentListener(listener);
	}


	public String getText() {
		return fFormula.get();
	}


	public void setText(String text) {
		fFormula.set(text);
	}
	
	private void updateCaret(final TextFlow textFlow, final Caret caret,
			final int offset, final boolean b) {
		fCaretOffset = offset;
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				CaretInfo caretPlacement = textFlow.getCaretPlacement(offset, b);
				caret.setVisible(true);
				caret.setSize(1, caretPlacement.getHeight());
				caret.setLocation(caretPlacement.getX(), caretPlacement.getY());					}
		});
	}


	@Override
	public int getLength() {
		return fFormula.getLength();
	}


	@Override
	public TextLocation getStart() {
		return new OffsetTextLocation(this, 0);
	}


	@Override
	public TextLocation getEnd() {
		return new OffsetTextLocation(this, getLength() - 1);
	}


	@Override
	public Optional<ICompositeTextPart> getParentTextPart() {
		return Optional.absent() ;
	}


	@Override
	public void updateCaret(Caret caret, int position, boolean flag) {
		
	}


	@Override
	public void replace(int start, int end, String text) {
		
	}
	
}
