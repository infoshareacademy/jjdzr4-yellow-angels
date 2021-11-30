package pl.infoshare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.infoshare.service.ItemComponentService;

@Controller
public class ItemComponentController {

    private final ItemComponentService service;

    public ItemComponentController(ItemComponentService service) {
        this.service = service;
    }

    @GetMapping("/stock")
    public String getStock() {
        return "stock-status";
    }

    @GetMapping("/products")
    public String getAll(Model model) {
        model.addAttribute("items", service.getAllItems());
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

    @GetMapping("/edit-product")
    public String editItem() {
        return "delete-product";
    }

    @GetMapping("/product/{id}")
    public String itemForm(@PathVariable int id, Model model) {
        model.addAttribute("item", service.getItemById(id));
        return "item";
    }

    @PostMapping("/edit-product")
    public String submit(){
        return "result";
    }

    @GetMapping("/search-engine")
    public String search() {
        return "search-engine";
    }

}
