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

    public boolean save(String name, String phoneNumber){
        long number = 0;
        try {
            number = Long.parseLong(phoneNumber);
        }catch (NumberFormatException e){
            return false;
        }
        if(!inClient(number)){
            client.add(new Client(name, number));
        }
        return true;
    }

    public boolean inClient(long phoneNumber){
        Client client1 = client.stream().filter(client -> client.getPhoneNumber() == phoneNumber).findAny().orElse(null);
        return client.contains(client1);
    }


}
