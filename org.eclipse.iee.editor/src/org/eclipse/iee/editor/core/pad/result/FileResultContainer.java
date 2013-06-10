package org.eclipse.iee.editor.core.pad.result;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class FileResultContainer implements IResultContainer {

	private String storagePath;
	
	public FileResultContainer() {
		this("pads/runtime");
	}
	
	public FileResultContainer(String storagePath) {
		super();
		this.storagePath = storagePath;
	}

	@Override
	public void putResult(String padId, String result) {
		OutputStream os = null;
		try {
			File file = getFile(padId);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			os = new FileOutputStream(file);
			os.write(result.toString().getBytes(Charset.forName("utf-8")));
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
				}
			}
		}
	}

	private File getFile(String padId) {
		return new File(storagePath, padId);
	}

	@Override
	public String getResult(String padId) {
		InputStream is = null;
		try {
			File file = getFile(padId);
			if (!file.exists()) {
				return null;
			}
			is = new FileInputStream(file);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			int b;
			while ((b = is.read()) != -1) {
				bos.write(b);
			}
			return new String(bos.toByteArray(), Charset.forName("utf-8"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}
		}
	}

}
