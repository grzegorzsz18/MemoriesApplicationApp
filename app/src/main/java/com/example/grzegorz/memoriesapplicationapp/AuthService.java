package com.example.grzegorz.memoriesapplicationapp;

/**
 * Created by Grzegorz on 2017-08-05.
 */

public class AuthService {
    static User user;
    public static User getUser(){
        return user;
    }
    public static void setUser(User us){
        user = us;
    }

}
