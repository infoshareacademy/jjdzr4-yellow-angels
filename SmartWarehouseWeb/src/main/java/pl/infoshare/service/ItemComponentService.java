package pl.infoshare.service;

import org.springframework.stereotype.Service;
import pl.infoshare.dataFactory.DataFactory;
import pl.infoshare.model.*;

import java.util.List;

@Service
public class ItemComponentService {

    private final DataFactory factory = DataFactory.getINSTANCE;

    public Item updateItem(Item item, int id) {

        Item existingItem = (Item) factory.getItemComponentById(id);

        existingItem.setId(id);
        existingItem.setName(item.getName());

        String categoryIdFromForm = item.getCategory().getName();
        existingItem.setCategory(factory.findCategoryById(categoryIdFromForm));

        String producerIdFromForm = item.getProducer().getName();
        existingItem.setProducer(factory.findProducerById(producerIdFromForm));

//        Item existingItem = (Item) updateBasicItemComponentInfo(item, id);
        updateItemComponents(existingItem);

        return item;
    }

    public Pack updatePack(Pack pack, int id) {


        Pack existingPack = (Pack) factory.getItemComponentById(id);

        existingPack.setId(id);
        existingPack.setName(pack.getName());

        String categoryIdFromForm = pack.getCategory().getName();
        existingPack.setCategory(factory.findCategoryById(categoryIdFromForm));

        String producerIdFromForm = pack.getProducer().getName();
        existingPack.setProducer(factory.findProducerById(producerIdFromForm));

//        Pack existingItem = (Pack) updateBasicItemComponentInfo(pack, id);
        updateItemComponents(existingPack);

        return pack;
    }

/*    private ItemComponent updateBasicItemComponentInfo(ItemComponent itemComponent, int id){

        Pack existingPack = (Pack) factory.getItemComponentById(id);

        existingPack.setId(id);
        existingPack.setName(itemComponent.getName());

        String categoryIdFromForm = itemComponent.getCategory().getName();
        existingPack.setCategory(factory.findCategoryById(categoryIdFromForm));

        String producerIdFromForm = itemComponent.getProducer().getName();
        existingPack.setProducer(factory.findProducerById(producerIdFromForm));

        return existingPack;
    }*/

    private void updateItemComponents(ItemComponent item){
        List<ItemComponent> items = factory.getItemComponents();
        items.set(items.indexOf(item), item);
        factory.setItemComponents(items);
    }
}
