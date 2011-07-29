package org.eclipse.iee.sample.math.pad;

import java.io.IOException;
import java.io.StringWriter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import java.awt.Color;
import javax.swing.text.BadLocationException;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
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

public class MathPad extends Pad {

	public MathPad() {
		super();
	}

	@Override
	public void createPartControl(final Composite parent) {
		parent.setLayout(new RowLayout());
		GridLayout layout = new GridLayout(2, false);
		layout.marginBottom = 3;
		layout.marginRight = 3;
		layout.marginLeft = 3;
		layout.marginTop = 3;
		Group mathPad = new Group(parent, SWT.NONE);
		mathPad.setText("Sample math Pad");
		mathPad.setBounds(parent.getBounds());
		mathPad.setLayout(layout);
		GridData groupGridData = new GridData();
		groupGridData.horizontalAlignment = GridData.FILL;
		groupGridData.verticalAlignment = GridData.FILL;
		mathPad.setData(groupGridData);

		final Text text = new Text(mathPad, SWT.BORDER);
		text.setBounds(this.getContainer().getComposite().getLocation().x, this
				.getContainer().getComposite().getLocation().y, 50, 10);
		text.setText("");

		final Button calculate = new Button(mathPad, SWT.BUTTON1);

		final Label label = new Label(mathPad, SWT.NONE);
		GridData labelGridData = new GridData();
		labelGridData.horizontalAlignment = GridData.FILL;
		labelGridData.grabExcessHorizontalSpace = true;
		labelGridData.grabExcessVerticalSpace = true;
		label.setLayoutData(labelGridData);

		final String imagePath = this.getContainerID() + ".jpg";
		calculate.setText("Calculate");
		calculate.setToolTipText("Calculate expression");
		calculate.addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent e) {

				String output = "";
				String expression = text.getText();

				try {
					F.initSymbols(null);
					EvalUtilities util = new EvalUtilities();
					IExpr result = null;
					StringBufferWriter buf = new StringBufferWriter();

					result = util.evaluate(expression);
					OutputFormFactory.get().convert(buf, result);

					output = buf.toString();

					/* Convert to TeX and image */
					EvalEngine engine = new EvalEngine();
					TeXUtilities texUtil = new TeXUtilities(engine);

					StringWriter stw = new StringWriter();
					texUtil.toTeX(result, stw);
					output = stw.toString();

					TeXFormula formula = new TeXFormula(stw.toString());
					/* */
					formula.createJPEG(TeXConstants.STYLE_DISPLAY, 20,
							imagePath, Color.white, Color.black);

				} catch (BadLocationException e1) {
					e1.printStackTrace();
				} catch (IOException e2) {
					e2.printStackTrace();
				} catch (Exception e3) {
					e3.printStackTrace();
				}
				Image image = null;
				try {
					image = new Image(parent.getDisplay(), imagePath);
				} catch (Exception exception) {

					exception.printStackTrace();

				}
				label.setImage(image);
				parent.pack();
			}

			@Override
			public void mouseDown(MouseEvent e) {
			}

			@Override
			public void mouseDoubleClick(MouseEvent e) {
			}
		});

	}

	protected MathPad(String containerID) {
		super(containerID);
	}

	@Override
	public Pad copy() {
		return new MathPad();
	}

	@Override
	public String getType() {
		return "Math";
	}

}
