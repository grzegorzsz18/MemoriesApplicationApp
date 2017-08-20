package com.example.grzegorz.memoriesapplicationapp;


/**
 * Created by Grzegorz on 2017-08-06.
 */

public class User {
    int id=0;
    long birthdate=0;
    String password="";
    String login="";
    String name="";
    String surName="";
    String email;
    String token;

    public User(String login, String name, String surName, String password, long birthdate, String email, String token) {
        this.login = login;
        this.name = name;
        this.surName = surName;
        this.password = password;
        this.birthdate = birthdate;
        this.email = email;
        this.token = token;
    }

    public User(String login, String name, String surName, String password, long birthdate, String email) {
        this.login = login;
        this.name = name;
        this.surName = surName;
        this.password = password;
        this.birthdate = birthdate;
        this.email = email;
    }

    public User(){

    }

    public String getEmail(){ return email;}

    public void setEmail(String email){
        this.email = email;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
