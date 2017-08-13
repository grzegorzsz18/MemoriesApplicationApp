package com.example.grzegorz.memoriesapplicationapp;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.*;
import retrofit.Callback;
import retrofit.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
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

    @PUT("/diary/add/{token}/")
    Call<ResponseBody> addDiary(@retrofit2.http.Body DiaryPost diary, @retrofit2.http.Path("token") String token);

    @GET("diary/byUser/{token}/")
    Call<List<DiaryPost>> getAllDiarys(@retrofit2.http.Path("token") String token);

    @GET("diary/byId/{id}/{token}")
    Call<DiaryPost> getDiaryDetail(@retrofit2.http.Path("id") int id, @retrofit2.http.Path("token") String token);

    @POST("diary/modify/{token}")
    Call<DiaryPost> modifyDiary(@retrofit2.http.Body DiaryPost diaryPost, @retrofit2.http.Path("token") String token);
}
