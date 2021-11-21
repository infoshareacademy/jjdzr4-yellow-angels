package pl.infoshare.SmartWarehouseWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/test")
    public String main() {
        return "index";
    }
}
