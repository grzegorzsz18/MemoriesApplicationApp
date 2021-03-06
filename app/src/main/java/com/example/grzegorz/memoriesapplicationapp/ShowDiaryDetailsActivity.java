package com.example.grzegorz.memoriesapplicationapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowDiaryDetailsActivity extends Activity {

    int diaryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_diary_details);
        diaryId = (Integer) getIntent().getExtras().get(ConstantsValues.DIARY_ID);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsValues.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserRetrofitService userService = retrofit.create(UserRetrofitService.class);
        final Call<DiaryPost> call = userService.getDiaryDetail(diaryId, AuthService.getUser().getToken());
        call.enqueue(new retrofit2.Callback<DiaryPost>() {
            @Override
            public void onResponse(Call<DiaryPost> call, retrofit2.Response<DiaryPost> response) {
                if (response.isSuccessful()) {
                    TextView title = (TextView) findViewById(R.id.diaryTitle);
                    TextView date = (TextView) findViewById(R.id.diaryDate);
                    TextView text = (TextView) findViewById(R.id.diaryText);
                    title.setText(response.body().getTitle());
                    date.setText(response.body().getTransformedData());
                    text.setText(response.body().getText());
                }
            }

            @Override
            public void onFailure(Call<DiaryPost> call, Throwable t) {
                Toast.makeText(ShowDiaryDetailsActivity.this, "you have been logged out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ShowDiaryDetailsActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }


    public void removeDiary(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsValues.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserRetrofitService userService = retrofit.create(UserRetrofitService.class);
        final Call<DiaryPost> call = userService.deleteDiary(diaryId, AuthService.getUser().getToken());
        call.enqueue(new retrofit2.Callback<DiaryPost>() {
            @Override
            public void onResponse(Call<DiaryPost> call, retrofit2.Response<DiaryPost> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(ShowDiaryDetailsActivity.this, "diary removed", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(ShowDiaryDetailsActivity.this, "sth wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<DiaryPost> call, Throwable t) {
                Toast.makeText(ShowDiaryDetailsActivity.this, "you have been logged out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ShowDiaryDetailsActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


    }

    public void modify(View view){
        Intent intent = new Intent(ShowDiaryDetailsActivity.this, EditDiaryActivity.class);
        TextView title = (TextView) findViewById(R.id.diaryTitle);
        TextView text = (TextView) findViewById(R.id.diaryText);
        String tit = title.getText().toString();
        String tex = text.getText().toString();
        intent.putExtra(ConstantsValues.DIARY_ID, diaryId);
        intent.putExtra(ConstantsValues.DIARY_TEXT, tex);
        intent.putExtra(ConstantsValues.DIARY_TITLE, tit);
        startActivity(intent);

    }
}
