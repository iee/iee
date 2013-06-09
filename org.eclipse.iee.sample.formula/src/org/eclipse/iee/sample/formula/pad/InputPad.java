package org.eclipse.iee.sample.formula.pad;

public class InputPad extends FormulaPad {

	
	@Override
	protected String generateCode() {
		if (fTranslatingExpression.length() == 0) {
			return "";
		}
		
		String[] expressions = fTranslatingExpression.split("=");
		
		String varName = expressions[0];
		Double varValue = Double.parseDouble(expressions[1]);
		
		StringBuilder sb = new StringBuilder();
		String storagePath = getContainer().getContainerManager().getStoragePath();
		sb.append("double ").append(varName).append(";");
		sb.append("File file = new File(\"").append(storagePath).append("/").append(getContainerID()).append("\");");
		sb.append("try {");
		sb.append(varName);
		sb.append("=");
		sb.append("Double.parseDouble(FileUtils.readFileToString(file));");
		sb.append("} catch(IOException e) {");
		sb.append("e.printStackTrace();");
		sb.append(varName).append("=").append(varValue).append("D;");
		sb.append("}");
		
		return sb.toString();
	}
	
	@Override
	public String getType() {
		return "Input";
	}
	
}
