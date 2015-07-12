package cz.arcanis.lotr;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

/**
 * Created by Arcanis on 12.7.2015.
 */
@Title("Addressbook")
@Theme("valo")
public class LotrUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setContent(new Label("aaa"));
    }
}
