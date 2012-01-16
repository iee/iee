package org.eclipse.iee.sample.output.pad;

import java.io.Serializable;

import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.sample.output.Activator;
import org.eclipse.iee.sample.output.console.ConsoleMessageEvent;
import org.eclipse.iee.sample.output.console.IConsoleMessageListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class OutputPad extends Pad implements Serializable {

	private static final long serialVersionUID = -5570698937452800023L;
	
	private Label fLabel;
	
	public OutputPad() {
		setType("Output Pad");
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
		Activator.getConsoleMessager().addConsoleMessageListener(new IConsoleMessageListener() {
			@Override
			public void messageReceived(ConsoleMessageEvent e) {
				System.out.println("Pad recieved message: " + e.getMessage());
				fLabel.setText(e.getMessage());				
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
}
