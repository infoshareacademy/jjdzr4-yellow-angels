package pl.infoshare.model;

import java.util.HashMap;
import java.util.Map;

public class Pack extends ItemComponent {
    private Map<ItemComponent, Integer> items;

    public Pack() {
    }

    public Pack() {
    }

    public Pack(String name, Category category, Producer producer) {
        super(name, category, producer);
        items = new HashMap<>();
    }

    public Pack(int id, String name, Category category, Producer producer) {
        super(id, name, category, producer);
        items = new HashMap<>();
    }

    public Pack(int id, String name, Category category, Producer producer, Map<ItemComponent, Integer> items) {
        super(id, name, category, producer);
        this.items = items;
    }

    public Map<ItemComponent, Integer> getItems() {
        return items;
    }

    public void setItems(Map<ItemComponent, Integer> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return super.toString() +
                "(" + items + ")";
    }
}