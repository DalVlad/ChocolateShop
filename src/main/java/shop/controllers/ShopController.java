package shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.dao.ChocolateDAO;
import shop.model.Chocolate;

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

    @GetMapping("/newChocolate")
    public String newChocolate(Model model){
        model.addAttribute("newChocolate", new Chocolate());
        return "newChocolate";
    }

    @PostMapping("/createChocolate")
    public String create(@ModelAttribute("newChocolate") Chocolate chocolate){
        chocolateDAO.save(chocolate);
        return "redirect:/home";
    }



}
