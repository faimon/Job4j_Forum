package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final Map<String, User> users = new HashMap<>();

    public UserService() {
        users.put("admin", new User("admin", "123"));
    }

    public void save(User user) {
        users.put(user.getUsername(), user);
    }

    public boolean checkPassUser(User checkedUser) {
        User user = users.get(checkedUser.getUsername());
        if (user == null) {
            return false;
        }
        return user.getUsername().equals(checkedUser.getUsername()) &&
                user.getPassword().equals(checkedUser.getPassword());
    }
}
