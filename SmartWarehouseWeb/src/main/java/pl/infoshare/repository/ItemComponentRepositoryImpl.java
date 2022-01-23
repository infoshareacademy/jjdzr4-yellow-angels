package pl.infoshare.repository;

import org.springframework.stereotype.Repository;
import pl.infoshare.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ItemComponentRepositoryImpl implements ItemComponentRepository{

    private final List<Category> categories = getAllCategories();
    private final List<Producer> producers = getAllProducers();
    private final List<Item> items = new ArrayList<>(List.of(
            new Item(1, "Item 1", categories.get(0), producers.get(0)),
            new Item(6, "Item 11", categories.get(0), producers.get(0)),
            new Item(2, "Item 2", categories.get(0), producers.get(1)),
            new Item(3, "Item 3", categories.get(1), producers.get(2)),
            new Item(4, "Item 4", categories.get(2), producers.get(0))));

    @Override
    public List<Item> getAllItems() {
        return items;
    }

    @Override
    public List<Pack> getAllPacks() {
        List<Category> categories = getAllCategories();
        List<Producer> producers = getAllProducers();
        return new ArrayList<>(List.of(
                new Pack(5, "Item 5", categories.get(2), producers.get(0))));
    }

    @Override
    public List<ItemComponent> getAll() {
        List<ItemComponent> itemComponents = new ArrayList<>(getAllItems());
        itemComponents.addAll(getAllPacks());
        return itemComponents;
    }

    @Override
    public List<Category> getAllCategories() {
        return new ArrayList<>(List.of(
                new Category(1, "category 1"),
                new Category(2, "category 2"),
                new Category(3, "category 3")));
    }

    @Override
    public List<Producer> getAllProducers() {
        return new ArrayList<>(List.of(
                new Producer(1, "producer 1", new Address()),
                new Producer(2, "producer 2", new Address()),
                new Producer(3, "producer 3", new Address())));
    }

    @Override
    public void saveItem(Item item) {
        items.add(item);
    }

    @Override
    public void savePack(Pack pack) {
        getAllPacks().add(pack);
    }

    @Override
    public Optional<Item> getItemById(int id) {
        List<Item> items = getAllItems();
        return items.stream().filter(i -> i.getId() == id).findFirst();
    }

    @Override
    public Optional<Pack> getPackById(int id) {
        List<Pack> packs = getAllPacks();
        return packs.stream().filter(i -> i.getId() == id).findFirst();
    }

    @Override
    public Optional<Category> getCategoryById(int id) {
        List<Category> categories = getAllCategories();
        return categories.stream().filter(i -> i.getId() == id).findFirst();
    }

    @Override
    public Optional<Producer> getProducerById(int id) {
        List<Producer> producers = getAllProducers();
        return producers.stream().filter(i -> i.getId() == id).findFirst();
    }
}