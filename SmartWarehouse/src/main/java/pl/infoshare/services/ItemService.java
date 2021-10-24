package pl.infoshare.services;

import pl.infoshare.model.ItemComponent;

import java.util.Scanner;

public class ItemService {
    

    public static ItemComponent editItem(ItemComponent item){

        item.toString();

        int input = 0;
        do{
            printMenu();
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextInt();
            switch (input){
                case 0:
                    break;
                case 1:
                    editName(item);
                    break;
                case 2:
                    editCategory(item);
                    break;
                case 3:
                    editProducer(item);
                    break;
            }
        }while (input!=0);

        return item;
    }

    private static void printMenu(){
        System.out.println("Co chcesz zmienić?");
        System.out.println("0. Nic -> Wyjście.");
        System.out.println("1. Nazwa");
        System.out.println("2. Kategoria");
        System.out.println("3. Producent");
    }

    private static void editName(ItemComponent item){
        System.out.println("Podaj nową nazwę: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        item.setName(input);
    }

    private static void editCategory(ItemComponent item) {

    }

    private static void editProducer(ItemComponent item) {
    }

}
