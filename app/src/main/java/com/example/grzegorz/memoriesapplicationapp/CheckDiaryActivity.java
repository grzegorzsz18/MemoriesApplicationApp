package com.example.grzegorz.memoriesapplicationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CheckDiaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_cruddiary);
    }

    public void goToShowAllDiaryPage(View view){
        Intent intent = new Intent(this,ShowListDiaryActivity.class);
        startActivity(intent);

    }
}
