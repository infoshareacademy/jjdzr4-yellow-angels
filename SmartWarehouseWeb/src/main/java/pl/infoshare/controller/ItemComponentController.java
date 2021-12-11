package pl.infoshare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.infoshare.model.Item;
import pl.infoshare.service.ItemComponentService;

@Controller
@RequestMapping
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
        model.addAttribute("items", service.getAllItemComponents());
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
        model.addAttribute("item", service.getItemById(id));
        return "product";
    }

    @GetMapping("/edit-item/{id}")
    public String editItem(@PathVariable("id") int id, Model model) {
        model.addAttribute("item", service.getItemById(id));
        model.addAttribute("categoriesList", service.getAllCategories());
        model.addAttribute("producersList", service.getAllProducers());
        return "edit-item";
    }

/*    @PostMapping(value = "/edit-item/{id}", params = "update")
    public String editItem(@PathVariable("id") int id,
                           @ModelAttribute("item") Item item,
                           Model model) {

        service.updateItem(item, id);

        model.addAttribute("item", service.getItemById(id));
        return "redirect:/product/{id}";
    }*/

    @PutMapping(path = "/edit-item/{id}", params = "update")
    public String editItemById(@PathVariable int id,
                               @ModelAttribute("item") Item item,
                               Model model) {

//        item = service.getItemById(id);

        Item updatedItem = service.updateItem(item, id);
        model.addAttribute("item", updatedItem);
        return "redirect:/product/{id}";
    }

   /* @PostMapping(value = "/edit-item/{id}", params = "cancel")
    public String cancelEditItem(@PathVariable("id") int id,
                                 @ModelAttribute("item") Item item) {
        return "redirect:/products";
    }*/

//    @PutMapping(value = "/edit-item/{id}", params = "cancel")
//    public String cancelEditItem(@PathVariable("id") int id) {
//        return "redirect:/products";
//    }

    @GetMapping("/search-engine")
    public String search() {
        return "search-engine";
    }

}
