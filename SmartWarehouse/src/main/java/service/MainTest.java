package service;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MainTest {
    //KLASA TESTOWA DO USUNIĘCIA

    public static void main(String[] args) {

        Person person = new Person("Aleksander", 36);

//        ObiectToJson obiectToJson = new ObiectToJson();
//        obiectToJson.createJSONObjectOK(person);

        JsonToObiect jsonToObiect = new JsonToObiect();
        Person person1 = jsonToObiect.converteJsonFileToDomainObiect(Person.class);

        //Sprawdzenie:
        int age = person1.getAge();
        System.out.println("Sprawdzenie: " + age);


    }


}

