package pl.infoshare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.infoshare.dataFactory.DataFactory;
import pl.infoshare.model.Item;
import pl.infoshare.service.ItemComponentService;

@Controller
@RequestMapping
public class ItemComponentController {

    private final ItemComponentService service;
    private final DataFactory factory = DataFactory.getINSTANCE;

    public ItemComponentController(ItemComponentService service) {
        this.service = service;
    }

    @GetMapping("/stock")
    public String getStock() {
        return "stock-status";
    }

    @GetMapping("/products")
    public String getAll(Model model) {
        model.addAttribute("items", factory.getItemComponents());
        return "products";
    }

    @GetMapping("/add-product")
    public String addItem() {
        return "add-product";
    }

    @GetMapping("/delete-product")
    public String deleteItem() {
        return "delete-product";
    }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("item", factory.getItemById(id));
        return "product";
    }

    @GetMapping("/edit-item/{id}")
    public String editItem(@PathVariable("id") int id, Model model) {
        model.addAttribute("item", factory.getItemById(id));
        model.addAttribute("categoriesList", factory.getCategories());
        model.addAttribute("producersList", factory.getProducers());
        return "edit-item";
    }

    @PutMapping(path = "/edit-item/{id}", params = "update")
    public String editItemById(@PathVariable int id,
                               @ModelAttribute("item") Item item,
                               Model model) {

        Item updatedItem = service.updateItem(item, id);
        model.addAttribute("item", updatedItem);
        return "redirect:/product/{id}";
    }

    @PutMapping(path = "/edit-item/{id}", params = "cancel")
    public String cancelUpdateItem(@PathVariable int id,
                                   Model model) {
        model.addAttribute("items", factory.getItemComponents());
        return "redirect:/products";
    }

    @GetMapping("/search-engine")
    public String search() {
        return "search-engine";
    }

}
