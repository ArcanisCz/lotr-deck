package cz.arcanis.lotr.vaadin.component;

import com.vaadin.data.Item;
import com.vaadin.data.util.AbstractBeanContainer;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import cz.arcanis.lotr.model.entity.Card;

import java.util.List;

/**
 * Created by Arcanis on 12.7.2015.
 */
public class CardList extends CustomComponent {

    private BeanContainer<Integer, Card> container = new BeanContainer<>(Card.class);

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


//        table.addGeneratedColumn("th", new Table.ColumnGenerator() {
//            @Override
//            public Object generateCell(Table source, Object itemId, Object columnId) {
//                BeanItem<Card> a = (BeanItem<Card>)source.getItem(itemId);
//                System.out.println(itemId+" "+ columnId+" "+a.getItemProperty(columnId));
//                return "aa";
//            }
//        });
        table.setSizeFull();
        return table;
    }


    public void setCards(List<Card> cards) {
        container.addAll(cards);
    }
}
