package pl.infoshare.service;

import pl.infoshare.dataFactory.DataFactory;
import pl.infoshare.model.Category;
import pl.infoshare.model.ItemComponent;
import pl.infoshare.model.Producer;
import pl.infoshare.utils.ConsoleInput;

import java.util.List;

public class EditItemService {

    private static final DataFactory dataFactory = DataFactory.getINSTANCE;

    public static void editItem() {

        int input;
        ItemComponent item = getItemById();
        if (item == null) {
            System.out.println("Brak produktu o takim id.");
            editItem();
        } else {
            do {
                printMenu();
                input = ConsoleInput.getInputUserInteger();
                switch (input) {
                    case 0:
                        break;
                    case 1:
                        editName(item);
                        break;
                    case 2:
                        editCategory(item);
                        break;
                    case 3:
                        editProducer(item);
                        break;
                }
            } while (input != 0);
        }
    }

    private static ItemComponent getItemById() {

        System.out.println("Podaj id produktu: ");
        int id = ConsoleInput.getInputUserInteger();

        List<ItemComponent> items = dataFactory.getItems();
        for (ItemComponent item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    private static void printMenu() {
        System.out.println("Co chcesz zmienić?");
        System.out.println("0. Nic -> Wyjście.");
        System.out.println("1. Nazwa");
        System.out.println("2. Kategoria");
        System.out.println("3. Producent");
    }

    private static void editName(ItemComponent item) {
        System.out.println("Aktualna nazwa: " + item.getName());
        System.out.println("Podaj nową nazwę: ");
        String input = ConsoleInput.getInputUserString();
        item.setName(input);
    }

    private static void editCategory(ItemComponent item) {
        List<Category> categories = dataFactory.getCategories();
        categories.forEach(System.out::println);
        System.out.println("Aktualna kategoria: " + item.getCategory().getName());
        System.out.println("Wskaż nową kategorię: ");
        int input = ConsoleInput.getInputUserInteger();

        boolean nothingChanged = true;
        for (Category category : categories) {
            if (category.getId() == input) {
                item.setCategory(categories.get(input));
                System.out.println("Zaktualizowano kategorię produktu.");
                nothingChanged = false;
            }
        }
        if (nothingChanged) {
            System.out.println("Brak kategorii o wskazanym id.");
        }
    }

    private static void editProducer(ItemComponent item) {
        List<Producer> producers = dataFactory.getProducers();
        producers.forEach(System.out::println);
        System.out.println("Aktualny producent: " + item.getProducer().getName());
        System.out.println("Wskaż nowego producenta: ");
        int input = ConsoleInput.getInputUserInteger();

        boolean nothingChanged = true;
        for (Producer producer : producers) {
            if (producer.getId() == input) {
                item.setProducer(producers.get(input));
                System.out.println("Zaktualizowano producenta produktu.");
                nothingChanged = false;
            }
        }
        if (nothingChanged) {
            System.out.println("Brak producenta o wskazanym id.");
        }
    }
}
