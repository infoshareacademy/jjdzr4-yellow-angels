package pl.infoshare;

import pl.infoshare.dataFactory.DataFactory;
import pl.infoshare.service.AddItemService;
import pl.infoshare.service.EditItemService;
import pl.infoshare.service.SearchEngine;
import pl.infoshare.utils.ConsoleInput;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<String> menuOptions = new ArrayList<>();
    private final AddItemService itemService = new AddItemService();

    public void run() {
        menuOptions = fillMenuOptions();
        displayMenu();
        int number = getMenuNumber();
        enterIntoMenuOptions(number);
    }

    private List<String> fillMenuOptions() {

        menuOptions.add("0. Wyjście z programu");
        menuOptions.add("1. Sprawdz stan magazynu ");
        menuOptions.add("2. Dodaj produkt");
        menuOptions.add("3. Usuń produkt");
        menuOptions.add("4. Edytuj produkt");
        menuOptions.add("5. Wyszukiwarka");

        return menuOptions;
    }

    private void displayMenu() {

//        1.text menu : - na bazie listy
        System.out.println("======================");

        for (String i : menuOptions) {
            System.out.println(i);
        }

        System.out.println("======================");

    }

    private int getMenuNumber() {

//        2. Pobieranie nr menu
        int result;
        boolean condition;
        do {
            System.out.println("Podaj nr menu gdzie chcesz wejsc: ");
            result = ConsoleInput.getInputUserInteger();
            condition = result > menuOptions.size() || result < 0;
            if (condition) {
                System.out.println("Brak takiego numeru w menu.");
            }
        } while (condition);
        return result;
    }

    private void enterIntoMenuOptions(int source) {

        switch (source) {
            case 0:
                System.out.println("Zamykam program");
                return;
            case 1:
//                KlasaJakasTam;
                System.out.println("Sprawdzam stan magazynu...");
                DataFactory.getINSTANCE.getItems().forEach(System.out::println);
                break;
            case 2:
                System.out.println("Przechodzę do dodawania produktu...");
                itemService.addItem();
                break;
            case 3:
//                KlasaJakasTam3;
                System.out.println("Usuwam produkt...");
                break;
            case 4:
//                Edycja produktu
                EditItemService.editItem();
                break;
            case 5:
//                Wyszukiwanie;
                SearchEngine search = new SearchEngine();
                search.runSearching();
                break;
        }
        returnToMenu();
    }

    private void returnToMenu() {
        displayMenu();
        enterIntoMenuOptions(getMenuNumber());
    }
}
