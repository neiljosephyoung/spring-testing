package com.njy.cli_tools.service;

import com.njy.cli_tools.pojo.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    User findUserById(int id);
    List<User> findAllUsers();
    void updateUser(User user);
    void deleteUser(int id);
}
