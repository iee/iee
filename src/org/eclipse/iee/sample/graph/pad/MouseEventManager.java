package org.eclipse.iee.sample.graph.pad;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;

public class MouseEventManager implements MouseListener, MouseMoveListener,
		MouseTrackListener {

	private boolean fIsChild;
	private Cursor fResizeCursorNS;
	private Cursor fResizeCursorEW;
	private Cursor fArrowCursor;
	private Cursor fResizeCursorNWSE;
	private Cursor fResizeCursorNESW;
	private boolean fIsCursorCanBeChanged;
	private Composite fComposite;
	private boolean fCanResize;
	private boolean fIsResizing;
	private boolean fChangeWidth;
	private boolean fChangeHeigth;
	private boolean fChangeLocationX;
	private boolean fChangeLocationY;

	public MouseEventManager(final Composite composite, boolean isChild) {
		fComposite = composite;
		fIsChild = isChild;
		fResizeCursorNS = new Cursor(null, SWT.CURSOR_SIZENS);
		fResizeCursorEW = new Cursor(null, SWT.CURSOR_SIZEWE);
		fArrowCursor = new Cursor(null, SWT.CURSOR_ARROW);
		fResizeCursorNWSE = new Cursor(null, SWT.CURSOR_SIZENWSE);
		fResizeCursorNESW = new Cursor(null, SWT.CURSOR_SIZENESW);
		fIsCursorCanBeChanged = true;
		fCanResize = false;
		fIsResizing = false;
		fChangeWidth = false;
		fChangeHeigth = false;
		fChangeLocationX = false;
		fChangeLocationY = false;
	}

	@Override
	public void mouseEnter(MouseEvent e) {
		fComposite.forceFocus();
	}

	@Override
	public void mouseExit(MouseEvent e) {
		fComposite.setCursor(fArrowCursor);
		fCanResize = false;
		fChangeWidth = false;
		fChangeHeigth = false;
		fChangeLocationX = false;
		fChangeLocationY = false;
	}

	@Override
	public void mouseHover(MouseEvent e) {
	}

	@Override
	public void mouseMove(MouseEvent e) {
		int delta = 5;
		Point border = fComposite.getSize();
		for (int i = 0; i <= delta; i++) {
			if (e.y == i && e.x == i) {
				if (fIsCursorCanBeChanged) {
					fComposite.setCursor(fResizeCursorNWSE);
					fCanResize = true;
					fChangeWidth = true;
					fChangeHeigth = true;
					fChangeLocationX = true;
					fChangeLocationY = true;
				}
			}

			if (e.y == border.y - i && e.x == border.x - i) {
				if (fIsCursorCanBeChanged) {
					fComposite.setCursor(fResizeCursorNWSE);
					fCanResize = true;
					fChangeWidth = true;
					fChangeHeigth = true;
					fChangeLocationX = false;
					fChangeLocationY = false;
				}
			}

			if (e.x == i && e.y == border.y - i) {
				if (fIsCursorCanBeChanged) {
					fComposite.setCursor(fResizeCursorNESW);
					fCanResize = true;
					fChangeWidth = true;
					fChangeHeigth = true;
					fChangeLocationX = true;
					fChangeLocationY = false;
				}
			}

			if (e.y == i && e.x == border.x - i) {
				if (fIsCursorCanBeChanged) {
					fComposite.setCursor(fResizeCursorNESW);
					fCanResize = true;
					fChangeWidth = true;
					fChangeHeigth = true;
					fChangeLocationX = false;
					fChangeLocationY = true;
				}
			}

			if (e.y == i && e.x > i && e.x < border.x - i) {
				if (fIsCursorCanBeChanged) {
					fComposite.setCursor(fResizeCursorNS);
					fCanResize = true;
					fChangeWidth = false;
					fChangeHeigth = true;
					fChangeLocationX = false;
					fChangeLocationY = true;
				}
			}

			if (e.y == border.y - i && e.x > i && e.x < border.x - i) {
				if (fIsCursorCanBeChanged) {
					fComposite.setCursor(fResizeCursorNS);
					fCanResize = true;
					fChangeWidth = false;
					fChangeHeigth = true;
					fChangeLocationX = false;
					fChangeLocationY = false;
				}
			}

			if (e.x == i && e.y > i && e.y < border.y - i) {
				if (fIsCursorCanBeChanged) {
					fComposite.setCursor(fResizeCursorEW);
					fCanResize = true;
					fChangeWidth = true;
					fChangeHeigth = false;
					fChangeLocationX = true;
					fChangeLocationY = false;
				}
			}

			if (e.x == border.x - i && e.y > i && e.y < border.y - i) {
				if (fIsCursorCanBeChanged) {
					fComposite.setCursor(fResizeCursorEW);
					fCanResize = true;
					fChangeWidth = true;
					fChangeHeigth = false;
					fChangeLocationX = false;
					fChangeLocationY = false;
				}
			}
		}

	}

	@Override
	public void mouseDoubleClick(MouseEvent e) {
	}

	@Override
	public void mouseDown(MouseEvent e) {
		if (e.button == 1)
			if (fCanResize) {
				fIsResizing = true;
				fIsCursorCanBeChanged = false;
			}
	}

	@Override
	public void mouseUp(MouseEvent e) {
		if (e.button == 1)
			if (fIsResizing) {
				Point beforeResize = fComposite.getSize();
				Rectangle beforeResizeBounds = fComposite.getBounds();
				/*
				 * TODO: Now pad can be resized only to right or to bottom.
				 * Extend it.
				 */
				if (e.x > 0 && e.y > 0) {
					Point afterResize = null;
					Rectangle afterResizeBounds = null;
					int newWidth = e.x;
					int newHeigth = e.y;
					int newLocationX = beforeResizeBounds.x;
					int newLocationY = beforeResizeBounds.y;
					if (fChangeLocationX) {
						newLocationX += e.x;
						newWidth = beforeResize.x - e.x;
					}
					if (fChangeLocationY) {
						newLocationY += e.y;
						newHeigth = beforeResize.y - e.y;
					}

					if (fChangeWidth && fChangeHeigth) {
						// To prevent appearance of uninformative pad
						if (newWidth < 420)
							newWidth = 420;
						if (newHeigth < 200)
							newHeigth = 200;
					}
					if (fChangeWidth && !fChangeHeigth) {
						newHeigth = beforeResize.y;
						if (newWidth < 420)
							newWidth = 420;
					}
					if (!fChangeWidth && fChangeHeigth) {
						newWidth = beforeResize.x;
						if (newHeigth < 200)
							newHeigth = 200;
					}
					// Now the case is unreached
					if (!fChangeWidth && !fChangeHeigth) {
						newWidth = beforeResize.x;
						newHeigth = beforeResize.y;
					}
					afterResize = new Point(newWidth, newHeigth);
					afterResizeBounds = new Rectangle(newLocationX,
							newLocationY, newWidth, newHeigth);
					fComposite.setSize(afterResize);
					fComposite.setBounds(afterResizeBounds);
					fComposite.redraw();
					// if (fIsChild)
					// {
					// fComposite.getParent().pack();
					// fComposite.getParent().redraw();
					// }
				}
				fIsCursorCanBeChanged = true;
				fIsResizing = false;
				fCanResize = false;
			}
	}

}
