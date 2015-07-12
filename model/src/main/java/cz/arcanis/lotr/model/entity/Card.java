package cz.arcanis.lotr.model.entity;

import cz.arcanis.lotr.model.enums.CardType;
import cz.arcanis.lotr.model.enums.Sphere;

/**
 * Created by Arcanis on 12.7.2015.
 */
public class Card {
    private Integer cardNumber; //will include set info
    private String name;
    private Sphere sphere;
    private Integer cost;
    private CardType cardType;

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sphere getSphere() {
        return sphere;
    }

    public void setSphere(Sphere sphere) {
        this.sphere = sphere;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }
}
