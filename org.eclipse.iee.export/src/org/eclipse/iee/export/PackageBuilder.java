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

	private Map<String, PackageResourceProvider> resources = new HashMap<>();

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
			PackageResourceProvider packageResourceProvider) {
		resources.put(resourcePath, packageResourceProvider);
	}

	public void writeToStream(ZipOutputStream zos) throws IOException {
		ZipEntry manifestEntry = new ZipEntry("META-INF.MF");
		zos.putNextEntry(manifestEntry);
		zos.write("Manifest-Version: 1.0\r\n".getBytes());
		if (!Strings.isNullOrEmpty(bundleVersion)) {
			zos.write(("Bundle-Version: " + bundleVersion + "\r\n").getBytes());
		}
		if (!Strings.isNullOrEmpty(bundleName)) {
			zos.write(("name: " + bundleName + "\r\n").getBytes());
		}
		if (!Strings.isNullOrEmpty(bundleDescription)) {
			zos.write(("description: " + bundleDescription + "\r\n").getBytes());
		}
		zos.write("type: fixed".getBytes());
		zos.closeEntry();
		ZipEntry viewEntry = new ZipEntry("schema/view.json");
		zos.putNextEntry(viewEntry);
		OutputStreamWriter writer = new OutputStreamWriter(zos, Charsets.UTF_8);
		new Gson().toJson(ws, writer);
		writer.flush();
		zos.closeEntry();
		for (Entry<String, PackageResourceProvider> entry : resources
				.entrySet()) {
			String path = entry.getKey();
			PackageResourceProvider provider = entry.getValue();
			ZipEntry resourceEntry = new ZipEntry("img/" + path);
			zos.putNextEntry(resourceEntry);
			provider.writeToStream(zos);
			zos.closeEntry();
		}

	}

}
