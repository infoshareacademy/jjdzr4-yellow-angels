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
        getCategoryOf(item).ifPresent(item::setCategory);
        getProducerOf(item).ifPresent(item::setProducer);
        repository.saveItem(item);
    }

    private int generateId() {
        return getAll().stream().max(Comparator.comparing(ItemComponent::getId)).get().getId() + 1;
    }

    public Item updateItem(Item item) {
        updateBasicItemComponentData(item);
        return item;
    }

    public Pack updatePack(Pack pack) {
        updateBasicItemComponentData(pack);
        return pack;
    }

    private void updateBasicItemComponentData(ItemComponent itemComponent) {
        int id = itemComponent.getId();
        Optional<ItemComponent> result = repository.getItemComponentById(id);
        if (result.isPresent()) {
            ItemComponent existing = result.get();
            existing.setId(id);
            existing.setName(itemComponent.getName());
            getCategoryOf(itemComponent).ifPresent(existing::setCategory);
            getProducerOf(itemComponent).ifPresent(existing::setProducer);
        }
    }

    private Optional<Category> getCategoryOf(ItemComponent itemComponent) {
        int newItemCategoryId = itemComponent.getCategory().getId();
        return repository.getCategoryById(newItemCategoryId);
    }

    private Optional<Producer> getProducerOf(ItemComponent itemComponent) {
        int newItemCategoryId = itemComponent.getProducer().getId();
        return repository.getProducerById(newItemCategoryId);
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
