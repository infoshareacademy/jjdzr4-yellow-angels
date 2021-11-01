package pl.infoshare.service;

import pl.infoshare.dataFactory.DataFactory;
import pl.infoshare.model.ItemComponent;
import pl.infoshare.utils.ConsoleInput;

import java.util.List;

public class DeleteItemService {

    private static final DataFactory factory = DataFactory.getINSTANCE;

    public static void deleteItem(){
        getItemById();
    }

    private static void getItemById() {

        System.out.println("Podaj id produktu, który chcesz usunąć: ");
        factory.getItems().forEach(System.out::println);
        int id = ConsoleInput.getInputUserInteger() - 1;

        List<ItemComponent> items = factory.getItems();
        for (ItemComponent item : items) {
            if (item.getId() == id) {
                factory.getItems().remove(item);
            }
        }

        if (factory.getProducers().size() < id) {
            System.out.println("Brak wskazanego produktu.");
            getItemById();
        }
    }
}
