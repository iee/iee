package org.eclipse.iee.web.ui.store;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.iee.core.EvaluationContextHolder;
import org.eclipse.iee.core.document.Document;
import org.eclipse.iee.core.document.parser.DefaultDocumentParser;
import org.eclipse.iee.core.store.IDocumentStore;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;

public class DevDocumentStore implements IDocumentStore {

	private DefaultDocumentParser parser;

	private File root;
	
	public DevDocumentStore(File root, DefaultDocumentParser parser) {
		this.parser = parser;
		this.root = root;
	}

	@Override
	public Document getDocument(String bundle, String name) throws IOException {
		InputStream resource = new FileInputStream(new File(getBundlePath(bundle), "src/"
				+ name.replace(".", "/") + ".java"));
		return new Document(bundle, name, parser.parseDocument(resource));
	}

	@Override
	public Class<?> getDocumentClass(String bundle, String name) throws IOException, ClassNotFoundException {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(bundle);
		IJavaProject javaProject = JavaCore.create(project);
		try {
			String[] computeDefaultRuntimeClassPath = JavaRuntime.computeDefaultRuntimeClassPath(javaProject);
			List<URL> urls = new ArrayList<>();
			for (String iClasspathEntry : computeDefaultRuntimeClassPath) {
				urls.add(new File(iClasspathEntry).toURL());
			}
			URLClassLoader classLoader = new URLClassLoader((URL[]) urls.toArray(new URL[urls.size()]), EvaluationContextHolder.class.getClassLoader());
			return classLoader.loadClass(name);
		}  catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public InputStream getResourceAsStream(String bundle, String document,
			String resource) throws IOException {
		return new FileInputStream(new File(new File(getBundlePath(bundle), "pads"), resource));
	}

	private File getBundlePath(String bundle) {
		return new File(root, bundle);
	}

}
