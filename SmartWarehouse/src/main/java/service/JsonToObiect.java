package service;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Scanner;

public class JsonToObiect {

    public <I> I converteJsonFileToDomainObiect(Class<I> cls) {
        System.out.println("Please enter the name of the JSON file you want to convert to the Java Object \n" +
                "NOTE: enter only the name of the file you are looking for (without the .json extension)");
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

   }
