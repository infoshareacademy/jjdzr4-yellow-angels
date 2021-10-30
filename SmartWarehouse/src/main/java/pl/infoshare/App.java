package pl.infoshare;

import pl.infoshare.model.Address;
import pl.infoshare.model.Category;
import pl.infoshare.model.Item;
import pl.infoshare.model.Producer;
import pl.infoshare.service.JsonToObiect;
import pl.infoshare.service.ObiectToJson;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
//        System.out.println("Yellow Angels");
//
//        Menu menu = new Menu();
//        menu.run();
        Address address = new Address("Polska");
        Category category = new Category(1, "Kategoria1");
        Producer producer = new Producer(1, "Prod001", address );
        Item item = new Item("Item111", category, producer);

        ObiectToJson obiectToJson = new ObiectToJson();
//        obiectToJson.createJSONObject(item, "src/main/");

        JsonToObiect jsonToObiect = new JsonToObiect();
        Item item1 = jsonToObiect.converteJsonFileToDomainObiect(Item.class, "21:42:27", "src/main/");
        System.out.println(item1.toString());


    }
}
