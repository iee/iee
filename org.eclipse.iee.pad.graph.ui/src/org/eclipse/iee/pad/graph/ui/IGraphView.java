package org.eclipse.iee.pad.graph.ui;

import org.eclipse.draw2d.FocusListener;
import org.eclipse.draw2d.IFigure;

public interface IGraphView {

	void addElement(IFigure elementComposite);

	String getVarsText();

	void setMinXText(String string);

	void setVarsText(String string);

	void setMaxXText(String string);

	void setMinYText(String string);

	void setMaxYText(String string);

	void addMinXFocusListener(FocusListener focusListener);

	String getMinXText();

	void addMaxXFocusListener(FocusListener focusListener);

	String getMaxXText();

	void addMinYFocusListener(FocusListener focusListener);

	String getMinYText();

	void addMaxYFocusListener(FocusListener focusListener);

	String getMaxYText();

}
