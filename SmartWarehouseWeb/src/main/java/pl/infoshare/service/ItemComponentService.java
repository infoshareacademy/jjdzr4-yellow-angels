package pl.infoshare.service;

import org.springframework.stereotype.Service;
import pl.infoshare.dataFactory.DataFactory;
import pl.infoshare.model.*;

import java.util.List;

@Service
public class ItemComponentService {

    private final DataFactory factory = DataFactory.getINSTANCE;

    public Item updateItem(Item item, int id) {
        Item existingItem = factory.getItemById(id);

        existingItem.setId(id);
        existingItem.setName(item.getName());

        String categoryIdFromForm = item.getCategory().getName();
        existingItem.setCategory(factory.findCategoryById(categoryIdFromForm));

        String producerIdFromForm = item.getProducer().getName();
        existingItem.setProducer(factory.findProducerById(producerIdFromForm));

        updateItemComponents(existingItem);

        return item;
    }

    private void updateItemComponents(Item item){
        List<ItemComponent> items = factory.getItemComponents();
        items.set(items.indexOf(item), item);
        factory.setItemComponents(items);
    }

}
