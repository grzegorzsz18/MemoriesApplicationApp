package com.example.grzegorz.memoriesapplicationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.io.IOException;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginActivity extends AppCompatActivity {

    @Override
    public void onBackPressed(){
    }

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

        final User user = new User();
        user.setPassword(password);
        user.setLogin(login);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsValues.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserRetrofitService userService = retrofit.create(UserRetrofitService.class);
        final Call<User> call = userService.getToken(user);
        call.enqueue(new retrofit2.Callback<User>() {
            @Override
            public void onResponse(Call<User> call, retrofit2.Response<User> response) {
                if(response.isSuccessful()) {
                    if(response.body() != null){
                        User user = new User(response.body().getLogin(),
                                response.body().getName(),
                                response.body().getSurName(),
                                response.body().getPassword(),
                                response.body().getBirthdate(),
                                response.body().getEmail(),
                                response.body().getToken());
                        AuthService.setUser(user);
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        TextView errorTV = (TextView) findViewById(R.id.loginErrorMessageField);
                        errorTV.setText("wrong password");
                    }
                }
                else{
                    TextView errorTV = (TextView) findViewById(R.id.loginErrorMessageField);
                    errorTV.setText("user doesn't exist");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                TextView errorTV = (TextView)findViewById(R.id.loginErrorMessageField);
                errorTV.setText("problem with connection");
            }
        });


    }

    public void register(View view){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }
}
