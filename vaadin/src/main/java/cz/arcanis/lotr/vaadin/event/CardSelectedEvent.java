package cz.arcanis.lotr.vaadin.event;

import com.vaadin.ui.Component;
import cz.arcanis.lotr.model.entity.Card;

import java.io.Serializable;

/**
 * Created by Arcanis on 13.7.2015.
 */
public class CardSelectedEvent extends Component.Event {

    private final Card card;

    public CardSelectedEvent(Component source, Card card) {
        super(source);
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public interface CardSelectedListener extends Serializable {
        void cardSelected(CardSelectedEvent event);
    }
}
