package pl.infoshare.dataFactory;

import pl.infoshare.model.ItemComponent;
import pl.infoshare.model.OrderItem;

import java.util.HashMap;
import java.util.Map;

public class ItemsInStock {

    private static Map<ItemComponent, Integer> stock = new HashMap<>();

    public static void addItemToStock(OrderItem order) {
        Integer currentQuantity = stock.get(order.getItemComponent());
        if (currentQuantity == null) {
            stock.put(order.getItemComponent(), order.getQuantity());
        } else {
            stock.put(order.getItemComponent(), currentQuantity + order.getQuantity());

        }
        System.out.println("Dodano " + order.getQuantity() + " sztuk " + order.getItemComponent() + ".");
        System.out.println("Aktualny stan magazynu to " + stock.get(order.getItemComponent()) + "sztuk.");
    }

}
