package com.example.grzegorz.memoriesapplicationapp;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReminderDetails extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsValues.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        int id = (int)getIntent().getExtras().get(ConstantsValues.CALENDAR_ID);
        UserRetrofitService userService = retrofit.create(UserRetrofitService.class);
        final Call<Calendar> call = userService.getCalendarById(AuthService.getUser().getToken(),id);
        call.enqueue(new retrofit2.Callback<Calendar>() {
            @Override
            public void onResponse(Call<Calendar> call, retrofit2.Response<Calendar> response) {
                if (response.isSuccessful()) {
                    if (response.body() == null) {
                        return;
                    }
                }

            }

            @Override
            public void onFailure(Call<Calendar> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "you have been logged out", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
