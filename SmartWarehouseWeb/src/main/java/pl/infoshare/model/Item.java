package pl.infoshare.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Item extends ItemComponent{

    public Item(String name, Category category, Producer producer) {
        super(name, category, producer);
    }

    public Item(int id, String name, Category category, Producer producer) {
        super(id, name, category, producer);
    }
}