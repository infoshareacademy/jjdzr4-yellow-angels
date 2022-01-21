package pl.infoshare.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Producer {
    private int id;
    public String name;
    private Address address;

    @Override
    public String toString() {
        return "(" +
                id +
                ".) " +
                name;
    }
}
