package shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import shop.dao.ChocolateDAO;
import shop.dao.OrderDAO;
import shop.dao.PeopleDAO;
import shop.model.chocolate.Chocolate;

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

    @GetMapping("/product/{id}")
    public String products(@PathVariable("id") int id, Model model){
        model.addAttribute("chocolate", chocolateDAO.getChocolate(id));
        return "product";
    }

    @GetMapping("/newChocolate")
    public String newChocolate(Model model){
        model.addAttribute("newChocolate", new Chocolate());
        return "newChocolate";
    }

    @PostMapping("/createChocolate")
    public String create(@ModelAttribute("newChocolate") Chocolate chocolate){
        if(!chocolateDAO.save(chocolate)){return "error";}
        return "redirect:/home";
    }

    @GetMapping("/order")
    public String order(Model model){
        model.addAttribute("chocolates", chocolateDAO.allChocolate());
        return "order";
    }

    @PostMapping("/orderAccepted")
    public String orderAccepted(@RequestParam("list") int[] chocolate,
                                @ModelAttribute("phoneNumber") String phoneNumber,
                                @RequestParam("name") String name){
        if(!peopleDAO.save(name, phoneNumber)){return "/error";}
        orderDAO.save(chocolate);
        return "redirect:/home";
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMyException(Exception  exception) {
        return "error";
    }

}
