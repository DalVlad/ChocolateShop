package shop.dao;

import org.springframework.stereotype.Component;
import shop.model.chocolate.Chocolate;
import shop.model.chocolate.ChocolateColor;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChocolateDAO {

    private static int INDEX_CHOCOLATE;
    private List<Chocolate> chocolates;

    {
        chocolates = new ArrayList<>();

        chocolates.add(new Chocolate(++INDEX_CHOCOLATE, ChocolateColor.BLACK, 50, "Marks"));
        chocolates.add(new Chocolate(++INDEX_CHOCOLATE, ChocolateColor.BLACK, 90, "Alpen Red"));
        chocolates.add(new Chocolate(++INDEX_CHOCOLATE, ChocolateColor.WHITE, 20, "Milca"));
        chocolates.add(new Chocolate(++INDEX_CHOCOLATE, ChocolateColor.WHITE, 30, "Mequik"));
    }


    public List<Chocolate> allChocolate(){
        return chocolates;
    }

    public Chocolate getChocolate(int index){
        return chocolates.stream().filter(chocolate -> chocolate.getIndex() == index).findAny().orElse(null);
    }

    public void save(Chocolate chocolate){
        chocolate.setIndex(++INDEX_CHOCOLATE);
        chocolates.add(chocolate);
    }

}
