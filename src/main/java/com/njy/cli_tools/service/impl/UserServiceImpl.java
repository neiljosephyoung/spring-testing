package com.njy.cli_tools.service.impl;

import com.njy.cli_tools.mapper.UserMapper;
import com.njy.cli_tools.pojo.User;
import com.njy.cli_tools.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public void addUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public User findUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }
}
