package pl.infoshare.services;

import pl.infoshare.dataFactory.DataFactory;
import pl.infoshare.model.Category;
import pl.infoshare.model.ItemComponent;

import java.util.List;
import java.util.Scanner;

public class ItemService {

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
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextInt();
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
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();

        List<ItemComponent> items = dataFactory.getItems();
        for (ItemComponent item : items) {
            if (id == item.getId()) {
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
        System.out.println("Podaj nową nazwę: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        item.setName(input);
    }

    private static void editCategory(ItemComponent item) {
        List<Category> categories = dataFactory.getCategories();
        System.out.println(categories.toString());
        System.out.println("Aktualna kategoria: "+item.getCategory().getName());
        System.out.println("Wskaż nową kategorię: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        boolean nothingChanged = true;
        for(Category category : categories){
            if(input == category.getId()){
                item.setCategory(categories.get(input));
                System.out.println("Zaktualizowano kategorię produktu.");
                nothingChanged = false;
            }
        }
        if(nothingChanged){
            System.out.println("Brak kategorii o wskazanym id.");
        }
    }

    private static void editProducer(ItemComponent item) {
    }

}
