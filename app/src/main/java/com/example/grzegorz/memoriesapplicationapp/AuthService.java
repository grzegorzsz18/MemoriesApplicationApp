package com.example.grzegorz.memoriesapplicationapp;

/**
 * Created by Grzegorz on 2017-08-05.
 */

public class AuthService {
    static String userName ="";
    static String token ;

    public static  String getToken(){
        return token;
    }

    public static String getLogin(){ return userName;}

    public static void setToken(String tok){ token = tok;}

    public static void setUserName(String na){userName = na;}


}
