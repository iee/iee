package org.eclipse.iee.core.document.writer;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.iee.core.HandlerManager;
import org.eclipse.iee.core.document.PadDocumentPart;
import org.eclipse.iee.core.document.parser.DocumentStructureConfig;
import org.eclipse.iee.core.document.source.ISourceGenerator;
import org.eclipse.iee.core.document.source.ISourceGeneratorContext;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

@Component
public class DefaultDocumentWriter implements IDocumentWriter {

	private final HandlerManager<IPadWriter> fWritersManager = new HandlerManager<>(IPadWriter.class);
	
	private final HandlerManager<ISourceGenerator> fSourceGeneratorsManager = new HandlerManager<>(ISourceGenerator.class);
	
	public DefaultDocumentWriter() {
	}
	
	@Reference(cardinality = ReferenceCardinality.MULTIPLE, unbind = "unregisterPadWriter", policy = ReferencePolicy.DYNAMIC)
	public void registerPadWriter(IPadWriter parser) {
		fWritersManager.registerHandler(parser);
	}
	
	public void unregisterPadWriter(IPadWriter parser) {
		fWritersManager.unregisterHandler(parser);
	}
	
	@Reference(cardinality = ReferenceCardinality.MULTIPLE, unbind = "unregisterSourceGenerator", policy = ReferencePolicy.DYNAMIC)
	public void registerSourceGenerator(ISourceGenerator generator) {
		fSourceGeneratorsManager.registerHandler(generator);
	}
	
	public void unregisterSourceGenerator(ISourceGenerator generator) {
		fSourceGeneratorsManager.unregisterHandler(generator);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.iee.core.document.writer.IDocumentWriter#getWriterSupport(T)
	 */
	@Override
	public <T extends PadDocumentPart> IPadWriter<T> getWriterSupport(T partType) {
		return fWritersManager.getHandler(partType.getClass());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.iee.core.document.writer.IDocumentWriter#getSourceGenerator(T)
	 */
	@Override
	public <T extends PadDocumentPart> ISourceGenerator<T> getSourceGenerator(T part) {
		return fSourceGeneratorsManager.getHandler(part.getClass());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.iee.core.document.writer.IDocumentWriter#getPrologue()
	 */
	@Override
	public String getPrologue() {
		return DocumentStructureConfig.EMBEDDED_REGION_BEGIN;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.iee.core.document.writer.IDocumentWriter#getEpilogue()
	 */
	@Override
	public String getEpilogue() {
		return DocumentStructureConfig.EMBEDDED_REGION_END;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.iee.core.document.writer.IDocumentWriter#writeInternalsToString(org.eclipse.iee.core.document.PadDocumentPart, org.eclipse.iee.core.document.source.ISourceGeneratorContext)
	 */
	@Override
	public String writeInternalsToString(PadDocumentPart part, ISourceGeneratorContext context) {
		
		IPadWriter<PadDocumentPart> writerSupport = getWriterSupport(part);

		/* Container ID */
		StringBuilder payload = new StringBuilder();

		payload.append(writerSupport.getType());
		Map<String, String> padParams = new HashMap<>(writerSupport.getParams(part));
		padParams.put("id", part.getId());
		if (padParams.size() > 0) {
			payload.append('(');
			boolean isFirst = true;
			for (Entry<String, String> entry : padParams.entrySet()) {
				if (!isFirst) {
					payload.append(",");
				}
				payload.append('"');
				payload.append(entry.getKey().replace("\"", "\\\""));
				payload.append("\"=\"");
				if (entry.getValue() != null) {
					payload.append(entry.getValue().replace("\"", "\\\""));
				}
				payload.append('"');
				isFirst = false;
			}
			payload.append(')');
		}
		String value = writerSupport.getValue(part);
		if (value != null && value.length() > 0) {
			payload.append(':').append(value);
		}
		
		ISourceGenerator<PadDocumentPart> sourceGenerator = getSourceGenerator(part);
		if (sourceGenerator != null) {
			String textContent = sourceGenerator.getSource(part, context);
			if (textContent != null && !textContent.isEmpty()) {
				/* Payload if exists */
	
				payload.append(DocumentStructureConfig.INNER_TEXT_BEGIN);
	
				String[] lines = textContent.split("\n");
				for (int i = 0; i < lines.length - 1; i++) {
					payload.append(lines[i].trim()).append(DocumentStructureConfig.INNER_TEXT_BR);
				}
				payload.append(lines[lines.length - 1]).append(
						DocumentStructureConfig.INNER_TEXT_END);
			}
		}
		return payload.toString();
	}


}
