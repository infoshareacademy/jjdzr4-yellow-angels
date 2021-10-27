package pl.infoshare.service;

import pl.infoshare.model.Category;
import pl.infoshare.model.ItemComponent;
import pl.infoshare.model.Producer;
import pl.infoshare.model.Item;

import java.util.ArrayList;
import java.util.List;

import static pl.infoshare.utils.ConsoleInput.*;

public class AddItemService {

       List<ItemComponent> items = new ArrayList<>();

       public void addItem() {

        System.out.println("Podaj nazwe produktu.");
        String nameInput = getInputUserString();
        System.out.println("Podaj kategorie produktu.");
        String categoryInput = getInputUserString();
        System.out.println("Podaj nazwe dostawcy produktu.");
        String supplierInput = getInputUserString();

        Item item = new Item(nameInput,
                new Category(categoryInput),
                new Producer(supplierInput));

        items.add(item);

        System.out.println("Dodales produkt o nazwie " + nameInput +" z kategorii " + categoryInput +",ktorego dostawca jest " + supplierInput + ".");
        System.out.println("Dziekujemy, Twoj produkt zostal dodany.");
        System.out.println("Liczba dodanych produktow: " + items.size());

       }

}



