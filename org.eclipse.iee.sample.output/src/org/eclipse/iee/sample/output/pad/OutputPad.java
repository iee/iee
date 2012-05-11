package org.eclipse.iee.sample.output.pad;

import java.io.Serializable;

import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.editor.core.utils.console.ConsoleMessageEvent;
import org.eclipse.iee.editor.core.utils.console.ConsoleMessager;
import org.eclipse.iee.editor.core.utils.console.IConsoleMessageListener;
import org.eclipse.iee.sample.output.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class OutputPad extends Pad implements Serializable {

	private static final long serialVersionUID = -5570698937452800023L;
	
	private Label fLabel;
	
	public OutputPad() {
	}

	@Override
	public void createPartControl(final Composite parent) {
		/* Initialize controls */
		FillLayout layout = new FillLayout(SWT.VERTICAL);
		parent.setLayout(layout);
		// It is hint operation now
		parent.setBackground(new Color(null, 255, 255, 255));
		
		fLabel = new Label(parent, SWT.WRAP | SWT.CENTER);
		fLabel.setText("Message");
		fLabel.setSize(300, 300);
		
		parent.pack();
				
		initLogic();
	}
	
	private void initLogic() {
		ConsoleMessager.getInstance().addConsoleMessageListener(new IConsoleMessageListener() {
			@Override
			public void messageReceived(ConsoleMessageEvent e) {
				fLabel.setText(e.getMessage());
			}

			@Override
			public String getRequesterID() {
				return "OutputPad";
			}
		});
	}

	@Override
	public Pad copy() {
		return new OutputPad();
	}

	@Override
	public void save() {
	}

	@Override
	public void unsave() {
	}

	@Override
	public void onContainerAttached() {
	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}
}
