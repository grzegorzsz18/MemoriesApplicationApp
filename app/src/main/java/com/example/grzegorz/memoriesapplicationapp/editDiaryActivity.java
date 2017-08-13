package com.example.grzegorz.memoriesapplicationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EditDiaryActivity extends AppCompatActivity {
    int diaryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_diary);
        TextView title = (TextView) findViewById(R.id.titleEditDiary);
        TextView text = (TextView) findViewById(R.id.textEditDiary);
        String tit = (String)getIntent().getExtras().get(ConstantsValues.DIARY_TITLE);
        String tex = (String)getIntent().getExtras().get(ConstantsValues.DIARY_TEXT);
        title.setText(tit);
        text.setText(tex);
        diaryId = (int)getIntent().getExtras().get(ConstantsValues.DIARY_ID);
    }

    public void confirmChanges(View view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsValues.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserRetrofitService userService = retrofit.create(UserRetrofitService.class);
        DiaryPost diaryPost = new DiaryPost();
        TextView title = (TextView) findViewById(R.id.titleEditDiary);
        TextView text = (TextView) findViewById(R.id.textEditDiary);
        diaryPost.setDate(System.currentTimeMillis());
        diaryPost.setTitle(title.getText().toString());
        diaryPost.setText(text.getText().toString());
        diaryPost.setId(diaryId);
        diaryPost.setAuthor(AuthService.getLogin());

        final Call<DiaryPost> call = userService.modifyDiary(diaryPost,AuthService.getToken());
        call.enqueue(new retrofit2.Callback<DiaryPost>() {
            @Override
            public void onResponse(Call<DiaryPost> call, retrofit2.Response<DiaryPost> response) {
                Intent intent = new Intent(EditDiaryActivity.this,ShowListDiaryActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<DiaryPost> call, Throwable t) {
                Toast.makeText(EditDiaryActivity.this, "you have been logged out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EditDiaryActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
