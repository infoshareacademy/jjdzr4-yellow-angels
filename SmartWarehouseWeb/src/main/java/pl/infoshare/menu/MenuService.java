package pl.infoshare.menu;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    public List<MenuObject> getMenu(){
        return List.of(
                new MenuObject(1, "Sprawdź stan magazynu", "stan_magazynu"),
                new MenuObject(2, "Dodaj produkt", "dodaj_produkt"),
                new MenuObject(3, "Usuń produkt", "usun_produkt"),
                new MenuObject(4, "Edytuj produkt", "edytuj_produkt"),
                new MenuObject(5, "Wyszukiwarka", "wyszukiwarka"));
    }
}
