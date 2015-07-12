package cz.arcanis.lotr;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import cz.arcanis.lotr.component.MainContent;
import cz.arcanis.lotr.component.TopMenu;

/**
 * Created by Arcanis on 12.7.2015.
 */
@Title("Addressbook")
@Theme("valo")
public class LotrUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Component header= new Label("header");
        Component menu = new TopMenu();
        Component content = new MainContent();
        Component footer= new Label("footer");

        VerticalLayout mainLayout = new VerticalLayout();

        mainLayout.addComponent(header);
        mainLayout.addComponent(menu);
        mainLayout.addComponent(content);
        mainLayout.addComponent(footer);

        mainLayout.setSizeFull();
        content.setSizeFull();
        mainLayout.setExpandRatio(content, 1);

        setContent(mainLayout);
    }
}
