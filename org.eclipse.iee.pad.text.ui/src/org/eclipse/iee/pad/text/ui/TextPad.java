package org.eclipse.iee.pad.text.ui;

import java.io.StringWriter;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.iee.core.document.text.Document;
import org.eclipse.iee.core.document.text.INode;
import org.eclipse.iee.core.document.text.NodeVisitor;
import org.eclipse.iee.core.document.text.Text;
import org.eclipse.iee.core.document.text.TextStyle;
import org.eclipse.iee.editor.core.bindings.ObservableProperty;
import org.eclipse.iee.editor.core.container.Container;
import org.eclipse.iee.editor.core.container.TextRenderCtx;
import org.eclipse.iee.editor.core.pad.FigurePad;
import org.eclipse.iee.editor.core.pad.common.text.IEditorLocation;
import org.eclipse.iee.editor.core.pad.common.ui.IMenuContributor;
import org.eclipse.iee.editor.core.pad.common.ui.SelectionModel;
import org.eclipse.iee.editor.core.pad.common.ui.SelectionModel.StyleProcessor;
import org.eclipse.iee.pad.text.TextPart;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Shell;

import com.google.common.base.Optional;

public class TextPad extends FigurePad<TextPart, Figure> implements IMenuContributor {

	private ImageDescriptor iBold;
	private ImageDescriptor iFont;
	private ImageDescriptor iItalic;
	private ImageDescriptor iCopy;
	private ImageDescriptor iPaste;
	private ImageDescriptor iTextForeground;
	private ImageDescriptor iTextBackground;

	private Optional<ObservableProperty<Document>> fRoot;

	private DocumentEditor fDocumentEditor;
	
	private TextRenderCtx fRenderCtx;
	
	public TextPad(TextRenderCtx renderContext) {
		fRenderCtx = renderContext;
		fDocumentEditor = new DocumentEditor(renderContext);
		addEditor(fDocumentEditor);
	}
	
	@Override
	public void attachContainer(Container container) {
		super.attachContainer(container);
	}
	
	@Override
	public void doBindValue(TextPart value) {
		fRoot = Optional.of(new ObservableProperty<Document>(value, "root", Document.class));
		fDocumentEditor.setValue(fRoot);
	}
	
	@Override
	protected void doUnbindValue(TextPart value) {
		if (fRoot.isPresent()) {
			fRoot.get().dispose();
		}
	}

	@Override
	public void contribute(MenuManager menuManager) {
		Action cutItem = new Action("Cut", SWT.PUSH) {
			@Override
			public void run() {
				
			}
		};
		cutItem.setImageDescriptor(iCopy);
		cutItem.setAccelerator(SWT.MOD1 | 'x');
		menuManager.add(cutItem);

		Action copyItem = new Action("Copy", SWT.PUSH) {
			@Override
			public void run() {
				
			}
		};
		copyItem.setImageDescriptor(iCopy);
		copyItem.setAccelerator(SWT.MOD1 | 'c');
		menuManager.add(copyItem);

		Action pasteItem = new Action("Paste", SWT.PUSH) {
			@Override
			public void run() {
				
			}
		};
		pasteItem.setImageDescriptor(iPaste);
		pasteItem.setAccelerator(SWT.MOD1 | 'v');
		menuManager.add(pasteItem);
		
		menuManager.add(new Separator());
		
		Action fontItem = new Action("Font", SWT.PUSH) {
			@Override
			public void run() {
				FontDialog dlg = new FontDialog(getContainer().getContainerManager().getShell());
				SelectionModel selectionModel = getContainer().getContainerManager().getSelectionModel();
				TextStyle style = selectionModel.getStyle();
				Font font = fRenderCtx.getFont(Optional.of(style));
				FontData[] fontData = font.getFontData();
				dlg.setFontList(fontData);
				Optional<Color> foreground = fRenderCtx.getForeground(Optional.of(style));
				if (foreground.isPresent()) {
					dlg.setRGB(foreground.get().getRGB());
				}

				if (dlg.open() != null) {
					final FontData[] fontList = dlg.getFontList();
					final RGB rgb = dlg.getRGB();
					selectionModel.applyStyle(new StyleProcessor() {
						@Override
						public void apply(TextStyle style) {
							style.setFont(fontList[0].getName());
							style.setFontSize(fontList[0].getHeight());

							if (rgb != null) {
								style.setFgColor(new java.awt.Color(rgb.red, rgb.green, rgb.blue));
							}
						}
					});
				}
			}
		};
		fontItem.setImageDescriptor(iFont);
		menuManager.add(fontItem);
		
		Action boldItem = new Action("Bold", SWT.PUSH) {
			@Override
			public void run() {
				SelectionModel selectionModel = getContainer().getContainerManager().getSelectionModel();
				TextStyle style = selectionModel.getStyle();
				final boolean newV = !style.isBold().or(false);
				selectionModel.applyStyle(new StyleProcessor() {
					@Override
					public void apply(TextStyle style) {
						style.setBold(newV);
					}
				});
			}
		};
		boldItem.setImageDescriptor(iBold);
		menuManager.add(boldItem);
		
		Action italicItem = new Action("Italic", SWT.PUSH) {
			@Override
			public void run() {
				SelectionModel selectionModel = getContainer().getContainerManager().getSelectionModel();
				TextStyle style = selectionModel.getStyle();
				final boolean newV = !style.isItalic().or(false);
				selectionModel.applyStyle(new StyleProcessor() {
					@Override
					public void apply(TextStyle style) {
						style.setItalic(newV);
					}
				});
			}
		};
		italicItem.setImageDescriptor(iItalic);
		menuManager.add(italicItem);
		
		Action foregroundItem = new Action("Text Foreground", SWT.PUSH) {
			@Override
			public void run() {
				SelectionModel selectionModel = getContainer().getContainerManager().getSelectionModel();
				TextStyle style = selectionModel.getStyle();
				Optional<java.awt.Color> fgColor = style.getFgColor();
				Shell shell = getContainer().getContainerManager().getShell();
				ColorDialog dialog = new ColorDialog(shell);
				RGB rgb = null;
				if (fgColor.isPresent()) {
					rgb = new RGB(fgColor.get().getRed(), fgColor.get().getGreen(), fgColor.get().getBlue());
					dialog.setRGB(rgb);
				}
				final RGB newRgb = dialog.open();
				if (newRgb == null) return;
				if (!newRgb.equals(rgb)) {
					selectionModel.applyStyle(new StyleProcessor() {
						@Override
						public void apply(TextStyle style) {
							style.setFgColor(new java.awt.Color(newRgb.red, newRgb.green, newRgb.blue));
						}
					});
				}
			}
		};
		foregroundItem.setImageDescriptor(iTextForeground);
		menuManager.add(foregroundItem);
		
		Action backgroundItem = new Action("Text Background", SWT.PUSH) {
			@Override
			public void run() {
				SelectionModel selectionModel = getContainer().getContainerManager().getSelectionModel();
				TextStyle style = selectionModel.getStyle();
				Optional<java.awt.Color> bgColor = style.getBgColor();
				Shell shell = getContainer().getContainerManager().getShell();
				ColorDialog dialog = new ColorDialog(shell);
				RGB rgb = null;
				if (bgColor.isPresent()) {
					rgb = new RGB(bgColor.get().getRed(), bgColor.get().getGreen(), bgColor.get().getBlue());
					dialog.setRGB(rgb);
				}
				final RGB newRgb = dialog.open();
				if (newRgb == null) return;
				if (!newRgb.equals(rgb)) {
					selectionModel.applyStyle(new StyleProcessor() {
						@Override
						public void apply(TextStyle style) {
							style.setBgColor(new java.awt.Color(newRgb.red, newRgb.green, newRgb.blue));
						}
					});
				}
			}
		};
		backgroundItem.setImageDescriptor(iTextBackground);
		menuManager.add(backgroundItem);
		
	}
	
	@Override
	public void activate() {
	}

	@Override
	public void deactivate() {
		getContainer().updateDocument();
	}
	
	@Override
	public String getType() {
		return "Text";
	}

	void initResources() {
		iFont= loadImage(Display.getDefault(), "font_big.ico"); 
		iBold = loadImage(Display.getDefault(), "bold.ico"); 
		iItalic = loadImage(Display.getDefault(), "italic.ico");
		iCopy = loadImage(Display.getDefault(), "copy.ico"); 
		iPaste = loadImage(Display.getDefault(), "paste.ico"); 
		iTextForeground = loadImage(Display.getDefault(), "textForeground.ico"); 
		iTextBackground = loadImage(Display.getDefault(), "textBackground.ico"); 
	}
	
	private ImageDescriptor loadImage(Display display, String fileName) {
		return ImageDescriptor.createFromURL(TextPad.class.getClassLoader().getResource("/icons/" + fileName));
	}
	
	@Override
	public String getTex() {
		return rootToString(this.getDocumentPart().getRoot()).replaceAll(" ", " \\\\ ")
				.replaceAll("\r\n", " \\\\\\\\ ")
				.replaceAll("\t", " \\\\quad ");
	}
	
	public String rootToString(Document root) {
		final StringWriter sw = new StringWriter();
		root.traverse(new NodeVisitor() {
			
			@Override
			public void tail(INode node) {
			}
			
			@Override
			public void head(INode node) {
				if (node instanceof Text) {
					sw.append(((Text) node).getText());
				}
			}
		});
		
		return sw.toString();
	}
	
    public static java.awt.Color toAwtColor(Color color) { 
        return new java.awt.Color(color.getRed(), color.getGreen(),  
                color.getBlue()); 
    } 
     
    public static Color toSwtColor(Device device, java.awt.Paint paint) { 
        java.awt.Color color; 
        if (paint instanceof java.awt.Color) { 
            color = (java.awt.Color) paint; 
        } 
        else { 
            try { 
                throw new Exception("only color is supported at present... "  
                        + "setting paint to uniform black color" ); 
            }  
            catch (Exception e) { 
                e.printStackTrace(); 
                color = new java.awt.Color(0, 0, 0); 
            } 
        } 
        return new org.eclipse.swt.graphics.Color(device, 
                color.getRed(), color.getGreen(), color.getBlue()); 
    }

	@Override
	protected Figure createFigure() {
		Figure figure = new Figure();
		figure.setLayoutManager(new ToolbarLayout());
		figure.add(fDocumentEditor.getView().getWrapped(IFigure.class), BorderLayout.CENTER);
		return figure;
	}
	
	@Override
	public Optional<IEditorLocation> getTextLocation(int x, int y) {
		return getStart();
	}
	
}
