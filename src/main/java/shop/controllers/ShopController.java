package shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import shop.dao.ChocolateDAO;
import shop.dao.OrderDAO;
import shop.dao.PeopleDAO;
import shop.model.basket.Basket;
import shop.model.chocolate.Chocolate;
import shop.model.people.Client;

import java.util.ArrayList;


@Controller
public class ShopController {

    private final ChocolateDAO chocolateDAO;
    private final PeopleDAO peopleDAO;
    private final OrderDAO orderDAO;

    @Autowired
    public ShopController(ChocolateDAO chocolateDAO, PeopleDAO peopleDAO, OrderDAO orderDAO) {
        this.chocolateDAO = chocolateDAO;
        this.peopleDAO = peopleDAO;
        this.orderDAO = orderDAO;
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

    @GetMapping("/order")
    public String order(Model model){
        model.addAttribute("chocolates", chocolateDAO.allChocolate());
        model.addAttribute("list", new ArrayList<Integer>());
//        model.addAttribute("client", new Client());
        return "order";
    }

    @PostMapping("/orderAccepted")
    public String orderAccepted(@RequestParam("list") int[] chocolate){
        orderDAO.save(chocolate);
        return "redirect:/home";
    }


}
