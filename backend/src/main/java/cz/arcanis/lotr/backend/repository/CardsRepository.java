package cz.arcanis.lotr.backend.repository;

import cz.arcanis.lotr.model.entity.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Created by Arcanis on 12.7.2015.
 */
public interface CardsRepository extends MongoRepository<Card, String> {
    List<Card> findBySet(String cardSet);
}
