package com.example.grzegorz.memoriesapplicationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onBackPressed(){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView name = (TextView)findViewById(R.id.userName);
        TextView surName = (TextView)findViewById(R.id.userSurname);
        TextView email = (TextView)findViewById(R.id.userEmail);
        name.setText(AuthService.getUser().getName());
        surName.setText(AuthService.getUser().getSurName());
        email.setText(AuthService.getUser().getEmail());
    }

    public void goToDiaryChoosePage(View view){
        Intent intent = new Intent(this,CheckDiaryActivity.class);
        startActivity(intent);
    }
}
