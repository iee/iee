package org.eclipse.iee.web.store;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;

import org.eclipse.iee.web.document.Document;
import org.eclipse.iee.web.parser.DefaultDocumentParser;

public class DevDocumentStore implements IDocumentStore {

	private DefaultDocumentParser parser;

	public DevDocumentStore(DefaultDocumentParser parser) {
		this.parser = parser;
	}

	@Override
	public Document getDocument(String bundle, String name) throws IOException {
		InputStream resource = new FileInputStream(new File(bundle, "src/"
				+ name.replace(".", "/") + ".java"));
		return parser.parseDocument(resource);
	}

	@Override
	public ClassLoader getDocumentClassLoader(String bundle, String name) throws IOException {
		URLClassLoader classLoader = new URLClassLoader(new URL[] {new File(bundle, "bin").toURL()}, getClass().getClassLoader());
		return classLoader;
	}

	@Override
	public InputStream getResourceAsStream(String bundle, String document,
			String resource) throws IOException {
		return new FileInputStream(new File(new File(bundle, "pads"), resource));
	}

}
