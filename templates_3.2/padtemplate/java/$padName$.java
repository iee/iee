package $packageName$.pad;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.iee.editor.core.pad.Pad;

public class $padName$ extends Pad {

	private static final long serialVersionUID = 1L;
	
	public $padName$() {
		super();
	}

	@Override
	public void createPartControl(Composite parent) {
	}

	protected $padName$(String containerID) {
		super(containerID);
	}

	@Override
	public Pad copy() {
		return new $padName$();
	}

	@Override
	public void save() {
	}

	@Override
	public void unsave() {
	}
}