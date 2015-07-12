package cz.arcanis.lotr;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.spring.server.SpringVaadinServlet;
import cz.arcanis.lotr.vaadin.LotrUI;

import javax.servlet.annotation.WebServlet;

/**
 * Created by Arcanis on 12.7.2015.
 */

@WebServlet(urlPatterns = "/*")
@VaadinServletConfiguration(ui = LotrUI.class, productionMode = false)
public class MyServlet extends SpringVaadinServlet {
}
