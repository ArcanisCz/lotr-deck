package cz.arcanis.lotr.vaadin.component;

import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.AbstractBeanContainer;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import cz.arcanis.lotr.model.entity.Card;
import cz.arcanis.lotr.vaadin.event.CardSelectedEvent;
import cz.arcanis.lotr.vaadin.generator.CardColumnGenerator;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

/**
 * Created by Arcanis on 12.7.2015.
 */
public class CardList extends CustomComponent {

    private final BeanContainer<Integer, Card> container = new BeanContainer<>(Card.class);
    private static final CardColumnGenerator CARD_COLUMN_GENERATOR = new CardColumnGenerator();


    private static final Method CARD_SELECTED_METHOD;

    static {
        try {
            CARD_SELECTED_METHOD = CardSelectedEvent.CardSelectedListener.class
                    .getDeclaredMethod("cardSelected",
                            new Class[]{CardSelectedEvent.class});
        } catch (final java.lang.NoSuchMethodException e) {
            // This should never happen
            throw new java.lang.RuntimeException(
                    "Internal error finding methods in CardSelectedEvent");
        }
    }

    public CardList() {
        Table table = createTable();
        VerticalLayout layout = new VerticalLayout();

        layout.addComponent(table);

        layout.setExpandRatio(table, 1);
        layout.setSizeFull();
        setCompositionRoot(layout);
    }

    private Table createTable() {
        final Table table = new Table();
        container.setBeanIdResolver(new AbstractBeanContainer.BeanIdResolver<Integer, Card>() {
            @Override
            public Integer getIdForBean(Card card) {
                return card.getId();
            }
        });
        table.setContainerDataSource(container);

        table.addGeneratedColumn("th", CARD_COLUMN_GENERATOR);
        table.setCellStyleGenerator(CARD_COLUMN_GENERATOR);
        table.setVisibleColumns("th");
        table.setImmediate(true);


        table.setMultiSelect(false);
        table.setSelectable(true);
        table.addItemClickListener(new ItemClickEvent.ItemClickListener() {
            @Override
            public void itemClick(ItemClickEvent event) {
                table.select(event.getItemId());
            }
        });

        table.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent event) {
                Collection<? extends CardSelectedEvent.CardSelectedListener> listeners = (Collection<? extends CardSelectedEvent.CardSelectedListener>) getListeners(CardSelectedEvent.class);
                for (CardSelectedEvent.CardSelectedListener listener : listeners) {
                    listener.cardSelected(new CardSelectedEvent(table, getCard(table, table.getValue())));
                }
            }
        });


        table.setPageLength(400);
        table.setSizeFull();
        return table;
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

    public void setCards(List<Card> cards) {
        container.addAll(cards);
    }

    public void addCardSelectedListener(CardSelectedEvent.CardSelectedListener listener) {
        this.addListener(CardSelectedEvent.class, listener, CARD_SELECTED_METHOD);
    }
}
