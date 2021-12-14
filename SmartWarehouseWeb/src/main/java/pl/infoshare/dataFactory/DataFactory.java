package pl.infoshare.dataFactory;

import pl.infoshare.model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class DataFactory {
    public static final DataFactory getINSTANCE = new DataFactory();

    private List<ItemComponent> itemComponents;
    private List<Category> categories;
    private List<Producer> producers;

    private DataFactory() {

        Category c1 = new Category(1, "category 1");
        Category c2 = new Category(2, "category 2");
        Category c3 = new Category(3, "category 3");

        Producer p1 = new Producer(1, "producer 1", null);
        Producer p2 = new Producer(2, "producer 2", null);
        Producer p3 = new Producer(3, "producer 3", null);

        itemComponents = new ArrayList<>(List.of(
                new Item(1, "Item 1", c1, p1),
                new Item(6, "Item 11", c1, p1),
                new Item(2, "Item 2", c1, p2),
                new Item(3, "Item 3", c2, p3),
                new Item(4, "Item 4", c3, p1),
                new Pack(5, "Item 5", c3, p1)));
        itemComponents.sort(Comparator.comparingInt(ItemComponent::getId));

        categories = new ArrayList<>(List.of(
                c3, c1, c2
        ));
        categories.sort(Comparator.comparingInt(Category::getId));

        producers = new ArrayList<>(List.of(
                p3, p1, p2
        ));
        producers.sort(Comparator.comparingInt(Producer::getId));
    }

    public List<ItemComponent> getItemComponents() {
        return itemComponents;
    }

    public void setItemComponents(List<ItemComponent> itemComponents) {
        this.itemComponents = itemComponents;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public List<Producer> getProducers() {
        return producers;
    }

    public void setProducers(ArrayList<Producer> producers) {
        this.producers = producers;
    }

    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        for (ItemComponent i : itemComponents) {
            if (Item.class == i.getClass()) {
                items.add((Item) i);
            }
        }
        return items;
    }

    public List<Pack> getPacks() {
        List<Pack> packs = new ArrayList<>();
        for (ItemComponent i : itemComponents) {
            if (Pack.class == i.getClass()) {
                packs.add((Pack) i);
            }
        }
        return packs;
    }

    public ItemComponent getItemComponentById(int id) {
        return getItemComponents()
                .stream()
                .filter(i -> i.getId() == id)
                .findFirst().orElse(null);
    }

    public Category findCategoryById(String id) {
        return getCategories().stream().filter(i -> i.getId() == Integer.parseInt(id)).findFirst().orElse(null);
    }

    public Producer findProducerById(String id) {
        return getProducers().stream().filter(i -> i.getId() == Integer.parseInt(id)).findFirst().orElse(null);
    }
}
