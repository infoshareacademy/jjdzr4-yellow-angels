package pl.infoshare.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Pack extends ItemComponent{
    private ArrayList<ItemComponent> items;

    public Pack(String name, Category category, Producer producer) {
        super(name, category, producer);
    }


    public void addComponent(ItemComponent item){
        items.add(item);
    }
}
