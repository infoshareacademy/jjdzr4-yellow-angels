package pl.infoshare.service;

import pl.infoshare.dataFactory.DataFactory;
import pl.infoshare.model.Category;
import pl.infoshare.model.Item;
import pl.infoshare.model.ItemComponent;
import pl.infoshare.model.Producer;

import java.util.Random;

import static pl.infoshare.utils.ConsoleInput.getInputUserInteger;
import static pl.infoshare.utils.ConsoleInput.getInputUserString;

public class AddItemService {

    private static final DataFactory factory = DataFactory.getINSTANCE;

    public void addItem() {

        System.out.println("Podaj nazwe produktu.");
        String nameInput = getInputUserString();
        Category categoryInput = setCategory();
        Producer producerInput = setProducer();
        int id = generateId();

        Item item = new Item(id, nameInput, categoryInput, producerInput);
        factory.getItems().add(item);

        System.out.println("Dodałeś produkt: " + nameInput + " z kategorii: " + categoryInput + ", którego dostawcą jest: " + producerInput + ".");
        System.out.println("Dziękujemy, Twój produkt został dodany.");
    }

    private Category setCategory() {
        System.out.println("Podaj kategorię produktu.");
        factory.getCategories().forEach(System.out::println);
        int categoryId = getInputUserInteger();
        if (factory.getCategories().size() > categoryId) {
            return factory.getCategories().get(categoryId);
        } else {
            System.out.println("Brak wskazanej kategorii.");
        }
        return setCategory();
    }

    private Producer setProducer() {
        System.out.println("Podaj producenta produktu.");
        factory.getProducers().forEach(System.out::println);
        int producerId = getInputUserInteger();
        if (factory.getProducers().size() > producerId) {
            return factory.getProducers().get(producerId);
        } else {
            System.out.println("Brak wskazanego producenta.");
        }
        return setProducer();
    }

    public int generateId() {
        Random random = new Random();
        int id = random.nextInt();
        for (ItemComponent item : factory.getItems()) {
            if (item.getId() == id || id < 0) {
                return generateId();
            }
        }
        return id;
    }
}



