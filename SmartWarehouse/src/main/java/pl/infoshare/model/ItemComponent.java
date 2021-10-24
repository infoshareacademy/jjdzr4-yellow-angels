package pl.infoshare.model;

import java.time.LocalDateTime;

public abstract class ItemComponent {
    private int id;
    private int itemCode; //producer serial number
    private String name;
    private Category category;
    private Producer producer;
    private double weight;
    private LocalDateTime expirationDate;
    private Warehouse localization;

    public ItemComponent(String name, Category category, Producer producer) {
        this.name = name;
        this.category = category;
        this.producer = producer;
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

    @Override
    public String toString() {
        return "ItemComponent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", producer=" + producer +
                '}';
    }
}
