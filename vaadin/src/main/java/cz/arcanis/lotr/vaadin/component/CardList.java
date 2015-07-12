package cz.arcanis.lotr.vaadin.component;

import com.vaadin.data.util.AbstractBeanContainer;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import cz.arcanis.lotr.model.entity.Card;
import cz.arcanis.lotr.vaadin.generator.CardColumnGenerator;

import java.util.List;

/**
 * Created by Arcanis on 12.7.2015.
 */
public class CardList extends CustomComponent {

    private final BeanContainer<Integer, Card> container = new BeanContainer<>(Card.class);
    private static final CardColumnGenerator CARD_COLUMN_GENERATOR = new CardColumnGenerator();

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

        table.setPageLength(400);
        table.setSizeFull();
        return table;
    }


    public void setCards(List<Card> cards) {
        container.addAll(cards);
    }
}
