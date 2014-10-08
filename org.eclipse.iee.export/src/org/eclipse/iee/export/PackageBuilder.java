package org.eclipse.iee.export;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.eclipse.iee.export.model.Worksheet;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import com.google.gson.Gson;

public class PackageBuilder {

	private Worksheet ws;

	private Map<String, IResourceProvider> resources = new HashMap<>();

	private String bundleName;

	private String bundleVersion;

	private String bundleDescription;

	public PackageBuilder setWorksheet(Worksheet ws) {
		this.ws = ws;
		return this;
	}

	public PackageBuilder setBundleName(String bundleName) {
		this.bundleName = bundleName;
		return this;
	}

	public PackageBuilder setBundleVersion(String bundleVersion) {
		this.bundleVersion = bundleVersion;
		return this;
	}

	public PackageBuilder setBundleDescription(String bundleDescription) {
		this.bundleDescription = bundleDescription;
		return this;
	}

	public void addResource(String resourcePath,
			IResourceProvider packageResourceProvider) {
		resources.put(resourcePath, packageResourceProvider);
	}

	public void writeToStream(ZipOutputStream zos) throws IOException {
		for (Entry<String, IResourceProvider> entry : resources
				.entrySet()) {
			String path = entry.getKey();
			IResourceProvider provider = entry.getValue();
			ZipEntry resourceEntry = new ZipEntry(path);
			zos.putNextEntry(resourceEntry);
			provider.writeToStream(zos);
			zos.closeEntry();
		}

	}

}
