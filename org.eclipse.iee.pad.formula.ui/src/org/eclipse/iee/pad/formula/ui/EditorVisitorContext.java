package org.eclipse.iee.pad.formula.ui;

import java.util.LinkedList;

import org.eclipse.iee.editor.core.container.TextRenderCtx;

public class EditorVisitorContext {

	private LinkedList<TextRenderCtx> renderCtxStack = new LinkedList<>();

	private final TextRenderCtx defaultRenderCtx;

	public EditorVisitorContext(TextRenderCtx defaultRenderCtx) {
		super();
		this.defaultRenderCtx = defaultRenderCtx;
	}

	public void pushRenderCtx(TextRenderCtx renderCtx) {
		renderCtxStack.push(renderCtx);
	}
	
	public void popRenderCtx() {
		renderCtxStack.pop();
	}
	
	public TextRenderCtx getRenderCtx() {
		return renderCtxStack.size() > 0 ? renderCtxStack.peek() : defaultRenderCtx;
	}
	
}