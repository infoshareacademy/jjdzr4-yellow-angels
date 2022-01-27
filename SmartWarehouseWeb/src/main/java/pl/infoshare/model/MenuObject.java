package pl.infoshare.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class MenuObject {
    private final int id;
    private final String name;
    private final String landingPage;

    @Override
    public String toString() {
        return name;
    }
}
