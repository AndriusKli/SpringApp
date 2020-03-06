package com.example.SpringApp.entity;

public class User {
    private String userName;
    private String name;
    private String surname;
    private String email;

    public User(String userName, String name, String surname, String email) {
        this.userName = userName;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
}
