package pl.infoshare.service;

import com.fasterxml.jackson.databind.*;
import java.io.File;

public class JsonToObiect {

    public <I> I converteJsonFileToDomainObiect(Class<I> cls, String fileName, String pathway) {
        I result = null;
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(pathway + fileName + ".json");

        try {
            result = objectMapper.readValue(file, cls);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("\nAn error occured. Pease follow the steps below:\n" +
                    "---------------------------------------------------------------------------------------------\n" +
                    "a) Make sure you entered the correct name of the file you are looking for,\n" +
                    "b) Make sure you have entered the file name only, without any .json extension.\n" +
                    "---------------------------------------------------------------------------------------------");
        }
        return result;
    }
}
