package com.njy.cli_tools.graphql;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
public class UserGraphQLController {

    private final UserRepository userRepository;

    public UserGraphQLController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @QueryMapping
    public List<User> users() {
        return userRepository.getUsers();
    }

    @QueryMapping
    public User userById(@Argument Long id) {
        return userRepository.getUserById(id);
    }

    @MutationMapping
    public User createUser(@Argument String name, @Argument String email) {
        return userRepository.saveUser(name, email);
    }
}

