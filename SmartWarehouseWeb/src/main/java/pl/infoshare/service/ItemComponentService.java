package pl.infoshare.service;

import org.springframework.stereotype.Service;
import pl.infoshare.model.*;
import pl.infoshare.repository.ItemComponentRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ItemComponentService {

    private final ItemComponentRepository repository;

    public ItemComponentService(ItemComponentRepository repository) {
        this.repository = repository;
    }

    public List<ItemComponent> getAll() {
        return repository.getAll();
    }

    public void saveItem(Item item) {
        int newId = generateId();
        item.setId(newId);

        int newItemCategoryId = item.getCategory().getId();
        Optional<Category> category = repository.getCategoryById(newItemCategoryId);
        category.ifPresent(item::setCategory);

        int newItemProducerId = item.getProducer().getId();
        Optional<Producer> producer = repository.getProducerById(newItemProducerId);
        producer.ifPresent(item::setProducer);

        repository.saveItem(item);
    }

    private int generateId() {
        return getAll().stream().max(Comparator.comparing(ItemComponent::getId)).get().getId() + 1;
    }

    public Item updateItem(Item item) {
        updateBasicItemComponentInfo(item);
        return item;
    }

    public Pack updatePack(Pack pack) {
        updateBasicItemComponentInfo(pack);
        return pack;
    }

    private void updateBasicItemComponentInfo(ItemComponent itemComponent) {
        int id = itemComponent.getId();
        Optional<ItemComponent> result = repository.getItemComponentById(id);
        if (result.isPresent()) {
            ItemComponent existing = result.get();
            existing.setId(id);
            existing.setName(itemComponent.getName());
            String categoryIdFromForm = itemComponent.getCategory().getName();
            existing.setCategory(repository.getCategoryById(Integer.parseInt(categoryIdFromForm)).get());
            String producerIdFromForm = itemComponent.getProducer().getName();
            existing.setProducer(repository.getProducerById(Integer.parseInt(producerIdFromForm)).get());
        }

    }

    public List<Item> getItems() {
        return repository.getAllItems();
    }

    public List<Pack> getPacks() {
        return repository.getAllPacks();
    }

    public Optional<Item> getItemById(int id) {
        return repository.getItemById(id);
    }

    public List<Category> getCategories() {
        return repository.getAllCategories();
    }

    public List<Producer> getProducers() {
        return repository.getAllProducers();
    }

    public Optional<Pack> getPackById(int id) {
        return repository.getPackById(id);
    }

    public Optional<ItemComponent> getItemComponentById(int id) {
        return repository.getItemComponentById(id);
    }
}
