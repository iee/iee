package org.eclipse.iee.editor.core.container;

import java.util.Hashtable;

import org.eclipse.iee.editor.core.pad.common.text.IContentTextPart;
import org.eclipse.iee.editor.core.pad.common.text.TextLocation;
import org.eclipse.iee.editor.core.pad.common.ui.IMenuContributor;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.text.ITextViewerExtension5;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CaretEvent;
import org.eclipse.swt.custom.CaretListener;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Menu;

import com.google.common.base.Optional;

public class UserInteractionManager {

	private final ISourceViewer fSourceViewer;
	
	private final ContainerManager fContainerManager;

	private Hashtable<Integer, Integer> fKeyActionMap = new Hashtable<Integer, Integer>();
	
	public UserInteractionManager(ContainerManager containerManager) {
		fContainerManager = containerManager;
		fSourceViewer = containerManager.getSourceViewer();

		fContainerManager.selectEditor(null);
		
		initListeners();
		createKeyBindings();
	
	}

	public void moveCaretTo(int offset) {
		fContainerManager.selectEditor(null);
		ITextViewerExtension5 ext5 = getExt5();
		fSourceViewer.getTextWidget().setCaretOffset(ext5.modelOffset2WidgetOffset(offset));
	}

	private ITextViewerExtension5 getExt5() {
		return (ITextViewerExtension5) fSourceViewer;
	}

	public void focusOnMainEditor() {
		fSourceViewer.getTextWidget().forceFocus();
	}
	
	public void updateCaretSelection() {
	}

	protected void initListeners() {
		/* 1) Disallow modification within Container's text region */
		final StyledText textWidget = fSourceViewer.getTextWidget();
		textWidget.addVerifyListener(new VerifyListener() {
			@Override
			public void verifyText(VerifyEvent e) {
				int start = getExt5().widgetOffset2ModelOffset(e.start);
				int end = getExt5().widgetOffset2ModelOffset(e.end);
				Container atStart = fContainerManager
						.getContainerHavingOffset(start);
				Container atEnd = fContainerManager
						.getContainerHavingOffset(end);

				/* Text replaced */
				if ((atStart != null && start != atStart.getPosition()
						.getOffset())
						|| (atEnd != null && e.end != atEnd.getPosition()
								.getOffset())) {
					e.doit = false;
					return;
				}

				/* XXX Visibility */
				// fContainerManager.updateContainerVisibility(false);
			}
		});

		textWidget.addVerifyKeyListener(new VerifyKeyListener() {
			@Override
			public void verifyKey(VerifyEvent event) {
				int action = textWidget.getKeyBinding(event.keyCode
						| event.stateMask);
				if (action == SWT.NULL) {
					if (event.character == SWT.DEL) {
						action = ST.DELETE_NEXT;
					}
				}
				if (action != SWT.NULL) {
					int caretOffset = getExt5().widgetOffset2ModelOffset(textWidget.getCaretOffset());
					switch (action) {
					case ST.COLUMN_PREVIOUS:
					case ST.SELECT_COLUMN_PREVIOUS:
						event.doit = caretPositionChange(caretOffset, false);
						break;
					case ST.COLUMN_NEXT:
					case ST.SELECT_COLUMN_NEXT:	
						event.doit = caretPositionChange(caretOffset, true);
						break;
					case ST.DELETE_NEXT:
						Container container = fContainerManager
								.getContainerHavingOffset(caretOffset);
						if (container != null) {
							container.destroy();
						}
					case ST.DELETE_PREVIOUS:
						Container prevContainer = fContainerManager
								.getContainerHavingOffset(caretOffset - 1);
						if (prevContainer != null) {
							prevContainer.destroy();
						}
					}
				}
			}
		});

		textWidget.addVerifyKeyListener(new VerifyKeyListener () {

			@Override
			public void verifyKey(VerifyEvent e) {
				
				TextLocation position = fContainerManager.getCursonPosition();
				if (position != null) {
					int action = getAction(e);
					if (action == SWT.NULL) {
						replace(position, position, String.valueOf(e.character));
						doColumnNext();
					} else {
						doAction(action);
					}
					e.doit = false;
				}
			}
		
		});

		/*
		 * If caret is inside Container's text region, moving it to the end of
		 * line
		 */
		textWidget.addCaretListener(new CaretListener() {
			@Override
			public void caretMoved(CaretEvent e) {
				Point selection = fSourceViewer.getSelectedRange();
				if (selection.y == 0) {
					int caretOffset = getExt5().widgetOffset2ModelOffset(e.caretOffset);
					Container container = fContainerManager
							.getContainerHavingOffset(caretOffset);
					if (container != null) {
						Position position = container.getPosition();
						if (caretOffset != position.getOffset()) {
							/* Move caret to the Pad's border */
							textWidget.setCaretOffset(getExt5().modelOffset2WidgetOffset(position.getOffset()
									+ position.getLength()));
							fContainerManager.selectEditor(null);
						}
					}
				}
			}
		});
		
		textWidget.addMenuDetectListener(new MenuDetectListener() {
			
			@Override
			public void menuDetected(MenuDetectEvent e) {
				Point control = textWidget.toControl(e.x, e.y);
				Optional<ITextEditor<?, ?>> editor = fContainerManager.getEditorAt(control.x, control.y);
				while (editor.isPresent() && !(editor.get() instanceof IMenuContributor)) {
					editor = editor.get().getParent();
				}
				if (editor.isPresent()) {
					MenuManager menuManager = new MenuManager();
					Menu menu = menuManager.createContextMenu(textWidget);
					((IMenuContributor) editor.get()).contribute(menuManager);
					menuManager.update(false);
					menu.setLocation(e.x, e.y);
					menu.setVisible(true);
					e.doit = false;
				}
			}
		});
		
		textWidget.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				fContainerManager.activateEditor(null);
			}
		});

	}

	private boolean caretPositionChange(int x, boolean caretMovesForward) {
		Point selection = fSourceViewer.getSelectedRange();
		if (selection.y == 0) {
			Container container = fContainerManager.getContainerHavingOffset(caretMovesForward ? x : x - 1);
			if (container != null) {
				Position position = container.getPosition();
				if (caretMovesForward) {
					fContainerManager.activateEditor(container.getPad());
					fSourceViewer.getTextWidget().setCaretOffset(getExt5().modelOffset2WidgetOffset(position.getOffset()
							+ position.getLength()));
				} else {
					fContainerManager.activateEditor(container.getPad());
					fSourceViewer.getTextWidget().setCaretOffset(getExt5().modelOffset2WidgetOffset(position.getOffset()));
				}
				return false;
			}
		}
		return true;
	}
	
	private int getAction(KeyEvent event) {
		int action;
		if (event.keyCode!= 0) {
			// special key pressed (e.g., F1)
			action = getKeyBinding(event.keyCode | event.stateMask);
		} else {
			// character key pressed
			action = getKeyBinding(event.character | event.stateMask);
			if (action == SWT.NULL) {
				if ((event.stateMask & SWT.CTRL) != 0 && event.character <= 31) {
					// get the character from the CTRL+char sequence, the control
					// key subtracts 64 from the value of the key that it modifies
					int c = event.character + 64;
					action = getKeyBinding(c | event.stateMask);
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
		int nextKey = fContainerManager.isMirrored() ? SWT.ARROW_LEFT : SWT.ARROW_RIGHT;
		int previousKey = fContainerManager.isMirrored() ? SWT.ARROW_RIGHT : SWT.ARROW_LEFT;
		
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
			fContainerManager.setCursorPosition(next.get());
		}
	}
	
	private void doColumnPrevious() {
		TextLocation position = getCursonPosition();
		Optional<TextLocation> previous = position.getPrevious();
		if (previous.isPresent()) {
			fContainerManager.setCursorPosition(previous.get());
		}
	}
	
	
	private void doDeletePrevious() {
		TextLocation start = getCursonPosition();
		Optional<TextLocation> previous = start.getPrevious();
		if (previous.isPresent()) {
			replace(previous.get(), start, "");
			fContainerManager.setCursorPosition(previous.get());
		}
	}
	
	private void doDeleteNext() {
		TextLocation start = getCursonPosition();
		Optional<TextLocation> next = start.getNext();
		if (next.isPresent()) {
			replace(start, next.get(), "");
		}
	}
	
	private TextLocation getCursonPosition() {
		return fContainerManager.getCursonPosition();
	}


	private void replace(TextLocation start, TextLocation end, String text) {
//		IContentTextPart textPart = start.getTextPart();
//		textPart.replace(start.getPosition(), end.getPosition(), text);
	}
	
}
