package pl.infoshare;

import pl.infoshare.service.AddItemService;
import pl.infoshare.model.Category;
import pl.infoshare.model.Item;
import pl.infoshare.model.Producer;
import pl.infoshare.services.ItemService;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private List<String> menuOptions = new ArrayList<>();
    private final AddItemService itemService = new AddItemService();

    public void run() {
        menuOptions = fillMenuOptions();
        displayMenu();
        int number = getMenuNumber();
        enterIntoMenuOptions(number);
    }


    private final List<String> fillMenuOptions() {

        menuOptions.add("0. Wyjście z programu");
        menuOptions.add("1. Sprawdz stan magazynu ");
        menuOptions.add("2. Dodaj produkt");
        menuOptions.add("3. Usuń produkt");
        menuOptions.add("4. Edytuj produkt");

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
        int result = 0;
        try {
            Scanner menuNumber = new Scanner(System.in);
            System.out.println("Podaj nr menu gdzie chcesz wejsc: ");
            result = menuNumber.nextInt();
            if (result > menuOptions.size() || result < 0) {
                System.out.println("błędny nr menu");
                getMenuNumber();
            }
        } catch (InputMismatchException e) {
            System.out.println("błąd, wprowadz cyfre");
            getMenuNumber();
        }

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
                ItemService.editItem(0);
                break;

        }
        returnToMenu();
    }

    private void returnToMenu() {
        displayMenu();
        enterIntoMenuOptions(getMenuNumber());
    }
}
