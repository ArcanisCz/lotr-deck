package cz.arcanis.lotr.model.entity.converter;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import cz.arcanis.lotr.model.entity.Card;
import cz.arcanis.lotr.model.entity.HeroCard;
import cz.arcanis.lotr.model.entity.interfaces.HasBattleStats;
import cz.arcanis.lotr.model.entity.interfaces.HasResourceCost;
import cz.arcanis.lotr.model.entity.interfaces.HasThreatCost;
import cz.arcanis.lotr.model.enums.CardSet;
import cz.arcanis.lotr.model.enums.CardType;
import cz.arcanis.lotr.model.enums.FieldName;
import cz.arcanis.lotr.model.enums.Sphere;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Arcanis on 12.7.2015.
 */
@ReadingConverter
public class CardReadConverter implements Converter<BasicDBObject, Card> {

    private static final Class[] interfaces = new Class[]{HasBattleStats.class, HasResourceCost.class, HasThreatCost.class};

    @Override
    public Card convert(BasicDBObject dbObject) {
        Card card = createCard(dbObject);

        fillCommonFields(dbObject, card);
        fillCardDataForInterfaces(CardReadConverter.interfaces, dbObject, card);

        System.out.println(card);
        return card;
    }

    private Card createCard(BasicDBObject dbObject) {
        CardType type = CardType.getByName(dbObject.get("type").toString());
        if (CardType.HERO.equals(type)) {
            return new HeroCard();
        } else {
            return new Card();
        }
    }

    private void fillCommonFields(BasicDBObject o, Card card) {
        card.setMongoId((ObjectId) get(o, FieldName._ID));
        card.setId(getInteger(o, FieldName.ID));
        card.setName(getString(o, FieldName.NAME));
        card.setSet(CardSet.getByName(getString(o, FieldName.SET)));
        card.setUnique(getBoolead(o, FieldName.UNIQUE));
        card.setSphere(Sphere.getByName(getString(o, FieldName.SPHERE)));
    }

    private void fillIntefaceFields(BasicDBObject o, HasBattleStats card) {
        card.setAttack(getInteger(o, FieldName.ATTACK));
        card.setDefense(getInteger(o, FieldName.DEFENSE));
        card.setHp(getInteger(o, FieldName.HP));
    }

    private void fillIntefaceFields(BasicDBObject o, HasResourceCost card) {

    }

    private void fillIntefaceFields(BasicDBObject o, HasThreatCost card) {
        card.setThreatCost(getInteger(o, FieldName.THREAT_COST));
    }

    private void fillCardDataForInterfaces(Class[] interfaces, DBObject dbObject, Card card) {
        for (Class cls : interfaces) {
            if (cls.isAssignableFrom(card.getClass())) {
                try {
                    Method method = CardReadConverter.class.getDeclaredMethod("fillIntefaceFields", BasicDBObject.class, cls);
                    method.invoke(this, dbObject, card);
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    System.out.println("AEEEEEEEEEE "+e);
                }
            }
        }
    }

    private static Object get(DBObject dbObject, FieldName name) {
        return dbObject.get(name.getName());
    }

    private static String getString(DBObject dbObject, FieldName name) {
        return get(dbObject, name).toString();
    }

    private static Integer getInteger(DBObject dbObject, FieldName name) {
        return Integer.parseInt(get(dbObject, name).toString());
    }

    private static Boolean getBoolead(DBObject dbObject, FieldName name) {
        return StringUtils.equalsIgnoreCase("true", get(dbObject, name).toString());
    }
}
