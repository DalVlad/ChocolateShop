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


    public List<Chocolate> getObjectChocolates() {
        return chocolates;
    }

    public void setObjectChocolates(List<Chocolate> objectChocolates) {
        this.chocolates = objectChocolates;
    }

    public void addObjectChocolates(Chocolate chocolate) {
        this.chocolates.add(chocolate);
    }

    @Override
    public String toString() {
        return "Basket: " + chocolates;
    }
}
