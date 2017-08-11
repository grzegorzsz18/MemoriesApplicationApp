package com.example.grzegorz.memoriesapplicationapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddDiaryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_diary);
    }

    public void addNewDiary(View view){
        TextView titleTV = (TextView)findViewById(R.id.titleAddDiary);
        TextView textTV = (TextView)findViewById(R.id.textAddDiary);
        DiaryPost diary = new DiaryPost();
        diary.setText(textTV.getText().toString());
        diary.setTitle(titleTV.getText().toString());
        diary.setAuthor(AuthService.getLogin());
        diary.setDate(System.currentTimeMillis());


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsValues.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserRetrofitService userService = retrofit.create(UserRetrofitService.class);
        final Call<ResponseBody> call = userService.addDiary(diary, AuthService.getToken());
        call.enqueue(new retrofit2.Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                if(response.isSuccessful()) {
                    if(response.body() != null){
                        Toast.makeText(AddDiaryActivity.this, "diary created!", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(AddDiaryActivity.this, ShowListDiaryActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(AddDiaryActivity.this, "sth wrong", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(AddDiaryActivity.this, "to nie powinno sie pokazac", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(AddDiaryActivity.this, "you have been logged out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddDiaryActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
