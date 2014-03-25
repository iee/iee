package org.eclipse.iee.editor.jdt.editors;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.iee.editor.IeeEditorPlugin;
import org.eclipse.iee.editor.core.container.Container;
import org.eclipse.iee.editor.core.container.ContainerManager;
import org.eclipse.iee.editor.core.container.event.IContainerManagerListener;
import org.eclipse.jdt.internal.ui.javaeditor.JavaSourceViewer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class IEESourceViewer extends JavaSourceViewer {
	
	private ContainerManager fContainerManager;
	private Listener fMouseListener;
	private List<ISelectionChangedListener> fPostSelectionChangedListeners;
	
	public IEESourceViewer(Composite parent, IVerticalRuler verticalRuler,
			IOverviewRuler overviewRuler, boolean showAnnotationsOverview,
			int styles, IPreferenceStore store) {
		super(parent, verticalRuler, overviewRuler,
				showAnnotationsOverview, styles, store);
	}

	@Override
	protected void createControl(Composite parent, int styles) {
		super.createControl(parent, styles);
		fContainerManager = new ContainerManager(IeeEditorPlugin.getDefault().getParser(), 
				IeeEditorPlugin.getDefault().getWriter(), this, getTextWidget());
		final StyledText textWidget = getTextWidget();
		fMouseListener = new Listener() {
			@Override
			public void handleEvent(Event event) {
				if (event.type == SWT.MouseDown) {
					if (!(event.widget instanceof Control))
	                {
	                    return;
	                }

	                boolean isOurChild = false;
	                for (Control c = (Control) event.widget; c != null; c = c.getParent())
	                {
	                    if (c == textWidget)
	                    {
	                        isOurChild = true;
	                        break;
	                    }
	                }
	                Control control = (Control) event.widget;
	                Point displayPoint = control.toDisplay(event.x, event.y);
	                Point styledTextPoint = textWidget.toControl(displayPoint);
					if (isOurChild) {
						Container c = fContainerManager.getContainerAtPoint(styledTextPoint);
						if (c != null) {
							int containerOffset = c.getPosition().getOffset();
							c.getContainerManager().getUserInteractionManager().moveCaretTo(containerOffset);
							select(c);
							c.getContainerManager().getUserInteractionManager().activateContainer(c);
						} else {
							select(null);
						}
					}
				}
			}
		};
		textWidget.getDisplay().addFilter(SWT.MouseDown, fMouseListener);
		
	}
	
	public ContainerManager getContainerManager() {
		return fContainerManager;
	}
	
	@Override
	protected void handleDispose() {
		getTextWidget().getDisplay().removeFilter(SWT.MouseUp, fMouseListener);
		super.handleDispose();
		getContainerManager().dispose();
		fContainerManager = null;
	}
	
	@Override
	public void setDocument(IDocument document,
			IAnnotationModel annotationModel, int modelRangeOffset,
			int modelRangeLength) {
		super.setDocument(document, annotationModel, modelRangeOffset, modelRangeLength);
		fContainerManager.setDocument(document);
	}
	
	public void select(Container c) {
		getContainerManager().getUserInteractionManager().selectContainer(c);
		if (c != null) {
			SelectionChangedEvent event = new SelectionChangedEvent(this, new StructuredSelection(c));
			fireSelectionChanged(event);
			firePostSelectionChanged(event);
		}
	}
	
	@Override
	public void setSelection(ISelection selection) {
		if (!(selection instanceof IStructuredSelection)) {
			super.setSelection(selection);
		}
		Object selected = ((IStructuredSelection) selection).getFirstElement();
		if (selected instanceof Container) {
			select((Container) selected);
		}
	}
	
	@Override
	public void addPostSelectionChangedListener(
			ISelectionChangedListener listener) {
		super.addPostSelectionChangedListener(listener);
		if (fPostSelectionChangedListeners == null) {
			fPostSelectionChangedListeners = new ArrayList<>();
		}

		if (!fPostSelectionChangedListeners.contains(listener)) {
			fPostSelectionChangedListeners.add(listener);
		}
	}
	
	@Override
	public void removePostSelectionChangedListener(
			ISelectionChangedListener listener) {
		super.removePostSelectionChangedListener(listener);
		if (fPostSelectionChangedListeners != null)  {
			fPostSelectionChangedListeners.remove(listener);
			if (fPostSelectionChangedListeners.size() == 0) {
				fPostSelectionChangedListeners=  null;
			}
		}
	}

	private void firePostSelectionChanged(SelectionChangedEvent event) {
		List<ISelectionChangedListener> listeners = fPostSelectionChangedListeners;
		if (listeners != null) {
			listeners = new ArrayList<>(listeners);
			for (int i = 0; i < listeners.size(); i++) {
				ISelectionChangedListener l= (ISelectionChangedListener) listeners.get(i);
				l.selectionChanged(event);
			}
		}
	}
	
}