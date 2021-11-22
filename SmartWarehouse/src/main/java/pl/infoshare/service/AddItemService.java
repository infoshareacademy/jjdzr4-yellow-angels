package pl.infoshare.service;

import pl.infoshare.Menu;
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

        String nameInput = setName();
        Category categoryInput = setCategory();
        Producer producerInput = setProducer();
        int id = generateId();

        Item item = new Item(id, nameInput, categoryInput, producerInput);
        factory.getItems().add(item);

        System.out.println("Dodałeś produkt: " + nameInput + " z kategorii: " + categoryInput + ", którego dostawcą jest: " + producerInput + ".");
        System.out.println("Dziękujemy, Twój produkt został dodany.");
    }

    private String setName(){
        System.out.println("Podaj nazwe produktu.");
        System.out.println("Wpisz '0' aby anulować.");
        String nameInput = getInputUserString();
        exitToMenu(nameInput);
        return nameInput;
    }

    private Category setCategory() {
        System.out.println("Podaj kategorię produktu.");
        System.out.println("Wpisz '0' aby anulować.");
        factory.getCategories().forEach(System.out::println);
        int categoryId = getInputUserInteger();

        exitToMenu(categoryId);

        for (Category category : factory.getCategories()) {
            if (category.getId() == categoryId) {
                return category;
            }
        }

        System.out.println("Brak wskazanej kategorii.");

        return setCategory();
    }

    private Producer setProducer() {
        System.out.println("Podaj producenta produktu.");
        System.out.println("Wpisz '0' aby anulować.");
        factory.getProducers().forEach(System.out::println);
        int producerId = getInputUserInteger();

        exitToMenu(producerId);

        for (Producer producer : factory.getProducers()) {
            if (producer.getId() == producerId) {
                return producer;
            }
        }

        System.out.println("Brak wskazanego producenta.");

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

    private void exitToMenu(int input){
        if (0 == input) {
            Menu.getINSTANCE().returnToMenu();
        }
    }

    private void exitToMenu(String input){
        if ("0".equals(input)) {
            Menu.getINSTANCE().returnToMenu();
        }
    }
}



