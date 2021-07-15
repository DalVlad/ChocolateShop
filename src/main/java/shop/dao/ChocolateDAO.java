package shop.dao;

import org.springframework.stereotype.Component;
import shop.model.Chocolate;
import shop.model.ChocolateColor;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChocolateDAO {

    private static int INDEX;
    private List<Chocolate> chocolate;

    {
        chocolate = new ArrayList<>();

        chocolate.add(new Chocolate(++INDEX, ChocolateColor.BLACK, 50));
        chocolate.add(new Chocolate(++INDEX, ChocolateColor.BLACK, 90));
        chocolate.add(new Chocolate(++INDEX, ChocolateColor.WHITE, 20));
//        chocolate.add(new Chocolate(++INDEX, ChocolateColor.WHITE, 30));
    }

    public List<Chocolate> allChocolate(){
        return chocolate;
    }

    public Chocolate getChocolate(final int index){
        return chocolate.stream().filter(chocolate -> chocolate.getIndex() == index).findAny().orElse(null);
    }

}
