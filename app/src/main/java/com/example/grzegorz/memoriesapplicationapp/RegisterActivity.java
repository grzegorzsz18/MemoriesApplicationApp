package com.example.grzegorz.memoriesapplicationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void register(View view){
        AuthService authService = new AuthService();
        TextView passwordTV = (TextView)findViewById(R.id.registerPassword);
        String password = passwordTV.getText().toString();
        TextView passwordConfTV = (TextView)findViewById(R.id.registerPasswordConfirm);
        String passwordConf = passwordConfTV.getText().toString();
        if(password.equals(passwordConf) == false){
            TextView errorMessageTV = (TextView)findViewById(R.id.registerErrorMessage);
            errorMessageTV.setText("passwords are differents");
            return;
        }
        else{
            TextView nameTV = (TextView)findViewById(R.id.registerName);
            TextView sNameTV = (TextView)findViewById(R.id.registerSname);
            TextView loginTV = (TextView)findViewById(R.id.registerLogin);
            String name = nameTV.getText().toString();
            String sName = sNameTV.getText().toString();
            String login = loginTV.getText().toString();
            authService.createNewUser(name,sName,login,password);
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        }
    }
}
