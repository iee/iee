package org.eclipse.iee.editor.core.pad;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;

public class MouseEventManager implements MouseListener, MouseMoveListener,	MouseTrackListener {
	
	private Composite fComposite;
	
	private Cursor fResizeCursorNS = new Cursor(null, SWT.CURSOR_SIZENS);
	private Cursor fResizeCursorEW = new Cursor(null, SWT.CURSOR_SIZEWE);
	private Cursor fArrowCursor = new Cursor(null, SWT.CURSOR_ARROW);
	private Cursor fResizeCursorNWSE = new Cursor(null, SWT.CURSOR_SIZENWSE);
	
	private boolean fIsCursorCanBeChanged = true;

	private boolean fCanResize = false;
	private boolean fIsResizing = false;
	private boolean fChangeWidth = false;
	private boolean fChangeHeigth = false;

	public MouseEventManager(Composite composite) {
		fComposite = composite;
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
	}

	@Override
	public void mouseHover(MouseEvent e) {
	}

	@Override
	public void mouseMove(MouseEvent e) {
		
		int delta = IPadConfiguration.BORDER_WIDTH + 3;
		
		Point border = fComposite.getSize();

		if (fIsCursorCanBeChanged) {
			if (e.x < border.x - delta) {
				if (e.y > border.y - delta) { /* bottom side */
					fComposite.setCursor(fResizeCursorNS);
					fCanResize = true;
					fChangeWidth = false;
					fChangeHeigth = true;
				}
			}
			else {				
				if (e.y > border.y - delta) { /* bottom-right corner */
					fComposite.setCursor(fResizeCursorNWSE);
					fCanResize = true;
					fChangeWidth = true;
					fChangeHeigth = true;
				}
				else { /* right side */
					fComposite.setCursor(fResizeCursorEW);
					fCanResize = true;
					fChangeWidth = true;
					fChangeHeigth = false;
				}
			}
		}
	}

	@Override
	public void mouseDoubleClick(MouseEvent e) {
	}

	@Override
	public void mouseDown(MouseEvent e) {
		/* First button is pressed for resizing */
		if (e.button == 1 && fCanResize) {
			fIsResizing = true;
			fIsCursorCanBeChanged = false;
		}
	}

	@Override
	public void mouseUp(MouseEvent e) {
		
		if (e.button != 1) {
			return;
		}
		
		/* If first button is released: */
			
		if (fIsResizing) {
			Point beforeResize = fComposite.getSize();
			Rectangle beforeResizeBounds = fComposite.getBounds();

			if (e.x > 0 && e.y > 0) {
				Point afterResize = null;
				Rectangle afterResizeBounds = null;
				int newWidth = e.x;
				int newHeigth = e.y;
				int newLocationX = beforeResizeBounds.x;
				int newLocationY = beforeResizeBounds.y;

				if (fChangeWidth && fChangeHeigth) {
					// To prevent appearance of uninformative pad
					// XXX Pad's min size
					if (newWidth < 70)
						newWidth = 70;
					if (newHeigth < 70)
						newHeigth = 70;
				}
				if (fChangeWidth && !fChangeHeigth) {
					newHeigth = beforeResize.y;
					if (newWidth < 70)
						newWidth = 70;
				}
				if (!fChangeWidth && fChangeHeigth) {
					newWidth = beforeResize.x;
					if (newHeigth < 70)
						newHeigth = 70;
				}
				// Now the case is unreached
				if (!fChangeWidth && !fChangeHeigth) {
					newWidth = beforeResize.x;
					newHeigth = beforeResize.y;
				}

				afterResize = new Point(newWidth, newHeigth);
				afterResizeBounds = new Rectangle(newLocationX, newLocationY,
						newWidth, newHeigth);

				fComposite.setSize(afterResize);
				fComposite.setBounds(afterResizeBounds);

				fComposite.redraw();
			}

			fIsCursorCanBeChanged = true;
			fIsResizing = false;
			fCanResize = false;
		}
	}

}
