package pl.infoshare.service;

import org.springframework.stereotype.Service;
import pl.infoshare.dataFactory.DataFactory;
import pl.infoshare.model.ItemComponent;

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

}
