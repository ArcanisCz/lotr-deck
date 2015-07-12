package cz.arcanis.lotr.component;

import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.MenuBar;

/**
 * Created by Arcanis on 12.7.2015.
 */
public class TopMenu extends CustomComponent {

    public TopMenu() {
        MenuBar bar = new MenuBar();
        bar.addItem("Pokus", new MenuBar.Command() {
            @Override
            public void menuSelected(MenuBar.MenuItem menuItem) {
                System.out.println("aaaa");
            }
        });

        setCompositionRoot(bar);
    }
}
