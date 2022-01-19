package pl.infoshare.model;

public class Item extends ItemComponent{

    public Item() {
    }

    public Item(String name, Category category, Producer producer) {
        super(name, category, producer);
    }

    public Item(int id, String name, Category category, Producer producer) {
        super(id, name, category, producer);
    }
}