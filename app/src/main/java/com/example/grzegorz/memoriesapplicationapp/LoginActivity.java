package com.example.grzegorz.memoriesapplicationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view){
        TextView loginTextView = (TextView)findViewById(R.id.loginLogin);
        String login = loginTextView.getText().toString();
        TextView passwordTextView = (TextView)findViewById(R.id.loginPassword);
        String password = passwordTextView.getText().toString();
        if(AuthService.login(login,password) == false){
            TextView errorField = (TextView)findViewById(R.id.loginErrorMessageField);
            errorField.setText("Wrong login or password");
            return;
        }
        else{
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }

    }

    public void register(View view){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}
