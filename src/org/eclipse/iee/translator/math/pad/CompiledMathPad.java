package org.eclipse.iee.translator.math.pad;

import java.io.Serializable;
import org.eclipse.iee.editor.core.pad.Pad;
import org.eclipse.iee.translator.math.FileStorage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;

public class CompiledMathPad extends Pad implements Serializable {

	private transient static FileStorage fFileStorage;

	private String fText;

	public CompiledMathPad() {
		super();
		fText = "";
	}

	@Override
	public void createPartControl(final Composite parent) {
		FillLayout layout = new FillLayout(SWT.HORIZONTAL);
		layout.marginHeight = 5;
		layout.marginWidth = 5;
		parent.setLayout(layout);
		final StyledText styledText = new StyledText(parent, SWT.NONE);
		styledText.setText(fText);
				
		styledText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				
				/*
				  Use this code:				  
				  
				  1) Create byte code 
				  		Compiler.compile(getContainerID(), styledText.getText());
				  
				  2) Update editor 
				  		getContainer().writeAtContainerRegionTail("Mole.eval(" + getContainerID() + ");");
				  
				 */
				
				//Mole.translateMath(styledText.getText());
				
				//getContainer().writeAtContainerRegionTail("System.out.println(Integer.toString(RunnableMath.math0()));");
			}
			
		});		
	}

	protected CompiledMathPad(String containerID) {
		super(containerID);
	}

	public static void setStorage(FileStorage fStorage) {
		CompiledMathPad.fFileStorage = fStorage;
	}

	@Override
	public Pad copy() {
		CompiledMathPad newPad = new CompiledMathPad();
		newPad.fText = this.fText;
		return newPad;
	}

	@Override
	public String getType() {
		return "CompiledMath";
	}

	// Save&Load operations, use it for serialization

	public void save() {
		CompiledMathPad.fFileStorage.saveToFile(this);
	}

	@Override
	public void unsave() {
		CompiledMathPad.fFileStorage.removeFile(getContainerID());
	}
}
