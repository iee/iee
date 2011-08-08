package org.eclipse.iee.sample.math.pad;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

public class MouseEventManager implements MouseListener, MouseMoveListener,
		MouseTrackListener {

	private Cursor fResizeCursorNS;
	private Cursor fResizeCursorEW;
	private Cursor fArrowCursor;
	private Cursor fResizeCursorNWSE;
	private Cursor fResizeCursorNESW;
	private Composite fComposite;
	private boolean fCanResize;
	private boolean fIsResizing;

	public MouseEventManager(final Composite composite) {
		fComposite = composite;
		fResizeCursorNS = new Cursor(null, SWT.CURSOR_SIZENS);
		fResizeCursorEW = new Cursor(null, SWT.CURSOR_SIZEWE);
		fArrowCursor = new Cursor(null, SWT.CURSOR_ARROW);
		fResizeCursorNWSE = new Cursor(null, SWT.CURSOR_SIZENWSE);
		fResizeCursorNESW = new Cursor(null, SWT.CURSOR_SIZENESW);
		fCanResize = false;
		fIsResizing = false;
	}

	@Override
	public void mouseEnter(MouseEvent e) {
		fComposite.forceFocus();
	}

	@Override
	public void mouseExit(MouseEvent e) {
		fComposite.setCursor(fArrowCursor);
		fCanResize = false;
	}

	@Override
	public void mouseHover(MouseEvent e) {
	}

	@Override
	public void mouseMove(MouseEvent e) {
		int delta = 2;
		Point border = fComposite.getSize();
		for (int i = 0; i <= delta; i++) {
			if (e.y == i && e.x == i) {
				fComposite.setCursor(fResizeCursorNWSE);
				fCanResize = true;
			}

			if (e.y == border.y - i && e.x == border.x - i) {
				fComposite.setCursor(fResizeCursorNWSE);
				fCanResize = true;
			}

			if (e.x == i && e.y == border.y - i || e.y == i
					&& e.x == border.x - i) {
				fComposite.setCursor(fResizeCursorNESW);
				fCanResize = true;
			}
			if (e.y == i && e.x > i && e.x < border.x - i
					|| e.y == border.y - i && e.x > i && e.x < border.x - i) {
				fComposite.setCursor(fResizeCursorNS);
				fCanResize = true;
			}
			if (e.x == i && e.y > i && e.y < border.y - i
					|| e.x == border.x - i && e.y > i && e.y < border.y - i) {
				fComposite.setCursor(fResizeCursorEW);
				fCanResize = true;
			}
		}

	}

	@Override
	public void mouseDoubleClick(MouseEvent e) {
	}

	@Override
	public void mouseDown(MouseEvent e) {
		if (fCanResize) {
			fIsResizing = true;
		}
	}

	@Override
	public void mouseUp(MouseEvent e) {
		if (fIsResizing) {
			fIsResizing = false;
			fCanResize = false;
		}
	}

}
