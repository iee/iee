package org.eclipse.iee.core.document.source;

public enum VariableType implements IVariableType {
	INT, DOUBLE, MATRIX, RANGE;

	@Override
	public String getJavaQualifiedName() {
		switch (this) {
		case DOUBLE:
			return "double";
		case INT:
			return "int";
		case MATRIX:
			return "Jama.Matrix";
		default:
			return null;
		}
	}

	@Override
	public IVariableType getMethodType(String name) {
		return null;
	}
}