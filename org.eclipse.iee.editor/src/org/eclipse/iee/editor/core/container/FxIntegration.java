package org.eclipse.iee.editor.core.container;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.IntBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.PaletteData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.sun.glass.ui.Application;
import com.sun.javafx.application.PlatformImpl;
import com.sun.javafx.cursor.CursorFrame;
import com.sun.javafx.embed.AbstractEvents;
import com.sun.javafx.embed.EmbeddedSceneInterface;
import com.sun.javafx.embed.EmbeddedStageInterface;
import com.sun.javafx.embed.HostInterface;
import com.sun.javafx.stage.EmbeddedWindow;

import javafx.scene.Scene;

@SuppressWarnings("restriction")
public class FxIntegration {

    private EmbeddedStageInterface stagePeer;
    
    private EmbeddedSceneInterface scenePeer;
	
    private HostInterface hostInterface;

	private EmbeddedWindow stage;

	private Scene scene;
    
    private int pWidth = 0;
    
    private int pHeight = 0;
    
    private volatile int pPreferredWidth = -1;
    
    private volatile int pPreferredHeight = -1;
    
    private IntBuffer pixelsBuf = null;

	private Canvas canvas;
	
    private static Field windowField;
    
    private static Method windowMethod;
    
    private static Method screenMethod;
    
    private static Method backingScaleFactorMethod;
    
    static {
        if (SWT.getPlatform().equals("cocoa")) {
            try {
                windowField = Shell.class.getDeclaredField("window");
                windowField.setAccessible(true);

                Class nsViewClass = Class.forName("org.eclipse.swt.internal.cocoa.NSView");            
                windowMethod = nsViewClass.getDeclaredMethod("window");
                windowMethod.setAccessible(true);

                Class nsWindowClass = Class.forName("org.eclipse.swt.internal.cocoa.NSWindow");
                screenMethod = nsWindowClass.getDeclaredMethod("screen");
                screenMethod.setAccessible(true);

                Class nsScreenClass = Class.forName("org.eclipse.swt.internal.cocoa.NSScreen");
                backingScaleFactorMethod = nsScreenClass.getDeclaredMethod("backingScaleFactor");
                backingScaleFactorMethod.setAccessible(true);
            } catch (Exception e) {
            }
        }
    }
	
	public FxIntegration(Canvas canvas) {
		this.canvas = canvas;
		hostInterface = new DefaultHostInterface(canvas);
		initFx();
		registerListeners(canvas);
	}
	
    private void registerListeners(Canvas canvas) {
        canvas.addPaintListener(pe -> {
            paintControl(pe);
        });
        
        canvas.addControlListener(new ControlListener() {
            @Override
            public void controlMoved(ControlEvent ce) {
                sendMoveEventToFX();
            }
            @Override
            public void controlResized(ControlEvent ce) {
                sendResizeEventToFX();
            }
        });
	}

	private static void initFx() {
        AccessController.doPrivileged((PrivilegedAction<Void>) () -> {
            System.setProperty("javafx.embed.isEventThread", "true");
            System.setProperty("glass.win.uiScale", "100%");
            System.setProperty("glass.win.renderScale", "100%");
            return null;
        });
        Map map = Application.getDeviceDetails();
        if (map == null) {
            Application.setDeviceDetails(map = new HashMap<>());
        }
        if (map.get("javafx.embed.eventProc") == null) {
            long eventProc = 0;
            try {
                Field field = Display.class.getDeclaredField("eventProc");
                field.setAccessible(true);
                if (field.getType() == int.class) {
                    eventProc = field.getLong(Display.getDefault());
                } else {
                    if (field.getType() == long.class) {
                        eventProc = field.getLong(Display.getDefault());
                    }
                }
            } catch (Throwable th) {
                //Fail silently
            }
            map.put("javafx.embed.eventProc", eventProc);
        }
        // Note that calling PlatformImpl.startup more than once is OK
        PlatformImpl.startup(() -> {
            Application.GetApplication().setName(Display.getAppName());
        });
    }
	
    public void setScene(final Scene newScene) {
        if ((stage == null) && (newScene != null)) {
            stage = new EmbeddedWindow(hostInterface);
            stage.show();
        }
        scene = newScene;
        if (stage != null) {
            stage.setScene(newScene);
        }
        if ((stage != null) && (newScene == null)) {
            stage.hide();
            stage = null;
        }
    }
    
    private void sendMoveEventToFX() {
        if ((stagePeer == null) /*|| !isShowing()*/) {
            return;
        }
        Rectangle rect = canvas.getClientArea();
        Point los = canvas.toDisplay(rect.x, rect.y);
        stagePeer.setLocation(los.x, los.y);
    }
    
    private void sendResizeEventToFX() {
        canvas.redraw();
        canvas.update();
        
        pWidth = canvas.getClientArea().width;
        pHeight = canvas.getClientArea().height;

        resizePixelBuffer(lastScaleFactor);

        if (scenePeer == null) {
            return;
        }

        stagePeer.setSize(pWidth, pHeight);
        scenePeer.setSize(pWidth, pHeight);
    }

	private class DefaultHostInterface implements HostInterface {

		private Canvas canvas;
		
		public DefaultHostInterface(Canvas canvas) {
			this.canvas = canvas;
		}

		@Override
		public void setEmbeddedStage(EmbeddedStageInterface embeddedStage) {
            stagePeer = embeddedStage;
            if (stagePeer == null) {
                return;
            }
            if (pWidth > 0 && pHeight > 0) {
                stagePeer.setSize(pWidth, pHeight);
            }
            if (canvas.isFocusControl()) {
                stagePeer.setFocused(true, AbstractEvents.FOCUSEVENT_ACTIVATED);
            }
            sendMoveEventToFX();
            sendResizeEventToFX();
		}
		
		@Override
		public void setEmbeddedScene(EmbeddedSceneInterface embeddedScene) {
            scenePeer = embeddedScene;
            if (scenePeer == null) {
                return;
            }
            if (pWidth > 0 && pHeight > 0) {
                scenePeer.setSize(pWidth, pHeight);
            }
            double scaleFactor = getScaleFactor();
            resizePixelBuffer(scaleFactor);
            lastScaleFactor = scaleFactor;
            scenePeer.setPixelScaleFactor((float)scaleFactor);
//            scenePeer.setDragStartListener((fxDragSource, dragAction) -> {
//                Platform.runLater(() -> {
//                    DragSource dragSource = createDragSource(fxDragSource, dragAction);
//                    if (dragSource == null) {
//                        fxDragSource.dragDropEnd(null);
//                    } else {
//                        updateDropTarget();
//                        FXCanvas.this.notifyListeners(SWT.DragDetect, null);
//                    }
//                });
//            });
            //Force the old drop target to be disposed before creating a new one
//            setDropTarget(null);
//            setDropTarget(createDropTarget(embeddedScene));
		}

		@Override
		public boolean requestFocus() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean traverseFocusOut(boolean forward) {
			// TODO Auto-generated method stub
			return false;
		}

		Lock lock = new ReentrantLock();
		boolean queued = false;
		@Override
        public void repaint() {
			lock.lock();
			try {
				if (queued) {
					return;
				}
                queued = true;
                Display.getDefault().asyncExec(() -> {
                    try {
                        if (canvas.isDisposed()) {
                        	return;
                        }
                        canvas.redraw();
                    } finally {
                    	lock.lock();
                    	try {
                    		queued = false;
	                    } finally {
	        				lock.unlock();
	        			}
                    }
                });
				
			} finally {
				lock.unlock();
			}
        }

		@Override
		public void setPreferredSize(int width, int height) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setEnabled(boolean enabled) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setCursor(CursorFrame cursorFrame) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean grabFocus() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void ungrabFocus() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
    private double lastScaleFactor = 1.0;
    private int lastWidth, lastHeight;
    private IntBuffer lastPixelsBuf = null;
    private void paintControl(PaintEvent pe) {
        if ((scenePeer == null) || (pixelsBuf == null)) {
            return;
        }

        double scaleFactor = getScaleFactor();
        if (lastScaleFactor != scaleFactor) {
            resizePixelBuffer(scaleFactor);
            lastScaleFactor = scaleFactor;
            scenePeer.setPixelScaleFactor((float)scaleFactor);
        }

        // if we can't get the pixels, draw the bits that were there before
        IntBuffer buffer = pixelsBuf;
        int width = pWidth, height = pHeight;
        if (scenePeer.getPixels(pixelsBuf, pWidth, pHeight)) {
            width = lastWidth = pWidth;
            height = lastHeight = pHeight;
            buffer = lastPixelsBuf = pixelsBuf;
        } else {
            if (lastPixelsBuf == null) return;
            width = lastWidth;
            height = lastHeight;
            buffer = lastPixelsBuf;
        }
        width = (int)Math.round(width * scaleFactor);
        height = (int)Math.round(height * scaleFactor);

        ImageData imageData = null;
        if ("win32".equals(SWT.getPlatform())) {
            PaletteData palette = new PaletteData(0xFF00, 0xFF0000, 0xFF000000);
            int scanline = width * 4;
            byte[] dstData = new byte[scanline * height];
            int[] srcData = buffer.array();
            int dp = 0, sp = 0;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int p = srcData[sp++];
                    dstData[dp++] = (byte) (p & 0xFF); //dst:blue
                    dstData[dp++] = (byte)((p >> 8) & 0xFF); //dst:green
                    dstData[dp++] = (byte)((p >> 16) & 0xFF); //dst:green
                    dstData[dp++] = (byte)0x00; //alpha
                }
            }
            imageData = new ImageData(width, height, 32, palette, 4, dstData);
        } else {
            if (width * height > buffer.array().length) {
                System.err.println("FXCanvas.paintControl: scale mismatch!");
                return;
            }
            PaletteData palette = new PaletteData(0x00ff0000, 0x0000ff00, 0x000000ff);
            imageData = new ImageData(width, height, 32, palette);
            imageData.setPixels(0, 0,width * height, buffer.array(), 0);
        }
        imageData.alphaData = new byte[imageData.width * imageData.height];
        int[] srcData = buffer.array();
        int p = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pix = srcData[p];
                imageData.alphaData[p] = (byte)((pix >> 24) & 0xFF);
                p += 1;
            }
        }
        
        Image image = new Image(Display.getDefault(), imageData);
        
        pe.gc.setClipping((Rectangle) null);
        System.out.println(width + "; " + height + "; " + pWidth + "; " + pHeight + "; ");
        System.out.println(pe.gc.getClipping());
        pe.gc.drawImage(image, 0, 0, width, height, 0, 0, pWidth, pHeight);
        image.dispose();
    }
    
    private double getScaleFactor() {
        if (SWT.getPlatform().equals("cocoa")) {
            if (windowField == null || screenMethod == null || backingScaleFactorMethod == null) {
                return 1.0;
            }
            try {
                Object nsWindow = windowField.get(canvas.getShell());
                Object nsScreen = screenMethod.invoke(nsWindow);
                Object bsFactor = backingScaleFactorMethod.invoke(nsScreen);
                return ((Double) bsFactor).doubleValue();
            } catch (Exception e) {
                // FAIL silently should the reflection fail
            }
        }
        return 1.0;
    }
    
    private void resizePixelBuffer(double newScaleFactor) {
        lastPixelsBuf = null;
        if ((pWidth <= 0) || (pHeight <= 0)) {
            pixelsBuf = null;
        } else {
            pixelsBuf = IntBuffer.allocate((int)Math.round(pWidth * newScaleFactor) *
                                           (int)Math.round(pHeight * newScaleFactor));            
            // The bg color may show through on resize. See RT-34380.
            RGB rgb = canvas.getBackground().getRGB();
            Arrays.fill(pixelsBuf.array(), rgb.red << 16 | rgb.green << 8 | rgb.blue);
        }
    }
	
}
