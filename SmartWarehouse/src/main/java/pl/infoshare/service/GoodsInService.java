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

    public static int chooseItemComponent() {

        System.out.println("Wybierz produkt dla ktory chcesz przyjac do magazynu.");
        DataFactory.getINSTANCE.getItems().forEach(System.out::println);
        System.out.println("Wybierz number z listy produktow, ktory chcesz wprowdzic do magazynu.");
        boolean isInWarehouse;
        int input = ConsoleInput.getInputUserInteger();
        do {

            if (input <= factory.getItems().size()) {
                isInWarehouse = true;
            } else {
                isInWarehouse = false;
                System.out.println("Nie ma takiego produktu.");
                DataFactory.getINSTANCE.getItems().forEach(System.out::println);
                System.out.println("Wybierz number z listy produktow, ktory chcesz wprowdzic do magazynu.");
                input = ConsoleInput.getInputUserInteger();
            }
        }
            while (!isInWarehouse) ;{
                System.out.println("Nie ma takiego produktu.");
                DataFactory.getINSTANCE.getItems().forEach(System.out::println);
                System.out.println("Wybierz number z listy produktow, ktory chcesz wprowdzic do magazynu.");
                input = ConsoleInput.getInputUserInteger();
            if (input <= factory.getItems().size()) {
                isInWarehouse = true;
            }
        }

        return input;
        }

    }

