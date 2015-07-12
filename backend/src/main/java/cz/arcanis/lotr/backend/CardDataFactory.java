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
        return cardsRepository.findBySet("Core");
    }
}
