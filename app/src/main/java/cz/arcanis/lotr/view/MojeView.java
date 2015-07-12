package cz.arcanis.lotr.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import cz.arcanis.lotr.component.CardList;
import cz.arcanis.lotr.data.CardDataFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Arcanis on 12.7.2015.
 */
@SpringView(name = "")
public class MojeView extends CustomComponent implements View {


    @Autowired
    private CardDataFactory cardDataFactory;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
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
        setSizeFull();

        System.out.println(cardDataFactory);
    }
}
