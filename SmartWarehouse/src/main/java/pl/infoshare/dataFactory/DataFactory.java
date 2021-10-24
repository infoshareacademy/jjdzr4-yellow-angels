package pl.infoshare.dataFactory;

import pl.infoshare.model.*;

import java.util.ArrayList;
import java.util.List;

public class DataFactory {
    public static final DataFactory getINSTANCE = new DataFactory();

    private final ArrayList<ItemComponent> items;
    private ArrayList<Category> categories;
    private ArrayList<Producer> producers;

    private DataFactory() {

        Category c1 = new Category("category 1");
        Category c2 = new Category("category 2");
        Category c3 = new Category("category 3");

        Producer p1 = new Producer("producer 1", null);
        Producer p2 = new Producer("producer 2", null);

        items = new ArrayList<>(List.of(
                new Item(1,"Item 1", c1, p1),
                new Item(2,"Item 2", c1, p2),
                new Item(3,"Item 3", c2, p1),
                new Item(4,"Item 4", c3, p1),
                new Pack(5,"Item 5", c3, p1)));

        categories = new ArrayList<>(List.of(
                c1, c2, c3
        ));

        producers = new ArrayList<>(List.of(
                p1, p2
        ));
    }

    public ItemComponent getItemById(int id){
        for (ItemComponent item : items){
            if(id == item.getId()){
                return item;
            }
        }
        return null;
    }




}
