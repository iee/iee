package org.eclipse.iee.editor.jdt.editors;

import org.eclipse.jdt.ui.text.IColorManager;
import org.eclipse.jdt.ui.text.IJavaPartitions;
import org.eclipse.jdt.ui.text.JavaSourceViewerConfiguration;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.texteditor.ITextEditor;

public class ExtendedJavaSourceViewerConfiguration extends JavaSourceViewerConfiguration {

	/* Constructor, without any changes */
	public ExtendedJavaSourceViewerConfiguration(
			IColorManager colorManager,
			IPreferenceStore preferenceStore,
			ITextEditor editor,
			String partitioning)
	{
		super(colorManager, preferenceStore, editor, partitioning);
	}
	
	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		
		System.out.println("ExtendedJavaSourceViewerConfiguration.getPresentationReconciler() called");
		
		/* The only change: using ExtendedJavaPresentationReconciler instead of JavaPresentationReconciler */
		PresentationReconciler reconciler = new ExtendedJavaPresentationReconciler();
		
		reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));

		DefaultDamagerRepairer dr= new DefaultDamagerRepairer(getCodeScanner());
		reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		dr= new DefaultDamagerRepairer(getJavaDocScanner());
		reconciler.setDamager(dr, IJavaPartitions.JAVA_DOC);
		reconciler.setRepairer(dr, IJavaPartitions.JAVA_DOC);

		dr= new DefaultDamagerRepairer(getMultilineCommentScanner());
		reconciler.setDamager(dr, IJavaPartitions.JAVA_MULTI_LINE_COMMENT);
		reconciler.setRepairer(dr, IJavaPartitions.JAVA_MULTI_LINE_COMMENT);

		dr= new DefaultDamagerRepairer(getSinglelineCommentScanner());
		reconciler.setDamager(dr, IJavaPartitions.JAVA_SINGLE_LINE_COMMENT);
		reconciler.setRepairer(dr, IJavaPartitions.JAVA_SINGLE_LINE_COMMENT);

		dr= new DefaultDamagerRepairer(getStringScanner());
		reconciler.setDamager(dr, IJavaPartitions.JAVA_STRING);
		reconciler.setRepairer(dr, IJavaPartitions.JAVA_STRING);

		dr= new DefaultDamagerRepairer(getStringScanner());
		reconciler.setDamager(dr, IJavaPartitions.JAVA_CHARACTER);
		reconciler.setRepairer(dr, IJavaPartitions.JAVA_CHARACTER);


		return reconciler;
	}
	
	
}
