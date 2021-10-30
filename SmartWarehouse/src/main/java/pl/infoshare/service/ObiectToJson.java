package pl.infoshare.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ObiectToJson {

    public void createJSONObject(Object object, String pathway) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String simpleClassName = object.getClass().getSimpleName();
        String fileName = DataTime.getCurrentTime();
        if(ifSaveFile(fileName,simpleClassName)) {
            try {
                objectMapper.writerWithDefaultPrettyPrinter().writeValue(
                        new FileWriter(pathway
                                + DataTime.getCurrentTime() +
                                ".json"), object);
                System.out.println("CREATE FILE: '" + DataTime.getCurrentTime() + "' IN PATH: " + pathway);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Saving file aborted!");
        }
    }

    public boolean ifSaveFile(String fileName, String className) {
        boolean result = false;
        System.out.println("--------------------------------\n" +
                "Do you want to save file?\n" +
                "Name: " + fileName + "\n" +
                "Type: " + className + "\n" +
                "--------------------------------\n" +
                "a) If yes enter 'y', then press enter\n" +
                "b) If no enter any keyboard key, then press enter");
        Scanner scanner = new Scanner(System.in);
        String resultYn = scanner.nextLine();
        if(resultYn.equals("Y") || resultYn.equals("y")) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }


}
