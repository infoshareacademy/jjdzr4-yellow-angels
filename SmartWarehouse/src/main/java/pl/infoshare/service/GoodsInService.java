package pl.infoshare.service;


import pl.infoshare.dataFactory.DataFactory;
import pl.infoshare.model.Category;
import pl.infoshare.model.Item;
import pl.infoshare.model.ItemComponent;
import pl.infoshare.model.Producer;
import pl.infoshare.utils.ConsoleInput;

import java.util.Optional;
import java.util.Random;

import static pl.infoshare.utils.ConsoleInput.getInputUserInteger;
import static pl.infoshare.utils.ConsoleInput.getInputUserString;

public class GoodsInService {

    private static final DataFactory factory = DataFactory.getINSTANCE;

    public static void run() {
        int id = chooseItemComponent();
        int quantity = incrementItemQuantity();
    }


    private static int chooseItemComponent() {

        System.out.println("Wybierz produkt, ktory chcesz przyjac do magazynu.");

        boolean isInWarehouse;
        int input = 0;
        do {
            factory.getItems().forEach(System.out::println);
            System.out.println("Wybierz number z listy produktow, ktory chcesz wprowdzic do magazynu.");
            input = ConsoleInput.getInputUserInteger();
            int finalInput = input;
            if (factory.getItems().stream().anyMatch(itemComponent -> itemComponent.getId() == finalInput)
            ) {
                isInWarehouse = true;
            } else {
                isInWarehouse = false;
                System.out.println("Nie ma takiego produktu.");

            }
        }
        while (!isInWarehouse);

        return input;
    }

    private static int incrementItemQuantity() {
        System.out.println("Podaj ilosc towaru.");
        return ConsoleInput.getInputUserInteger();

    }


}



