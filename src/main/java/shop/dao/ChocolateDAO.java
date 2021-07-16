package shop.dao;

import org.springframework.stereotype.Component;
import shop.model.Chocolate;
import shop.model.ChocolateColor;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChocolateDAO {

    private static int INDEX;
    private List<Chocolate> chocolates;

    {
        chocolates = new ArrayList<>();

        chocolates.add(new Chocolate(++INDEX, ChocolateColor.BLACK, 50, "Marks"));
        chocolates.add(new Chocolate(++INDEX, ChocolateColor.BLACK, 90, "Alpen Red"));
        chocolates.add(new Chocolate(++INDEX, ChocolateColor.WHITE, 20, "Milca"));
        chocolates.add(new Chocolate(++INDEX, ChocolateColor.WHITE, 30, "Mequik"));
    }

    public List<Chocolate> allChocolate(){
        return chocolates;
    }

    public Chocolate getChocolate(final int index){
        return chocolates.stream().filter(chocolate -> chocolate.getIndex() == index).findAny().orElse(null);
    }

    public void save(Chocolate chocolate){
        chocolate.setIndex(++INDEX);
        chocolates.add(chocolate);
    }

}
