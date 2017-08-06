package com.example.grzegorz.memoriesapplicationapp;

import java.util.Date;

/**
 * Created by Grzegorz on 2017-08-06.
 */

public class User {
    int id;
    long birthdate;
    String password;
    String login;
    String name;
    String surName;

    public User(String login, String name, String surName, String password, long birthdate) {
        this.login = login;
        this.name = name;
        this.surName = surName;
        this.password = password;
        this.birthdate = birthdate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public long getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(long birthdate) {
        this.birthdate = birthdate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
