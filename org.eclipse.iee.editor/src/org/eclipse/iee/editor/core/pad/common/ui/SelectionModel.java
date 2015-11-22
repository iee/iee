package org.eclipse.iee.editor.core.pad.common.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.iee.core.document.text.ITextLocation;
import org.eclipse.iee.core.document.text.OffsetTextLocation;
import org.eclipse.iee.core.document.text.Span;
import org.eclipse.iee.core.document.text.Text;
import org.eclipse.iee.core.document.text.TextStyle;
import org.eclipse.iee.editor.core.container.EditorManager;
import org.eclipse.iee.editor.core.container.ITextEditor;
import org.eclipse.iee.editor.core.pad.common.text.IEditorLocation;
import org.eclipse.iee.editor.core.pad.common.text.ITextContainer;
import org.eclipse.iee.editor.core.pad.common.text.OffsetEditorLocation;
import org.eclipse.iee.editor.text.edit.ChangeStyleCtx;
import org.eclipse.iee.editor.text.edit.ChangeStyleVisitor;
import org.eclipse.iee.editor.text.edit.CompositeCommand;
import org.eclipse.iee.editor.text.edit.IEditCommand;
import org.eclipse.iee.editor.text.edit.ReplaceCtx;
import org.eclipse.iee.editor.text.edit.ReplaceVisitor;

import com.google.common.base.Optional;
import com.google.common.base.Verify;

public class SelectionModel {

	private IEditorLocation fStart;
	
	private IEditorLocation fEnd;
	
	private EditorManager fEditorManager;
	
	public SelectionModel(EditorManager editorManager) {
		fEditorManager = editorManager;
	}
	
	public SelectionModel(IEditorLocation start, IEditorLocation end) {
		this.fStart = start;
		this.fEnd = end;
	}

	public void select() {
		if (fStart == null || fEnd == null) {
			return;
		}
		ITextEditor<?> commonAncestor = findCommonAncestor(fStart.getEditor(), fEnd.getEditor());
		SelectionModel normalized = normalize();
		
		commonAncestor.selectBetween(normalized.getStart(), normalized.getEnd());
	}
	
	public SelectionModel normalize() {
		ITextEditor<?> commonAncestor = findCommonAncestor(fStart.getEditor(), fEnd.getEditor());
		ITextEditor<?> l = fStart.getEditor();
		while(l != commonAncestor && l.getParent().get() != commonAncestor) {
			l = l.getParent().get();
		}
		ITextEditor<?> r = fEnd.getEditor();
		while(r != commonAncestor && r.getParent().get() != commonAncestor) {
			r = r.getParent().get();
		}		
		List<ITextEditor<?>> children = commonAncestor.getChildren();
		IEditorLocation left;
		IEditorLocation right;
		if (children.indexOf(l) < children.indexOf(r)) {
			left = fStart;
			right = fEnd;
		} else if (children.indexOf(l) == children.indexOf(r) && fEnd.getOffset() > fStart.getOffset()) {
			left = fStart;
			right = fEnd;
		} else {
			left = fEnd;
			right = fStart;
		}
		return new SelectionModel(left, right);
	}
	
	public void unselect() {
		if (fStart == null || fEnd == null) {
			return;
		}
		ITextEditor<?> commonAncestor = findCommonAncestor(fStart.getEditor(), fEnd.getEditor());
		SelectionModel normalized = normalize();
		commonAncestor.unselectBetween(normalized.getStart(), normalized.getEnd());
	}
	
	public static ITextEditor<?> findCommonAncestor(ITextEditor<?> ll, ITextEditor<?> rr) {
		if (ll == rr) {
			return ll;
		}
		List<ITextEditor<?>> leftAncestors = new ArrayList<>();
		List<ITextEditor<?>> rightAncestors = new ArrayList<>();
		Optional<ITextEditor<?>> l = Optional.<ITextEditor<?>> of(ll);
		Optional<ITextEditor<?>> r = Optional.<ITextEditor<?>> of(rr);
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

	public void append(IEditorLocation end) {
		unselect();
		this.fEnd = end;
		select();
	}

	public void set(IEditorLocation textLocation) {
		unselect();
		this.fStart = this.fEnd = textLocation;
	}
	
	public void setEnd(IEditorLocation textLocation) {
		unselect();
		this.fEnd = textLocation;
		select();
	}
	
	public IEditorLocation getStart() {
		return fStart;
	}

	public IEditorLocation getEnd() {
		return fEnd;
	}

	public IEditorLocation replace(String text) {
		Verify.verifyNotNull(fStart);
		Verify.verifyNotNull(fEnd);
		SelectionModel normalized = normalize();
		
		ITextLocation modelStart = new OffsetTextLocation((Text) normalized.getStart().getEditor().getModel(), normalized.getStart().getOffset());
		ITextLocation modelEnd = new OffsetTextLocation((Text) normalized.getEnd().getEditor().getModel(), normalized.getEnd().getOffset());
		CompositeCommand accept = modelStart.findCommonAncestor(modelEnd).accept(new ReplaceVisitor(), new ReplaceCtx(modelStart, modelEnd, text));
		accept.perform();
		modelEnd = accept.adjust(modelEnd);
		return new OffsetEditorLocation((ITextContainer<?>) normalized.getEnd().getEditor(), modelEnd.getOffset());
	}
	
	public void applyStyle(final StyleProcessor styleProcessor) {
		Verify.verifyNotNull(fStart);
		Verify.verifyNotNull(fEnd);
		SelectionModel normalized = normalize();
		
		ITextLocation modelStart = new OffsetTextLocation((Text) normalized.getStart().getEditor().getModel(), normalized.getStart().getOffset());
		ITextLocation modelEnd = new OffsetTextLocation((Text) normalized.getEnd().getEditor().getModel(), normalized.getEnd().getOffset());
		CompositeCommand accept = modelStart.findCommonAncestor(modelEnd).accept(new ChangeStyleVisitor(), new ChangeStyleCtx(modelStart, modelEnd) {
			@Override
			protected IEditCommand do_(final Span span) {
				return new IEditCommand() {
					
					@Override
					public void perform() {
						styleProcessor.apply(span.getStyle());
					}
					
					@Override
					public ITextLocation adjust(ITextLocation location) {
						return location;
					}
				};
				
			}
		});
		accept.perform();
		
		modelStart = accept.adjust(modelStart);
		modelEnd = accept.adjust(modelEnd);
		
		fStart = new OffsetEditorLocation((ITextContainer<?>) fEditorManager.getEditorByModel(modelStart.getModel()), modelStart.getOffset());
		fEnd = new OffsetEditorLocation((ITextContainer<?>) fEditorManager.getEditorByModel(modelEnd.getModel()), modelEnd.getOffset());
		
		select();
		
	}

	
	public boolean isEmpty() {
		return fStart.getEditor() == fEnd.getEditor() && fStart.getOffset() == fEnd.getOffset();
	}

	public static interface StyleProcessor {
		
		void apply(TextStyle style);
		
	}

	public TextStyle getStyle() {
		SelectionModel normalized = normalize();
		Text model = (Text) normalized.getStart().getEditor().getModel();
		return model.getStyle();
	}
	
}
