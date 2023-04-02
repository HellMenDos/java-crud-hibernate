package net.javaguides.usermanagement;

import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;


public class Main {
	
    public static Tomcat runServer(String webappDir) throws Exception {
        Tomcat tomcat = new Tomcat();
        int port = 8080;

        tomcat.setPort(port);
        tomcat.getConnector().setPort(port);

        System.out.println("configuring app with basedir: " + new File(webappDir).getAbsolutePath());
        StandardContext ctx = (StandardContext) tomcat.addWebapp("", new File(webappDir).getAbsolutePath());

        File clsDir = new File("build/classes");
        if (!clsDir.exists()) {
            clsDir = new File("build/classes");
        }


        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", clsDir.getAbsolutePath(),
                "/"));
        ctx.setResources(resources);


        tomcat.start();
        tomcat.getServer().await();

        return tomcat;
    }

    public static void main(String[] args) throws Exception {
        runServer("src/main/webapp/");
    }
	
}
