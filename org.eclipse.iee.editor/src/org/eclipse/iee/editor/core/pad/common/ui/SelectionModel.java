package org.eclipse.iee.editor.core.pad.common.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.iee.editor.core.container.ITextEditor;
import org.eclipse.iee.editor.core.pad.common.text.TextLocation;

import com.google.common.base.Optional;

public class SelectionModel {

	private TextLocation start;
	
	private TextLocation end;
	
	public void select() {
		if (start == null || end == null) {
			return;
		}
		ITextEditor<?, ?> commonAncestor = findCommonAncestor(start.getEditor(), end.getEditor());
		ITextEditor<?, ?> l = start.getEditor();
		while(l != commonAncestor && l.getParent().get() != commonAncestor) {
			l = l.getParent().get();
		}
		ITextEditor<?, ?> r = end.getEditor();
		while(r != commonAncestor && r.getParent().get() != commonAncestor) {
			r = r.getParent().get();
		}		
		List<ITextEditor<?, ?>> children = commonAncestor.getChildren();
		TextLocation left;
		TextLocation right;
		if (children.indexOf(l) < children.indexOf(r)) {
			left = start;
			right = end;
		} else {
			left = end;
			right = start;
		}
		
		commonAncestor.selectBetween(left, right);
	}
	
	public void unselect() {
		if (start == null || end == null) {
			return;
		}
		ITextEditor<?, ?> commonAncestor = findCommonAncestor(start.getEditor(), end.getEditor());
		ITextEditor<?, ?> l = start.getEditor();
		while(l != commonAncestor && l.getParent().get() != commonAncestor) {
			l = l.getParent().get();
		}
		ITextEditor<?, ?> r = end.getEditor();
		while(r != commonAncestor && r.getParent().get() != commonAncestor) {
			r = r.getParent().get();
		}		
		List<ITextEditor<?, ?>> children = commonAncestor.getChildren();
		TextLocation left;
		TextLocation right;
		if (children.indexOf(l) < children.indexOf(r)) {
			left = start;
			right = end;
		} else {
			left = end;
			right = start;
		}
		commonAncestor.unselectBetween(left, right);
	}
	
	public static ITextEditor<?, ?> findCommonAncestor(ITextEditor<?, ?> ll, ITextEditor<?, ?> rr) {
		if (ll == rr) {
			return ll;
		}
		List<ITextEditor<?, ?>> leftAncestors = new ArrayList<>();
		List<ITextEditor<?, ?>> rightAncestors = new ArrayList<>();
		Optional<ITextEditor<?, ?>> l = Optional.<ITextEditor<?, ?>> of(ll);
		Optional<ITextEditor<?, ?>> r = Optional.<ITextEditor<?, ?>> of(rr);
		while (l.isPresent()) {
			leftAncestors.add(l.get());
			l = l.get().getParent();
		}
		while (r.isPresent()) {
			rightAncestors.add(r.get());
			r = r.get().getParent();
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

	public void append(TextLocation end) {
		unselect();
		this.end = end;
		select();
	}

	public void set(TextLocation textLocation) {
		unselect();
		this.start = this.end = textLocation;
	}
	
	

}
