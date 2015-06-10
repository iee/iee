package org.eclipse.iee.pad.graph.ui;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FocusEvent;
import org.eclipse.draw2d.FocusListener;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.MouseEvent;
import org.eclipse.draw2d.MouseListener;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.iee.editor.core.bindings.IObservableValue;
import org.eclipse.iee.editor.core.bindings.IObserver;
import org.eclipse.iee.editor.core.bindings.ObservableProperty;
import org.eclipse.iee.editor.core.pad.common.text.AbstractTextEditor;
import org.eclipse.iee.editor.core.pad.common.text.TextLocation;
import org.eclipse.iee.editor.core.pad.common.text.TextPartEditor;
import org.eclipse.iee.editor.core.pad.common.ui.IMenuContributor;
import org.eclipse.iee.pad.formula.ui.utils.UIFormulaRenderer;
import org.eclipse.iee.pad.graph.model.GraphElement;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Caret;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.jfree.chart.plot.DrawingSupplier;
import org.jfree.experimental.swt.SWTUtils;
import org.jfree.util.PaintUtilities;

import com.google.common.base.Strings;

public class GraphElementEditor extends AbstractTextEditor<GraphElement> implements IMenuContributor<GraphElement> {

	private ImageFigure fFormulaImage;
	
	private Figure fTextFigure;
	
	private Label fLine;
	
	private UIFormulaRenderer fFormulaRenderer;
	
	private DrawingSupplier fDrawingSupplier;
	
	private IShellProvider fShellProvider;

	private TextPartEditor fTextPartEditor;

	private ObservableProperty<String> fColorValue;

	private ObservableProperty<String> fFunctionValue;

	private ObservableProperty<Integer> fWidthValue;

	public GraphElementEditor(UIFormulaRenderer formulaRenderer, DrawingSupplier drawingSupplier, IShellProvider shellProvider) {
		this.fFormulaRenderer = formulaRenderer;
		fDrawingSupplier = drawingSupplier;
		fShellProvider = shellProvider;
	}
	
	protected Figure createFigure() {
		final Figure figure = new Figure();
		figure.setLayoutManager(new ToolbarLayout(false));
		fFormulaImage = new ImageFigure();
		fTextPartEditor = new TextPartEditor();
		addChildEditor(fTextPartEditor);
		
		fTextFigure = fTextPartEditor.getFigure();
		fLine = new Label();
		toggleFormulaImage();
		
		figure.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent me) {
				if (me.button == 1) {
					toggleInputText();
				}
			}
			
			@Override
			public void mousePressed(MouseEvent me) {
			}
			
			@Override
			public void mouseDoubleClicked(MouseEvent me) {
			}
		});
		figure.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent fe) {
			}

			@Override
			public void focusLost(FocusEvent fe) {
				toggleFormulaImage();
			}});
		toggleFormulaImage();
		return figure;
	}
	
	public void toggleInputText() {
		Figure figure = (Figure) getFigure();
		figure.removeAll();
		figure.add(fTextFigure);
		figure.add(fLine);
		fTextFigure.requestFocus();
	}

	public void toggleFormulaImage() {
		Figure figure = (Figure) getFigure();
		figure.removeAll();
		Image newImage = createImage();
		if (newImage != null) {
			fFormulaImage.setImage(newImage);
		}
		figure.add(fFormulaImage);
		figure.add(fLine);
		figure.revalidate();
	}
	
	@Override
	public TextLocation getTextLocation(int x, int y) {
		return null;
	}

	@Override
	public void acceptCaret(Caret caret, TextLocation textLocation) {
	}

	@Override
	public boolean isSelectable() {
		return false;
	}

	@Override
	public void setSelected(boolean b) {
	}

	@Override
	public void setActive(boolean b) {
	}
	
	private Image createImage() {
		String fTexExpression = fTextPartEditor.getValue();
		if (Strings.isNullOrEmpty(fTexExpression)) {
			fTexExpression = "o";
		}
		Image image = null;
		if (fTexExpression != null) {
			image = fFormulaRenderer.getFormulaImage(fTexExpression);
		}
		return image;
	}

	@Override
	public void contribute(MenuManager menuManager, GraphElement object) {
		menuManager.add(new ActionContributionItem(new Action("Add function") {
			@Override
			public void runWithEvent(Event event) {
				GraphElement newElement = new GraphElement();
				newElement.setNumberOfPoints(100);
				newElement.setColor(getNextColor());
				getObservableValue().getValue().getGraph().addElement(newElement);
			}
		}));
		menuManager.add(new ActionContributionItem(new Action("Remove function") {
			@Override
			public void runWithEvent(Event event) {
				getObservableValue().getValue().getGraph().removeElement(getModel());
			}
		}));
		menuManager.add(new ActionContributionItem(new Action("Properties") {
			@Override
			public void runWithEvent(final Event event) {
					Dialog dialog = new Dialog(fShellProvider) {
					
					private ElementProperties elementProperties;

					@Override
					protected Control createDialogArea(Composite parent) {
						elementProperties = new ElementProperties(parent, SWT.NONE);
						GraphElement model = getModel();
						elementProperties.getWidthSpinner().setSelection(model.getWidth());
						RGB rgb = SWTUtils.toSwtColor(event.display, PaintUtilities.stringToColor(model.getColor())).getRGB();
						elementProperties.getColorSelector().setColorValue(rgb);
						elementProperties.getPointsText().setText(StringConverter.asString(model.getNumberOfPoints()));
						return elementProperties;
					}
					
					@Override
					protected void okPressed() {
						int width = elementProperties.getWidthSpinner().getSelection();
						getModel().setWidth(width);
						RGB colorValue = elementProperties.getColorSelector().getColorValue();
						java.awt.Color awtColor = SWTUtils.toAwtColor(new Color(event.display, colorValue));
						getModel().setColor(PaintUtilities.colorToString(awtColor));
						getModel().setNumberOfPoints(StringConverter.asInt(elementProperties.getPointsText().getText()));
						super.okPressed();
						setColor(awtColor);
						setWidth(width);
					}
					
				};
				dialog.open();
			}
		}));
	}
	
	public void setColor(java.awt.Color awtColor) {
		fLine.setBackgroundColor(SWTUtils.toSwtColor(Display.getDefault(), awtColor));
	}

	public void setWidth(int width) {
		fLine.setSize(getFigure().getSize().width, width);
	}
	
	public String getNextColor() {
		return PaintUtilities.colorToString((java.awt.Color) fDrawingSupplier.getNextPaint());
	}
	
	public void bindValue(IObservableValue<GraphElement> value) {
		super.bindObservableValue(value);
	}
	
	@Override
	protected void doBindValue(GraphElement value) {

		IObserver<Integer> fWidthObserver = new IObserver<Integer>() {
			@Override
			public void valueChanged(Integer oldValue, Integer newValue) {
				setWidth(newValue);
			}
		};
		IObserver<String> fColorObserver = new IObserver<String>() {
			@Override
			public void valueChanged(String oldValue, String newValue) {
				setColor(PaintUtilities.stringToColor(newValue));
			}
		};
		
		fColorValue = new ObservableProperty<String>(value, "color", String.class);
		fColorValue.addObserver(fColorObserver);
		String color = fColorValue.getValue();
		if (color == null) {
			color = getNextColor();
			fColorValue.setValue(color);
		}
		fWidthValue = new ObservableProperty<Integer>(value, "width", Integer.class);
		fWidthValue.addObserver(fWidthObserver);
		
		fFunctionValue = new ObservableProperty<String>(value, "function", String.class);
		fTextPartEditor.bindValue(fFunctionValue);
		
		setColor(PaintUtilities.stringToColor(color));
		setWidth(fWidthValue.getValue());

	}
	
	@Override
	protected void doUnbindValue(GraphElement value) {
		fWidthValue.dispose();
		fFunctionValue.dispose();
		fWidthValue.dispose();
	}

}
