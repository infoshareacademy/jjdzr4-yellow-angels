package pl.infoshare;
import pl.infoshare.model.User;
import pl.infoshare.service.AddUserService;

import static pl.infoshare.service.AddUserService.addUser;
import static pl.infoshare.service.AddUserService.greetUser;

/**
 * Hello world!
 *
 */
public class App 
{


    public static void main(String[] args )
    {
        System.out.println( "Tres Hombres Ltd" );

        addUser();
        greetUser();


        Menu menu = new Menu();
        menu.run();
    }
}
