package service_flow.assignment.api.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 *
 * @author Ali Raza
 */
public class SpringConfigBootstrap implements WebApplicationInitializer {

    @Override
    public void onStartup(final ServletContext servletContext) throws ServletException {
        final AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        servletContext.addListener(new ContextLoaderListener(context));
        servletContext.addServlet("cxfServlet", CXFServlet.class).addMapping("/rest/*");
        context.setServletContext(servletContext);
        context.scan("service_flow");
        context.refresh();
    }

}
