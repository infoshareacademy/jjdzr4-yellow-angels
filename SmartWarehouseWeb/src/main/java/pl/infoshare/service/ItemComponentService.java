package pl.infoshare.service;

import org.springframework.stereotype.Service;
import pl.infoshare.dataFactory.DataFactory;
import pl.infoshare.model.*;

import java.util.List;

@Service
public class ItemComponentService {

    private final DataFactory factory = DataFactory.getINSTANCE;

    public List<ItemComponent> getAllItemComponents() {
        return factory.getItemComponents();
    }

    public List<Item> getAllItems() {
        return factory.getItems();
    }

    public List<Pack> getAllPacks() {
        return factory.getPacks();
    }

    public Item getItemById(int id) {
        return factory.getItems()
                .stream()
                .filter(i -> i.getId() == id)
                .findFirst().orElse(null);
    }

    public void updateItem(Item item, int id) {
        Item existingItem = getItemById(id);

        existingItem.setId(id);
        existingItem.setName(item.getName());
        existingItem.setCategory(item.getCategory());
        existingItem.setProducer(item.getProducer());

        List<ItemComponent> items = factory.getItemComponents();
        items.set(items.indexOf(existingItem), item);
    }

    public List<Category> getAllCategories() {
        return factory.getCategories();
    }

    public List<Producer> getAllProducers() {
        return factory.getProducers();
    }

}
