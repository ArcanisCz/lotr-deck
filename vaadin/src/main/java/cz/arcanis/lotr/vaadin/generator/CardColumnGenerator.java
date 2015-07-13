package cz.arcanis.lotr.vaadin.generator;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.LayoutEvents;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import cz.arcanis.lotr.model.entity.Card;
import cz.arcanis.lotr.model.enums.Sphere;
import cz.arcanis.lotr.vaadin.LotrTheme;

import java.util.Collection;

/**
 * Created by Arcanis on 12.7.2015.
 */
public class CardColumnGenerator implements Table.ColumnGenerator, Table.CellStyleGenerator {

    @Override
    public Object generateCell(final Table source, final Object itemId, final Object columnId) {
        Card card = getCard(source, itemId);
        if (card != null) {
            VerticalLayout layout = generateCardCell(card);
            layout.addLayoutClickListener(new LayoutEvents.LayoutClickListener() {
                @Override
                public void layoutClick(LayoutEvents.LayoutClickEvent event) {
                    Collection<? extends ItemClickEvent.ItemClickListener> listeners = (Collection<? extends ItemClickEvent.ItemClickListener>) source.getListeners(ItemClickEvent.class);
                    for(ItemClickEvent.ItemClickListener listener : listeners){
                        listener.itemClick(new ItemClickEvent(source, source.getItem(itemId), itemId, columnId, null));
                    }
                }
            });
            return layout;
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

    private VerticalLayout generateCardCell(Card card) {
        VerticalLayout lines = new VerticalLayout();
        HorizontalLayout firstLine = new HorizontalLayout();
        HorizontalLayout secondLine = new HorizontalLayout();
        HorizontalLayout thirdLine = new HorizontalLayout();

        firstLine.addComponent(new Label(card.getName()));
        secondLine.addComponent(new Label(card.getId().toString()));
        thirdLine.addComponent(new Label(card.getImg()));

        lines.addStyleName(LotrTheme.CURSOR_POINTER);
        lines.addComponent(firstLine);
        lines.addComponent(secondLine);
        lines.addComponent(thirdLine);
        return lines;
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
