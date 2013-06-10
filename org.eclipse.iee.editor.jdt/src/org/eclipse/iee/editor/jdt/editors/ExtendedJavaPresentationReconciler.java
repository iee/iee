package org.eclipse.iee.editor.jdt.editors;

import org.eclipse.jdt.internal.ui.text.JavaPresentationReconciler;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextPresentation;


@SuppressWarnings("restriction")
public class ExtendedJavaPresentationReconciler extends JavaPresentationReconciler {

	@Override
	protected TextPresentation createPresentation(IRegion damage, IDocument document) {
		TextPresentation textPresentation = super.createPresentation(damage, document);
		
		// Add styles to testPresentation here
		System.out.print("ExtendedJavaPresentationReconciler.createPresentation() called");
		
		return textPresentation;
	}

}
