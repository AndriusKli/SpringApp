package com.example.SpringApp.controller;

import com.example.SpringApp.entity.CreateUserCommand;
import com.example.SpringApp.entity.User;
import com.example.SpringApp.repo.UserDAO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "user")
@RequestMapping(value = "/users")
public class UserController {
    private final UserDAO userDao;

    @Autowired
    public UserController(UserDAO userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Get users", notes = "Returns a list of registered users.")
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create user", notes = "Creates a new user.")
    public void createUser(@RequestBody final CreateUserCommand createUserCommand) {
        userDao.createUser(new User(createUserCommand.getUserName(), createUserCommand.getName(), createUserCommand.getSurname(), createUserCommand.getEmail()));
        System.out.println(createUserCommand);
    }

// Dummy value @  localhost:1234/users
//    {
//        "email": "kliunka@gmail.com",
//        "name": "andrius",
//        "surname": "kliunka",
//        "userName": "andriuxxx"
//    }
//
//    http://localhost:1234/swagger-ui.html

    @RequestMapping(path = "/{userName}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Deletes user", notes = "Deletes user by their username.")
    public void deleteUser(@PathVariable final String userName) {
        userDao.deleteUser(userName);
        System.out.println("Deleting user: " + userName);
    }
}
