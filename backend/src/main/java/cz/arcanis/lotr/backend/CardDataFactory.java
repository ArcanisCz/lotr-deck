package cz.arcanis.lotr.backend;

import cz.arcanis.lotr.backend.repository.CardsRepository;
import cz.arcanis.lotr.model.entity.Card;
import cz.arcanis.lotr.model.enums.CardType;
import cz.arcanis.lotr.model.enums.Sphere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Arcanis on 12.7.2015.
 */
@Component
public class CardDataFactory {

    @Autowired
    private CardsRepository cardsRepository;

    public List<Card> getCards() {
//        Card prvni = new Card();
//        prvni.setCardNumber(1);
//        prvni.setName("Aragorn");
//        prvni.setCardType(CardType.ALLY);
//        prvni.setCost(11);
//        prvni.setSphere(Sphere.LEADERSHIP);
//
//
//        Card druha = new Card();
//        druha.setCardNumber(2);
//        druha.setName("Galadriea");
//        druha.setCardType(CardType.ALLY);
//        druha.setCost(12);
//        druha.setSphere(Sphere.LORE);
//
//        List<Card> list = new LinkedList<>();
//        list.add(prvni);
//        list.add(druha);
//        return list;
        return cardsRepository.findAll();
    }
}
