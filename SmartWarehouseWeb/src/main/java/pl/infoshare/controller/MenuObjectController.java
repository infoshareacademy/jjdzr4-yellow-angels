package pl.infoshare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.infoshare.service.ItemComponentService;
import pl.infoshare.service.MenuObjectService;

@Controller
@RequestMapping
public class MenuObjectController {

    private final ItemComponentService itemComponentService;
    private final MenuObjectService menuService;

    public MenuObjectController(ItemComponentService itemComponentService, MenuObjectService menuService) {
        this.menuService = menuService;
        this.itemComponentService = itemComponentService;
    }

    @GetMapping("/menu")
    public String getMenu(Model model) {
        model.addAttribute("menuObjects", menuService.getMenu());
        return "menu";
    }

    @GetMapping("/stock")
    public String getStock() {
        return "stock-status";
    }

    @GetMapping("/products")
    public String getAll(Model model) {
        model.addAttribute("menuObjects", menuService.getMenu());
        model.addAttribute("items", itemComponentService.getItems());
        model.addAttribute("packs", itemComponentService.getPacks());
        return "products";
    }

    @GetMapping("/add-product")
    public String addItem() {
        return "add-product";
    }

    @GetMapping("/search-engine")
    public String search() {
        return "search-engine";
    }

}
