package pl.infoshare.service;


import pl.infoshare.dataFactory.DataFactory;
import pl.infoshare.dataFactory.ItemsInStock;
import pl.infoshare.model.*;
import pl.infoshare.utils.ConsoleInput;

import java.util.Optional;
import java.util.Random;

import static pl.infoshare.utils.ConsoleInput.getInputUserInteger;
import static pl.infoshare.utils.ConsoleInput.getInputUserString;

public class GoodsInService {

    private static final DataFactory factory = DataFactory.getINSTANCE;

    public static void run() {
        ItemComponent item = chooseItemComponent();
        int quantity = incrementItemQuantity();
        OrderItem order = new OrderItem(item,quantity);
        ItemsInStock.addItemToStock(order);
    }


    private static ItemComponent chooseItemComponent() {

        System.out.println("Wybierz produkt, ktory chcesz przyjac do magazynu.");
        ItemComponent item = null;
        boolean isInWarehouse;

        do {
            factory.getItems().forEach(System.out::println);
            System.out.println("Wybierz number z listy produktow, ktory chcesz wprowdzic do magazynu.");
            int input = ConsoleInput.getInputUserInteger();

            Optional<ItemComponent> optionalItemComponent = factory.getItems().stream().filter(itemComponent -> itemComponent.getId() == input).findFirst();
            if (optionalItemComponent.isPresent()
            ) {
                item = optionalItemComponent.get();
                isInWarehouse = true;
            } else {
                isInWarehouse = false;
                System.out.println("Nie ma takiego produktu.");

            }
        }
        while (!isInWarehouse);

        return item;
    }

    private static int incrementItemQuantity() {
        System.out.println("Podaj ilosc towaru.");
        return ConsoleInput.getInputUserInteger();

    }

}



