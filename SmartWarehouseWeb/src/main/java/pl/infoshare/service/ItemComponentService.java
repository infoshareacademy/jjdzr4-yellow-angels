package pl.infoshare.service;

import org.springframework.stereotype.Service;
import pl.infoshare.dataFactory.DataFactory;
import pl.infoshare.model.Category;
import pl.infoshare.model.ItemComponent;
import pl.infoshare.model.Producer;

import java.util.List;

@Service
public class ItemComponentService {

    public List<ItemComponent> getAllItems(){
        return DataFactory.getINSTANCE.getItems();
    }

    public ItemComponent getItemById(int id){
        return DataFactory.getINSTANCE.getItems()
                .stream()
                .filter(itemComponent -> itemComponent.getId() == id)
                .findFirst().orElse(null);
    }

    public ItemComponent updateItem(ItemComponent itemComponent) {
        return null;
    }

    public List<Category> getAllCategories() {
        return DataFactory.getINSTANCE.getCategories();
    }

    public List<Producer> getAllProducers() {
        return DataFactory.getINSTANCE.getProducers();
    }

}
