package pl.infoshare.menu;

public class MenuObject {
    private final int id;
    private final String name;
    private final String landingPage;

    public MenuObject(int id, String name, String landingPageName) {
        this.id = id;
        this.name = name;
        this.landingPage = landingPageName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLandingPage() {
        return landingPage;
    }

    @Override
    public String toString() {
        return id +
                ". " + name;
    }
}
