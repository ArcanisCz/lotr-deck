package cz.arcanis.lotr.vaadin.component;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import cz.arcanis.lotr.model.entity.Card;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Arcanis on 13.7.2015.
 */
public class CardDisplay extends CustomComponent {

    Map<String, Image> cache = new HashMap<>();
    HorizontalLayout layout = new HorizontalLayout();

    public CardDisplay() {
        layout.setSizeFull();

        setCompositionRoot(layout);
    }

    public void setCard(Card card){
        layout.removeAllComponents();
        if(card != null){
            String url = "http://www.cardgamedb.com/forums/uploads/"+card.getImg();
            if(cache.containsKey(url)){
                Image image = cache.get(url);
                layout.addComponent(image);
                layout.setComponentAlignment(image, Alignment.MIDDLE_CENTER);
            }else{
                Resource resource = new ExternalResource("http://www.cardgamedb.com/forums/uploads/"+card.getImg());
                Image image = new Image(null, resource);
//                image.setImmediate(true);
                layout.addComponent(image);
                layout.setComponentAlignment(image, Alignment.MIDDLE_CENTER);
                cache.put(url, image);
            }

        }
    }
}
