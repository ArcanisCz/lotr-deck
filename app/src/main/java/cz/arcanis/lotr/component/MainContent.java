package cz.arcanis.lotr.component;

import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

/**
 * Created by Arcanis on 12.7.2015.
 */
public class MainContent extends CustomComponent {
    public MainContent() {
        Component left = new Label("left");
        Component right = new CardList();

        HorizontalLayout layout = new HorizontalLayout();

        layout.addComponent(left);
        layout.addComponent(right);

        layout.setSizeFull();
        layout.setExpandRatio(left, 1);
        layout.setExpandRatio(right, 1);
        right.setSizeFull();
        left.setSizeFull();

        setCompositionRoot(layout);
    }
}
