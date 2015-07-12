package cz.arcanis.lotr.data;

import com.vaadin.data.util.BeanItem;
import cz.arcanis.lotr.entity.Card;
import cz.arcanis.lotr.enums.CardType;
import cz.arcanis.lotr.enums.Sphere;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Arcanis on 12.7.2015.
 */
public class CardDataFactory {

    public static List<Card> getCards() {
        Card prvni = new Card();
        prvni.setCardNumber(1);
        prvni.setName("Aragorn");
        prvni.setCardType(CardType.ALLY);
        prvni.setCost(11);
        prvni.setSphere(Sphere.LEADERSHIP);


        Card druha = new Card();
        druha.setCardNumber(2);
        druha.setName("Galadriea");
        druha.setCardType(CardType.ALLY);
        druha.setCost(12);
        druha.setSphere(Sphere.LORE);

        List<Card> list = new LinkedList<>();
        list.add(prvni);
        list.add(druha);
        return list;
    }
}
