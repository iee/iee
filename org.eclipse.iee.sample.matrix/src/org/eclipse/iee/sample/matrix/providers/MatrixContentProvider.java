package org.eclipse.iee.sample.matrix.providers;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

public class MatrixContentProvider implements IStructuredContentProvider{

	@Override
	public void dispose() {
		
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		
	}

	//Just add methods for getting matrix elements
	@Override
	public Object[] getElements(Object inputElement) {
		return null;
	}
	
}
