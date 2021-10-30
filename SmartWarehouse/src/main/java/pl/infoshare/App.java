package pl.infoshare;


import pl.infoshare.model.Category;
import pl.infoshare.model.Item;
import pl.infoshare.model.Producer;
import pl.infoshare.service.JsonToObiect;
import pl.infoshare.service.ObiectToJson;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
//        System.out.println( "Yellow Angels" );
//
//        Menu menu = new Menu();
//        menu.run();

        Category category = new Category(1, "Cola");
        Producer producer = new Producer("Pro");

        Item item = new Item("Ala", category, producer);

//        ObiectToJson obiectToJson = new ObiectToJson();
//        obiectToJson.createJSONObject(item, "/home/rob/Desktop/yellowAngelsProjekt/SmartWarehouse/");

        JsonToObiect jsonToObiect = new JsonToObiect();
        Item item1 = jsonToObiect.converteJsonFileToDomainObiect(Item.class, "21:56:15", "/home/rob/Desktop/yellowAngelsProjekt/SmartWarehouse");
        String name = item1.getCategory().getName();
        System.out.println(name);

//  /home/rob/Desktop/yellowAngelsProjekt/SmartWarehouse/21:56:15.json
    }

}
