package pl.infoshare.service;

import pl.infoshare.dataFactory.DataFactory;
import pl.infoshare.model.ItemComponent;
import pl.infoshare.utils.ConsoleInput;

import java.util.List;

public class DeleteItemService {

    private static final DataFactory factory = DataFactory.getINSTANCE;

    public static void deleteItem() {

        int id = getItemId();

        if (0 == id){
            return;
        }

        List<ItemComponent> items = factory.getItems();
        ItemComponent itemToRemove = null;
        for (ItemComponent item : items) {
            if (item.getId() == id) {
                itemToRemove = item;
            }
        }

        if (itemToRemove == null) {
            System.out.println("Brak wskazanego produktu.");
            deleteItem();
        } else {
            items.remove(itemToRemove);
            System.out.println("Usunięto produkt " + itemToRemove + ".");
        }
    }

    private static int getItemId(){
        System.out.println("Podaj id produktu, który chcesz usunąć: ");
        System.out.println("Wpisz '0' aby anulować.");
        factory.getItems().forEach(System.out::println);
        return ConsoleInput.getInputUserInteger();
    }
}
