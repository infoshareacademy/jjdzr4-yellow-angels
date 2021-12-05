package pl.infoshare.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.infoshare.model.ItemComponent;
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

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable int id, Model model){
        model.addAttribute("item", service.getItemById(id));
        return "product";
    }

    @GetMapping("/edit-product/{id}")
    public String editItem(@PathVariable int id, Model model) {
        model.addAttribute("item", service.getItemById(id));
        model.addAttribute("categories", service.getAllCategories());
        model.addAttribute("producers", service.getAllProducers());
        return "edit-product";
    }

    @PutMapping("/edit-product/{id}")
    public String editItem(@PathVariable int id, @RequestBody ItemComponent itemComponent, Model model) {
        service.updateItem(itemComponent);
        model.addAttribute("item", service.getItemById(id));
        return "product";
    }

    @GetMapping("/search-engine")
    public String search() {
        return "search-engine";
    }

}
