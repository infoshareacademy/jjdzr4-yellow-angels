package pl.infoshare.model;

public class Producer {
    private int id;
    public String name;
    private Address address;

    public Producer(String name) {
        this.name = name;
    }

    public Producer(String name, Address address) {
        this.name = name;
        this.address = address;

    }
}
