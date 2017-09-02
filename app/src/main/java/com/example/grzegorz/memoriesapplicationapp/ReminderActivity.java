package com.example.grzegorz.memoriesapplicationapp;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReminderActivity extends Activity {
    ArrayList<Calendar> calendarList = new ArrayList<>();
    ArrayList<Calendar> calendarsToDisplay = new ArrayList<>();
    ArrayAdapter<Calendar> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        SeekBar seekBar = (SeekBar)findViewById(R.id.reminderSeekBarPriority);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                // TODO Auto-generated method stub
                filterCalendar(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantsValues.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserRetrofitService userService = retrofit.create(UserRetrofitService.class);
        final Call<List<Calendar>> call = userService.getAllReminder(AuthService.getUser().getToken());
        call.enqueue(new retrofit2.Callback<List<Calendar>>() {
            @Override
            public void onResponse(Call<List<Calendar>> call, retrofit2.Response<List<Calendar>> response) {
                if(response.isSuccessful()) {
                    if(response.body() == null){
                        return;
                    }
                    for(int i =0 ; i <response.body().size(); i++){
                        calendarList.add(response.body().get(i));
                    }
                    displayCalendars(0);
                }
                }


            @Override
            public void onFailure(Call<List<Calendar>> call, Throwable t) {
                Toast.makeText(ReminderActivity.this, "you have been logged out", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void displayCalendars(int priority){
        filterCalendar(priority);
        adapter = new ArrayAdapter<Calendar>(
                ReminderActivity.this,
                android.R.layout.simple_list_item_1,
                calendarsToDisplay
        );
        ListView listView = (ListView)findViewById(R.id.reminderList);
        listView.setAdapter(adapter);
    }

    private void filterCalendar(int priority){
        calendarsToDisplay.clear();
        for(Calendar c: calendarList){
            if(c.getPriority() >= priority){
                calendarsToDisplay.add(c);
            }
        }
        if(adapter != null){adapter.notifyDataSetChanged();}
    }

    public void onListItemClick(ListView listView,
                                View itemView,
                                int position,
                                long id){
        Intent intent = new Intent(ReminderActivity.this,ReminderDetails.class);
        intent.putExtra(ConstantsValues.CALENDAR_ID,calendarList.get((int)id).getId());

        startActivity(intent);

    }

}
