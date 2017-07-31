package com.example.grzegorz.memoriesapplicationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDiaryDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_diary_details);
        int diaryId = (Integer)getIntent().getExtras().get(ConstantsValues.DIARY_ID);
        DiaryPost diary = DiaryService.getDiaryById(diaryId);

        TextView title = (TextView)findViewById(R.id.diaryTitle);
        TextView date = (TextView)findViewById(R.id.diaryDate);
        TextView text = (TextView)findViewById(R.id.diaryText);
        title.setText(diary.getTitle());
        date.setText(diary.getTransformedData());
        text.setText(diary.getText());
    }
}
