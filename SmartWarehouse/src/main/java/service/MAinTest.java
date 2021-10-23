package service;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MAinTest {

    public static void main(String[] args) {

        Person person = new Person("Aleksander", 36);

        JsonToObiect jsonToObiect = new JsonToObiect();
        Person person1 = jsonToObiect.jSonToObiectUsingFileReader111(Person.class);
        String name = person1.getName();
        System.out.println("imię: " + name);
    }

}

