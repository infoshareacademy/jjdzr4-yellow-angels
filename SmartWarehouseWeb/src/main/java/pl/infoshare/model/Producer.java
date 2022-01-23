package pl.infoshare.model;

import java.util.Objects;

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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producer producer = (Producer) o;
        return id == producer.id && Objects.equals(name, producer.name) && Objects.equals(address, producer.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }
}
