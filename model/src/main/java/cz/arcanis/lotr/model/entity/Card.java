package cz.arcanis.lotr.model.entity;

import cz.arcanis.lotr.model.enums.CardSet;
import cz.arcanis.lotr.model.enums.Sphere;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

/**
 * Created by Arcanis on 12.7.2015.
 */
@Document(collection = "cards")
public class Card {
    @Id
    private ObjectId mongoId;

    private String name;
    private Integer id;
    private CardSet set;
    private Boolean unique;
    private Sphere sphere;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectId getMongoId() {
        return mongoId;
    }

    public void setMongoId(ObjectId mongoId) {
        this.mongoId = mongoId;
    }

    public CardSet getSet() {
        return set;
    }

    public void setSet(CardSet set) {
        this.set = set;
    }

    public Sphere getSphere() {
        return sphere;
    }

    public void setSphere(Sphere sphere) {
        this.sphere = sphere;
    }

    public Boolean getUnique() {
        return unique;
    }

    public void setUnique(Boolean unique) {
        this.unique = unique;
    }

    @Override
    public String toString() {
        return  ToStringBuilder.reflectionToString(this);
    }
}
