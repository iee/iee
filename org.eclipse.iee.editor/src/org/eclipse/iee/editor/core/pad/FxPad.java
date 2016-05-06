package org.eclipse.iee.editor.core.pad;

import java.awt.Rectangle;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.editor.core.container.Container;
import org.eclipse.iee.editor.core.container.IView;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.layout.Region;

public abstract class FxPad<T extends PadDocumentPart, F extends Region> extends Pad<T> {

	private F fContent;
	
	@Override
	public void attachContainer(Container container)  {
		Assert.isNotNull(container);
		Assert.isLegal(!isContainerAttached(), "Another container is already attached");

		fContainer = container;
		fContent = getFigure();
		
		container.getContainerManager().getEditorManager().addEditor(this);
		container.getContainerManager().getEditorManager().getFxMainFigure().getChildren().add(fContent);
		
		fContent.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
			@Override
			public void changed(ObservableValue<? extends Bounds> observable, Bounds oldValue, Bounds newValue) {
				Rectangle bounds = getView().getBounds();
				updateSelectionBounds(bounds);
			}
		});
	}

	@Override
	public void setBounds(Rectangle newBounds) {
		fContent.setPrefSize(newBounds.width, newBounds.height);
		fContent.relocate(newBounds.x, newBounds.y);
		updateSelectionBounds(newBounds);
	}

	@Override
	public void setVisible(boolean isVisible) {
		fContent.setVisible(isVisible);
	}
	
	@Override
	public void dispose() {
		fContainer.getContainerManager().getEditorManager().removeEditor(this);
		fContainer.getContainerManager().getEditorManager().getFxMainFigure().getChildren().remove(fContent);
	}

	public F getFigure() {
		if (fContent == null) {
			fContent = createContent();
		}
		return fContent;
	}

	protected abstract F createContent();
	
	
	@Override
	protected IView createView() {
		return new IView() {
			
			@Override
			public <T> T getWrapped(Class<T> type) {
				return null;
			}
			
			@Override
			public Rectangle getBounds() {
				Bounds bounds = fContent.boundsInParentProperty().getValue();
				return new Rectangle((int)bounds.getMinX(), (int)bounds.getMinY(), (int)bounds.getWidth(), (int)bounds.getHeight());
			}
		};
	}
	
}
