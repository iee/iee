package org.eclipse.iee.pad.formula.ui;

import java.util.LinkedList;

import org.eclipse.iee.editor.core.container.RenderCtx;

public class EditorVisitorContext {

	private LinkedList<RenderCtx> renderCtxStack = new LinkedList<>();

	private final RenderCtx defaultRenderCtx;

	public EditorVisitorContext(RenderCtx defaultRenderCtx) {
		super();
		this.defaultRenderCtx = defaultRenderCtx;
	}

	public void pushRenderCtx(RenderCtx renderCtx) {
		renderCtxStack.push(renderCtx);
	}
	
	public void popRenderCtx() {
		renderCtxStack.pop();
	}
	
	public RenderCtx getRenderCtx() {
		return renderCtxStack.size() > 0 ? renderCtxStack.peek() : defaultRenderCtx;
	}
	
}