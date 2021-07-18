package shop.model.basket;


import shop.model.chocolate.Chocolate;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    private List<Chocolate> chocolates;


    public Basket(){}

    public Basket(int quantity) {
        this.chocolates = new ArrayList<>(quantity);
    }

    public List<Chocolate> getChocolates() {
        return chocolates;
    }

    public void setChocolates(List<Chocolate> objectChocolates) {
        this.chocolates = objectChocolates;
    }

    public void addChocolates(Chocolate chocolate) {
        this.chocolates.add(chocolate);
    }

    @Override
    public String toString() {
        return "Basket: " + chocolates;
    }
}
