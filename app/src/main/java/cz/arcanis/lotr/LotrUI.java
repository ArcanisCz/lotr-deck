package cz.arcanis.lotr;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import cz.arcanis.lotr.component.MainContent;
import cz.arcanis.lotr.component.TopMenu;
import cz.arcanis.lotr.data.CardDataFactory;
import cz.arcanis.lotr.view.MojeView;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Arcanis on 12.7.2015.
 */
@SpringUI
@Title("Addressbook")
@Theme("valo")
public class LotrUI extends UI {
    private Navigator navigator;

    @Autowired
    private SpringViewProvider springViewProvider;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        Component header= new Label("header");
//        Component menu = new TopMenu();
        Component footer= new Label("footer");
        Panel content = new Panel();

        this.navigator = new Navigator(this, content);
        navigator.addProvider(springViewProvider);

        VerticalLayout mainLayout = new VerticalLayout();

        mainLayout.addComponent(header);
//        mainLayout.addComponent(menu);
        mainLayout.addComponent(content);
        mainLayout.addComponent(footer);

        mainLayout.setSizeFull();
        mainLayout.setExpandRatio(content, 1);
        content.setSizeFull();
        content.addStyleName(ValoTheme.PANEL_BORDERLESS);

        setContent(mainLayout);
    }
}
