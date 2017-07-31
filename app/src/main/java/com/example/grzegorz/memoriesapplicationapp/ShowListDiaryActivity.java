package com.example.grzegorz.memoriesapplicationapp;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ShowListDiaryActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<DiaryPost> adapter = new ArrayAdapter<DiaryPost>(
                this,
                android.R.layout.simple_list_item_1,
                DiaryService.getAllDiary()
        );
        ListView listView = getListView();
        listView.setAdapter(adapter);
    }

    public void onListItemClick(ListView listView,
                                View itemView,
                                int position,
                                long id){
        Intent intent = new Intent(ShowListDiaryActivity.this,ShowDiaryDetailsActivity.class);
        intent.putExtra(ConstantsValues.DIARY_ID,(int)id);

        startActivity(intent);
    }
}
