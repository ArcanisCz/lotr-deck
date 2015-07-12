package cz.arcanis.lotr.vaadin.component;

import com.vaadin.data.util.AbstractBeanContainer;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import cz.arcanis.lotr.model.entity.Card;

/**
 * Created by Arcanis on 12.7.2015.
 */
public class CardList extends CustomComponent {
    public CardList() {
        Table table = createTable();
        VerticalLayout layout = new VerticalLayout();

        layout.addComponent(table);

        layout.setExpandRatio(table, 1);
        layout.setSizeFull();
        setCompositionRoot(layout);
    }

    private Table createTable() {
        Table table = new Table();
        BeanContainer<Integer, Card> container = new BeanContainer<>(Card.class);
        container.setBeanIdResolver(new AbstractBeanContainer.BeanIdResolver<Integer, Card>() {
            @Override
            public Integer getIdForBean(Card card) {
                return card.getCardNumber();
            }
        });
//        container.addAll(CardDataFactory.getCards());
        table.setContainerDataSource(container);


        table.setSizeFull();
        return table;

    }
}
