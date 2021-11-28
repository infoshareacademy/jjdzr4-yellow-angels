package pl.infoshare.menu;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    public List<MenuObject> getMenu(){
        return List.of(
                new MenuObject(1, "Stan magazynu", "stock-status"),
                new MenuObject(2, "Lista produktów", "products"),
                new MenuObject(3, "Dodaj produkt", "add-product"),
                new MenuObject(4, "Usuń produkt", "delete-product"),
                new MenuObject(5, "Edytuj produkt", "edit-product"),
                new MenuObject(6, "Wyszukiwarka", "search-engine"));
    }
}
