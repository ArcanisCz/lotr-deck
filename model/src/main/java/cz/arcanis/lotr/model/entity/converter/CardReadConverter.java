package cz.arcanis.lotr.model.entity.converter;

import com.mongodb.BasicDBObject;
import cz.arcanis.lotr.model.entity.Card;
import cz.arcanis.lotr.model.enums.CardSet;
import cz.arcanis.lotr.model.enums.Sphere;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

/**
 * Created by Arcanis on 12.7.2015.
 */
@ReadingConverter
public class CardReadConverter implements Converter<BasicDBObject, Card> {

    @Override
    public Card convert(BasicDBObject dbObject) {
        Card card = new Card();
        card.setMongoId((ObjectId) dbObject.get("_id"));
        card.setId(Integer.parseInt(dbObject.get("id").toString()));
        card.setName(dbObject.get("name").toString());
        card.setSet(CardSet.getSetByName(dbObject.get("set").toString()));
        card.setUnique(StringUtils.equalsIgnoreCase("true", dbObject.get("unique").toString()));
        card.setSphere(Sphere.getSetByName(dbObject.get("sphere").toString()));
        return card;
    }
}
