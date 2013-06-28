package org.eclipse.iee.editor.core.container;

import org.eclipse.jface.text.Position;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CaretEvent;
import org.eclipse.swt.custom.CaretListener;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Point;

public class UserInteractionManager {
		
	private final StyledText fStyledText;
	private final ContainerManager fContainerManager;
	
	private Container fSelectedContainer;
	private Container fActiveContainer;
	
	public UserInteractionManager(ContainerManager containerManager) {
		fContainerManager = containerManager;
		fStyledText = containerManager.getStyledText();
		
		fSelectedContainer = null;
		
		initListeners();
	}
	
	public Container getSelectedContainer() {
		return fSelectedContainer;
	}
	
	public void moveCaretTo(int offset) {
		setSelectedContainer(null);
		fStyledText.setCaretOffset(offset);
		fStyledText.forceFocus();
	}
	
	public void updateCaretSelection() {
	}

	private void setSelectedContainer(Container container) {
		if (container != null && container.equals(fSelectedContainer)) {
			return;
		}
		if (fSelectedContainer != null) {
			fContainerManager.fireContainerLostSelection(fSelectedContainer);
		}
		fSelectedContainer = container;
		if (fSelectedContainer != null) {
			fContainerManager.fireContainerSelected(fSelectedContainer);
		}
	}
		
	public void activateContainer(Container container) {
		if (container != null && container.equals(fActiveContainer)) {
			return;
		}
		if (fActiveContainer != null) {
			fContainerManager.fireContainerDeactivated(fActiveContainer);
		}
		fActiveContainer = container;
		if (fActiveContainer != null) {
			fContainerManager.fireContainerActivated(fActiveContainer);
		}
		setSelectedContainer(container);
	}
	

	public void deactivateContainer(Container container) {
		activateContainer(null);
	}
		
	protected void initListeners() {
		/* 1) Disallow modification within Container's text region */
		fStyledText.addVerifyListener(new VerifyListener() {
			@Override
			public void verifyText(VerifyEvent e) {
				Container atStart = fContainerManager.getContainerHavingOffset(e.start);
				Container atEnd = fContainerManager.getContainerHavingOffset(e.end);

				/* Text replaced */
				if ((atStart != null && e.start != atStart.getPosition().getOffset()) ||
						(atEnd != null && e.end != atEnd.getPosition().getOffset()))
				{
					e.doit = false;
					return;
				}

				/* XXX Visibility */
				//fContainerManager.updateContainerVisibility(false);
			}
		});

		fStyledText.addVerifyKeyListener(new VerifyKeyListener() {
			@Override
			public void verifyKey(VerifyEvent event) {
				int action = fStyledText.getKeyBinding(event.keyCode | event.stateMask);
				if (action == SWT.NULL) {
					if (event.character == SWT.DEL) {
						action = ST.DELETE_NEXT;
					}
				}
				if (action != SWT.NULL) {
					int caretOffset = fStyledText.getCaretOffset();
					switch (action) {
					case ST.COLUMN_PREVIOUS:
						event.doit = caretPositionChange(caretOffset, false);
						break;
					case ST.COLUMN_NEXT:
						event.doit = caretPositionChange(caretOffset, true);
						break;
					case ST.DELETE_NEXT:
						Container container = fContainerManager.getContainerHavingOffset(caretOffset);
						if (container != null) {
							container.destroy();
						}
					case ST.DELETE_PREVIOUS:
						Container prevContainer = fContainerManager.getContainerHavingOffset(caretOffset - 1);
						if (prevContainer != null) {
							prevContainer.destroy();
						}
					}
				}
			}
		});
		
		fStyledText.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				/*
				 * CTRL + ALT causes pad activation
				 */
				if ((e.stateMask & SWT.CTRL) != 0 && e.keyCode == SWT.ALT) {
					int caretOffset = fStyledText.getCaretOffset();
					Container container = fContainerManager.getContainerHavingOffset(caretOffset);					
					if (container != null && container.getPosition().getOffset() == caretOffset) {
						fContainerManager.fireContainerActivated(container);
					}
				}
				
				/*
				 * PageUP or PageDown
				 */
				/*if (e.keyCode == SWT.PAGE_UP || e.keyCode == SWT.PAGE_DOWN) {
					fContainerManager.getStyledTextManager().updatePresentations();
				}*/
			}
			
			@Override public void keyReleased(KeyEvent e) {}
		});
		
		/*
		 * If caret is inside Container's text region, moving it to the end of line
		 */
		fStyledText.addCaretListener(new CaretListener() {
			@Override
			public void caretMoved(CaretEvent e) {
				Point selection = fStyledText.getSelection();
				if (selection.y - selection.x == 0) {
					Container container = fContainerManager.getContainerHavingOffset(e.caretOffset);
					if (container != null) {
						Position position = container.getPosition();
						if (e.caretOffset != position.getOffset()) {
								/* Move caret to the Pad's border */
								fStyledText.setCaretOffset(position.getOffset() + position.getLength());
								setSelectedContainer(null);
						}
					}
				}
			}
		}); 
		
	}
	
	private boolean caretPositionChange(int x, boolean caretMovesForward) {
		Point selection = fStyledText.getSelection();
		if (selection.y - selection.x == 0) {
			Container container = fContainerManager.getContainerHavingOffset(caretMovesForward ? x : x - 1);
			if (container != null) {
				Position position = container.getPosition();
				if (caretMovesForward) {
					activateContainer(container);	
					fStyledText.setCaretOffset(position.getOffset() + position.getLength());
				} else {
					activateContainer(container);
					fStyledText.setCaretOffset(position.getOffset());
				}
				return false;
			}
		}
		return true;
	}

}
