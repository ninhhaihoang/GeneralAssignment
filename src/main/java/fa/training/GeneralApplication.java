package fa.training;

import fa.training.utils.HibernateUtils;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.File;

public class GeneralApplication {
    public static void main(String[] args) throws LifecycleException {
//        String contextPath = "/";
//        String webappDirLocation = "src/main/webapp/";
//        String baseDirectory = new File(webappDirLocation).getAbsolutePath();
//
//        Tomcat tomcat = new Tomcat();
//        tomcat.setPort(8080);
//        StandardContext context = (StandardContext) tomcat.addWebapp(contextPath, baseDirectory);
//
//        // Additions to make @WebServlet work
//        String buildPath = "target/classes";
//        String webAppMount = "/WEB-INF";
//
//        File additionalWebInfClasses = new File(buildPath);
//        WebResourceRoot resources = new StandardRoot(context);
//        resources.addPreResources(new DirResourceSet(resources, webAppMount, additionalWebInfClasses.getAbsolutePath(), contextPath));
//        context.setResources(resources);
//        // End of additions
//
//        tomcat.start();
//        tomcat.getServer().await();
    }
}
