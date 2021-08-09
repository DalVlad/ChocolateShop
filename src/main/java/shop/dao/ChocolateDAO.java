package shop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import shop.model.chocolate.Chocolate;

import java.util.List;

@Component
public class ChocolateDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ChocolateDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Chocolate> allChocolate(){
        return jdbcTemplate.query("SELECT * FROM Chocolate", new BeanPropertyRowMapper<>(Chocolate.class));
    }

    public Chocolate getChocolate(int id){
        return jdbcTemplate.query("SELECT * FROM Chocolate WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Chocolate.class))
                .stream().findAny().orElse(null);
    }

    public boolean save(Chocolate chocolate){
        List<Chocolate> chocolates = allChocolate();
        for(Chocolate chocolate1: chocolates){
            if(chocolate1.getName().equals(chocolate.getName())){
                return false;
            }
        }
        jdbcTemplate.update("INSERT INTO Chocolate VALUES (DEFAULT , ?, ?, ?)", chocolate.getChocolateColor(),
                chocolate.getCocoaPercentage(), chocolate.getName());
        return true;
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Chocolate WHERE id=?", id);
    }

}
