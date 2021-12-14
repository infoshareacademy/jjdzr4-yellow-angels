package pl.infoshare.service;

import org.springframework.stereotype.Service;
import pl.infoshare.dataFactory.DataFactory;
import pl.infoshare.model.Item;
import pl.infoshare.model.ItemComponent;
import pl.infoshare.model.Pack;

@Service
public class ItemComponentService {

    private final DataFactory factory = DataFactory.getINSTANCE;

    public Item updateItem(Item item, int id) {

        updateBasicItemComponentInfo(item, id);

        return item;
    }

    public Pack updatePack(Pack pack, int id) {

        updateBasicItemComponentInfo(pack, id);

        return pack;
    }

    private void updateBasicItemComponentInfo(ItemComponent itemComponent, int id) {

        ItemComponent existing = factory.getItemComponentById(id);

        existing.setId(id);
        existing.setName(itemComponent.getName());

        String categoryIdFromForm = itemComponent.getCategory().getName();
        existing.setCategory(factory.findCategoryById(categoryIdFromForm));

        String producerIdFromForm = itemComponent.getProducer().getName();
        existing.setProducer(factory.findProducerById(producerIdFromForm));

    }

}
