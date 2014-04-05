package org.eclipse.iee.pad.formula.ui;

import java.util.Collection;

import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.pad.formula.SymbolicEngine;
import org.eclipse.iee.pad.formula.SymbolicPart;
import org.eclipse.iee.pad.formula.ui.utils.FormulaRenderer;
import org.eclipse.iee.pad.formula.ui.utils.Function;
import org.eclipse.swt.graphics.Image;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SymbolicPad extends AbstractFormulaPad<SymbolicPart> {

	private static final Logger logger = LoggerFactory.getLogger(FormulaPad.class);

	private SymbolicEngine fSymbolicEngine;
	
	public SymbolicPad(SymbolicPart part) {
		super(part);
		setTranslatingExpression(part.getFormula());
		setOriginalExpression(part.getFormula());
		fSymbolicEngine = new SymbolicEngine();
	}

	@Override
	public String getType() {
		return "Symbolic";
	}

	public void validateInput() {
		String text = fDocument.get();
		fOriginalExpression = text;

		if (SymbolicEngine.validate(text)) {
			setInputIsValid();
			fLastValidText = text;
		} else {

			setInputIsInvalid();
		}
	}

	public void processInput() {
		if (fIsInputValid) {
			if (!fDocument.get().equals(fTranslatingExpression)) {
				/* Remove result images from following pads */
				Collection<Pad<?>> following = FormulaPadManager
						.getFollowingPads(this);

				for (Pad<?> pad : following) {
					((SymbolicPad) pad).updateLastResult("");
				}
			}
		}

		fTranslatingExpression = fLastValidText;

		/* Set formula image */
		fTexExpression = translateToLatex(fTranslatingExpression);
		Image image = FormulaRenderer.getSymbolicImage(fTexExpression);
		fFormulaImageLabel.setImage(image);

		/* Generate code */

		String output = generateSymjaOutputCode(fTranslatingExpression);
		updateLastResult(output);
		getDocumentPart().setFormula(fOriginalExpression);
		getContainer().updateDocument();
	}

	public String generateSymjaOutputCode(String expression) {
		String variable = expression;
		char lastVariable = variable.charAt(expression.trim().length() - 1);
		if (lastVariable == '=')
			variable = expression.substring(0, expression.lastIndexOf('='));
		String output = "";

		output = fSymbolicEngine.getOutput(variable);

		if (lastVariable != '=')
			output = "";

		return output;
	}

	public void updateLastResult(String result) {
		final Image image;
		fResult = result;
		if (result == "")
			image = null;
		else {
			String latex = translateToLatex(result);
			fTexExpression += latex;
			image = FormulaRenderer.getSymbolicImage(latex);
		}
		Function updateImage = new Function() {

			@Override
			public void f() {
				if (!fLastResultImageLabel.isDisposed()) {
					fLastResultImageLabel.setImage(image);
					fParent.pack();
				}
			}
		};

		asyncUIUpdate(updateImage);

	}

	public static String translateToLatex(String text) {
		String latex = "";

		if (text.length() > 0 && text.charAt(text.length() - 1) == '=') {
			latex = SymbolicEngine.getTeX(text.substring(0,
					text.lastIndexOf('=')));
			latex = latex + "=";
		} else {
			latex = SymbolicEngine.getTeX(text);
		}
		logger.debug("tex: " + latex);

		return latex;

	}

	@Override
	protected Image createImage(String formula) {
		return FormulaRenderer.getSymbolicImage(formula);
	}
	
	@Override
	public SymbolicPad copy() {
		SymbolicPad newPad = new SymbolicPad(getDocumentPart().copy());
		return newPad;
	}

}