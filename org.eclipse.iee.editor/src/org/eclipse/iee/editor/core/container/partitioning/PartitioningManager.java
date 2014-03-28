package org.eclipse.iee.editor.core.container.partitioning;

import org.eclipse.iee.core.document.parser.DocumentStructureConfig;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;

public class PartitioningManager {

	public final static String PARTITIONING_ID = "__iee_embedding_partitioning";
	
	/** Content type of embedded partition. */
	public final static String CONTENT_TYPE_EMBEDDED = "__embedded";

	/** Content type of plain text partition. */
	public final static String CONENT_TYPE_PLAINTEXT = "__plaintext";
	
	
	private final IDocument fDocument;
	private IDocumentPartitioner fDocumentPartitioner;
	private boolean disposed = false;
	
	public PartitioningManager(DocumentStructureConfig config, IDocument document) {
		fDocument = document;
		
		fDocumentPartitioner = new FastPartitioner(
			new PartitioningScanner(
				config.EMBEDDED_REGION_BEGIN, 
				config.EMBEDDED_REGION_END),
			new String[] { CONTENT_TYPE_EMBEDDED });
	
		fDocumentPartitioner.connect(fDocument);
		((IDocumentExtension3) fDocument).setDocumentPartitioner(
				PartitioningManager.PARTITIONING_ID, fDocumentPartitioner);
			
	}

	public void dispose() {
		if (!disposed) {
			((IDocumentExtension3) fDocument).setDocumentPartitioner(
					PartitioningManager.PARTITIONING_ID, null);
			fDocumentPartitioner.disconnect();
			fDocumentPartitioner = null;
			disposed = true;
		}
	}
}
