package pl.infoshare.service;

public class Produkt {

    public static void main(String[] args) {

        Produkt produkt = new Produkt("AAA", 200);

        ObiectToJson obiectToJson = new ObiectToJson();
//        obiectToJson.createJSONObject(produkt, "src/main/");

        JsonToObiect jsonToObiect = new JsonToObiect();
        Produkt produkt1 = jsonToObiect.converteJsonFileToDomainObiect(Produkt.class, "13:27:55", "src/main/");
        String nazwa = produkt1.getNazwa();
        System.out.println(nazwa);
    }

    public Produkt() {
    }

    String nazwa;
    int wartosc;

    public Produkt(String cena, int wartosc) {
        this.nazwa = cena;
        this.wartosc = wartosc;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getWartosc() {
        return wartosc;
    }

    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }
}
