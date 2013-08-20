package org.eclipse.iee.web.server;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.FragmentConfiguration;
import org.eclipse.jetty.webapp.MetaInfConfiguration;
import org.eclipse.jetty.webapp.TagLibConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

public class TestServer {

	public static void main(String[] args) throws Exception {
		
		Server server = new Server(9090);
		WebAppContext webAppContext = new WebAppContext();
		webAppContext.setContextPath("/test");
		webAppContext.setResourceBase("src/main/webapp");
		webAppContext.addServlet(DocumentServlet.class, "/doc/*");
		webAppContext.setConfigurations(new Configuration[] {
                new AnnotationConfiguration(), new WebXmlConfiguration(),
                new WebInfConfiguration(), new TagLibConfiguration(),
                new PlusConfiguration(), new MetaInfConfiguration(),
                new FragmentConfiguration(), new EnvConfiguration() });
        server.setHandler(webAppContext);
        server.start();
		
	}
	
}
