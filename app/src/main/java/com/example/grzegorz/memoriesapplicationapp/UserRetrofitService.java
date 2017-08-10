package com.example.grzegorz.memoriesapplicationapp;
import okhttp3.ResponseBody;
import retrofit2.*;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit2.http.POST;

import retrofit.http.Path;
import retrofit2.http.PUT;

/**
 * Created by Grzegorz on 2017-08-06.
 */

public interface UserRetrofitService {
    @PUT("/user/add/")
    Call<ResponseBody> addUser(@retrofit2.http.Body User body);

    @POST("/user/getToken/")
    Call<ResponseBody> getToken(@retrofit2.http.Body User user);
}
