/**
 * 
 */
package org.eclipse.iee.pad.fem3d;

import org.eclipse.iee.core.document.source.ISourceGenerator;
import org.eclipse.iee.core.document.source.ISourceGeneratorContext;

/**
 * @author aefimchuk
 *
 */
public class Fem3DSourceGenerator implements ISourceGenerator<Fem3DPart> {

	@Override
	public String getSource(Fem3DPart part, ISourceGeneratorContext context) {
		String path = context.getStoragePath(); 

		String file = part.getId();
		
		StringBuilder generatedText = new StringBuilder();
		generatedText.append("try {");
		generatedText.append("String path = \"").append(path).append("\";");
		generatedText.append("String file = \"").append(file).append("\";");
		generatedText.append("com.ieecloud.viewer.Java3DViewer.print(").append(part.getModelVariable()).append(", file, path + \"_img\");");
		generatedText.append("	byte[] bar = org.apache.commons.io.FileUtils.readFileToByteArray(new File(path + \"/\" + file));");
		generatedText.append("String encoded = org.apache.commons.codec.binary.Base64.encodeBase64String(bar);");
		generatedText.append("org.eclipse.iee.core.EvaluationContextHolder.putResult(\"").append(part.getId()).append("\", String.valueOf(variable))");
		generatedText.append("} catch (IOException e) {");
		generatedText.append("e.printStackTrace();");
		generatedText.append("}");
		return generatedText.toString();
	}

}
