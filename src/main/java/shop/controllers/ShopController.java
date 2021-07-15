package shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.dao.ChocolateDAO;

@Controller
public class ShopController {

    private final ChocolateDAO chocolateDAO;

    @Autowired
    public ShopController(ChocolateDAO chocolateDAO) {
        this.chocolateDAO = chocolateDAO;
    }

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("chocolates", chocolateDAO.allChocolate());
        return "home";
    }

    @GetMapping("/product/{index}")
    public String products(@PathVariable("index") int index, Model model){
        model.addAttribute("chocolate", chocolateDAO.getChocolate(index));
        return "product";
    }
}
