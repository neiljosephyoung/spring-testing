package com.njy.cli_tools.controller;

import com.njy.cli_tools.pojo.User;
import com.njy.cli_tools.pojo.dto.UserDTO;
import com.njy.cli_tools.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/validatePhoneNumber")
    public String validatePhoneNumber(@RequestBody @Valid UserDTO userDTO) {
        return "Valid phone number!";
    }


    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok("User added successfully!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userService.findUserById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/**")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody User user) {
        userService.updateUser(new User(id, user.name()));
        return ResponseEntity.ok("User updated successfully!");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully!");
    }
}
