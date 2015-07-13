package cz.arcanis.lotr.vaadin.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import cz.arcanis.lotr.backend.CardDataFactory;
import cz.arcanis.lotr.vaadin.component.CardDisplay;
import cz.arcanis.lotr.vaadin.component.CardList;
import cz.arcanis.lotr.vaadin.event.CardSelectedEvent;
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
        final Component left = new Label("left");
        final CardDisplay center = new CardDisplay();
        final CardList right = new CardList();

        HorizontalLayout layout = new HorizontalLayout();

        layout.addComponent(left);
        layout.addComponent(center);
        layout.addComponent(right);

        layout.setSizeFull();
        layout.setExpandRatio(left, 1);
        center.setWidth(400, Unit.PIXELS);
        center.setHeight(100, Unit.PERCENTAGE);
        layout.setExpandRatio(right, 1);
        right.setSizeFull();
        left.setSizeFull();

        center.setImmediate(true);
        right.setImmediate(true);

        setCompositionRoot(layout);
        setSizeFull();

        right.addCardSelectedListener(new CardSelectedEvent.CardSelectedListener() {
            @Override
            public void cardSelected(CardSelectedEvent event) {
                center.setCard(event.getCard());
            }
        });

        right.setCards(cardDataFactory.getCards());
    }
}
