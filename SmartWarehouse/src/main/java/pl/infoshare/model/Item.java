package pl.infoshare.model;

import java.io.Serializable;

public class Item extends ItemComponent implements Serializable {


//DODAŁEM:
private Item() {
    super();
}

    public Item(String name, Category category, Producer producer) {
        super(name, category, producer);
    }

    public Item(int id, String name, Category category, Producer producer) {
        super(id, name, category, producer);
    }

    //DODAŁEM:
    @Override
    public String toString() {
        return "Item{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", category=" + getCategory() +
                ", producer=" + getProducer() +
                '}';
    }

}
