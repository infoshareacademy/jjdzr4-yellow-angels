package pl.infoshare.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class ItemComponent {
    private int id;
    private int itemCode; //producer serial number
    private String name;
    private Category category;
    private Producer producer;
    private double weight;
    private LocalDateTime expirationDate;
    private Warehouse localization;

    public ItemComponent(int id, String name, Category category, Producer producer) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.producer = producer;
    }

    public ItemComponent(String name, Category category, Producer producer) {
        this.name = name;
        this.category = category;
        this.producer = producer;
    }

    @Override
    public String toString() {
        return  name +
                ", Category: " + category +
                ", Producer: " + producer;

    }
}
