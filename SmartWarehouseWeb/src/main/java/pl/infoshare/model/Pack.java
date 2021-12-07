package pl.infoshare.model;

import java.util.ArrayList;

public class Pack extends ItemComponent {
    private ArrayList<ItemComponent> items;

    public Pack() {
    }

    public Pack(String name, Category category, Producer producer) {
        super(name, category, producer);
        items = new ArrayList<>();
    }

    public Pack(int id, String name, Category category, Producer producer) {
        super(id, name, category, producer);
        items = new ArrayList<>();
    }

    public void addComponent(ItemComponent item) {
        items.add(item);
    }
}