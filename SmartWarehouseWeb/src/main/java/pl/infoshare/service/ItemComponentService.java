package pl.infoshare.service;

import org.springframework.stereotype.Service;
import pl.infoshare.model.Category;
import pl.infoshare.model.Item;
import pl.infoshare.model.ItemComponent;
import pl.infoshare.model.Producer;
import pl.infoshare.repository.ItemComponentRepositoryImpl;

import java.util.List;
import java.util.Optional;

@Service
public class ItemComponentService {

    private final ItemComponentRepositoryImpl repository;

    public ItemComponentService(ItemComponentRepositoryImpl repository) {
        this.repository = repository;
    }

    public List<ItemComponent> getAll(){
        return repository.getAll();
    }
    public void saveItem(Item item){
        item.setId(0);

        int newItemCategoryId = item.getCategory().getId();
        Optional<Category> category = repository.getCategoryById(newItemCategoryId);
        category.ifPresent(item::setCategory);

        int newItemProducerId = item.getProducer().getId();
        Optional<Producer> producer = repository.getProducerById(newItemProducerId);
        producer.ifPresent(item::setProducer);

        repository.saveItem(item);
    }

}
