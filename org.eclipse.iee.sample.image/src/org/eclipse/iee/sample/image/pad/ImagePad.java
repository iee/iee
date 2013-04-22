package org.eclipse.iee.sample.image.pad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Widget;

public class ImagePad extends Pad implements Serializable {

	private transient static final Logger logger = Logger.getLogger(ImagePad.class);
	
	public transient static final int STATE_MENU = 0;
	public transient static final int STATE_IMAGE = 1;
	public transient static final int STATE_ERROR = 2;

	private static final long serialVersionUID = -5570698937452800023L;

	private int fCurrentState;
	protected String fImagePath;

	protected transient Image fOriginalImage = null;
	protected transient Image fResizedImage = null;
	private int fImageWidth = -1;
	private int fImageHeigth = -1;
	
	private Label label;

	private Composite fParent;
	
	private Composite fCurrent;
	
	public String getImagePath() {
		return fImagePath;
	}

	public void setImagePath(String imagePath) {
		this.fImagePath = imagePath;
	}

	public ImagePad() {
		fCurrentState = STATE_MENU;
		fImagePath = null;
	}

	public ImagePad(int currentState, String imagePath) {
		fCurrentState = currentState;
		fImagePath = imagePath;
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

		fImagePath = null;

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
				FileDialog fileDialog = new FileDialog(welcome.getShell(), SWT.OPEN);
				fileDialog.setFilterNames(new String[] { "Jpeg (*.jpg)", "PNG (*.png)" });
				fileDialog.setFilterExtensions(new String[] { "*.jpg", "*.png" });

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
		
		try {
			fOriginalImage = new Image(fParent.getDisplay(), getContainer().getContainerManager().getStoragePath() + "image/" + fImagePath);
			if (fImageWidth > 0 && fImageHeigth > 0)
			{
				fResizedImage = new Image(fParent.getDisplay(),
					fOriginalImage.getImageData().scaledTo(fImageWidth, fImageHeigth));
			}
			else
			{
				fResizedImage = fOriginalImage;
			}
			
		} catch (Exception e) {

			logger.error(e.getMessage());
			e.printStackTrace();

			/* Switch to error state */

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
				fImageWidth = size.x;
				fImageHeigth = size.y;
				getContainer().setPadParam("width", String.valueOf(fImageWidth));
				getContainer().setPadParam("height", String.valueOf(fImageHeigth));
				fResizedImage = new Image(fParent.getDisplay(),
					fOriginalImage.getImageData().scaledTo(fImageWidth, fImageHeigth));
				
				label.setImage(fResizedImage);
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

				fImagePath = null;
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
	public Pad copy() {
		return new ImagePad(fCurrentState, fImagePath);
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
	
	public void setSize(int width, int heght) {
		fImageWidth = width;
		fImageHeigth = heght;
		if (label != null) {
			fResizedImage = new Image(label.getParent().getDisplay(),
					fOriginalImage.getImageData().scaledTo(fImageWidth, fImageHeigth));
			label.setImage(fResizedImage);
			label.getParent().redraw();
		}
	}

	@Override
	public String getType() {
		return "Image";
	}

	public void setImageFile(String imagePath) {
		File storageDirectory = new File(getContainer().getContainerManager().getStoragePath() + "image/");
		
		if (!storageDirectory.exists()) {
			if (!storageDirectory.mkdirs()) {
				return;
			}
		}
		
		File imageSrc = new File(imagePath);
		File imageDst = new File(getContainer().getContainerManager().getStoragePath() + "image/" + imageSrc.getName());
		if (!imageDst.exists())
		{
			try {
				FileUtils.copyFile(imageSrc, imageDst);
			} catch (IOException e1) {
			}
		}
		
		fImagePath = imageSrc.getName();
		getContainer().setValue(fImagePath);
		switchToImage();
	}
	
	public void setImageData(ImageData imageData) {
		File storageDirectory = new File(getContainer().getContainerManager().getStoragePath() + "image/");
		
		if (!storageDirectory.exists()) {
			if (!storageDirectory.mkdirs()) {
				return;
			}
		}
		ImageLoader loader = new ImageLoader();
		loader.data = new ImageData[] {imageData};
		String imageName = UUID.randomUUID().toString() + ".png";
		File imageDst = new File(getContainer().getContainerManager().getStoragePath() + "image/" + imageName);
		FileOutputStream stream = null;
		try {
			stream = new FileOutputStream(imageDst);
			loader.save(stream, SWT.IMAGE_PNG);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} finally {
			IOUtils.closeQuietly(stream);
		}

		fImagePath = imageName;
		getContainer().setValue(fImagePath);
		switchToImage();
	}

	private void switchToImage() {
		/* Switch to image presentation state */
		fCurrentState = STATE_IMAGE;
		initView(fParent);
	}
	
	@Override
	public String getTex() {
		return "\\includegraphics{" + getContainer().getContainerManager().getStoragePath() + "image/" + fImagePath + "}";
	}
	
}
