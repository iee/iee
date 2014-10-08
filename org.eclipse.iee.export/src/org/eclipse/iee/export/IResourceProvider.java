package org.eclipse.iee.export;

import java.io.IOException;
import java.io.OutputStream;

public interface IResourceProvider {

	void writeToStream(OutputStream zos) throws IOException;

}
