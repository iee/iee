package org.eclipse.iee.sample.image.pad;

import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;

public class ImagePad extends Pad {

	private final int STATE_MENU = 0;
	private final int STATE_IMAGE = 1;
	private final int STATE_ERROR = 2;

	private int fCurrentState;
	protected String fImagePath;

	public ImagePad() {
		fCurrentState = STATE_MENU;
		fImagePath = null;
	}

	protected ImagePad(int currentState, String imagePath) {
		fCurrentState = currentState;
		fImagePath = imagePath;
	}

	@Override
	public void createPartControl(final Composite parent) {
		initView(parent);
	}

	protected void initView(Composite parent) {
		switch (fCurrentState) {

		case STATE_MENU:
			initWelcomeView(parent);
			break;

		case STATE_IMAGE:
			initImageView(parent);
			break;

		case STATE_ERROR:
			initErrorView(parent);
			break;

		default:
			throw new RuntimeException("ImagePad: invalid state");
		}
	}

	protected void initWelcomeView(final Composite parent) {
		System.out.println("initWelcomeView");

		/* Clear data */

		fImagePath = null;

		/* Initialize controls */
		FillLayout layout = new FillLayout(SWT.VERTICAL);
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		parent.setLayout(layout);

		final Label label = new Label(parent, SWT.WRAP | SWT.CENTER);
		label.setText("This sample control is for inserting image into Eclipse editor");
		label.setSize(200, 100);

		final Button button = new Button(parent, SWT.PUSH);
		button.setText("Choose image");

		parent.pack();

		/* State logic */

		button.addMouseListener(new MouseListener() {
			@Override
			public void mouseUp(MouseEvent e) {
				FileDialog fileDialog = new FileDialog(parent.getShell(),
						SWT.OPEN);
				fileDialog.setFilterNames(new String[] { "Jpeg (*.jpg)",
						"PNG (*.png)" });
				fileDialog
						.setFilterExtensions(new String[] { "*.jpg", "*.png" });

				String imagePath = fileDialog.open();
				if (imagePath == null) {
					return;
				}

				/* Dispose current controls */

				button.removeMouseListener(this);
				button.dispose();
				label.dispose();

				/* Switch to image presentation state */

				fImagePath = imagePath;
				fCurrentState = STATE_IMAGE;
				initView(parent);
			}

			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
			}

			@Override
			public void mouseDown(MouseEvent arg0) {
			}
		});

	}

	protected void initImageView(Composite parent) {
		System.out.println("initImageView");

		Image image = null;
		try {
			image = new Image(parent.getDisplay(), fImagePath);
		} catch (Exception e) {

			e.printStackTrace();

			/* Switch to error state */

			fCurrentState = STATE_ERROR;
			initView(parent);
		}

		/* Initialize controls */
		// final Image insertedImage = new Image(parent.getDisplay(),
		// image.getImageData().scaledTo(300,300));

		// final Image insertedImage = image;
		FillLayout layout = new FillLayout();
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		parent.setLayout(layout);
		// Canvas photo = new Canvas(parent, SWT.RESIZE);
		// photo.addPaintListener(new PaintListener() {
		//
		// @Override
		// public void paintControl(PaintEvent e) {
		// e.gc.drawImage(insertedImage, 0, 0);
		// }
		// });
		Label label = new Label(parent, SWT.NONE);
		label.setImage(image);

		parent.pack();

		MouseEventManager mouseManager = new MouseEventManager(parent);
		parent.addMouseTrackListener(mouseManager);
		parent.addMouseMoveListener(mouseManager);
		parent.addMouseListener(mouseManager);

	}

	protected void initErrorView(final Composite parent) {
		System.out.println("initErrorView");

		FillLayout layout = new FillLayout(SWT.VERTICAL);
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		parent.setLayout(layout);

		final Label label = new Label(parent, SWT.NONE);
		label.setText("Error occured");

		final Button button = new Button(parent, SWT.PUSH);
		button.setText("Reload");

		parent.pack();

		/* State logic */

		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseDown(MouseEvent e) {

				/* Dispose controls */

				button.removeMouseListener(this);
				button.dispose();
				label.dispose();

				/* Switch to welcome state */

				fImagePath = null;
				fCurrentState = STATE_MENU;
				initView(parent);
			}

			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
			}
		});

	}

	@Override
	public Pad copy() {
		return new ImagePad(fCurrentState, fImagePath);
	}

	@Override
	public String getType() {
		return "Image Pad";
	}
}
