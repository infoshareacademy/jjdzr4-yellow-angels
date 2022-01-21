package pl.infoshare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.infoshare.model.Item;
import pl.infoshare.repository.ItemComponentRepositoryImpl;
import pl.infoshare.service.ItemComponentService;

@Controller
public class ItemComponentController {

    private final ItemComponentService service;
    private final ItemComponentRepositoryImpl repository;

    public ItemComponentController(ItemComponentService service, ItemComponentRepositoryImpl repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping("/stock")
    public String getStock() {
        return "stock-status";
    }

    @GetMapping("/products")
    public String getAll(Model model) {
        model.addAttribute("items", service.getAll());
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
        return "edit-product";
    }

    @GetMapping("/search-engine")
    public String search() {
        return "search-engine";
    }

    @GetMapping("/add-item")
    public String getAddItem(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("categoriesList", repository.getAllCategories());
        model.addAttribute("producersList", repository.getAllProducers());
        return "add-item";
    }

    @GetMapping("/add-new-item")
    public String getAddItemForm() {
        return "redirect:/index";
    }

    @PostMapping("/add-new-item")
    public String addNewItem(@ModelAttribute("item") Item item) {
        service.saveItem(item);
        return "redirect:/products";
    }

    @GetMapping("/add-pack")
    public String getAddPackForm() {
        return "add-pack";
    }
}
