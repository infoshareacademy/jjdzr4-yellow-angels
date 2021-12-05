package pl.infoshare.model;

public class Item extends ItemComponent{

    public Item(String name, Category category, Producer producer) {
        super(name, category, producer);
    }

    public Item(int id, String name, Category category, Producer producer) {
        super(id, name, category, producer);
    }

    public Item(int id, String name, Category category, Producer producer, double weight, double netPrice)
    {super(id,name,category,producer,weight,netPrice);}
}
