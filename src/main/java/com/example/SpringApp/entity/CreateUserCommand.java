package com.example.SpringApp.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class CreateUserCommand {

    @NotNull
    @Length(min = 1, max = 30)
    private String userName;
    @NotNull
    @Length(min = 1, max = 100)
    private String name;
    @NotNull
    @Length(min = 1, max = 100)
    private String surname;
    @NotNull
    @Length(min = 1, max = 200)
    @Email
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }





}
