package pl.infoshare.service;

import org.springframework.stereotype.Service;
import pl.infoshare.model.MenuObject;

import java.util.List;

@Service
public class MenuObjectService {

    public List<MenuObject> getMenu(){
        return List.of(
                new MenuObject(1, "Stock status", "stock"),
                new MenuObject(2, "Products", "products"),
                new MenuObject(3, "Add product", "add-product"),
                new MenuObject(4, "Search", "search-engine"));
    }
}
