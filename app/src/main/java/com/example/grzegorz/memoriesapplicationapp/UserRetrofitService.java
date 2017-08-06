package com.example.grzegorz.memoriesapplicationapp;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.PUT;

/**
 * Created by Grzegorz on 2017-08-06.
 */

public interface UserRetrofitService {
    @PUT("/user/add/")
    void addUser(@Body User body, Callback<User> user);
}
