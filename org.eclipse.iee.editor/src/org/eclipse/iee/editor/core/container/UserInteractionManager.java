package org.eclipse.iee.editor.core.container;

import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.jface.text.ITextViewerExtension5;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CaretEvent;
import org.eclipse.swt.custom.CaretListener;
import org.eclipse.swt.custom.ST;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Point;

public class UserInteractionManager {

	private final ISourceViewer fSourceViewer;
	private final ContainerManager fContainerManager;

	private Container fSelectedContainer;

	private Container fActiveContainer;

	public UserInteractionManager(ContainerManager containerManager) {
		fContainerManager = containerManager;
		fSourceViewer = containerManager.getSourceViewer();

		fSelectedContainer = null;

		initListeners();
	}

	public void moveCaretTo(int offset) {
		selectContainer(null);
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

	public void selectContainer(Container container) {
		if (container != null && container.equals(fSelectedContainer)) {
			return;
		}
		
		if (fSelectedContainer != null) {
			Pad<?> selected = fContainerManager.getPadById(fSelectedContainer.getContainerID());
			selected.setSelected(false);
			fContainerManager.fireContainerLostSelection(fSelectedContainer);
		}
		fSelectedContainer = container;
		if (fSelectedContainer != null) {
			Pad<?> selected = fContainerManager.getPadById(container.getContainerID());
			selected.setSelected(true);
			fContainerManager.fireContainerSelected(fSelectedContainer);
		}
	}

	public void activateContainer(Container container) {
		if (container != null && container.equals(fActiveContainer)) {
			return;
		}
		if (fActiveContainer != null) {
			Pad<?> pad = fContainerManager.getPadById(fActiveContainer.getContainerID());
			pad.deactivate();
			fContainerManager.fireContainerDeactivated(fActiveContainer);
		}
		fActiveContainer = container;
		if (fActiveContainer != null) {
			Pad<?> pad = fContainerManager.getPadById(fActiveContainer.getContainerID());
			pad.activate();
			fContainerManager.fireContainerActivated(fActiveContainer);
		}
		selectContainer(container);
	}

	public void deactivateContainer(Container container) {
		activateContainer(null);
		fSourceViewer.getTextWidget().forceFocus();
	}

	protected void initListeners() {
		/* 1) Disallow modification within Container's text region */
		fSourceViewer.getTextWidget().addVerifyListener(new VerifyListener() {
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

		fSourceViewer.getTextWidget().addVerifyKeyListener(new VerifyKeyListener() {
			@Override
			public void verifyKey(VerifyEvent event) {
				int action = fSourceViewer.getTextWidget().getKeyBinding(event.keyCode
						| event.stateMask);
				if (action == SWT.NULL) {
					if (event.character == SWT.DEL) {
						action = ST.DELETE_NEXT;
					}
				}
				if (action != SWT.NULL) {
					int caretOffset = getExt5().widgetOffset2ModelOffset(fSourceViewer.getTextWidget().getCaretOffset());
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

		fSourceViewer.getTextWidget().addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				/*
				 * CTRL + ALT causes pad activation
				 */
				if ((e.stateMask & SWT.CTRL) != 0 && e.keyCode == SWT.ALT) {
					int caretOffset = getExt5().widgetOffset2ModelOffset(fSourceViewer.getTextWidget().getCaretOffset());
					Container container = fContainerManager
							.getContainerHavingOffset(caretOffset);
					if (container != null
							&& container.getPosition().getOffset() == caretOffset) {
						fContainerManager.fireContainerActivated(container);
					}
				}

				/*
				 * PageUP or PageDown
				 */
				/*
				 * if (e.keyCode == SWT.PAGE_UP || e.keyCode == SWT.PAGE_DOWN) {
				 * fContainerManager
				 * .getStyledTextManager().updatePresentations(); }
				 */
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});

		/*
		 * If caret is inside Container's text region, moving it to the end of
		 * line
		 */
		fSourceViewer.getTextWidget().addCaretListener(new CaretListener() {
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
							fSourceViewer.getTextWidget().setCaretOffset(getExt5().modelOffset2WidgetOffset(position.getOffset()
									+ position.getLength()));
							selectContainer(null);
						}
					}
				}
			}
		});

	}

	private boolean caretPositionChange(int x, boolean caretMovesForward) {
		Point selection = fSourceViewer.getSelectedRange();
		if (selection.y == 0) {
			Container container = fContainerManager
					.getContainerHavingOffset(caretMovesForward ? x : x - 1);
			if (container != null) {
				Position position = container.getPosition();
				if (caretMovesForward) {
					activateContainer(container);
					fSourceViewer.getTextWidget().setCaretOffset(getExt5().modelOffset2WidgetOffset(position.getOffset()
							+ position.getLength()));
				} else {
					activateContainer(container);
					fSourceViewer.getTextWidget().setCaretOffset(getExt5().modelOffset2WidgetOffset(position.getOffset()));
				}
				return false;
			}
		}
		return true;
	}
	
}
