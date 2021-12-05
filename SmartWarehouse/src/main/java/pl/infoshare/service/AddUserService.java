package pl.infoshare.service;

import pl.infoshare.dataFactory.DataFactory;
import pl.infoshare.model.User;
import pl.infoshare.model.UserType;
import pl.infoshare.utils.ConsoleInput;

import java.util.ArrayList;

import static pl.infoshare.model.UserType.COMPANY;
import static pl.infoshare.model.UserType.PRIVATE;
import static pl.infoshare.utils.ConsoleInput.getInputUserInteger;
import static pl.infoshare.utils.ConsoleInput.getInputUserString;

public class AddUserService {


    private static User user;
    private static UserType userType;
    private static final DataFactory factory = DataFactory.getINSTANCE;

    public static boolean isRegistered (String mail) {

        ArrayList<User> users = factory.getUsers();


        return users.stream().map(u -> u.getMail().equals(mail)).findFirst().orElse(false);
    }
    public static User addUser() {
       String name;
       String emailAddress;
       String surname;
       String phoneNumber;
       String login;
       String password;
       UserType PRIVATE,COMPANY;

       System.out.println("======================");
       System.out.println("Witamy w SmartWarehouse!");

       System.out.println("Podaj swoje imie:");
       name = ConsoleInput.getInputUserString();


       System.out.println("Podaj swoje nazwisko:");
       surname = ConsoleInput.getInputUserString();


       System.out.println("Podaj swoj numer telefonu:");
       phoneNumber = ConsoleInput.getInputUserString();


       System.out.println("Podaj swoj adres e-mail:");
       emailAddress = ConsoleInput.getInputUserString();


       System.out.println("Podaj swoj preferowany login:");
       login = ConsoleInput.getInputUserString();


       System.out.println("Podaj haslo, ktore zawiera co najmniej 5 znakow:");
       String passwordTry = ConsoleInput.getInputUserString();
       password = checkPassword(passwordTry);


       System.out.println("Czy jestes klientem prywatnym czy biznesowym? Zaznacz odpowiednia opcje:");
       System.out.println("Wybierz 1 jesli jestes klientem prywatnym lub 2 jesli biznesowym");
       int input = ConsoleInput.getInputUserInteger();
       UserType userType = checkType(input);


       user = new User(name,surname,phoneNumber,emailAddress,login,password, userType);

         return user;

        }
  public static void greetUser() {

       System.out.println("Witaj " + user.getName());
       System.out.println("Twoj login to " + user.getLogin());
       System.out.println("\n" + "W czym mozemy pomoc dzisiaj?");

      }
  public static String checkPassword(String password) {
      boolean condition;
      condition = password.length() <= 5;
      while(condition) {
          System.out.println("Twoje haslo jest za krotkie.");
          System.out.println("Sprobuj jeszce raz.");
          password = ConsoleInput.getInputUserString();
             if(password.length() >= 5) {
                 condition = false;
                 }
            }
      return password;

       }

    public static UserType checkType(int input) {
        int result = input;
        boolean condition = true;
        while (condition) {
            System.out.println("Wpisz w konsole 1 lub 2.");
            input = ConsoleInput.getInputUserInteger();
            if (input == 1  ||  result == 2)  {
               condition = false;
            }

        }
        if(input == 1) {
            return UserType.PRIVATE;
        } else {
            return UserType.COMPANY;
        }

    }
}






