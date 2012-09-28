package org.eclipse.iee.sample.image.pad;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.sample.image.ImageFileStorage;
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

public class ImagePad extends Pad implements Serializable {

	private transient static final Logger logger = Logger.getLogger(ImagePad.class);
	
	private transient static final int STATE_MENU = 0;
	private transient static final int STATE_IMAGE = 1;
	private transient static final int STATE_ERROR = 2;

	private static final long serialVersionUID = -5570698937452800023L;

	private int fCurrentState;
	protected String fImagePath;

	protected transient Image fOriginalImage = null;
	protected transient Image fResizedImage = null;
	private int fImageWidth = -1;
	private int fImageHeigth = -1;
	
	private String fStoragePath;

	public String getStoragePath() {
		return fStoragePath;
	}

	public void setStoragePath(String storagePath) {
		this.fStoragePath = storagePath;
	}
	
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
		/* Clear data */

		fImagePath = null;

		/* Initialize controls */
		FillLayout layout = new FillLayout(SWT.VERTICAL);
		parent.setLayout(layout);
		// It is hint operation now
		parent.setBackground(new Color(null, 255, 255, 255));

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
				FileDialog fileDialog = new FileDialog(parent.getShell(), SWT.OPEN);
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

	protected void initImageView(final Composite parent) {
		logger.debug("initImageView");
		
		try {
			fOriginalImage = new Image(parent.getDisplay(), fImagePath);
			if (fImageWidth > 0 && fImageHeigth > 0)
			{
				fResizedImage = new Image(parent.getDisplay(),
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
			initView(parent);
		}

		/* Initialize controls */
		FillLayout layout = new FillLayout();
		parent.setLayout(layout);
		final Label label = new Label(parent, SWT.NONE);
		label.setImage(fResizedImage);
		parent.pack();

		parent.addControlListener(new ControlListener() {
			@Override
			public void controlResized(ControlEvent e) {				
				Point size = parent.getSize();
				fImageWidth = size.x;
				fImageHeigth = size.y;
				fResizedImage = new Image(parent.getDisplay(),
					fOriginalImage.getImageData().scaledTo(fImageWidth, fImageHeigth));
				
				label.setImage(fResizedImage);
				parent.redraw();
			}
			
			@Override
			public void controlMoved(ControlEvent e) {
			}			
		});
	}

	protected void initErrorView(final Composite parent) {

		FillLayout layout = new FillLayout(SWT.VERTICAL);
		parent.setLayout(layout);
		// It is hint operation now
		parent.setBackground(new Color(null, 255, 255, 255));

		final Label label = new Label(parent, SWT.WRAP | SWT.CENTER);
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
	public void save() {
		ImageFileStorage.getInstance(fStoragePath).saveToFile(this);
	}

	@Override
	public void unsave() {
		ImageFileStorage.getInstance(fStoragePath).removeFile(getContainerID());
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
}
