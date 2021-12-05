package pl.infoshare.model;

import java.time.LocalDateTime;

public abstract class ItemComponent {
    private int id;
    private int itemCode; //producer serial number
    private String name;
    private Category category;
    private Producer producer;
    private double weight;
    private double netPrice;
    private int quantity;
    private LocalDateTime expirationDate;
    private Warehouse localization;

    public ItemComponent(int id, String name, Category category, Producer producer) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.producer = producer;
        this.quantity = 0;
    }

    public ItemComponent(String name, Category category, Producer producer) {
        this.name = name;
        this.category = category;
        this.producer = producer;
        this.quantity = 0;
    }

    public ItemComponent(int id, String name, Category category, Producer producer, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.producer = producer;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getNetPrice() {
        return netPrice;
    }
    public void setNetPrice(double netPrice) {
        this.netPrice = netPrice;
    }
    public double getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return  id + ". " +
                name +
                ", Kategoria: " + category +
                ", Producent: " + producer;

    }
}
