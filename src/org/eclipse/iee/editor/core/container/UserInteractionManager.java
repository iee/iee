package org.eclipse.iee.editor.core.container;

import org.eclipse.jface.text.Position;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CaretEvent;
import org.eclipse.swt.custom.CaretListener;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;

public class UserInteractionManager {
	private final StyledText fStyledText;
	private final ContainerManager fContainerManager;
	
	private Boolean fCaretMovesForward;
	private Container fSelectedContainer;
	
	public UserInteractionManager(ContainerManager containerManager) {
		fContainerManager = containerManager;
		fStyledText = containerManager.getStyledText();
		
		fCaretMovesForward = false;
		fSelectedContainer = null;
		
		initListeners();
	}
	
	public void moveCaretTo(int offset) {
		fStyledText.setCaretOffset(offset);
		fStyledText.forceFocus();
	}
	
	public void updateCaretSelection() {
		int caretOffset = fStyledText.getCaretOffset();
		Container container = fContainerManager.getContainerHavingOffset(caretOffset);
		
		if (container != null && container.getPosition().getOffset() == caretOffset) {
			/* Caret is at the left side of the pad */
			if (container != fSelectedContainer) {
				/* Select this container and unselect previous */
				if (fSelectedContainer != null) {
					fContainerManager.fireContainerLostSelection(fSelectedContainer);
				}
				fSelectedContainer = container;
				fContainerManager.fireContainerSelected(container);
			}
		}
		else if (fSelectedContainer != null) {
			/* Only unselect previous container */
			fContainerManager.fireContainerLostSelection(fSelectedContainer);
			fSelectedContainer = null;
		}
	}
		
		
	protected void initListeners() {
		/* 1) Disallow modification within Container's text region */
		fStyledText.addVerifyListener(new VerifyListener() {
			@Override
			public void verifyText(VerifyEvent e) {
				Container atStart = fContainerManager.getContainerHavingOffset(e.start);
				Container atEnd = fContainerManager.getContainerHavingOffset(e.end);
				
				System.out.println(e.start + " " + e.end);
				
				/* Text replaced */
				if ((atStart != null && e.start != atStart.getPosition().getOffset()) ||
						(atEnd != null && e.end != atEnd.getPosition().getOffset()))
				{
					e.doit = false;
					return;
				}

				fContainerManager.updateContainerVisibility(false);
			}
		});

		fStyledText.addVerifyKeyListener(new VerifyKeyListener() {
			@Override
			public void verifyKey(VerifyEvent event) {
				switch (event.keyCode) {
				case SWT.ARROW_LEFT:
				case SWT.ARROW_UP:
					fCaretMovesForward = false;
					break;
				case SWT.ARROW_RIGHT:
				case SWT.ARROW_DOWN:
					fCaretMovesForward = true;
					break;
				}
			}
		});
		
		/*
		 * CTRL + ALT causes pad activation
		 */
		fStyledText.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if ((e.stateMask & SWT.CTRL) != 0 && e.keyCode == SWT.ALT) {
					int caretOffset = fStyledText.getCaretOffset();
					Container container = fContainerManager.getContainerHavingOffset(caretOffset);					
					if (container != null && container.getPosition().getOffset() == caretOffset) {
						fContainerManager.fireContainerActivated(container);
					}
				}
			}
			
			@Override public void keyReleased(KeyEvent e) {}
		});
		
		/*
		 * If caret is inside Container's text region, moving it to the
		 * beginning of line
		 */
		fStyledText.addCaretListener(new CaretListener() {
			@Override
			public void caretMoved(CaretEvent e) {
				Container container = fContainerManager.getContainerHavingOffset(e.caretOffset);
				if (container != null) {
					Position position = container.getPosition();
					
					if (e.caretOffset != position.getOffset() && e.caretOffset != position.getOffset() + position.getLength()) {
						/* Move caret to the Pad's border */
						if (fCaretMovesForward) {
							fStyledText.setCaretOffset(position.getOffset() + position.getLength());
						} else {
							fStyledText.setCaretOffset(position.getOffset());
						}
					}
				}
				
				updateCaretSelection();
			}
		});
	}
}
