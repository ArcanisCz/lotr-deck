package cz.arcanis.lotr.vaadin.generator;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import cz.arcanis.lotr.model.entity.Card;
import cz.arcanis.lotr.model.enums.Sphere;
import cz.arcanis.lotr.vaadin.LotrTheme;

/**
 * Created by Arcanis on 12.7.2015.
 */
public class CardColumnGenerator implements Table.ColumnGenerator, Table.CellStyleGenerator {

    @Override
    public Object generateCell(Table source, Object itemId, Object columnId) {
        Card card = getCard(source, itemId);
        if (card != null) {
            return generateCardCell(card);
        }
        return null;
    }

    @Override
    public String getStyle(Table source, Object itemId, Object propertyId) {
        Card card = getCard(source, itemId);
        if (card != null) {
            return generateCardStyle(card);
        }
        return null;
    }

    private Card getCard(Table source, Object itemId) {
        Item item = source.getItem(itemId);
        if (item instanceof BeanItem) {
            BeanItem beanItem = (BeanItem) item;
            Object bean = beanItem.getBean();
            if (bean instanceof Card) {
                return (Card) bean;
            }
        }
        return null;
    }

    private Component generateCardCell(Card card) {
        return new Label(card.getName());
    }

    private String generateCardStyle(Card card) {
        Sphere sphere = card.getSphere();
        if (Sphere.LORE.equals(sphere)) {
            return LotrTheme.LORE;
        } else if (Sphere.SPIRIT.equals(sphere)) {
            return LotrTheme.SPIRIT;
        } else if (Sphere.TACTICS.equals(sphere)) {
            return LotrTheme.TACTICS;
        } else if (Sphere.LEADERSHIP.equals(sphere)) {
            return LotrTheme.LEADERSHIP;
        } else {
            return LotrTheme.NEUTRAL;
        }
    }
}
