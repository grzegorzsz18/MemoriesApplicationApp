package com.example.grzegorz.memoriesapplicationapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowListDiaryActivity extends ListActivity {
    ArrayList<DiaryPost> diaryList = new ArrayList<DiaryPost>();
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ConstantsValues.SERVER_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            UserRetrofitService userService = retrofit.create(UserRetrofitService.class);
            final Call<List<DiaryPost>> call = userService.getAllDiarys(AuthService.getToken());
            call.enqueue(new retrofit2.Callback<List<DiaryPost>>() {
                @Override
                public void onResponse(Call<List<DiaryPost>> call, retrofit2.Response<List<DiaryPost>> response) {
                    if(response.isSuccessful()) {
                        if(response.body() == null){
                            Toast.makeText(ShowListDiaryActivity.this, "Nothing to show", Toast.LENGTH_SHORT).show();
                            ShowListDiaryActivity.super.onBackPressed();
                            return;
                        }
                        for(int i =0 ; i <response.body().size(); i++){
                            DiaryPost diary = new DiaryPost();
                            diary.setId(response.body().get(i).getId());
                            diary.setAuthor(response.body().get(i).getAuthorId());
                            diary.setTitle(response.body().get(i).getTitle());
                            diary.setText(response.body().get(i).getText());
                            diary.setDate(response.body().get(i).getDate());
                            diaryList.add(diary);
                        }
                            ArrayAdapter<DiaryPost> adapter = new ArrayAdapter<DiaryPost>(
                                    ShowListDiaryActivity.this,
                                    android.R.layout.simple_list_item_1,
                                    diaryList
                            );
                            ListView listView = getListView();
                            listView.setAdapter(adapter);
                    }
                }

                @Override
                public void onFailure(Call<List<DiaryPost>> call, Throwable t) {
                    Toast.makeText(ShowListDiaryActivity.this, "you have been logged out", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ShowListDiaryActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            });
        }

    public void onListItemClick(ListView listView,
                                View itemView,
                                int position,
                                long id){
        Intent intent = new Intent(ShowListDiaryActivity.this,ShowDiaryDetailsActivity.class);
        intent.putExtra(ConstantsValues.DIARY_ID,(int)diaryList.get((int)id).getId());

        startActivity(intent);
    }
}
