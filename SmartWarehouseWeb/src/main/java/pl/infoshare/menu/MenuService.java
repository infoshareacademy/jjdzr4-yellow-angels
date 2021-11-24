package pl.infoshare.menu;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    public List<MenuObject> getMenu(){
        return List.of(
                new MenuObject(1, "Stan magazynu", "stan-magazynu"),
                new MenuObject(2, "Lista produktów", "lista-produktow"),
                new MenuObject(3, "Dodaj produkt", "dodaj-produkt"),
                new MenuObject(4, "Usuń produkt", "usun-produkt"),
                new MenuObject(5, "Edytuj produkt", "edytuj-produkt"),
                new MenuObject(6, "Wyszukiwarka", "wyszukiwarka"));
    }
}
