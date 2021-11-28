package pl.infoshare.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.infoshare.service.MenuObjectService;

@Controller
@RequestMapping
public class MenuObjectController {

    private final MenuObjectService menuService;

    public MenuObjectController(MenuObjectService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("/menu")
    public String getMenu(Model model) {
        model.addAttribute("menuObjects", menuService.getMenu());
        return "menu";
    }
}
