package cz.arcanis.lotr;

import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Arcanis on 12.7.2015.
 */
public class AppInitializer implements WebApplicationInitializer {


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new MyUIServlet());
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/*");
    }

}
