package org.eclipse.iee.editor.monitoring.views;


import org.eclipse.iee.editor.IPadEditor;
import org.eclipse.iee.editor.core.container.Container;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;


public class EditorContainersMonitoringView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "org.eclipse.iee.editor.monitoring.views.EditorContainersMonitoringView";

	private IWorkbenchPart fCurrentPadEditor;
	private IPropertyListener fCurrentPadEditorPropertyListener;
	private IPartListener fWorkbenchPartListener;
	
	private TableViewer fContainersTableViewer;

	
	class ContainerContentProvider implements IStructuredContentProvider {
		@Override
		public Object[] getElements(Object parent) {
			return (Object[]) parent;
		}
		@Override public void dispose() {}
		@Override public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {}
	}
	
	class ContainersLabelProvider
		extends LabelProvider implements ITableLabelProvider {

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			Container container = (Container) element;
			switch (columnIndex) {
			case 0:
				return container.getContainerID();
				
			case 1:
				return String.format("%d", container.getPosition().getOffset());
			
			case 2:	
				return "" /*+ container.getLineNumber()*/;
				
			default:
				return "unknown " + columnIndex;
			}
		}
	}
	

	public void createPartControl(Composite parent) {

		parent.setLayout(new FillLayout(SWT.VERTICAL));
		initContainerTableView(parent);
		parent.pack();
		
		/* Linking with editor */
		
		fCurrentPadEditorPropertyListener = new IPropertyListener() {
			@Override
			public void propertyChanged(Object source, int propId) {
				if (propId == IPadEditor.PROP_CONTAINER_SET) {
					updateViewerInput();
				}
			}
		};
		
		fWorkbenchPartListener = new IPartListener() {
			@Override
			public void partBroughtToTop(IWorkbenchPart part) {
				System.out.println("partBroughtToTop");
				if (part instanceof IEditorPart) {
					if (part instanceof IPadEditor){
						linkEditor(part);
					} else {
						unlinkEditor();
					}
				}
			}

			@Override
			public void partClosed(IWorkbenchPart part) {
				System.out.println("partClosed");
				if (part == fCurrentPadEditor) {
					unlinkEditor();
				}
			}
			
			@Override public void partDeactivated(IWorkbenchPart part) {}
			@Override public void partOpened(IWorkbenchPart part) {}
			@Override public void partActivated(IWorkbenchPart part) {}
		};
		
		getSite().getPage().addPartListener(fWorkbenchPartListener);
		
		
		/* Check current editor */
		
		IWorkbenchPart part = getSite().getPage().getActiveEditor();
		if (part instanceof IPadEditor) {
			linkEditor(part);
		}
	}
	
	protected void initContainerTableView(Composite parent) {		
		fContainersTableViewer = new TableViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);

		final Table table = fContainersTableViewer.getTable();
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		String[] columnNames = new String[] { "Container ID", "Offset", "Line number"};
		int[] columnWidths = new int[] { 300, 100, 100 };
		int[] columnAlignments = new int[] { SWT.LEFT, SWT.LEFT, SWT.LEFT};
		
		for (int i = 0; i < columnNames.length; i++) {
			TableColumn tableColumn = new TableColumn(table, columnAlignments[i]);
			tableColumn.setText(columnNames[i]);
			tableColumn.setWidth(columnWidths[i]);
		}
		
		fContainersTableViewer.setContentProvider(new ContainerContentProvider());
		fContainersTableViewer.setLabelProvider(new ContainersLabelProvider());
	}
	
	protected void linkEditor(IWorkbenchPart part) {
		if (fCurrentPadEditor != null) {
			fCurrentPadEditor.removePropertyListener(fCurrentPadEditorPropertyListener);
		}
		
		fCurrentPadEditor = part;			
		fCurrentPadEditor.addPropertyListener(fCurrentPadEditorPropertyListener);
		
		updateViewerInput();
	}
	
	protected void unlinkEditor() {
		if (fCurrentPadEditor != null) {
			fCurrentPadEditor.removePropertyListener(fCurrentPadEditorPropertyListener);
		}
		fCurrentPadEditor = null;
		fContainersTableViewer.setInput(null);
	}
	
	protected void updateViewerInput() {
		fContainersTableViewer.setInput(
			((IPadEditor)fCurrentPadEditor).getElements()
		);
	}
		
	@Override
	public void dispose() {
		
		/* Remove container monitoring */
		
		getSite().getPage().removePartListener(fWorkbenchPartListener);
		if (fCurrentPadEditor != null) {
			fCurrentPadEditor.removePropertyListener(fCurrentPadEditorPropertyListener);
		}

		super.dispose();
    }
	
	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		fContainersTableViewer.getControl().setFocus();
	}
}
