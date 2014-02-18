package org.eclipse.iee.pad.image.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.pad.image.ImagePart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.Files;

public class ImagePad extends Pad<ImagePart> {

	private transient static final Logger logger = LoggerFactory
			.getLogger(ImagePad.class);

	public transient static final int STATE_MENU = 0;
	public transient static final int STATE_IMAGE = 1;
	public transient static final int STATE_ERROR = 2;

	private int fCurrentState = STATE_IMAGE;

	protected transient Image fOriginalImage = null;
	protected transient Image fResizedImage = null;

	private Label label;

	private Composite fParent;

	private Composite fCurrent;

	public ImagePad(ImagePart imagePart) {
		super(imagePart);
	}

	@Override
	public void createPartControl(final Composite parent) {
		fParent = parent;
		initView(parent);
	}

	protected void initView(Composite parent) {
		if (fCurrent != null) {
			fCurrent.dispose();
		}

		switch (fCurrentState) {

		case STATE_MENU:
			initWelcomeView();
			break;

		case STATE_IMAGE:
			initImageView();
			break;

		case STATE_ERROR:
			initErrorView();
			break;

		default:
			throw new RuntimeException("ImagePad: invalid state");
		}
	}

	protected void initWelcomeView() {
		/* Clear data */

		/* Initialize controls */
		FillLayout layout = new FillLayout(SWT.VERTICAL);
		fParent.setLayout(layout);

		final Composite welcome = new Composite(fParent, SWT.NONE);
		// It is hint operation now
		welcome.setBackground(new Color(null, 255, 255, 255));

		final Label label = new Label(welcome, SWT.WRAP | SWT.CENTER);
		label.setText("This sample control is for inserting image into Eclipse editor");
		label.setSize(200, 100);

		final Button button = new Button(welcome, SWT.PUSH);
		button.setText("Choose image");

		welcome.pack();

		/* State logic */

		button.addMouseListener(new MouseListener() {
			@Override
			public void mouseUp(MouseEvent e) {
				FileDialog fileDialog = new FileDialog(welcome.getShell(),
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

				setImageFile(imagePath);
			}

			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
			}

			@Override
			public void mouseDown(MouseEvent arg0) {
			}
		});
		fCurrent = welcome;
	}

	protected void initImageView() {
		logger.debug("initImageView");

		String imageFile = getContainer().getContainerManager().getStoragePath()
				+ "image/" + getDocumentPart().getImagePath();
		try(InputStream is = new FileInputStream(imageFile)) {
			fOriginalImage = new Image(fParent.getDisplay(), imageFile);
			if (getDocumentPart().getImageWidth() > 0 && getDocumentPart().getImageHeigth() > 0) {
				fResizedImage = new Image(fParent.getDisplay(), fOriginalImage
						.getImageData().scaledTo(getDocumentPart().getImageWidth(), getDocumentPart().getImageHeigth()));
			} else {
				fResizedImage = fOriginalImage;
			}

		} catch (FileNotFoundException e) {
			logger.error("Image file {} is absent", imageFile);
			fCurrentState = STATE_ERROR;
			initView(fParent);
		} catch (Exception e) {
			logger.error("Failed to initialize image", e);
			fCurrentState = STATE_ERROR;
			initView(fParent);
		}

		/* Initialize controls */
		FillLayout layout = new FillLayout();
		fParent.setLayout(layout);
		label = new Label(fParent, SWT.NONE);
		label.setImage(fResizedImage);
		fParent.pack();

		fParent.addControlListener(new ControlListener() {
			@Override
			public void controlResized(ControlEvent e) {
				Point size = fParent.getSize();
				
				getDocumentPart().setImageWidth(size.x);
				getDocumentPart().setImageHeigth(size.y);
				fResizedImage = new Image(fParent.getDisplay(), fOriginalImage
						.getImageData().scaledTo(getDocumentPart().getImageWidth(), getDocumentPart().getImageHeigth()));

				label.setImage(fResizedImage);
				getContainer().updateDocument();
				fParent.redraw();
			}

			@Override
			public void controlMoved(ControlEvent e) {
			}
		});

		label.addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent e) {
			}

			@Override
			public void mouseDown(MouseEvent e) {
				moveCaretToCurrentPad();
				getContainer().getContainerManager()
						.getUserInteractionManager()
						.activateContainer(getContainer());
			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {
			}
		});
	}

	protected void initErrorView() {

		FillLayout layout = new FillLayout(SWT.VERTICAL);
		fParent.setLayout(layout);
		// It is hint operation now
		fParent.setBackground(new Color(null, 255, 255, 255));

		final Label label = new Label(fParent, SWT.WRAP | SWT.CENTER);
		label.setText("Error occured");

		final Button button = new Button(fParent, SWT.PUSH);
		button.setText("Reload");

		fParent.pack();

		/* State logic */

		button.addMouseListener(new MouseListener() {

			@Override
			public void mouseDown(MouseEvent e) {

				/* Dispose controls */

				button.removeMouseListener(this);
				button.dispose();
				label.dispose();

				/* Switch to welcome state */

				fCurrentState = STATE_MENU;
				initView(fParent);
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
	public Pad<ImagePart> copy() {
		return new ImagePad(getDocumentPart().copy());
	}

	@Override
	public void save() {
	}

	@Override
	public void unsave() {
	}

	@Override
	public void onContainerAttached() {
		// TODO Auto-generated method stub
	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub

	}

	@Override
	public String getType() {
		return "Image";
	}

	public void setImageFile(String imagePath) {
		File storageDirectory = new File(getContainer().getContainerManager()
				.getStoragePath() + "image/");

		if (!storageDirectory.exists()) {
			if (!storageDirectory.mkdirs()) {
				return;
			}
		}

		File imageSrc = new File(imagePath);
		File imageDst = new File(getContainer().getContainerManager()
				.getStoragePath() + "image/" + imageSrc.getName());
		if (!imageDst.exists()) {
			try {
				Files.copy(imageSrc, imageDst);
			} catch (IOException e1) {
			}
		}

		getDocumentPart().setImagePath(imageSrc.getName());
		switchToImage();
	}

	private void switchToImage() {
		/* Switch to image presentation state */
		fCurrentState = STATE_IMAGE;
		initView(fParent);
	}

	@Override
	public String getTex() {
		return "\\includegraphics{"
				+ getContainer().getContainerManager().getStoragePath()
				+ "image/" + getDocumentPart().getImagePath() + "}";
	}

}
