package shop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shop.model.basket.Basket;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDAO {

    private final ChocolateDAO chocolateDAO;
    @Autowired
    public OrderDAO(ChocolateDAO chocolateDAO) {
        this.chocolateDAO = chocolateDAO;
    }

    private List<Basket> basket;
    {
        basket = new ArrayList<>();
    }

    public void save(int[] basket){
        Basket basket1 = new Basket(basket.length);
        for(int i: basket){
            basket1.addChocolates(chocolateDAO.getChocolate(i));
        }
        this.basket.add(basket1);
    }
}
