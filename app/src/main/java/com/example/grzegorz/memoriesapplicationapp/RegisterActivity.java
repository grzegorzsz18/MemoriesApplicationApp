package com.example.grzegorz.memoriesapplicationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Date;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void register(View view) {
        TextView passwordTV = (TextView) findViewById(R.id.registerPassword);
        String password = passwordTV.getText().toString();
        TextView passwordConfTV = (TextView) findViewById(R.id.registerPasswordConfirm);
        String passwordConf = passwordConfTV.getText().toString();
        if (password.equals(passwordConf) == false) {
            TextView errorMessageTV = (TextView) findViewById(R.id.registerErrorMessage);
            errorMessageTV.setText("passwords are differents");
            return;
        } else {
            TextView nameTV = (TextView) findViewById(R.id.registerName);
            TextView sNameTV = (TextView) findViewById(R.id.registerSname);
            TextView loginTV = (TextView) findViewById(R.id.registerLogin);
            TextView emailTV = (TextView) findViewById(R.id.registerEmail);
            String name = nameTV.getText().toString();
            String sName = sNameTV.getText().toString();
            String login = loginTV.getText().toString();
            String email = emailTV.getText().toString();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ConstantsValues.SERVER_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            User user = new User(login, name, sName, password, (new Date((System.currentTimeMillis()))).getTime(), email);
            UserRetrofitService userService = retrofit.create(UserRetrofitService.class);
            final Call<ResponseBody> call = userService.addUser(user);
            call.enqueue(new retrofit2.Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(RegisterActivity.this, "Error", Toast.LENGTH_LONG).show();
                }
            });

        }
    }
}
