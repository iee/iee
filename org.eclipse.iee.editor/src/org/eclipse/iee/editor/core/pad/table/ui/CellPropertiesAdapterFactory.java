package org.eclipse.iee.editor.core.pad.table.ui;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.iee.editor.core.pad.table.TableCell;
import org.eclipse.iee.editor.properties.ContainerPropertySource;
import org.eclipse.ui.views.properties.IPropertySource;

public class CellPropertiesAdapterFactory implements IAdapterFactory {

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object, java.lang.Class)
	 */
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (IPropertySource.class.isAssignableFrom(adapterType)) {
			return new ContainerPropertySource(new CellPropertiesModel((TableCell) adaptableObject));
		} 
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
	 */
	@Override
	public Class[] getAdapterList() {
		return new Class[] {IPropertySource.class};
	}

}
