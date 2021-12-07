package pl.infoshare.model;

public class Producer {
    private int id;
    public String name;
    private Address address;

    public Producer(String name) {
        this.name = name;
    }

    public Producer(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    /*@Override
    public String toString() {
        return "(" +
                id +
                ".) " +
                name;
    }*/

    @Override
    public String toString() {
        return name;
    }
}
