package org.eclipse.iee.sample.math.pad;

import java.io.*;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;

import java.awt.Color;
import javax.swing.text.BadLocationException;

import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.iee.editor.core.pad.Pad;
import org.matheclipse.core.eval.EvalEngine;
import org.matheclipse.core.eval.EvalUtilities;
import org.matheclipse.core.eval.TeXUtilities;
import org.matheclipse.core.expression.F;
import org.matheclipse.core.form.output.OutputFormFactory;
import org.matheclipse.core.form.output.StringBufferWriter;
import org.matheclipse.core.interfaces.IExpr;
import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;

public class MathPad extends Pad implements Serializable {

	private String fImagePath;
	private String fExpression;
	private boolean fIsTextVisible;

	public MathPad() {
		super();
		fImagePath = this.getContainerID() + ".jpg";
		fExpression = "";
		fIsTextVisible = true;
		save();
	}

	@Override
	public void createPartControl(final Composite parent) {
		parent.setLayout(new RowLayout());
		FormLayout layout = new FormLayout();
		layout.marginBottom = 3;
		layout.marginRight = 3;
		layout.marginLeft = 3;
		layout.marginTop = 3;
		final Group mathPad = new Group(parent, SWT.NONE);
		mathPad.setText("Sample math Pad");
		mathPad.setLayout(layout);
		mathPad.setToolTipText("Use DoubleClick for any action");

		final Text text = new Text(mathPad, SWT.BORDER | SWT.H_SCROLL);
		text.setText(fExpression);
		FormData textFormData = new FormData();
		textFormData.top = new FormAttachment(20);
		text.setLayoutData(textFormData);
		text.setToolTipText("Use DoubleClick for calculation");
		text.setVisible(fIsTextVisible);

		final Label label = new Label(mathPad, SWT.NONE | SWT.RESIZE);
		label.setText(fExpression);
		FormData labelFormData = new FormData();
		labelFormData.top = new FormAttachment(20);
		label.setLayoutData(labelFormData);

		if (!fImagePath.isEmpty()) {
			File imageFile = new File(fImagePath);
			Image image = null;
			if (imageFile.exists()) {
				try {
					image = new Image(parent.getDisplay(), fImagePath);
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				label.setImage(image);
				parent.pack();
			}
		}
		label.setToolTipText("Use DoubleClick for edit");
		label.setVisible(!fIsTextVisible);

		parent.pack();

		// Listeners

		MouseEventManager mouseManager = new MouseEventManager(parent);
		parent.addMouseTrackListener(mouseManager);
		parent.addMouseMoveListener(mouseManager);

		text.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				fExpression = text.getText();
			}
		});

		text.addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent e) {

			}

			@Override
			public void mouseDown(MouseEvent e) {
			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				if (fIsTextVisible) {
					fIsTextVisible = false;
					text.setVisible(fIsTextVisible);
					fExpression = text.getText();
					String output = "";
					try {
						F.initSymbols(null);
						EvalUtilities util = new EvalUtilities();
						IExpr result = null;
						StringBufferWriter buf = new StringBufferWriter();

						if (fExpression.isEmpty())
							result = util.evaluate("Empty string");
						else
							result = util.evaluate(fExpression);
						OutputFormFactory.get().convert(buf, result);

						output = buf.toString();

						/* Convert to TeX and image */
						EvalEngine engine = new EvalEngine();
						TeXUtilities texUtil = new TeXUtilities(engine);

						StringWriter stw = new StringWriter();
						texUtil.toTeX(result, stw);
						output = stw.toString();
						fExpression = output;

						TeXFormula formula = new TeXFormula(stw.toString());
						/* */
						formula.createJPEG(TeXConstants.STYLE_DISPLAY, 20,
								fImagePath, Color.white, Color.black);

					} catch (BadLocationException e1) {
						e1.printStackTrace();
					} catch (IOException e2) {
						e2.printStackTrace();
					} catch (Exception e3) {
						e3.printStackTrace();
					}

					Image image = null;
					try {
						image = new Image(parent.getDisplay(), fImagePath);
					} catch (Exception exception) {
						exception.printStackTrace();
					}
					label.setImage(image);
					label.setSize(image.getBounds().width,
							image.getBounds().height);
					label.setVisible(!fIsTextVisible);

					parent.pack();
					save();
				}
			}
		});

		label.addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent e) {
			}

			@Override
			public void mouseDown(MouseEvent e) {
			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {
				if (!fIsTextVisible) {
					fIsTextVisible = true;
					text.setText(fExpression);
					text.setVisible(fIsTextVisible);
					label.setVisible(!fIsTextVisible);
					parent.pack();
					save();
				}
			}
		});

	}

	protected MathPad(String containerID) {
		super(containerID);
		fImagePath = containerID + ".jpg";
		fExpression = "";
		fIsTextVisible = true;
		save();
	}

	@Override
	public Pad copy() {
		MathPad newPad = new MathPad();
		newPad.fExpression = this.fExpression;
		newPad.fIsTextVisible = this.fIsTextVisible;
		File inputFile = new File(this.fImagePath);
		File outputFile = new File(newPad.fImagePath);

		try {
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(inputFile), 4096);
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(outputFile), 4096);
			int buffer;
			while ((buffer = bis.read()) != -1) {
				bos.write(buffer);
			}
			bos.close();
			bis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return newPad;
	}

	@Override
	public String getType() {
		return "Math";
	}

	// Save&Load operations, use it for serialization

	public void save() {
		try {
			FileOutputStream fos = new FileOutputStream(this.getContainerID()
					+ ".bin");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(this);
			out.close();
			fos.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	public MathPad load() {
		MathPad loadedPad = null;
		try {
			FileInputStream fis = new FileInputStream(this.getContainerID()
					+ ".bin");
			ObjectInputStream in = new ObjectInputStream(fis);
			try {
				loadedPad = (MathPad) in.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			in.close();
			fis.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
		return loadedPad;
	}

}
