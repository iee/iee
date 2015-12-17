package org.eclipse.iee.export.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.iee.core.IParameterProvider;
import org.eclipse.iee.core.IResultContainer;
import org.eclipse.iee.core.InMemoryResultContainer;
import org.eclipse.iee.core.NullParameterProvider;
import org.eclipse.iee.core.document.Document;
import org.eclipse.iee.core.document.DocumentPart;
import org.eclipse.iee.core.document.RootDocumentPart;
import org.eclipse.iee.core.document.parser.IDocumentParser;
import org.eclipse.iee.core.store.IDocumentStore;
import org.eclipse.iee.export.IResourceProvider;
import org.eclipse.iee.export.PackageBuilder;
import org.eclipse.iee.export.PackageResourceProvider;
import org.eclipse.iee.web.renderer.IHTMLRenderer;
import org.eclipse.iee.web.renderer.IHTMLRendererContext;
import org.eclipse.iee.web.renderer.IHTMLRendererManager;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.pde.core.project.IBundleProjectDescription;
import org.eclipse.pde.core.project.IBundleProjectService;
import org.eclipse.ui.PlatformUI;

import com.google.common.base.Throwables;
import com.google.common.io.ByteStreams;
import com.ieecloud.store.ws.client.StoreWsClient;

final class IeeExportOperation implements IRunnableWithProgress {

	private final IDocumentParser parser;
	private final String destinationFile;
	private final String password;
	private final boolean uploadChecked;
	private final String username;
	private final String urlStr;
	private final List<IProject> selectedResources;
	private final IHTMLRendererManager htmlRendererManager;
	private final IDocumentStore documentStore;

	IeeExportOperation(IDocumentParser documentParser,
			IHTMLRendererManager htmlRendererManager,
			IDocumentStore documentStore, String destinationFile,
			String password, boolean uploadChecked, String username,
			String urlStr, List<IProject> selectedResources) {
		this.parser = documentParser;
		this.htmlRendererManager = htmlRendererManager;
		this.documentStore = documentStore;
		this.destinationFile = destinationFile;
		this.password = password;
		this.uploadChecked = uploadChecked;
		this.username = username;
		this.urlStr = urlStr;
		this.selectedResources = selectedResources;
	}

	@Override 
	public void run(IProgressMonitor monitor) throws InvocationTargetException,
			InterruptedException {

		StoreWsClient storeWsClient = null;
		
		if (uploadChecked) {
			URL url;
			try {
				url = URI.create(urlStr).toURL();
			} catch (MalformedURLException e2) {
				throw new InvocationTargetException(e2);
			}		
			
			try {
				storeWsClient = new StoreWsClient("https".equals(url.getProtocol()), url.getHost(), String.valueOf(url.getPort()), password, username, null);
			} catch (Exception e2) {
				throw new InvocationTargetException(e2);
			}
		}
		
		for (IProject iProject : selectedResources) {
			IJavaProject javaProject = JavaCore.create(iProject);
			IClasspathEntry[] resolvedClasspath;
			try {
				resolvedClasspath = javaProject.getResolvedClasspath(true);
			} catch (JavaModelException e1) {
				throw Throwables.propagate(e1);
			}
			IBundleProjectService service = (IBundleProjectService) PlatformUI.getWorkbench().getService(IBundleProjectService.class);
			final String version = null;
			final IBundleProjectDescription description;
			try {
				description = service.getDescription(iProject);
			} catch (CoreException e1) {
				throw Throwables.propagate(e1);
			}
//			if (description != null) {
//				version = description.getBundleVersion().toString();
//			}
			
			File zipFile = new File(destinationFile, iProject.getName() + ".zip");
			try (FileOutputStream fos = new FileOutputStream(zipFile);
					ZipOutputStream zos = new ZipOutputStream(fos)) {
				
				final PackageBuilder export = new PackageBuilder();
				
				for (IClasspathEntry classpathEntry : resolvedClasspath) {
					if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
						final IPath path = classpathEntry.getPath();
						final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(path);
						
						folder.accept(new IResourceVisitor() {
							
							@Override
							public boolean visit(IResource resource) throws CoreException {
								if (resource.getType() == IResource.FILE
										&& JavaCore.isJavaLikeFileName(resource.getName())) {
									final IFile file = (IFile) resource;
									URI relativize = addResource(
											export, folder, file);
									try {
										doFile(description.getSymbolicName(), relativize.toString(), version, export, file);
									} catch (IOException e) {
										throw Throwables.propagate(e);
									}
								}
								return true;
							}



							private void doFile(String bundle, String name, String version, final PackageBuilder export, IFile file)
									throws IOException,
									CoreException {
								
								
								
								try (InputStream is = file.getContents()) {
									RootDocumentPart parsedDocument = parser.parseDocument(is);
									new Document(bundle, name, version, parsedDocument);
									List<DocumentPart> children = parsedDocument.getChildren();
									for (final DocumentPart documentPart : children) {
										IHTMLRendererContext context = new IHTMLRendererContext() {
											@Override
											public boolean isEditMode() {
												return false;
											}
											
											@Override
											public Writer getWriter() throws IOException {
												return new StringWriter();
											}
											
											@Override
											public IResultContainer getResultContainer() {
												return new InMemoryResultContainer();
											}
											
											@Override
											public InputStream getResourceAsStream(String string)
													throws IOException {
												return null;
											}
											
											@Override
											public IParameterProvider getParameterProvider() {
												return new NullParameterProvider();
											}
											
											@Override
											public String createURL(Map<String, String> params) {
												return null;
											}
											
											@Override
											public String createResourceURL(String padId,
													String resourceId, Map<String, String> params) {
												String resourcePath = padId + ".png";
												export.addResource(
														"img/" + resourcePath, 
														new PackageResourceProvider(htmlRendererManager, documentStore, resourcePath, documentPart)
														);
												
												return "img/" + resourcePath;
											}
										};
										IHTMLRenderer<DocumentPart> padHTMLRenderer = htmlRendererManager.getPadHTMLRenderer(documentPart);
										padHTMLRenderer.renderPad(documentPart, context);
									}
								}
							
							}
							
						});
					}
				}
				final IResource root = iProject;
				final IFolder metaInfFolder = iProject.getFolder("META-INF");
				if (metaInfFolder.exists()) {
					metaInfFolder.accept(new IResourceVisitor() {
						
						@Override
						public boolean visit(IResource resource) throws CoreException {
							if (resource.getType() == IResource.FILE) {
								final IFile file = (IFile) resource;
								addResource(export, root, file);
							}
							return true;
						}
					});
				}
				final IFolder osgiInfFolder = iProject.getFolder("OSGI-INF");
				if (osgiInfFolder.exists()) {
					osgiInfFolder.accept(new IResourceVisitor() {
						
						@Override
						public boolean visit(IResource resource) throws CoreException {
							if (resource.getType() == IResource.FILE) {
								final IFile file = (IFile) resource;
								addResource(export, root, file);
							}
							return true;
						}
					});
				}
				final IFolder iconsFolder = iProject.getFolder("icons");
				if (iconsFolder.exists()) {
					iconsFolder.accept(new IResourceVisitor() {
						
						@Override
						public boolean visit(IResource resource) throws CoreException {
							if (resource.getType() == IResource.FILE) {
								final IFile file = (IFile) resource;
								addResource(export, root, file);
							}
							return true;
						}
					});
				}
				final IFolder texturesFolder = iProject.getFolder("textures");
				if (texturesFolder.exists()) {
					texturesFolder.accept(new IResourceVisitor() {
						
						@Override
						public boolean visit(IResource resource) throws CoreException {
							if (resource.getType() == IResource.FILE) {
								final IFile file = (IFile) resource;
								addResource(export, root, file);
							}
							return true;
						}
					});
				}
				final IFolder imagesFolder = iProject.getFolder("pads/image");
				if (imagesFolder.exists()) {
					imagesFolder.accept(new IResourceVisitor() {
						
						@Override
						public boolean visit(IResource resource) throws CoreException {
							if (resource.getType() == IResource.FILE) {
								final IFile file = (IFile) resource;
								addResource(export, "img/" +  file.getName(), file);
							}
							return true;
						}
					});
				}
				
				
				export.writeToStream(zos);
				
			} catch (IOException e) {
				throw new InvocationTargetException(e);
			} catch (CoreException e) {
				throw new InvocationTargetException(e);
			} 
			
			if (uploadChecked) {
				try(InputStream is = new FileInputStream(zipFile)) {
					storeWsClient.uploadNewModel(zipFile.getName(), ByteStreams.toByteArray(is));
				} catch (FileNotFoundException e) {
					throw new InvocationTargetException(e);
				} catch (IOException e) {
					throw new InvocationTargetException(e);
				} catch (Exception e) {
					throw new InvocationTargetException(e);
				}
			}
		}
	}

	private URI addResource(
			final PackageBuilder export,
			final IResource root,
			final IFile file) {
		URI relativize = root.getLocationURI().relativize(file.getLocationURI());
		String fileName = relativize.toString();
		addResource(export, fileName, file);
		return relativize;
	}

	private void addResource(final PackageBuilder export, String fileName, final IFile file) {
		export.addResource(fileName, new IResourceProvider() {
			
			@Override
			public void writeToStream(OutputStream zos) throws IOException {
				try (InputStream is = file.getContents()) {
					ByteStreams.copy(is, zos);
				} catch (CoreException e) {
					throw Throwables.propagate(e);
				}
			}
		});
	}
}