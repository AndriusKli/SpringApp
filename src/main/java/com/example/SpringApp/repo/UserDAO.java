package com.example.SpringApp.repo;

import com.example.SpringApp.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> getUsers();
    void createUser(User user);
    void deleteUser(String username);
}
