package shop.dao;

import org.springframework.stereotype.Component;
import shop.model.people.Client;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDAO {

    private List<Client> client;
    {
        client = new ArrayList<>();
    }


}
