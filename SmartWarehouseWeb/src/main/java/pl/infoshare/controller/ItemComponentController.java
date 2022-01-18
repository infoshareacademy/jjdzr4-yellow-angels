package pl.infoshare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.infoshare.model.Item;
import pl.infoshare.model.Pack;
import pl.infoshare.service.ItemComponentService;
import pl.infoshare.service.MenuObjectService;

@Controller
@RequestMapping
public class ItemComponentController {

    private final ItemComponentService service;
    private final MenuObjectService menuService;

    public ItemComponentController(ItemComponentService service, MenuObjectService menuService) {
        this.service = service;
        this.menuService = menuService;
    }

    @GetMapping("/stock")
    public String getStock() {
        return "stock-status";
    }

    @GetMapping("/products")
    public String getAll(Model model) {
        model.addAttribute("menuObjects", menuService.getMenu());
        model.addAttribute("items", service.getItems());
        model.addAttribute("packs", service.getPacks());
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
        model.addAttribute("item", service.getItemComponentById(id).get());
        return "product";
    }

    @GetMapping("/edit-item/{id}")
    public String editItem(@PathVariable("id") int id, Model model) {
        model.addAttribute("item", service.getItemById(id).get());
        model.addAttribute("categoriesList", service.getCategories());
        model.addAttribute("producersList", service.getProducers());
        return "edit-item";
    }

    @PutMapping(path = "/edit-item/{id}", params = "update")
    public String editItemById(@PathVariable int id,
                               @ModelAttribute("item") Item item,
                               Model model) {

        Item updatedItem = service.updateItem(item);
        model.addAttribute("item", updatedItem);
        return "redirect:/product/{id}";
    }

    @PutMapping(path = "/edit-item/{id}", params = "cancel")
    public String cancelUpdateItem(@PathVariable int id) {
        return "redirect:/products";
    }

    @GetMapping("/edit-pack/{id}")
    public String editPack(@PathVariable("id") int id, Model model) {
        Pack pack = service.getPackById(id).get();
        model.addAttribute("menuObjects", menuService.getMenu());
//        model.addAttribute("pack", factory.getItemComponentById(id));
        model.addAttribute("pack", pack);
//        model.addAttribute("currentPackItems", pack.getItems().keySet());
        model.addAttribute("currentPackItems", pack.getItems());
        model.addAttribute("items", service.getItems());
        model.addAttribute("categoriesList", service.getCategories());
        model.addAttribute("producersList", service.getProducers());
        return "edit-pack";
    }

    @PutMapping(path = "/edit-pack/{id}", params = "update")
    public String editPackById(@PathVariable int id,
                               @ModelAttribute("pack") Pack pack,
                               Model model) {

        Pack updatedPack = service.updatePack(pack);
        model.addAttribute("pack", updatedPack);
        return "redirect:/product/{id}";
    }

    @PutMapping(path = "/edit-pack/{id}", params = "cancel")
    public String cancelUpdatePack(@PathVariable int id) {
        return "redirect:/products";
    }

    @GetMapping("/search-engine")
    public String search() {
        return "search-engine";
    }

    @GetMapping(path = "products", params = "editItem")
    public String goToEditItem(@ModelAttribute("item") Item item) {
        return "redirect:/edit-item/";
    }


    @GetMapping("/add-item")
    public String getAddItemForm() {
        return "add-item";
    }

    @GetMapping("/add-pack")
    public String getAddPackForm() {
        return "add-pack";
    }
}
