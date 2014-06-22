package org.eclipse.iee.editor.monitoring.handlers;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.iee.editor.IPadEditor;
import org.eclipse.iee.editor.core.container.Container;
import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.iee.editor.core.pad.IPadFactoryManager;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.monitoring.utils.Convert;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.handlers.HandlerUtil;

public class PdfExportHandler implements IHandler {

	private static final Logger logger = Logger
			.getLogger(PdfExportHandler.class);

	private String fLatex;
	private String fPdfPath;

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		logger.debug("Export to pdf");

		Shell shell = HandlerUtil.getActiveWorkbenchWindow(event).getShell();
		IWorkbenchPage page = HandlerUtil.getActiveWorkbenchWindow(event)
				.getActivePage();
		IEditorPart targetEditor = page.getActiveEditor();

		IPadEditor fPadEditor;
		try {
			fPadEditor = (IPadEditor) targetEditor;
		} catch (ClassCastException e) {
			fPadEditor = null;
		}

		if (fPadEditor == null) {
			MessageDialog.openError(shell, "Invalid editor", "Invalid editor");
			return null;
		}

		FileDialog fileDialog = new FileDialog(shell, SWT.SAVE);
		fileDialog.setFilterNames(new String[] { "pdf (*.pdf)" });
		fileDialog.setFilterExtensions(new String[] { "*.pdf" });

		fPdfPath = fileDialog.open();
		if (fPdfPath == null) {
			return null;
		}

		fLatex = "";
		int lastOffset = 0;
		String javaSource = "";

		IPadFactoryManager padManager = fPadEditor.getPadManager();
		ContainerManager containerManager = fPadEditor.getContainerManager();

		for (Container c : containerManager.getContainers()) {
			javaSource = "";
			int offset = c.getPosition().getOffset();
			int length = c.getPosition().getLength();

			try {
				javaSource = containerManager.getDocument().get(lastOffset,
						offset - lastOffset);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}

			fLatex += convertJavaSource(javaSource);

			Pad<?> pad = containerManager.getPadById(c.getContainerID());
			fLatex += pad.getTex();

			lastOffset = offset + length;
		}

		try {
			javaSource = containerManager.getDocument().get(lastOffset,
					containerManager.getDocument().getLength() - lastOffset);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}

		fLatex += convertJavaSource(javaSource);

		logger.debug("full latex: " + fLatex);

		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				try {
					Convert.toSVG(fLatex, "Example.svg", true);
					Convert.SVGTo("Example.svg", fPdfPath, Convert.PDF);

					File svgFile = new File("Example.svg");
					svgFile.delete();
				} catch (IOException ex) {
				}
			}
		});

		return null;
	}

	private String convertJavaSource(String inputSource) {
		return inputSource.replaceAll(" ", " \\\\ ")
				.replaceAll("\r\n", " \\\\\\\\ ")
				.replaceAll("\t", " \\\\quad ").replaceAll("\\{", "\\\\{")
				.replaceAll("\\}", "\\\\}");
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isHandled() {
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
	}

}
