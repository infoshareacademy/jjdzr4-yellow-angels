package service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataOutput;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;


public class JsonToObiect {
//https://stackoverflow.com/questions/17712052/convert-json-string-to-generic-object-in-java-with-gson
//https://stackoverflow.com/questions/17712052/convert-json-string-to-generic-object-in-java-with-gson
//https://www.youtube.com/watch?v=Bq7WBXd6gEg&ab_channel=JavaHangout

    //TA METODA SPEŁNIA ZAŁOŻENIA TASKU
    public <I> I converteJsonFileToDomainObiect(Class<I> cls) {
        System.out.println("Prosze wpisz nazwę szukanego pliku JSON, który chcesz skonwertować do postaci Obiektu Java\n" +
                "UWAGA: wpisz jedynie nazwę szukanego pliku (bez rozszeżenia .json)");
        String projectDirectory = PathsClasses.getProjecDirectory();
        Scanner scanner = new Scanner(System.in);
        String nazwa = scanner.nextLine();
        I result = null;
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(projectDirectory + nazwa + ".json");
        try {
         result = objectMapper.readValue(file,cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    //NA POTRZEBY TESTOWANIA, METODA, PRZYJMUJE NAZWĘ SZUKANEGO PLIKU DO SWOJEJ SYGNATURY
    public <I> I converteJsonFileToDomainObiect001(Class<I> cls, String nazwa) {
        System.out.println("Prosze wpisz nazwę pliku o rozszeżeniu JSON, który chcesz skonwertować do postaci Obiektu Java");
        String projectDirectory = PathsClasses.getProjecDirectory();
//        Scanner scanner = new Scanner(System.in);
//        String nazwa = scanner.nextLine();
        I result = null;
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(projectDirectory + nazwa + ".json");
        try {
            result = objectMapper.readValue(file,cls);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public <I> I jSonToObiectUsingFileReader111(Class<I> cls) {

//        System.out.println("Prosze wpisz nazwę pliku o rozszeżeniu JSON, który chcesz skonwertować do postaci Obiektu Java");
//        Scanner scanner = new Scanner(System.in);
//        String nazwa = scanner.nextLine();

        I result = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            FileReader fileReader = new FileReader("/home/rob/Desktop/YellowAngels1/SmartWarehouse/Person 21:29:09.json");

            //     Person person = objectMapper.readValue(fileReader, Person.class);
            result = objectMapper.readValue(fileReader, cls);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
///home/rob/Desktop/YellowAngels1/SmartWarehouse/PersonTest 2021-10-22 20:40:59 .json

   private String getClassNameFromFileName(String s) {
        //do metody prześlemy Stringa z nazwą naszego pliku, w której na pierwszym miejsu widnieje
       String[] split = s.split(" ");
       String clasName = split[0];
     return clasName + ".class";
   }


   }
