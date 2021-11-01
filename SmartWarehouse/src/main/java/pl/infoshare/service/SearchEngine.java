package pl.infoshare.service;

import pl.infoshare.dataFactory.DataFactory;

import pl.infoshare.model.ItemComponent;
import pl.infoshare.utils.ConsoleInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SearchEngine {

    private static final DataFactory factory = DataFactory.getINSTANCE;

    public void runSearching() {
        System.out.println("Ile wyników wyświetlić?" + '\n' + "Wprowadź [0] jeśli wszystkie: ");
        int userInputRecords = ConsoleInput.getInputUserInteger();
        List <ItemComponent> result;
        if (userInputRecords == 0){
            result = searchAnyExpressionContains();
        }
        else {
            result = searchAnyExpressionContains(userInputRecords);
        }

        if (result.size() == 0){
            System.out.println("Brak wyników.");
        } else {
            result.forEach(System.out::println);
        }
    }

    private List<ItemComponent> searchAnyExpressionContains() {
        return searchAnyExpressionContains(factory.getItems().size());
    }

    private List<ItemComponent> searchAnyExpressionContains(int numberOfProducts) {
        List<ItemComponent> result = new ArrayList<>();

        Scanner search1 = new Scanner(System.in);
        System.out.println("Wprowadź szukaną frazę: ");
        String userSearchInput = search1.nextLine();

        Pattern anyExpression = Pattern.compile(".*" + userSearchInput + ".*");

        for (ItemComponent item : factory.getItems()) {
            Matcher matcher = anyExpression.matcher(item.getName());

            if (matcher.matches() && result.size() < numberOfProducts) {
                result.add(item);
            }
        }
        return result;
    }
}
