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

}
