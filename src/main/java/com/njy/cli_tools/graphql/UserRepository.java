package com.njy.cli_tools.graphql;


import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public class UserRepository {
    private final Map<Long, User> users = new HashMap<>();
    private long idCounter = 1;

    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    public User getUserById(Long id) {
        return users.get(id);
    }

    public User saveUser(String name, String email) {
        User user = new User(idCounter++, name, email);
        users.put(user.id(), user);
        return user;
    }
}