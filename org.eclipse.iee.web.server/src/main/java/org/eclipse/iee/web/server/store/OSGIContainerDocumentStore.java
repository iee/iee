/**
 * 
 */
package org.eclipse.iee.web.server.store;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import org.eclipse.iee.web.document.Document;
import org.eclipse.iee.web.parser.DefaultDocumentParser;
import org.eclipse.iee.web.store.IDocumentStore;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

import com.google.common.base.Throwables;

/**
 * @author Toxin
 * 
 */
public class OSGIContainerDocumentStore implements IDocumentStore {

	private Framework framework;

	private DefaultDocumentParser documentParser;

	private Thread watchThread;
	
	public OSGIContainerDocumentStore(String folder, DefaultDocumentParser documentParser) {
		this.documentParser = documentParser;
		
		
		FrameworkFactory frameworkFactory = ServiceLoader.load(FrameworkFactory.class).iterator().next();
		Map<String, String> config = new HashMap<String, String>();
		config.put(Constants.FRAMEWORK_SYSTEMPACKAGES_EXTRA, "org.eclipse.iee.document.api, com.ieecloud.ui.viewer, org.apache.commons.codec.binary; version=\"1.4.0\", org.apache.commons.io");
		config.put(Constants.FRAMEWORK_STORAGE, folder + "/osgi-area");
		config.put(Constants.FRAMEWORK_STORAGE_CLEAN, "true");

		framework = frameworkFactory.newFramework(config);
		try {
			framework.start();
			System.out.println(framework.getBundleContext().getProperty(Constants.FRAMEWORK_STORAGE));
			Bundle[] bundles = framework.getBundleContext().getBundles();
			for (Bundle bundle : bundles) {
				if (bundle.getBundleId() != 0) {
					Path path = Paths.get(new URI(bundle.getLocation()));
					if (!Files.exists(path)) {
						bundle.uninstall();
					} else {
						System.out.println(bundle.getLocation());
					}
				}
			}
			
			
			Path start = Paths.get(folder + "/doc");
			if (!Files.exists(start)) {
				Files.createDirectory(start);
			}
			
			final WatchService watcher = FileSystems.getDefault().newWatchService();
			
			watchThread = new Thread(new Runnable() {
				@Override
				public void run() {
					for (;;) {
					    WatchKey key;
					    try {
					        key = watcher.take();
					    } catch (InterruptedException x) {
					        return;
					    }

					    for (WatchEvent<?> event: key.pollEvents()) {
					        WatchEvent.Kind<?> kind = event.kind();
					        if (kind == OVERFLOW) {
					            continue;
					        }
					        Path dir = (Path) key.watchable();
					        Path fullPath = dir.resolve((Path) event.context());
					        if (fullPath.toUri().getPath().endsWith(".jar")) {
					        	if (kind == ENTRY_CREATE) {
					        		try {
					        			installJar(fullPath);
									} catch (Exception e) {
										e.printStackTrace();
									}
					        	} else if (kind == ENTRY_MODIFY) {
					        		Bundle bundle = framework.getBundleContext().getBundle(fullPath.toAbsolutePath().toUri().toString());
					        		if (bundle != null) {
					        			try {
											bundle.update();
										} catch (BundleException e) {
											e.printStackTrace();
										}
					        		}
					        	} else if (kind == ENTRY_DELETE) {
					        		Bundle bundle = framework.getBundleContext().getBundle(fullPath.toAbsolutePath().toUri().toString());
					        		if (bundle != null) {
					        			try {
											bundle.uninstall();
										} catch (BundleException e) {
											e.printStackTrace();
										}
					        		}
					        	}
					        }
					        boolean valid = key.reset();
					        if (!valid) {
					            break;
					        }
					    }
					}
				}
			});
			watchThread.start();
			
			Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
				
				@Override
				public FileVisitResult preVisitDirectory(Path dir,
						BasicFileAttributes attrs) throws IOException {
					dir.register(watcher, ENTRY_CREATE,
							ENTRY_MODIFY,
							ENTRY_DELETE);
					
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
						throws IOException {
					
					if (file.toUri().getPath().endsWith(".jar")) {
						installJar(file);
					}
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (BundleException | IOException | URISyntaxException e) {
			Throwables.propagate(e);
		}
	}
	
	private void installJar(Path file) {
		try {
			String location = file.toAbsolutePath().toUri().toString();
			Bundle bundle = framework.getBundleContext().getBundle(location);
			System.out.println(location);
			if (bundle != null) {
				return;
			}
			bundle = framework.getBundleContext().installBundle(location);
			bundle.start();
		} catch (BundleException e) {
			Throwables.propagate(e);
		}
	}

	@Override
	public Document getDocument(String bundle, String document)
			throws IOException {
		Bundle bundle2 = getBundle(framework.getBundleContext(), bundle);
		if (bundle2 == null) {
			return null;
		}
		URL resource = bundle2.getEntry("/src/" + document + ".java");
		Document parsedDocument;
		try (InputStream stream = resource.openStream()) {
			parsedDocument = documentParser.parseDocument(stream);
		}
		return parsedDocument;
	}

	private Bundle getBundle(BundleContext bundleContext, String symbolicName) {
	    Bundle result = null;
	    for (Bundle candidate : bundleContext.getBundles()) {
	        if (symbolicName.equals(candidate.getSymbolicName())) {
	            if (result == null || result.getVersion().compareTo(candidate.getVersion()) < 0) {
	                result = candidate;
	            }
	        }
	    }
	    return result;
	}
	
	@Override
	public Class<?> getDocumentClass(String bundle, String document) throws IOException, ClassNotFoundException {
		return getBundle(framework.getBundleContext(), bundle).loadClass(document);
	}

	@Override
	public InputStream getResourceAsStream(String bundle, String document,
			String resource) throws IOException {
		return getBundle(framework.getBundleContext(), bundle).getResource(resource).openStream();
	}

	public void stop() {
		watchThread.interrupt();
	}
	
}
