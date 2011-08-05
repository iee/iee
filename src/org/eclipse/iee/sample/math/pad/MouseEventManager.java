package org.eclipse.iee.sample.math.pad;

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

	private Cursor fResizeCursorNS;
	private Cursor fResizeCursorEW;
	private Cursor fArrowCursor;
	private Cursor fResizeCursorNWSE;
	private Cursor fResizeCursorNESW;
	private Composite fComposite;
	private boolean fCanResize;

	public MouseEventManager(final Composite composite) {
		fComposite = composite;
		fResizeCursorNS = new Cursor(null, SWT.CURSOR_SIZENS);
		fResizeCursorEW = new Cursor(null, SWT.CURSOR_SIZEWE);
		fArrowCursor = new Cursor(null, SWT.CURSOR_ARROW);
		fResizeCursorNWSE = new Cursor(null, SWT.CURSOR_SIZENWSE);
		fResizeCursorNESW = new Cursor(null, SWT.CURSOR_SIZENESW);
		fCanResize = false;
	}

	@Override
	public void mouseEnter(MouseEvent e) {
		fComposite.forceFocus();
	}

	@Override
	public void mouseExit(MouseEvent e) {
	}

	@Override
	public void mouseHover(MouseEvent e) {
	}

	@Override
	public void mouseMove(MouseEvent e) {
		fCanResize = false;
		Point border = fComposite.getSize();
		System.out.println("width="+ border.x);
		System.out.println("heigth="+ border.y);
		if (e.y == 0 && e.x == 0 || e.y == border.y && e.x == border.x)
		{
			fComposite.setCursor(fResizeCursorNWSE);
			fCanResize = true;
		}
		if (e.x == 0 && e.y == border.y || e.y == 0 && e.x == border.x)
		{
			fComposite.setCursor(fResizeCursorNESW);
			fCanResize = true;
		}
		if (e.y == 0 && e.x > 0 && e.x < border.x || e.y == border.y && e.x > 0 && e.x < border.x) {
			fComposite.setCursor(fResizeCursorNS);
			fCanResize = true;
		} 
		if (e.x == 0 && e.y > 0 && e.y < border.y || e.x == border.x && e.y > 0 && e.y < border.y) {
			fComposite.setCursor(fResizeCursorEW);
			fCanResize = true;
		}
		if (!fCanResize)
		{
			fComposite.setCursor(fArrowCursor);
		}
	}

	@Override
	public void mouseDoubleClick(MouseEvent e) {
	}

	@Override
	public void mouseDown(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseUp(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
