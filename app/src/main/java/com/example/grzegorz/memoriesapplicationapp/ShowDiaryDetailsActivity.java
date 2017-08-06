package com.example.grzegorz.memoriesapplicationapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ShowDiaryDetailsActivity extends Activity {

    int diaryId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_diary_details);
        diaryId = (Integer)getIntent().getExtras().get(ConstantsValues.DIARY_ID);
        DiaryPost diary = DiaryService.getDiaryById(diaryId);

        TextView title = (TextView)findViewById(R.id.diaryTitle);
        TextView date = (TextView)findViewById(R.id.diaryDate);
        TextView text = (TextView)findViewById(R.id.diaryText);
        title.setText(diary.getTitle());
        date.setText(diary.getTransformedData());
        text.setText(diary.getText());
    }


    public void removeDiary(View view){
        DiaryService.removeDiaryById(diaryId);
    }
}
