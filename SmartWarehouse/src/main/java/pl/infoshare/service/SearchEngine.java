package pl.infoshare.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import pl.infoshare.dataFactory.DataFactory;
import pl.infoshare.model.Item;
import pl.infoshare.model.ItemComponent;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SearchEngine {

    private static final DataFactory factory = DataFactory.getINSTANCE;


    public void runSearching() {
        fileListCreator();
        System.out.println(searchAnyExpressionContains());
    }


//        wyszukiwanie czy fraza zawiera sie w ...

    private List<ItemComponent> searchAnyExpressionContains() {
        List<ItemComponent> result = new ArrayList<>();

        Scanner search1 = new Scanner(System.in);
        System.out.println("Wprowadź szukaną frazę: ");
        String userSearchInput = search1.nextLine();

        Pattern anyExpression = Pattern.compile(".*" + userSearchInput + ".*");

        for (ItemComponent item : factory.getItems()) {
            Matcher matcher = anyExpression.matcher(item.getName());

            if (matcher.matches()) {
                result.add(item);
            }
        }

        return result;
    }

//        wyszukiwanie konkretnej frazy

    private void searchDirectExpression() {

        Scanner search1 = new Scanner(System.in);
        System.out.println("Wprowadź szukaną frazę: ");
        String userSearchInput = search1.nextLine();

        Pattern directExpression = Pattern.compile(userSearchInput);
    }

//iterowanie po plikach json ?

    private void iterateOnList() {
    }


//    tworzenie listy do przesukiwania

    private void fileListCreator() {

//        Map<String,List<Item>> groupedItems = new HashMap<>(); <- jak to użyć ?

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        String jsonPathName = "src/main/resources"; // <- musi być podana prawidłowa ścieżka do plików .json
        File jsonDirectory = new File(jsonPathName);

        if (jsonDirectory.isDirectory()) {
            List<File> files = new ArrayList<>(Arrays.asList(jsonDirectory.listFiles()));

            System.out.println(files); // <- zwraca listę plików json

            for (File f : files) {

                try {
                    Item item = mapper.readValue(new FileReader(f), Item.class); // <- odczytuje zawartość pliku ?

                    System.out.println(item);  // testowy sout

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
