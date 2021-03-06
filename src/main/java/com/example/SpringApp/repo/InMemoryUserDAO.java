package com.example.SpringApp.repo;

import com.example.SpringApp.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class InMemoryUserDAO implements UserDAO {

    private final List<User> users = new CopyOnWriteArrayList<>();

    @Override
    public List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }

    @Override
    public User getUser(String username) {
        return users.stream().filter(x -> x.getUserName().equals(username)).findFirst().orElse(null);
    }

    @Override
    public void createUser(User user) {
        users.add(user);
    }

    @Override
    public void deleteUser(String username) {
        User user = users.stream().filter(x -> x.getUserName().equals(username)).findFirst().orElse(null);
        if (user != null) {
            users.remove(user);
        } else {
            System.out.println("User not found. Not doing anything.");
        }
    }
}
