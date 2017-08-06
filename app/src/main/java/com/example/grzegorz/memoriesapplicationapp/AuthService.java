package com.example.grzegorz.memoriesapplicationapp;

import java.util.Date;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Grzegorz on 2017-08-05.
 */

public class AuthService {
    static String userName ="";
    static String token;

    public static  String getToken(){
        return token;
    }

    public static boolean login(String userN, String password){
        if(userN.equalsIgnoreCase("login") && password.equalsIgnoreCase("password")){
            return true;
        }
        return false;
        /*userName = userN;
        // rest do serwisów o zwrot tokena
        token = "zwrocona wartosc";
        if(token == null){
            return false;
        }
        return true;
        */
    }
    public static void createNewUser(String name, String sName, String login, String password){
        User user = new User(login,name,sName,password,(new Date((System.currentTimeMillis()))).getTime());
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://145.239.84.11:8080/")
                .build();
        UserRetrofitService userService = restAdapter.create(UserRetrofitService.class);
        userService.addUser(user,new Callback<User>(){
            public void success(User user, Response response){
        }
            @Override
            public void failure(RetrofitError error) {
            }
        });
    }



}
