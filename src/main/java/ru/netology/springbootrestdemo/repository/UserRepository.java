package ru.netology.springbootrestdemo.repository;

import org.springframework.stereotype.Component;
import ru.netology.springbootrestdemo.model.Authorities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserRepository {

    ConcurrentHashMap<String, Map<String, List<Authorities>>> repository = new ConcurrentHashMap<>();

    public UserRepository() {
        addUser("admin", "admin", Authorities.READ, Authorities.DELETE, Authorities.WRITE);
    }

    private void addUser(String user, String password, Authorities... authorities) {
        repository.put(user, new HashMap<>() {{
            put(password, new ArrayList<>());
        }});
        for (Authorities authority : authorities) {
            repository.get(user).get(password).add(authority);
        }

    }


    public List<Authorities> getUserAuthorities(String user, String password) {
        if (repository.containsKey(user) && repository.get(user).containsKey(password)) {
            return repository.get(user).get(password);
        } else {
            return null;
        }
    }
}