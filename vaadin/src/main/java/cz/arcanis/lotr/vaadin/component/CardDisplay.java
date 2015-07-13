package cz.arcanis.lotr.vaadin.component;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import com.vaadin.ui.*;
import cz.arcanis.lotr.model.entity.Card;

/**
 * Created by Arcanis on 13.7.2015.
 */
public class CardDisplay extends CustomComponent{

    HorizontalLayout layout = new HorizontalLayout();

    public CardDisplay() {
        setImmediate(true);
        layout.setImmediate(true);
        layout.setSizeFull();

        setCompositionRoot(layout);
    }

    public void setCard(Card card){
        layout.removeAllComponents();
        if(card != null){
            Resource resource = new ExternalResource("http://www.cardgamedb.com/forums/uploads/"+card.getImg());
            Image image = new Image(null, resource);
            image.setImmediate(true);
            layout.addComponent(image);
            layout.setComponentAlignment(image, Alignment.MIDDLE_CENTER);
        }
    }
}
