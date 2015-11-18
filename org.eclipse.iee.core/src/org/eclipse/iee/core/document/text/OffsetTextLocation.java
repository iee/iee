package org.eclipse.iee.core.document.text;

import java.util.ArrayList;
import java.util.List;

public class OffsetTextLocation implements ITextLocation {

	private Text fText;
	
	private int fOffset;
	
	public OffsetTextLocation(Text text, int offset) {
		super();
		fText = text;
		fOffset = offset;
	}

	@Override
	public Text getModel() {
		return fText;
	}

	@Override
	public int getOffset() {
		return fOffset;
	}

	@Override
	public INode findCommonAncestor(ITextLocation to) {
		if (fText == to.getModel()) {
			return fText;
		}
		List<INode> leftAncestors = new ArrayList<>();
		List<INode> rightAncestors = new ArrayList<>();
		INode l = fText;
		INode r = to.getModel();
		while (l != null) {
			leftAncestors.add(l);
			l = l.getParent();
		}
		while (r != null) {
			rightAncestors.add(r);
			r = r.getParent();
		}
		int il = leftAncestors.size() - 1;
		int ir = rightAncestors.size() - 1;
		do {
			if (leftAncestors.get(il) != rightAncestors.get(ir)) {
				break;
			}
			il--;
			ir--;
		} while (il >= 0 && ir >= 0);

		return leftAncestors.get(il + 1);
	}

}
