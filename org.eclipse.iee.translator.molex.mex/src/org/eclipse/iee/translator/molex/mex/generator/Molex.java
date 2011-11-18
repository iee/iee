package org.eclipse.iee.translator.molex.mex.generator;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

public class Molex {
	
	public static void main(String[] args) {
		//if (args.length==0) {
		//	System.err.println("Aborting: no path to EMF resource provided!");
		//	return;
		//}
		Injector injector = new org.eclipse.iee.translator.molex.mex.MexStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
		Molex main = injector.getInstance(Molex.class);
		//main.runGenerator(args[0]);
		System.out.println(main.translateMath("1 / (a + b)-c+2.5-6+3.77"));
	}
	
	public static Molex create() {
		Injector injector = new org.eclipse.iee.translator.molex.mex.MexStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
		return injector.getInstance(Molex.class);
		//main.runGenerator(args[0]);
		//System.out.println(main.translateMath("1 / (a + b)"));
	}
	
	@Inject 
	private Provider<ResourceSet> resourceSetProvider;
	
	@Inject
	private IResourceValidator validator;
	
	@Inject
	private IGenerator generator;
	
	@Inject 	
	private JavaIoFileSystemAccess fileAccess;

	public String translateMath(String input) {
		InputStream inputStream = new ByteArrayInputStream(input.getBytes());
		ResourceSet set = resourceSetProvider.get();
		Resource resource = set.getResource(URI.createURI("test.mex"), true);
	
		try {
			resource.unload();
			resource.load(inputStream, set.getLoadOptions());
				
			return ((MexGenerator)generator).generateText(resource);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	protected void runGenerator(String string) {
		// load the resource
		ResourceSet set = resourceSetProvider.get();
		Resource resource = set.getResource(URI.createURI(string), true);
						
		// validate the resource
		List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		if (!list.isEmpty()) {
			for (Issue issue : list) {
				System.err.println(issue);
			}
			return;
		}
		
		// configure and start the generator
		fileAccess.setOutputPath("src-gen/");
		//generator.doGenerate(resource, fileAccess);
		
		System.out.println(
			((MexGenerator)generator).generateText(resource)
		);
		
		System.out.println("Code generation finished.");
	}
}
